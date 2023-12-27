/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

public class sDTCPState {
    public String sdisSerialNumber;
    public int encryption_state;

    public String getSdisSerialNumber() {
        return this.sdisSerialNumber;
    }

    public void setSdisSerialNumber(String string) {
        this.sdisSerialNumber = string;
    }

    public int getEncryption_state() {
        return this.encryption_state;
    }

    public void setEncryption_state(int n) {
        this.encryption_state = n;
    }

    public sDTCPState() {
    }

    public sDTCPState(String string, int n) {
        this.sdisSerialNumber = string;
        this.encryption_state = n;
    }

    public String toString() {
        return new StringBuffer("sDTCPState{").append("sdisSerialNumber=").append(this.sdisSerialNumber).append(", encryption_state=").append(this.encryption_state).append("}").toString();
    }
}

