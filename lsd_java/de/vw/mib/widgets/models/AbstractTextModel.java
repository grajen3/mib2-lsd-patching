/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.widgets.interfaces.Glowable;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public interface AbstractTextModel
extends WidgetModel,
Glowable {
    public static final int PID_BASE;
    public static final int PID_COLOR_BACKGROUND;
    public static final int PID_COLOR_FOREGROUND;
    public static final int PID_FONT;
    public static final int PID_LINE_SPACING;
    public static final int PID_PADDING;
    public static final int PID_TEXT;
    public static final int PID_BASELINE_OFFSET;
    public static final int PID_ALIGNMENT_HORIZONTAL;
    public static final int PID_GLOW_TYPE;
    public static final int PID_GLOW_COLOR;
    public static final int PID_GLOW_VISIBLE;
    public static final int PID_VISUAL_LINE_COUNT;
    public static final int PID_COLOR_UPPER_BEVEL;
    public static final int PID_COLOR_LOWER_BEVEL;
    public static final int PID_BEVEL_DEPTH;
    public static final int PID_BEVEL_ENABLED;
    public static final int PID_TEXT_STYLING_ENABLED;
    public static final int PID_COLORS_HIGHLIGHT_BACKGROUND;
    public static final int PID_COLORS_HIGHLIGHT_FOREGROUND;
    public static final int PID_FONT_STYLES;
    public static final int PID_COUNT_ABSTRACT_TEXT;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COLOR_FADE;
    public static final int EASING_INDEX_CONTENT_FADE_OUT;
    public static final int EASING_INDEX_CONTENT_FADE_IN;
    public static final int EASING_INDEX_GLOW_IN;
    public static final int EASING_INDEX_GLOW_OUT;
    public static final int EASING_INDEX_COUNT_ABSTRACT_TEXT;
    public static final int SID_BASE;
    public static final int SID_GLOW_VISIBLE;
    public static final int SID_TEXT_STYLING_ENABLED;
    public static final int SID_COUNT_ABSTRACT_TEXT;
    public static final int BEVELENABLED_NONE;
    public static final int BEVELENABLED_UPPER;
    public static final int BEVELENABLED_LEFT;
    public static final int BEVELENABLED_LOWER;
    public static final int BEVELENABLED_RIGHT;
    public static final int ALIGNMENTHORIZONTAL_LEFT;
    public static final int ALIGNMENTHORIZONTAL_CENTER;
    public static final int ALIGNMENTHORIZONTAL_RIGHT;
    public static final char MARKUP_HIGHLIGHT_START;
    public static final char MARKUP_HIGHLIGHT_END;
    public static final char MARKUP_INDEX_FIRST;
    public static final char MARKUP_INDEX_LAST;
    public static final char MARKUP_STYLE_START;
    public static final char MARKUP_STYLE_END;

    default public int get_alignmentHorizontal() {
    }

    default public void set_alignmentHorizontal(int n) {
    }

    default public Color get_colorBackground() {
    }

    default public void set_colorBackground(Color color) {
    }

    default public Color get_colorForeground() {
    }

    default public void set_colorForeground(Color color) {
    }

    default public Color[] get_colorsHighlightForeground() {
    }

    default public void set_colorsHighlightForeground(Color[] colorArray) {
    }

    default public Color[] get_colorsHighlightBackground() {
    }

    default public void set_colorsHighlightBackground(Color[] colorArray) {
    }

    default public FontAttribs get_font() {
    }

    default public void set_font(FontAttribs fontAttribs) {
    }

    default public int[] get_fontStyles() {
    }

    default public void set_fontStyles(int[] nArray) {
    }

    default public int get_lineSpacing() {
    }

    default public void set_lineSpacing(int n) {
    }

    default public Insets get_padding() {
    }

    default public void set_padding(Insets insets) {
    }

    default public String get_text() {
    }

    default public void set_text(String string) {
    }

    default public boolean is_textStylingEnabled() {
    }

    default public void set_textStylingEnabled(boolean bl) {
    }

    default public void set_baselineOffset(int n) {
    }

    default public int get_baselineOffset() {
    }

    default public void set_visualLineCount(int n) {
    }

    default public int get_visualLineCount() {
    }

    default public Font getFont() {
    }

    default public TextLayout getTextLayout() {
    }

    default public TextStyle[] getTextStyles() {
    }

    default public TextLayout getContentFadeInTextLines() {
    }

    default public TextLayout getContentFadeOutTextLines() {
    }

    default public float getColorFadingProgress() {
    }

    default public Color getLastColor() {
    }

    default public float getContentFadeOutAlpha() {
    }

    default public boolean isContentFadeInAnimationActive() {
    }

    default public boolean isContentFadeOutAnimationActive() {
    }

    default public float getContentFadeInAlpha() {
    }

    default public int getMaxLineWidth() {
    }

    default public int getMaxLineHeight() {
    }

    default public int getMaxLineCount() {
    }

    default public void set_colorLowerBevel(Color color) {
    }

    default public Color get_colorLowerBevel() {
    }

    default public void set_colorUpperBevel(Color color) {
    }

    default public Color get_colorUpperBevel() {
    }

    default public int get_bevelDepth() {
    }

    default public void set_bevelDepth(int n) {
    }

    default public int get_bevelEnabled() {
    }

    default public void set_bevelEnabled(int n) {
    }

    default public List getTextHighlights() {
    }
}

