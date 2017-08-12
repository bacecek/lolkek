package com.bacecek.lolkek.view.shop;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bacecek.lolkek.R;
import com.bacecek.lolkek.view.models.Spinner;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.Holder> {

    private List<Spinner> dataset;
    private OnShopItemSelected onShopItemSelected;

    public ShopAdapter(List<Spinner> dataset, OnShopItemSelected onShopItemSelected) {
        this.dataset = dataset;
        this.onShopItemSelected = onShopItemSelected;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_spinner, parent, false);
        return new Holder(view, onShopItemSelected);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tvCount.setText(dataset.get(position).getCount());

        int type = dataset.get(position).getCoeff();
        switch (type) {
            case 2: {
                holder.ivSpinner.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.spinner1));
                break;
            }
            case 3: {
                holder.ivSpinner.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.spinner2));
                break;
            }
            case 5: {
                holder.ivSpinner.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.spinner3));
                break;
            }
            case 10: {
                holder.ivSpinner.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.spinner4));
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class Holder extends RecyclerView.ViewHolder {

        ImageView ivSpinner;
        TextView tvCount;
        Button btnBuy;

        Holder(View itemView, OnShopItemSelected onShopItemSelected) {
            super(itemView);
            ivSpinner = (ImageView) itemView.findViewById(R.id.iv_shop_spinner);
            tvCount = (TextView) itemView.findViewById(R.id.tv_shop_count);
            btnBuy = (Button) itemView.findViewById(R.id.btn_shop_buy);
        }

        private void setListener(final OnShopItemSelected listener) {
            btnBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) listener.onBuyClick(getAdapterPosition());
                }
            });
        }


    }

}
