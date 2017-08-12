package com.bacecek.lolkek.data;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class MemFactory {

    private String defaultMem = "http://i0.kym-cdn.com/photos/images/newsfeed/000/573/007/58e.gif";
    private String[] memes= new String[]
    {
        "https://pp.userapi.com/c7008/v7008418/508bd/HjHqZoPGaRk.jpg",
                "https://cs541607.userapi.com/c836635/v836635062/64829/MSBQAByrtqY.jpg",
                "https://cs541607.userapi.com/c836635/v836635288/521bf/YGNTL79937c.jpg",
                "https://pp.userapi.com/c7008/v7008503/47fbd/NF-HBxtccWA.jpg",
                "https://pp.userapi.com/c7008/v7008351/51602/7TMUkU28l3c.jpg",
                "https://pp.userapi.com/c7008/v7008874/4b282/ddWWJLHgjbQ.jpg",
                "https://pp.userapi.com/c7008/v7008129/fc27a/EKe5U3Hk5eQ.jpg",
                "https://pp.userapi.com/c7008/v7008843/4a965/i2YcdIuFIH0.jpg",
                "https://pp.userapi.com/c7008/v7008771/6a148/TQ_5dZc13Ok.jpg",
                "https://pp.userapi.com/c7008/v7008013/57243/a7-FdsKBiFQ.jpg",
                "https://pp.userapi.com/c7008/v7008447/5c154/jDMtI2XNBoE.jpg",
                "https://pp.userapi.com/c7008/v7008603/4bdaf/H0gFKgxQbb4.jpg",
                "https://pp.userapi.com/c7008/v7008170/5667e/RvVDpjQIkuc.jpg",
                "https://pp.userapi.com/c7008/v7008172/53e3d/PVWaNJ0Z3lg.jpg",
                "https://pp.userapi.com/c7008/v7008466/408e9/p-cVh8ebPfw.jpg",
                "https://pp.userapi.com/c7008/v7008410/3d8e4/2oVpwYvigek.jpg",
                "https://pp.userapi.com/c7008/v7008834/65d93/04v4fSj-JYo.jpg",
                "https://pp.userapi.com/c7008/v7008011/54145/yHX2bN-tXzM.jpg",
                "https://pp.userapi.com/c7008/v7008039/5c1ea/ABNRWntxyM4.jpg",
                "https://pp.userapi.com/c7008/v7008388/92043/K-7L-CZl4M8.jpg",
                "https://pp.userapi.com/c841026/v841026554/11e19/YBISplFDaW8.jpg",
                "https://pp.userapi.com/c543106/v543106443/40040/VVZ5iPzDhxg.jpg",
                "https://pp.userapi.com/c837530/v837530638/60f7d/8Obmn5vgqqM.jpg",
                "https://pp.userapi.com/c837530/v837530251/526f5/RFnmeaXQFK8.jpg",
                "https://pp.userapi.com/c543106/v543106647/44528/gkBTXFYU9WQ.jpg",
                "https://pp.userapi.com/c837527/v837527884/4eb5c/a-Q9Uxxevo0.jpg",
                "https://pp.userapi.com/c841023/v841023954/a82d/ygN5ucqGDzI.jpg",
                "https://pp.userapi.com/c837527/v837527460/5200f/KEKlbepApZg.jpg",
                "https://pp.userapi.com/c837527/v837527076/46960/kEgGgxk0Mc4.jpg",
                "https://cs541607.userapi.com/c836428/v836428032/416f8/F0cRXmOtlEg.jpg",
                "https://pp.userapi.com/c837627/v837627951/48e67/djaPS0md0HI.jpg",
                "https://pp.userapi.com/c837627/v837627944/59f5e/4s7oeNN_gQc.jpg",
                "https://pp.userapi.com/c837627/v837627529/533b6/EVn9XASW-T0.jpg",
                "https://pp.userapi.com/c543106/v543106704/24813/V5ZGIftHuf4.jpg",
                "https://pp.userapi.com/c837627/v837627532/55fb8/yrLtQmQ3uVI.jpg"};

    @Inject
    public MemFactory() {
    }

    public String getMemOfTime(long timestamp) {
        long time = timestamp % 35000;
        int memInd=0;

        return memes[memInd];
    }
}
