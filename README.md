# UltimateBreadcrumbsView
UltimaleBreadcrumbView is a customized Breadcrumbs with many added flexible features that gives you control over your content path that you can use to navigate easily through your application,
<br>If you have any question or suggestion with this library , welcome to tell me !

## Demo


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
how to add/remove item
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

```

### Step 4
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

# Contact me
If you have a better idea or way on this project, please let me know, thanks :)
<br/>
[Email](abdshammout.97@gmail.com)
<br/>
[Facebook](https://www.facebook.com/abdshammout.1997)

# License

```text
Copyright 2019 Abd Alrahman Shammout

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

