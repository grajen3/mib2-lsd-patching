/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.widgets.models.DynamicImageModel;

public interface LabeledIconModel
extends DynamicImageModel {
    public static final int PID_BASE;
    public static final int PID_LABELED_ICON_VALUE;
    public static final int PID_FONT;
    public static final int PID_LINE_SPACING;
    public static final int PID_TEXT_FALLBACK_COLOR;
    public static final int PID_COUNT_LABELED_ICON;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_LABELED_ICON;
    public static final int SID_BASE;
    public static final int SID_COUNT_LABELED_ICON;

    default public LabeledIconValue get_labeledIconValue() {
    }

    default public void set_labeledIconValue(LabeledIconValue labeledIconValue) {
    }

    default public FontAttribs get_font() {
    }

    default public void set_font(FontAttribs fontAttribs) {
    }

    default public Point getTextPosition() {
    }

    default public String getText() {
    }

    default public TextLayout getTextLayout() {
    }

    default public TextStyle[] getTextStyles() {
    }

    default public Color4b getTextColor() {
    }

    default public int get_lineSpacing() {
    }

    default public void set_lineSpacing(int n) {
    }

    default public Color get_textFallbackColor() {
    }

    default public void set_textFallbackColor(Color color) {
    }

    default public boolean isFallbackMode() {
    }

    default public Font getFontRenderer() {
    }

    default public int getFontSize() {
    }

    default public boolean isTextDisplayEnabled() {
    }
}

