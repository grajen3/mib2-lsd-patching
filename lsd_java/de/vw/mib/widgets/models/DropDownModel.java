/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.PushUpModel;
import de.vw.mib.widgets.models.WidgetListModel;

public interface DropDownModel
extends PushUpModel {
    public static final int PID_BASE;
    public static final int PID_CLOSE_AUTOMATICALLY;
    public static final int PID_DROP_DOWN_LIST_REF;
    public static final int PID_LAYOUT_ALIGNMENT;
    public static final int PID_LAYOUT_AUTOMATICALLY;
    public static final int PID_Y_OFFSET;
    public static final int PID_COUNT_DROPDOWN;
    public static final int SID_BASE;
    public static final int SID_CLOSE_AUTOMATICALLY;
    public static final int SID_LAYOUT_AUTOMATICALLY;
    public static final int SID_COUNT_DROPDOWN;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_DROPDOWN;
    public static final int LAYOUT_ALIGMENT_BASE;
    public static final int LAYOUT_ALIGMENT_CENTER;
    public static final int LAYOUT_ALIGMENT_TOP;
    public static final int LAYOUT_ALIGMENT_BOTTOM;
    public static final int LAYOUT_ALIGMENT_COUNT_DROPDOWN;
    public static final int SCALINGPIVOT_BASE;
    public static final int SCALINGPIVOT_ACTIVE_BUTTON;
    public static final int SCALINGPIVOT_DROPDOWN_COUNT;

    default public boolean is_closeAutomatically() {
    }

    default public void set_closeAutomatically(boolean bl) {
    }

    default public WidgetListModel get_dropDownListRef() {
    }

    default public void set_dropDownListRef(WidgetListModel widgetListModel) {
    }

    default public int get_layoutAlignment() {
    }

    default public void set_layoutAlignment(int n) {
    }

    default public boolean is_layoutAutomatically() {
    }

    default public void set_layoutAutomatically(boolean bl) {
    }

    default public int get_yOffset() {
    }

    default public void set_yOffset(int n) {
    }

    default public Rectangle getAutoLayoutArea() {
    }

    default public void setAutoLayoutArea(Rectangle rectangle) {
    }

    default public Rectangle getFlyingWindowOpeningArea() {
    }

    default public void setFlyingWindowOpeningArea(int n, int n2, int n3, int n4) {
    }
}

