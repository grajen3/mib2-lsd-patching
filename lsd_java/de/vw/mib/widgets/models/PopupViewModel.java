/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.interfaces.CompositeBackground;
import de.vw.mib.widgets.models.ViewModel;

public interface PopupViewModel
extends ViewModel,
CompositeBackground {
    public static final int PID_BASE;
    public static final int PID_VISIBLE_AREA;
    public static final int PID_VISIBLE_AREA_ALIGNMENT;
    public static final int PID_COMPOSITE_BACKGROUND_IMAGES;
    public static final int PID_COMPOSITE_BACKGROUND_COLORS;
    public static final int PID_COMPOSITE_BACKGROUND_MODE;
    public static final int PID_COMPOSITE_BACKGROUND_ARROW_OFFSET_X;
    public static final int PID_COMPOSITE_BACKGROUND_ARROW_OFFSET_Y;
    public static final int PID_RESTRICTION_MODE;
    public static final int PID_COUNT_POPUPVIEW;
    public static final int SID_BASE;
    public static final int SID_COUNT_POPUP_VIEW;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_POPUP_VIEW;
    public static final int VISIBLEAREAALIGNMENT_MANUAL;
    public static final int VISIBLEAREAALIGNMENT_HORIZONTAL;
    public static final int VISIBLEAREAALIGNMENT_VERTICAL;
    public static final int VISIBLEAREAALIGNMENT_BOTH;
    public static final int RESTRICTIONMODE_NONE;
    public static final int RESTRICTIONMODE_FULL;

    default public Rectangle get_visibleArea() {
    }

    default public void set_visibleArea(Rectangle rectangle) {
    }

    default public void set_visibleAreaAlignment(int n) {
    }

    default public int get_visibleAreaAlignment() {
    }

    default public int get_restrictionMode() {
    }

    default public void set_restrictionMode(int n) {
    }
}

