/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.FontPerformanceMetrics;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;

public interface FontManager
extends ResourceManager {
    default public FontPerformanceMetrics getPerformanceMetrics() {
    }

    default public Font getDefaultFont() {
    }

    default public Font getFontFromCommonSkin(String string) {
    }

    default public Font getFontFromCurrentSkin(String string) {
    }

    default public CachePerformanceMetrics getFontCacheUsage() {
    }

    default public CachePerformanceMetrics getGlyphCacheUsage() {
    }
}

