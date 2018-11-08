package com.inigoflores.liverpooltest.store_search.interactor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inigoflores.liverpooltest.R;
import com.inigoflores.liverpooltest.application.LiverpoolApplication;
import com.inigoflores.liverpooltest.store_search.presenter.ISearchPresenter;
import com.inigoflores.liverpooltest.store_search.respository.ISearchDataService;
import com.inigoflores.liverpooltest.store_search.respository.Search;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by inigo on 07/12/17.
 */

public class SearchInteractor implements ISearchInteractor {

    private final String baseUrl = LiverpoolApplication.context.getResources().getString(R.string.urlBase);

    private ISearchPresenter searchPresenter;

    public SearchInteractor(ISearchPresenter searchPresenter){
        this.searchPresenter = searchPresenter;
    }

    @Override
    public void requestSearch(String param) {

        //1 OkHttpClient
        OkHttpClient client = new OkHttpClient();

        //2 GsonBuilder
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //3 Retrofit.Builder()
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //4 retrofit.create
        ISearchDataService service = retrofit.create(ISearchDataService.class);

        //5 service.getRecords
        Call<Search> messagesCall = service.getRecords(baseUrl + "plp?search-string=" + param);
        if(messagesCall != null){
            messagesCall.enqueue(new Callback<Search>() {
                @Override
                public void onResponse(Call<Search> call, Response<Search> response) {
                    if(response.body().plpResults != null){
                        if(response.body().plpResults.records != null && response.body().plpResults.records.size() > 0){
                            searchPresenter.responseSearch(response.body().plpResults.records);
                        }
                    }
                    else if(response.body().plpResults == null){
                        searchPresenter.responseError("0");}
                }

                @Override
                public void onFailure(Call<Search> call, Throwable t) {
                    searchPresenter.responseError(t.getMessage());
                }
            });
        }
    }
}
