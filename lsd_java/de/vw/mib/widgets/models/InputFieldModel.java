/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.speller.InputFieldChangedListener;

public interface InputFieldModel
extends TextAreaModel,
Adjustable,
AdjustmentListener {
    public static final int PID_BASE;
    public static final int PID_COLOR_HIGHLIGHT_FOREGROUND;
    public static final int PID_COLOR_HIGHLIGHT_BACKGROUND;
    public static final int PID_COLOR_MATCH_FOREGROUND;
    public static final int PID_SPELLER_REF;
    public static final int PID_HIDE_TYPING;
    public static final int PID_HIDE_TYPING_CHAR;
    public static final int PID_CURSOR_IMAGE;
    public static final int PID_CURSOR_MODE;
    public static final int PID_CURSOR_OFFSET;
    public static final int PID_INPUT_TEXT_IS_HIGHLIGHTED;
    public static final int PID_COUNT_INPUT_FIELD;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_INPUTFIELD;
    public static final int SID_BASE;
    public static final int SID_HIDE_TYPING;
    public static final int SID_COUNT_INPUT_FIELD;
    public static final int MAX_VIEWPORT_WIDTH;
    public static final int MAX_VIEWPORT_HEIGHT;
    public static final int CURSORMODE_DEFAULT;
    public static final int CURSORMODE_HIGHLIGHT;
    public static final int DEFAULT_CURSOR_OFFSET;

    default public Image get_cursorImage() {
    }

    default public void set_cursorImage(Image image) {
    }

    default public int get_cursorMode() {
    }

    default public void set_cursorMode(int n) {
    }

    default public int get_cursorOffset() {
    }

    default public void set_cursorOffset(int n) {
    }

    default public Color get_colorHighlightForeground() {
    }

    default public void set_colorHighlightForeground(Color color) {
    }

    default public Color get_colorHighlightBackground() {
    }

    default public void set_colorHighlightBackground(Color color) {
    }

    default public Color get_colorMatchForeground() {
    }

    default public void set_colorMatchForeground(Color color) {
    }

    default public AbstractSpellerModel get_spellerRef() {
    }

    default public void set_spellerRef(AbstractSpellerModel abstractSpellerModel) {
    }

    default public boolean is_hideTyping() {
    }

    default public void set_hideTyping(boolean bl) {
    }

    default public String get_hideTypingChar() {
    }

    default public void set_hideTypingChar(String string) {
    }

    default public void validate() {
    }

    default public boolean is_inputTextIsHighlighted() {
    }

    default public void set_inputTextIsHighlighted(boolean bl) {
    }

    default public Rectangle getCursorArea() {
    }

    default public void getAbsCursorArea(Rectangle rectangle) {
    }

    default public Rectangle getAlternateCursorArea() {
    }

    default public boolean isAlternateCursorVisible() {
    }

    default public void setCursorPosition(int n, int n2) {
    }

    default public int getViewPortPosition() {
    }

    default public boolean isVertical() {
    }

    default public boolean isInfoTextVisible() {
    }

    default public boolean isMatchTextVisible() {
    }

    default public boolean isCursorVisible() {
    }

    default public boolean isCursorRTL() {
    }

    default public boolean isHighlightVisible() {
    }

    default public void addInputFieldChangedListener(InputFieldChangedListener inputFieldChangedListener) {
    }

    default public void removeInputFieldChangedListener(InputFieldChangedListener inputFieldChangedListener) {
    }

    default public TextLayout getTruncationTextlayout() {
    }

    default public TextLayout[] getMatchTextLayouts() {
    }

    default public TextStyle[] getMatchTextStyle() {
    }

    default public Color getMatchColorForeground() {
    }
}

