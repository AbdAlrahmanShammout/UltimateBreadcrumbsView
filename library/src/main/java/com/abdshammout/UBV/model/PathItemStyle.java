package com.abdshammout.UBV.model;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;

import com.abdshammout.UBV.library.R;
import com.abdshammout.UBV.util.Constants;


public class PathItemStyle {

    //******** Path Item Background ********
    @DrawableRes
    private int pathItemBackgroundResId = R.drawable.bg_default_path;
    @ColorInt
    private int pathItemBackgroundColor;

    private Drawable pathItemBackgroundDrawable;

    private int typeBackgroundPathItem = 1;

    //******** set ********
    public void setPathItemBackgroundResId(@DrawableRes int ResId){
        pathItemBackgroundResId = ResId;
        typeBackgroundPathItem = Constants.TYPE_INT_RES;
    }

    public void setPathItemBackgroundColor(@ColorInt int color){
        pathItemBackgroundColor = color;
        typeBackgroundPathItem = Constants.TYPE_INT_COLOR;
    }

    public void setPathItemBackgroundDrawable(Drawable drawable){
        pathItemBackgroundDrawable = drawable;
        typeBackgroundPathItem = Constants.TYPE_DRAWABLE;
    }

    //******** get ********
    public int getPathItemBackgroundResId() {
        return pathItemBackgroundResId;
    }

    public int getPathItemBackgroundColor() {
        return pathItemBackgroundColor;
    }

    public Drawable getPathItemBackgroundDrawable() {
        return pathItemBackgroundDrawable;
    }

    public int getTypeBackgroundPathItem() {
        return typeBackgroundPathItem;
    }






    //******** Active Path Item Background ********
    @DrawableRes
    private int ActivePathItemBackgroundResId = R.drawable.bg_default_active_path;
    @ColorInt
    private int ActivePathItemBackgroundColor;

    private Drawable ActivePathItemBackgroundDrawable;

    private int ActivePathItemBackgroundType = 1;

    //******** set ********

    public void setActivePathItemBackgroundResId(@DrawableRes int ResId){
        ActivePathItemBackgroundResId = ResId;
        ActivePathItemBackgroundType = Constants.TYPE_INT_RES;
    }

    public void setActivePathItemBackgroundColor(@ColorInt int color){
        ActivePathItemBackgroundColor = color;
        ActivePathItemBackgroundType = Constants.TYPE_INT_COLOR;
    }

    public void setActivePathItemBackgroundDrawable(Drawable drawable){
        ActivePathItemBackgroundDrawable = drawable;
        ActivePathItemBackgroundType = Constants.TYPE_DRAWABLE;
    }

    //******** get ********
    public int getActivePathItemBackgroundResId() {
        return ActivePathItemBackgroundResId;
    }

    public int getActivePathItemBackgroundColor() {
        return ActivePathItemBackgroundColor;
    }

    public Drawable getActivePathItemBackgroundDrawable() {
        return ActivePathItemBackgroundDrawable;
    }

    public int getActivePathItemBackgroundType() {
        return ActivePathItemBackgroundType;
    }




    //******** path Item Text Color ********
    @ColorInt
    private int pathItemTextColor = Color.BLACK;

    public void setPathItemTextColor(@ColorInt int pathItemTextColor) {
        this.pathItemTextColor = pathItemTextColor;
    }

    public int getPathItemTextColor() {
        return pathItemTextColor;
    }


    //******** Active path Item Text Color ********
    @ColorInt
    private int ActivePathItemTextColor = Color.WHITE;

    public void setActivePathItemTextColor(@ColorInt int activePathItemTextColor) {
        this.ActivePathItemTextColor = activePathItemTextColor;
    }

    public int getActivePathItemTextColor() {
        return ActivePathItemTextColor;
    }



}
