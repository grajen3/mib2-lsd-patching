/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.daynight;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.internal.system.daynight.DayNightServiceImpl;

class DayNightServiceImpl$2
extends DSIServiceStateListenerAdapter {
    private final /* synthetic */ DayNightServiceImpl this$0;

    DayNightServiceImpl$2(DayNightServiceImpl dayNightServiceImpl) {
        this.this$0 = dayNightServiceImpl;
    }

    @Override
    public void registered(String string, int n) {
        this.this$0.connectToDsi();
    }
}

