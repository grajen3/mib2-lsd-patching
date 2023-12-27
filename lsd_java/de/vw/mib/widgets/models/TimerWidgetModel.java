/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.WidgetModel;

public interface TimerWidgetModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_DURATION_START;
    public static final int PID_DURATION_RESTART;
    public static final int PID_AUTO_START;
    public static final int PID_TIMER_RUNNING;
    public static final int PID_COUNT_TIMERWIDGET;
    public static final int SID_BASE;
    public static final int SID_AUTOSTART;
    public static final int SID_TIMER_RUNNING;
    public static final int SID_COUNT_TIMERWIDGET;

    default public boolean is_autoStart() {
    }

    default public void set_autoStart(boolean bl) {
    }

    default public int get_durationStart() {
    }

    default public void set_durationStart(int n) {
    }

    default public int get_durationRestart() {
    }

    default public void set_durationRestart(int n) {
    }

    default public void set_timerRunning(boolean bl) {
    }

    default public boolean is_timerRunning() {
    }
}

