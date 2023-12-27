/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.properties.values.FixFormatterFieldData;

public interface INavigationLocation {
    default public String getCountry() {
    }

    default public String getCountryAbbreviation() {
    }

    default public String getTown() {
    }

    default public String getZipCode() {
    }

    default public String getStreet() {
    }

    default public String getHousenumber() {
    }

    default public String getJunction() {
    }

    default public String getDistrict() {
    }

    default public String getSubmunicipalTown() {
    }

    default public String getPoiName() {
    }

    default public String getState() {
    }

    default public String getVillage() {
    }

    default public String getWard() {
    }

    default public String getPlaceName() {
    }

    default public boolean isValid() {
    }

    default public double getLatitude() {
    }

    default public double getLongitude() {
    }

    default public String getCity() {
    }

    default public String getCityRefinement() {
    }

    default public String getStreetRefinement() {
    }

    default public String getPrefecture() {
    }

    default public String getMunicipality() {
    }

    default public String getPlace() {
    }

    default public String getChome() {
    }

    default public FixFormatterFieldData getLocationFormatter() {
    }
}

