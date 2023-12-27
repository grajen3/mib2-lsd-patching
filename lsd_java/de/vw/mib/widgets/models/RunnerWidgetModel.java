/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.models.WidgetModel;

public interface RunnerWidgetModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_MODE;
    public static final int PID_OUTPUT_REFERENCES;
    public static final int PID_SYNC_TIMES;
    public static final int PID_TIME_SPAN;
    public static final int PID_UPDATE_INTERVAL;
    public static final int PID_UNBOUNDED;
    public static final int PID_VALUE;
    public static final int PID_VALUE_MAX;
    public static final int PID_VALUE_MIN;
    public static final int PID_COUNT_RUNNER;
    public static final int SID_BASE;
    public static final int SID_UNBOUNDED;
    public static final int SID_PROPAGATE_VALUE_CHANGE;
    public static final int SID_COUNT_RUNNER_WIDGET;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_VALUE_CHANGE;
    public static final int EASING_INDEX_COUNT_RUNNER;
    public static final int MODE_NORMAL;
    public static final int MODE_COUNTDOWN;
    public static final int TIMER_STATUS_OFF;
    public static final int TIMER_STATUS_ON;
    public static final int SYNC_TIMES_IDX_TIMER_STATUS;
    public static final int SYNC_TIMES_IDX_STOP_TIME;
    public static final int SYNC_TIMES_IDX_SYSTEM_TIME;
    public static final int SYNC_TIMES_COUNT;

    default public int get_mode() {
    }

    default public void set_mode(int n) {
    }

    default public Adjustable[] get_outputReferences() {
    }

    default public void set_outputReferences(Adjustable[] adjustableArray) {
    }

    default public int[] get_syncTimes() {
    }

    default public void set_syncTimes(int[] nArray) {
    }

    default public int get_timeSpan() {
    }

    default public void set_timeSpan(int n) {
    }

    default public boolean is_unbounded() {
    }

    default public void set_unbounded(boolean bl) {
    }

    default public int get_updateInterval() {
    }

    default public void set_updateInterval(int n) {
    }

    default public int get_value() {
    }

    default public void set_value(int n) {
    }

    default public int get_valueMax() {
    }

    default public void set_valueMax(int n) {
    }

    default public int get_valueMin() {
    }

    default public void set_valueMin(int n) {
    }

    default public void setPropagateValueChange(boolean bl) {
    }

    default public int getInternalTime() {
    }

    default public int getSystimeOnTimerStop() {
    }

    default public boolean isTimeRunning() {
    }

    default public void resetValue() {
    }

    default public void start() {
    }

    default public void stop() {
    }
}

