# Expandit
Expandit is a library for Android that offers a highly customizable expandable listview. You can even customize if "Expandit" can be expanded or not !

## Demo




* ### Sample app
This video showcases how much you can customize expandit ( using different list item description view, showing the list as a dialog or in-activity and more ) :
   <p align="center">
<a href="https://www.youtube.com/watch?v=2GJ8uRUC3uw" target="_blank"><img src="https://raw.githubusercontent.com/AmalH/expandit/master/screenshots/demoThumbail.png"/></a>
   </p>


* ### Screenshots: 
The following section presents a screenshot for
  

## QuickStart

Include Expandit into the build.gradle file:
```Java
implementation 'tech.pragmatictheories.libs.expandit:1.0.0'
```
Using Expandit:
* ### Using Expandit as a dialog
    * Example 1
    ```Java
    ArrayList<String> listItemsTitles =  new ArrayList<>(Arrays.asList("Overview","Getting started","Basics","Classes and objects","Functions and lambdas"
        ,"Others","Java Interop","Javascript"));

    ArrayList<String> defaultListItemsDetails =  new ArrayList<>(Arrays.asList("description of item 1","description of item 2","description of item 3","description of item 4","description of item 5","description of item 6","description of item 7","description of item 8"));

    ArrayList<Integer> listItemsIcons =  new ArrayList< (Arrays.asList(R.drawable.ic_overview,R.drawable.ic_start,R.drawable.ic_basics,R.drawable.ic_classesobjects,R.drawable.ic_functions,R.drawable.ic_others,R.drawable.ic_java,R.drawable.ic_javascript));
        
    ArrayList<String > expandedItems1 =  new ArrayList<>(Arrays.asList("chapter 1", "chapter 2","chapter 2"));
    ArrayList<String > expandedItems2 =  new ArrayList<>(Arrays.asList("1st chapter", "2nd chapter","3d chapter"));
    HashMap<Integer,ArrayList> listData = new HashMap<Integer,ArrayList>(){
            {
                put(0,expandedItems1);
                put(1,expandedItems2);
                put(2,expandedItems3);
                put(3,expandedItems4);
                put(4,expandedItems5);
                put(5,expandedItems6);
                put(6,expandedItems7);
                put(7,expandedItems8);
            }
        };
        
    new ExpanditDialogList(MainActivity.this,"Kotlin       courseslist",listItemsTitles,listData,listItemsIcons,listMenuId,defaultListItemsDetails)).show()
    
    ```
    //screenshot
    
     * Example 2
    ```Java
    ExpanditDialogList myList = new ExpanditDialogList(MainActivity.this);
    myList.setTitle("Non-expandable!");
    myList.setListItemsTitles(listItemsTitles);
    myList.setListItemsIcons(listItemsIcons);
    //myList.setListItemMenu(defaultListMenu);
    myList.show();
    ```
    //screenshot
    
    * Example 3
    ```Java
    new ExpanditDialogList(MainActivity.this,"custom item details2",listItemsTitles2,listData,listItemsIcons2,listMenuId,R.layout.custom_item_details_view2)).show()
    ```
    //screenshot
   
* ### Using Expandit as a list (in-activity)
    * Example 1
    ```Java
    addView(new ExpanditActivityList(MainActivity.this,"Kotlin courseslist",listItemsTitles,listData,listItemsIcons,listMenuId,defaultListItemsDetails));
    .
    OR
    .
    (findViewById(R.id.myList)).setAdapter(new ExpanditListAdapter(context,listItemsTitles,listData,listItemsIcons,listMenuId,defaultListItemsDetails))
    ```
     //screenshot
    
    * Example 2
    ```Java
    addView(new ExpanditActivityList(MainActivity.this,"custom item details 1",listItemsTitles,listData,listItemsIcons,listMenuId,R.layout.custom_item_details_view));
    .
    OR
    .
    (findViewById(R.id.myList)).setAdapter(new ExpanditListAdapter(context,listItemsTitles,listData,listItemsIcons,listMenuId,customDetailsView))
    ```
    
     //screenshot

## Getting help
If you spot a problem you can open an issue here, or alternatively, you can tweet me at  [@AmalHichrii](http://twitter.com/AmalHichrii).
