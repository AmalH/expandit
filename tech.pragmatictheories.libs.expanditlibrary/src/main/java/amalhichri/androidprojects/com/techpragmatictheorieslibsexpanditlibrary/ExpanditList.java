package amalhichri.androidprojects.com.techpragmatictheorieslibsexpanditlibrary;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuBuilder;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpanditList extends Dialog {

    private ArrayList<String> listItemsTitles=new ArrayList<>();
    private HashMap<Integer, ArrayList> listData= new HashMap<>();
    private ArrayList<Integer> listItemsIcons = new ArrayList<>();
    private MenuBuilder listItemMenu;

    public ExpanditList(@NonNull Context context,ArrayList<String> listItemsTitles,HashMap<Integer, ArrayList> listData,ArrayList<Integer> listItemsIcons,MenuBuilder listItemMenu) {

        super(context);
        this.listItemsIcons = listItemsIcons;
        this.listData = listData;
        this.listItemsIcons = listItemsIcons;
        this.listItemMenu= listItemMenu;
        this.setContentView(R.layout.expanditlistview);
        ((ExpandableListView)this.findViewById(R.id.expandableLvw)).setAdapter(new ExpanditListAdapter(context,listItemsTitles,listData,listItemsIcons,listItemMenu));
    }
}
