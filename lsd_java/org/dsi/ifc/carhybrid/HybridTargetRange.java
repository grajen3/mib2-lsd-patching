/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class HybridTargetRange {
    public short maxRange;
    public short range;
    public int rangeUnit;

    public HybridTargetRange() {
        this.maxRange = 0;
        this.range = 0;
        this.rangeUnit = 0;
    }

    public HybridTargetRange(short s, short s2, int n) {
        this.maxRange = s;
        this.range = s2;
        this.rangeUnit = n;
    }

    public short getMaxRange() {
        return this.maxRange;
    }

    public short getRange() {
        return this.range;
    }

    public int getRangeUnit() {
        return this.rangeUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("HybridTargetRange");
        stringBuffer.append('(');
        stringBuffer.append("maxRange");
        stringBuffer.append('=');
        stringBuffer.append(this.maxRange);
        stringBuffer.append(',');
        stringBuffer.append("range");
        stringBuffer.append('=');
        stringBuffer.append(this.range);
        stringBuffer.append(',');
        stringBuffer.append("rangeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

