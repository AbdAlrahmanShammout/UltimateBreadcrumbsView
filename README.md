# UltimateBreadcrumbsView
UltimaleBreadcrumbView is a customized Breadcrumbs with many added flexible features that gives you control over your content path that you can use to navigate easily through your application,
<br>If you have any question or suggestion with this library , You are Welcome !



## Demo
| Gif|picture|
|:-------------:|:-----:|
|![](https://github.com/AbdAlrahmanShammout/UltimateBreadcrumbsView/blob/master/UltimateBreadcrumbsView%20image/RBCs%20App%20Demo.gif)|![](https://github.com/AbdAlrahmanShammout/UltimateBreadcrumbsView/blob/master/UltimateBreadcrumbsView%20image/demo%20style.gif)|


## component UltimateBreadcrumbsView
![](https://github.com/AbdAlrahmanShammout/UltimateBreadcrumbsView/blob/master/UltimateBreadcrumbsView%20image/component%20UltimateBreadcrumbsView.jpg)
### Consists of three 3️⃣ basic parts.

**1- PathItemStyle.**

| method|description|parameter type|
| ------------- |:-------------:| :-----|
|`setPathItemBackgroundResId()`|the background of the path item Of type **resource**| ```@DrawableRes int```|
|`setPathItemBackgroundColor()`|the background of the path item Of type **Color**| ```@ColorInt int```|
|`setPathItemBackgroundDrawable()`|the background of the path item Of type **Drawable**| ```Drawable```|
|`setActivePathItemBackgroundResId()`|the background of the **Active** path item Of type **resource**|  ```@DrawableRes int```|
|`setActivePathItemBackgroundColor()`|the background of the **Active** path item Of type **Color**|  ```@ColorInt int```|
|`setActivePathItemBackgroundDrawable()`|the background of the **Active** path item Of type **Drawable**| ```Drawable```|
|`setPathItemTextColor()`|the color of the path item text| ```@ColorInt int```|
|`setActivePathItemTextColor()`|the color of the **Active** path item text| ```@ColorInt int```|

**2- PathItem.**

| method|description|parameter type|
| ------------- |:-------------:| :-----|
|`constructor()`|two parameters title and id (optional)| ```String, int (optional)```|
|`setPathItemStyle()`|allows you to choose a specific style for this item and second parameter ask to use a specific Style In Active status also| ```PathItemStyle, boolean useStyleAlsoInActive```|
> an **id** field is used in the **constructor** to store a given id, for example, to save category id

**3- UltimateBreadcrumbsView.**

| method|description|parameter type|
| ------------- |:-------------:| :-----|
|`setPathItemStyle()`|add a style to **All** path item| ```@DrawableRes int```|
|`setBackButtonBackgroundRes()`|the background of the Back Button Of type **resource**| ```@DrawableRes int```|
|`setBackButtonBackgroundColor()`|the background of the Back Button Of type **Color**| ```@ColorInt int```|
|`setBackButtonBackgroundDrawable()`|the background of the Back Button Of type **Drawable**| ```Drawable```|
|`setBackButtonIconRes()`|the icon of the Back Button Of type **resource**| ```@DrawableRes int```|
|`setBackButtonIconDrawable()`|the icon of the Back Button Of type **Drawable**| ```Drawable```|
|`setBackButtonIconBitmap()`|the icon of the Back Button Of type **Bitmap**| ```Bitmap```|
|`setOnClickListenerBreadcrumbs()`|the Listener of the ```onBackClick, onPathItemClick, onPathItemLongClick ```| ```OnClickListenerBreadcrumbs```|
|`addToPath()`|To add an item to the UltimateBreadcrumbsView| ```PathItem, int position (optional)```|
|`back()`|To remove item from UltimateBreadcrumbsView|no parameter|
|`backTo()`|to remove all item from UltimateBreadcrumbsView **to specific position**|```int position```|
|`getItemCount()`|to get items count inn ultimatebreadcrumbsview|no parameter|






## Usage
### Step 1
Add dependencies in build.gradle.
<pre>
    dependencies {
       implementation 'com.abdshammout.UBV:library:1.0.2'
    }
</pre>

### Step 2
Add the UltimateBreadcrumbsView to your layout:
<br>
<br>Simple
<br>

```xml
<com.abdshammout.UBV.UltimateBreadcrumbsView
        android:id="@+id/ultimateBreadcrumbsView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
</com.abdshammout.UBV.UltimateBreadcrumbsView>
```
Advance

```xml
<com.abdshammout.UBV.UltimateBreadcrumbsView
        android:id="@+id/ultimateBreadcrumbsView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:pathItemBackground="@drawable/bg_two_corner"
        app:pathItemTextColor="@android:color/white"
        app:activePathItemBackground="@drawable/bg_two_corner_active"
        app:activePathItemTextColor="@android:color/black"
        app:backButtonBackground="@drawable/bg_two_corner"
        app:backButtonIcon="@drawable/icon">
</com.abdshammout.UBV.UltimateBreadcrumbsView>
```
Or init in code

```java
ultimateBreadcrumbsView = findViewById(R.id.ultimateBreadcrumbsView);

PathItemStyle pathItemStyle = new PathItemStyle();
pathItemStyle.setPathItemBackgroundResId(R.drawable.bg_two_corner);
pathItemStyle.setActivePathItemBackgroundResId(R.drawable.bg_two_corner_active);

pathItemStyle.setPathItemTextColor(getResources().getColor(android.R.color.white));//or Color.WHITE
pathItemStyle.setActivePathItemTextColor(Color.BLACK);

ultimateBreadcrumbsView.setPathItemStyle(pathItemStyle);

ultimateBreadcrumbsView.setBackButtonBackgroundRes(R.drawable.bg_two_corner);
ultimateBreadcrumbsView.setBackButtonIconRes(android.R.drawable.ic_delete);
```

### Step 3
It's very simple to use.

```java
ultimateBreadcrumbsView.setOnClickListenerBreadcrumbs(new OnClickListenerBreadcrumbs() {
    @Override
    public void onBackClick() {
        Toast.makeText(SecondSampleActivity.this,
                "onBackClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPathItemClick(int index, String title, int id) {
        Toast.makeText(SecondSampleActivity.this,
                index+"  onPathItemClick = "+title, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPathItemLongClick(int index, String title, int id) {
        Toast.makeText(SecondSampleActivity.this,
                index+"  onPathItemLongClick = "+title, Toast.LENGTH_SHORT).show();
    }
});
```
### Final Step 4
**Very important:** The line must be added after the above instructions have been implemented (Must be the last instruction)
<br/>
**(please do not forget this)**
```java
//....
//....
//the codes mentioned above

ultimateBreadcrumbsView.initUltimateBreadcrumbsView();
```
***
### how to add/remove items

```java
//create PathItem
//add just title
PathItem pathItem = new PathItem("title");
//or add title and id
PathItem pathItem = new PathItem("title", 9);

//Add item
ultimateBreadcrumbsView.addToPath(pathItem);

//Added in custom position
ultimateBreadcrumbsView.addToPath(pathItem, 10);

//Remove item
ultimateBreadcrumbsView.back();

//Remove all item to specific position
ultimateBreadcrumbsView.backTo(3);

```

## custom style for special path item
```java
//create new PathItemStyle and set attr
PathItemStyle pathItemStyle = new PathItemStyle();
pathItemStyle.setPathItemBackgroundColor(Color.RED);
pathItemStyle.setActivePathItemBackgroundColor(Color.
pathItemStyle.setPathItemTextColor(Color.GREEN);
pathItemStyle.setActivePathItemTextColor(Color.YELLOW

//create new PathItem
PathItem pathItem = new PathItem("title");
//set special style 
pathItem.setPathItemStyle(pathItemStyle, false);//The second parameter boolean for use Style Also In Active
//add to ultimateBreadcrumbsView
ultimateBreadcrumbsView.addToPath(pathItem);
```

# Contact me:
if You have any thoughts or ideas, please let me know, thanks :)
<br/>
[Email](abdshammout.97@gmail.com)
<br/>
[Facebook](https://www.facebook.com/abdshammout.1997)

## contributors
- Linguist Checking : Thanks To [Cloud-22](https://github.com/Cloud-22)

# License

```text
Copyright 2019 Abd Alrahman Shammout
    for the lights in our lives ☀

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

