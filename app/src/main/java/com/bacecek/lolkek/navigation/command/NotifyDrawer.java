package com.bacecek.lolkek.navigation.command;


import com.bacecek.lolkek.navigation.Screen;

import ru.terrakok.cicerone.commands.Command;

/**
 * @author alexandergartemov
 */
public class NotifyDrawer implements Command {
    
    private Screen screen;
    private String title;
    
    public NotifyDrawer(Screen screen, String title){
        this.screen = screen;
        this.title = title;
    }
    
    public NotifyDrawer(Screen screen){
        this.screen = screen;
    }
    
    public int getScreenKey() {
        return screen.getId();
    }

    public String getScreenTag() {
        return screen.getTag();
    }

    public Screen getScreen() {return screen;}
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
}
