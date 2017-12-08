package com.inigoflores.liverpooltest.store_search.respository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by inigo on 07/12/17.
 */

public interface ISearchDataService {
    @GET
    Call<Search> getContent(@Url String url);
}
