/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class FACResponseData {
    public int telFACStatus;
    public int telFacility;
    public short telClass;

    public FACResponseData() {
        this.telFACStatus = 0;
        this.telFacility = 0;
        this.telClass = 0;
    }

    public FACResponseData(int n, int n2, short s) {
        this.telFACStatus = n;
        this.telFacility = n2;
        this.telClass = s;
    }

    public int getTelFACStatus() {
        return this.telFACStatus;
    }

    public int getTelFacility() {
        return this.telFacility;
    }

    public short getTelClass() {
        return this.telClass;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("FACResponseData");
        stringBuffer.append('(');
        stringBuffer.append("telFACStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.telFACStatus);
        stringBuffer.append(',');
        stringBuffer.append("telFacility");
        stringBuffer.append('=');
        stringBuffer.append(this.telFacility);
        stringBuffer.append(',');
        stringBuffer.append("telClass");
        stringBuffer.append('=');
        stringBuffer.append(this.telClass);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

