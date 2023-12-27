/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.spi.layout;

public interface GlyphLayout {
    public static final int GLYPH_ID_NOT_AVAILABLE;
    public static final int GLYPH_ID_FOREGONE_GLYPH;

    default public int getGlyphId() {
    }

    default public int getSourceIndex() {
    }

    default public int getX() {
    }

    default public int getY() {
    }

    default public int getWidth() {
    }

    default public int getHeight() {
    }

    default public int getCaretX() {
    }

    default public boolean isRightToLeft() {
    }
}

