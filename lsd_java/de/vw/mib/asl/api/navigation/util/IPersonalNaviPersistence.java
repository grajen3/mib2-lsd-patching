/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import de.vw.mib.collections.booleans.BooleanArrayList;
import de.vw.mib.collections.ints.IntArrayList;
import org.dsi.ifc.global.NavLocation;

public interface IPersonalNaviPersistence {
    default public int getVoiceAnouncementDuringPhoneCall() {
    }

    default public void setVoiceAnouncementDuringPhoneCall(int n) {
    }

    default public int getVoiceAnouncementDetail() {
    }

    default public void setVoiceAnouncementDetail(int n) {
    }

    default public boolean isVoiceAnouncementState() {
    }

    default public void setVoiceAnouncementState(boolean bl) {
    }

    default public int getTrafficSignMode() {
    }

    default public void setTrafficSignMode(int n) {
    }

    default public int getGuidanceTimeFormat() {
    }

    default public void setGuidanceTimeFormat(int n) {
    }

    default public boolean isGuidanceStatusLineInfo() {
    }

    default public void setGuidanceStatusLineInfo(boolean bl) {
    }

    default public boolean isBorderChangeActive() {
    }

    default public void setBorderChangeActive(boolean bl) {
    }

    default public boolean isRouteOptionsAlternativeRouteCalc() {
    }

    default public void setRouteOptionsAlternativeRouteCalc(boolean bl) {
    }

    default public int getRouteOptionsRouteCalculationType() {
    }

    default public void setRouteOptionsRouteCalculationType(int n) {
    }

    default public int getRouteOptionsDynamicRouteCalculation() {
    }

    default public void setRouteOptionsDynamicRouteCalculation(int n) {
    }

    default public BooleanArrayList getRouteOptionsAvoidRoadTypes() {
    }

    default public IntArrayList getRouteOptionsVignetteAvailableCountryIds() {
    }

    default public boolean isMapMainMapShowBrandIcons() {
    }

    default public void setMapMainMapShowBrandIcons(boolean bl) {
    }

    default public boolean isMapMainMapShowFavoriteIcons() {
    }

    default public void setMapMainMapShowFavoriteIcons(boolean bl) {
    }

    default public boolean isMapMainLaneGuidance() {
    }

    default public void setMapMainLaneGuidance(boolean bl) {
    }

    default public boolean isFuelWarinigPopup() {
    }

    default public void setFuelWarinigPopup(boolean bl) {
    }

    default public void resetToDefaults() {
    }

    default public boolean isHOVUsage() {
    }

    default public void setHOVUsage(boolean bl) {
    }

    default public boolean isMainMapShowPoiIcons() {
    }

    default public void setMainMapShowPoiIcons(boolean bl) {
    }

    default public void setHomeDestLocation(NavLocation navLocation) {
    }

    default public NavLocation getHomeDestLocation(NavLocation navLocation) {
    }

    default public void setMainMapOrientation(int n) {
    }

    default public int getMainMapOrientation() {
    }

    default public void setMainMapTypeLast(int n) {
    }

    default public int getMainMapTypeLast() {
    }

    default public void setMainMapShowSpeedAndFlow(boolean bl) {
    }

    default public boolean getMainMapShowSpeedAndFlow() {
    }

    default public boolean getTrafficShowFreeFlow() {
    }

    default public void setTrafficShowFreeFlow(boolean bl) {
    }

    default public void setTrafficShowCongestion(boolean bl) {
    }

    default public boolean getTrafficShowCongestion() {
    }

    default public void setTrafficShowIncidents(boolean bl) {
    }

    default public boolean getTrafficShowIncidents() {
    }

    default public boolean isKDK() {
    }

    default public void setKDK(boolean bl) {
    }

    default public void setMapInMapMode(int n) {
    }

    default public int getMapInMapMode() {
    }

    default public int getMainMapAutoZoomMode() {
    }

    default public void setMainMapAutoZoomMode(int n) {
    }

    default public boolean isSpeedCameraWarning() {
    }

    default public void setSpeedCameraWarning(boolean bl) {
    }

    default public void setMainMapVisibleInKombi(boolean bl) {
    }

    default public boolean isMapVisibleInKombi() {
    }

    default public void setMapTypeKombiFpk(int n) {
    }

    default public int getMapTypeKombiFpk() {
    }

    default public void setMapOrientationKombiFpk(int n) {
    }

    default public int getMapOrientationKombiFpk() {
    }

    default public void setMapContentKombiFpk(int n) {
    }

    default public int getMapContentKombiFpk() {
    }

    default public void setKdkActiveInKombiFpk(boolean bl) {
    }

    default public boolean isKdkActiveInKombiFpk() {
    }

    default public void setAutoZoomModeKombiFpk(int n) {
    }

    default public int getAutoZoomModeKombiFpk() {
    }

    default public void setPrivacyMode(boolean bl) {
    }

    default public boolean isPrivacyMode() {
    }

    default public void setSplitScreenGuidanceVisibility(boolean bl) {
    }

    default public boolean isSplitScreenGuidanceVisible() {
    }

    default public void setSplitScreenNoGuidanceVisibility(boolean bl) {
    }

    default public boolean isSplitScreenNoGuidanceVisible() {
    }

    default public void setSplitScreenGuidanceContent(int n) {
    }

    default public int getSplitScreenGuidanceContent() {
    }

    default public void setSplitScreenNoGuidanceContent(int n) {
    }

    default public int getSplitScreenNoGuidanceContent() {
    }

    default public boolean isAudibleApproachPPOIHintStatus() {
    }

    default public void setAudibleApproachPPOIHintStatus(boolean bl) {
    }

    default public int getMainMapMapMode() {
    }

    default public void setMainMapMode(int n) {
    }

    default public void setOnlineToursAvailable(int n) {
    }

    default public int getOnlineToursAvailable() {
    }

    default public void setRouteOptionsSeasonalRestrictions(boolean bl) {
    }

    default public boolean isSeasonalRestrictions() {
    }

    default public void setRouteOptionsStatisticalData(boolean bl) {
    }

    default public boolean isStatisticalData() {
    }

    default public int getDayNightMainMapMode() {
    }

    default public void setDayNightMainMapMode(int n) {
    }

    default public void lockPersitence() {
    }

    default public void unlockPersitence() {
    }

    default public boolean isMergingTraffic() {
    }

    default public void setMergingTraffic(boolean bl) {
    }

    default public boolean isReduceLane() {
    }

    default public void setReduceLane(boolean bl) {
    }

    default public boolean isRailwayCrossing() {
    }

    default public void setRailwayCrossing(boolean bl) {
    }

    default public int getSpeedCameraWarningType() {
    }

    default public void setSpeedCameraWarningType(int n) {
    }

    default public boolean isPnavEnabled() {
    }

    default public void setPnavEnabled(boolean bl) {
    }

    default public boolean isShowSldeHelp() {
    }

    default public void setShowSldeHelp(boolean bl) {
    }

    default public int getLastModeDestinationInput() {
    }

    default public void setLastModeDestinationInput(int n) {
    }

    default public void setLastTimeStampBeforeHmiOff(long l) {
    }

    default public long getLastTimeStampBeforeHmiOff() {
    }
}

