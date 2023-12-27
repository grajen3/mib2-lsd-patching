/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.poi;

import de.vw.mib.asl.api.navigation.IASLNavigationInternalServiceFirst;
import de.vw.mib.asl.api.navigation.poi.IPersistedPoiSetup;
import de.vw.mib.asl.api.navigation.poi.IPoiOnboardSearchResultListener;
import de.vw.mib.asl.api.navigation.poi.IPoiOnlineSearchResultListener;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener;
import org.dsi.ifc.navigation.LIValueListElement;

public interface ASLNavigationPoiAPI
extends IASLNavigationInternalServiceFirst {
    public static final int EV_POI_ONLINE_SDS_START_ONLINE_POI_VOICE_SEARCH;
    public static final int EV_POI_ONLINE_SDS_GET_VALUE_LIST_BLOCK;
    public static final int EV_POI_ONLINE_SDS_LIST_BLOCK_INDEX_INPUT_P0;
    public static final int EV_POI_ONLINE_SDS_LIST_BLOCK_COUNT_INPUT_P1;
    public static final int EV_POI_ONLINE_SDS_STOP_ONLINE_POI_VOICE_SEARCH;
    public static final int EV_POI_ONLINE_SDS_RESOLVE_ENTRY;
    public static final int EV_POI_ONLINE_SDS_RESOLVE_ENTRY_INPUT_P0;
    public static final int EV_POI_ONBOARD_VALUELIST_BLOCK;
    public static final int EV_POI_ONBOARD_VALUELIST_BLOCK_OFFSET_P0;
    public static final int EV_POI_ONBOARD_VALUELIST_BLOCK_COUNT_P1;
    public static final int EV_POI_ONBOARD_RESOLVE_ENTRY;
    public static final int EV_POI_ONBOARD_RESOLVE_ENTRY_INDEX_P0;
    public static final int EV_POI_ONBOARD_SEARCH_CATEGORY;
    public static final int EV_POI_ONBOARD_SEARCH_CATEGORY_UID_P0;
    public static final int EV_POI_ONBOARD_SEARCH_CATEGORY_SEARCH_AREA_P1;
    public static final int EV_POI_ONLINE_DYNPOI_PRECHECK;
    public static final int EV_POI_ONLINE_DYNPOI_PRECHECK_P0_ID;
    public static final int EV_POI_ONLINE_DYNPOI_PRECHECK_P1_LISTENER;

    default public IPersistedPoiSetup getPoiSetup() {
    }

    default public void reloadTopPois(int n) {
    }

    default public boolean isValidOnlinePoiCategory(int n) {
    }

    default public void registerPoiOnboardSearchResultListener(IPoiOnboardSearchResultListener iPoiOnboardSearchResultListener) {
    }

    default public void unregisterPoiOnboardSearchResultListener(IPoiOnboardSearchResultListener iPoiOnboardSearchResultListener) {
    }

    default public void registerPoiOnlineSearchResultListener(IPoiOnlineSearchResultListener iPoiOnlineSearchResultListener) {
    }

    default public void unregisterPoiOnlineSearchResultListener(IPoiOnlineSearchResultListener iPoiOnlineSearchResultListener) {
    }

    default public boolean isOnlinePoiReady() {
    }

    default public String getSelectedOnlinePoiUrl() {
    }

    default public void startVoiceOnlinePoiSearch() {
    }

    default public void getValueListBlock(int n, int n2) {
    }

    default public void stopOnlinePoiSearch() {
    }

    default public void resolveOnlineEntry(IOnlinePoiListElement iOnlinePoiListElement) {
    }

    default public void startOnboardPoiSearch(long l, int n) {
    }

    default public void getOnboardValueListBlock(int n, int n2) {
    }

    default public void selectOnboardEntry(int n) {
    }

    default public long[] getTopPoiCategoryUids() {
    }

    default public int calculateOnboardDirectionIndex(LIValueListElement lIValueListElement) {
    }

    default public int calculateOnboardDistance(LIValueListElement lIValueListElement) {
    }

    default public void updateSearchLocation() {
    }

    default public void dynPoi2Service(int n, NavigationOnlinePoiListener navigationOnlinePoiListener) {
    }

    default public void initXt9Finished() {
    }

    default public void initXt9OnboardFinished() {
    }

    default public String getLastServiceIdString() {
    }

    default public void setLastServiceIdString(String string) {
    }
}

