package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PagingActionTemplate {
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
    public Object label;
}
