package amalhichri.androidprojects.com.techpragmatictheorieslibsexpanditlibrary;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
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
    private MenuBuilder listItemMenu;


    public ExpanditListAdapter(Context context, List listItemsTitles, HashMap<Integer, ArrayList> listData, ArrayList<Integer> listItemsIcons,MenuBuilder listItemMenu) {
        this.context = context;
        this.listItemsTitles = listItemsTitles;
        this.listData= listData;
        this.listItemsIcons= listItemsIcons;
        this.listItemMenu= listItemMenu;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
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
        return this.listData.get(this.listItemsTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listItemsTitles.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listItemsTitles.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String title = (String) getGroup(groupPosition);
        final int  courseIcon = listItemsIcons.get(groupPosition);

        if (convertView == null)
            convertView = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_item, null);
        ((TextView) convertView.findViewById(R.id.listTitle_text)).setText(title);
        ((ImageView)convertView.findViewById(R.id.itemIcon)).setImageResource(courseIcon);
        ((ListItemView) convertView. findViewById(R.id.listItemMenu)).setMenu(listItemMenu);
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