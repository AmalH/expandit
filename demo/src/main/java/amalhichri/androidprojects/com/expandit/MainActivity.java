package amalhichri.androidprojects.com.expandit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import amalhichri.androidprojects.com.techpragmatictheorieslibsexpanditlibrary.ExpanditList;

public class MainActivity extends Activity {


    private ArrayList<String> listItemsTitles=new ArrayList<>();
    private HashMap<Integer,ArrayList> listData= new HashMap<>();
    private ArrayList<Integer> listItemsIcons = new ArrayList<>();
    private MenuBuilder myMenu;

    @SuppressLint({"RestrictedApi", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItemsTitles.add("Item 1");
        listItemsTitles.add("Item 2");
        listItemsTitles.add("Item 3");

        ArrayList<String > expandedItems1 =  new ArrayList<>(Arrays.asList("xyz", "abc","ijkd"));

        listItemsIcons.add(R.drawable.ic_java);
        listItemsIcons.add(R.drawable.ic_javascript);
        listItemsIcons.add(R.drawable.ic_javascript);

        listData.put(0,expandedItems1);
        listData.put(1,expandedItems1);
        listData.put(2,expandedItems1);

        myMenu = new MenuBuilder(getApplicationContext());
        myMenu.add(R.menu.my_menu);


        (findViewById(R.id.testBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ExpanditList(MainActivity.this,listItemsTitles,listData,listItemsIcons,myMenu)).show();
            }
        });
    }
}
