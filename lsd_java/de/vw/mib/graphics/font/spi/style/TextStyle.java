/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.spi.style;

import de.vw.mib.graphics.font.spi.style.GlyphStyle;

public interface TextStyle {
    public static final int HORIZONTAL_ALIGNMENT_LEFT;
    public static final int HORIZONTAL_ALIGNMENT_CENTER;
    public static final int HORIZONTAL_ALIGNMENT_RIGHT;
    public static final int LINEBREAK_MODE_DEFAULT;
    public static final int LINEBREAK_MODE_CHARACTER;

    default public int getLineSpacing() {
    }

    default public int getHorizontalAlignment() {
    }

    default public int getLinebreakMode() {
    }

    default public int getStartIndex() {
    }

    default public int getEndIndex() {
    }

    default public GlyphStyle getGlyphStyle() {
    }
}

