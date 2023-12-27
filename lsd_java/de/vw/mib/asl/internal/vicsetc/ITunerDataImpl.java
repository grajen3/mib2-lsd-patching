/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.vicsetc.ITunerData;

public class ITunerDataImpl
implements ITunerData {
    String stationName;
    long frequency;

    public ITunerDataImpl(String string, long l) {
        this.stationName = string;
        this.frequency = l;
    }

    @Override
    public String getStationName() {
        return this.stationName;
    }

    @Override
    public long getFrequency() {
        return this.frequency;
    }
}

