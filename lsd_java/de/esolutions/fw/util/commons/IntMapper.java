/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.Buffer;

public class IntMapper {
    private static final boolean DEBUG;
    private int[][] map;
    private int[] defValue;
    private String name;
    public boolean hasDefault = false;
    public int length;

    public IntMapper(String string, int[][] nArray) {
        this.create(string, nArray);
    }

    public IntMapper(String string, int[][] nArray, int[] nArray2) {
        this.defValue = nArray2;
        this.hasDefault = true;
        this.create(string, nArray);
    }

    private final void create(String string, int[][] nArray) {
        this.map = nArray;
        this.length = this.map.length;
        this.name = string;
    }

    public final String getName() {
        return this.name;
    }

    private final String instanceName() {
        return new StringBuffer().append("IntMapper[").append(this.name).append("]").toString();
    }

    public void set(int n, int n2) {
        if (0 <= n && n < this.length) {
            this.map[n][1] = n2;
        } else if (this.hasDefault) {
            throw new IndexOutOfBoundsException(new StringBuffer().append(this.instanceName()).append(".set: Index ").append(n).append(" found as key, ignored").toString());
        }
    }

    public boolean isKey(int n) {
        for (int i2 = 0; i2 < this.length; ++i2) {
            if (n != this.map[i2][0]) continue;
            return true;
        }
        return false;
    }

    public int getValue(int n) {
        for (int i2 = 0; i2 < this.length; ++i2) {
            if (n != this.map[i2][0]) continue;
            return this.map[i2][1];
        }
        if (this.hasDefault) {
            return this.defValue[1];
        }
        throw new IndexOutOfBoundsException(new StringBuffer().append(this.instanceName()).append(" Index ").append(n).append(" not in map").toString());
    }

    public int getKey(int n) {
        for (int i2 = 0; i2 < this.length; ++i2) {
            if (n != this.map[i2][1]) continue;
            return this.map[i2][0];
        }
        if (this.hasDefault) {
            return this.defValue[1];
        }
        throw new IndexOutOfBoundsException(new StringBuffer().append(this.instanceName()).append(" Value ").append(n).append(" not in map").toString());
    }

    public final String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.instanceName()).append("(size=").append(this.length).append(", ");
        if (this.hasDefault) {
            buffer.append("defaultVal:(").append(this.defValue[0]).append(",").append(this.defValue[1]).append(")");
        } else {
            buffer.append("no defaultVal - throws exceptions");
        }
        buffer.append(" data:");
        for (int i2 = 0; i2 < this.length; ++i2) {
            buffer.append("(").append(this.map[i2][0]).append(",").append(this.map[i2][1]).append(")");
        }
        buffer.append(")");
        return buffer.toString();
    }
}

