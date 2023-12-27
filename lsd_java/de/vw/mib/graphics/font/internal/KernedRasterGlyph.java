/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.internal.AbstractGlyph;
import de.vw.mib.graphics.font.internal.BitmappedGlyph;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;

public final class KernedRasterGlyph
extends AbstractGlyph
implements Cacheable {
    private static final int GLYPHBITMAP_MAP_INITIAL_CAPACITY;
    private static final int KERNING_MAP_INITIAL_CAPACITY;
    private IntObjectMap glyphBitmapMap = new IntObjectOptHashMap(10);
    private IntIntMap kerningMap = new IntIntOptHashMap(50);
    private Rectangle boundingBox;
    private int byteSize = 0;

    public KernedRasterGlyph(long l, Font font, int n, int n2) {
        super(l, font, n, n2);
    }

    public KernedRasterGlyph(long l, Font font, char c2, int n) {
        super(l, font, c2, n, 0);
    }

    @Override
    public void dispose() {
        this.glyphBitmapMap.clear();
        this.glyphBitmapMap = null;
        this.kerningMap.clear();
        this.kerningMap = null;
    }

    @Override
    public int getByteSize() {
        return this.byteSize;
    }

    public BitmappedGlyph getBitmappedGlyph(GlyphStyle glyphStyle) {
        return (BitmappedGlyph)this.glyphBitmapMap.get(KernedRasterGlyph.getUniqueStyleId(glyphStyle));
    }

    public Object[] getBitmappedGlyphs() {
        return this.glyphBitmapMap.valuesToArray();
    }

    public void addBitmappedGlyph(GlyphStyle glyphStyle, BitmappedGlyph bitmappedGlyph) {
        this.glyphBitmapMap.put(KernedRasterGlyph.getUniqueStyleId(glyphStyle), bitmappedGlyph);
        this.byteSize += bitmappedGlyph.getByteSize();
    }

    public Rectangle getBoundingBox() {
        return this.boundingBox;
    }

    public void setBoundingBox(Rectangle rectangle) {
        this.boundingBox = rectangle;
    }

    public boolean hasKerning(int n) {
        int n2 = (this.getCharacter() & 0xFFFF0000) << 16 | n & 0xFFFF0000;
        return this.kerningMap.containsKey(n2);
    }

    public int getKerning(int n) {
        int n2 = (this.getCharacter() & 0xFFFF0000) << 16 | n & 0xFFFF0000;
        return this.kerningMap.get(n2);
    }

    public void addKerning(int n, int n2) {
        this.kerningMap.put((this.getCharacter() & 0xFFFF0000) << 16 | n & 0xFFFF0000, n2);
    }

    private static int getUniqueStyleId(GlyphStyle glyphStyle) {
        return glyphStyle.getFontSize() | (glyphStyle.isUnderline() ? 128 : 0) | (glyphStyle.isStrikeOut() ? 64 : 0) | (glyphStyle.isOverline() ? 32 : 0) | (glyphStyle.isItalic() ? 16 : 0) | (glyphStyle.isBold() ? 8 : 0) | (glyphStyle.isHintingDisabled() ? 4 : 0) | (glyphStyle.isByteCodeHintingDisabled() ? 2 : 0);
    }
}

