/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

public class ConnectionStateInformationStruct {
    public int connectionState;
    public int applicationID;

    public ConnectionStateInformationStruct() {
        this.connectionState = 0;
        this.applicationID = 0;
    }

    public ConnectionStateInformationStruct(int n, int n2) {
        this.connectionState = n;
        this.applicationID = n2;
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public int getApplicationID() {
        return this.applicationID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("ConnectionStateInformationStruct");
        stringBuffer.append('(');
        stringBuffer.append("connectionState");
        stringBuffer.append('=');
        stringBuffer.append(this.connectionState);
        stringBuffer.append(',');
        stringBuffer.append("applicationID");
        stringBuffer.append('=');
        stringBuffer.append(this.applicationID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

