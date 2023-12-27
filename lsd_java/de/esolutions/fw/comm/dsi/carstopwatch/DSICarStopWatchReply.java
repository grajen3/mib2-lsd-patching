/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carstopwatch;

import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;

public interface DSICarStopWatchReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateStopWatchViewOptions(StopWatchViewOptions stopWatchViewOptions, int n) {
    }

    default public void updateStopWatchState(int n, int n2) {
    }

    default public void updateStopWatchCurrentLapNumber(int n, int n2) {
    }

    default public void updateStopWatchTotalTime(StopWatchTime stopWatchTime, int n) {
    }

    default public void updateStopWatchLastSplitTime(int n, StopWatchTime stopWatchTime, int n2) {
    }

    default public void updateStopWatchCurrentLapTime(StopWatchTime stopWatchTime, int n) {
    }

    default public void updateStopWatchLastLapTime(StopWatchTime stopWatchTime, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

