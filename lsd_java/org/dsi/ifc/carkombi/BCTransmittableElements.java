/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCTransmittableElements {
    public int ra0;
    public int ra1;
    public int ra2;
    public int ra3;
    public int raF;

    public BCTransmittableElements() {
        this.ra0 = 0;
        this.ra1 = 0;
        this.ra2 = 0;
        this.ra3 = 0;
        this.raF = 0;
    }

    public BCTransmittableElements(int n, int n2, int n3, int n4, int n5) {
        this.ra0 = n;
        this.ra1 = n2;
        this.ra2 = n3;
        this.ra3 = n4;
        this.raF = n5;
    }

    public int getRa0() {
        return this.ra0;
    }

    public int getRa1() {
        return this.ra1;
    }

    public int getRa2() {
        return this.ra2;
    }

    public int getRa3() {
        return this.ra3;
    }

    public int getRaF() {
        return this.raF;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("BCTransmittableElements");
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
        stringBuffer.append("raF");
        stringBuffer.append('=');
        stringBuffer.append(this.raF);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

