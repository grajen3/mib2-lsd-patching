/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.daynight;

import de.vw.mib.asl.internal.impl.system.VehicleStatesListenerAdapter;
import de.vw.mib.asl.internal.system.daynight.DayNightServiceImpl;

class DayNightServiceImpl$1
extends VehicleStatesListenerAdapter {
    private final /* synthetic */ DayNightServiceImpl this$0;

    DayNightServiceImpl$1(DayNightServiceImpl dayNightServiceImpl) {
        this.this$0 = dayNightServiceImpl;
    }

    @Override
    public void updateDisplayDayNightDesign(boolean bl, int n) {
        int n2 = bl ? 2 : 1;
        this.this$0.updateDayNightModeSenorValue(n2);
    }
}

