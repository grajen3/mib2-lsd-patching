/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCPiloPaSystemState {
    public boolean pp;
    public boolean gp;

    public PDCPiloPaSystemState() {
        this.pp = false;
        this.gp = false;
    }

    public PDCPiloPaSystemState(boolean bl, boolean bl2) {
        this.pp = bl;
        this.gp = bl2;
    }

    public boolean isPp() {
        return this.pp;
    }

    public boolean isGp() {
        return this.gp;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("PDCPiloPaSystemState");
        stringBuffer.append('(');
        stringBuffer.append("pp");
        stringBuffer.append('=');
        stringBuffer.append(this.pp);
        stringBuffer.append(',');
        stringBuffer.append("gp");
        stringBuffer.append('=');
        stringBuffer.append(this.gp);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

