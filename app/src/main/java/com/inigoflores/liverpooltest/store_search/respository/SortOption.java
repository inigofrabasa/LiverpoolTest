package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SortOption {
    @SerializedName("selected")
    @Expose
    public Boolean selected;
    @SerializedName("navigationState")
    @Expose
    public String navigationState;
    @SerializedName("contentPath")
    @Expose
    public String contentPath;
    @SerializedName("@class")
    @Expose
    public String _class;
    @SerializedName("siteRootPath")
    @Expose
    public String siteRootPath;
    @SerializedName("label")
    @Expose
    public String label;
}