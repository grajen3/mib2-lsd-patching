/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.FontSPIImpl$FontSPITextLineLayout;
import de.eso.mib.SLineMetric;
import de.eso.mib.STextMetric;
import de.vw.mib.graphics.font.spi.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;

public class FontSPIImpl$FontSPITextLayout
implements TextLayout {
    private STextMetric tlinfo;
    private FontSPIImpl$FontSPITextLineLayout[] tllinfo;

    FontSPIImpl$FontSPITextLayout(STextMetric sTextMetric, SLineMetric[] sLineMetricArray) {
        this.tlinfo = sTextMetric;
        this.tllinfo = new FontSPIImpl$FontSPITextLineLayout[sLineMetricArray.length];
        for (int i2 = 0; i2 < sLineMetricArray.length; ++i2) {
            this.tllinfo[i2] = new FontSPIImpl$FontSPITextLineLayout(sLineMetricArray[i2], i2);
        }
    }

    FontSPIImpl$FontSPITextLayout(boolean bl) {
        this.tlinfo = STextMetric.create();
        this.tlinfo.isTruncated(1);
        if (bl) {
            this.tlinfo.width(60);
            this.tlinfo.height(60);
            this.tlinfo.lineCount(1);
            this.tllinfo = new FontSPIImpl$FontSPITextLineLayout[1];
            this.tllinfo[0] = new FontSPIImpl$FontSPITextLineLayout();
        } else {
            this.tlinfo.width(0);
            this.tlinfo.height(0);
            this.tlinfo.lineCount(0);
            this.tllinfo = new FontSPIImpl$FontSPITextLineLayout[0];
        }
    }

    @Override
    public boolean isTruncated() {
        return this.tlinfo.isTruncated() == 1;
    }

    @Override
    public int getWidth() {
        return this.tlinfo.width();
    }

    @Override
    public int getHeight() {
        return this.tlinfo.height();
    }

    @Override
    public int getLineCount() {
        return this.tlinfo.lineCount();
    }

    @Override
    public TextLineLayout getTextLine(int n) {
        return this.tllinfo[n];
    }

    public String toString() {
        String string = new StringBuffer().append("TL: trunc:").append(this.isTruncated()).append(" w:").append(this.getWidth()).append(" h:").append(this.getHeight()).append(" lines:").append(this.getLineCount()).toString();
        StringBuffer stringBuffer = new StringBuffer(string);
        for (int i2 = 0; i2 < this.tllinfo.length; ++i2) {
            stringBuffer.append("\n");
            stringBuffer.append(this.tllinfo[i2]);
        }
        return stringBuffer.toString();
    }
}

