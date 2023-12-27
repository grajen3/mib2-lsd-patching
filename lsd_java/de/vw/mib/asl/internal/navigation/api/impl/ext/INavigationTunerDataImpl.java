/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

import de.vw.mib.asl.api.navigation.traffic.INavigationTunerData;

public class INavigationTunerDataImpl
implements INavigationTunerData {
    String stationName;
    long frequency;

    public INavigationTunerDataImpl(String string, long l) {
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

