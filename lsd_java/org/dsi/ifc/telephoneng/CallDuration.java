/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class CallDuration {
    public short telCallID;
    public int telElapsedTime;

    public CallDuration() {
        this.telCallID = 0;
        this.telElapsedTime = 0;
    }

    public CallDuration(short s, int n) {
        this.telCallID = s;
        this.telElapsedTime = n;
    }

    public short getTelCallID() {
        return this.telCallID;
    }

    public int getTelElapsedTime() {
        return this.telElapsedTime;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("CallDuration");
        stringBuffer.append('(');
        stringBuffer.append("telCallID");
        stringBuffer.append('=');
        stringBuffer.append(this.telCallID);
        stringBuffer.append(',');
        stringBuffer.append("telElapsedTime");
        stringBuffer.append('=');
        stringBuffer.append(this.telElapsedTime);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

