/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.api.system.daynight.DayNightListener;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiTargetHSM;

class MapViewerKombiTargetHSM$1
implements DayNightListener {
    private final /* synthetic */ MapViewerKombiTargetHSM this$0;

    MapViewerKombiTargetHSM$1(MapViewerKombiTargetHSM mapViewerKombiTargetHSM) {
        this.this$0 = mapViewerKombiTargetHSM;
    }

    @Override
    public void onDayNightModeSensorValueChanged(int n) {
        int n2 = this.this$0.datapool.getDayNightModeMainMap();
        if (n2 == 2) {
            boolean bl = this.this$0.convertDayNightSensorValueToIsNightBoolean(n);
            this.this$0.changeDayNightMode(bl);
        }
    }
}

