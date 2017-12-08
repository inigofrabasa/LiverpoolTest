package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by inigo on 06/12/17.
 */

public class Properties {
    @SerializedName("DisplayOrder")
    @Expose
    public String displayOrder;
    @SerializedName("SourceId")
    @Expose
    public String sourceId;
    @SerializedName("dimensionValueId")
    @Expose
    public String dimensionValueId;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("DGraph.Strata")
    @Expose
    public String dGraphStrata;

}
