package com.bacecek.lolkek.navigation;

import com.bacecek.lolkek.navigation.command.BackTo;
import com.bacecek.lolkek.navigation.command.Forward;
import com.bacecek.lolkek.navigation.command.NotifyDrawer;
import com.bacecek.lolkek.navigation.command.Replace;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.terrakok.cicerone.Router;

/**
 * @author alexandergartemov
 */
@Singleton
public class AppRouter extends Router {
    @Inject
    public AppRouter() {
    }

    public void notifyDrawerToolbar(Screen screen) {
        executeCommand(new NotifyDrawer(screen));
    }

    public void navigateTo(Screen screen) {
        navigateTo(screen, null);
    }

    public void navigateTo(Screen screen, Object data) {
        executeCommand(new Forward(screen, data));
    }

    public void newRootScreen(Screen screen) {
        executeCommand(new BackTo(null));
        executeCommand(new Replace(screen, null));
    }

}
