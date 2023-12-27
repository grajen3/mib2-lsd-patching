/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

public class sOLRLocationReference {
    public byte[] location;

    public byte[] getLocation() {
        return this.location;
    }

    public void setLocation(byte[] byArray) {
        this.location = byArray;
    }

    public sOLRLocationReference() {
    }

    public sOLRLocationReference(byte[] byArray) {
        this.location = byArray;
    }

    public String toString() {
        return new StringBuffer("sOLRLocationReference{").append("location=").append("[").append(this.location == null ? "null" : new StringBuffer().append("size=").append(this.location.length).toString()).append("]").append("}").toString();
    }
}

