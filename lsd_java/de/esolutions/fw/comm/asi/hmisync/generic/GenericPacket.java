/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic;

import java.util.Arrays;

public class GenericPacket {
    public int keyword;
    public String[] data;

    public int getKeyword() {
        return this.keyword;
    }

    public void setKeyword(int n) {
        this.keyword = n;
    }

    public String[] getData() {
        return this.data;
    }

    public void setData(String[] stringArray) {
        this.data = stringArray;
    }

    public GenericPacket() {
    }

    public GenericPacket(int n, String[] stringArray) {
        this.keyword = n;
        this.data = stringArray;
    }

    public String toString() {
        return new StringBuffer("GenericPacket{").append("keyword=").append(this.keyword).append(", data=").append("[").append(this.data == null ? "null" : Arrays.asList(this.data).toString()).append("]").append("}").toString();
    }
}

