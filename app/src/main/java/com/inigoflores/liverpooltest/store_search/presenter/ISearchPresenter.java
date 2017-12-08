package com.inigoflores.liverpooltest.store_search.presenter;

/**
 * Created by inigo on 07/12/17.
 */

public interface ISearchPresenter {
    void requestSearch(String param);
    void responseSearch(Object object);
    void responseError(String error);
}
