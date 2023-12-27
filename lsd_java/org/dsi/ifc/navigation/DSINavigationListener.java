/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIListener;
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

public interface DSINavigationListener
extends DSIListener {
    default public void updateAfaMode(int n, int n2) {
    }

    default public void updateAfaSpeaking(boolean bl, int n) {
    }

    default public void updateEtcDemoModeState(boolean bl, int n) {
    }

    default public void updateEtcLanguageLoadProgress(long l, int n) {
    }

    default public void updateEtcLanguageLoadStatus(int n, int n2) {
    }

    default public void updateEtcMetricSystem(int n, int n2) {
    }

    default public void updateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
    }

    default public void updateDmRecentRoutesList(RRListElement[] rRListElementArray, int n) {
    }

    default public void updateLispIsSpellerActive(boolean bl, int n) {
    }

    default public void updateRgActive(boolean bl, int n) {
    }

    default public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    default public void updateRgCurrentRoute(Route route, int n) {
    }

    default public void updateRgCurrentRouteOptions(RouteOptions routeOptions, int n) {
    }

    default public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
    }

    default public void updateRgTurnToStreet(String string, boolean bl, int n) {
    }

    default public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions, int n) {
    }

    default public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
    }

    default public void updateRgStreetList(NavRouteListData[] navRouteListDataArray, int n) {
    }

    default public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    default public void rgException(int n) {
    }

    default public void updateRgRouteProperties(RouteProperties routeProperties, int n) {
    }

    default public void updateSoPosPosition(PosPosition posPosition, int n) {
    }

    default public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
    }

    default public void updateSoPosTimeInformation(PosTimeInfo posTimeInfo, int n) {
    }

    default public void updateRrdActive(boolean bl, int n) {
    }

    default public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray, int n) {
    }

    default public void updateEtcVersionInfo(NavVersionInfo navVersionInfo, int n) {
    }

    default public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    default public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
    }

    default public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
    }

    default public void updateRgiString(short[] sArray, int n) {
    }

    default public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray, int n) {
    }

    default public void updateRmPersistentRoute(Route route, int n) {
    }

    default public void updateRgTimeAfaToDestination(long l, int n) {
    }

    default public void etcSensorDataReplayRoute(Route route) {
    }

    default public void etcSensorDataReplayGuidance(boolean bl) {
    }

    default public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
    }

    default public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
    }

    default public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
    }

    default public void updateTrOperatingMode(int n, int n2) {
    }

    default public void updateTrTraceList(NavTraceListData[] navTraceListDataArray, int n) {
    }

    default public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
    }

    default public void updateRgRouteCalculationState(int n, int n2) {
    }

    default public void updateNavstateOfOperation(int n, int n2) {
    }

    default public void updateNavMedia(String[] stringArray, int n) {
    }

    default public void updateRgTurnList(TurnListElement[] turnListElementArray, int n) {
    }

    default public void updateAvailableLanguages(String[] stringArray, int n) {
    }

    default public void updateLanguage(String string, int n) {
    }

    default public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
    }

    default public void updateEtcCurrentNavDataBase(NavDataBase navDataBase, int n) {
    }

    default public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint, int n) {
    }

    default public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
    }

    default public void updateTrRecordingState(int n, int n2) {
    }

    default public void rgSetRouteGuidanceModeResult() {
    }

    default public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
    }

    default public void dmRecentRoutesGetResult(long l, Route route) {
    }

    default public void dmResult(long l, long l2) {
    }

    default public void liGetStateResult(LISpellerData lISpellerData) {
    }

    default public void liResult(long l) {
    }

    default public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
    }

    default public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
    }

    default public void liValueList(LIValueList lIValueList, long l) {
    }

    default public void poiValueList(LIValueList lIValueList, long l) {
    }

    default public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
    }

    default public void rmMakeRoutePersistentResult(long l) {
    }

    default public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
    }

    default public void etcGetCountryAbbreviationResult(String string, long l) {
    }

    default public void trStartTraceRecordingResult(int n, long l, int n2) {
    }

    default public void trStopTraceRecordingResult(int n, long l, int n2) {
    }

    default public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
    }

    default public void trRenameTraceResult(int n, int n2) {
    }

    default public void trDeleteTraceResult(int n, int n2) {
    }

    default public void trDeleteAllTracesResult(int n, int n2) {
    }

    default public void rmRouteAddResult(int n, long l) {
    }

    default public void rmRouteDeleteResult(int n) {
    }

    default public void rmRouteDeleteAllResult(int n) {
    }

    default public void rmRouteGetResult(int n, Route route) {
    }

    default public void rmRouteRenameResult(int n) {
    }

    default public void createExportFileResult(int n, boolean bl) {
    }

    default public void importFileResult(int n, boolean bl) {
    }

    default public void languageSpellableCharactersResult(String string) {
    }

    default public void rgNotPossible(int n) {
    }

    default public void translateRouteResult(Route route) {
    }

    default public void locationToStreamResult(boolean bl, byte[] byArray) {
    }

    default public void streamToLocationResult(boolean bl, NavLocation navLocation) {
    }

    default public void liValueListFileStatus(int n, int n2, String string) {
    }

    default public void liValueListOutputMethod(int n) {
    }

    default public void updateDmFlagDestination(NavLocation navLocation, int n) {
    }

    default public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    default public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    default public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
    }

    default public void updateLiCountryForCityAndStreetHistory(String string, int n) {
    }

    default public void liLastCityAndStreetHistoryResult(long l) {
    }

    default public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
    }

    default public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray, int n) {
    }

    default public void liHistoryResult(int n) {
    }

    default public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    default public void updateRgTurnListCalculationHorizon(long l, int n) {
    }

    default public void updateRgPoiInfoCalculationHorizon(long l, int n) {
    }

    default public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
    }

    default public void liStripLocationResult(NavLocation navLocation) {
    }

    default public void responseAudioTrigger(int n) {
    }

    default public void updateAudioRequest(int n, int n2) {
    }

    default public void liSetCountryForCityAndStreetHistoryResult(int n) {
    }

    default public void rgStartGuidanceCalculatedRouteResult(int n) {
    }

    default public void rgSwitchToNextPossibleRoadResult(boolean bl) {
    }

    default public void liThesaurusHistoryAddResult(int n, int n2) {
    }

    default public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry thesaurusHistoryEntry, int n) {
    }

    default public void liThesaurusHistoryDeleteResult(int n, int n2) {
    }

    default public void liThesaurusHistoryDeleteAllResult(int n) {
    }

    default public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] thesaurusHistoryEntryArray, int n) {
    }

    default public void updateCountryInfo(CountryInfo[] countryInfoArray, int n) {
    }

    default public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
    }

    default public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
    }

    default public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
    }

    default public void ehResult(int n, int n2) {
    }

    default public void setRemainingRangeOfVehicleResult(int n) {
    }

    default public void setVehicleConsumptionInfoResult(int n) {
    }

    default public void setUserDefinedPOIsResult(int n) {
    }

    default public void setTrailerStatusResult(int n) {
    }

    default public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
    }

    default public void liSelectViaPointResult(NavLocation navLocation, int n) {
    }

    default public void updateStyleDBPaths(String[] stringArray, int n) {
    }

    default public void updateRouteResumePossible(boolean bl, int n) {
    }

    default public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    default public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray, int n) {
    }

    default public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
    }

    default public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    default public void updatePersonalPOISearchStatus(int n, int n2) {
    }

    default public void deletePersonalPOIDataBasesResult(int n) {
    }

    default public void setVehicleFuelTypeResult(int n, int n2) {
    }

    default public void createNavLocationOfPOIUIDResult(long l, NavLocation navLocation, int n) {
    }

    default public void rmRouteReplaceResult(int n, long l, int n2) {
    }

    default public void setNavInternalDataToFactorySettingsResult(int n) {
    }

    default public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
    }

    default public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
    }

    default public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    default public void trExportTrailsResult(int n) {
    }

    default public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo, int n) {
    }

    default public void rgStartRubberbandManipulationResult(int n) {
    }

    default public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle, int n) {
    }

    default public void rgGetLocationOnRouteResult(NavLocation navLocation, int n) {
    }

    default public void rgResult(int n) {
    }

    default public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
    }

    default public void updateRgEnhancedSignPostInfoStatus(boolean bl, int n) {
    }

    default public void etcSetDemoModeResult(int n) {
    }

    default public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
    }

    default public void lispGetMatchingNVCResult(String string) {
    }

    default public void poiGetXt9LDBsResult(String[] stringArray) {
    }

    default public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    default public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    default public void rgTriggerRCCIUpdateResult(int n) {
    }

    default public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
    }

    default public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
    }

    default public void etcGetPositionTimeInfoResult(PosTimeInfo posTimeInfo, int n) {
    }

    default public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
    }

    default public void updateRgPersistedRouteDataAvailable(boolean bl, int n) {
    }

    default public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
    }

    default public void triggerEventAudioMessageResult(int n) {
    }

    default public void updateMapIntegrationState(int n, int n2) {
    }

    default public void updateMapIntegrationProgress(int n, int n2) {
    }

    default public void etcTriggerNavigationRestartResult(int n, int n2) {
    }

    default public void lispRequestNVCListResult(int n, String string, int n2) {
    }

    default public void updateBapManeuverState(int n, int n2) {
    }

    default public void rmImportToursFromGpxFileResult(int n) {
    }

    default public void updateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
    }

    default public void importRouteFromGpxFileResult(NavLocation navLocation) {
    }

    default public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n, int n2) {
    }

    default public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
    }

    default public void trClearRecordedTraceCacheResult() {
    }

    default public void updateProfileState(int n, int n2, int n3) {
    }

    default public void profileChanged(int n, int n2) {
    }

    default public void profileCopied(int n, int n2, int n3) {
    }

    default public void profileReset(int n, int n2) {
    }

    default public void profileResetAll(int n) {
    }
}

