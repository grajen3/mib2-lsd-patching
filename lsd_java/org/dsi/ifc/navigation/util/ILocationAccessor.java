/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation.util;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.PhonemeData;

public interface ILocationAccessor {
    default public int getAdditionalFlags() {
    }

    default public String getCountry() {
    }

    default public String getCountryAbbreviation() {
    }

    default public String getState() {
    }

    default public String getStateAbbreviation() {
    }

    default public String getHousenumber() {
    }

    default public int getIconIndex() {
    }

    default public String getJunction() {
    }

    default public int getLatitude() {
    }

    default public int getLongitude() {
    }

    default public String getMmiInternalData() {
    }

    default public String getMotorWayExit() {
    }

    default public String getPhonenumber() {
    }

    default public String getPoiCategory() {
    }

    default public int getPoiCategoryNumber() {
    }

    default public String getPoiClass() {
    }

    default public String getPoiName() {
    }

    default public String getStreet() {
    }

    default public String getStreetNearby() {
    }

    default public String getStreetRefinement() {
    }

    default public int getSubIconIndex() {
    }

    default public String getTown() {
    }

    default public String getTowncenter() {
    }

    default public String getTownRefinement() {
    }

    default public int getType() {
    }

    default public String getURLAddress() {
    }

    default public String getZipCode() {
    }

    default public String getTownOriginalName() {
    }

    default public boolean isNavigable() {
    }

    default public boolean isParentOfPOIs() {
    }

    default public boolean isZipCodeNeededForRefinement() {
    }

    default public boolean isTownRefinementNeededForRefinement() {
    }

    default public boolean isZipCodeSpelled() {
    }

    default public boolean isTownOrder9() {
    }

    default public boolean isFullPostalCode() {
    }

    default public boolean isStateSpelled() {
    }

    default public boolean isStreetBasename() {
    }

    default public void removeAll() {
    }

    default public void setLocation(NavLocation navLocation) {
    }

    default public void setMmiInternalData(String string) {
    }

    default public int getCountryIconIndex() {
    }

    default public int getAdditionalPoiAttributeBoolean(int n) {
    }

    default public String getAdditionalPoiAttributeString(int n) {
    }

    default public int getAdditionalPoiAttributeInt(int n) {
    }

    default public float getAdditionalPoiAttributeFloat(int n) {
    }

    default public int getConnectorCount() {
    }

    default public int getConnectorAttributeBoolean(int n, int n2) {
    }

    default public float getConnectorAttributeFloat(int n, int n2) {
    }

    default public String getConnectorAttributeString(int n, int n2) {
    }

    default public int getConnectorAttributeInt(int n, int n2) {
    }

    default public PhonemeData getPhoneme(int n) {
    }

    default public void setIsPicNavLocation(boolean bl) {
    }

    default public boolean getIsPicNavLocation() {
    }

    default public String getCountryCode() {
    }

    default public String getStreetIconText() {
    }

    default public int getStreetIconId() {
    }

    default public int[] getIconDecoratorInformation() {
    }

    default public String getMapCode() {
    }

    default public String getDistrict() {
    }

    default public String getChome() {
    }

    default public boolean isLocationDisambiguationPossible() {
    }

    default public String getWard() {
    }

    default public String getPlaceName() {
    }

    default public String getSubmunicipalTown() {
    }

    default public String getVillage() {
    }

    default public String getAdditionalLocationInformation(int n) {
    }

    default public String getGpxName() {
    }

    default public boolean isLocationInCityState() {
    }

    default public NavSegmentID getTraceID() {
    }

    default public boolean getAdditionalFlagStatus(int n) {
    }
}

