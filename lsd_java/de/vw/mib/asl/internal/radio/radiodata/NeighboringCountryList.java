/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

public class NeighboringCountryList {
    private int homeCountry = -1;
    int[] neighboringCountries = null;

    public NeighboringCountryList(int n, int[] nArray) {
        this.homeCountry = n;
        this.neighboringCountries = nArray;
    }

    public int[] getNeighboringCountries() {
        return this.neighboringCountries;
    }

    public void setNeighboringCountries(int[] nArray) {
        this.neighboringCountries = nArray;
    }

    public int getHomeCountry() {
        return this.homeCountry;
    }

    public void setHomeCountry(int n) {
        this.homeCountry = n;
    }
}

