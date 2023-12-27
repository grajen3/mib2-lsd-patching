/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

public class BluetoothDevice {
    public String name;
    public long address;
    public boolean connected;
    public boolean knownAtStartup;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public long getAddress() {
        return this.address;
    }

    public void setAddress(long l) {
        this.address = l;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void setConnected(boolean bl) {
        this.connected = bl;
    }

    public boolean isKnownAtStartup() {
        return this.knownAtStartup;
    }

    public void setKnownAtStartup(boolean bl) {
        this.knownAtStartup = bl;
    }

    public BluetoothDevice() {
    }

    public BluetoothDevice(String string, long l, boolean bl, boolean bl2) {
        this.name = string;
        this.address = l;
        this.connected = bl;
        this.knownAtStartup = bl2;
    }

    public String toString() {
        return new StringBuffer("BluetoothDevice{").append("name=").append(this.name).append(", address=").append(this.address).append(", connected=").append(this.connected).append(", knownAtStartup=").append(this.knownAtStartup).append("}").toString();
    }
}

