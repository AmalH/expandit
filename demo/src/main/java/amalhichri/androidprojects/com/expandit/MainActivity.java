package amalhichri.androidprojects.com.expandit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import amalhichri.androidprojects.com.techpragmatictheorieslibsexpanditlibrary.ExpanditActivityList;
import amalhichri.androidprojects.com.techpragmatictheorieslibsexpanditlibrary.ExpanditDialogList;

public class MainActivity extends Activity {


    private ArrayList<String> listItemsTitles,defaultListItemsDetails;
    private HashMap<Integer,ArrayList> listData;
    private ArrayList<Integer> listItemsIcons;
    private MenuBuilder myMenu;
    private static boolean isDialog=true;

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
        myMenu.add(R.string.menuitem2);


        /**-------------------------------------- list type  ------------------------------------**/

        ((RadioButton)findViewById(R.id.listAsDialogChkbx)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    isDialog=true;
                if(!isChecked)
                    isDialog=false;
                    }
        });

        ((RadioButton)findViewById(R.id.listAsActivtyChkbx)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    isDialog=false;
                if(!isChecked)
                    isDialog=true;
            }
        });
        /**-------------------------------------- default list  ------------------------------------**/
        (findViewById(R.id.defaultUiBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDialog)
                    (new ExpanditDialogList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,defaultListItemsDetails)).show();
                if (!isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.GONE);
                    ((LinearLayout)findViewById(R.id.expanditLvwContainer)).addView(new ExpanditActivityList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,defaultListItemsDetails));
                    (findViewById(R.id.backToMainBtn)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.expanditLvwContainer)).setVisibility(View.VISIBLE);
                }

            }
        });

        /**-------------------------------------- custom list 1 ------------------------------------**/
        (findViewById(R.id.customUiBtn0)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.VISIBLE);
                    ExpanditDialogList myList = new ExpanditDialogList(MainActivity.this);
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
                if (!isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.GONE);
                    ((LinearLayout)findViewById(R.id.expanditLvwContainer)).addView(new ExpanditActivityList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,defaultListItemsDetails));
                    (findViewById(R.id.backToMainBtn)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.expanditLvwContainer)).setVisibility(View.VISIBLE);
                }

            }
        });

        /**-------------------------------------- custom details 1------------------------------------**/
        (findViewById(R.id.customUiBtn1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.VISIBLE);
                    (new ExpanditDialogList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,R.layout.custom_item_details_view)).show();
                }
                if (!isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.GONE);
                    ((LinearLayout)findViewById(R.id.expanditLvwContainer)).addView(new ExpanditActivityList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,R.layout.custom_item_details_view));
                    (findViewById(R.id.backToMainBtn)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.expanditLvwContainer)).setVisibility(View.VISIBLE);
                }
            }
        });

        /**-------------------------------------- custom details 2 ------------------------------------**/
        (findViewById(R.id.customUiBtn2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.VISIBLE);
                    (new ExpanditDialogList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,R.layout.custom_item_details_view2)).show();
                }
                if (!isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.GONE);
                    ((LinearLayout)findViewById(R.id.expanditLvwContainer)).addView(new ExpanditActivityList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,myMenu,R.layout.custom_item_details_view2));
                    (findViewById(R.id.backToMainBtn)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.expanditLvwContainer)).setVisibility(View.VISIBLE);
                }
            }
        });


        /**-------------------------------------- back button ------------------------------------**/
        (findViewById(R.id.backToMainBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (findViewById(R.id.btnsContainer)).setVisibility(View.VISIBLE);
                (findViewById(R.id.expanditLvwContainer)).setVisibility(View.GONE);
                (findViewById(R.id.backToMainBtn)).setVisibility(View.GONE);
            }
        });

}

}
