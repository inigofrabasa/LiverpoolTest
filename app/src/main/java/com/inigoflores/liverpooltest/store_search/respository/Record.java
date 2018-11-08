package com.inigoflores.liverpooltest.store_search.respository;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by inigo on 08/11/18.
 */

public class Record {
    @SerializedName("productId")
    @Expose
    public String productId;
    @SerializedName("skuRepositoryId")
    @Expose
    public String skuRepositoryId;
    @SerializedName("productDisplayName")
    @Expose
    public String productDisplayName;
    @SerializedName("productType")
    @Expose
    public String productType;
    @SerializedName("productRatingCount")
    @Expose
    public Integer productRatingCount;
    @SerializedName("productAvgRating")
    @Expose
    public Float productAvgRating;
    @SerializedName("listPrice")
    @Expose
    public Float listPrice;
    @SerializedName("minimumListPrice")
    @Expose
    public Float minimumListPrice;
    @SerializedName("maximumListPrice")
    @Expose
    public Float maximumListPrice;
    @SerializedName("promoPrice")
    @Expose
    public Float promoPrice;
    @SerializedName("minimumPromoPrice")
    @Expose
    public Float minimumPromoPrice;
    @SerializedName("maximumPromoPrice")
    @Expose
    public Float maximumPromoPrice;
    @SerializedName("isHybrid")
    @Expose
    public Boolean isHybrid;
    @SerializedName("isMarketPlace")
    @Expose
    public Boolean isMarketPlace;
    @SerializedName("smImage")
    @Expose
    public String smImage;
    @SerializedName("lgImage")
    @Expose
    public String lgImage;
    @SerializedName("xlImage")
    @Expose
    public String xlImage;
    @SerializedName("groupType")
    @Expose
    public String groupType;
    @SerializedName("plpFlags")
    @Expose
    public List<Object> plpFlags = null;

    public Bitmap productImage = null;
}
