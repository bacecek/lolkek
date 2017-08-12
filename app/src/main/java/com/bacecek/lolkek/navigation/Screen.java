package com.bacecek.lolkek.navigation;


import com.bacecek.lolkek.R;

/**
 * @author alexandergartemov
 */
public enum Screen {
    //---------------------------------Available from drawer--------------------------------------//
    SCREEN_MEM(R.id.mem),

    SCREEN_CHOOSE_SPINNER(R.id.btn_lol);



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
