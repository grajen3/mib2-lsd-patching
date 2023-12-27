/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.models.AbstractSliderModel;
import de.vw.mib.widgets.models.StaticImageModel;

public interface ScrollbarModel
extends AbstractSliderModel,
Adjustable,
AdjustmentListener {
    public static final int PID_BASE;
    public static final int PID_IMAGES_SCROLLBAR;
    public static final int PID_COLORS_SCROLLBAR;
    public static final int PID_IMAGE_SCROLLBAR_REF;
    public static final int PID_ADJUSTABLE_WIDGET_REF;
    public static final int PID_JUMP;
    public static final int PID_START_TIME;
    public static final int PID_REPEAT_TIME;
    public static final int PID_MIN_SCROLLBAR_SIZE;
    public static final int PID_STEP_VALUES;
    public static final int PID_PAGE_SIZE;
    public static final int PID_VISIBILITY_MODE;
    public static final int PID_COUNT_SCROLLBAR;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_SCROLLBAR;
    public static final int SID_BASE;
    public static final int SID_JUMP;
    public static final int SID_COUNT_SCROLLBAR;
    public static final int VISIBILITYMODE_ALWAYS_OFF;
    public static final int VISIBILITYMODE_ALWAYS_ON;
    public static final int VISIBILITYMODE_AUTO_ALL;
    public static final int VISIBILITYMODE_AUTO_INDICATOR;
    public static final int SPEECH_PROMPT_FIRST_PAGE;
    public static final int SPEECH_PROMPT_FIRST_PAGE_FAIL;
    public static final int SPEECH_PROMPT_LAST_PAGE;
    public static final int SPEECH_PROMPT_LAST_PAGE_FAIL;
    public static final int SPEECH_PROMPT_NEXT_PAGE;
    public static final int SPEECH_PROMPT_NEXT_PAGE_FAIL;
    public static final int SPEECH_PROMPT_PREV_PAGE;
    public static final int SPEECH_PROMPT_PREV_PAGE_FAIL;
    public static final int SPEECH_COMMAND_FIRST_PAGE;
    public static final int SPEECH_COMMAND_LAST_PAGE;
    public static final int SPEECH_COMMAND_NEXT_PAGE;
    public static final int SPEECH_COMMAND_PREV_PAGE;

    default public Image[] get_imagesScrollbar() {
    }

    default public void set_imagesScrollbar(Image[] imageArray) {
    }

    default public Color[] get_colorsScrollbar() {
    }

    default public void set_colorsScrollbar(Color[] colorArray) {
    }

    default public StaticImageModel get_imageScrollbarRef() {
    }

    default public void set_imageScrollbarRef(StaticImageModel staticImageModel) {
    }

    default public int get_visibilityMode() {
    }

    default public void set_visibilityMode(int n) {
    }

    default public boolean isScrollbarIndicatorVisibile() {
    }

    default public boolean is_jump() {
    }

    default public void set_jump(boolean bl) {
    }

    default public int getPageSize() {
    }

    default public void setPageSize(int n) {
    }

    default public Adjustable get_adjustableWidgetRef() {
    }

    default public void set_adjustableWidgetRef(Adjustable adjustable) {
    }

    default public void notifyAdjustmentListener(int n) {
    }

    default public int get_startTime() {
    }

    default public void set_startTime(int n) {
    }

    default public int get_repeatTime() {
    }

    default public void set_repeatTime(int n) {
    }

    default public void set_minScrollbarSize(int n) {
    }

    default public int get_minScrollbarSize() {
    }

    default public int get_stepValues() {
    }

    default public void set_stepValues(int n) {
    }

    default public void setCurrentValue(int n) {
    }

    default public int getCurrentValue() {
    }

    default public int get_pageSize() {
    }

    default public void set_pageSize(int n) {
    }

    default public int getValuePoint() {
    }

    default public void scrollToNextPage() {
    }

    default public void scrollToPrevPage() {
    }

    default public void updateStepValuePosition(int n, int n2) {
    }
}

