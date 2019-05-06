package com.abdshammout.UBV.model;


public class PathItem {
    private String title;
    private int id = -1;
    private PathItemStyle pathItemStyle;
    private boolean useStyleAlsoInActive;

    public PathItem(String title) {
        this.title = title;
    }

    public PathItem(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public void setPathItemStyle(PathItemStyle pathItemStyle, boolean useStyleAlsoInActive) {
        this.pathItemStyle = pathItemStyle;
        this.useStyleAlsoInActive = useStyleAlsoInActive;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public PathItemStyle getPathItemStyle() {
        return pathItemStyle;
    }

    public boolean isUseStyleAlsoInActive() {
        return useStyleAlsoInActive;
    }



}
