/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exboxm;

public class ConnectionControl {
    public int connectionRequestType;
    public int connectionRequestResult;
    public String pIN;

    public ConnectionControl() {
        this.connectionRequestType = 0;
        this.connectionRequestResult = 0;
        this.pIN = null;
    }

    public ConnectionControl(int n, int n2, String string) {
        this.connectionRequestType = n;
        this.connectionRequestResult = n2;
        this.pIN = string;
    }

    public int getConnectionRequestType() {
        return this.connectionRequestType;
    }

    public int getConnectionRequestResult() {
        return this.connectionRequestResult;
    }

    public String getPIN() {
        return this.pIN;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("ConnectionControl");
        stringBuffer.append('(');
        stringBuffer.append("connectionRequestType");
        stringBuffer.append('=');
        stringBuffer.append(this.connectionRequestType);
        stringBuffer.append(',');
        stringBuffer.append("connectionRequestResult");
        stringBuffer.append('=');
        stringBuffer.append(this.connectionRequestResult);
        stringBuffer.append(',');
        stringBuffer.append("pIN");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.pIN);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

