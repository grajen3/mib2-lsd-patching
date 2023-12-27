/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface TimerWidgetController
extends WidgetController {
    public static final String IN_STARTTIMER_NAME;
    public static final String IN_STOPTIMER_NAME;
    public static final String OUT_TIMERELAPSED_NAME;

    default public void fire_startTimer() {
    }

    default public void fire_stopTimer() {
    }

    default public void fire_timerElapsed() {
    }
}

