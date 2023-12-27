/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.AbstractTextModel;

public interface TextAreaModel
extends AbstractTextModel {
    public static final int PID_BASE;
    public static final int PID_ALIGNMENT_VERTICAL;
    public static final int PID_LINE_BREAK_MODE;
    public static final int PID_SHORTEN;
    public static final int PID_SHORTENED;
    public static final int PID_DYNAMIC_RESIZE_DIRECTION;
    public static final int PID_DYNAMIC_SIZE;
    public static final int PID_FONT_GLOW_COLOR;
    public static final int PID_COUNT_TEXTAREA;
    public static final int ALIGNMENTVERTICAL_TOP;
    public static final int ALIGNMENTVERTICAL_CENTER;
    public static final int ALIGNMENTVERTICAL_BOTTOM;
    public static final int LINEBREAKMODE_NONE;
    public static final int LINEBREAKMODE_CHARACTER;
    public static final int LINEBREAKMODE_WORD;
    public static final int LINEBREAKMODE_CHINESE;
    public static final int LINEBREAKMODE_MANUAL;
    public static final int LINEBREAKMODE_CHARACTER_ON_TRUNCATION;
    public static final int DYNAMICRESIZEDIRECTION_NONE;
    public static final int DYNAMICRESIZEDIRECTION_HORIZONTAL;
    public static final int DYNAMICRESIZEDIRECTION_VERTICAL;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_TEXTAREA;
    public static final int SID_BASE;
    public static final int SID_SHORTEN;
    public static final int SID_SHORTENED;
    public static final int SID_OVERRIDE_LINEBREAK_TO_CHARACTER;
    public static final int SID_COUNT_TEXTAREA;

    default public int get_alignmentVertical() {
    }

    default public void set_alignmentVertical(int n) {
    }

    default public int get_lineBreakMode() {
    }

    default public void set_lineBreakMode(int n) {
    }

    default public boolean is_shorten() {
    }

    default public void set_shorten(boolean bl) {
    }

    default public boolean is_shortened() {
    }

    default public void set_shortened(boolean bl) {
    }

    default public void set_dynamicResizeDirection(int n) {
    }

    default public int get_dynamicResizeDirection() {
    }

    default public void set_dynamicSize(int n) {
    }

    default public int get_dynamicSize() {
    }
}

