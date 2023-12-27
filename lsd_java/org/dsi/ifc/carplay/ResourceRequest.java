/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carplay;

public class ResourceRequest {
    public int resourceID;
    public int transferType;
    public int transferPriority;
    public int takeConstraint;
    public int borrowConstraint;
    public int unborrowConstraint;

    public ResourceRequest() {
        this.resourceID = 0;
        this.transferType = 0;
        this.transferPriority = 0;
        this.takeConstraint = 0;
        this.borrowConstraint = 0;
        this.unborrowConstraint = 0;
    }

    public ResourceRequest(int n, int n2, int n3, int n4, int n5, int n6) {
        this.resourceID = n;
        this.transferType = n2;
        this.transferPriority = n3;
        this.takeConstraint = n4;
        this.borrowConstraint = n5;
        this.unborrowConstraint = n6;
    }

    public int getResourceID() {
        return this.resourceID;
    }

    public int getTransferType() {
        return this.transferType;
    }

    public int getTransferPriority() {
        return this.transferPriority;
    }

    public int getTakeConstraint() {
        return this.takeConstraint;
    }

    public int getBorrowConstraint() {
        return this.borrowConstraint;
    }

    public int getUnborrowConstraint() {
        return this.unborrowConstraint;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("ResourceRequest");
        stringBuffer.append('(');
        stringBuffer.append("resourceID");
        stringBuffer.append('=');
        stringBuffer.append(this.resourceID);
        stringBuffer.append(',');
        stringBuffer.append("transferType");
        stringBuffer.append('=');
        stringBuffer.append(this.transferType);
        stringBuffer.append(',');
        stringBuffer.append("transferPriority");
        stringBuffer.append('=');
        stringBuffer.append(this.transferPriority);
        stringBuffer.append(',');
        stringBuffer.append("takeConstraint");
        stringBuffer.append('=');
        stringBuffer.append(this.takeConstraint);
        stringBuffer.append(',');
        stringBuffer.append("borrowConstraint");
        stringBuffer.append('=');
        stringBuffer.append(this.borrowConstraint);
        stringBuffer.append(',');
        stringBuffer.append("unborrowConstraint");
        stringBuffer.append('=');
        stringBuffer.append(this.unborrowConstraint);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

