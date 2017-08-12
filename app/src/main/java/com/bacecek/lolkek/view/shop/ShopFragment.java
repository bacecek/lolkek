package com.bacecek.lolkek.view.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bacecek.lolkek.R;
import com.bacecek.lolkek.view.models.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShopFragment extends Fragment {

    @BindView(R.id.rv_shop)
    RecyclerView rvShop;

    ShopAdapter shopAdapter;

    private Unbinder unbinder;

    public static ShopFragment newInstance() {
        Bundle args = new Bundle();
        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop,
                container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        List<Spinner> dataset = new ArrayList<>();
        dataset.add(new Spinner(1,100, 2, 2));
        dataset.add(new Spinner(2,100, 3, 5));
        dataset.add(new Spinner(3,100, 10, 5));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);



        shopAdapter = new ShopAdapter(dataset, new OnShopItemSelected() {
            @Override
            public void onBuyClick(int position) {
                Log.e("ShopFragment", "ItemClicked");
            }
        });

        rvShop.setLayoutManager(gridLayoutManager);
        rvShop.setAdapter(shopAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
