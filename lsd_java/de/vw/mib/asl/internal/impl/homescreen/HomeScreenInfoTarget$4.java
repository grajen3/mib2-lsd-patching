/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.api.system.clock.DateTimeListener;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenInfoTarget;

class HomeScreenInfoTarget$4
implements DateTimeListener {
    private final /* synthetic */ HomeScreenInfoTarget this$0;

    HomeScreenInfoTarget$4(HomeScreenInfoTarget homeScreenInfoTarget) {
        this.this$0 = homeScreenInfoTarget;
    }

    @Override
    public void updateTime(byte by, byte by2, byte by3) {
        this.this$0.updateTimeDatapool(by, by2, by3);
    }

    @Override
    public void updateDate(short s, byte by, byte by2) {
        this.this$0.updateDateDatapool(s, by, by2);
    }
}

