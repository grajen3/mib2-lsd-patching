/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.poi;

import org.dsi.ifc.global.NavLocation;

public interface IPersistedPoiSetup {
    public static final int POI_FUEL_OPTIONS_PREFERRED_CHARGING_SPEED_DEFAULT;

    default public NavLocation getLocationForSearchAreaMap() {
    }

    default public void setLocationForSearchAreaMap(NavLocation navLocation) {
    }

    default public boolean getFuelOptionsDestinationRangeWarning() {
    }

    default public void setFuelOptionsDestinationRangeWarning(boolean bl) {
    }

    default public boolean getFuelOptionsDestinationHomeWarning() {
    }

    default public void setFuelOptionsDestinationHomeWarning(boolean bl) {
    }

    default public int getPreferredChargingSpeed() {
    }

    default public void setPreferredChargingSpeed(int n) {
    }

    default public String getOnlineSearchProviderUrl() {
    }

    default public void setOnlineSearchProviderUrl(String string) {
    }

    default public String getOnlineSearchProviderChecksum() {
    }

    default public void setOnlineSearchProviderChecksum(String string) {
    }

    default public String getOnlineSearchProviderDynamicUrl(int n) {
    }

    default public void setOnlineSearchProviderDynamicUrl(String string, int n) {
    }

    default public String getOnlineSearchProviderDynamicChecksum(int n) {
    }

    default public void setOnlineSearchProviderDynamicChecksum(String string, int n) {
    }

    default public boolean getFuelOptionsFuelWarning() {
    }

    default public void setFuelOptionsFuelWarning(boolean bl) {
    }

    default public void updateProperties() {
    }

    default public void updatePropertyFuelOptionsFuelWarning() {
    }

    default public void updatePropertyFuelOptionsDestinationRangeWarning() {
    }

    default public void updatePropertyFuelOptionsDestinationHomeWarning() {
    }

    default public void updatePropertyPreferredChargingSpeed() {
    }

    default public void reloadPersistedData() {
    }

    default public int getSearchAreaActiveGuidance() {
    }

    default public int getSearchAreaNoGuidance() {
    }

    default public void setLocationForSearchAreaAddress(NavLocation navLocation) {
    }

    default public NavLocation getLocationForSearchAreaAddress() {
    }

    default public void setSearchAreaActiveGuidance(int n) {
    }

    default public void setSearchAreaNoGuidance(int n) {
    }
}

