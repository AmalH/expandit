package amalhichri.androidprojects.com.techpragmatictheorieslibsexpanditlibrary;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpanditList extends Dialog {

    private ArrayList<String> listItemsTitles=new ArrayList<>();
    private HashMap<Integer, ArrayList> listData= new HashMap<>();
    private ArrayList<Integer> listItemsIcons = new ArrayList<>();
    private MenuBuilder listItemMenu;
    private String title;


    public ExpanditList(Context context){
        super(context);
        this.setContentView(R.layout.expanditlistview);
        //((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(context,listItemsTitles,listData,listItemsIcons,listItemMenu));
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(context));
    }

    /*public ExpanditList(@NonNull Context context,String title,ArrayList<String> listItemsTitles,HashMap<Integer, ArrayList> listData,ArrayList<Integer> listItemsIcons,MenuBuilder listItemMenu) {
        super(context);
        this.listItemsIcons = listItemsIcons;
        this.listData = listData;
        this.listItemsIcons = listItemsIcons;
        this.listItemMenu= listItemMenu;
        this.setContentView(R.layout.expanditlistview);
        ((TextView)findViewById(R.id.listTitle)).setText(title);
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(context,listItemsTitles,listData,listItemsIcons,listItemMenu));
    }

    public ExpanditList(@NonNull Context context,String title,ArrayList<String> listItemsTitles,HashMap<Integer, ArrayList> listData,ArrayList<Integer> listItemsIcons,MenuBuilder listItemMenu,int view) {

        super(context);
        this.listItemsIcons = listItemsIcons;
        this.listData = listData;
        this.listItemsIcons = listItemsIcons;
        this.listItemMenu= listItemMenu;
        this.setContentView(R.layout.expanditlistview);
        ((TextView)findViewById(R.id.listTitle)).setText(title);
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(context,listItemsTitles,listData,listItemsIcons,listItemMenu,view));
    }*/

    public void setListItemMenu(MenuBuilder listItemMenu) {
        this.listItemMenu = listItemMenu;
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listItemMenu));
    }

    public void setListItemsTitles(ArrayList<String> listItemsTitles) {
        this.listItemsTitles = listItemsTitles;
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listItemMenu));
        // ( (BaseExpandableListAdapter)((ExpandableListView)this.findViewById(R.id.expandableLvw)).getExpandableListAdapter()).notifyDataSetChanged();
    }

    public void setListData(HashMap<Integer, ArrayList> listData) {
        this.listData = listData;
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listItemMenu));

    }

    public void setListItemsIcons(ArrayList<Integer> listItemsIcons) {
        this.listItemsIcons = listItemsIcons;
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listItemMenu));
    }

    public void setTitle(String title) {
        this.title = title;
        ((TextView)findViewById(R.id.listTitle)).setText(title);
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listItemMenu));
        //  ( (BaseExpandableListAdapter)((ExpandableListView)this.findViewById(R.id.expandableLvw)).getExpandableListAdapter()).notifyDataSetChanged();
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

    public MenuBuilder getListItemMenu() {
        return listItemMenu;
    }

}
