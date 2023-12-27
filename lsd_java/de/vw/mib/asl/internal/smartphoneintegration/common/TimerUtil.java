/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.common;

import de.vw.mib.genericevents.AbstractTarget;

public class TimerUtil {
    public static final int TIMEOUT_DEVICELIST;
    public static final int TIMEOUT_UPDATE_DISCOVERED_DEVICES_BUS_RESET_WAIT;
    public static final int TIMEOUT_DEVICE_SWITCH_WAIT;
    public static final int TIMEOUT_CONNECTION_STATE_RESET;
    public static final int TIMEOUT_MIRRORLINK_CONNECTION_WAIT;

    public static void startTimer(AbstractTarget abstractTarget, int n, int n2) {
        if (!abstractTarget.getTimerServer().isTimerActive(abstractTarget.getTargetId(), n)) {
            abstractTarget.startTimer(n, (long)n2, false);
        } else {
            abstractTarget.restartTimer(n);
        }
    }

    public static void stopTimer(AbstractTarget abstractTarget, int n) {
        if (abstractTarget.getTimerServer().isTimerActive(abstractTarget.getTargetId(), n)) {
            abstractTarget.stopTimer(n);
        }
    }
}

