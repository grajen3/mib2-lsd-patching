/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface RunnerWidgetController
extends WidgetController {
    public static final String IN_RESET_NAME;
    public static final String IN_START_NAME;
    public static final String IN_STOP_NAME;
    public static final String IN_STOPSPLITTIME_NAME;
    public static final String IN_STOPPROPAGATEVALUECHANGE_NAME;
    public static final String IN_STARTPROPAGATEVALUECHANGE_NAME;
    public static final String OUT_STOPPED_NAME;
    public static final String OUT_STARTED_NAME;
    public static final String OUT_SENDSPLITTIME_NAME;
    public static final String OUT_SENDCURRENTTIME_NAME;
    public static final String OUT_SENDCURRENTSYSTEMTIME_NAME;

    default public void fire_reset() {
    }

    default public void fire_start() {
    }

    default public void fire_stop() {
    }

    default public void fire_stopSplitTime() {
    }

    default public void fire_startPropagateValueChange() {
    }

    default public void fire_stopPropagateValueChange() {
    }

    default public void fire_sendCurrentTime() {
    }

    default public void fire_sendCurrentSystemTime() {
    }

    default public void fire_sendSplitTime() {
    }

    default public void fire_stopped() {
    }

    default public void fire_started() {
    }
}

