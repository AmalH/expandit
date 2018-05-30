package amalhichri.androidprojects.com.techpragmatictheorieslibsexpanditlibrary;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpanditDialogList extends Dialog {

    private ArrayList<String> listItemsTitles=new ArrayList<>();
    private HashMap<Integer, ArrayList> listData= new HashMap<>();
    private ArrayList<Integer> listItemsIcons = new ArrayList<>();
    private ArrayList<String> defaultListItemsDetails = new ArrayList<>();
    private int listMenuId;
    private String title;
    private int customDetailsView;

    public ExpanditDialogList(Context context){
        super(context);
        this.setContentView(R.layout.expanditlistview);
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(context));
    }

    public ExpanditDialogList(@NonNull Context context, String title, ArrayList<String> listItemsTitles, HashMap<Integer, ArrayList> listData, ArrayList<Integer> listItemsIcons, int listMenuId, int customDetailsView) {

        super(context);
        this.listItemsIcons = listItemsIcons;
        this.listData = listData;
        this.listItemsIcons = listItemsIcons;
        this.listMenuId= listMenuId;
        this.customDetailsView= customDetailsView;
        this.setContentView(R.layout.expanditlistview);
        ((TextView)findViewById(R.id.listHeader)).setText(title);
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(context,listItemsTitles,listData,listItemsIcons,listMenuId,customDetailsView));
    }

    public ExpanditDialogList(@NonNull Context context, String title, ArrayList<String> listItemsTitles, HashMap<Integer, ArrayList> listData, ArrayList<Integer> listItemsIcons,int listMenuId, ArrayList<String> defaultListItemsDetails) {

        super(context);
        this.listItemsIcons = listItemsIcons;
        this.listData = listData;
        this.listItemsIcons = listItemsIcons;
        this.listMenuId= listMenuId;
        this.defaultListItemsDetails= defaultListItemsDetails;
        this.setContentView(R.layout.expanditlistview);
        ((TextView)findViewById(R.id.listHeader)).setText(title);
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(context,listItemsTitles,listData,listItemsIcons,listMenuId,defaultListItemsDetails));
    }


    public void setListItemMenu(int listMenuId) {
        this.listMenuId = listMenuId;
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listMenuId,0));
    }

    public void setListItemsTitles(ArrayList<String> listItemsTitles) {
        this.listItemsTitles = listItemsTitles;
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listMenuId,0));
    }

    public void setListData(HashMap<Integer, ArrayList> listData) {
        this.listData = listData;
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listMenuId,0));

    }

    public void setListItemsIcons(ArrayList<Integer> listItemsIcons) {
        this.listItemsIcons = listItemsIcons;
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listMenuId,0));
    }

    public void setTitle(String title) {
        this.title = title;
        ((TextView)findViewById(R.id.listHeader)).setText(title);
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listMenuId,0));
}

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getListItemsTitles() {
        return listItemsTitles;
    }

    public HashMap<Integer, ArrayList> getListData() {
        return listData;
    }

    public ArrayList<Integer> getListItemsIcons() {
        return listItemsIcons;
    }

    public int  getListItemMenu() {
        return listMenuId;
    }

}
