/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class UGDOTransmittableElements {
    public short ra0;
    public short ra1;
    public short ra2;
    public short ra3;
    public short ra4;
    public short ra5;
    public short raF;

    public UGDOTransmittableElements() {
        this.ra0 = 0;
        this.ra1 = 0;
        this.ra2 = 0;
        this.ra3 = 0;
        this.ra4 = 0;
        this.ra5 = 0;
        this.raF = 0;
    }

    public UGDOTransmittableElements(short s, short s2, short s3, short s4, short s5, short s6) {
        this.ra0 = s;
        this.ra1 = s2;
        this.ra2 = s3;
        this.ra3 = s4;
        this.ra4 = s5;
        this.ra5 = 0;
        this.raF = s6;
    }

    public UGDOTransmittableElements(short s, short s2, short s3, short s4, short s5, short s6, short s7) {
        this.ra0 = s;
        this.ra1 = s2;
        this.ra2 = s3;
        this.ra3 = s4;
        this.ra4 = s5;
        this.ra5 = s6;
        this.raF = s7;
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

    public short getRa3() {
        return this.ra3;
    }

    public short getRa4() {
        return this.ra4;
    }

    public short getRa5() {
        return this.ra5;
    }

    public short getRaF() {
        return this.raF;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("UGDOTransmittableElements");
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
        stringBuffer.append("ra3");
        stringBuffer.append('=');
        stringBuffer.append(this.ra3);
        stringBuffer.append(',');
        stringBuffer.append("ra4");
        stringBuffer.append('=');
        stringBuffer.append(this.ra4);
        stringBuffer.append(',');
        stringBuffer.append("ra5");
        stringBuffer.append('=');
        stringBuffer.append(this.ra5);
        stringBuffer.append(',');
        stringBuffer.append("raF");
        stringBuffer.append('=');
        stringBuffer.append(this.raF);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

