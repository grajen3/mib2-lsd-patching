/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono;

public class TransferState {
    public int state;
    public String deviceId;

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String string) {
        this.deviceId = string;
    }

    public TransferState() {
    }

    public TransferState(int n, String string) {
        this.state = n;
        this.deviceId = string;
    }

    public String toString() {
        return new StringBuffer("TransferState{").append("state=").append(this.state).append(", deviceId=").append(this.deviceId).append("}").toString();
    }
}

