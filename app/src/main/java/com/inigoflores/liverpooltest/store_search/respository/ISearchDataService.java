package com.inigoflores.liverpooltest.store_search.respository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by inigo on 08/11/18.
 */

public interface ISearchDataService {
    @GET
    Call<Search> getRecords(@Url String url);
}
