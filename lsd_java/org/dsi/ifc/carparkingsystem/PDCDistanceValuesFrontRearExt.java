/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCDistanceValuesFrontRearExt {
    public int spacing5;
    public int spacing6;
    public int spacing7;
    public int spacing8;

    public PDCDistanceValuesFrontRearExt() {
        this.spacing5 = 0;
        this.spacing6 = 0;
        this.spacing7 = 0;
        this.spacing8 = 0;
    }

    public PDCDistanceValuesFrontRearExt(int n, int n2, int n3, int n4) {
        this.spacing5 = n;
        this.spacing6 = n2;
        this.spacing7 = n3;
        this.spacing8 = n4;
    }

    public int getSpacing5() {
        return this.spacing5;
    }

    public int getSpacing6() {
        return this.spacing6;
    }

    public int getSpacing7() {
        return this.spacing7;
    }

    public int getSpacing8() {
        return this.spacing8;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("PDCDistanceValuesFrontRearExt");
        stringBuffer.append('(');
        stringBuffer.append("spacing5");
        stringBuffer.append('=');
        stringBuffer.append(this.spacing5);
        stringBuffer.append(',');
        stringBuffer.append("spacing6");
        stringBuffer.append('=');
        stringBuffer.append(this.spacing6);
        stringBuffer.append(',');
        stringBuffer.append("spacing7");
        stringBuffer.append('=');
        stringBuffer.append(this.spacing7);
        stringBuffer.append(',');
        stringBuffer.append("spacing8");
        stringBuffer.append('=');
        stringBuffer.append(this.spacing8);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

