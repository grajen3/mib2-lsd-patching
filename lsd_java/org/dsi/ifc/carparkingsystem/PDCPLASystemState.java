/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCPLASystemState {
    public boolean pdcSystemState;
    public boolean plaSystemState;

    public PDCPLASystemState() {
        this.pdcSystemState = false;
        this.plaSystemState = false;
    }

    public PDCPLASystemState(boolean bl, boolean bl2) {
        this.pdcSystemState = bl;
        this.plaSystemState = bl2;
    }

    public boolean isPdcSystemState() {
        return this.pdcSystemState;
    }

    public boolean isPlaSystemState() {
        return this.plaSystemState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("PDCPLASystemState");
        stringBuffer.append('(');
        stringBuffer.append("pdcSystemState");
        stringBuffer.append('=');
        stringBuffer.append(this.pdcSystemState);
        stringBuffer.append(',');
        stringBuffer.append("plaSystemState");
        stringBuffer.append('=');
        stringBuffer.append(this.plaSystemState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

