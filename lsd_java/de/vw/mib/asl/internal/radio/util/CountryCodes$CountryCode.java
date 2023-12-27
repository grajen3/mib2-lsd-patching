/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.util;

public class CountryCodes$CountryCode {
    public String country;
    public String itu;
    public short pi;
    public String ecc;

    public CountryCodes$CountryCode(String string, String string2, int n, String string3) {
        this.country = string;
        this.itu = string2;
        this.pi = (short)n;
        this.ecc = string3;
    }
}

