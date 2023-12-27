/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

public class WlanDevice {
    public long hwaddr;
    public String name;
    public int state;
    public int wlantype;
    public boolean knownAtStartUp;

    public long getHwaddr() {
        return this.hwaddr;
    }

    public void setHwaddr(long l) {
        this.hwaddr = l;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public int getWlantype() {
        return this.wlantype;
    }

    public void setWlantype(int n) {
        this.wlantype = n;
    }

    public boolean isKnownAtStartUp() {
        return this.knownAtStartUp;
    }

    public void setKnownAtStartUp(boolean bl) {
        this.knownAtStartUp = bl;
    }

    public WlanDevice() {
    }

    public WlanDevice(long l, String string, int n, int n2, boolean bl) {
        this.hwaddr = l;
        this.name = string;
        this.state = n;
        this.wlantype = n2;
        this.knownAtStartUp = bl;
    }

    public String toString() {
        return new StringBuffer("WlanDevice{").append("hwaddr=").append(this.hwaddr).append(", name=").append(this.name).append(", state=").append(this.state).append(", wlantype=").append(this.wlantype).append(", knownAtStartUp=").append(this.knownAtStartUp).append("}").toString();
    }
}

