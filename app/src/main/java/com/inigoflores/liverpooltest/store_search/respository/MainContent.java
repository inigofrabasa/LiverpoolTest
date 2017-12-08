package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainContent {
    @SerializedName("originalTerms")
    @Expose
    public List<String> originalTerms = null;
    @SerializedName("@type")
    @Expose
    public String type;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("contents")
    @Expose
    public List<Content_> contents = null;
    @SerializedName("ruleLimit")
    @Expose
    public String ruleLimit;
    @SerializedName("contentCollection")
    @Expose
    public String contentCollection;
}
