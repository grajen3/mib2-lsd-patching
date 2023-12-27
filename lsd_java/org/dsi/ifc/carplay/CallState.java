/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carplay;

public class CallState {
    public String phoneNumber;
    public String callerName;
    public int status;
    public int direction;
    public String uniqueCallID;

    public CallState() {
        this.phoneNumber = "";
        this.callerName = "";
        this.status = 0;
        this.direction = 0;
        this.uniqueCallID = "";
    }

    public CallState(String string, String string2, int n, int n2, String string3) {
        this.phoneNumber = string;
        this.callerName = string2;
        this.status = n;
        this.direction = n2;
        this.uniqueCallID = string3;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getCallerName() {
        return this.callerName;
    }

    public int getStatus() {
        return this.status;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getUniqueCallID() {
        return this.uniqueCallID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("CallState");
        stringBuffer.append('(');
        stringBuffer.append("phoneNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.phoneNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("callerName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.callerName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
        stringBuffer.append(',');
        stringBuffer.append("direction");
        stringBuffer.append('=');
        stringBuffer.append(this.direction);
        stringBuffer.append(',');
        stringBuffer.append("uniqueCallID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.uniqueCallID);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

