package com.bacecek.lolkek.navigation.command;


import com.bacecek.lolkek.navigation.Screen;

import ru.terrakok.cicerone.commands.Command;

/**
 * @author alexandergartemov
 */
public class Forward implements Command {
    private Screen screen;
    private Object transitionData;

    public Forward(Screen screen, Object transitionData) {
        this.screen = screen;
        this.transitionData = transitionData;
    }

    public int getScreenKey() {
        return screen.getId();
    }

    public String getScreenTag() {
        return screen.getTag();
    }

    public Screen getScreen() {return screen;}
    
    public Object getTransitionData() {
        return transitionData;
    }
}
