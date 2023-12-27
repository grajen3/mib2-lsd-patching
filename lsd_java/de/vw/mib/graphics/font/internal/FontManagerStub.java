/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.internal.AbstractFontManager;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;

public class FontManagerStub
extends AbstractFontManager {
    @Override
    public Font getDefaultFont() {
        return null;
    }

    @Override
    public Font getFontFromCommonSkin(String string) {
        return null;
    }

    @Override
    public Font getFontFromCurrentSkin(String string) {
        return null;
    }

    @Override
    public CachePerformanceMetrics getFontCacheUsage() {
        return null;
    }

    @Override
    public CachePerformanceMetrics getGlyphCacheUsage() {
        return null;
    }
}

