package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by inigo on 08/11/18.
 */

public class SortOption {
    @SerializedName("sortBy")
    @Expose
    public String sortBy;
    @SerializedName("label")
    @Expose
    public String label;
}
