package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchCrumb {
    @SerializedName("@class")
    @Expose
    public String _class;
    @SerializedName("terms")
    @Expose
    public String terms;
    @SerializedName("removeAction")
    @Expose
    public RemoveAction removeAction;
    @SerializedName("correctedTerms")
    @Expose
    public Object correctedTerms;
    @SerializedName("key")
    @Expose
    public String key;
    @SerializedName("matchMode")
    @Expose
    public String matchMode;
}
