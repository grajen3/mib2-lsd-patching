/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.TextLayoutPerformanceMetrics;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.GlyphStyle;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;

public interface TextLayoutManager
extends ResourceManager {
    default public TextLayoutPerformanceMetrics getPerformanceMetrics() {
    }

    default public GlyphStyle createGlyphStyle(int n, int n2, int n3) {
    }

    default public GlyphStyle createGlyphStyle(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
    }

    default public TextStyle createTextStyle(int n, int n2, int n3, int n4, int n5, GlyphStyle glyphStyle) {
    }

    default public TextLayout performTextLayout(int n, int n2, int n3, boolean bl, char c2, boolean bl2, char c3, TextStyle[] textStyleArray, String string, Font font) {
    }

    default public CachePerformanceMetrics getTextLayoutCacheUsage() {
    }
}

