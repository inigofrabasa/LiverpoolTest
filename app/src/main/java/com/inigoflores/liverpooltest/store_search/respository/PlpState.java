package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by inigo on 08/11/18.
 */

public class PlpState {
    @SerializedName("categoryId")
    @Expose
    public String categoryId;
    @SerializedName("currentSortOption")
    @Expose
    public String currentSortOption;
    @SerializedName("currentFilters")
    @Expose
    public String currentFilters;
    @SerializedName("firstRecNum")
    @Expose
    public Integer firstRecNum;
    @SerializedName("lastRecNum")
    @Expose
    public Integer lastRecNum;
    @SerializedName("recsPerPage")
    @Expose
    public Integer recsPerPage;
    @SerializedName("totalNumRecs")
    @Expose
    public Integer totalNumRecs;
    @SerializedName("originalSearchTerm")
    @Expose
    public String originalSearchTerm;

}
