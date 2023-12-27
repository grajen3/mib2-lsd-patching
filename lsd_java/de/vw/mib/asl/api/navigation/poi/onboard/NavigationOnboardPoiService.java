/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;

public interface NavigationOnboardPoiService {
    public static final int ONBOARD_POI_SEARCH_STATUS_CANCELED;
    public static final int ONBOARD_POI_SEARCH_STATUS_FINISHED;
    public static final int ONBOARD_POI_SEARCH_STATUS_INVALID;
    public static final int ONBOARD_POI_SEARCH_STATUS_RUNNING;
    public static final int ONBOARD_POI_SEARCH_CRITERIA_AROUND_POSITION;
    public static final int ONBOARD_POI_SEARCH_CRITERIA_AROUND_DESTINATION;
    public static final int ONBOARD_POI_SEARCH_CRITERIA_AROUND_STOPOVER;
    public static final int ONBOARD_POI_SEARCH_CRITERIA_ALONG_THE_ROUTE;

    default public void lockInput() {
    }

    default public void weakLockInput() {
    }

    default public void unlockInput() {
    }

    default public void freeService() {
    }

    default public void startPoiSearch(long l, int n) {
    }

    default public void getValueListBlock(int n, int n2) {
    }

    default public void stopPoiSearch() {
    }

    default public void resolveEntry(IOnboardPoiListElement iOnboardPoiListElement) {
    }

    default public long[] getTopPoiCategoryUids() {
    }
}

