/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.Glyph;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;

public interface Font
extends Disposable {
    public static final int STYLE_PLAIN;
    public static final int STYLE_BOLD;
    public static final int STYLE_ITALIC;
    public static final int STYLE_UNDERLINE;
    public static final int STYLE_STRIKEOUT;
    public static final int STYLE_OVERLINE;
    public static final int STYLE_NO_HINTING;
    public static final int STYLE_NO_BYTECODEHINTING;
    public static final int PRECISION;

    default public String getName() {
    }

    default public String getFamilyName() {
    }

    default public String getStyleName() {
    }

    default public int getFontId() {
    }

    default public int getAscender(int n) {
    }

    default public int getDescender(int n) {
    }

    default public int getHeight(int n) {
    }

    default public int getLeading(int n) {
    }

    default public int getMaxAdvanceWidth(int n) {
    }

    default public Rectangle getBoundingBox(String string, GlyphStyle glyphStyle) {
    }

    default public void getBoundingBox(String string, GlyphStyle glyphStyle, Rectangle rectangle) {
    }

    default public Rectangle getBoundingBox(Glyph glyph, GlyphStyle glyphStyle) {
    }

    default public Rectangle getBoundingBox(char c2, GlyphStyle glyphStyle) {
    }

    default public Glyph getGlyph(int n, int n2) {
    }

    default public Glyph getGlyph(char c2, int n) {
    }

    default public boolean isGlyphAvailable(char c2, int n) {
    }
}

