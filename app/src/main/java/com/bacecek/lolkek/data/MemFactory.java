package com.bacecek.lolkek.data;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class MemFactory {

    private String defaultMem = "http://i0.kym-cdn.com/photos/images/newsfeed/000/573/007/58e.gif";

    @Inject
    public MemFactory() {
    }

    public String  getMemOfTime(long timestamp){
        return defaultMem;
    }
}
