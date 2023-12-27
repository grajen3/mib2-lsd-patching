/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.cache.CacheListener;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.font.internal.KernedRasterFont;
import de.vw.mib.graphics.font.internal.KernedRasterGlyph;

final class KernedRasterFont$GlyphCacheListener
implements CacheListener {
    private final KernedRasterFont font;

    public KernedRasterFont$GlyphCacheListener(KernedRasterFont kernedRasterFont) {
        this.font = kernedRasterFont;
    }

    @Override
    public void add(long l, Cacheable cacheable) {
    }

    @Override
    public void clear() {
    }

    @Override
    public void hit(long l, Cacheable cacheable) {
    }

    @Override
    public void miss(long l) {
    }

    @Override
    public void remove(Cacheable cacheable) {
        KernedRasterGlyph kernedRasterGlyph = (KernedRasterGlyph)cacheable;
        if (kernedRasterGlyph != null && kernedRasterGlyph.getFont().getFontId() == this.font.getFontId()) {
            this.font.glyphMap.remove(kernedRasterGlyph.getId());
        }
    }
}

