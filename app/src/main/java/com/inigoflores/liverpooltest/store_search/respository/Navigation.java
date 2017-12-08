package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Navigation {
    @SerializedName("@type")
    @Expose
    public String type;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("dimensionName")
    @Expose
    public String dimensionName;
    @SerializedName("refinements")
    @Expose
    public List<Refinement> refinements = null;
    @SerializedName("multiSelect")
    @Expose
    public Boolean multiSelect;
    @SerializedName("ancestors")
    @Expose
    public List<Object> ancestors = null;
    @SerializedName("displayName")
    @Expose
    public String displayName;
    @SerializedName("whyPrecedenceRuleFired")
    @Expose
    public Object whyPrecedenceRuleFired;
}
