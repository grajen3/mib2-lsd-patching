/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.FontSPIImpl$FontSPIGlyphLayout;
import de.eso.mib.SGlyphMetric;
import de.eso.mib.SLineMetric;
import de.eso.mib.SPI;
import de.vw.mib.graphics.font.spi.layout.GlyphLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;

public class FontSPIImpl$FontSPITextLineLayout
implements TextLineLayout {
    private SLineMetric tllinfo;
    private FontSPIImpl$FontSPIGlyphLayout[] glinfo;

    FontSPIImpl$FontSPITextLineLayout(SLineMetric sLineMetric, int n) {
        this.tllinfo = sLineMetric;
        int[] nArray = new int[]{this.tllinfo.glyphcount()};
        SGlyphMetric[] sGlyphMetricArray = SPI.font_get_layout_line_content(n, nArray, 0);
        if (sGlyphMetricArray != null) {
            this.glinfo = new FontSPIImpl$FontSPIGlyphLayout[this.tllinfo.glyphcount()];
            for (int i2 = 0; i2 < this.tllinfo.glyphcount(); ++i2) {
                this.glinfo[i2] = new FontSPIImpl$FontSPIGlyphLayout(sGlyphMetricArray[i2]);
            }
        }
    }

    FontSPIImpl$FontSPITextLineLayout() {
        this.tllinfo = SLineMetric.create();
        this.tllinfo.left(0);
        this.tllinfo.top(10);
        this.tllinfo.bottom(70);
        this.tllinfo.baseline(60);
        this.tllinfo.glyphcount(1);
        this.glinfo = new FontSPIImpl$FontSPIGlyphLayout[1];
        this.glinfo[0] = new FontSPIImpl$FontSPIGlyphLayout();
    }

    @Override
    public int getLeft() {
        return this.tllinfo.left();
    }

    @Override
    public int getTop() {
        return this.tllinfo.top();
    }

    @Override
    public int getBottom() {
        return this.tllinfo.bottom();
    }

    @Override
    public int getBaseline() {
        return this.tllinfo.baseline();
    }

    @Override
    public int getGlyphCount() {
        return this.tllinfo.glyphcount();
    }

    @Override
    public GlyphLayout getGlyph(int n) {
        return this.glinfo[n];
    }

    public String toString() {
        String string = new StringBuffer().append("TLL: l:").append(this.getLeft()).append(" t:").append(this.getTop()).append(" b:").append(this.getBottom()).append(" bl:").append(this.getBaseline()).append(" glyphs:").append(this.getGlyphCount()).toString();
        StringBuffer stringBuffer = new StringBuffer(string);
        for (int i2 = 0; i2 < this.glinfo.length; ++i2) {
            stringBuffer.append("\n");
            stringBuffer.append(this.glinfo[i2]);
        }
        return stringBuffer.toString();
    }
}

