/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navi.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceArrayList;
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceBooleanArrayList;
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceIntArrayList;
import de.vw.mib.asl.navi.persistence.Navigation;
import de.vw.mib.collections.booleans.BooleanArrayList;
import de.vw.mib.collections.ints.IntArrayList;
import java.util.List;

class NavigationImpl
extends AbstractPersistable
implements Navigation {
    private final PersistenceModule module;
    private final PersistenceBooleanArrayList routeOptionsAvoidRoadTypes = new PersistenceBooleanArrayList();
    private final PersistenceIntArrayList routeOptionsVignetteAvailableCountryIds = new PersistenceIntArrayList();
    private final PersistenceArrayList homeAddressStream = new PersistenceArrayList();
    private int voiceAnouncementDuringPhoneCall;
    private int voiceAnouncementDetail;
    private boolean voiceAnouncementState;
    private int trafficSignMode;
    private int guidanceTimeFormat;
    private boolean guidanceStatusLineInfo;
    private boolean borderChangeActive;
    private boolean routeOptionsAlternativeRouteCalc;
    private int routeOptionsRouteCalculationType;
    private int routeOptionsDynamicRouteCalculation;
    private boolean mapMainMapShowBrandIcons;
    private boolean mapMainMapShowFavoriteIcons;
    private boolean mapMainLaneGuidance;
    private boolean fuelWarinigPopup;
    private boolean hOVUsage;
    private boolean mainMapShowPoiIcons;
    private int mainMapOrientation;
    private int mainMapTypeLast;
    private boolean mainMapShowSpeedAndFlow;
    private boolean trafficShowFreeFlow;
    private boolean trafficShowCongestion;
    private boolean trafficShowIncidents;
    private boolean mainMapIsKdkActive;
    private int mapInMapMode;
    private int mainMapAutoZoomMode;
    private boolean speedCameraWarning;
    private boolean mainMapVisibleInKombi;
    private int mapTypeKombiFpk;
    private int mapOrientationKombiFpk;
    private int mapContentKombiFpk;
    private boolean kdkActiveInKombiFpk;
    private int autoZoomModeKombiFpk;
    private boolean privacyMode;
    private boolean splitScreenGuidanceVisibility;
    private boolean splitScreenNoGuidanceVisibility;
    private int splitScreenGuidanceContent;
    private int splitScreenNoGuidanceContent;
    private boolean audibleApproachPPOIHintStatus;
    private int mainMapMapMode;
    private int onlineToursAvailable;
    private boolean seasonalRestrictions;
    private boolean statisticalData;
    private int dayNightMainMapMode;
    private boolean mergingTraffic;
    private boolean reduceLane;
    private boolean railwayCrossing;
    private int speedCameraWarningType;
    private boolean pnavEnabled;
    private boolean showSldeHelp;
    private int lastModeDestinationInput;
    private long lastTimeStampBeforeHmiOff;

    NavigationImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        this.routeOptionsAvoidRoadTypes.setRootPersistable(persistable);
        this.routeOptionsVignetteAvailableCountryIds.setRootPersistable(persistable);
        this.homeAddressStream.setRootPersistable(persistable);
    }

    @Override
    public int getVoiceAnouncementDuringPhoneCall() {
        return this.voiceAnouncementDuringPhoneCall;
    }

    @Override
    public void setVoiceAnouncementDuringPhoneCall(int n) {
        this.voiceAnouncementDuringPhoneCall = n;
        this.markDirty();
    }

    @Override
    public int getVoiceAnouncementDetail() {
        return this.voiceAnouncementDetail;
    }

    @Override
    public void setVoiceAnouncementDetail(int n) {
        this.voiceAnouncementDetail = n;
        this.markDirty();
    }

    @Override
    public boolean isVoiceAnouncementState() {
        return this.voiceAnouncementState;
    }

    @Override
    public void setVoiceAnouncementState(boolean bl) {
        this.voiceAnouncementState = bl;
        this.markDirty();
    }

    @Override
    public int getTrafficSignMode() {
        return this.trafficSignMode;
    }

    @Override
    public void setTrafficSignMode(int n) {
        this.trafficSignMode = n;
        this.markDirty();
    }

    @Override
    public int getGuidanceTimeFormat() {
        return this.guidanceTimeFormat;
    }

    @Override
    public void setGuidanceTimeFormat(int n) {
        this.guidanceTimeFormat = n;
        this.markDirty();
    }

    @Override
    public boolean isGuidanceStatusLineInfo() {
        return this.guidanceStatusLineInfo;
    }

    @Override
    public void setGuidanceStatusLineInfo(boolean bl) {
        this.guidanceStatusLineInfo = bl;
        this.markDirty();
    }

    @Override
    public boolean isBorderChangeActive() {
        return this.borderChangeActive;
    }

    @Override
    public void setBorderChangeActive(boolean bl) {
        this.borderChangeActive = bl;
        this.markDirty();
    }

    @Override
    public boolean isRouteOptionsAlternativeRouteCalc() {
        return this.routeOptionsAlternativeRouteCalc;
    }

    @Override
    public void setRouteOptionsAlternativeRouteCalc(boolean bl) {
        this.routeOptionsAlternativeRouteCalc = bl;
        this.markDirty();
    }

    @Override
    public int getRouteOptionsRouteCalculationType() {
        return this.routeOptionsRouteCalculationType;
    }

    @Override
    public void setRouteOptionsRouteCalculationType(int n) {
        this.routeOptionsRouteCalculationType = n;
        this.markDirty();
    }

    @Override
    public int getRouteOptionsDynamicRouteCalculation() {
        return this.routeOptionsDynamicRouteCalculation;
    }

    @Override
    public void setRouteOptionsDynamicRouteCalculation(int n) {
        this.routeOptionsDynamicRouteCalculation = n;
        this.markDirty();
    }

    @Override
    public BooleanArrayList getRouteOptionsAvoidRoadTypes() {
        return this.routeOptionsAvoidRoadTypes;
    }

    @Override
    public IntArrayList getRouteOptionsVignetteAvailableCountryIds() {
        return this.routeOptionsVignetteAvailableCountryIds;
    }

    @Override
    public boolean isMapMainMapShowBrandIcons() {
        return this.mapMainMapShowBrandIcons;
    }

    @Override
    public void setMapMainMapShowBrandIcons(boolean bl) {
        this.mapMainMapShowBrandIcons = bl;
        this.markDirty();
    }

    @Override
    public boolean isMapMainMapShowFavoriteIcons() {
        return this.mapMainMapShowFavoriteIcons;
    }

    @Override
    public void setMapMainMapShowFavoriteIcons(boolean bl) {
        this.mapMainMapShowFavoriteIcons = bl;
        this.markDirty();
    }

    @Override
    public boolean isMapMainLaneGuidance() {
        return this.mapMainLaneGuidance;
    }

    @Override
    public void setMapMainLaneGuidance(boolean bl) {
        this.mapMainLaneGuidance = bl;
        this.markDirty();
    }

    @Override
    public boolean isFuelWarinigPopup() {
        return this.fuelWarinigPopup;
    }

    @Override
    public void setFuelWarinigPopup(boolean bl) {
        this.fuelWarinigPopup = bl;
        this.markDirty();
    }

    @Override
    public boolean isHOVUsage() {
        return this.hOVUsage;
    }

    @Override
    public void setHOVUsage(boolean bl) {
        this.hOVUsage = bl;
        this.markDirty();
    }

    @Override
    public boolean isMainMapShowPoiIcons() {
        return this.mainMapShowPoiIcons;
    }

    @Override
    public void setMainMapShowPoiIcons(boolean bl) {
        this.mainMapShowPoiIcons = bl;
        this.markDirty();
    }

    @Override
    public List getHomeAddressStream() {
        return this.homeAddressStream;
    }

    @Override
    public int getMainMapOrientation() {
        return this.mainMapOrientation;
    }

    @Override
    public void setMainMapOrientation(int n) {
        this.mainMapOrientation = n;
        this.markDirty();
    }

    @Override
    public int getMainMapTypeLast() {
        return this.mainMapTypeLast;
    }

    @Override
    public void setMainMapTypeLast(int n) {
        this.mainMapTypeLast = n;
        this.markDirty();
    }

    @Override
    public boolean isMainMapShowSpeedAndFlow() {
        return this.mainMapShowSpeedAndFlow;
    }

    @Override
    public void setMainMapShowSpeedAndFlow(boolean bl) {
        this.mainMapShowSpeedAndFlow = bl;
        this.markDirty();
    }

    @Override
    public boolean isTrafficShowFreeFlow() {
        return this.trafficShowFreeFlow;
    }

    @Override
    public void setTrafficShowFreeFlow(boolean bl) {
        this.trafficShowFreeFlow = bl;
        this.markDirty();
    }

    @Override
    public boolean isTrafficShowCongestion() {
        return this.trafficShowCongestion;
    }

    @Override
    public void setTrafficShowCongestion(boolean bl) {
        this.trafficShowCongestion = bl;
        this.markDirty();
    }

    @Override
    public boolean isTrafficShowIncidents() {
        return this.trafficShowIncidents;
    }

    @Override
    public void setTrafficShowIncidents(boolean bl) {
        this.trafficShowIncidents = bl;
        this.markDirty();
    }

    @Override
    public boolean isMainMapIsKdkActive() {
        return this.mainMapIsKdkActive;
    }

    @Override
    public void setMainMapIsKdkActive(boolean bl) {
        this.mainMapIsKdkActive = bl;
        this.markDirty();
    }

    @Override
    public int getMapInMapMode() {
        return this.mapInMapMode;
    }

    @Override
    public void setMapInMapMode(int n) {
        this.mapInMapMode = n;
        this.markDirty();
    }

    @Override
    public int getMainMapAutoZoomMode() {
        return this.mainMapAutoZoomMode;
    }

    @Override
    public void setMainMapAutoZoomMode(int n) {
        this.mainMapAutoZoomMode = n;
        this.markDirty();
    }

    @Override
    public boolean isSpeedCameraWarning() {
        return this.speedCameraWarning;
    }

    @Override
    public void setSpeedCameraWarning(boolean bl) {
        this.speedCameraWarning = bl;
        this.markDirty();
    }

    @Override
    public boolean isMainMapVisibleInKombi() {
        return this.mainMapVisibleInKombi;
    }

    @Override
    public void setMainMapVisibleInKombi(boolean bl) {
        this.mainMapVisibleInKombi = bl;
        this.markDirty();
    }

    @Override
    public int getMapTypeKombiFpk() {
        return this.mapTypeKombiFpk;
    }

    @Override
    public void setMapTypeKombiFpk(int n) {
        this.mapTypeKombiFpk = n;
        this.markDirty();
    }

    @Override
    public int getMapOrientationKombiFpk() {
        return this.mapOrientationKombiFpk;
    }

    @Override
    public void setMapOrientationKombiFpk(int n) {
        this.mapOrientationKombiFpk = n;
        this.markDirty();
    }

    @Override
    public int getMapContentKombiFpk() {
        return this.mapContentKombiFpk;
    }

    @Override
    public void setMapContentKombiFpk(int n) {
        this.mapContentKombiFpk = n;
        this.markDirty();
    }

    @Override
    public boolean isKdkActiveInKombiFpk() {
        return this.kdkActiveInKombiFpk;
    }

    @Override
    public void setKdkActiveInKombiFpk(boolean bl) {
        this.kdkActiveInKombiFpk = bl;
        this.markDirty();
    }

    @Override
    public int getAutoZoomModeKombiFpk() {
        return this.autoZoomModeKombiFpk;
    }

    @Override
    public void setAutoZoomModeKombiFpk(int n) {
        this.autoZoomModeKombiFpk = n;
        this.markDirty();
    }

    @Override
    public boolean isPrivacyMode() {
        return this.privacyMode;
    }

    @Override
    public void setPrivacyMode(boolean bl) {
        this.privacyMode = bl;
        this.markDirty();
    }

    @Override
    public boolean isSplitScreenGuidanceVisibility() {
        return this.splitScreenGuidanceVisibility;
    }

    @Override
    public void setSplitScreenGuidanceVisibility(boolean bl) {
        this.splitScreenGuidanceVisibility = bl;
        this.markDirty();
    }

    @Override
    public boolean isSplitScreenNoGuidanceVisibility() {
        return this.splitScreenNoGuidanceVisibility;
    }

    @Override
    public void setSplitScreenNoGuidanceVisibility(boolean bl) {
        this.splitScreenNoGuidanceVisibility = bl;
        this.markDirty();
    }

    @Override
    public int getSplitScreenGuidanceContent() {
        return this.splitScreenGuidanceContent;
    }

    @Override
    public void setSplitScreenGuidanceContent(int n) {
        this.splitScreenGuidanceContent = n;
        this.markDirty();
    }

    @Override
    public int getSplitScreenNoGuidanceContent() {
        return this.splitScreenNoGuidanceContent;
    }

    @Override
    public void setSplitScreenNoGuidanceContent(int n) {
        this.splitScreenNoGuidanceContent = n;
        this.markDirty();
    }

    @Override
    public boolean isAudibleApproachPPOIHintStatus() {
        return this.audibleApproachPPOIHintStatus;
    }

    @Override
    public void setAudibleApproachPPOIHintStatus(boolean bl) {
        this.audibleApproachPPOIHintStatus = bl;
        this.markDirty();
    }

    @Override
    public int getMainMapMapMode() {
        return this.mainMapMapMode;
    }

    @Override
    public void setMainMapMapMode(int n) {
        this.mainMapMapMode = n;
        this.markDirty();
    }

    @Override
    public int getOnlineToursAvailable() {
        return this.onlineToursAvailable;
    }

    @Override
    public void setOnlineToursAvailable(int n) {
        this.onlineToursAvailable = n;
        this.markDirty();
    }

    @Override
    public boolean isSeasonalRestrictions() {
        return this.seasonalRestrictions;
    }

    @Override
    public void setSeasonalRestrictions(boolean bl) {
        this.seasonalRestrictions = bl;
        this.markDirty();
    }

    @Override
    public boolean isStatisticalData() {
        return this.statisticalData;
    }

    @Override
    public void setStatisticalData(boolean bl) {
        this.statisticalData = bl;
        this.markDirty();
    }

    @Override
    public int getDayNightMainMapMode() {
        return this.dayNightMainMapMode;
    }

    @Override
    public void setDayNightMainMapMode(int n) {
        this.dayNightMainMapMode = n;
        this.markDirty();
    }

    @Override
    public boolean isMergingTraffic() {
        return this.mergingTraffic;
    }

    @Override
    public void setMergingTraffic(boolean bl) {
        this.mergingTraffic = bl;
        this.markDirty();
    }

    @Override
    public boolean isReduceLane() {
        return this.reduceLane;
    }

    @Override
    public void setReduceLane(boolean bl) {
        this.reduceLane = bl;
        this.markDirty();
    }

    @Override
    public boolean isRailwayCrossing() {
        return this.railwayCrossing;
    }

    @Override
    public void setRailwayCrossing(boolean bl) {
        this.railwayCrossing = bl;
        this.markDirty();
    }

    @Override
    public int getSpeedCameraWarningType() {
        return this.speedCameraWarningType;
    }

    @Override
    public void setSpeedCameraWarningType(int n) {
        this.speedCameraWarningType = n;
        this.markDirty();
    }

    @Override
    public boolean isPnavEnabled() {
        return this.pnavEnabled;
    }

    @Override
    public void setPnavEnabled(boolean bl) {
        this.pnavEnabled = bl;
        this.markDirty();
    }

    @Override
    public boolean isShowSldeHelp() {
        return this.showSldeHelp;
    }

    @Override
    public void setShowSldeHelp(boolean bl) {
        this.showSldeHelp = bl;
        this.markDirty();
    }

    @Override
    public int getLastModeDestinationInput() {
        return this.lastModeDestinationInput;
    }

    @Override
    public void setLastModeDestinationInput(int n) {
        this.lastModeDestinationInput = n;
        this.markDirty();
    }

    @Override
    public long getLastTimeStampBeforeHmiOff() {
        return this.lastTimeStampBeforeHmiOff;
    }

    @Override
    public void setLastTimeStampBeforeHmiOff(long l) {
        this.lastTimeStampBeforeHmiOff = l;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

