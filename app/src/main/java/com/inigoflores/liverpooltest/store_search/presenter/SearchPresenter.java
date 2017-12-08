package com.inigoflores.liverpooltest.store_search.presenter;

import com.inigoflores.liverpooltest.store_search.interactor.ISearchInteractor;
import com.inigoflores.liverpooltest.store_search.interactor.SearchInteractor;
import com.inigoflores.liverpooltest.store_search.view.ISearchView;

/**
 * Created by inigo on 07/12/17.
 */

public class SearchPresenter implements ISearchPresenter {

    private ISearchView searchView;
    private ISearchInteractor searchInteractor;

    public SearchPresenter(ISearchView searchView){
        this.searchView = searchView;
        searchInteractor = new SearchInteractor(this);
    }

    @Override
    public void requestSearch(String param) {
        searchInteractor.requestSearch(param);
    }

    @Override
    public void responseSearch(Object object) {
        searchView.responseSearch(object);
    }

    @Override
    public void responseError(String error) {
        searchView.responseError(error);
    }
}
