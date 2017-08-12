package com.bacecek.lolkek.navigation;


/**
 * @author alexandergartemov
 */
public enum Screen {
    //---------------------------------Available from drawer--------------------------------------//
    SCREEN_MEM(1),

    SCREEN_TWO(2);



    private int id;
    private int titleID;

    Screen(int id) {
        this.id = id;
        this.titleID = titleID;
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return String.valueOf(id);
    }

    public int getTitleID() {
        return titleID;
    }


    public interface OnToolbarClickListener {
        void onToolbarClicked();
    }
}
