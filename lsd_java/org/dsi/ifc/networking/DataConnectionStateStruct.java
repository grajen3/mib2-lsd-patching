/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

public class DataConnectionStateStruct {
    public int contextState;
    public int operationMode;

    public DataConnectionStateStruct() {
        this.contextState = 0;
        this.operationMode = 0;
    }

    public DataConnectionStateStruct(int n, int n2) {
        this.contextState = n;
        this.operationMode = n2;
    }

    public int getContextState() {
        return this.contextState;
    }

    public int getOperationMode() {
        return this.operationMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("DataConnectionStateStruct");
        stringBuffer.append('(');
        stringBuffer.append("contextState");
        stringBuffer.append('=');
        stringBuffer.append(this.contextState);
        stringBuffer.append(',');
        stringBuffer.append("operationMode");
        stringBuffer.append('=');
        stringBuffer.append(this.operationMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

