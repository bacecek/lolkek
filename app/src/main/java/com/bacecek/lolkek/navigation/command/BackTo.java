package com.bacecek.lolkek.navigation.command;


import com.bacecek.lolkek.navigation.Screen;

import ru.terrakok.cicerone.commands.Command;

/**
 *
 */
public class BackTo implements Command {

    private Screen screen;

    public BackTo(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
}
