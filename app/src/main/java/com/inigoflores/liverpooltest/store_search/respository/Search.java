package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by inigo on 06/12/17.
 */

public class Search {
    @SerializedName("contents")
    @Expose
    public List<Content> contents = null;
}
