/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto;

public class Resource {
    public int resourceID;
    public int owner;

    public Resource() {
        this.resourceID = 0;
        this.owner = 0;
    }

    public Resource(int n, int n2) {
        this.resourceID = n;
        this.owner = n2;
    }

    public int getResourceID() {
        return this.resourceID;
    }

    public int getOwner() {
        return this.owner;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("Resource");
        stringBuffer.append('(');
        stringBuffer.append("resourceID");
        stringBuffer.append('=');
        stringBuffer.append(this.resourceID);
        stringBuffer.append(',');
        stringBuffer.append("owner");
        stringBuffer.append('=');
        stringBuffer.append(this.owner);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

