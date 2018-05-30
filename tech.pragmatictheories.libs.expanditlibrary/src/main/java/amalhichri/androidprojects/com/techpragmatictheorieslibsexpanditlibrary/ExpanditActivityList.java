package amalhichri.androidprojects.com.techpragmatictheorieslibsexpanditlibrary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpanditActivityList extends ExpandableListView {

    private ArrayList<String> listItemsTitles=new ArrayList<>();
    private HashMap<Integer, ArrayList> listData= new HashMap<>();
    private ArrayList<Integer> listItemsIcons = new ArrayList<>();
    private ArrayList<String> defaultListItemsDetails = new ArrayList<>();
    private int listMenuId;
    private String title;
    private int customDetailsView;
    private View headerView;

    public ExpanditActivityList(Context context) {
        super(context);
        headerView = LayoutInflater.from(context).inflate(R.layout.activitylist_header,null);
        this.setAdapter(new ExpanditListAdapter(context));
    }


    public ExpanditActivityList(@NonNull Context context, String title, ArrayList<String> listItemsTitles, HashMap<Integer, ArrayList> listData, ArrayList<Integer> listItemsIcons, int listMenuId, int customDetailsView) {

        super(context);
        this.listItemsIcons = listItemsIcons;
        this.listData = listData;
        this.listItemsIcons = listItemsIcons;
        this.listMenuId= listMenuId;
        this.customDetailsView= customDetailsView;
        this.headerView = LayoutInflater.from(context).inflate(R.layout.activitylist_header,null);
        ((TextView)this.headerView.findViewById(R.id.listHeader)).setText(title);
        this.setHeaderDividersEnabled(false);
        this.addHeaderView(headerView);
        this.setAdapter(new ExpanditListAdapter(context,listItemsTitles,listData,listItemsIcons,listMenuId,customDetailsView));
    }

    public ExpanditActivityList(@NonNull Context context, String title, ArrayList<String> listItemsTitles, HashMap<Integer, ArrayList> listData, ArrayList<Integer> listItemsIcons, int listMenuId, ArrayList<String> defaultListItemsDetails) {

        super(context);
        this.listItemsIcons = listItemsIcons;
        this.listData = listData;
        this.listItemsIcons = listItemsIcons;
        this.listMenuId= listMenuId;
        this.defaultListItemsDetails= defaultListItemsDetails;
        this.headerView = LayoutInflater.from(context).inflate(R.layout.activitylist_header,null);
        ((TextView)headerView.findViewById(R.id.listHeader)).setText(title);
        this.setHeaderDividersEnabled(false);
        this.addHeaderView(headerView);
        this.setAdapter(new ExpanditListAdapter(context,listItemsTitles,listData,listItemsIcons,listMenuId,defaultListItemsDetails));
    }


    public void setListItemMenu(int listMenuId) {
        this.listMenuId = listMenuId;
        this.setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listMenuId,0));
    }

    public void setListItemsTitles(ArrayList<String> listItemsTitles) {
        this.listItemsTitles = listItemsTitles;
        this.setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listMenuId,0));
    }

    public void setListData(HashMap<Integer, ArrayList> listData) {
        this.listData = listData;
        this.setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listMenuId,0));

    }

    public void setListItemsIcons(ArrayList<Integer> listItemsIcons) {
        this.listItemsIcons = listItemsIcons;
         this.setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listMenuId,0));
    }

    public void setTitle(String title) {
        this.title = title;
        ((TextView)this.headerView.findViewById(R.id.listHeader)).setText(title);
        this.setHeaderDividersEnabled(false);
        this.addHeaderView(headerView);
        this.setAdapter(new ExpanditListAdapter(getContext(),listItemsTitles,listData,listItemsIcons,listMenuId,0));
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

    public int getListItemMenu() {
        return listMenuId;
    }

}