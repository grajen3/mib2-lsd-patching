/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carstopwatch;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;

public interface DSICarStopWatchListener
extends DSIListener {
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
}

