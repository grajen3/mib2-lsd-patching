/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto;

public class ResourceRequest {
    public int resourceID;
    public int transferType;

    public ResourceRequest() {
        this.resourceID = 0;
        this.transferType = 0;
    }

    public ResourceRequest(int n, int n2) {
        this.resourceID = n;
        this.transferType = n2;
    }

    public int getResourceID() {
        return this.resourceID;
    }

    public int getTransferType() {
        return this.transferType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("ResourceRequest");
        stringBuffer.append('(');
        stringBuffer.append("resourceID");
        stringBuffer.append('=');
        stringBuffer.append(this.resourceID);
        stringBuffer.append(',');
        stringBuffer.append("transferType");
        stringBuffer.append('=');
        stringBuffer.append(this.transferType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

