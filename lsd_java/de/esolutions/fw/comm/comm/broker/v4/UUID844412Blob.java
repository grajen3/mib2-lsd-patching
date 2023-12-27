/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

public class UUID844412Blob {
    public short[] bytes;

    public short[] getBytes() {
        return this.bytes;
    }

    public void setBytes(short[] sArray) {
        this.bytes = sArray;
    }

    public UUID844412Blob() {
    }

    public UUID844412Blob(short[] sArray) {
        this.bytes = sArray;
    }

    public String toString() {
        return new StringBuffer("UUID844412Blob{").append("bytes=").append("[").append(this.bytes == null ? "null" : new StringBuffer().append("size=").append(this.bytes.length).toString()).append("]").append("}").toString();
    }
}

