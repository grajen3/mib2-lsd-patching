/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.BackgroundContainerModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.InputFieldModel;
import de.vw.mib.widgets.models.WidgetModel;

public interface PreviewLineModel
extends BackgroundContainerModel {
    public static final int PID_BASE;
    public static final int PID_CONTENT_REFS;
    public static final int PID_CONTENT_BACKGROUND_MODES;
    public static final int PID_INPUT_FIELD_REF;
    public static final int PID_INACTIVE_AREA_REF;
    public static final int PID_HIDE_AUTOMATICALLY;
    public static final int PID_COUNT_PREVIEW_LINE;
    public static final int CONTENT_INDEX_INITIAL;
    public static final int CONTENT_INDEX_HIDDEN;
    public static final int CONTENT_INDEX_HISTORY;
    public static final int CONTENT_INDEX_PREVIEW;
    public static final int CONTENT_INDEX_RESULT;
    public static final int CONTENT_INDEX_COUNT;
    public static final int SID_BASE;
    public static final int SID_HIDE_AUTOMATICALLY;
    public static final int SID_COUNT_PREVIEW_LINE;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_RESIZE_BACKGROUND;
    public static final int EASING_INDEX_COUNT_PREVIEW_LINE;

    default public WidgetModel[] get_contentRefs() {
    }

    default public void set_contentRefs(WidgetModel[] widgetModelArray) {
    }

    default public void set_contentBackgroundModes(int[] nArray) {
    }

    default public int[] get_contentBackgroundModes() {
    }

    default public void set_hideAutomatically(boolean bl) {
    }

    default public boolean is_hideAutomatically() {
    }

    default public InputFieldModel get_inputFieldRef() {
    }

    default public void set_inputFieldRef(InputFieldModel inputFieldModel) {
    }

    default public InactiveAreaModel get_inactiveAreaRef() {
    }

    default public void set_inactiveAreaRef(InactiveAreaModel inactiveAreaModel) {
    }

    default public void showContent(int n) {
    }

    default public int getActiveContent() {
    }
}

