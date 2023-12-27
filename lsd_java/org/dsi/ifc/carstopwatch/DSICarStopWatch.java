/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carstopwatch;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carstopwatch.StopWatchTime;

public interface DSICarStopWatch
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_STOPWATCHVIEWOPTIONS;
    public static final int ATTR_STOPWATCHSTATE;
    public static final int ATTR_STOPWATCHCURRENTLAPNUMBER;
    public static final int ATTR_STOPWATCHTOTALTIME;
    public static final int ATTR_STOPWATCHLASTSPLITTIME;
    public static final int ATTR_STOPWATCHCURRENTLAPTIME;
    public static final int ATTR_STOPWATCHLASTLAPTIME;
    public static final int RT_SETSTOPWATCHFASTESTLAPTIME;
    public static final int RT_SETSTOPWATCHLAPRATING;
    public static final int RT_SETSTOPWATCHLAPPROGRESS;
    public static final int RT_SETSTOPWATCHLAPGPSTRIGGER;
    public static final int RT_SETSTOPWATCHCONTROL;
    public static final int RT_SETSTOPWATCHSLOWESTLAPTIME;
    public static final int STOPWATCHLAPRATING_NOT_ACTIVE;
    public static final int STOPWATCHLAPRATING_SLOWER;
    public static final int STOPWATCHLAPRATING_SAME_PACE;
    public static final int STOPWATCHLAPRATING_FASTER;
    public static final int STOPWATCHLAPRATING_INIT;
    public static final int STOPWATCHLAPRATING_NOT_SUPPORTED;
    public static final int STOPWATCHCOMMAND_INIT;
    public static final int STOPWATCHCOMMAND_START;
    public static final int STOPWATCHCOMMAND_START_MOVING_VEHICLE;
    public static final int STOPWATCHCOMMAND_STOP;
    public static final int STOPWATCHCOMMAND_CONTINUE;
    public static final int STOPWATCHCOMMAND_RESET;
    public static final int STOPWATCHCOMMAND_SPLITTIME;
    public static final int STOPWATCHCOMMAND_LAPTIME;
    public static final int STOPWATCHSTATE_INIT;
    public static final int STOPWATCHSTATE_RUNNING;
    public static final int STOPWATCHSTATE_NOT_RUNNING;
    public static final int STOPWATCHSTATE_NOT_RUNNING_RESET;
    public static final int STOPWATCHSTATE_NOT_RUNNING_NO_RESET;

    default public void setStopWatchFastestLapTime(StopWatchTime stopWatchTime) {
    }

    default public void setStopWatchLapRating(int n) {
    }

    default public void setStopWatchLapProgress(float f2) {
    }

    default public void setStopWatchLapGPSTrigger() {
    }

    default public void setStopWatchControl(int n) {
    }

    default public void setStopWatchSlowestLapTime(StopWatchTime stopWatchTime) {
    }
}

