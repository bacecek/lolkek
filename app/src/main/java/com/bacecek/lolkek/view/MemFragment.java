package com.bacecek.lolkek.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bacecek.lolkek.KekApplication;
import com.bacecek.lolkek.R;
import com.bacecek.lolkek.data.MemState;
import com.bacecek.lolkek.data.ResultState;
import com.bacecek.lolkek.data.ScreenState;
import com.bacecek.lolkek.navigation.BackButtonListener;
import com.bacecek.lolkek.presenter.MemPresenter;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *
 */
public class MemFragment extends MvpAppCompatFragment implements MemView, BackButtonListener {
    public static MemFragment newInstance() {
        return new MemFragment();
    }

    @BindView(R.id.txt_timer) TextView timer;
    @BindView(R.id.img_mem) ImageView mem;
    @BindView(R.id.btn_gavno) View btnDislike;
    @BindView(R.id.btn_lol) View btnLike;

    @BindView(R.id.view_result) ViewGroup result;
    @BindView(R.id.txt_winner) TextView resultText;
    @BindView(R.id.txt_percent) TextView resultPercent;
    @BindView(R.id.txt_cats) TextView plusCats;
    @BindView(R.id.img_spinner) ImageView spinner;

    private Unbinder unbinder;

    @InjectPresenter MemPresenter presenter;

    @ProvidePresenter
    public MemPresenter providePresenter() {
        return KekApplication.get(getContext()).getApplicationComponent().getMemPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mem, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter.initMem();
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

    @Override
    public void showScreenState(ScreenState screenState) {
        if (screenState.getState() == ScreenState.MEM) {
            showMem((MemState) screenState);
        } else {
            showResult((ResultState) screenState);
        }
    }

    private void showMem(MemState memState) {
        Glide.with(getContext())
                .load(memState.getMem())
                .into(mem);
    }

    private void showResult(ResultState resultState) {

    }

    @OnClick(R.id.btn_gavno)
    public void onGavnoClicked(){
        presenter.onGavnoClicked();
    }

    @OnClick(R.id.btn_gavno)
    public void onLolClicked(){
        presenter.onLolClicked();
    }
}
