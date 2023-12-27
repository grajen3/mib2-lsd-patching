/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class TIMMemoUsage {
    public int memoUsage;
    public int freeListRows;

    public TIMMemoUsage() {
        this.memoUsage = 0;
        this.freeListRows = 0;
    }

    public TIMMemoUsage(int n, int n2) {
        this.memoUsage = n;
        this.freeListRows = n2;
    }

    public int getMemoUsage() {
        return this.memoUsage;
    }

    public int getFreeListRows() {
        return this.freeListRows;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("TIMMemoUsage");
        stringBuffer.append('(');
        stringBuffer.append("memoUsage");
        stringBuffer.append('=');
        stringBuffer.append(this.memoUsage);
        stringBuffer.append(',');
        stringBuffer.append("freeListRows");
        stringBuffer.append('=');
        stringBuffer.append(this.freeListRows);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

