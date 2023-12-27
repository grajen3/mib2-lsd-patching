/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListener;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListener;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.api.navigation.map.NavigationMapListener;
import de.vw.mib.asl.api.navigation.map.NavigationMapService;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapListener;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapService;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListener;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryService;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiListener;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiService;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiService;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListener;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficListener;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficService;

public interface ASLNavigationAPI {
    public static final String EXIF_TAG_GPS_LONGITUDE_REF_WEST_INDICATOR;
    public static final String EXIF_TAG_GPS_LONGITUDE_REF_EAST_INDICATOR;
    public static final String EXIF_TAG_GPS_LATITUDE_REF_NORTH_INDICATOR;
    public static final String EXIF_TAG_GPS_LATITUDE_REF_SOUTH_INDICATOR;
    public static final int EV_RECEIVE_FILEBROWSER_SESSION_START_RESULT;
    public static final int EV_FILEBROWSER_SET_CONTENTFILTER_RESULT;
    public static final int EV_FILEBROWSER_UPDATE_LIST_SIZE;
    public static final int EV_FILEBROWSER_RECEIVE_ENTRIES;
    public static final int EV_FILEBROWSER_RECEIVE_RESOURCE_LOCATORS;
    public static final int EV_FILEBROWSER_SET_DIRECTORY_ABSOLUTE;
    public static final int EV_FILEBROWSER_DIRECTORY_CHANGED;
    public static final int EV_HANDLE_FILEBROWSER_START_SESSION_WITH_PARAMETERS_RESULT;
    public static final int EV_FILEBROWSER_GET_ENTRIES_RESULT;
    public static final int EV_HANDLE_FILEBROWSER_RESOLVE_RESOURCE_LOCATOR_NAVIGATION;
    public static final int EV_HANDLE_FILEBROWSER_RESOLVE_RESOURCE_LOCATORS_IMPORT;
    public static final int EV_FILEBROWSER_DIRECTORY_CHANGED_P0_PATH;
    public static final int EV_FILEBROWSER_DIRECTORY_CHANGED_P1_SESSIONHANDLE;
    public static final int EV_ASL_INT_SOUND_OFF;
    public static final int EV_ASL_INT_SOUND_ON;
    public static final int EV_ASL_INT_SOUND_SET_CONNECTION_RESULT;
    public static final int GEO_INDEX_DEGREES;
    public static final int GEO_INDEX_MINUTES;
    public static final int GEO_INDEX_SECONDS;

    default public int degMinSecToDsi(double[] dArray) {
    }

    default public int degMinSecToDsi(double[] dArray, boolean bl) {
    }

    default public double dsiToDecimal(int n) {
    }

    default public int decimalToDsi(double d2) {
    }

    default public double[] dsiToDegMinSec(int n) {
    }

    default public ASLNavigationServices getASLNavigationServices(ASLNavigationServicesListener aSLNavigationServicesListener) {
    }

    default public INavigationPosPosition getPositionInfo() {
    }

    default public boolean isGatwayInstance() {
    }

    default public void setNavSpeechCapabilities(boolean bl, boolean bl2, boolean bl3) {
    }

    default public void updateBapCompassInfo(int n, int n2) {
    }

    default public void updateBapDistanceToDestination(int n, int n2) {
    }

    default public void updateBapDistanceToNextManeuver(int n, int n2, boolean bl, int n3) {
    }

    default public void updateBapTimeToDestination(int n, int n2, long l) {
    }

    default public void updateBapTurnToInfo(String string, String string2) {
    }

    default public int getNavigationServiceState() {
    }

    default public String dynPoi2Service(int n) {
    }

    default public void registerNavServiceStateListener(INavServiceStateListener iNavServiceStateListener) {
    }

    default public void unregisterNavServiceStateListener(INavServiceStateListener iNavServiceStateListener) {
    }

    default public NavigationGuidanceService getNavigationGuidanceService(NavigationGuidanceListener navigationGuidanceListener) {
    }

    default public NavigationMemoryService getNavigationMemoryService(NavigationMemoryListener navigationMemoryListener) {
    }

    default public NavigationLocationinputService getNavigationLocationinputService(NavigationLocationinputListener navigationLocationinputListener) {
    }

    default public NavigationMapService getNavigationMapService(NavigationMapListener navigationMapListener) {
    }

    default public NavigationTrafficService getNavigationTrafficService(NavigationTrafficListener navigationTrafficListener) {
    }

    default public NavigationOnlinePoiService getNavigationOnlinePoiService(NavigationOnlinePoiListener navigationOnlinePoiListener) {
    }

    default public NavigationOnboardPoiService getNavigationOnboardPoiService(NavigationOnboardPoiListener navigationOnboardPoiListener) {
    }

    default public INavigationLocation createNavigationLocation(double d2, double d3) {
    }

    default public ICMapService getICMapService(ICMapListener iCMapListener) {
    }

    default public NavigationSplitscreenService getNavigationSplitscreenService(NavigationSplitscreenListener navigationSplitscreenListener) {
    }
}

