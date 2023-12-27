/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.Glyph;
import de.vw.mib.graphics.font.GlyphBitmap;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;

public interface RasterizableFont
extends Font {
    default public GlyphBitmap getGlyphBitmap(Glyph glyph, GlyphStyle glyphStyle) {
    }
}

