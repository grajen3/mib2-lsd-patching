/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.SGlyphMetric;
import de.vw.mib.graphics.font.spi.layout.GlyphLayout;

public class FontSPIImpl$FontSPIGlyphLayout
implements GlyphLayout {
    private SGlyphMetric glinfo;

    FontSPIImpl$FontSPIGlyphLayout(SGlyphMetric sGlyphMetric) {
        this.glinfo = sGlyphMetric;
    }

    FontSPIImpl$FontSPIGlyphLayout() {
        this.glinfo = SGlyphMetric.create();
        this.glinfo.glyphid(10);
        this.glinfo.sourceindex(0);
        this.glinfo.x(0);
        this.glinfo.y(20);
        this.glinfo.width(60);
        this.glinfo.height(60);
        this.glinfo.caretX(0);
        this.glinfo.isRightToLeft(0);
    }

    @Override
    public int getGlyphId() {
        return this.glinfo.glyphid();
    }

    @Override
    public int getSourceIndex() {
        return this.glinfo.sourceindex();
    }

    @Override
    public int getX() {
        return this.glinfo.x();
    }

    @Override
    public int getY() {
        return this.glinfo.y();
    }

    @Override
    public int getWidth() {
        return this.glinfo.width();
    }

    @Override
    public int getHeight() {
        return this.glinfo.height();
    }

    @Override
    public int getCaretX() {
        return this.glinfo.caretX();
    }

    @Override
    public boolean isRightToLeft() {
        return this.glinfo.isRightToLeft() == 1;
    }

    public String toString() {
        String string = new StringBuffer().append("GL: id:").append(this.getGlyphId()).append(" idx:").append(this.getSourceIndex()).append(" x:").append(this.getX()).append(" y:").append(this.getY()).append(" w:").append(this.getWidth()).append(" h:").append(this.getHeight()).append(" cx: ").append(this.getCaretX()).append(" rtl:").append(this.isRightToLeft()).toString();
        return string;
    }
}

