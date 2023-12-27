/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.navigation;

import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.ComplexAnalyzer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.NavVersionInfo;
import org.dsi.ifc.navigation.PoiExtendedInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.PosTimeInfo;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RgTurnToInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;
import org.dsi.ifc.navigation.TourImportStatus;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;

public final class DSINavigationComplexAnalyzer
extends ComplexAnalyzer
implements DSINavigationListener {
    private static final String LISP_SELECT_LIST_ITEM_M_N;
    private static final String LISP_SELECT_LIST_ITEM_BY_IDENT_M_N;
    private int lispSelectListItemMid = this.getServiceMethodId(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavigationComplexAnalyzer.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, "lispSelectListItem");
    private int lispSelectListItemByIdentMid = this.getServiceMethodId(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavigationComplexAnalyzer.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, "lispSelectListItemByIdent");
    private boolean liResult = false;
    private boolean liCurrentState = false;
    private boolean poiValueList = false;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    private void analyze() {
        if ((this.analyzedServiceMethodId == this.lispSelectListItemMid || this.analyzedServiceMethodId == this.lispSelectListItemByIdentMid) && this.liResult && (this.liCurrentState || this.poiValueList)) {
            this.liResult = false;
            this.liCurrentState = false;
            this.poiValueList = false;
            this.finished = true;
        }
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
    }

    @Override
    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
    }

    @Override
    public void dmRecentRoutesGetResult(long l, Route route) {
    }

    @Override
    public void dmResult(long l, long l2) {
    }

    @Override
    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
    }

    @Override
    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
    }

    @Override
    public void ehResult(int n, int n2) {
    }

    @Override
    public void etcGetCountryAbbreviationResult(String string, long l) {
    }

    @Override
    public void etcSensorDataReplayGuidance(boolean bl) {
    }

    @Override
    public void etcSensorDataReplayRoute(Route route) {
    }

    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
    }

    @Override
    public void importFileResult(int n, boolean bl) {
    }

    @Override
    public void languageSpellableCharactersResult(String string) {
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.liCurrentState = true;
        this.analyze();
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
    }

    @Override
    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
    }

    @Override
    public void liResult(long l) {
        this.liResult = true;
        this.analyze();
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
    }

    @Override
    public void liThesaurusHistoryAddResult(int n, int n2) {
    }

    @Override
    public void liThesaurusHistoryDeleteAllResult(int n) {
    }

    @Override
    public void liThesaurusHistoryDeleteResult(int n, int n2) {
    }

    @Override
    public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry thesaurusHistoryEntry, int n) {
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
    }

    @Override
    public void liValueListFileStatus(int n, int n2, String string) {
    }

    @Override
    public void liValueListOutputMethod(int n) {
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
    }

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        this.poiValueList = true;
        this.analyze();
    }

    @Override
    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
    }

    @Override
    public void responseAudioTrigger(int n) {
    }

    @Override
    public void rgException(int n) {
    }

    @Override
    public void rgNotPossible(int n) {
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
    }

    @Override
    public void rmRouteDeleteAllResult(int n) {
    }

    @Override
    public void rmRouteDeleteResult(int n) {
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
    }

    @Override
    public void rmRouteRenameResult(int n) {
    }

    @Override
    public void setRemainingRangeOfVehicleResult(int n) {
    }

    @Override
    public void setTrailerStatusResult(int n) {
    }

    @Override
    public void setUserDefinedPOIsResult(int n) {
    }

    @Override
    public void setVehicleConsumptionInfoResult(int n) {
    }

    @Override
    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
    }

    @Override
    public void trDeleteTraceResult(int n, int n2) {
    }

    @Override
    public void trRenameTraceResult(int n, int n2) {
    }

    @Override
    public void trStartTraceRecordingResult(int n, long l, int n2) {
    }

    @Override
    public void trStopTraceRecordingResult(int n, long l, int n2) {
    }

    @Override
    public void translateRouteResult(Route route) {
    }

    @Override
    public void updateAfaMode(int n, int n2) {
    }

    @Override
    public void updateAfaSpeaking(boolean bl, int n) {
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
    }

    @Override
    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
    }

    @Override
    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
    }

    @Override
    public void updateCountryInfo(CountryInfo[] countryInfoArray, int n) {
    }

    @Override
    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
    }

    @Override
    public void updateDmFlagDestination(NavLocation navLocation, int n) {
    }

    @Override
    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
    }

    @Override
    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray, int n) {
    }

    @Override
    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    @Override
    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase, int n) {
    }

    @Override
    public void updateEtcDemoModeState(boolean bl, int n) {
    }

    @Override
    public void updateEtcLanguageLoadProgress(long l, int n) {
    }

    @Override
    public void updateEtcLanguageLoadStatus(int n, int n2) {
    }

    @Override
    public void updateEtcMetricSystem(int n, int n2) {
    }

    @Override
    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo, int n) {
    }

    @Override
    public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] thesaurusHistoryEntryArray, int n) {
    }

    @Override
    public void updateLanguage(String string, int n) {
    }

    @Override
    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
    }

    @Override
    public void updateLiCountryForCityAndStreetHistory(String string, int n) {
    }

    @Override
    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl, int n) {
    }

    @Override
    public void updateNavMedia(String[] stringArray, int n) {
    }

    @Override
    public void updateNavstateOfOperation(int n, int n2) {
    }

    @Override
    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray, int n) {
    }

    public void updatePOIsInsideProximityRange(NavLocation[] navLocationArray, int n) {
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
    }

    @Override
    public void updateRgActive(boolean bl, int n) {
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
    }

    @Override
    public void updateRgCurrentRoute(Route route, int n) {
    }

    @Override
    public void updateRgCurrentRouteOptions(RouteOptions routeOptions, int n) {
    }

    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
    }

    @Override
    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray, int n) {
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    @Override
    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
    }

    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    @Override
    public void updateRgPoiInfoCalculationHorizon(long l, int n) {
    }

    @Override
    public void updateRgRouteCalculationState(int n, int n2) {
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
    }

    @Override
    public void updateRgRouteProperties(RouteProperties routeProperties, int n) {
    }

    @Override
    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray, int n) {
    }

    @Override
    public void updateRgTimeAfaToDestination(long l, int n) {
    }

    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray, int n) {
    }

    @Override
    public void updateRgTurnListCalculationHorizon(long l, int n) {
    }

    @Override
    public void updateRgTurnToStreet(String string, boolean bl, int n) {
    }

    @Override
    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions, int n) {
    }

    @Override
    public void updateRgiString(short[] sArray, int n) {
    }

    @Override
    public void updateRmPersistentRoute(Route route, int n) {
    }

    @Override
    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
    }

    @Override
    public void updateRouteResumePossible(boolean bl, int n) {
    }

    @Override
    public void updateRrdActive(boolean bl, int n) {
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray, int n) {
    }

    @Override
    public void updateSoPosPosition(PosPosition posPosition, int n) {
    }

    @Override
    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
    }

    @Override
    public void updateStyleDBPaths(String[] stringArray, int n) {
    }

    @Override
    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint, int n) {
    }

    @Override
    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
    }

    @Override
    public void updateTrOperatingMode(int n, int n2) {
    }

    @Override
    public void updateTrRecordingState(int n, int n2) {
    }

    @Override
    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray, int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
    }

    @Override
    public void setVehicleFuelTypeResult(int n, int n2) {
    }

    @Override
    public void createNavLocationOfPOIUIDResult(long l, NavLocation navLocation, int n) {
    }

    @Override
    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    @Override
    public void updatePersonalPOISearchStatus(int n, int n2) {
    }

    @Override
    public void rmRouteReplaceResult(int n, long l, int n2) {
    }

    @Override
    public void deletePersonalPOIDataBasesResult(int n) {
    }

    @Override
    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray, int n) {
    }

    @Override
    public void liHistoryResult(int n) {
    }

    @Override
    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
    }

    @Override
    public void setNavInternalDataToFactorySettingsResult(int n) {
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
    }

    @Override
    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
    }

    @Override
    public void trExportTrailsResult(int n) {
    }

    @Override
    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo, int n) {
    }

    @Override
    public void rgStartRubberbandManipulationResult(int n) {
    }

    @Override
    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle, int n) {
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation, int n) {
    }

    @Override
    public void rgResult(int n) {
    }

    @Override
    public void updateRgEnhancedSignPostInfoStatus(boolean bl, int n) {
    }

    @Override
    public void updateSoPosTimeInformation(PosTimeInfo posTimeInfo, int n) {
    }

    @Override
    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
    }

    @Override
    public void lispGetMatchingNVCResult(String string) {
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    @Override
    public void etcSetDemoModeResult(int n) {
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
    }

    @Override
    public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    @Override
    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    @Override
    public void rgTriggerRCCIUpdateResult(int n) {
    }

    @Override
    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
    }

    @Override
    public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
    }

    @Override
    public void etcGetPositionTimeInfoResult(PosTimeInfo posTimeInfo, int n) {
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
    }

    @Override
    public void updateRgPersistedRouteDataAvailable(boolean bl, int n) {
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
    }

    @Override
    public void lispRequestNVCListResult(int n, String string, int n2) {
    }

    @Override
    public void updateMapIntegrationState(int n, int n2) {
    }

    @Override
    public void updateMapIntegrationProgress(int n, int n2) {
    }

    @Override
    public void etcTriggerNavigationRestartResult(int n, int n2) {
    }

    @Override
    public void updateBapManeuverState(int n, int n2) {
    }

    @Override
    public void rmImportToursFromGpxFileResult(int n) {
    }

    @Override
    public void updateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
    }

    @Override
    public void importRouteFromGpxFileResult(NavLocation navLocation) {
    }

    @Override
    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n, int n2) {
    }

    @Override
    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
    }

    @Override
    public void trClearRecordedTraceCacheResult() {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

