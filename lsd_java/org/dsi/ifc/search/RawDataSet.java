/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

public class RawDataSet {
    public long id;
    public int entryType;
    public int entryFlags;
    public byte[] data;

    public RawDataSet() {
        this.id = 0L;
        this.entryType = 1;
        this.entryFlags = 0;
        this.data = null;
    }

    public RawDataSet(long l, int n, int n2, byte[] byArray) {
        this.id = l;
        this.entryType = n;
        this.entryFlags = n2;
        this.data = byArray;
    }

    public long getId() {
        return this.id;
    }

    public int getEntryType() {
        return this.entryType;
    }

    public int getEntryFlags() {
        return this.entryFlags;
    }

    public byte[] getData() {
        return this.data;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("RawDataSet");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("entryType");
        stringBuffer.append('=');
        stringBuffer.append(this.entryType);
        stringBuffer.append(',');
        stringBuffer.append("entryFlags");
        stringBuffer.append('=');
        stringBuffer.append(this.entryFlags);
        stringBuffer.append(',');
        stringBuffer.append("data");
        stringBuffer.append('[');
        if (this.data != null) {
            stringBuffer.append(this.data.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.data != null) {
            int n = this.data.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.data[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.data);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

