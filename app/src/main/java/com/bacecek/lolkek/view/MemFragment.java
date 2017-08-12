package com.bacecek.lolkek.view;

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
import com.bacecek.lolkek.presenter.MemPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 */
public class MemFragment extends MvpAppCompatFragment implements MemView, BackButtonListener {
    public static MemFragment newInstance() {
        return new MemFragment();
    }
    private Unbinder unbinder;

    @InjectPresenter MemPresenter presenter;

    @ProvidePresenter
    public MemPresenter providePresenter(){
        return KekApplication.get(getContext()).getApplicationComponent().getMemPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mem, container, false);
        unbinder = ButterKnife.bind(this, view);
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
