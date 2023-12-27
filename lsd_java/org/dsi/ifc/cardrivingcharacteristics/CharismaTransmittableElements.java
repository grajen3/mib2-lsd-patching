/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class CharismaTransmittableElements {
    public int ra0;
    public int ra1;
    public int raF;

    public CharismaTransmittableElements() {
        this.ra0 = 0;
        this.ra1 = 0;
        this.raF = 0;
    }

    public CharismaTransmittableElements(int n, int n2, int n3) {
        this.ra0 = n;
        this.ra1 = n2;
        this.raF = n3;
    }

    public int getRa0() {
        return this.ra0;
    }

    public int getRa1() {
        return this.ra1;
    }

    public int getRaF() {
        return this.raF;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("CharismaTransmittableElements");
        stringBuffer.append('(');
        stringBuffer.append("ra0");
        stringBuffer.append('=');
        stringBuffer.append(this.ra0);
        stringBuffer.append(',');
        stringBuffer.append("ra1");
        stringBuffer.append('=');
        stringBuffer.append(this.ra1);
        stringBuffer.append(',');
        stringBuffer.append("raF");
        stringBuffer.append('=');
        stringBuffer.append(this.raF);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

