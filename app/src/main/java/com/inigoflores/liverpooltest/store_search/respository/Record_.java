package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record_ {
    @SerializedName("@class")
    @Expose
    public String _class;
    @SerializedName("detailsAction")
    @Expose
    public DetailsAction_ detailsAction;
    @SerializedName("numRecords")
    @Expose
    public Integer numRecords;
    @SerializedName("attributes")
    @Expose
    public Attributes_ attributes;
    @SerializedName("records")
    @Expose
    public Object records;
}
