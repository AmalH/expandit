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


    private ArrayList<String> listItemsTitles;
    private HashMap<Integer,ArrayList> listData;
    private ArrayList<Integer> listItemsIcons;
    private MenuBuilder myMenu;

    @SuppressLint({"RestrictedApi", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItemsTitles =  new ArrayList<>(Arrays.asList("Overview","Getting started","Basics","Classes and objects","Functions and lambdas"
        ,"Others","Java Interop","Javascript"));

        listItemsIcons =  new ArrayList<>(Arrays.asList(R.drawable.ic_overview,R.drawable.ic_start,R.drawable.ic_basics,R.drawable.ic_classesobjects
        ,R.drawable.ic_functions,R.drawable.ic_others,R.drawable.ic_java,R.drawable.ic_javascript));

        final ArrayList<String > expandedItems1 =  new ArrayList<>(Arrays.asList("chapter 1", "chapter 2","chapter 2"));
        final ArrayList<String > expandedItems2 =  new ArrayList<>(Arrays.asList("1st chapter", "2nd chapter","3d chapter"));
        listData = new HashMap<Integer,ArrayList>(){
            {
                put(0,expandedItems1);
                put(1,expandedItems2);
                put(2,expandedItems1);
                put(3,expandedItems2);
                put(4,expandedItems1);
                put(5,expandedItems2);
                put(6,expandedItems1);
                put(7,expandedItems2);
            }
        };
        myMenu = new MenuBuilder(getApplicationContext());
        myMenu.add(R.menu.my_menu);

        (findViewById(R.id.defaultUiBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ExpanditList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu)).show();
            }
        });

        (findViewById(R.id.customUiBtn1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ExpanditList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,R.layout.custom_item_details_view)).show();
            }
        });

        (findViewById(R.id.customUiBtn2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ExpanditList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,R.layout.custom_item_details_view2)).show();
            }
        });
    }
}
