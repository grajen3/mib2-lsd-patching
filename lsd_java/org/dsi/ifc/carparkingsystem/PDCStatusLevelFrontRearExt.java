/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCStatusLevelFrontRearExt {
    public int statusLevel5;
    public int statusLevel6;
    public int statusLevel7;
    public int statusLevel8;

    public PDCStatusLevelFrontRearExt() {
        this.statusLevel5 = 0;
        this.statusLevel6 = 0;
        this.statusLevel7 = 0;
        this.statusLevel8 = 0;
    }

    public PDCStatusLevelFrontRearExt(int n, int n2, int n3, int n4) {
        this.statusLevel5 = n;
        this.statusLevel6 = n2;
        this.statusLevel7 = n3;
        this.statusLevel8 = n4;
    }

    public int getStatusLevel5() {
        return this.statusLevel5;
    }

    public int getStatusLevel6() {
        return this.statusLevel6;
    }

    public int getStatusLevel7() {
        return this.statusLevel7;
    }

    public int getStatusLevel8() {
        return this.statusLevel8;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("PDCStatusLevelFrontRearExt");
        stringBuffer.append('(');
        stringBuffer.append("statusLevel5");
        stringBuffer.append('=');
        stringBuffer.append(this.statusLevel5);
        stringBuffer.append(',');
        stringBuffer.append("statusLevel6");
        stringBuffer.append('=');
        stringBuffer.append(this.statusLevel6);
        stringBuffer.append(',');
        stringBuffer.append("statusLevel7");
        stringBuffer.append('=');
        stringBuffer.append(this.statusLevel7);
        stringBuffer.append(',');
        stringBuffer.append("statusLevel8");
        stringBuffer.append('=');
        stringBuffer.append(this.statusLevel8);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

