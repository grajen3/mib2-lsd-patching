/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.interfaces.PushUpHandler;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.ListModel;
import de.vw.mib.widgets.models.PushUpModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public interface ControlBarModel
extends ListModel,
PushUpHandler {
    public static final int PID_BASE;
    public static final int PID_INACTIVE_AREA_REF;
    public static final int PID_LAYOUT_AUTOMATICALLY;
    public static final int PID_LAYOUT_ATTRIBS_LIST;
    public static final int PID_PUSH_UP_REFS;
    public static final int PID_PUSH_UP_REFS_GROUPS;
    public static final int PID_BUTTON_RESOURCE_CONTROL_ENABLED;
    public static final int PID_VISIBLE_BUTTON_COUNT;
    public static final int PID_VISIBLE_BUTTON_INDEX;
    public static final int PID_BUTTON_BACKGROUND_IMAGES;
    public static final int PID_COUNT_CONTROL_BAR;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_CONTROLBAR;
    public static final int SID_BASE;
    public static final int SID_LAYOUT_AUTOMATICALLY;
    public static final int SID_BUTTON_RESOURCE_CONTROL_ENABLED;
    public static final int SID_COUNT_CONTROL_BAR;

    default public InactiveAreaModel get_inactiveAreaRef() {
    }

    default public void set_inactiveAreaRef(InactiveAreaModel inactiveAreaModel) {
    }

    default public boolean is_layoutAutomatically() {
    }

    default public void set_layoutAutomatically(boolean bl) {
    }

    default public LayoutAttribs[] get_layoutAttribsList() {
    }

    default public void set_layoutAttribsList(LayoutAttribs[] layoutAttribsArray) {
    }

    default public PushUpModel[] get_pushUpRefs() {
    }

    default public void set_pushUpRefs(PushUpModel[] pushUpModelArray) {
    }

    default public int[] get_pushUpRefsGroups() {
    }

    default public void set_pushUpRefsGroups(int[] nArray) {
    }

    default public void set_buttonResourceControlEnabled(boolean bl) {
    }

    default public boolean is_buttonResourceControlEnabled() {
    }

    default public void set_visibleButtonCount(int n) {
    }

    default public int get_visibleButtonCount() {
    }

    default public void set_visibleButtonIndex(int n) {
    }

    default public int get_visibleButtonIndex() {
    }

    default public void set_buttonBackgroundImages(Image[] imageArray) {
    }

    default public Image[] get_buttonBackgroundImages() {
    }

    default public List getActiveChildren() {
    }

    default public void setCurrentActiveWidget(WidgetModel widgetModel) {
    }

    default public WidgetModel getCurrentActiveWidget() {
    }

    @Override
    default public void close() {
    }
}

