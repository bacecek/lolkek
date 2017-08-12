package com.bacecek.lolkek.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.bacecek.lolkek.model.MemRepository;
import com.bacecek.lolkek.navigation.AppRouter;
import com.bacecek.lolkek.navigation.Screen;
import com.bacecek.lolkek.view.MemView;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
@InjectViewState
public class MemPresenter extends BasePresenter<MemView> {
    private final AppRouter appRouter;
    private final MemRepository memRepository;

    @Inject
    public MemPresenter(AppRouter appRouter,MemRepository memRepository) {
        super(appRouter);
        this.appRouter = appRouter;
        this.memRepository = memRepository;
    }

    public void exampleMethodNavigate(){
        appRouter.navigateTo(Screen.SCREEN_MEM); //ВСЁ!
    }

    public void exampleMethodToView(){
      // getViewState().methodInView(); //ВСЁ!
    }
}
