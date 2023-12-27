/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang.reflect;

class ProxyNameAndTypeCache {
    int[][] keyTable;
    int[] valueTable;
    int elementSize;
    int threshold;

    ProxyNameAndTypeCache(int n) {
        if (n < 13) {
            n = 13;
        }
        this.elementSize = 0;
        this.threshold = (int)((float)n * -1007343553);
        this.keyTable = new int[n][];
        this.valueTable = new int[n];
    }

    int get(int[] nArray) {
        int n = this.hashCode(nArray);
        while (this.keyTable[n] != null) {
            if (this.keyTable[n][0] == nArray[0] && this.keyTable[n][1] == nArray[1]) {
                return this.valueTable[n];
            }
            n = (n + 1) % this.keyTable.length;
        }
        return -1;
    }

    int hashCode(int[] nArray) {
        return (nArray[0] + nArray[1]) % this.keyTable.length;
    }

    int put(int[] nArray, int n) {
        int n2 = this.hashCode(nArray);
        while (this.keyTable[n2] != null) {
            if (this.keyTable[n2][0] == nArray[0] && this.keyTable[n2][1] == nArray[1]) {
                this.valueTable[n2] = n;
                return this.valueTable[n2];
            }
            n2 = (n2 + 1) % this.keyTable.length;
        }
        this.keyTable[n2] = nArray;
        this.valueTable[n2] = n;
        if (++this.elementSize > this.threshold) {
            this.rehash();
        }
        return n;
    }

    private void rehash() {
        ProxyNameAndTypeCache proxyNameAndTypeCache = new ProxyNameAndTypeCache(this.keyTable.length * 2);
        int n = this.keyTable.length;
        while (--n >= 0) {
            if (this.keyTable[n] == null) continue;
            proxyNameAndTypeCache.put(this.keyTable[n], this.valueTable[n]);
        }
        this.keyTable = proxyNameAndTypeCache.keyTable;
        this.valueTable = proxyNameAndTypeCache.valueTable;
        this.threshold = proxyNameAndTypeCache.threshold;
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

