/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.spi;

import de.vw.mib.graphics.font.spi.FontMetrics;
import de.vw.mib.graphics.font.spi.NativeGlyph;
import de.vw.mib.graphics.font.spi.layout.TextLayout;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;
import de.vw.mib.graphics.font.spi.style.TextStyle;
import java.nio.ByteBuffer;

public interface FontSPI {
    default public int openFont(int n, int n2) {
    }

    default public int openFont(int n, String string) {
    }

    default public void closeFont(int n) {
    }

    default public String getFamilyName(int n) {
    }

    default public String getStyleName(int n) {
    }

    default public int getAscender(int n, int n2) {
    }

    default public int getDescender(int n, int n2) {
    }

    default public int getHeight(int n, int n2) {
    }

    default public int getMaxAdvanceWidth(int n, int n2) {
    }

    default public boolean isGlyphAvailable(int n, char c2) {
    }

    default public void getControlBox(int n, char c2, int n2, int[] nArray) {
    }

    default public int getKerning(int n, char c2, char c3, int n2) {
    }

    default public NativeGlyph getGlyph(int n, char c2, int n2, int n3) {
    }

    default public void releaseGlyph(ByteBuffer byteBuffer) {
    }

    default public boolean isTextLayoutingAvailable() {
    }

    default public TextLayout performTextLayout(int n, int n2, int n3, boolean bl, char c2, boolean bl2, char c3, TextStyle[] textStyleArray, String string) {
    }

    default public FontMetrics getFontMetrics(GlyphStyle glyphStyle) {
    }

    default public NativeGlyph getGlyphById(GlyphStyle glyphStyle, int n) {
    }
}

