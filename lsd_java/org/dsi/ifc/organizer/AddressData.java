/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.global.ResourceLocator;

public class AddressData {
    public int addressType;
    public String street;
    public String locality;
    public String localitySound;
    public String country;
    public String region;
    public String postalCode;
    public boolean topDestination;
    public String geoPosition;
    public int navLocationVersion;
    public byte[] navLocation;
    public ResourceLocator navPicture;

    public AddressData() {
        this.addressType = 0;
        this.street = null;
        this.locality = null;
        this.country = null;
        this.region = null;
        this.postalCode = null;
        this.topDestination = false;
        this.geoPosition = null;
        this.navLocationVersion = 0;
        this.navLocation = null;
        this.navPicture = null;
    }

    public AddressData(int n, String string, String string2, String string3, String string4, String string5, String string6, boolean bl, String string7, int n2, byte[] byArray, ResourceLocator resourceLocator) {
        this.addressType = n;
        this.street = string;
        this.locality = string2;
        this.localitySound = string3;
        this.country = string4;
        this.region = string5;
        this.postalCode = string6;
        this.topDestination = bl;
        this.geoPosition = string7;
        this.navLocationVersion = n2;
        this.navLocation = byArray;
        this.navPicture = resourceLocator;
    }

    public int getAddressType() {
        return this.addressType;
    }

    public String getStreet() {
        return this.street;
    }

    public String getLocality() {
        return this.locality;
    }

    public String getLocalitySound() {
        return this.localitySound;
    }

    public String getCountry() {
        return this.country;
    }

    public String getRegion() {
        return this.region;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public boolean isTopDestination() {
        return this.topDestination;
    }

    public String getGeoPosition() {
        return this.geoPosition;
    }

    public int getNavLocationVersion() {
        return this.navLocationVersion;
    }

    public byte[] getNavLocation() {
        return this.navLocation;
    }

    public ResourceLocator getNavPicture() {
        return this.navPicture;
    }

    private String arrayToString(Object object, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            if (!(object instanceof byte[])) continue;
            stringBuffer.append(((byte[])object)[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1800);
        stringBuffer.append("AddressData");
        stringBuffer.append('(');
        stringBuffer.append("addressType");
        stringBuffer.append('=');
        stringBuffer.append(this.addressType);
        stringBuffer.append(',');
        stringBuffer.append("street");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.street);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("locality");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.locality);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("localitySound");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.localitySound);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.country);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("region");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.region);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("postalCode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.postalCode);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("topDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.topDestination);
        stringBuffer.append(',');
        stringBuffer.append("geoPosition");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.geoPosition);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("navLocationVersion");
        stringBuffer.append('=');
        stringBuffer.append(this.navLocationVersion);
        stringBuffer.append(',');
        stringBuffer.append("navLocation");
        stringBuffer.append('[');
        if (this.navLocation != null) {
            stringBuffer.append(this.navLocation.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.navLocation != null) {
            int n = this.navLocation.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.navLocation[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.navLocation);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("navPicture");
        stringBuffer.append('=');
        stringBuffer.append(this.navPicture);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

