/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navi.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.collections.booleans.BooleanArrayList;
import de.vw.mib.collections.ints.IntArrayList;
import java.util.List;

public interface Navigation
extends Persistable {
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

    default public boolean isHOVUsage() {
    }

    default public void setHOVUsage(boolean bl) {
    }

    default public boolean isMainMapShowPoiIcons() {
    }

    default public void setMainMapShowPoiIcons(boolean bl) {
    }

    default public List getHomeAddressStream() {
    }

    default public int getMainMapOrientation() {
    }

    default public void setMainMapOrientation(int n) {
    }

    default public int getMainMapTypeLast() {
    }

    default public void setMainMapTypeLast(int n) {
    }

    default public boolean isMainMapShowSpeedAndFlow() {
    }

    default public void setMainMapShowSpeedAndFlow(boolean bl) {
    }

    default public boolean isTrafficShowFreeFlow() {
    }

    default public void setTrafficShowFreeFlow(boolean bl) {
    }

    default public boolean isTrafficShowCongestion() {
    }

    default public void setTrafficShowCongestion(boolean bl) {
    }

    default public boolean isTrafficShowIncidents() {
    }

    default public void setTrafficShowIncidents(boolean bl) {
    }

    default public boolean isMainMapIsKdkActive() {
    }

    default public void setMainMapIsKdkActive(boolean bl) {
    }

    default public int getMapInMapMode() {
    }

    default public void setMapInMapMode(int n) {
    }

    default public int getMainMapAutoZoomMode() {
    }

    default public void setMainMapAutoZoomMode(int n) {
    }

    default public boolean isSpeedCameraWarning() {
    }

    default public void setSpeedCameraWarning(boolean bl) {
    }

    default public boolean isMainMapVisibleInKombi() {
    }

    default public void setMainMapVisibleInKombi(boolean bl) {
    }

    default public int getMapTypeKombiFpk() {
    }

    default public void setMapTypeKombiFpk(int n) {
    }

    default public int getMapOrientationKombiFpk() {
    }

    default public void setMapOrientationKombiFpk(int n) {
    }

    default public int getMapContentKombiFpk() {
    }

    default public void setMapContentKombiFpk(int n) {
    }

    default public boolean isKdkActiveInKombiFpk() {
    }

    default public void setKdkActiveInKombiFpk(boolean bl) {
    }

    default public int getAutoZoomModeKombiFpk() {
    }

    default public void setAutoZoomModeKombiFpk(int n) {
    }

    default public boolean isPrivacyMode() {
    }

    default public void setPrivacyMode(boolean bl) {
    }

    default public boolean isSplitScreenGuidanceVisibility() {
    }

    default public void setSplitScreenGuidanceVisibility(boolean bl) {
    }

    default public boolean isSplitScreenNoGuidanceVisibility() {
    }

    default public void setSplitScreenNoGuidanceVisibility(boolean bl) {
    }

    default public int getSplitScreenGuidanceContent() {
    }

    default public void setSplitScreenGuidanceContent(int n) {
    }

    default public int getSplitScreenNoGuidanceContent() {
    }

    default public void setSplitScreenNoGuidanceContent(int n) {
    }

    default public boolean isAudibleApproachPPOIHintStatus() {
    }

    default public void setAudibleApproachPPOIHintStatus(boolean bl) {
    }

    default public int getMainMapMapMode() {
    }

    default public void setMainMapMapMode(int n) {
    }

    default public int getOnlineToursAvailable() {
    }

    default public void setOnlineToursAvailable(int n) {
    }

    default public boolean isSeasonalRestrictions() {
    }

    default public void setSeasonalRestrictions(boolean bl) {
    }

    default public boolean isStatisticalData() {
    }

    default public void setStatisticalData(boolean bl) {
    }

    default public int getDayNightMainMapMode() {
    }

    default public void setDayNightMainMapMode(int n) {
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

    default public long getLastTimeStampBeforeHmiOff() {
    }

    default public void setLastTimeStampBeforeHmiOff(long l) {
    }
}

