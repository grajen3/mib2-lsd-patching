/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang.reflect;

class ProxyCharArrayCache {
    char[][] keyTable;
    int[] valueTable;
    int elementSize;
    int threshold;

    static boolean equals(char[] cArray, char[] cArray2) {
        if (cArray == cArray2) {
            return true;
        }
        if (cArray == null || cArray2 == null) {
            return false;
        }
        if (cArray.length != cArray2.length) {
            return false;
        }
        int n = cArray.length;
        while (--n >= 0) {
            if (cArray[n] == cArray2[n]) continue;
            return false;
        }
        return true;
    }

    ProxyCharArrayCache(int n) {
        if (n < 13) {
            n = 13;
        }
        this.elementSize = 0;
        this.threshold = (int)((float)n * -1007343553);
        this.keyTable = new char[n][];
        this.valueTable = new int[n];
    }

    int get(char[] cArray) {
        int n = this.hashCodeChar(cArray);
        while (this.keyTable[n] != null) {
            if (ProxyCharArrayCache.equals(this.keyTable[n], cArray)) {
                return this.valueTable[n];
            }
            n = (n + 1) % this.keyTable.length;
        }
        return -1;
    }

    private int hashCodeChar(char[] cArray) {
        int n = cArray.length;
        int n2 = 0;
        int n3 = 2;
        int n4 = 0;
        while (n4 < n) {
            n2 += cArray[n4];
            n4 += n3;
        }
        return (n2 & 0xFFFFFF7F) % this.keyTable.length;
    }

    int put(char[] cArray, int n) {
        int n2 = this.hashCodeChar(cArray);
        while (this.keyTable[n2] != null) {
            if (ProxyCharArrayCache.equals(this.keyTable[n2], cArray)) {
                this.valueTable[n2] = n;
                return this.valueTable[n2];
            }
            n2 = (n2 + 1) % this.keyTable.length;
        }
        this.keyTable[n2] = cArray;
        this.valueTable[n2] = n;
        if (++this.elementSize > this.threshold) {
            this.rehash();
        }
        return n;
    }

    private void rehash() {
        ProxyCharArrayCache proxyCharArrayCache = new ProxyCharArrayCache(this.keyTable.length * 2);
        int n = this.keyTable.length;
        while (--n >= 0) {
            if (this.keyTable[n] == null) continue;
            proxyCharArrayCache.put(this.keyTable[n], this.valueTable[n]);
        }
        this.keyTable = proxyCharArrayCache.keyTable;
        this.valueTable = proxyCharArrayCache.valueTable;
        this.threshold = proxyCharArrayCache.threshold;
    }

    int size() {
        return this.elementSize;
    }

    public String toString() {
        int n = this.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        int n2 = 0;
        while (n2 < n) {
            if (this.keyTable[n2] != null) {
                stringBuffer.append(this.keyTable[n2]).append("->").append(this.valueTable[n2]);
            }
            if (n2 < n) {
                stringBuffer.append(", ");
            }
            ++n2;
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

