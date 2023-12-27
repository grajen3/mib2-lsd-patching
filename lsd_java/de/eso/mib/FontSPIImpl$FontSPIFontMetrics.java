/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.FontMetricsInfo;
import de.vw.mib.graphics.font.spi.FontMetrics;

public class FontSPIImpl$FontSPIFontMetrics
implements FontMetrics {
    private FontMetricsInfo fminfo;

    FontSPIImpl$FontSPIFontMetrics(FontMetricsInfo fontMetricsInfo) {
        this.fminfo = fontMetricsInfo;
    }

    @Override
    public int getAscender() {
        return this.fminfo.ascender();
    }

    @Override
    public int getDescender() {
        return this.fminfo.descender();
    }

    @Override
    public int getHeight() {
        return this.fminfo.height();
    }

    @Override
    public int getMaxAdvanceWidth() {
        return this.fminfo.advanceWidth();
    }

    @Override
    public int getUnderlinePosition() {
        return this.fminfo.underlinePosition();
    }

    @Override
    public int getUnderlineThickness() {
        return this.fminfo.underlineThickness();
    }

    @Override
    public int getStrikeOutPosition() {
        return this.fminfo.strikeOutPosition();
    }

    @Override
    public int getStrikeOutThickness() {
        return this.fminfo.strikeOutThickness();
    }

    @Override
    public int getOverlinePosition() {
        return this.fminfo.overlinePosition();
    }

    @Override
    public int getOverlineThickness() {
        return this.fminfo.overlineThickness();
    }
}

