package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Refinement {
    @SerializedName("multiSelect")
    @Expose
    public Boolean multiSelect;
    @SerializedName("navigationState")
    @Expose
    public String navigationState;
    @SerializedName("contentPath")
    @Expose
    public String contentPath;
    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("@class")
    @Expose
    public String _class;
    @SerializedName("siteRootPath")
    @Expose
    public String siteRootPath;
    @SerializedName("label")
    @Expose
    public String label;
    @SerializedName("properties")
    @Expose
    public Properties properties;
}
