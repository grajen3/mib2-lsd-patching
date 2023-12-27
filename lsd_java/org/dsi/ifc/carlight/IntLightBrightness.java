/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class IntLightBrightness {
    public short brightness;
    public boolean state;

    public IntLightBrightness() {
        this.brightness = 0;
        this.state = false;
    }

    public IntLightBrightness(short s, boolean bl) {
        this.brightness = s;
        this.state = bl;
    }

    public short getBrightness() {
        return this.brightness;
    }

    public boolean isState() {
        return this.state;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("IntLightBrightness");
        stringBuffer.append('(');
        stringBuffer.append("brightness");
        stringBuffer.append('=');
        stringBuffer.append(this.brightness);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

