package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by inigo on 06/12/17.
 */

public class Search {
    @SerializedName("status")
    @Expose
    public Status status;
    @SerializedName("pageType")
    @Expose
    public String pageType;
    @SerializedName("plpResults")
    @Expose
    public PlpResults plpResults;
}
