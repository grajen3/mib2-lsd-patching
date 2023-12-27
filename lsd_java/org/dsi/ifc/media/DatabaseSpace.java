/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

public class DatabaseSpace {
    public long size;
    public long sizeAvail;
    public long maxEntries;
    public long numEntries;

    public DatabaseSpace() {
        this.size = 0L;
        this.sizeAvail = 0L;
        this.maxEntries = 0L;
        this.numEntries = 0L;
    }

    public DatabaseSpace(long l, long l2, long l3, long l4) {
        this.size = l;
        this.sizeAvail = l2;
        this.maxEntries = l3;
        this.numEntries = l4;
    }

    public long getSize() {
        return this.size;
    }

    public long getSizeAvail() {
        return this.sizeAvail;
    }

    public long getMaxEntries() {
        return this.maxEntries;
    }

    public long getNumEntries() {
        return this.numEntries;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("DatabaseSpace");
        stringBuffer.append('(');
        stringBuffer.append("size");
        stringBuffer.append('=');
        stringBuffer.append(this.size);
        stringBuffer.append(',');
        stringBuffer.append("sizeAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.sizeAvail);
        stringBuffer.append(',');
        stringBuffer.append("maxEntries");
        stringBuffer.append('=');
        stringBuffer.append(this.maxEntries);
        stringBuffer.append(',');
        stringBuffer.append("numEntries");
        stringBuffer.append('=');
        stringBuffer.append(this.numEntries);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

