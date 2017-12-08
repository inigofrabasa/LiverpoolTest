package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SecondaryContent {
    @SerializedName("removeAllAction")
    @Expose
    public RemoveAllAction removeAllAction;
    @SerializedName("refinementCrumbs")
    @Expose
    public List<Object> refinementCrumbs = null;
    @SerializedName("geoFilterCrumb")
    @Expose
    public Object geoFilterCrumb;
    @SerializedName("@type")
    @Expose
    public String type;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("searchCrumbs")
    @Expose
    public List<SearchCrumb> searchCrumbs = null;
    @SerializedName("rangeFilterCrumbs")
    @Expose
    public List<Object> rangeFilterCrumbs = null;
    @SerializedName("navigation")
    @Expose
    public List<Navigation> navigation = null;
}
