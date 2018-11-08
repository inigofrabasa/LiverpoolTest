package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by inigo on 08/11/18.
 */

public class RefinementGroup {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("refinement")
    @Expose
    public List<Refinement> refinement = null;
    @SerializedName("multiSelect")
    @Expose
    public Boolean multiSelect;
    @SerializedName("dimensionName")
    @Expose
    public String dimensionName;
}
