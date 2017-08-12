package com.bacecek.lolkek.navigation;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bacecek.lolkek.navigation.command.BackTo;
import com.bacecek.lolkek.navigation.command.Forward;
import com.bacecek.lolkek.navigation.command.Replace;
import com.bacecek.lolkek.view.MemFragment;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.SystemMessage;

/**
 * @author alexandergartemov
 */
public class AppNavigator implements Navigator {

    private FragmentManager fragmentManager;
    private int mainContainer;
    private int secondContainer;
    private AppCompatActivity activity;

    public AppNavigator(AppCompatActivity appCompatActivity, int mainContainer) {
        this.fragmentManager = appCompatActivity.getSupportFragmentManager();
        this.mainContainer = mainContainer;
        this.activity = appCompatActivity;
    }

    @Override
    public void applyCommand(Command command) {
        if (command instanceof Forward) {
            Forward forward = (Forward) command;

            Fragment fragment = createFragment(forward.getScreenKey(), forward.getTransitionData());
            if (fragment == null) {
                unknownScreen(command);
                return;
            }
            fragmentManager
                    .beginTransaction()
                    .replace(mainContainer, fragment, forward.getScreenTag())
                    .addToBackStack(forward.getScreenTag())
                    .commit();


        } else if (command instanceof Back) {
            if (fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStackImmediate();
            } else {
                exit();
            }
        } else if (command instanceof Replace) {
            Replace replace = (Replace) command;
            Fragment fragment = createFragment(replace.getScreenKey(), replace.getTransitionData());
            if (fragment == null) {
                unknownScreen(command);
                return;
            }
            if (fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStackImmediate();
                fragmentManager
                        .beginTransaction()
                        .replace(mainContainer, fragment, replace.getScreenTag())
                        .addToBackStack(String.valueOf(replace.getScreenKey()))
                        .commit();
            } else {
                fragmentManager
                        .beginTransaction()
                        .replace(mainContainer, fragment, replace.getScreenTag())
                        .commit();
            }
        } else if (command instanceof BackTo) {
            Screen screen = ((BackTo) command).getScreen();

            if (screen == null) {
                backToRoot();
            } else {
                String key = screen.getTag();
                boolean hasScreen = false;
                for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
                    if (key.equals(fragmentManager.getBackStackEntryAt(i).getName())) {

                        fragmentManager.popBackStackImmediate(key, 0);
                        hasScreen = true;
                        break;
                    }
                }
                if (!hasScreen) {
                    backToUnexisting();
                }
            }
        } else if (command instanceof SystemMessage) {
            showSystemMessage(((SystemMessage) command).getMessage());
        }
    }


    private void backToRoot() {
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
            fragmentManager.popBackStack();
        }
        fragmentManager.executePendingTransactions();
    }

    private Fragment createFragment(int screenKey, Object data) {
        switch (screenKey) {
            case 1:
                return MemFragment.newInstance();
            default:
                return null;
        }
    }

    private void showSystemMessage(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    private void exit() {
        activity.finish();
    }

    private void backToUnexisting() {
        backToRoot();
    }

    private void unknownScreen(Command command) {
        this.applyCommand(new SystemMessage("Screen is not implemented"));
    }

}
