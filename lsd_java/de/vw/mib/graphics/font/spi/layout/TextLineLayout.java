/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.spi.layout;

import de.vw.mib.graphics.font.spi.layout.GlyphLayout;

public interface TextLineLayout {
    default public int getLeft() {
    }

    default public int getTop() {
    }

    default public int getBottom() {
    }

    default public int getBaseline() {
    }

    default public int getGlyphCount() {
    }

    default public GlyphLayout getGlyph(int n) {
    }
}

