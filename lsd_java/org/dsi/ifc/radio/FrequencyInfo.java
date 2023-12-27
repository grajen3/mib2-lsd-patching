/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class FrequencyInfo {
    public long frequency;
    public String label;

    public FrequencyInfo() {
        this.frequency = 0L;
        this.label = "";
    }

    public FrequencyInfo(long l, String string) {
        this.frequency = l;
        this.label = string;
    }

    public long getFrequency() {
        return this.frequency;
    }

    public String getLabel() {
        return this.label;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("FrequencyInfo");
        stringBuffer.append('(');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append(this.frequency);
        stringBuffer.append(',');
        stringBuffer.append("label");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.label);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

