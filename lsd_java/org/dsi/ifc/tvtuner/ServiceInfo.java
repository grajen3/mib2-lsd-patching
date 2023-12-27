/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tvtuner;

public class ServiceInfo {
    public long namePID;
    public int servicePID;
    public String name;
    public int sType;
    public int contentGroup;

    public ServiceInfo() {
        this.namePID = 0L;
        this.servicePID = 0;
        this.name = null;
        this.sType = 0;
        this.contentGroup = 0;
    }

    public ServiceInfo(long l, int n, String string, int n2, int n3) {
        this.namePID = l;
        this.servicePID = n;
        this.name = string;
        this.sType = n2;
        this.contentGroup = n3;
    }

    public long getNamePID() {
        return this.namePID;
    }

    public int getServicePID() {
        return this.servicePID;
    }

    public String getName() {
        return this.name;
    }

    public int getSType() {
        return this.sType;
    }

    public int getContentGroup() {
        return this.contentGroup;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("ServiceInfo");
        stringBuffer.append('(');
        stringBuffer.append("namePID");
        stringBuffer.append('=');
        stringBuffer.append(this.namePID);
        stringBuffer.append(',');
        stringBuffer.append("servicePID");
        stringBuffer.append('=');
        stringBuffer.append(this.servicePID);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("sType");
        stringBuffer.append('=');
        stringBuffer.append(this.sType);
        stringBuffer.append(',');
        stringBuffer.append("contentGroup");
        stringBuffer.append('=');
        stringBuffer.append(this.contentGroup);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

