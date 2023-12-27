/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.navigation;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.navigation.DSINavigationReply;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryMatchLocationData;
import org.osgi.framework.BundleContext;

public class DSINavigationProvider
extends AbstractProvider
implements DSINavigation {
    private static final int[] attributeIDs = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 64, 21, 22, 23, 24, 25, 28, 29, 31, 32, 34, 37, 38, 39, 42, 43, 45, 46, 47, 48, 49, 52, 53, 54, 55, 56, 57, 61, 62, 63, 65, 66, 67, 68, 69, 70, 75, 76, 77, 78, 81, 82, 83, 84, 85, 86, 87, 88, 89, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107};
    private DSINavigationProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public DSINavigationProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavigationProvider.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSINavigationProxy(this.instance, (DSINavigationReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void afaRepeat(int n) {
        try {
            this.proxy.afaRepeat(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createExportFile(String string, int n) {
        try {
            this.proxy.createExportFile(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmFlagDestinationSet(NavLocation navLocation) {
        try {
            this.proxy.dmFlagDestinationSet(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmFlagDestinationRemove() {
        try {
            this.proxy.dmFlagDestinationRemove();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmFlagDestinationSetName(String string) {
        try {
            this.proxy.dmFlagDestinationSetName(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmLastDestinationsAddList(NavLastDest[] navLastDestArray) {
        try {
            this.proxy.dmLastDestinationsAddList(navLastDestArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmLastDestinationsDelete(long l) {
        try {
            this.proxy.dmLastDestinationsDelete(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmLastDestinationsDeleteAll() {
        try {
            this.proxy.dmLastDestinationsDeleteAll();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmLastDestinationsGet(long l) {
        try {
            this.proxy.dmLastDestinationsGet(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmLastDestinationsReplace(long l, NavLocation navLocation, String string) {
        try {
            this.proxy.dmLastDestinationsReplace(l, navLocation, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmRecentRoutesAdd(Route route, String string) {
        try {
            this.proxy.dmRecentRoutesAdd(route, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmRecentRoutesDelete(long l) {
        try {
            this.proxy.dmRecentRoutesDelete(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmRecentRoutesDeleteAll() {
        try {
            this.proxy.dmRecentRoutesDeleteAll();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmRecentRoutesGet(long l) {
        try {
            this.proxy.dmRecentRoutesGet(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dmRecentRoutesReplace(long l, Route route, String string) {
        try {
            this.proxy.dmRecentRoutesReplace(l, route, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableRgStreetLists(boolean bl) {
        try {
            this.proxy.enableRgStreetLists(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableRgLaneGuidance(boolean bl) {
        try {
            this.proxy.enableRgLaneGuidance(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableRgPoiInfo(boolean bl) {
        try {
            this.proxy.enableRgPoiInfo(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void etcGetCountryAbbreviation(String string) {
        try {
            this.proxy.etcGetCountryAbbreviation(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void etcSetDemoMode(boolean bl) {
        try {
            this.proxy.etcSetDemoMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void etcSetDemoModeSpeed(long l) {
        try {
            this.proxy.etcSetDemoModeSpeed(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void etcSetMetricSystem(int n) {
        try {
            this.proxy.etcSetMetricSystem(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void etcSelectDatabase(int n) {
        try {
            this.proxy.etcSelectDatabase(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void etcSelectNavDataBase(int n) {
        try {
            this.proxy.etcSelectNavDataBase(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void importFile(String string, int n) {
        try {
            this.proxy.importFile(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void languageSpellableCharacters(String string) {
        try {
            this.proxy.languageSpellableCharacters(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liGetCurrentState() {
        try {
            this.proxy.liGetCurrentState();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liGetLastCityHistoryEntry(long l) {
        try {
            this.proxy.liGetLastCityHistoryEntry(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liGetLastStreetHistoryEntry(long l) {
        try {
            this.proxy.liGetLastStreetHistoryEntry(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liGetLocationDescriptionTransform(NavLocation navLocation) {
        try {
            this.proxy.liGetLocationDescriptionTransform(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liGetLocationDescriptionTransformNearBy(NavLocation navLocation) {
        try {
            this.proxy.liGetLocationDescriptionTransformNearBy(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liGetState() {
        try {
            this.proxy.liGetState();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liGetLastStateHistoryEntry(long l) {
        try {
            this.proxy.liGetLastStateHistoryEntry(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastStateHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        try {
            this.proxy.liLastStateHistoryAdd(navLocation, bl, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastStateHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        try {
            this.proxy.liLastStateHistoryAddExtended(navLocation, bl, string, lIExtDataArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastStateHistoryDelete(long l) {
        try {
            this.proxy.liLastStateHistoryDelete(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastStateHistoryDeleteAll() {
        try {
            this.proxy.liLastStateHistoryDeleteAll();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastCityHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        try {
            this.proxy.liLastCityHistoryAdd(navLocation, bl, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastCityHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        try {
            this.proxy.liLastCityHistoryAddExtended(navLocation, bl, string, lIExtDataArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastCityHistoryDelete(long l) {
        try {
            this.proxy.liLastCityHistoryDelete(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastCityHistoryDeleteAll() {
        try {
            this.proxy.liLastCityHistoryDeleteAll();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastStreetHistoryAdd(NavLocation navLocation, String string) {
        try {
            this.proxy.liLastStreetHistoryAdd(navLocation, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastStreetHistoryAddExtended(NavLocation navLocation, String string, LIExtData[] lIExtDataArray) {
        try {
            this.proxy.liLastStreetHistoryAddExtended(navLocation, string, lIExtDataArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastStreetHistoryDelete(long l) {
        try {
            this.proxy.liLastStreetHistoryDelete(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastStreetHistoryDeleteAll() {
        try {
            this.proxy.liLastStreetHistoryDeleteAll();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liRestoreState(LISpellerData lISpellerData) {
        try {
            this.proxy.liRestoreState(lISpellerData);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liSetCountryForCityAndStreetHistory(String string) {
        try {
            this.proxy.liSetCountryForCityAndStreetHistory(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liSetHistory(String string, String string2) {
        try {
            this.proxy.liSetHistory(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liSetStreetForCityHistory(String string) {
        try {
            this.proxy.liSetStreetForCityHistory(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liDeleteHistory() {
        try {
            this.proxy.liDeleteHistory();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liSetCurrentLD(NavLocation navLocation) {
        try {
            this.proxy.liSetCurrentLD(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispAddCharacter(String string) {
        try {
            this.proxy.lispAddCharacter(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispCancelSpeller() {
        try {
            this.proxy.lispCancelSpeller();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispDeleteAllCharacters() {
        try {
            this.proxy.lispDeleteAllCharacters();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispRequestValueListByListIndex(int n, boolean bl) {
        try {
            this.proxy.lispRequestValueListByListIndex(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispSelectListItem(int n) {
        try {
            this.proxy.lispSelectListItem(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispSelectItemFromLocation(NavLocation navLocation) {
        try {
            this.proxy.lispSelectItemFromLocation(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispSelectByCategoryUid(int n) {
        try {
            this.proxy.lispSelectByCategoryUid(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispSelectByMultipleCategoryUids(int[] nArray) {
        try {
            this.proxy.lispSelectByMultipleCategoryUids(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispSetInput(String string, boolean bl) {
        try {
            this.proxy.lispSetInput(string, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispGetMatchingNVC(String string) {
        try {
            this.proxy.lispGetMatchingNVC(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispUndoCharacter() {
        try {
            this.proxy.lispUndoCharacter();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liStartMultiCriteriaSpeller(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        try {
            this.proxy.liStartMultiCriteriaSpeller(n, n2, bl, bl2, bl3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liStartSpeller(int n, boolean bl, boolean bl2, boolean bl3) {
        try {
            this.proxy.liStartSpeller(n, bl, bl2, bl3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liTryBestMatch(TryBestMatchData tryBestMatchData) {
        try {
            this.proxy.liTryBestMatch(tryBestMatchData);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liValueListFilename(String string) {
        try {
            this.proxy.liValueListFilename(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liValueListOutputMethod(int n) {
        try {
            this.proxy.liValueListOutputMethod(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void locationToStream(NavLocation navLocation) {
        try {
            this.proxy.locationToStream(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiSelectSelectionCriteria(long l) {
        try {
            this.proxy.poiSelectSelectionCriteria(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiSetContext(NavLocation navLocation) {
        try {
            this.proxy.poiSetContext(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiSetSortOrder2(int n) {
        try {
            this.proxy.poiSetSortOrder2(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiStartSpellerAlongRoute(int n, long l, long l2) {
        try {
            this.proxy.poiStartSpellerAlongRoute(n, l, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiStartSpellerAlongRouteAdvanced(int n, long l, long l2, long l3, boolean bl) {
        try {
            this.proxy.poiStartSpellerAlongRouteAdvanced(n, l, l2, l3, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSoPosPositionDescriptionVehicle() {
        try {
            this.proxy.requestSoPosPositionDescriptionVehicle();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgCalculateRoute(Route route, int n) {
        try {
            this.proxy.rgCalculateRoute(route, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgSetPosition(NavLocation navLocation) {
        try {
            this.proxy.rgSetPosition(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgSetRouteGuidanceMode(int n) {
        try {
            this.proxy.rgSetRouteGuidanceMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgSetRouteOptions(RouteOptions routeOptions) {
        try {
            this.proxy.rgSetRouteOptions(routeOptions);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRoute(int n) {
        try {
            this.proxy.rgStartGuidanceCalculatedRoute(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgStopGuidance() {
        try {
            this.proxy.rgStopGuidance();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rmMakeRoutePersistent(Route route) {
        try {
            this.proxy.rmMakeRoutePersistent(route);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rmRouteAdd(int n, Route route, String string) {
        try {
            this.proxy.rmRouteAdd(n, route, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rmRouteDelete(int n, long l) {
        try {
            this.proxy.rmRouteDelete(n, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rmRouteDeleteAll(int n) {
        try {
            this.proxy.rmRouteDeleteAll(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rmRouteGet(int n, long l) {
        try {
            this.proxy.rmRouteGet(n, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rmRouteRename(int n, long l, String string) {
        try {
            this.proxy.rmRouteRename(n, l, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rrdStartCalculationByListIndex(int n, long l) {
        try {
            this.proxy.rrdStartCalculationByListIndex(n, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rrdStartCalculationForPosition(NavLocationWgs84[] navLocationWgs84Array) {
        try {
            this.proxy.rrdStartCalculationForPosition(navLocationWgs84Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rrdStopCalculation() {
        try {
            this.proxy.rrdStopCalculation();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLanguage(String string) {
        try {
            this.proxy.setLanguage(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void streamToLocation(byte[] byArray) {
        try {
            this.proxy.streamToLocation(byArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void translateRoute(Route route) {
        try {
            this.proxy.translateRoute(route);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void trCreateWaypoint() {
        try {
            this.proxy.trCreateWaypoint();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void trDeleteAllTraces() {
        try {
            this.proxy.trDeleteAllTraces();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void trDeleteTrace(NavSegmentID navSegmentID) {
        try {
            this.proxy.trDeleteTrace(navSegmentID);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void trRenameTrace(NavSegmentID navSegmentID, String string) {
        try {
            this.proxy.trRenameTrace(navSegmentID, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void trStartTraceRecording(int n) {
        try {
            this.proxy.trStartTraceRecording(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void trStopTraceRecording() {
        try {
            this.proxy.trStopTraceRecording();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void trStoreTrace(String string) {
        try {
            this.proxy.trStoreTrace(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liStripLocation(NavLocation navLocation, int n) {
        try {
            this.proxy.liStripLocation(navLocation, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liSetNVCRange(int n) {
        try {
            this.proxy.liSetNVCRange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liValueListWindowSize(int n) {
        try {
            this.proxy.liValueListWindowSize(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAudioTrigger(int n) {
        try {
            this.proxy.requestAudioTrigger(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liThesaurusHistoryAdd(String string) {
        try {
            this.proxy.liThesaurusHistoryAdd(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liThesaurusHistoryGetEntry(int n) {
        try {
            this.proxy.liThesaurusHistoryGetEntry(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liThesaurusHistoryDelete(int n) {
        try {
            this.proxy.liThesaurusHistoryDelete(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liThesaurusHistoryDeleteAll() {
        try {
            this.proxy.liThesaurusHistoryDeleteAll();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ehGetAllCategories(int n) {
        try {
            this.proxy.ehGetAllCategories(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ehGetAllBrandsOfCategory(int n, int n2) {
        try {
            this.proxy.ehGetAllBrandsOfCategory(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        try {
            this.proxy.ehSetCategoryVisibility(n, nArray, blArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ehSetCategoryVisibilityToDefault(int n) {
        try {
            this.proxy.ehSetCategoryVisibilityToDefault(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ehSetCategoryAudioWarning(int n, int[] nArray, boolean[] blArray) {
        try {
            this.proxy.ehSetCategoryAudioWarning(n, nArray, blArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ehSetCategoryMonitoring(int[] nArray, boolean[] blArray) {
        try {
            this.proxy.ehSetCategoryMonitoring(nArray, blArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ehSetBrandVisibility(int n, int[] nArray, boolean[] blArray) {
        try {
            this.proxy.ehSetBrandVisibility(n, nArray, blArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ehSetBrandPreference(int n, int[] nArray, boolean[] blArray) {
        try {
            this.proxy.ehSetBrandPreference(n, nArray, blArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRemainingRangeOfVehicle(int n) {
        try {
            this.proxy.setRemainingRangeOfVehicle(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUserDefinedPOIs(NavLocation[] navLocationArray) {
        try {
            this.proxy.setUserDefinedPOIs(navLocationArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTrailerStatus(boolean bl) {
        try {
            this.proxy.setTrailerStatus(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCountryInfo(String string) {
        try {
            this.proxy.requestCountryInfo(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void jumpToNextManeuver() {
        try {
            this.proxy.jumpToNextManeuver();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liGetViaPointCountryList() {
        try {
            this.proxy.liGetViaPointCountryList();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liSetViaPointCountry(String string) {
        try {
            this.proxy.liSetViaPointCountry(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liGetViaPointList(int n, int n2, int n3, int n4) {
        try {
            this.proxy.liGetViaPointList(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liSelectViaPoint(int n) {
        try {
            this.proxy.liSelectViaPoint(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
        try {
            this.proxy.rgStartGuidanceCalculatedRouteByUID(navSegmentID);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liGetSpellableCharacters(NavLocation navLocation, int n) {
        try {
            this.proxy.liGetSpellableCharacters(navLocation, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liStopSpeller() {
        try {
            this.proxy.liStopSpeller();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liValueListMaximumLength(int n) {
        try {
            this.proxy.liValueListMaximumLength(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPathsToPersonalPOIDataBases(String[] stringArray) {
        try {
            this.proxy.setPathsToPersonalPOIDataBases(stringArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deletePersonalPOIDataBases(String[] stringArray) {
        try {
            this.proxy.deletePersonalPOIDataBases(stringArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgStopRouteCalculation() {
        try {
            this.proxy.rgStopRouteCalculation();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgSwitchToNextPossibleRoad() {
        try {
            this.proxy.rgSwitchToNextPossibleRoad();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVehicleFuelType(int n) {
        try {
            this.proxy.setVehicleFuelType(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createNavLocationOfPOIUID(long l) {
        try {
            this.proxy.createNavLocationOfPOIUID(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispSelectListItemByIdent(String string) {
        try {
            this.proxy.lispSelectListItemByIdent(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rmRouteReplace(int n, long l, Route route) {
        try {
            this.proxy.rmRouteReplace(n, l, route);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNavInternalDataToFactorySettings() {
        try {
            this.proxy.setNavInternalDataToFactorySettings();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liTryMatchLocation(TryMatchLocationData tryMatchLocationData) {
        try {
            this.proxy.liTryMatchLocation(tryMatchLocationData);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void trImportTrails(String string) {
        try {
            this.proxy.trImportTrails(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void trExportTrails(NavSegmentID[] navSegmentIDArray, String string) {
        try {
            this.proxy.trExportTrails(navSegmentIDArray, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgSkipNextWayPoints(int n) {
        try {
            this.proxy.rgSkipNextWayPoints(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgReverseTrailDirection() {
        try {
            this.proxy.rgReverseTrailDirection();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgPrepareRubberbandManipulation(boolean bl) {
        try {
            this.proxy.rgPrepareRubberbandManipulation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgStartRubberbandManipulation(int n) {
        try {
            this.proxy.rgStartRubberbandManipulation(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgSetRubberbandPosition(NavLocationWgs84 navLocationWgs84) {
        try {
            this.proxy.rgSetRubberbandPosition(navLocationWgs84);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgGetRouteBoundingRectangle(boolean bl, int n) {
        try {
            this.proxy.rgGetRouteBoundingRectangle(bl, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgGetLocationOnRoute(long l) {
        try {
            this.proxy.rgGetLocationOnRoute(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgStopRubberbandManipulation() {
        try {
            this.proxy.rgStopRubberbandManipulation();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgDeleteCalculatedRubberbandPoint() {
        try {
            this.proxy.rgDeleteCalculatedRubberbandPoint();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgGetRubberBandPointPosition() {
        try {
            this.proxy.rgGetRubberBandPointPosition();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgEnableEnhancedSignPostInfo(boolean bl) {
        try {
            this.proxy.rgEnableEnhancedSignPostInfo(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispGetLocationFromLiValueListElement(int n) {
        try {
            this.proxy.lispGetLocationFromLiValueListElement(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgSetTurnListMode(int n) {
        try {
            this.proxy.rgSetTurnListMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liHistoryAddLocation(NavLocation navLocation) {
        try {
            this.proxy.liHistoryAddLocation(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastCityHistorySetStreet(NavLocation navLocation) {
        try {
            this.proxy.liLastCityHistorySetStreet(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liLastStreetHistorySetCity(NavLocation navLocation) {
        try {
            this.proxy.liLastStreetHistorySetCity(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableRgMotorwayInfo(boolean bl) {
        try {
            this.proxy.enableRgMotorwayInfo(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgTriggerRCCIUpdate() {
        try {
            this.proxy.rgTriggerRCCIUpdate();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiGetXt9LDBs(NavLocation navLocation, int n) {
        try {
            this.proxy.poiGetXt9LDBs(navLocation, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiSetListStyle(int n) {
        try {
            this.proxy.poiSetListStyle(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void etcGetPositionTimeInfo(NavLocationWgs84 navLocationWgs84) {
        try {
            this.proxy.etcGetPositionTimeInfo(navLocationWgs84);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiGetCategoryTypesFromUId(int n) {
        try {
            this.proxy.poiGetCategoryTypesFromUId(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgDeletePersistedRouteData() {
        try {
            this.proxy.rgDeletePersistedRouteData();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgCalculate1stRouteAndPostponeRemaining(Route route, int n, boolean bl) {
        try {
            this.proxy.rgCalculate1stRouteAndPostponeRemaining(route, n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void liDisambiguateLocation(NavLocation navLocation) {
        try {
            this.proxy.liDisambiguateLocation(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void triggerEventAudioMessage(int n) {
        try {
            this.proxy.triggerEventAudioMessage(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispAddStroke(String string) {
        try {
            this.proxy.lispAddStroke(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lispRequestNVCList(int n, int n2, int n3) {
        try {
            this.proxy.lispRequestNVCList(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiConfigureContext(String string, int n, NavLocation navLocation, int[] nArray) {
        try {
            this.proxy.poiConfigureContext(string, n, navLocation, nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void etcTriggerNavigationRestart(int n) {
        try {
            this.proxy.etcTriggerNavigationRestart(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rmImportToursFromGpxFile(int n, String string) {
        try {
            this.proxy.rmImportToursFromGpxFile(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rmAbortImportToursFromGpxFile() {
        try {
            this.proxy.rmAbortImportToursFromGpxFile();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void importRouteFromGpxFile(String string) {
        try {
            this.proxy.importRouteFromGpxFile(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiRequestExtendedInfo(NavLocation navLocation) {
        try {
            this.proxy.poiRequestExtendedInfo(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rgConfigurePoiInfo(NavPoiInfoConfiguration navPoiInfoConfiguration) {
        try {
            this.proxy.rgConfigurePoiInfo(navPoiInfoConfiguration);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void trClearRecordedTraceCache() {
        try {
            this.proxy.trClearRecordedTraceCache();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVirtualRouteGuidance(boolean bl) {
        try {
            this.proxy.setVirtualRouteGuidance(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileChange(int n) {
        try {
            this.proxy.profileChange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileCopy(int n, int n2) {
        try {
            this.proxy.profileCopy(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileReset(int n) {
        try {
            this.proxy.profileReset(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileResetAll() {
        try {
            this.proxy.profileResetAll();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
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

