package com.abdshammout.UBV;

public interface OnClickListenerBreadcrumbs {

    void onBackClick();

    void onPathItemClick(int index, String title, int id);

    void onPathItemLongClick(int index, String title, int id);

}
