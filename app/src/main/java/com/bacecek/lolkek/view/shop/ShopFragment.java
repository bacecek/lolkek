package com.bacecek.lolkek.view.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bacecek.lolkek.KekApplication;
import com.bacecek.lolkek.R;
import com.bacecek.lolkek.presenter.ShopPresenter;
import com.bacecek.lolkek.view.models.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShopFragment extends MvpAppCompatFragment implements ShopView{

    @BindView(R.id.rv_shop)
    RecyclerView rvShop;

    ShopAdapter shopAdapter;

    private Unbinder unbinder;

    @InjectPresenter
    ShopPresenter presenter;

    @ProvidePresenter
    public ShopPresenter providePresenter() {
        return KekApplication.get(getContext()).getApplicationComponent().getShopPresenter();
    }

    public static ShopFragment newInstance() {
        Bundle args = new Bundle();
        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initRv(){
        List<Spinner> list = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        shopAdapter = new ShopAdapter(list, position -> presenter.onItemBought(shopAdapter.getItem(position)));
        rvShop.setLayoutManager(gridLayoutManager);
        rvShop.setAdapter(shopAdapter);
        shopAdapter.setDataset(list);
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), "Недостаточно денег", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop,
                container, false);
        unbinder = ButterKnife.bind(this, view);

        initRv();
        presenter.initShop();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onSpinnerBought(Spinner item) {
        presenter.onItemBought(item);
    }

    @Override
    public void updateItems(List<Spinner> list) {
        shopAdapter.setDataset(list);
    }
}
