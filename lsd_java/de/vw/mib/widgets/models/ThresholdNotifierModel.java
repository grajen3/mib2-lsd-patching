/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.WidgetModel;

public interface ThresholdNotifierModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_VALUE;
    public static final int PID_VALUE_MIN;
    public static final int PID_VALUE_MAX;
    public static final int PID_COUNT_THRESHOLD;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_THRESHOLD;

    default public int get_value() {
    }

    default public void set_value(int n) {
    }

    default public int get_valueMin() {
    }

    default public void set_valueMin(int n) {
    }

    default public int get_valueMax() {
    }

    default public void set_valueMax(int n) {
    }

    default public int getLastValue() {
    }
}

