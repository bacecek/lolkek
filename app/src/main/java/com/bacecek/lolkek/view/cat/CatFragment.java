package com.bacecek.lolkek.view.cat;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    @BindView(R.id.tv_plus_1)
    TextView tvPlus1;
    @BindView(R.id.tv_plus_2)
    TextView tvPlus2;
    @BindView(R.id.tv_plus_3)
    TextView tvPlus3;

    //volatile boolean animating;
    volatile int counter;

    @OnClick(R.id.cat_image)
    void onCatClick() {
        //if (!animating) {
        presenter.gladitCat();
        counter++;
        //}
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

    @Override
    public void showPlusBalance(int plus) {
        TextView crt = crtToAnimate(counter);
        crt.setText("+" + plus);
        crt.setVisibility(View.VISIBLE);
        //animating = true;
        crt.animate()
                .alpha(0f)
                .alphaBy(1.0f)
                .scaleX(1.0f)
                .scaleXBy(1.2f)
                .scaleY(1.0f)
                .scaleYBy(1.2f)
                .setDuration(300)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        crt.setVisibility(View.GONE);
                        crt.setScaleX(1.0f);
                        crt.setScaleY(1.0f);
                        // animating = false;
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {
                        crt.setVisibility(View.GONE);
                        crt.setScaleX(1.0f);
                        crt.setScaleY(1.0f);
                        //animating = false;
                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }).start();

    }

    private TextView crtToAnimate(int counter) {
        int crt = counter % 3;
        switch (crt) {
            case 0:
                return tvPlus1;
            case 1:
                return tvPlus2;
            case 2:
                return tvPlus3;
            default:
                return tvPlus1;
        }
    }
}
