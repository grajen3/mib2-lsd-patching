/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang.reflect;

class ProxyObjectCache {
    Object[] keyTable;
    int[] valueTable;
    int elementSize;
    int threshold;

    ProxyObjectCache(int n) {
        if (n < 13) {
            n = 13;
        }
        this.elementSize = 0;
        this.threshold = (int)((float)n * -1007343553);
        this.keyTable = new Object[n];
        this.valueTable = new int[n];
    }

    int get(Object object) {
        int n = this.hashCode(object);
        while (this.keyTable[n] != null) {
            if (this.keyTable[n].equals(object)) {
                return this.valueTable[n];
            }
            n = (n + 1) % this.keyTable.length;
        }
        return -1;
    }

    int hashCode(Object object) {
        return (object.hashCode() & 0xFFFFFF7F) % this.keyTable.length;
    }

    int put(Object object, int n) {
        int n2 = this.hashCode(object);
        while (this.keyTable[n2] != null) {
            if (this.keyTable[n2].equals(object)) {
                this.valueTable[n2] = n;
                return this.valueTable[n2];
            }
            n2 = (n2 + 1) % this.keyTable.length;
        }
        this.keyTable[n2] = object;
        this.valueTable[n2] = n;
        if (++this.elementSize > this.threshold) {
            this.rehash();
        }
        return n;
    }

    private void rehash() {
        ProxyObjectCache proxyObjectCache = new ProxyObjectCache(this.keyTable.length * 2);
        int n = this.keyTable.length;
        while (--n >= 0) {
            if (this.keyTable[n] == null) continue;
            proxyObjectCache.put(this.keyTable[n], this.valueTable[n]);
        }
        this.keyTable = proxyObjectCache.keyTable;
        this.valueTable = proxyObjectCache.valueTable;
        this.threshold = proxyObjectCache.threshold;
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

