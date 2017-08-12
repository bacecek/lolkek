package com.bacecek.lolkek.view.choose_spinner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatDialogFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bacecek.lolkek.KekApplication;
import com.bacecek.lolkek.R;
import com.bacecek.lolkek.presenter.ChooseSpinnerPresenter;
import com.bacecek.lolkek.view.models.Spinner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by macbookpro on 12.08.17.
 */

public class ChooseSpinnerFragment extends MvpAppCompatDialogFragment implements ChooseSpinnerView {

    @BindView(R.id.list_spinners)
    RecyclerView listSpinners;

    private Unbinder unbinder;
    private ChooseSpinnerAdapter adapter;

    @InjectPresenter
    ChooseSpinnerPresenter presenter;

    @ProvidePresenter
    ChooseSpinnerPresenter providePresenter() {
        return KekApplication.get(getContext()).getApplicationComponent().getChooseSpinnerPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_spinner, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listSpinners.setLayoutManager(new LinearLayoutManager(getContext()));
        listSpinners.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public static ChooseSpinnerFragment newInstance() {
        return new ChooseSpinnerFragment();
    }

    @Override
    public void setSpinners(List<Spinner> spinners) {
        if(adapter == null) {
            adapter = new ChooseSpinnerAdapter(p -> {
                presenter.onChooseSpinner(p);
                this.dismissAllowingStateLoss();
            }, spinners);
            listSpinners.setAdapter(adapter);
        } else {
            adapter.setData(spinners);
        }
    }

    @Override
    public void dismiss() {
        //dismissAllowingStateLoss();
    }
}
