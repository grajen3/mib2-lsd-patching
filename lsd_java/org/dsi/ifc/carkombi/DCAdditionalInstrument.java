/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class DCAdditionalInstrument {
    public boolean instrumentOnOff;
    public boolean light;
    public boolean time;
    public int brightness;

    public DCAdditionalInstrument() {
        this.instrumentOnOff = false;
        this.light = false;
        this.time = false;
        this.brightness = 0;
    }

    public DCAdditionalInstrument(boolean bl, boolean bl2, boolean bl3, int n) {
        this.instrumentOnOff = bl;
        this.light = bl2;
        this.time = bl3;
        this.brightness = n;
    }

    public boolean isInstrumentOnOff() {
        return this.instrumentOnOff;
    }

    public boolean isLight() {
        return this.light;
    }

    public boolean isTime() {
        return this.time;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DCAdditionalInstrument");
        stringBuffer.append('(');
        stringBuffer.append("instrumentOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.instrumentOnOff);
        stringBuffer.append(',');
        stringBuffer.append("light");
        stringBuffer.append('=');
        stringBuffer.append(this.light);
        stringBuffer.append(',');
        stringBuffer.append("time");
        stringBuffer.append('=');
        stringBuffer.append(this.time);
        stringBuffer.append(',');
        stringBuffer.append("brightness");
        stringBuffer.append('=');
        stringBuffer.append(this.brightness);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

