/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import org.dsi.ifc.sdars.StationInfo;

public interface ChannelFilter {
    default public boolean checkChannel(StationInfo stationInfo) {
    }
}

