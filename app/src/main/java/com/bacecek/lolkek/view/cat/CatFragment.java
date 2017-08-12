package com.bacecek.lolkek.view.cat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bacecek.lolkek.KekApplication;
import com.bacecek.lolkek.R;
import com.bacecek.lolkek.navigation.BackButtonListener;
import com.bacecek.lolkek.presenter.CatPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ringov on 12.08.17.
 */

public class CatFragment extends MvpAppCompatFragment implements CatView, BackButtonListener {
    public static CatFragment newInstance() {
        return new CatFragment();
    }

    private Unbinder unbinder;

    @InjectPresenter
    CatPresenter presenter;

    @OnClick(R.id.cat_image)
    void onCatClick() {
        presenter.gladitCat();
    }

    @ProvidePresenter
    public CatPresenter providePresenter() {
        return KekApplication.get(getContext()).getApplicationComponent().getCatPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cat, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter.initCat();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onBackPressed() {
        presenter.onBackPressed();
    }

}
