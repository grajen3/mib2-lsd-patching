/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public interface DSINavigationC {
    default public void afaRepeat(int n) {
    }

    default public void createExportFile(String string, int n) {
    }

    default public void dmFlagDestinationSet(NavLocation navLocation) {
    }

    default public void dmFlagDestinationRemove() {
    }

    default public void dmFlagDestinationSetName(String string) {
    }

    default public void dmLastDestinationsAddList(NavLastDest[] navLastDestArray) {
    }

    default public void dmLastDestinationsDelete(long l) {
    }

    default public void dmLastDestinationsDeleteAll() {
    }

    default public void dmLastDestinationsGet(long l) {
    }

    default public void dmLastDestinationsReplace(long l, NavLocation navLocation, String string) {
    }

    default public void dmRecentRoutesAdd(Route route, String string) {
    }

    default public void dmRecentRoutesDelete(long l) {
    }

    default public void dmRecentRoutesDeleteAll() {
    }

    default public void dmRecentRoutesGet(long l) {
    }

    default public void dmRecentRoutesReplace(long l, Route route, String string) {
    }

    default public void enableRgStreetLists(boolean bl) {
    }

    default public void enableRgLaneGuidance(boolean bl) {
    }

    default public void enableRgPoiInfo(boolean bl) {
    }

    default public void etcGetCountryAbbreviation(String string) {
    }

    default public void etcSetDemoMode(boolean bl) {
    }

    default public void etcSetDemoModeSpeed(long l) {
    }

    default public void etcSetMetricSystem(int n) {
    }

    default public void etcSelectDatabase(int n) {
    }

    default public void etcSelectNavDataBase(int n) {
    }

    default public void importFile(String string, int n) {
    }

    default public void languageSpellableCharacters(String string) {
    }

    default public void liGetCurrentState() {
    }

    default public void liGetLastCityHistoryEntry(long l) {
    }

    default public void liGetLastStreetHistoryEntry(long l) {
    }

    default public void liGetLocationDescriptionTransform(NavLocation navLocation) {
    }

    default public void liGetLocationDescriptionTransformNearBy(NavLocation navLocation) {
    }

    default public void liGetState() {
    }

    default public void liGetLastStateHistoryEntry(long l) {
    }

    default public void liLastStateHistoryAdd(NavLocation navLocation, boolean bl, String string) {
    }

    default public void liLastStateHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
    }

    default public void liLastStateHistoryDelete(long l) {
    }

    default public void liLastStateHistoryDeleteAll() {
    }

    default public void liLastCityHistoryAdd(NavLocation navLocation, boolean bl, String string) {
    }

    default public void liLastCityHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
    }

    default public void liLastCityHistoryDelete(long l) {
    }

    default public void liLastCityHistoryDeleteAll() {
    }

    default public void liLastStreetHistoryAdd(NavLocation navLocation, String string) {
    }

    default public void liLastStreetHistoryAddExtended(NavLocation navLocation, String string, LIExtData[] lIExtDataArray) {
    }

    default public void liLastStreetHistoryDelete(long l) {
    }

    default public void liLastStreetHistoryDeleteAll() {
    }

    default public void liRestoreState(LISpellerData lISpellerData) {
    }

    default public void liSetCountryForCityAndStreetHistory(String string) {
    }

    default public void liSetHistory(String string, String string2) {
    }

    default public void liSetStreetForCityHistory(String string) {
    }

    default public void liDeleteHistory() {
    }

    default public void liSetCurrentLD(NavLocation navLocation) {
    }

    default public void lispAddCharacter(String string) {
    }

    default public void lispCancelSpeller() {
    }

    default public void lispDeleteAllCharacters() {
    }

    default public void lispRequestValueListByListIndex(int n, boolean bl) {
    }

    default public void lispSelectListItem(int n) {
    }

    default public void lispSelectItemFromLocation(NavLocation navLocation) {
    }

    default public void lispSelectByCategoryUid(int n) {
    }

    default public void lispSelectByMultipleCategoryUids(int[] nArray) {
    }

    default public void lispSetInput(String string, boolean bl) {
    }

    default public void lispGetMatchingNVC(String string) {
    }

    default public void lispUndoCharacter() {
    }

    default public void liStartMultiCriteriaSpeller(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
    }

    default public void liStartSpeller(int n, boolean bl, boolean bl2, boolean bl3) {
    }

    default public void liTryBestMatch(TryBestMatchData tryBestMatchData) {
    }

    default public void liValueListFilename(String string) {
    }

    default public void liValueListOutputMethod(int n) {
    }

    default public void locationToStream(NavLocation navLocation) {
    }

    default public void poiSelectSelectionCriteria(long l) {
    }

    default public void poiSetContext(NavLocation navLocation) {
    }

    default public void poiSetSortOrder2(int n) {
    }

    default public void poiStartSpellerAlongRoute(int n, long l, long l2) {
    }

    default public void poiStartSpellerAlongRouteAdvanced(int n, long l, long l2, long l3, boolean bl) {
    }

    default public void requestSoPosPositionDescriptionVehicle() {
    }

    default public void rgCalculateRoute(Route route, int n) {
    }

    default public void rgSetPosition(NavLocation navLocation) {
    }

    default public void rgSetRouteGuidanceMode(int n) {
    }

    default public void rgSetRouteOptions(RouteOptions routeOptions) {
    }

    default public void rgStartGuidanceCalculatedRoute(int n) {
    }

    default public void rgStopGuidance() {
    }

    default public void rmMakeRoutePersistent(Route route) {
    }

    default public void rmRouteAdd(int n, Route route, String string) {
    }

    default public void rmRouteDelete(int n, long l) {
    }

    default public void rmRouteDeleteAll(int n) {
    }

    default public void rmRouteGet(int n, long l) {
    }

    default public void rmRouteRename(int n, long l, String string) {
    }

    default public void rrdStartCalculationByListIndex(int n, long l) {
    }

    default public void rrdStartCalculationForPosition(NavLocationWgs84[] navLocationWgs84Array) {
    }

    default public void rrdStopCalculation() {
    }

    default public void setLanguage(String string) {
    }

    default public void streamToLocation(byte[] byArray) {
    }

    default public void translateRoute(Route route) {
    }

    default public void trCreateWaypoint() {
    }

    default public void trDeleteAllTraces() {
    }

    default public void trDeleteTrace(NavSegmentID navSegmentID) {
    }

    default public void trRenameTrace(NavSegmentID navSegmentID, String string) {
    }

    default public void trStartTraceRecording(int n) {
    }

    default public void trStopTraceRecording() {
    }

    default public void trStoreTrace(String string) {
    }

    default public void liStripLocation(NavLocation navLocation, int n) {
    }

    default public void liSetNVCRange(int n) {
    }

    default public void liValueListWindowSize(int n) {
    }

    default public void requestAudioTrigger(int n) {
    }

    default public void liThesaurusHistoryAdd(String string) {
    }

    default public void liThesaurusHistoryGetEntry(int n) {
    }

    default public void liThesaurusHistoryDelete(int n) {
    }

    default public void liThesaurusHistoryDeleteAll() {
    }

    default public void ehGetAllCategories(int n) {
    }

    default public void ehGetAllBrandsOfCategory(int n, int n2) {
    }

    default public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
    }

    default public void ehSetCategoryVisibilityToDefault(int n) {
    }

    default public void ehSetCategoryAudioWarning(int n, int[] nArray, boolean[] blArray) {
    }

    default public void ehSetCategoryMonitoring(int[] nArray, boolean[] blArray) {
    }

    default public void ehSetBrandVisibility(int n, int[] nArray, boolean[] blArray) {
    }

    default public void ehSetBrandPreference(int n, int[] nArray, boolean[] blArray) {
    }

    default public void setRemainingRangeOfVehicle(int n) {
    }

    default public void setUserDefinedPOIs(NavLocation[] navLocationArray) {
    }

    default public void setTrailerStatus(boolean bl) {
    }

    default public void requestCountryInfo(String string) {
    }

    default public void jumpToNextManeuver() {
    }

    default public void liGetViaPointCountryList() {
    }

    default public void liSetViaPointCountry(String string) {
    }

    default public void liGetViaPointList(int n, int n2, int n3, int n4) {
    }

    default public void liSelectViaPoint(int n) {
    }

    default public void rgStartGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
    }

    default public void liGetSpellableCharacters(NavLocation navLocation, int n) {
    }

    default public void liStopSpeller() {
    }

    default public void liValueListMaximumLength(int n) {
    }

    default public void setPathsToPersonalPOIDataBases(String[] stringArray) {
    }

    default public void deletePersonalPOIDataBases(String[] stringArray) {
    }

    default public void rgStopRouteCalculation() {
    }

    default public void rgSwitchToNextPossibleRoad() {
    }

    default public void setVehicleFuelType(int n) {
    }

    default public void createNavLocationOfPOIUID(long l) {
    }

    default public void lispSelectListItemByIdent(String string) {
    }

    default public void rmRouteReplace(int n, long l, Route route) {
    }

    default public void setNavInternalDataToFactorySettings() {
    }

    default public void liTryMatchLocation(TryMatchLocationData tryMatchLocationData) {
    }

    default public void trImportTrails(String string) {
    }

    default public void trExportTrails(NavSegmentID[] navSegmentIDArray, String string) {
    }

    default public void rgSkipNextWayPoints(int n) {
    }

    default public void rgReverseTrailDirection() {
    }

    default public void rgPrepareRubberbandManipulation(boolean bl) {
    }

    default public void rgStartRubberbandManipulation(int n) {
    }

    default public void rgSetRubberbandPosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public void rgGetRouteBoundingRectangle(boolean bl, int n) {
    }

    default public void rgGetLocationOnRoute(long l) {
    }

    default public void rgStopRubberbandManipulation() {
    }

    default public void rgDeleteCalculatedRubberbandPoint() {
    }

    default public void rgGetRubberBandPointPosition() {
    }

    default public void rgEnableEnhancedSignPostInfo(boolean bl) {
    }

    default public void lispGetLocationFromLiValueListElement(int n) {
    }

    default public void rgSetTurnListMode(int n) {
    }

    default public void liHistoryAddLocation(NavLocation navLocation) {
    }

    default public void liLastCityHistorySetStreet(NavLocation navLocation) {
    }

    default public void liLastStreetHistorySetCity(NavLocation navLocation) {
    }

    default public void enableRgMotorwayInfo(boolean bl) {
    }

    default public void rgTriggerRCCIUpdate() {
    }

    default public void poiGetXt9LDBs(NavLocation navLocation, int n) {
    }

    default public void poiSetListStyle(int n) {
    }

    default public void etcGetPositionTimeInfo(NavLocationWgs84 navLocationWgs84) {
    }

    default public void poiGetCategoryTypesFromUId(int n) {
    }

    default public void rgDeletePersistedRouteData() {
    }

    default public void rgCalculate1stRouteAndPostponeRemaining(Route route, int n, boolean bl) {
    }

    default public void liDisambiguateLocation(NavLocation navLocation) {
    }

    default public void triggerEventAudioMessage(int n) {
    }

    default public void lispAddStroke(String string) {
    }

    default public void lispRequestNVCList(int n, int n2, int n3) {
    }

    default public void poiConfigureContext(String string, int n, NavLocation navLocation, int[] nArray) {
    }

    default public void etcTriggerNavigationRestart(int n) {
    }

    default public void rmImportToursFromGpxFile(int n, String string) {
    }

    default public void rmAbortImportToursFromGpxFile() {
    }

    default public void importRouteFromGpxFile(String string) {
    }

    default public void poiRequestExtendedInfo(NavLocation navLocation) {
    }

    default public void rgConfigurePoiInfo(NavPoiInfoConfiguration navPoiInfoConfiguration) {
    }

    default public void trClearRecordedTraceCache() {
    }

    default public void setVirtualRouteGuidance(boolean bl) {
    }

    default public void profileChange(int n) {
    }

    default public void profileCopy(int n, int n2) {
    }

    default public void profileReset(int n) {
    }

    default public void profileResetAll() {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

