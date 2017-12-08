package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Record {
    @SerializedName("@class")
    @Expose
    public String _class;
    @SerializedName("detailsAction")
    @Expose
    public DetailsAction detailsAction;
    @SerializedName("numRecords")
    @Expose
    public Integer numRecords;
    @SerializedName("attributes")
    @Expose
    public Attributes attributes;
    @SerializedName("records")
    @Expose
    public List<Record_> records = null;
}
