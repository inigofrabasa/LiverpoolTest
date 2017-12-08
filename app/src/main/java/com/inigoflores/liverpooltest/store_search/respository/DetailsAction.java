package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsAction {
    @SerializedName("recordState")
    @Expose
    public String recordState;
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
