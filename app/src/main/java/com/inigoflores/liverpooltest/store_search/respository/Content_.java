package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Content_ {
    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("@type")
    @Expose
    public String type;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("totalNumRecs")
    @Expose
    public Integer totalNumRecs;
    @SerializedName("sortOptions")
    @Expose
    public List<SortOption> sortOptions = null;
    @SerializedName("firstRecNum")
    @Expose
    public Integer firstRecNum;
    @SerializedName("lastRecNum")
    @Expose
    public Integer lastRecNum;
    @SerializedName("pagingActionTemplate")
    @Expose
    public PagingActionTemplate pagingActionTemplate;
    @SerializedName("recsPerPage")
    @Expose
    public Integer recsPerPage;
    @SerializedName("records")
    @Expose
    public List<Record> records = null;
    @SerializedName("minimumResultListPrice")
    @Expose
    public String minimumResultListPrice;
    @SerializedName("precomputedSorts")
    @Expose
    public List<Object> precomputedSorts = null;
    @SerializedName("maximumResultListPrice")
    @Expose
    public String maximumResultListPrice;
}
