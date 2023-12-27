/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.FontManager;
import de.vw.mib.graphics.font.FontPerformanceMetrics;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;

public abstract class AbstractFontManager
implements FontManager {
    private final FontPerformanceMetrics performanceMetrics = new FontPerformanceMetrics();

    @Override
    public void dispose() {
    }

    @Override
    public final FontPerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }

    @Override
    public abstract Font getDefaultFont() {
    }

    @Override
    public abstract Font getFontFromCommonSkin(String string) {
    }

    @Override
    public abstract Font getFontFromCurrentSkin(String string) {
    }

    @Override
    public abstract CachePerformanceMetrics getFontCacheUsage() {
    }

    @Override
    public abstract CachePerformanceMetrics getGlyphCacheUsage() {
    }
}

