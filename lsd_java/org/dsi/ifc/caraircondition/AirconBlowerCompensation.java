/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconBlowerCompensation {
    public boolean sds;
    public boolean tel;

    public AirconBlowerCompensation() {
        this.sds = false;
        this.tel = false;
    }

    public AirconBlowerCompensation(boolean bl, boolean bl2) {
        this.sds = bl;
        this.tel = bl2;
    }

    public boolean isSds() {
        return this.sds;
    }

    public boolean isTel() {
        return this.tel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("AirconBlowerCompensation");
        stringBuffer.append('(');
        stringBuffer.append("sds");
        stringBuffer.append('=');
        stringBuffer.append(this.sds);
        stringBuffer.append(',');
        stringBuffer.append("tel");
        stringBuffer.append('=');
        stringBuffer.append(this.tel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

