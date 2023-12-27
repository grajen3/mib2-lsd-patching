/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carauxheatercooler;

public class AuxHeaterCoolerMode {
    public int mode;
    public int state;
    public int reason;

    public AuxHeaterCoolerMode() {
        this.mode = 0;
        this.state = 0;
        this.reason = 0;
    }

    public AuxHeaterCoolerMode(int n, int n2, int n3) {
        this.mode = n;
        this.state = n2;
        this.reason = n3;
    }

    public int getMode() {
        return this.mode;
    }

    public int getState() {
        return this.state;
    }

    public int getReason() {
        return this.reason;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AuxHeaterCoolerMode");
        stringBuffer.append('(');
        stringBuffer.append("mode");
        stringBuffer.append('=');
        stringBuffer.append(this.mode);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("reason");
        stringBuffer.append('=');
        stringBuffer.append(this.reason);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

