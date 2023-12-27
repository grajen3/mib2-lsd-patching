/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.internal.AbstractTextLayoutManager;
import de.vw.mib.graphics.font.internal.TextLayoutManagerStub$1;
import de.vw.mib.graphics.font.internal.TextLayoutManagerStub$2;
import de.vw.mib.graphics.font.internal.TextLayoutManagerStub$3;
import de.vw.mib.graphics.font.internal.TextLayoutManagerStub$4;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.GlyphStyle;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;

public class TextLayoutManagerStub
extends AbstractTextLayoutManager {
    @Override
    public GlyphStyle createGlyphStyle(int n, int n2, int n3) {
        return new TextLayoutManagerStub$1(this);
    }

    @Override
    public GlyphStyle createGlyphStyle(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        return new TextLayoutManagerStub$2(this);
    }

    @Override
    public TextStyle createTextStyle(int n, int n2, int n3, int n4, int n5, GlyphStyle glyphStyle) {
        return new TextLayoutManagerStub$3(this);
    }

    @Override
    public TextLayout performTextLayout(int n, int n2, int n3, boolean bl, char c2, boolean bl2, char c3, TextStyle[] textStyleArray, String string, Font font) {
        return new TextLayoutManagerStub$4(this);
    }

    @Override
    public CachePerformanceMetrics getTextLayoutCacheUsage() {
        return null;
    }
}

