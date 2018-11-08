package com.inigoflores.liverpooltest.store_search.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by inigo on 08/11/18.
 */

public class Status {
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("statusCode")
    @Expose
    public Integer statusCode;
}
