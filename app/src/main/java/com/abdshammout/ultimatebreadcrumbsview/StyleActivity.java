package com.abdshammout.ultimatebreadcrumbsview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abdshammout.UBV.UltimateBreadcrumbsView;
import com.abdshammout.UBV.model.PathItem;
import com.abdshammout.UBV.model.PathItemStyle;

public class StyleActivity extends AppCompatActivity {

    UltimateBreadcrumbsView ultimateBreadcrumbsView1;
    UltimateBreadcrumbsView ultimateBreadcrumbsView2;
    UltimateBreadcrumbsView ultimateBreadcrumbsView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        ultimateBreadcrumbsView1 = findViewById(R.id.ultimateBreadcrumbsView1);
        ultimateBreadcrumbsView2 = findViewById(R.id.ultimateBreadcrumbsView2);
        ultimateBreadcrumbsView3 = findViewById(R.id.ultimateBreadcrumbsView3);

        ultimateBreadcrumbsView1.initUltimateBreadcrumbsView();
        for (int i = 0; i < 5; i++) {
            ultimateBreadcrumbsView1.addToPath(new PathItem("title "+i));
        }



        ultimateBreadcrumbsView2.initUltimateBreadcrumbsView();
        for (int i = 0; i < 5; i++) {
            PathItem pathItem = new PathItem("title "+i);
            if (i == 2){
                PathItemStyle pathItemStyle = new PathItemStyle();
                pathItemStyle.setPathItemBackgroundResId(R.drawable.bg_two_corner_sp);
                pathItem.setPathItemStyle(pathItemStyle, false);
            }
            ultimateBreadcrumbsView2.addToPath(pathItem);
        }


        ultimateBreadcrumbsView3.initUltimateBreadcrumbsView();
        for (int i = 0; i < 5; i++) {
            ultimateBreadcrumbsView3.addToPath(new PathItem("title "+i));
        }

    }
}
