package amalhichri.androidprojects.com.expandit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
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
    private ArrayList<Integer> listItemsIcons,listItemsIcons2;
    private ArrayList<String > expandedItems1,expandedItems2;
    private int listMenuId;
    private static boolean isDialog=true;
    private Animation fadeIn;
    private AnimationSet animation;

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

        listItemsIcons2 =  new ArrayList<>(Arrays.asList(R.drawable.ic_movie1,R.drawable.ic_movie2,R.drawable.ic_movie1,R.drawable.ic_movie2
                ,R.drawable.ic_movie1,R.drawable.ic_movie2,R.drawable.ic_movie1,R.drawable.ic_movie2));

        expandedItems1 =  new ArrayList<>(Arrays.asList("chapter 1", "chapter 2","chapter 2"));
        expandedItems2 =  new ArrayList<>(Arrays.asList("1st chapter", "2nd chapter","3d chapter"));
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

        listMenuId = R.menu.my_menu;

        fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(2000);
        animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeIn);
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
                    (new ExpanditDialogList(MainActivity.this,"Kotlin courses list",listItemsTitles,listData,listItemsIcons,listMenuId,defaultListItemsDetails)).show();
                if (!isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.GONE);
                    ((LinearLayout)findViewById(R.id.expanditLvwContainer)).addView(new ExpanditActivityList(MainActivity.this,"Kotlin courses list",listItemsTitles,listData,listItemsIcons,listMenuId,defaultListItemsDetails));
                    (findViewById(R.id.backToMainBtn)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.expanditLvwContainer)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.backToMainBtn)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.expanditLvwContainer)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.backToMainBtn)).setAnimation(animation);
                    (findViewById(R.id.expanditLvwContainer)).setAnimation(animation);
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
                    myList.setTitle("Non-expandable!");
                    myList.setListItemsTitles(listItemsTitles);
                    myList.setListItemsIcons(listItemsIcons);
                    //myList.setListData(listData);
                    //myList.setListItemMenu(defaultListMenu);
                    myList.show();
               /* Log.d("AAA ","A "+myList.getListData().get(1).toString());
                Log.d("Titles ",myList.getListItemsTitles().toString());
                Log.d("Icons ",myList.getListItemsIcons().toString());
                Log.d("Title ",myList.getTitle());*/
                }
                if (!isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.GONE);
                    ExpanditActivityList myList = new ExpanditActivityList(MainActivity.this);
                    myList.setListItemsTitles(listItemsTitles);
                    myList.setListItemsIcons(listItemsIcons);
                    myList.setTitle("Unexpandable..");
                    //myList.setListData(listData);
                    //myList.setListItemMenu(defaultListMenu);
                    ((LinearLayout)findViewById(R.id.expanditLvwContainer)).addView(myList);
                    (findViewById(R.id.backToMainBtn)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.expanditLvwContainer)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.backToMainBtn)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.expanditLvwContainer)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.backToMainBtn)).setAnimation(animation);
                    (findViewById(R.id.expanditLvwContainer)).setAnimation(animation);
                }

            }
        });

        /**-------------------------------------- custom details 1------------------------------------**/
        (findViewById(R.id.customUiBtn1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.VISIBLE);
                    (new ExpanditDialogList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons,listMenuId,R.layout.custom_item_details_view)).show();
                }
                if (!isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.GONE);
                    ((LinearLayout)findViewById(R.id.expanditLvwContainer)).addView(new ExpanditActivityList(MainActivity.this,"custom item details 1",listItemsTitles,listData,listItemsIcons,listMenuId,R.layout.custom_item_details_view));
                    (findViewById(R.id.backToMainBtn)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.expanditLvwContainer)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.backToMainBtn)).setAnimation(animation);
                    (findViewById(R.id.expanditLvwContainer)).setAnimation(animation);
                }
            }
        });

        /**-------------------------------------- custom details 2 ------------------------------------**/
        (findViewById(R.id.customUiBtn2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.VISIBLE);
                    (new ExpanditDialogList(MainActivity.this,"Test list",listItemsTitles,listData,listItemsIcons2,listMenuId,R.layout.custom_item_details_view2)).show();
                }
                if (!isDialog){
                    (findViewById(R.id.btnsContainer)).setVisibility(View.GONE);
                    ((LinearLayout)findViewById(R.id.expanditLvwContainer)).addView(new ExpanditActivityList(MainActivity.this,"custom item details 2",listItemsTitles,listData,listItemsIcons2,listMenuId,R.layout.custom_item_details_view2));
                    (findViewById(R.id.backToMainBtn)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.expanditLvwContainer)).setVisibility(View.VISIBLE);
                    (findViewById(R.id.backToMainBtn)).setAnimation(animation);
                    (findViewById(R.id.expanditLvwContainer)).setAnimation(animation);
                }
            }
        });

        /**-------------------------------------- back button ------------------------------------**/
        (findViewById(R.id.backToMainBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (findViewById(R.id.btnsContainer)).setVisibility(View.VISIBLE);
                (findViewById(R.id.btnsContainer)).setAnimation(animation);
                ((LinearLayout)findViewById(R.id.expanditLvwContainer)).removeAllViews();
                (findViewById(R.id.expanditLvwContainer)).setVisibility(View.GONE);
                (findViewById(R.id.backToMainBtn)).setVisibility(View.GONE);
            }
        });

}
}
