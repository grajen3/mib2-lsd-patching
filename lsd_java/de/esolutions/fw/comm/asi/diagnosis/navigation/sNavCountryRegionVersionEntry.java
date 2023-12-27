/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

public class sNavCountryRegionVersionEntry {
    public short[] country_region_version_code;

    public short[] getCountry_region_version_code() {
        return this.country_region_version_code;
    }

    public void setCountry_region_version_code(short[] sArray) {
        this.country_region_version_code = sArray;
    }

    public sNavCountryRegionVersionEntry() {
    }

    public sNavCountryRegionVersionEntry(short[] sArray) {
        this.country_region_version_code = sArray;
    }

    public String toString() {
        return new StringBuffer("sNavCountryRegionVersionEntry{").append("country_region_version_code=").append("[").append(this.country_region_version_code == null ? "null" : new StringBuffer().append("size=").append(this.country_region_version_code.length).toString()).append("]").append("}").toString();
    }
}

