/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class ExtLightLampErrorDetectionStateTrailer {
    public int lamp;
    public int state;

    public ExtLightLampErrorDetectionStateTrailer() {
        this.lamp = 0;
        this.state = 0;
    }

    public ExtLightLampErrorDetectionStateTrailer(int n, int n2) {
        this.lamp = n;
        this.state = n2;
    }

    public int getLamp() {
        return this.lamp;
    }

    public int getState() {
        return this.state;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("ExtLightLampErrorDetectionStateTrailer");
        stringBuffer.append('(');
        stringBuffer.append("lamp");
        stringBuffer.append('=');
        stringBuffer.append(this.lamp);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

