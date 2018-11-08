package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by inigo on 08/11/18.
 */

public class Refinement {
    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("label")
    @Expose
    public String label;
    @SerializedName("refinementId")
    @Expose
    public String refinementId;
    @SerializedName("selected")
    @Expose
    public Boolean selected;
    @SerializedName("colorHex")
    @Expose
    public String colorHex;

}
