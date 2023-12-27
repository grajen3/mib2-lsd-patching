/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.UUID844412Blob;

public class InstanceID {
    public UUID844412Blob id;
    public long handle;
    public UUID844412Blob key;

    public UUID844412Blob getId() {
        return this.id;
    }

    public void setId(UUID844412Blob uUID844412Blob) {
        this.id = uUID844412Blob;
    }

    public long getHandle() {
        return this.handle;
    }

    public void setHandle(long l) {
        this.handle = l;
    }

    public UUID844412Blob getKey() {
        return this.key;
    }

    public void setKey(UUID844412Blob uUID844412Blob) {
        this.key = uUID844412Blob;
    }

    public InstanceID() {
        this.id = null;
        this.key = null;
    }

    public InstanceID(UUID844412Blob uUID844412Blob, long l, UUID844412Blob uUID844412Blob2) {
        this.id = uUID844412Blob;
        this.handle = l;
        this.key = uUID844412Blob2;
    }

    public String toString() {
        return new StringBuffer("InstanceID{").append("id=").append(this.id).append(", handle=").append(this.handle).append(", key=").append(this.key).append("}").toString();
    }
}

