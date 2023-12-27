/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.internal;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;

public class LocationHelper {
    private NavLocation m_NavLocation = null;
    public static final int LAD_AdditionalFlags;
    public static final int LAD_IsGeoPosFlag;
    public static final int LAD_IsParentPOIFlag;
    public static final int LAD_CityOfficialName;
    public static final int LAD_StateName;
    public static final int LAD_StateAbbreviation;
    public static final int LAD_CountryCode;
    public static final int LAD_CityTransliteration;
    public static final int LAD_CityDestinationType;
    public static final int LAD_SuburbOfficialName;
    public static final int LAD_CityOfficialPhoneme;
    public static final int LAD_CityExonymPhoneme;
    public static final int LAD_SuburbOfficialPhoneme;
    public static final int LAD_SuburbExonymPhoneme;
    public static final int LAD_StreetPhoneme;
    public static final int LAD_StreetAlternativePhoneme;
    public static final int LAD_StatePhoneme;
    public static final int LAD_StateAlternativePhoneme;
    public static final int LAD_JunctionPhoneme;
    public static final int LAD_JunctionAlternativePhoneme;
    public static final int LAD_CountryOfficialPhoneme;
    public static final int LAD_CountryExonymPhoneme;
    public static final int LAD_SuburbTransliteration;
    public static final int LAD_CityExonym;
    public static final int LAD_POINamePhoneme;
    public static final int LAD_SuburbExonym;
    public static final int LAD_SuburbExonymTransliteration;
    public static final int LAD_CityExonymTransliteration;
    public static final int LAD_ISO3CountryCode;
    public static final int LAD_PathToGPXFile;
    public static final int LAD_LinkToTrackInGPXFile;
    private static final String LocationAdditionalDataSeparator;
    public static final int CountryCode_Invalid;
    public static final int DESTINATION_TYPE_CITY_OFFICIAL_NAME;
    public static final int DESTINATION_TYPE_CITY_EXONYM;
    public static final int DESTINATION_TYPE_CITY_OFFICIAL_NAME_TRANSLITERATION;
    public static final int DESTINATION_TYPE_CITY_EXONYM_TRANSLITERATION;
    public static final int DESTINATION_TYPE_SUBURB_OFFICIAL_NAME;
    public static final int DESTINATION_TYPE_SUBURB_EXONYM;
    public static final int DESTINATION_TYPE_SUBURB_OFFICIAL_NAME_TRANSLITERATION;
    public static final int DESTINATION_TYPE_SUBURB_EXONYM_TRANSLITERATION;

    public LocationHelper(NavLocation navLocation) {
        this.setLocation(navLocation);
    }

    public void setLocation(NavLocation navLocation) {
        this.m_NavLocation = navLocation;
        if (null == this.m_NavLocation) {
            this.m_NavLocation = new NavLocation();
        }
    }

    public NavLocation getLocation() {
        return this.m_NavLocation;
    }

    public void clearLocation() {
        this.m_NavLocation.positionValid = false;
        this.m_NavLocation.longitude = 0;
        this.m_NavLocation.latitude = 0;
        this.m_NavLocation.altitude = 0;
        this.m_NavLocation.country = null;
        this.m_NavLocation.countryAbbreviation = null;
        this.m_NavLocation.housenumber = null;
        this.m_NavLocation.junction = null;
        this.m_NavLocation.street = null;
        this.m_NavLocation.streetRefinement = null;
        this.m_NavLocation.town = null;
        this.m_NavLocation.towncenter = null;
        this.m_NavLocation.townRefinement = null;
        this.m_NavLocation.zipCode = null;
        this.m_NavLocation.proprietaryData = null;
        this.m_NavLocation.version = null;
        this.m_NavLocation.versionOfLocationStructureValid = false;
    }

    public void addProprietaryData(int n, String string) {
        boolean bl = false;
        NavLocationDescriptor[] navLocationDescriptorArray = this.m_NavLocation.proprietaryData;
        if (navLocationDescriptorArray != null) {
            for (int i2 = 0; i2 < navLocationDescriptorArray.length && !bl; ++i2) {
                if (navLocationDescriptorArray[i2].getData() == null || navLocationDescriptorArray[i2].selectionCriterion != n) continue;
                bl = true;
                navLocationDescriptorArray[i2] = new NavLocationDescriptor(n, string);
            }
            if (!bl) {
                NavLocationDescriptor[] navLocationDescriptorArray2 = new NavLocationDescriptor[navLocationDescriptorArray.length + 1];
                System.arraycopy((Object)navLocationDescriptorArray, 0, (Object)navLocationDescriptorArray2, 0, navLocationDescriptorArray.length);
                navLocationDescriptorArray = navLocationDescriptorArray2;
                navLocationDescriptorArray[navLocationDescriptorArray.length - 1] = new NavLocationDescriptor(n, string);
            }
        } else {
            navLocationDescriptorArray = new NavLocationDescriptor[]{new NavLocationDescriptor(n, string)};
        }
        this.m_NavLocation.proprietaryData = navLocationDescriptorArray;
    }

    public String getDataOfSelectionCriterion(int n) {
        String string = "";
        if (null != this.m_NavLocation.proprietaryData) {
            for (int i2 = 0; i2 < this.m_NavLocation.proprietaryData.length; ++i2) {
                if (this.m_NavLocation.proprietaryData[i2].selectionCriterion != n) continue;
                string = this.m_NavLocation.proprietaryData[i2].getData();
            }
        }
        return string;
    }

    public String getDataForInternalType(int n) {
        String string = "";
        String string2 = LocationHelper.getLocationAdditionalData(n);
        if (null != this.m_NavLocation.proprietaryData) {
            for (int i2 = 0; i2 < this.m_NavLocation.proprietaryData.length; ++i2) {
                if (this.m_NavLocation.proprietaryData[i2].selectionCriterion != 121 || !this.m_NavLocation.proprietaryData[i2].getData().startsWith(string2)) continue;
                string = this.m_NavLocation.proprietaryData[i2].getData().substring(string2.length());
                break;
            }
        }
        return string;
    }

    public int getValueForInternalType(int n) {
        String string = this.getDataForInternalType(n);
        return LocationHelper.parseInt(string);
    }

    public int getValueOfSelectionCriterion(int n) {
        String string = this.getDataOfSelectionCriterion(n);
        return LocationHelper.parseInt(string);
    }

    public boolean isFlagSet(int n) {
        boolean bl = false;
        int n2 = this.getValueForInternalType(n);
        if (n2 > 0) {
            bl = true;
        }
        return bl;
    }

    public String getTownByDestinationType(int n) {
        String string = "";
        switch (n) {
            case 6: {
                string = this.getDataForInternalType(2001);
                break;
            }
            case 7: {
                string = this.getDataForInternalType(2066);
                break;
            }
            case 8: {
                string = this.getDataForInternalType(2008);
                break;
            }
            case 9: {
                string = this.getDataForInternalType(2071);
                break;
            }
            case 11: {
                string = this.getDataForInternalType(2010);
                break;
            }
            case 12: {
                string = this.getDataForInternalType(2069);
                break;
            }
            case 13: {
                string = this.getDataForInternalType(2055);
                break;
            }
            case 14: {
                string = this.getDataForInternalType(2070);
                break;
            }
        }
        return string;
    }

    private static String getLocationAdditionalData(int n) {
        String string = new StringBuffer().append(String.valueOf(n)).append(":").toString();
        return string;
    }

    private static int parseInt(String string) {
        try {
            if (string.length() > 0) {
                return Integer.parseInt(string);
            }
            return -1;
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }
}

