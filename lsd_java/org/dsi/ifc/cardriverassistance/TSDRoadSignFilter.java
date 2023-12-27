/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class TSDRoadSignFilter {
    public boolean trailerLimits;

    public TSDRoadSignFilter() {
        this.trailerLimits = false;
    }

    public TSDRoadSignFilter(boolean bl) {
        this.trailerLimits = bl;
    }

    public boolean isTrailerLimits() {
        return this.trailerLimits;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("TSDRoadSignFilter");
        stringBuffer.append('(');
        stringBuffer.append("trailerLimits");
        stringBuffer.append('=');
        stringBuffer.append(this.trailerLimits);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

