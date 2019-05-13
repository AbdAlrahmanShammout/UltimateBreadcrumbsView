package com.abdshammout.ultimatebreadcrumbsview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abdshammout.UBV.OnClickListenerBreadcrumbs;
import com.abdshammout.UBV.UltimateBreadcrumbsView;
import com.abdshammout.UBV.model.PathItem;

public class FirstSampleActivity extends AppCompatActivity {

    UltimateBreadcrumbsView ultimateBreadcrumbsView;

    Button addItem;
    Button addInPosition;
    Button removeItem;
    Button goToSecondSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_sample);
        ultimateBreadcrumbsView = findViewById(R.id.ultimateBreadcrumbsView);
        addItem = findViewById(R.id.addItem);
        addInPosition = findViewById(R.id.addInPosition);
        removeItem = findViewById(R.id.removeItem);
        goToSecondSample = findViewById(R.id.goToSecondSample);

        ultimateBreadcrumbsView.setOnClickListenerBreadcrumbs(new OnClickListenerBreadcrumbs() {
            @Override
            public void onBackClick() {
                Toast.makeText(FirstSampleActivity.this,
                        "onBackClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPathItemClick(int index, String title, int id) {
                Toast.makeText(FirstSampleActivity.this,
                        index+"  onPathItemClick = "+title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPathItemLongClick(int index, String title, int id) {
                Toast.makeText(FirstSampleActivity.this,
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


        goToSecondSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstSampleActivity.this,
                        SecondSampleActivity.class));
            }
        });
    }
}
