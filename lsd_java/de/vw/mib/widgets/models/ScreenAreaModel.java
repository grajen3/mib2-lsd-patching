/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.TransformContainerModel;

public interface ScreenAreaModel
extends TransformContainerModel {
    public static final int PID_BASE;
    public static final int PID_VIEW_ALIGNMENT;
    public static final int PID_VIEW_TYPES_ANIMATABLE;
    public static final int PID_VIEW_TYPES_ALIGNMENT;
    public static final int PID_SCALEMODE;
    public static final int PID_COUNT_SCREEN_AREA;
    public static final int VIEW_ALIGNMENT_NONE;
    public static final int VIEW_ALIGNMENT_LEFT;
    public static final int VIEW_ALIGNMENT_RIGHT;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_MOVE_IN_VIEW;
    public static final int EASING_INDEX_MOVE_OUT_VIEW;
    public static final int EASING_INDEX_COUNT_SCREEN_AREA;
    public static final int SID_BASE;
    public static final int SID_COUNT_SCREEN_AREA;
    public static final int SCALEMODE_DISABLED;
    public static final int SCALEMODE_FIT;
    public static final int SCALEMODE_FILL;

    default public void set_viewAlignment(int n) {
    }

    default public int get_viewAlignment() {
    }

    default public void set_viewTypesAnimatable(int[] nArray) {
    }

    default public int[] get_viewTypesAnimatable() {
    }

    default public void set_viewTypesAlignment(int[] nArray) {
    }

    default public int[] get_viewTypesAlignment() {
    }

    default public void set_scalemode(int n) {
    }

    default public int get_scalemode() {
    }
}

