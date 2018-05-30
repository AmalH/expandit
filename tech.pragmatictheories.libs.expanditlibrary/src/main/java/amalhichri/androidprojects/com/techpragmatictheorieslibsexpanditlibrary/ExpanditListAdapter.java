package amalhichri.androidprojects.com.techpragmatictheorieslibsexpanditlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lucasurbas.listitemview.ListItemView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ExpanditListAdapter extends BaseExpandableListAdapter {

    private Context context;

    private List listItemsTitles;
    private HashMap<Integer, ArrayList> listData;
    private ArrayList<Integer> listItemsIcons;
    private ArrayList<String> defaultListItemsDetails;
    private int listMenuId;
    private int customItemDetailsView=0;
    private int  itemIcon;

    public ExpanditListAdapter(Context context){
        this.context = context;
    }


    public ExpanditListAdapter(Context context,List listItemsTitles, HashMap<Integer, ArrayList> listData, ArrayList<Integer> listItemsIcons,int listMenuId,int customItemDetailsView) {
        this.context = context;
        this.listItemsTitles = listItemsTitles;
        this.listData= listData;
        this.listItemsIcons= listItemsIcons;
        this.listMenuId = listMenuId;
        this.customItemDetailsView = customItemDetailsView;
    }

    public ExpanditListAdapter(Context context,List listItemsTitles, HashMap<Integer, ArrayList> listData, ArrayList<Integer> listItemsIcons,int listMenuId,ArrayList<String> defadefaultListItemsDetails) {
        this.context = context;
        this.listItemsTitles = listItemsTitles;
        this.listData= listData;
        this.listItemsIcons= listItemsIcons;
        this.listMenuId = listMenuId;
        this.defaultListItemsDetails = defadefaultListItemsDetails;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if(listData.size()==0)
            return 0;
        else
            return this.listData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null)
            convertView = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_item_expanded, null);
        ((TextView) convertView.findViewById(R.id.listItem_text)).setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        if(this.listData.size()==0)
            return 0;
        else
            return this.listData.get(groupPosition).size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listItemsTitles.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        if(this.listItemsTitles==null)
            return 0;
        else
            return this.listItemsTitles.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String title = (String) getGroup(groupPosition);
        if(listItemsIcons.size()>0)
            itemIcon = listItemsIcons.get(groupPosition);

        if (convertView == null && customItemDetailsView==0){
                convertView = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_item, null);
                ((TextView) convertView.findViewById(R.id.listTitle_text)).setText(title);
                if (defaultListItemsDetails!=null)
                    ((TextView) convertView.findViewById(R.id.itemDetails)).setText(defaultListItemsDetails.get(groupPosition));
                ((ImageView)convertView.findViewById(R.id.itemIcon)).setImageResource(itemIcon);
                if(listMenuId!=0)
                    ((ListItemView) convertView. findViewById(R.id.listItemMenu)).inflateMenu(listMenuId);
            }
            else if(convertView == null && customItemDetailsView!=0){
                convertView = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_item, null);
                ((TextView) convertView.findViewById(R.id.listTitle_text)).setText(title);
                (convertView.findViewById(R.id.itemDetails)).setVisibility(View.GONE);
                View viewToAdd = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(customItemDetailsView, null);
                if(viewToAdd.getParent()!=null)
                    ((ViewGroup)viewToAdd.getParent()).removeView(viewToAdd);
                ((LinearLayout)convertView.findViewById(R.id.itemDetailsContainer)).addView(viewToAdd);
                ((ImageView)convertView.findViewById(R.id.itemIcon)).setImageResource(itemIcon);
                ((ListItemView) convertView. findViewById(R.id.listItemMenu)).inflateMenu(listMenuId);
            }
        return convertView;
        }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}