/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class BCmETransmittableElements {
    public short ra0;
    public short ra1;
    public short ra2;
    public short raF;

    public BCmETransmittableElements() {
        this.ra0 = 0;
        this.ra1 = 0;
        this.ra2 = 0;
        this.raF = 0;
    }

    public BCmETransmittableElements(short s, short s2, short s3, short s4) {
        this.ra0 = s;
        this.ra1 = s2;
        this.ra2 = s3;
        this.raF = s4;
    }

    public short getRa0() {
        return this.ra0;
    }

    public short getRa1() {
        return this.ra1;
    }

    public short getRa2() {
        return this.ra2;
    }

    public short getRaF() {
        return this.raF;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BCmETransmittableElements");
        stringBuffer.append('(');
        stringBuffer.append("ra0");
        stringBuffer.append('=');
        stringBuffer.append(this.ra0);
        stringBuffer.append(',');
        stringBuffer.append("ra1");
        stringBuffer.append('=');
        stringBuffer.append(this.ra1);
        stringBuffer.append(',');
        stringBuffer.append("ra2");
        stringBuffer.append('=');
        stringBuffer.append(this.ra2);
        stringBuffer.append(',');
        stringBuffer.append("raF");
        stringBuffer.append('=');
        stringBuffer.append(this.raF);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

