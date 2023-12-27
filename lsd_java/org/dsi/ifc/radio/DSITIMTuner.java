/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIBase;

public interface DSITIMTuner
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_TIMMESSAGELIST;
    public static final int ATTR_TIMSTATUS;
    public static final int ATTR_TIMMEMOUSAGE;
    public static final int ATTR_TIMAVAILABLE;
    public static final int TIMSTATUS_UNDEFINED;
    public static final int TIMSTATUS_STOP;
    public static final int TIMSTATUS_PLAY;
    public static final int TIMSTATUS_PAUSE;
    public static final int TIMSTATUS_FAST_FORWARD;
    public static final int TIMSTATUS_FAST_BACKWARD;
    public static final int TIMSTATUS_RECORD;
    public static final int TIMPLAYBACKMODE_UNDEFINED;
    public static final int TIMPLAYBACKMODE_STOP;
    public static final int TIMPLAYBACKMODE_PLAY;
    public static final int TIMPLAYBACKMODE_PAUSE;
    public static final int TIMPLAYBACKMODE_FAST_FORWARD;
    public static final int TIMPLAYBACKMODE_FAST_BACKWARD;
    public static final int TIMPLAYBACKMETHODSTATUS_UNDEFINED;
    public static final int TIMPLAYBACKMETHODSTATUS_RUNNING;
    public static final int TIMPLAYBACKMETHODSTATUS_DONE;
    public static final int TIMPLAYBACKMETHODSTATUS_INVALID;
    public static final int TIMPLAYBACKMETHODSTATUS_TIM_NOT_AVAILABLE;
    public static final int TIMRESETTYPE_UNDEFINED;
    public static final int TIMRESETTYPE_TO_DEFAULT;
    public static final int TIMRESETTYPE_ANONYMIZE;
    public static final int TIMAVAILABLE_UNDEFINED;
    public static final int TIMAVAILABLE_NO;
    public static final int TIMAVAILABLE_DEVICE_ONLY;
    public static final int TIMAVAILABLE_YES;
    public static final int RT_PLAYBACK;
    public static final int RT_RESET;
    public static final int RT_JUMPPLAYBACK;
    public static final int RP_PLAYBACK;

    default public void playback(int n, int n2) {
    }

    default public void reset(int n) {
    }

    default public void jumpPlayback(int n) {
    }
}

