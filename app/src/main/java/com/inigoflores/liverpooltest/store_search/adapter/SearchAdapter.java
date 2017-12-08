package com.inigoflores.liverpooltest.store_search.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inigoflores.liverpooltest.R;
import com.inigoflores.liverpooltest.store_search.respository.Record;
import com.inigoflores.liverpooltest.store_search.utilities.DownloadImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inigo on 07/12/17.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{

    private int resource;
    private Activity activity;
    private List<Record> records;

    public SearchAdapter(int resource, Activity activity, Object object){
        this.resource = resource;
        this.activity = activity;
        if(object == null)
            records = new ArrayList<>();
        else
            this.records = (List<Record>)object;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        final int pos = getItemViewType(position);

        if(records.get(pos).attributes.productDisplayName.get(0) != null){
            holder.productName.setText(records.get(pos).attributes.productDisplayName.get(0));
        }

        if (records.get(pos).attributes.productImage == null) {
            if(records.get(pos).attributes.skuThumbnailImage.get(0) != null &&
                    records.get(pos).attributes.skuThumbnailImage.size() > 0)
                new DownloadImage(holder.productImage, records.get(pos).attributes)
                        .execute(records.get(pos).attributes.skuThumbnailImage.get(0));
        } else {
            holder.productImage.setImageBitmap(records.get(pos).attributes.productImage);
        }

        if(records.get(pos).attributes.skuSalePrice.get(0) != null){
            holder.productPrice.setText("$ " + records.get(pos).attributes.skuSalePrice.get(0));
        }

    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{

        private View listItem;
        private TextView productName;
        private ImageView productImage;
        private TextView productPrice;

        public SearchViewHolder(View itemView) {
            super(itemView);

            listItem        = itemView.findViewById(R.id.ll_list_item);
            productName     = itemView.findViewById(R.id.tv_product_name);
            productImage    = itemView.findViewById(R.id.iv_product_image);
            productPrice    = itemView.findViewById(R.id.tv_product_price);
        }
    }
}
