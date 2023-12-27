/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.text;

import de.vw.mib.graphics.drawable.shape.RectangularShapeDrawable;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.TextStyle;

public interface TextDrawable
extends RectangularShapeDrawable {
    default public TextLayout getTextLayout() {
    }

    default public void setTextLayout(TextLayout textLayout) {
    }

    default public TextStyle[] getTextStyles() {
    }

    default public void setTextStyles(TextStyle[] textStyleArray) {
    }

    default public int getSize() {
    }

    default public void setSize(int n) {
    }

    default public int getStyle() {
    }

    default public void setStyle(int n) {
    }

    default public void setIntervalStart(int n) {
    }

    default public void setIntervalEnd(int n) {
    }

    default public String getText() {
    }

    default public void setText(String string) {
    }

    default public Font getFont() {
    }

    default public void setFont(Font font) {
    }
}

