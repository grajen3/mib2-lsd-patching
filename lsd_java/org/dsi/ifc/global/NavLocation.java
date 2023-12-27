/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

import java.util.Arrays;
import org.dsi.ifc.global.NavLocationDescriptor;

public class NavLocation {
    public String version;
    public boolean versionOfLocationStructureValid;
    public boolean positionValid;
    public int longitude;
    public int latitude;
    public int altitude;
    public String country;
    public String countryAbbreviation;
    public String housenumber;
    public String junction;
    public String street;
    public String streetRefinement;
    public String town;
    public String towncenter;
    public String townRefinement;
    public String zipCode;
    public NavLocationDescriptor[] proprietaryData;

    public NavLocation() {
        this.version = "1.0.0.Panasonic";
        this.versionOfLocationStructureValid = true;
        this.positionValid = false;
        this.longitude = 0;
        this.latitude = 0;
        this.altitude = 0;
        this.country = null;
        this.countryAbbreviation = null;
        this.housenumber = null;
        this.junction = null;
        this.street = null;
        this.streetRefinement = null;
        this.town = null;
        this.towncenter = null;
        this.townRefinement = null;
        this.zipCode = null;
        this.proprietaryData = null;
    }

    public NavLocation(String string, boolean bl, boolean bl2, int n, int n2, int n3, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, NavLocationDescriptor[] navLocationDescriptorArray) {
        this.version = string;
        this.versionOfLocationStructureValid = bl;
        this.positionValid = bl2;
        this.longitude = n;
        this.latitude = n2;
        this.altitude = n3;
        this.country = string2;
        this.countryAbbreviation = string3;
        this.housenumber = string4;
        this.junction = string5;
        this.street = string6;
        this.streetRefinement = string7;
        this.town = string8;
        this.towncenter = string9;
        this.townRefinement = string10;
        this.zipCode = string11;
        this.proprietaryData = navLocationDescriptorArray;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isVersionOfLocationStructureValid() {
        return this.versionOfLocationStructureValid;
    }

    public boolean isPositionValid() {
        return this.positionValid;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getAltitude() {
        return this.altitude;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public String getHousenumber() {
        return this.housenumber;
    }

    public String getJunction() {
        return this.junction;
    }

    public String getStreet() {
        return this.street;
    }

    public String getStreetRefinement() {
        return this.streetRefinement;
    }

    public String getTown() {
        return this.town;
    }

    public String getTowncenter() {
        return this.towncenter;
    }

    public String getTownRefinement() {
        return this.townRefinement;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public NavLocationDescriptor[] getProprietaryData() {
        return this.proprietaryData;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Location [altitude=");
        stringBuffer.append(this.altitude);
        stringBuffer.append(", country=");
        stringBuffer.append(this.country);
        stringBuffer.append(", countryAbbreviation=");
        stringBuffer.append(this.countryAbbreviation);
        stringBuffer.append(", housenumber=");
        stringBuffer.append(this.housenumber);
        stringBuffer.append(", junction=");
        stringBuffer.append(this.junction);
        stringBuffer.append(", latitude=");
        stringBuffer.append(this.latitude);
        stringBuffer.append(", longitude=");
        stringBuffer.append(this.longitude);
        stringBuffer.append(", positionValid=");
        stringBuffer.append(this.positionValid);
        stringBuffer.append(", proprietaryData=");
        stringBuffer.append(this.proprietaryData != null ? Arrays.asList(this.proprietaryData) : null);
        stringBuffer.append(", street=");
        stringBuffer.append(this.street);
        stringBuffer.append(", streetRefinement=");
        stringBuffer.append(this.streetRefinement);
        stringBuffer.append(", town=");
        stringBuffer.append(this.town);
        stringBuffer.append(", townRefinement=");
        stringBuffer.append(this.townRefinement);
        stringBuffer.append(", towncenter=");
        stringBuffer.append(this.towncenter);
        stringBuffer.append(", version=");
        stringBuffer.append(this.version);
        stringBuffer.append(", versionOfLocationStructureValid=");
        stringBuffer.append(this.versionOfLocationStructureValid);
        stringBuffer.append(", zipCode=");
        stringBuffer.append(this.zipCode);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

