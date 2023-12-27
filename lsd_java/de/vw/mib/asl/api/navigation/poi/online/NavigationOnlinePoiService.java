/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.poi.online;

import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;

public interface NavigationOnlinePoiService {
    public static final int ONLINE_POI_SEARCH_RESULTSOURCE_POI;
    public static final int ONLINE_POI_SEARCH_RESULTSOURCE_SDS;
    public static final int ONLINE_POI_SEARCH_STATUS_OK_INIT;
    public static final int ONLINE_POI_SEARCH_STATUS_OK_CANCELED;
    public static final int ONLINE_POI_SEARCH_STATUS_OK_COMPLETE;
    public static final int ONLINE_POI_SEARCH_STATUS_ERROR_VOICE_RECOGNITION_FAILED;
    public static final int ONLINE_POI_SEARCH_STATUS_ERROR_VOICE_RECOGNIZED_NO_RESULTS;
    public static final int ONLINE_POI_SEARCH_STATUS_ERROR_VOICE_NOT_RECOGNIZED;
    public static final int ONLINE_POI_SEARCH_STATUS_ERROR_VOICE_LANGUAGE_NOT_SUPPORTED;
    public static final int ONLINE_POI_SEARCH_STATUS_ERROR_POISTS_PARSE;

    default public void lockInput() {
    }

    default public void weakLockInput() {
    }

    default public void unlockInput() {
    }

    default public void freeService() {
    }

    default public void startVoicePoiSearch() {
    }

    default public void getValueListBlock(int n, int n2) {
    }

    default public void stopPoiSearch() {
    }

    default public void resolveEntry(IOnlinePoiListElement iOnlinePoiListElement) {
    }

    default public void dynPoi2Service(int n) {
    }

    default public boolean isServiceReady() {
    }
}

