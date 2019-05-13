package com.abdshammout.ultimatebreadcrumbsview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abdshammout.UBV.OnClickListenerBreadcrumbs;
import com.abdshammout.UBV.UltimateBreadcrumbsView;
import com.abdshammout.UBV.model.PathItem;
import com.abdshammout.UBV.model.PathItemStyle;

public class SecondSampleActivity extends AppCompatActivity {

    UltimateBreadcrumbsView ultimateBreadcrumbsView;

    Button addItem;
    Button addInPosition;
    Button removeItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sample);
        ultimateBreadcrumbsView = findViewById(R.id.ultimateBreadcrumbsView);
        addItem = findViewById(R.id.addItem);
        addInPosition = findViewById(R.id.addInPosition);
        removeItem = findViewById(R.id.removeItem);

        initUBV();

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

        ultimateBreadcrumbsView.initUltimateBreadcrumbsView();





        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ultimateBreadcrumbsView.addToPath(new PathItem("title"));
            }
        });

        addInPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ultimateBreadcrumbsView.addToPath(new PathItem("title"),5);
            }
        });

        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ultimateBreadcrumbsView.back();
            }
        });

    }


    private void initUBV(){
        PathItemStyle pathItemStyle = new PathItemStyle();
        pathItemStyle.setPathItemBackgroundResId(R.drawable.bg_two_corner);
        pathItemStyle.setActivePathItemBackgroundResId(R.drawable.bg_two_corner_active);

        pathItemStyle.setPathItemTextColor(getResources().getColor(android.R.color.white));//or Color.WHITE
        pathItemStyle.setActivePathItemTextColor(Color.BLACK);

        ultimateBreadcrumbsView.setPathItemStyle(pathItemStyle);

        ultimateBreadcrumbsView.setBackButtonBackgroundRes(R.drawable.bg_two_corner);
        ultimateBreadcrumbsView.setBackButtonIconRes(android.R.drawable.ic_delete);

    }

}
