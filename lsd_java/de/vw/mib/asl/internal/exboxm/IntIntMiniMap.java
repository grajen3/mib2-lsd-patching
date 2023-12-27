/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm;

public class IntIntMiniMap {
    private final int defaultValue;
    private final int lastKeyIndex;
    private final int[] keyValuePairs;
    private final String[] names;
    private int found;

    public IntIntMiniMap(int n, String string, int[] nArray) {
        this.defaultValue = n;
        int n2 = nArray.length / 2;
        this.lastKeyIndex = n2 * 2 - 2;
        this.keyValuePairs = nArray;
        this.names = new String[n2];
        int n3 = 0;
        int n4 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5 = n3 < n4 ? string.indexOf(124, n3) : n4;
            this.names[i2] = new StringBuffer().append(n3 == n4 ? "???" : string.substring(n3, n5 == -1 ? n4 : n5)).append(" {").append(this.keyValuePairs[2 * i2 + 0]).append(";").append(this.keyValuePairs[2 * i2 + 1]).append("}").toString();
            n3 = n5 == -1 ? n4 : n5 + 1;
        }
    }

    public boolean isUnknownKey(int n) {
        return !this.find(n);
    }

    public boolean containsKey(int n) {
        return this.find(n);
    }

    public int get(int n) {
        return this.find(n) ? this.keyValuePairs[this.found + 1] : this.defaultValue;
    }

    public String getName(int n) {
        return this.find(n) ? this.names[this.found / 2] : "";
    }

    private boolean find(int n) {
        if (this.found >= 0 && this.keyValuePairs[this.found] == n) {
            return true;
        }
        for (int i2 = this.lastKeyIndex; i2 >= 0; i2 -= 2) {
            if (this.keyValuePairs[i2] != n) continue;
            this.found = i2;
            return true;
        }
        this.found = -1;
        return false;
    }
}

