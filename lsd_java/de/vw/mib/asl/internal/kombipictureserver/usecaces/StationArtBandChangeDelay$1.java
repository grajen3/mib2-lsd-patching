/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.usecaces;

import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArtBandChangeDelay;
import de.vw.mib.datapool.ASLDatapoolObserver;

class StationArtBandChangeDelay$1
implements ASLDatapoolObserver {
    private final /* synthetic */ StationArtBandChangeDelay this$0;

    StationArtBandChangeDelay$1(StationArtBandChangeDelay stationArtBandChangeDelay) {
        this.this$0 = stationArtBandChangeDelay;
    }

    @Override
    public void datapoolValueChanged(int n) {
        if (1324 != n) {
            return;
        }
        this.this$0.enableDelayTimer();
    }
}

