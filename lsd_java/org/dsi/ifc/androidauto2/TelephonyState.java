/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto2;

public class TelephonyState {
    public int signalStrength;

    public TelephonyState() {
        this.signalStrength = 0;
    }

    public TelephonyState(int n) {
        this.signalStrength = n;
    }

    public int getSignalStrength() {
        return this.signalStrength;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("TelephonyState");
        stringBuffer.append('(');
        stringBuffer.append("signalStrength");
        stringBuffer.append('=');
        stringBuffer.append(this.signalStrength);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

