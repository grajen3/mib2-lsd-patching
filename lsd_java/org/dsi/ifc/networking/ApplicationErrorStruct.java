/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

public class ApplicationErrorStruct {
    public int applicationID;
    public int result;

    public ApplicationErrorStruct() {
        this.applicationID = 0;
        this.result = 0;
    }

    public ApplicationErrorStruct(int n, int n2) {
        this.applicationID = n;
        this.result = n2;
    }

    public int getApplicationID() {
        return this.applicationID;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("ApplicationErrorStruct");
        stringBuffer.append('(');
        stringBuffer.append("applicationID");
        stringBuffer.append('=');
        stringBuffer.append(this.applicationID);
        stringBuffer.append(',');
        stringBuffer.append("result");
        stringBuffer.append('=');
        stringBuffer.append(this.result);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

