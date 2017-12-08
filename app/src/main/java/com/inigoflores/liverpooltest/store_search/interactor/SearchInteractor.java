package com.inigoflores.liverpooltest.store_search.interactor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inigoflores.liverpooltest.R;
import com.inigoflores.liverpooltest.application.LiverpoolApplication;
import com.inigoflores.liverpooltest.store_search.presenter.ISearchPresenter;
import com.inigoflores.liverpooltest.store_search.respository.Content;
import com.inigoflores.liverpooltest.store_search.respository.Content_;
import com.inigoflores.liverpooltest.store_search.respository.ISearchDataService;
import com.inigoflores.liverpooltest.store_search.respository.MainContent;
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
    private final String jsonKey = LiverpoolApplication.context.getResources().getString(R.string.jsonKey);
    private final String listParam = LiverpoolApplication.context.getResources().getString(R.string.listParam);

    private ISearchPresenter searchPresenter;

    public SearchInteractor(ISearchPresenter searchPresenter){
        this.searchPresenter = searchPresenter;
    }

    @Override
    public void requestSearch(String param) {

        OkHttpClient client = new OkHttpClient();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ISearchDataService service =  retrofit.create(ISearchDataService.class);

        Call<Search> messagesCall = service.getContent(baseUrl + "?s="+ param + "&" + jsonKey);
        if(messagesCall != null){
            messagesCall.enqueue(new Callback<Search>() {
                @Override
                public void onResponse(Call<Search> call, Response<Search> response) {
                    if(response.body().contents != null){
                        for(Content content : response.body().contents)
                            for(MainContent mainContent : content.mainContent)
                                if(mainContent.contents != null)
                                    for (Content_ content_ : mainContent.contents) {
                                        if (content_.name.contains(listParam)) {
                                            searchPresenter.responseSearch(content_.records);
                                            break;
                                        }
                                    }
                    }
                    else if(response.body().contents == null){
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
