/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

public final class CountryCount {
    private int country = -1;
    private int count = 0;

    public CountryCount(int n, int n2) {
        this.country = n;
        this.count = n2;
    }

    public int getCountry() {
        return this.country;
    }

    public void setCountry(int n) {
        this.country = n;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int n) {
        this.count = n;
    }

    public void incrementCount() {
        ++this.count;
    }
}

