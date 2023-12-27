/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

public class StationInfo {
    public long id;
    public String name;
    public int serviceType;
    public int contentGroup;

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(int n) {
        this.serviceType = n;
    }

    public int getContentGroup() {
        return this.contentGroup;
    }

    public void setContentGroup(int n) {
        this.contentGroup = n;
    }

    public StationInfo() {
    }

    public StationInfo(long l, String string, int n, int n2) {
        this.id = l;
        this.name = string;
        this.serviceType = n;
        this.contentGroup = n2;
    }

    public String toString() {
        return new StringBuffer("StationInfo{").append("id=").append(this.id).append(", name=").append(this.name).append(", serviceType=").append(this.serviceType).append(", contentGroup=").append(this.contentGroup).append("}").toString();
    }
}

