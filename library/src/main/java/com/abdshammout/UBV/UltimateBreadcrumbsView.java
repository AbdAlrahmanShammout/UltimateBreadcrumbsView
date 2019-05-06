package com.AbdShammout.UBV;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.AbdShammout.UBV.model.PathItem;
import com.AbdShammout.UBV.model.PathItemStyle;
import com.AbdShammout.UBV.util.Constants;
import com.AbdShammout.UBV.util.Utils;

public class UltimateBreadcrumbsView extends LinearLayout {

    private BreadcrumbsRecyclerView breadcrumbsRecyclerView;
    private PathItemStyle pathItemStyle = new PathItemStyle();
    private OnClickListenerBreadcrumbs onClickListenerBreadcrumbs;

    public UltimateBreadcrumbsView(Context context) {
        super(context);
    }

    public UltimateBreadcrumbsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttr(context, attrs);
    }

    public UltimateBreadcrumbsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);
    }

    private void initAttr(Context context, AttributeSet attrs){
        if (attrs != null) {
            // Attribute initialization
            final TypedArray a = context.obtainStyledAttributes(attrs,
                    com.AbdShammout.UBV.R.styleable.UltimateBreadcrumbsView, 0, 0);
            if (a.hasValue(R.styleable.UltimateBreadcrumbsView_pathItemBackground))
                pathItemStyle.setPathItemBackgroundDrawable(a.getDrawable(R.styleable.UltimateBreadcrumbsView_pathItemBackground));
            if (a.hasValue(R.styleable.UltimateBreadcrumbsView_ActivePathItemBackground))
                pathItemStyle.setBackgroundPathItemActive(a.getDrawable(R.styleable.UltimateBreadcrumbsView_ActivePathItemBackground));

            pathItemStyle.setPathItemTextColor(a.getColor(R.styleable.UltimateBreadcrumbsView_pathItemTextColor, Color.BLACK));
            pathItemStyle.setActivePathItemTextColor(a.getColor(R.styleable.UltimateBreadcrumbsView_ActivePathItemTextColor, Color.WHITE));

            if (a.hasValue(R.styleable.UltimateBreadcrumbsView_backButtonIcon))
                setBackButtonIconDrawable(a.getDrawable(R.styleable.UltimateBreadcrumbsView_backButtonIcon));
            if (a.hasValue(R.styleable.UltimateBreadcrumbsView_backButtonBackground))
                setBackButtonBackgroundDrawable(a.getDrawable(R.styleable.UltimateBreadcrumbsView_backButtonBackground));

            a.recycle();
        }
    }

    private RecyclerView CreateRecyclerView(){
        breadcrumbsRecyclerView = new BreadcrumbsRecyclerView(getContext());
        breadcrumbsRecyclerView.setLayoutDirection(LAYOUT_DIRECTION_RTL);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        breadcrumbsRecyclerView.setLayoutParams(params);
        breadcrumbsRecyclerView.setOnClickListenerBreadcrumbs(onClickListenerBreadcrumbs);
        breadcrumbsRecyclerView.setPathItemStyle(pathItemStyle);
        return breadcrumbsRecyclerView;
    }

    private ImageView createButtonBack(){
        ImageView buttonBack = new ImageView(getContext());
        setBackgroundBackButton(buttonBack);
        setIconBackButton(buttonBack);
        int margin = Utils.convertDpToPx(getContext(),4);
        int padding = margin*2;
        LayoutParams params= new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(margin,margin,margin,margin);
        buttonBack.setLayoutParams(params);
        buttonBack.setPadding(padding,padding,padding,padding);
        buttonBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
                onClickListenerBreadcrumbs.onBackClick();
            }
        });
        return buttonBack;
    }

    //--------- public Method ------------
    public void initUltimateBreadcrumbsView(){
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        addView(createButtonBack());
        addView(CreateRecyclerView());
    }

    public void setOnClickListenerBreadcrumbs(OnClickListenerBreadcrumbs onClickListenerBreadcrumbs) {
        this.onClickListenerBreadcrumbs = onClickListenerBreadcrumbs;
    }

    public void setPathItemStyle(PathItemStyle pathItemStyle){
        this.pathItemStyle = pathItemStyle;
    }

    public void addToPath(PathItem pathItem){
        if (breadcrumbsRecyclerView == null){
            Log.e("NullBreadcrumbReference","Cant find property in undefined Type");
            return;
        }
        breadcrumbsRecyclerView.addToPath(pathItem);
    }

    public void addToPath(PathItem pathItem, int position){
        if (breadcrumbsRecyclerView == null){
            Log.e("NullBreadcrumbReference","Cant find property in undefined Type");
            return;
        }
        breadcrumbsRecyclerView.addToPath(pathItem, position);
    }

    public void back(){
        if (breadcrumbsRecyclerView == null){
            Log.e("NullBreadcrumbReference","Cant find property in undefined Type");
            return;
        }
        breadcrumbsRecyclerView.back();
    }

    public void backTo(int position){
        if (breadcrumbsRecyclerView == null){
            Log.e("NullBreadcrumbReference","Cant find property in undefined Type");
            return;
        }
        breadcrumbsRecyclerView.backTo(position);
    }

    public int getItemCount(){
        if (breadcrumbsRecyclerView == null){
            Log.e("NullBreadcrumbReference","Cant find property in undefined Type");
            return -1;
        }
        return breadcrumbsRecyclerView.getItemCount();
    }





    //************** Button Back *****************
    @DrawableRes
    private int backButtonBackgroundRes = R.drawable.bg_default_path;
    @ColorInt
    private int backButtonBackgroundColor;
    private Drawable backButtonBackgroundDrawable;
    private int backButtonBackgroundType = 1;

    public void setBackButtonBackgroundRes(@DrawableRes int backButtonBackgroundRes) {
        this.backButtonBackgroundRes = backButtonBackgroundRes;
        backButtonBackgroundType = 1;
    }
    public void setBackButtonBackgroundColor(@ColorInt int backButtonBackgroundColor) {
        this.backButtonBackgroundColor = backButtonBackgroundColor;
        backButtonBackgroundType = 2;
    }
    public void setBackButtonBackgroundDrawable(Drawable backButtonBackgroundDrawable) {
        this.backButtonBackgroundDrawable = backButtonBackgroundDrawable;
        backButtonBackgroundType = 3;
    }
    private void setBackgroundBackButton(ImageView imageView){
        switch (backButtonBackgroundType){
            case Constants.TYPE_INT_RES:
                imageView.setBackgroundResource(backButtonBackgroundRes);
                break;
            case Constants.TYPE_INT_COLOR:
                imageView.setBackgroundColor(backButtonBackgroundColor);
                break;
            case Constants.TYPE_DRAWABLE:
                imageView.setBackground(backButtonBackgroundDrawable);
                break;
        }
    }


    @DrawableRes
    private int backButtonIconRes = R.drawable.ic_back_black;
    private Drawable backButtonIconDrawable;
    private Bitmap backButtonIconBitmap;
    private int backButtonIconType = 1;

    public void setBackButtonIconRes(int backButtonIconRes) {
        this.backButtonIconRes = backButtonIconRes;
        backButtonIconType = Constants.TYPE_INT_RES;
    }
    public void setBackButtonIconDrawable(Drawable backButtonIconDrawable) {
        this.backButtonIconDrawable = backButtonIconDrawable;
        backButtonIconType = Constants.TYPE_DRAWABLE;
    }
    public void setBackButtonIconBitmap(Bitmap backButtonIconBitmap) {
        this.backButtonIconBitmap = backButtonIconBitmap;
        backButtonIconType = Constants.TYPE_BITMAP;
    }
    private void setIconBackButton(ImageView imageView){
        switch (backButtonIconType){
            case Constants.TYPE_INT_RES:
                imageView.setImageResource(backButtonIconRes);
                break;
            case Constants.TYPE_DRAWABLE:
                imageView.setImageDrawable(backButtonIconDrawable);
                break;
            case Constants.TYPE_BITMAP:
                imageView.setImageBitmap(backButtonIconBitmap);
                break;
        }
    }




}
