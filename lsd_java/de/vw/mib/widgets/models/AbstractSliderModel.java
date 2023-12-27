/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.AbstractButtonModel;

public interface AbstractSliderModel
extends AbstractButtonModel {
    public static final int PID_BASE;
    public static final int PID_VALUE;
    public static final int PID_VALUE_MIN;
    public static final int PID_VALUE_MAX;
    public static final int PID_PADDING_MIN;
    public static final int PID_PADDING_MAX;
    public static final int PID_STEP;
    public static final int PID_ORIENTATION;
    public static final int PID_WRAP_FLAG;
    public static final int PID_COUNT_ABSTRACT_SLIDER;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_ABSTRACT_SLIDER;
    public static final int SID_BASE;
    public static final int SID_COUNT_ABSTRACT_SLIDER;
    public static final int ORIENTATION_HORIZONTAL_LEFT;
    public static final int ORIENTATION_HORIZONTAL_RIGHT;
    public static final int ORIENTATION_VERTICAL_TOP;
    public static final int ORIENTATION_VERTICAL_BOTTOM;
    public static final int OUTSIDE_AHEAD;
    public static final int OUTSIDE_BEHIND;

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

    default public int get_paddingMin() {
    }

    default public void set_paddingMin(int n) {
    }

    default public int get_paddingMax() {
    }

    default public void set_paddingMax(int n) {
    }

    default public int get_step() {
    }

    default public void set_step(int n) {
    }

    default public int get_orientation() {
    }

    default public void set_orientation(int n) {
    }

    default public float getScaleRatio() {
    }

    default public void setScaleRatio(float f2) {
    }

    default public void setScalePosition(int n) {
    }

    default public int getScalePosition() {
    }

    default public int updatePosition(int n, int n2, boolean bl) {
    }

    default public boolean is_wrapFlag() {
    }

    default public void set_wrapFlag(boolean bl) {
    }

    default public void setPositionOnScrollbarButton(int n, int n2) {
    }

    default public int getPositionOnScrollbarButton() {
    }

    default public void startValueChangeShadowTimer() {
    }

    default public void stopValueChangeShadowTimer(boolean bl) {
    }
}

