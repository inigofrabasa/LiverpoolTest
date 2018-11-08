package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by inigo on 08/11/18.
 */

public class PlpResults {
    @SerializedName("label")
    @Expose
    public String label;
    @SerializedName("plpState")
    @Expose
    public PlpState plpState;
    @SerializedName("sortOptions")
    @Expose
    public List<SortOption> sortOptions = null;
    @SerializedName("refinementGroups")
    @Expose
    public List<RefinementGroup> refinementGroups = null;
    @SerializedName("records")
    @Expose
    public List<Record> records = null;
}
