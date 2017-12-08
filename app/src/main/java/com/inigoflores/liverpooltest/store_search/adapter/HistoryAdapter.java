package com.inigoflores.liverpooltest.store_search.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.inigoflores.liverpooltest.R;

import java.util.List;

/**
 * Created by inigo on 07/12/17.
 */

public class HistoryAdapter extends ArrayAdapter<String> {

    ViewHolder holder;
    Context context;
    List<String> Search;
    private Activity activity;

    public HistoryAdapter(Context context, List<String> search, Activity activity) {
        super(context, R.layout.history_row, search);
        this.context = context;
        this.Search = search;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.history_row, parent, false);
            holder = new ViewHolder();
            holder.result_search = rowView.findViewById(R.id.product_name);
            rowView.setTag(holder);
        } else{
            holder = (ViewHolder) rowView.getTag();
        }

        holder.Search = Search.get(position);
        holder.result_search.setText(Search.get(position));

        return rowView;
    }

    class ViewHolder {
        String Search;
        TextView result_search;
    }

    @Override
    public int getCount(){
        return Search.size();
    }
}
