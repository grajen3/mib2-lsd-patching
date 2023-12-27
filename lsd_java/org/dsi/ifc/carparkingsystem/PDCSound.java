/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCSound {
    public int volume;
    public int frequency;

    public PDCSound() {
        this.volume = 0;
        this.frequency = 0;
    }

    public PDCSound(int n, int n2) {
        this.volume = n;
        this.frequency = n2;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("PDCSound");
        stringBuffer.append('(');
        stringBuffer.append("volume");
        stringBuffer.append('=');
        stringBuffer.append(this.volume);
        stringBuffer.append(',');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append(this.frequency);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

