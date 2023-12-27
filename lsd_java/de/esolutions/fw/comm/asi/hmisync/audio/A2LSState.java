/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

public class A2LSState {
    public String currentDevice;
    public String requestingDevice;

    public String getCurrentDevice() {
        return this.currentDevice;
    }

    public void setCurrentDevice(String string) {
        this.currentDevice = string;
    }

    public String getRequestingDevice() {
        return this.requestingDevice;
    }

    public void setRequestingDevice(String string) {
        this.requestingDevice = string;
    }

    public A2LSState() {
    }

    public A2LSState(String string, String string2) {
        this.currentDevice = string;
        this.requestingDevice = string2;
    }

    public String toString() {
        return new StringBuffer("A2LSState{").append("currentDevice=").append(this.currentDevice).append(", requestingDevice=").append(this.requestingDevice).append("}").toString();
    }
}

