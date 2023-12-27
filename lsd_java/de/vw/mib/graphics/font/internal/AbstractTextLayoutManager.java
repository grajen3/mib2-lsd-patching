/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.TextLayoutManager;
import de.vw.mib.graphics.font.TextLayoutPerformanceMetrics;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.GlyphStyle;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;

public abstract class AbstractTextLayoutManager
implements TextLayoutManager {
    private final TextLayoutPerformanceMetrics performanceMetrics = new TextLayoutPerformanceMetrics();

    @Override
    public void dispose() {
    }

    @Override
    public final TextLayoutPerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }

    @Override
    public abstract GlyphStyle createGlyphStyle(int n, int n2, int n3) {
    }

    @Override
    public abstract GlyphStyle createGlyphStyle(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
    }

    @Override
    public abstract TextStyle createTextStyle(int n, int n2, int n3, int n4, int n5, GlyphStyle glyphStyle) {
    }

    @Override
    public abstract TextLayout performTextLayout(int n, int n2, int n3, boolean bl, char c2, boolean bl2, char c3, TextStyle[] textStyleArray, String string, Font font) {
    }

    @Override
    public abstract CachePerformanceMetrics getTextLayoutCacheUsage() {
    }
}

