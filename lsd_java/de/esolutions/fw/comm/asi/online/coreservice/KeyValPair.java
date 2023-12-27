/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

public class KeyValPair {
    public String key;
    public String val;

    public String getKey() {
        return this.key;
    }

    public void setKey(String string) {
        this.key = string;
    }

    public String getVal() {
        return this.val;
    }

    public void setVal(String string) {
        this.val = string;
    }

    public KeyValPair() {
    }

    public KeyValPair(String string, String string2) {
        this.key = string;
        this.val = string2;
    }

    public String toString() {
        return new StringBuffer("KeyValPair{").append("key=").append(this.key).append(", val=").append(this.val).append("}").toString();
    }
}

