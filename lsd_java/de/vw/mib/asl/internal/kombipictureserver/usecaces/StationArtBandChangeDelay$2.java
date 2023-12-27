/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.usecaces;

import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArtBandChangeDelay;

class StationArtBandChangeDelay$2
implements Runnable {
    private final /* synthetic */ byte val$timeoutId;
    private final /* synthetic */ StationArtBandChangeDelay this$0;

    StationArtBandChangeDelay$2(StationArtBandChangeDelay stationArtBandChangeDelay, byte by) {
        this.this$0 = stationArtBandChangeDelay;
        this.val$timeoutId = by;
    }

    @Override
    public void run() {
        this.this$0.processTimeout(this.val$timeoutId);
    }
}

