/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSINavigationVW;
import org.dsi.ifc.base.DSIListener;
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

public class DSINavigationVWImpl
implements DSINavigationVW {
    private DSINavigation dsiNavigation;
    private boolean facadeEnabled;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSINavigationVWImpl]");

    @Override
    public void afaRepeat(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("afaRepeat( int source )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.afaRepeat(n);
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("clearNotification( DSIListener listener )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.clearNotification(dSIListener);
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("clearNotification( int attribute, DSIListener listener )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.clearNotification(n, dSIListener);
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("clearNotification( int[] attributes, DSIListener listener )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.clearNotification(nArray, dSIListener);
    }

    @Override
    public void createExportFile(String string, int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("createExportFile( String file, int userID )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.createExportFile(string, n);
    }

    @Override
    public void createNavLocationOfPOIUID(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("createNavLocationOfPOIUID( long poiUid )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.createNavLocationOfPOIUID(l);
    }

    @Override
    public void deletePersonalPOIDataBases(String[] stringArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("deletePersonalPOIDataBases( String[] paths )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.deletePersonalPOIDataBases(stringArray);
    }

    @Override
    public void dmFlagDestinationRemove() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmFlagDestinationRemove()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmFlagDestinationRemove();
    }

    @Override
    public void dmFlagDestinationSet(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmFlagDestinationSet( NavLocation location )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmFlagDestinationSet(navLocation);
    }

    @Override
    public void dmFlagDestinationSetName(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmFlagDestinationSetName( String name )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmFlagDestinationSetName(string);
    }

    @Override
    public void dmLastDestinationsAddList(NavLastDest[] navLastDestArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmLastDestinationsAddList( NavLastDest[] lastDestList )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmLastDestinationsAddList(navLastDestArray);
    }

    @Override
    public void dmLastDestinationsDelete(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmLastDestinationsDelete( long destID )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmLastDestinationsDelete(l);
    }

    @Override
    public void dmLastDestinationsDeleteAll() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmLastDestinationsDeleteAll()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmLastDestinationsDeleteAll();
    }

    @Override
    public void dmLastDestinationsGet(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmLastDestinationsGet( long idestID )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmLastDestinationsGet(l);
    }

    @Override
    public void dmLastDestinationsReplace(long l, NavLocation navLocation, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmLastDestinationsReplace( long destID, NavLocation destination, String title )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmLastDestinationsReplace(l, navLocation, string);
    }

    @Override
    public void dmRecentRoutesAdd(Route route, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmRecentRoutesAdd( Route route, String title )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmRecentRoutesAdd(route, string);
    }

    @Override
    public void dmRecentRoutesDelete(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmRecentRoutesDelete( long routeID )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmRecentRoutesDelete(l);
    }

    @Override
    public void dmRecentRoutesDeleteAll() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmRecentRoutesDeleteAll()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmRecentRoutesDeleteAll();
    }

    @Override
    public void dmRecentRoutesGet(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmRecentRoutesGet( long routeID )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmRecentRoutesGet(l);
    }

    @Override
    public void dmRecentRoutesReplace(long l, Route route, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("dmRecentRoutesReplace( long routeID, Route route, String title )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.dmRecentRoutesReplace(l, route, string);
    }

    @Override
    public void ehGetAllBrandsOfCategory(int n, int n2) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("ehGetAllBrandsOfCategory( int mapStyleType, int categoryUid )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.ehGetAllBrandsOfCategory(n, n2);
    }

    @Override
    public void ehGetAllCategories(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("ehGetAllCategories( int mapStyleType )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.ehGetAllCategories(n);
    }

    @Override
    public void ehSetBrandPreference(int n, int[] nArray, boolean[] blArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("ehSetBrandPreference( int mapStyleType, int[] brandUid, boolean[] preference )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.ehSetBrandPreference(n, nArray, blArray);
    }

    @Override
    public void ehSetBrandVisibility(int n, int[] nArray, boolean[] blArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("ehSetBrandVisibility( int mapStyleType, int[] brandUid, boolean[] visibility )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.ehSetBrandVisibility(n, nArray, blArray);
    }

    @Override
    public void ehSetCategoryAudioWarning(int n, int[] nArray, boolean[] blArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("ehSetCategoryAudioWarning( int mapStyleType, int[] categoryUid, boolean[] audible )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.ehSetCategoryAudioWarning(n, nArray, blArray);
    }

    @Override
    public void ehSetCategoryMonitoring(int[] nArray, boolean[] blArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("ehSetCategoryMonitoring( int[] categoryUid, boolean[] monitor )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.ehSetCategoryMonitoring(nArray, blArray);
    }

    @Override
    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("ehSetCategoryVisibility( int mapStyleType, int[] categoryUid, boolean[] visibility )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.ehSetCategoryVisibility(n, nArray, blArray);
    }

    @Override
    public void ehSetCategoryVisibilityToDefault(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("ehSetCategoryVisibilityToDefault( int mapStyleType )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.ehSetCategoryVisibilityToDefault(n);
    }

    @Override
    public void enableRgLaneGuidance(boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("enableRgLaneGuidance( boolean enabled )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.enableRgLaneGuidance(bl);
    }

    @Override
    public void enableRgMotorwayInfo(boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("enableRgMotorwayInfo( boolean enable )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setVirtualRouteGuidance(bl);
    }

    @Override
    public void enableRgPoiInfo(boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("enableRgPoiInfo( boolean enabled )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.enableRgPoiInfo(bl);
    }

    @Override
    public void enableRgStreetLists(boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("enableRgStreetLists( boolean enabled )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.enableRgStreetLists(bl);
    }

    @Override
    public void etcGetCountryAbbreviation(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("etcGetCountryAbbreviation( String country )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.etcGetCountryAbbreviation(string);
    }

    @Override
    public void etcGetPositionTimeInfo(NavLocationWgs84 navLocationWgs84) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("etcGetPositionTimeInfo( NavLocationWgs84 position )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.etcGetPositionTimeInfo(navLocationWgs84);
    }

    @Override
    public void etcSelectDatabase(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("etcSelectDatabase( int index )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.etcSelectDatabase(n);
    }

    @Override
    public void etcSelectNavDataBase(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("etcSelectNavDataBase( int uid )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.etcSelectNavDataBase(n);
    }

    @Override
    public void etcSetDemoMode(boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("etcSetDemoMode( boolean enable )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.etcSetDemoMode(bl);
    }

    @Override
    public void etcSetDemoModeSpeed(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("etcSetDemoModeSpeed( long speed )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.etcSetDemoModeSpeed(l);
    }

    @Override
    public void etcSetMetricSystem(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("etcSetMetricSystem( int metricSystem )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.etcSetMetricSystem(n);
    }

    @Override
    public void etcTriggerNavigationRestart(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("etcTriggerNavigationRestart( int reason )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.etcTriggerNavigationRestart(n);
    }

    @Override
    public void importFile(String string, int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("importFile( String file, int userID )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.importFile(string, n);
    }

    @Override
    public void importRouteFromGpxFile(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("importRouteFromGpxFile( String fileName )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.importRouteFromGpxFile(string);
    }

    @Override
    public void jumpToNextManeuver() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("jumpToNextManeuver()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.jumpToNextManeuver();
    }

    @Override
    public void languageSpellableCharacters(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("languageSpellableCharacters( String countryAbbreviation )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.languageSpellableCharacters(string);
    }

    @Override
    public void liDeleteHistory() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liDeleteHistory()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liDeleteHistory();
    }

    @Override
    public void liDisambiguateLocation(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liDisambiguateLocation( NavLocation location )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liDisambiguateLocation(navLocation);
    }

    @Override
    public void liGetCurrentState() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liGetCurrentState()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liGetCurrentState();
    }

    @Override
    public void liGetLastCityHistoryEntry(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liGetLastCityHistoryEntry( long id )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liGetLastCityHistoryEntry(l);
    }

    @Override
    public void liGetLastStateHistoryEntry(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liGetLastStateHistoryEntry( long id )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liGetLastStateHistoryEntry(l);
    }

    @Override
    public void liGetLastStreetHistoryEntry(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liGetLastStreetHistoryEntry( long id )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liGetLastStreetHistoryEntry(l);
    }

    @Override
    public void liGetLocationDescriptionTransform(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liGetLocationDescriptionTransform( NavLocation location )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liGetLocationDescriptionTransform(navLocation);
    }

    @Override
    public void liGetLocationDescriptionTransformNearBy(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liGetLocationDescriptionTransformNearBy( NavLocation location )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liGetLocationDescriptionTransformNearBy(navLocation);
    }

    @Override
    public void liGetSpellableCharacters(NavLocation navLocation, int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liGetSpellableCharacters( NavLocation navLocation, int selectionCriterion )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liGetSpellableCharacters(navLocation, n);
    }

    @Override
    public void liGetState() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liGetState()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liGetState();
    }

    @Override
    public void liGetViaPointCountryList() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liGetViaPointCountryList()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liGetViaPointCountryList();
    }

    @Override
    public void liGetViaPointList(int n, int n2, int n3, int n4) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liGetViaPointList( int windowSize, int offset, int anchorId, int openedListAnchorId )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liGetViaPointList(n, n2, n3, n4);
    }

    @Override
    public void liHistoryAddLocation(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liHistoryAddLocation( NavLocation location )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liHistoryAddLocation(navLocation);
    }

    @Override
    public void liLastCityHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastCityHistoryAdd( NavLocation city, boolean hasStreets, String nameofEntry )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastCityHistoryAdd(navLocation, bl, string);
    }

    @Override
    public void liLastCityHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastCityHistoryAddExtended( NavLocation city, boolean hasStreets, String nameofEntry, LIExtData[] extendedData )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastCityHistoryAddExtended(navLocation, bl, string, lIExtDataArray);
    }

    @Override
    public void liLastCityHistoryDelete(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastCityHistoryDelete( long id )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastCityHistoryDelete(l);
    }

    @Override
    public void liLastCityHistoryDeleteAll() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastCityHistoryDeleteAll()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastCityHistoryDeleteAll();
    }

    @Override
    public void liLastCityHistorySetStreet(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastCityHistorySetStreet( NavLocation street ").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastCityHistorySetStreet(navLocation);
    }

    @Override
    public void liLastStateHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastStateHistoryAdd( NavLocation state, boolean hasCities, String nameofEntry )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastStateHistoryAdd(navLocation, bl, string);
    }

    @Override
    public void liLastStateHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastStateHistoryAddExtended( NavLocation state, boolean hasCities, String nameofEntry, LIExtData[] extendedData )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastStateHistoryAddExtended(navLocation, bl, string, lIExtDataArray);
    }

    @Override
    public void liLastStateHistoryDelete(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastStateHistoryDelete( long id )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastStateHistoryDelete(l);
    }

    @Override
    public void liLastStateHistoryDeleteAll() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastStateHistoryDeleteAll()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastStateHistoryDeleteAll();
    }

    @Override
    public void liLastStreetHistoryAdd(NavLocation navLocation, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastStreetHistoryAdd( NavLocation street, String nameOfEntry )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastStreetHistoryAdd(navLocation, string);
    }

    @Override
    public void liLastStreetHistoryAddExtended(NavLocation navLocation, String string, LIExtData[] lIExtDataArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastStreetHistoryAddExtended( NavLocation street, String nameofEntry, LIExtData[] extendedData )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastStreetHistoryAddExtended(navLocation, string, lIExtDataArray);
    }

    @Override
    public void liLastStreetHistoryDelete(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastStreetHistoryDelete( long id )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastStreetHistoryDelete(l);
    }

    @Override
    public void liLastStreetHistoryDeleteAll() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastStreetHistoryDeleteAll()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastStreetHistoryDeleteAll();
    }

    @Override
    public void liLastStreetHistorySetCity(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liLastStreetHistorySetCity( NavLocation city )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liLastStreetHistorySetCity(navLocation);
    }

    @Override
    public void liRestoreState(LISpellerData lISpellerData) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liRestoreState( LISpellerData spellerState )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liRestoreState(lISpellerData);
    }

    @Override
    public void liSelectViaPoint(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liSelectViaPoint( int viaPointId )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liSelectViaPoint(n);
    }

    @Override
    public void liSetCountryForCityAndStreetHistory(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liSetCountryForCityAndStreetHistory( String countryAbbreviation )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liSetCountryForCityAndStreetHistory(string);
    }

    @Override
    public void liSetCurrentLD(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liSetCurrentLD( NavLocation locDescID )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liSetCurrentLD(navLocation);
    }

    @Override
    public void liSetHistory(String string, String string2) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liSetHistory( String countryAbbreviation, String stateAbbreviation )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liSetHistory(string, string2);
    }

    @Override
    public void liSetNVCRange(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liSetNVCRange( int nvcRange )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liSetNVCRange(n);
    }

    @Override
    public void liSetStreetForCityHistory(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liSetStreetForCityHistory( String street )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liSetStreetForCityHistory(string);
    }

    @Override
    public void liSetViaPointCountry(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liSetViaPointCountry( String countryAbbreviation )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liSetViaPointCountry(string);
    }

    @Override
    public void lispAddCharacter(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispAddCharacter( String inputChar )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispAddCharacter(string);
    }

    @Override
    public void lispAddStroke(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispAddStroke( String stroke )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispAddStroke(string);
    }

    @Override
    public void lispCancelSpeller() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispCancelSpeller()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispCancelSpeller();
    }

    @Override
    public void lispDeleteAllCharacters() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispDeleteAllCharacters()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispDeleteAllCharacters();
    }

    @Override
    public void lispGetLocationFromLiValueListElement(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispGetLocationFromLiValueListElement( int listIndex )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispGetLocationFromLiValueListElement(n);
    }

    @Override
    public void lispGetMatchingNVC(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispGetMatchingNVC( String guessNVC )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispGetMatchingNVC(string);
    }

    @Override
    public void lispRequestNVCList(int n, int n2, int n3) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispRequestNVCList( int nvcRange, int offset, int windowSize )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispRequestNVCList(n, n2, n3);
    }

    @Override
    public void lispRequestValueListByListIndex(int n, boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispRequestValueListByListIndex( int anchorIndex, boolean nextPage )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispRequestValueListByListIndex(n, bl);
    }

    @Override
    public void lispSelectByCategoryUid(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispSelectByCategoryUid( int categoryUid )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispSelectByCategoryUid(n);
    }

    @Override
    public void lispSelectByMultipleCategoryUids(int[] nArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispSelectByMultipleCategoryUids( int[] categoryUids )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispSelectByMultipleCategoryUids(nArray);
    }

    @Override
    public void lispSelectItemFromLocation(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispSelectItemFromLocation( NavLocation historyLocation )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispSelectItemFromLocation(navLocation);
    }

    @Override
    public void lispSelectListItem(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispSelectListItem( int index )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispSelectListItem(n);
    }

    @Override
    public void lispSelectListItemByIdent(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispSelectListItemByIdent( String ident )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispSelectListItemByIdent(string);
    }

    @Override
    public void lispSetInput(String string, boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispSetInput( String input, boolean autoSelectInput )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispSetInput(string, bl);
    }

    @Override
    public void lispUndoCharacter() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("lispUndoCharacter()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.lispUndoCharacter();
    }

    @Override
    public void liStartMultiCriteriaSpeller(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liStartMultiCriteriaSpeller( int criterion1, int criterion2, boolean removeZipCode, boolean removeTown, boolean removeStreet )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liStartMultiCriteriaSpeller(n, n2, bl, bl2, bl3);
    }

    @Override
    public void liStartSpeller(int n, boolean bl, boolean bl2, boolean bl3) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liStartSpeller( int selectionCriterion, boolean removeZipCode, boolean removeTown, boolean removeStreet )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liStartSpeller(n, bl, bl2, bl3);
    }

    @Override
    public void liStopSpeller() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liStopSpeller()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liStopSpeller();
    }

    @Override
    public void liStripLocation(NavLocation navLocation, int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liStripLocation( NavLocation location, int type )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liStripLocation(navLocation, n);
    }

    @Override
    public void liThesaurusHistoryAdd(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liThesaurusHistoryAdd( String wordToAdd )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liThesaurusHistoryAdd(string);
    }

    @Override
    public void liThesaurusHistoryDelete(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liThesaurusHistoryDelete( int uid )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liThesaurusHistoryDelete(n);
    }

    @Override
    public void liThesaurusHistoryDeleteAll() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liThesaurusHistoryDeleteAll()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liThesaurusHistoryDeleteAll();
    }

    @Override
    public void liThesaurusHistoryGetEntry(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liThesaurusHistoryGetEntry( int uid )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liThesaurusHistoryGetEntry(n);
    }

    @Override
    public void liTryBestMatch(TryBestMatchData tryBestMatchData) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liTryBestMatch( TryBestMatchData tbmData )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liTryBestMatch(tryBestMatchData);
    }

    @Override
    public void liTryMatchLocation(TryMatchLocationData tryMatchLocationData) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liTryMatchLocation( TryMatchLocationData tmLocation )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liTryMatchLocation(tryMatchLocationData);
    }

    @Override
    public void liValueListFilename(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liValueListFilename( String liValueListFilename )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liValueListFilename(string);
    }

    @Override
    public void liValueListMaximumLength(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liValueListMaximumLength( int maximumLength )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liValueListMaximumLength(n);
    }

    @Override
    public void liValueListOutputMethod(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liValueListOutputMethod( int liValueListOutputMethod )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liValueListOutputMethod(n);
    }

    @Override
    public void liValueListWindowSize(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("liValueListWindowSize( int windowSize )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.liValueListWindowSize(n);
    }

    @Override
    public void locationToStream(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("locationToStream( NavLocation navLocation )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.locationToStream(navLocation);
    }

    @Override
    public void poiConfigureContext(String string, int n, NavLocation navLocation, int[] nArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("poiConfigureContext( String initialSearchString, int poiSearchMode, NavLocation poiLocation, int[] categoryUIds )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.poiConfigureContext(string, n, navLocation, nArray);
    }

    @Override
    public void poiGetCategoryTypesFromUId(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("poiGetCategoryTypesFromUId( int categoryUId )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.poiGetCategoryTypesFromUId(n);
    }

    @Override
    public void poiGetXt9LDBs(NavLocation navLocation, int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("poiGetXt9LDBs( NavLocation position, int mode )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.poiGetXt9LDBs(navLocation, n);
    }

    @Override
    public void poiRequestExtendedInfo(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("poiRequestExtendedInfo( NavLocation poi )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.poiRequestExtendedInfo(navLocation);
    }

    @Override
    public void poiSelectSelectionCriteria(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("poiSelectSelectionCriteria( long index )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.poiSelectSelectionCriteria(l);
    }

    @Override
    public void poiSetContext(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("poiSetContext( NavLocation poiLocation )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.poiSetContext(navLocation);
    }

    @Override
    public void poiSetListStyle(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("poiSetListStyle( int style )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.poiSetListStyle(n);
    }

    @Override
    public void poiSetSortOrder2(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("poiSetSortOrder2( int poiSortOrder )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.poiSetSortOrder2(n);
    }

    @Override
    public void poiStartSpellerAlongRoute(int n, long l, long l2) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("poiStartSpellerAlongRoute( int selectionCriterion, long corridor, long length )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.poiStartSpellerAlongRoute(n, l, l2);
    }

    @Override
    public void poiStartSpellerAlongRouteAdvanced(int n, long l, long l2, long l3, boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("poiStartSpellerAlongRouteAdvanced( int selectionCriterion, long corridor, long length, long offset, boolean reverse )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.poiStartSpellerAlongRouteAdvanced(n, l, l2, l3, bl);
    }

    @Override
    public void requestAudioTrigger(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("requestAudioTrigger( int audioMode )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.requestAudioTrigger(n);
    }

    @Override
    public void requestCountryInfo(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("requestCountryInfo( String countryAbbreviation )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.requestCountryInfo(string);
    }

    @Override
    public void requestSoPosPositionDescriptionVehicle() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("requestSoPosPositionDescriptionVehicle()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.requestSoPosPositionDescriptionVehicle();
    }

    @Override
    public void rgCalculate1stRouteAndPostponeRemaining(Route route, int n, boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgCalculate1stRouteAndPostponeRemaining( Route route, int numOfRoutes, boolean resumeRoute )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgCalculate1stRouteAndPostponeRemaining(route, n, bl);
    }

    @Override
    public void rgCalculateRoute(Route route, int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgCalculateRoute( Route route, int numOfAlternatives )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgCalculateRoute(route, n);
    }

    @Override
    public void rgConfigurePoiInfo(NavPoiInfoConfiguration navPoiInfoConfiguration) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgConfigurePoiInfo( NavPoiInfoConfiguration config )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgConfigurePoiInfo(navPoiInfoConfiguration);
    }

    @Override
    public void rgDeleteCalculatedRubberbandPoint() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgDeleteCalculatedRubberbandPoint()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgDeleteCalculatedRubberbandPoint();
    }

    @Override
    public void rgDeletePersistedRouteData() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgDeletePersistedRouteData()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgDeletePersistedRouteData();
    }

    @Override
    public void rgEnableEnhancedSignPostInfo(boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgEnableEnhancedSignPostInfo( boolean enable )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgEnableEnhancedSignPostInfo(bl);
    }

    @Override
    public void rgGetLocationOnRoute(long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgGetLocationOnRoute( long distance )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgGetLocationOnRoute(l);
    }

    @Override
    public void rgGetRouteBoundingRectangle(boolean bl, int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgGetRouteBoundingRectangle( boolean completeTour, int destinationIndex )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgGetRouteBoundingRectangle(bl, n);
    }

    @Override
    public void rgGetRubberBandPointPosition() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgGetRubberBandPointPosition()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgGetRubberBandPointPosition();
    }

    @Override
    public void rgPrepareRubberbandManipulation(boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgPrepareRubberbandManipulation( boolean stopGuidance )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgPrepareRubberbandManipulation(bl);
    }

    @Override
    public void rgReverseTrailDirection() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgReverseTrailDirection()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgReverseTrailDirection();
    }

    @Override
    public void rgSetPosition(NavLocation navLocation) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgSetPosition( NavLocation position )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgSetPosition(navLocation);
    }

    @Override
    public void rgSetRouteGuidanceMode(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgSetRouteGuidanceMode( int guidanceMode )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgSetRouteGuidanceMode(n);
    }

    @Override
    public void rgSetRouteOptions(RouteOptions routeOptions) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgSetRouteOptions( RouteOptions routeOptions )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgSetRouteOptions(routeOptions);
    }

    @Override
    public void rgSetRubberbandPosition(NavLocationWgs84 navLocationWgs84) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgSetRubberbandPosition( NavLocationWgs84 position )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgSetRubberbandPosition(navLocationWgs84);
    }

    @Override
    public void rgSetTurnListMode(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgSetTurnListMode( int mode )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgSetTurnListMode(n);
    }

    @Override
    public void rgSkipNextWayPoints(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgSkipNextWayPoints( int numberOfWaypointsToSkip )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgSkipNextWayPoints(n);
    }

    @Override
    public void rgStartGuidanceCalculatedRoute(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgStartGuidanceCalculatedRoute( int routeHandle )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgStartGuidanceCalculatedRoute(n);
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgStartGuidanceCalculatedRouteByUID( NavSegmentID uidOfCalculatedRoute )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgStartGuidanceCalculatedRouteByUID(navSegmentID);
    }

    @Override
    public void rgStartRubberbandManipulation(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgStartRubberbandManipulation( int routeSectionIndex )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgStartRubberbandManipulation(n);
    }

    @Override
    public void rgStopGuidance() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgStopGuidance()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgStopGuidance();
    }

    @Override
    public void rgStopRouteCalculation() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgStopRouteCalculation()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgStopRouteCalculation();
    }

    @Override
    public void rgStopRubberbandManipulation() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgStopRubberbandManipulation()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgStopRubberbandManipulation();
    }

    @Override
    public void rgSwitchToNextPossibleRoad() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgSwitchToNextPossibleRoad()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgSwitchToNextPossibleRoad();
    }

    @Override
    public void rgTriggerRCCIUpdate() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rgTriggerRCCIUpdate()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rgTriggerRCCIUpdate();
    }

    @Override
    public void rmAbortImportToursFromGpxFile() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rmAbortImportToursFromGpxFile()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rmAbortImportToursFromGpxFile();
    }

    @Override
    public void rmImportToursFromGpxFile(int n, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rmImportToursFromGpxFile(int rmID, String fileName)").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rmImportToursFromGpxFile(n, string);
    }

    @Override
    public void rmMakeRoutePersistent(Route route) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rmMakeRoutePersistent( Route route )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rmMakeRoutePersistent(route);
    }

    @Override
    public void rmRouteAdd(int n, Route route, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rmRouteAdd( int rmID, Route route, String name )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rmRouteAdd(n, route, string);
    }

    @Override
    public void rmRouteDelete(int n, long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rmRouteDelete( int rmID, long routeId )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rmRouteDelete(n, l);
    }

    @Override
    public void rmRouteDeleteAll(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rmRouteDeleteAll( int rmID )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rmRouteDeleteAll(n);
    }

    @Override
    public void rmRouteGet(int n, long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rmRouteGet( int rmID, long routeId )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rmRouteGet(n, l);
    }

    @Override
    public void rmRouteRename(int n, long l, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rmRouteRename( int rmID, long routeID, String name )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rmRouteRename(n, l, string);
    }

    @Override
    public void rmRouteReplace(int n, long l, Route route) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rmRouteReplace( int rmID, long routeID, Route route )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rmRouteReplace(n, l, route);
    }

    @Override
    public void rrdStartCalculationByListIndex(int n, long l) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rrdStartCalculationByListIndex( int anchorIndex, long numberToCalc )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rrdStartCalculationByListIndex(n, l);
    }

    @Override
    public void rrdStartCalculationForPosition(NavLocationWgs84[] navLocationWgs84Array) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rrdStartCalculationForPosition( NavLocationWgs84[] navLocations )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rrdStartCalculationForPosition(navLocationWgs84Array);
    }

    @Override
    public void rrdStopCalculation() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("rrdStopCalculation()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.rrdStopCalculation();
    }

    public void setDsiNavigation(DSINavigation dSINavigation) {
        this.dsiNavigation = dSINavigation;
    }

    public void setFacadeEnabled(boolean bl) {
        if (!bl) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setFacadeEnabled( boolean facadeEnabled )").append("' will be ignored").log();
            return;
        }
        this.facadeEnabled = bl;
    }

    @Override
    public void setLanguage(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setLanguage( String navLanguage )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setLanguage(string);
    }

    @Override
    public void setNavInternalDataToFactorySettings() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setNavInternalDataToFactorySettings()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setNavInternalDataToFactorySettings();
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setNotification( DSIListener listener )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setNotification(dSIListener);
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setNotification( int attribute, DSIListener listener )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setNotification(n, dSIListener);
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setNotification( int[] attributes, DSIListener listener )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setNotification(nArray, dSIListener);
    }

    @Override
    public void setPathsToPersonalPOIDataBases(String[] stringArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setPathsToPersonalPOIDataBases( String[] paths )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setPathsToPersonalPOIDataBases(stringArray);
    }

    @Override
    public void setRemainingRangeOfVehicle(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setRemainingRangeOfVehicle( int remainingRange )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setRemainingRangeOfVehicle(n);
    }

    @Override
    public void setTrailerStatus(boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setTrailerStatus( boolean trailerAttached )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setTrailerStatus(bl);
    }

    @Override
    public void setUserDefinedPOIs(NavLocation[] navLocationArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setUserDefinedPOIs( NavLocation[] userDefinedPOIs )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setUserDefinedPOIs(navLocationArray);
    }

    @Override
    public void setVehicleFuelType(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("setVehicleFuelType( int vehicleFuelType )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.setVehicleFuelType(n);
    }

    @Override
    public void streamToLocation(byte[] byArray) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("streamToLocation( byte[] streamLocation )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.streamToLocation(byArray);
    }

    @Override
    public void translateRoute(Route route) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("translateRoute( Route navRouteList )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.translateRoute(route);
    }

    @Override
    public void trCreateWaypoint() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("trCreateWaypoint()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.trCreateWaypoint();
    }

    @Override
    public void trDeleteAllTraces() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("trDeleteAllTraces()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.trDeleteAllTraces();
    }

    @Override
    public void trDeleteTrace(NavSegmentID navSegmentID) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("trDeleteTrace( NavSegmentID traceId )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.trDeleteTrace(navSegmentID);
    }

    @Override
    public void trExportTrails(NavSegmentID[] navSegmentIDArray, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("trExportTrails( NavSegmentID[] traceIDs, String fileName )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.trExportTrails(navSegmentIDArray, string);
    }

    @Override
    public void triggerEventAudioMessage(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("triggerEventAudioMessage( int soundID )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.triggerEventAudioMessage(n);
    }

    @Override
    public void trImportTrails(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("trImportTrails( String fileName )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.trImportTrails(string);
    }

    @Override
    public void trRenameTrace(NavSegmentID navSegmentID, String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("trRenameTrace( NavSegmentID traceId, String name )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.trRenameTrace(navSegmentID, string);
    }

    @Override
    public void trStartTraceRecording(int n) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("trStartTraceRecording( int recordingMode )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.trStartTraceRecording(n);
    }

    @Override
    public void trStopTraceRecording() {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("trStopTraceRecording()").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.trStopTraceRecording();
    }

    @Override
    public void trStoreTrace(String string) {
        if (!this.facadeEnabled) {
            this.logger.makeWarn().append("The facade is disabled, the call '").append("trStoreTrace( String name )").append("' will be ignored").log();
            return;
        }
        this.dsiNavigation.trStoreTrace(string);
    }

    @Override
    public void trClearRecordedTraceCache() {
    }

    @Override
    public void profileChange(int n) {
    }

    @Override
    public void profileCopy(int n, int n2) {
    }

    @Override
    public void profileReset(int n) {
    }

    @Override
    public void profileResetAll() {
    }

    @Override
    public void setVirtualRouteGuidance(boolean bl) {
    }
}

