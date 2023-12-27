/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

final class Events {
    static final int EV_SYNC_LOST;
    static final int EV_SYNC_SUCCESS;
    static final int EV_SELECT_SERVICE;
    static final int P_SELECTSERVICE_SID;
    static final int P_SELECTSERVICE_SCIDI;
    static final int EV_TIMER_WAITING1;
    static final long TIMEOUT_WAITING1;
    static final int EV_TIMER_WAITING2;
    static final long TIMEOUT_WAITING2;
    static final int EV_TIMER_NOTEXT1;
    static final long TIMEOUT_NOTEXT1;
    static final int EV_TIMER_TEXT1;
    static final long DEFAULT_TIMEOUT;
    static long thresholdTIMEOUT;
    static boolean thresholdExceeded;
    static final int EV_TIMER_NO_UPDATE;
    static final long TIMEOUT_NO_UPDATE;
    static final int EV_TIMER_SYNC_LOST;
    static final long TIMEOUT_SYNC_LOST;
    static final int EV_TIMER_DEBOUNCE_RT;
    static final long TIMEOUT_DEBOUNCE_RT;
    static final int EV_TIMER_SYNC_LOST_RTPLUS;
    static final long TIMEOUT_SYNC_LOST_RTPLUS;

    Events() {
    }

    static {
        thresholdTIMEOUT = 0;
        thresholdExceeded = false;
    }
}

