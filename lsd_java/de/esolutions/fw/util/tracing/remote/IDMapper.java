/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public class IDMapper {
    private int[] map;
    private short[] typeMap;
    private int size;
    private int max;

    public IDMapper(int n) {
        this.map = new int[n];
        this.typeMap = new short[n];
        this.size = n;
        this.max = -1;
    }

    private void grow(int n) {
        int[] nArray = this.map;
        short[] sArray = this.typeMap;
        int n2 = this.size;
        this.size = n;
        this.map = new int[this.size];
        this.typeMap = new short[this.size];
        System.arraycopy((Object)nArray, 0, (Object)this.map, 0, n2);
        System.arraycopy((Object)sArray, 0, (Object)this.typeMap, 0, n2);
    }

    public void setMapping(short s, int n, int n2) {
        if (n >= this.size) {
            this.grow(n + 256);
        }
        this.typeMap[n] = s;
        this.map[n] = n2;
        if (n > this.max) {
            this.max = n;
        }
    }

    public int getMaxExtern() {
        return this.max;
    }

    public short getType(int n) {
        if (n >= this.size) {
            return 0;
        }
        return this.typeMap[n];
    }

    public int getInternalID(int n) {
        if (n >= this.size) {
            return -1;
        }
        return this.map[n];
    }

    public TraceEntityURI getInternalURI(int n) {
        if (n >= this.size) {
            return null;
        }
        return new TraceEntityURI(this.typeMap[n], this.map[n]);
    }

    public TraceEntityURI getInternalURI(TraceEntityURI traceEntityURI) {
        int n = this.getInternalID(traceEntityURI.getId());
        if (n != -1) {
            return new TraceEntityURI(traceEntityURI.getType(), n);
        }
        return null;
    }
}

