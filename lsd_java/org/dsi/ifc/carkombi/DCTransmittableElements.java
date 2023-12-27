/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class DCTransmittableElements {
    public int ra0;
    public int ra1;
    public int ra2;
    public int raF;

    public DCTransmittableElements() {
        this.ra0 = 0;
        this.ra1 = 0;
        this.ra2 = 0;
        this.raF = 0;
    }

    public DCTransmittableElements(int n, int n2, int n3) {
        this.ra0 = n;
        this.ra1 = n2;
        this.ra2 = 0;
        this.raF = n3;
    }

    public DCTransmittableElements(int n, int n2, int n3, int n4) {
        this.ra0 = n;
        this.ra1 = n2;
        this.ra2 = n3;
        this.raF = n4;
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

    public int getRaF() {
        return this.raF;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DCTransmittableElements");
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

