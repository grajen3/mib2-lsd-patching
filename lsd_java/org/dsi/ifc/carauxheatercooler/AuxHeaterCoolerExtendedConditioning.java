/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carauxheatercooler;

public class AuxHeaterCoolerExtendedConditioning {
    public boolean z1rl;
    public boolean z1rr;
    public boolean z2rl;
    public boolean z2rr;

    public AuxHeaterCoolerExtendedConditioning() {
        this.z1rl = false;
        this.z1rr = false;
        this.z2rl = false;
        this.z2rr = false;
    }

    public AuxHeaterCoolerExtendedConditioning(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.z1rl = bl;
        this.z1rr = bl2;
        this.z2rl = bl3;
        this.z2rr = bl4;
    }

    public boolean isZ1rl() {
        return this.z1rl;
    }

    public boolean isZ1rr() {
        return this.z1rr;
    }

    public boolean isZ2rl() {
        return this.z2rl;
    }

    public boolean isZ2rr() {
        return this.z2rr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AuxHeaterCoolerExtendedConditioning");
        stringBuffer.append('(');
        stringBuffer.append("z1rl");
        stringBuffer.append('=');
        stringBuffer.append(this.z1rl);
        stringBuffer.append(',');
        stringBuffer.append("z1rr");
        stringBuffer.append('=');
        stringBuffer.append(this.z1rr);
        stringBuffer.append(',');
        stringBuffer.append("z2rl");
        stringBuffer.append('=');
        stringBuffer.append(this.z2rl);
        stringBuffer.append(',');
        stringBuffer.append("z2rr");
        stringBuffer.append('=');
        stringBuffer.append(this.z2rr);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

