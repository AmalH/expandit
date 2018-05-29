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


    private ArrayList<String> listItemsTitles,defaultListItemsDetails;
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

        defaultListItemsDetails =  new ArrayList<>(Arrays.asList("description of item 1","description of item 2","description of item 3","description of item 4","description of item 5"
                ,"description of item 6","description of item 7","description of item 8"));

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
        myMenu.add(R.string.menuitem1);
        myMenu.add(R.string.menuitem1);

        /**-------------------------------------- default list  ------------------------------------**/
        (findViewById(R.id.defaultUiBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ExpanditList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,defaultListItemsDetails)).show();
            }
        });

        /**-------------------------------------- custom list 1 ------------------------------------**/
        (findViewById(R.id.customUiBtn0)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExpanditList myList = new ExpanditList(MainActivity.this);
                myList.setTitle("Test A");
                myList.setListItemsTitles(listItemsTitles);
                myList.setListItemsIcons(listItemsIcons);
                //myList.setListData(listData);
                //myList.setListItemMenu(myMenu);
                myList.show();
               /* Log.d("AAA ","A "+myList.getListData().get(1).toString());
                Log.d("Titles ",myList.getListItemsTitles().toString());
                Log.d("Icons ",myList.getListItemsIcons().toString());
                Log.d("Title ",myList.getTitle());*/
            }
        });

        /**-------------------------------------- custom details 1------------------------------------**/
        (findViewById(R.id.customUiBtn1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ExpanditList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,R.layout.custom_item_details_view)).show();
            }
        });

        /**-------------------------------------- custom details 2 ------------------------------------**/
        (findViewById(R.id.customUiBtn2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ExpanditList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,R.layout.custom_item_details_view2)).show();
            }
        });
    }

}
