/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class ACCDistanceWarning {
    public boolean systemState;
    public short timeGap;

    public ACCDistanceWarning() {
        this.systemState = false;
        this.timeGap = 0;
    }

    public ACCDistanceWarning(boolean bl, short s) {
        this.systemState = bl;
        this.timeGap = s;
    }

    public boolean isSystemState() {
        return this.systemState;
    }

    public short getTimeGap() {
        return this.timeGap;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("ACCDistanceWarning");
        stringBuffer.append('(');
        stringBuffer.append("systemState");
        stringBuffer.append('=');
        stringBuffer.append(this.systemState);
        stringBuffer.append(',');
        stringBuffer.append("timeGap");
        stringBuffer.append('=');
        stringBuffer.append(this.timeGap);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

