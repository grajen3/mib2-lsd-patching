/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.IEConnector;
import org.dsi.ifc.global.NavLocation;

public interface ILocationWrapper {
    public static final int LOCATION_TYPE_UNKNOWN;
    public static final int LOCATION_TYPE_GEO;
    public static final int LOCATION_TYPE_ADDRESS;
    public static final int LOCATION_TYPE_CROSSING;
    public static final int LOCATION_TYPE_POI;
    public static final int MMI_DEST_MEM_ENTRY_NAME;
    public static final int MMI_DEST_MEM_FLAG_DEST_NAME;
    public static final int MMI_ONLINE_POI_NAME;
    public static final int MMI_ONLINE_POI_PHONE;

    default public NavLocation getLocation() {
    }

    default public void setLocation(NavLocation navLocation) {
    }

    default public NavLocation getLocationCopy() {
    }

    default public String getCountry() {
    }

    default public boolean isCountryAvailable() {
    }

    default public String getCountryCode() {
    }

    default public String getIsoCountryCode() {
    }

    default public boolean isIsoCountryCodeAvailable() {
    }

    default public boolean isCountryCodeAvailable() {
    }

    default public String getHousenumber() {
    }

    default public boolean isHousenumberAvailable() {
    }

    default public int getIconIndex() {
    }

    default public String getGpxName() {
    }

    default public boolean isGPXNameAvailable() {
    }

    default public boolean isIconIndexAvailable() {
    }

    default public int getCountryIconIndex() {
    }

    default public String getCrossing() {
    }

    default public boolean isCrossingAvailable() {
    }

    default public int getLatitude() {
    }

    default public int getLatitudeDegrees() {
    }

    default public int getLatitudeMinutes() {
    }

    default public int getLatitudeSeconds() {
    }

    default public int getLongitude() {
    }

    default public int getLongitudeDegrees() {
    }

    default public int getLongitudeMinutes() {
    }

    default public int getLongitudeSeconds() {
    }

    default public boolean isGeoLocationAvailable() {
    }

    default public void setMmiInternalDataValue(int n, String string) {
    }

    default public String getMmiInternalDataValue(int n) {
    }

    default public boolean isMmiInternalDataAvailable() {
    }

    default public String getMotorWayExit() {
    }

    default public boolean isMotorWayExitAvailable() {
    }

    default public String getPhonenumber() {
    }

    default public boolean isPhonenumberAvailable() {
    }

    default public String getPoiCategory() {
    }

    default public boolean isPoiCategoryAvailable() {
    }

    default public int getPoiCategoryNumber() {
    }

    default public boolean isPoiCategoryNumberAvailable() {
    }

    default public String getPoiClass() {
    }

    default public boolean isPoiClassAvailable() {
    }

    default public String getPoiName() {
    }

    default public boolean isPoiNameAvailable() {
    }

    default public String getStreet() {
    }

    default public boolean isStreetAvailable() {
    }

    default public String getStreetRefinement() {
    }

    default public boolean isStreetRefinementAvailable() {
    }

    default public int getSubIconIndex() {
    }

    default public boolean isSubIconIndexAvailable() {
    }

    default public String getCity() {
    }

    default public String getUnformattedTownName() {
    }

    default public boolean isCityAvailable() {
    }

    default public String getCityRefinement() {
    }

    default public boolean isCityRefinementAvailable() {
    }

    default public String getCityCenter() {
    }

    default public boolean isCityCenterAvailable() {
    }

    default public boolean isCityCenter() {
    }

    default public int getLocationDSIType() {
    }

    default public int getLocationType() {
    }

    default public boolean isTypeAvailable() {
    }

    default public String getURLAddress() {
    }

    default public boolean isURLAddressAvailable() {
    }

    default public String getPostalCode() {
    }

    default public boolean isPostalCodeAvailable() {
    }

    default public boolean isPostalCodeSpelled() {
    }

    default public boolean isPostalCodeNeeded() {
    }

    default public boolean isCityRefinementNeeded() {
    }

    default public boolean isNavigable() {
    }

    default public boolean isParentOfPOIs() {
    }

    default public boolean isFullPostalCode() {
    }

    default public boolean isProvinceAvailable() {
    }

    default public String getProvince() {
    }

    default public boolean isProvinceAbbreviationAvailable() {
    }

    default public String getProvinceAbbreviation() {
    }

    default public boolean isStateAvailable() {
    }

    default public String getState() {
    }

    default public boolean isStateAbbreviationAvailable() {
    }

    default public String getStateAbbreviation() {
    }

    default public boolean isStateSpelled() {
    }

    default public boolean isProvinceSpelled() {
    }

    default public boolean isStreetNearbyAvailable() {
    }

    default public String getStreetNearby() {
    }

    default public boolean isStreetBasename() {
    }

    default public boolean isTownorder9() {
    }

    default public String getChargingStationProvider() {
    }

    default public int getChargingStationAccess() {
    }

    default public int getChargingStationOnSitePayment() {
    }

    default public int getChargingStationOpen24h() {
    }

    default public int getChargingStationPay() {
    }

    default public int getChargingStationSubscription() {
    }

    default public int getEConnectorCount() {
    }

    default public IEConnector[] getEConnectors() {
    }

    default public String getPlace() {
    }

    default public String getMapCode() {
    }

    default public String getWard() {
    }

    default public String getChome() {
    }
}

