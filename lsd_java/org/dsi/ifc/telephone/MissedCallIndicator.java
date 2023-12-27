/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class MissedCallIndicator {
    public boolean missedCall;
    public int missedCallCount;

    public MissedCallIndicator() {
        this.missedCall = false;
        this.missedCallCount = 0;
    }

    public MissedCallIndicator(boolean bl, int n) {
        this.missedCall = bl;
        this.missedCallCount = n;
    }

    public boolean isMissedCall() {
        return this.missedCall;
    }

    public int getMissedCallCount() {
        return this.missedCallCount;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("MissedCallIndicator");
        stringBuffer.append('(');
        stringBuffer.append("missedCall");
        stringBuffer.append('=');
        stringBuffer.append(this.missedCall);
        stringBuffer.append(',');
        stringBuffer.append("missedCallCount");
        stringBuffer.append('=');
        stringBuffer.append(this.missedCallCount);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

