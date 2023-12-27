/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class IntLightTransmittableElements {
    public short ra0;
    public short raF;

    public IntLightTransmittableElements() {
        this.ra0 = 0;
        this.raF = 0;
    }

    public IntLightTransmittableElements(short s, short s2) {
        this.ra0 = s;
        this.raF = s2;
    }

    public short getRa0() {
        return this.ra0;
    }

    public short getRaF() {
        return this.raF;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("IntLightTransmittableElements");
        stringBuffer.append('(');
        stringBuffer.append("ra0");
        stringBuffer.append('=');
        stringBuffer.append(this.ra0);
        stringBuffer.append(',');
        stringBuffer.append("raF");
        stringBuffer.append('=');
        stringBuffer.append(this.raF);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

