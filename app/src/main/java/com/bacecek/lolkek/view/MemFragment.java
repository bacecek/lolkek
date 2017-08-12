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
import com.bacecek.lolkek.Utils;
import com.bacecek.lolkek.data.MemState;
import com.bacecek.lolkek.data.ResultState;
import com.bacecek.lolkek.data.ScreenState;
import com.bacecek.lolkek.navigation.BackButtonListener;
import com.bacecek.lolkek.presenter.MemPresenter;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
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

    @BindViews({R.id.img_mem, R.id.txt_timer}) List<View> memStateList;

    static final ButterKnife.Action<View> GONE = (view, index) -> view.setVisibility(View.GONE);
    static final ButterKnife.Action<View> VISIBLE = (view, index) -> view.setVisibility(View.VISIBLE);

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
            ButterKnife.apply(memStateList, VISIBLE);
            result.setVisibility(View.GONE);
            showMem((MemState) screenState);
        } else {
            ButterKnife.apply(memStateList, GONE);
            result.setVisibility(View.VISIBLE);
            showResult((ResultState) screenState);
        }
    }

    private void showMem(MemState memState) {
        timer.setText(String.valueOf(15-memState.getTime()));
        Glide.with(getContext())
                .load(memState.getMem())
                .into(mem);
    }

    private void showResult(ResultState resultState) {
        resultState.getNewCoins();
        resultText.setText(resultState.getTitle());
        resultPercent.setText(resultState.getPercent() + "%");
        plusCats.setText("+"+resultState.getNewCoins());
        if (resultState.getSpinner() != null){
            spinner.setColorFilter(Utils.getSpinnerColorFilter(resultState.getSpinner().getCoeff(), getContext()));
            spinner.setVisibility(View.VISIBLE);
        } else {
            spinner.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.btn_gavno)
    public void onGavnoClicked(){
        presenter.onGavnoClicked();
    }

    @OnClick(R.id.btn_lol)
    public void onLolClicked(){
        presenter.onLolClicked();
    }

}
