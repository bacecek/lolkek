package com.bacecek.lolkek.view.choose_spinner;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bacecek.lolkek.R;
import com.bacecek.lolkek.view.models.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bacecek on 12.08.17.
 */

public class ChooseSpinnerAdapter extends RecyclerView.Adapter<ChooseSpinnerAdapter.ViewHolder> {
    private OnChooseSpinnerListener onItemClickListener;
    private List<Spinner> data = new ArrayList<>();

    public ChooseSpinnerAdapter(OnChooseSpinnerListener onItemClickListener, List<Spinner> data) {
        this.onItemClickListener = onItemClickListener;
        this.data = data;
    }

    public void setData(List<Spinner> list) {
        this.data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spinner_dialog, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(data.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_spinner_dialog)
        ImageView imgSpinner;
        @BindView(R.id.txt_spinner_name)
        TextView txtSpinnerName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Spinner spinner, OnChooseSpinnerListener onChooseSpinnerListener) {
            txtSpinnerName.setText(spinner.getCoeff() + "x");
            int type = spinner.getCoeff();
            switch (type) {
                case 2: {
                    imgSpinner.setColorFilter(ContextCompat.getColor(itemView.getContext(), R.color.spinner1));
                    break;
                }
                case 3: {
                    imgSpinner.setColorFilter(ContextCompat.getColor(itemView.getContext(), R.color.spinner2));
                    break;
                }
                case 5: {
                    imgSpinner.setColorFilter(ContextCompat.getColor(itemView.getContext(), R.color.spinner3));
                    break;
                }
                case 10: {
                    imgSpinner.setColorFilter(ContextCompat.getColor(itemView.getContext(), R.color.spinner4));
                    break;
                }
            }
            if(onChooseSpinnerListener != null) {
                itemView.setOnClickListener(v -> onChooseSpinnerListener.onChooseSpinner(spinner));
            }
        }
    }

    public interface OnChooseSpinnerListener {
        void onChooseSpinner(Spinner spinner);
    }

}
