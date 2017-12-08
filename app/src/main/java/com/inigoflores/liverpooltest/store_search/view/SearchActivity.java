package com.inigoflores.liverpooltest.store_search.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.inigoflores.liverpooltest.R;
import com.inigoflores.liverpooltest.store_search.adapter.HistoryAdapter;
import com.inigoflores.liverpooltest.store_search.adapter.SearchAdapter;
import com.inigoflores.liverpooltest.store_search.presenter.ISearchPresenter;
import com.inigoflores.liverpooltest.store_search.presenter.SearchPresenter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchActivity extends AppCompatActivity implements ISearchView {

    private final String activityPreferences = "ActivityPreferences";
    private final String searchHistoryKey = "searchHistory";

    private ISearchPresenter searchPresenter;
    private EditText searchParam;
    private RecyclerView searchResultRecycler;

    private HistoryAdapter historyAdapter;
    private ListView historyList;
    private ProgressBar progressBar;

    List<String> history = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        searchParam = findViewById(R.id.et_search_term);
        searchResultRecycler = findViewById(R.id.rv_search_result);
        historyList   = findViewById(R.id.lv_searchResult);
        progressBar = findViewById(R.id.indeterminateBar);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        searchResultRecycler.setLayoutManager(gridLayoutManager);

        searchPresenter = new SearchPresenter(this);

        searchParam.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()!=KeyEvent.ACTION_DOWN)
                    return true;

                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    historyList.setVisibility(View.GONE);
                    onSearch(null);
                }

                return false;
            }
        });

        searchParam.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (searchParam.getText().length() > 0) {
                    historyList.setVisibility(View.VISIBLE);
                }
                else{
                    historyList.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        historyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                searchParam.setText(history.get(position));
                historyList.setVisibility(View.GONE);
                onSearch(null);
            }
        });

        history = getHistory();
        setHistory(history);
    }

    public void onSearch(View v){
        if(!searchParam.getText().toString().trim().isEmpty()){
            searchPresenter.requestSearch(searchParam.getText().toString());
            historyList.setVisibility(View.GONE);
            searchResultRecycler.setVisibility(View.GONE);

            progressBar.setVisibility(View.VISIBLE);
            hideKeyboard();
        }
    }

    @Override
    public void responseSearch(Object object) {
        if(object != null){
            progressBar.setVisibility(View.GONE);
            history.add(searchParam.getText().toString());
            setHistory(history);
            searchResultRecycler.setVisibility(View.VISIBLE);
            searchResultRecycler.setAdapter(new SearchAdapter(R.layout.cardview_item, this, object));
            searchResultRecycler.invalidate();
        }
    }

    @Override
    public void responseError(String error) {
        if(error != null){
            if(error == "0"){
                searchResultRecycler.setVisibility(View.GONE);
            }
            else
                Log.v("Search Error: ", error);
        }
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void setHistory(List<String> history) {
            historyAdapter = new HistoryAdapter(this, history, this);
            historyList.setAdapter(historyAdapter);
    }

    private void saveHistory(List<String> history){

        SharedPreferences settings = this.getSharedPreferences(activityPreferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Set<String> searchHistory = settings.getStringSet(searchHistoryKey, new HashSet<String>());

        for(String value : history)
            searchHistory.add(value);

        editor.clear();
        editor.putStringSet(searchHistoryKey, searchHistory);
        editor.commit();
    }

    private List<String> getHistory(){
        List<String> historyArray = new ArrayList<>();
        SharedPreferences settings = this.getSharedPreferences(activityPreferences, Context.MODE_PRIVATE);
        Set<String> history = settings.getStringSet(searchHistoryKey, new HashSet<String>());
        if(history != null){
            for(String result : history){
                historyArray.add(result);
            }
        }

        return historyArray;
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveHistory(history);
    }
}
