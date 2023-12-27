/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onlinepoi;

import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;

public interface OnlinePOIService {
    public static final int ONLINEPOISEARCH_RESULT_EXCEPTION;
    public static final int ONLINEPOISEARCH_RESULT_FAILED;
    public static final int ONLINEPOISEARCH_RESULT_NORESULT;
    public static final int ONLINEPOISEARCH_RESULT_NOKEYWORD;
    public static final int ONLINEPOISEARCH_RESULT_NOLANGUAGESUPPORT;
    public static final int ONLINEPOISEARCH_RESULT_NOFURTHERRESULTS;

    default public boolean isServiceReady() {
    }

    default public void prepareForSearch() {
    }

    default public void startSearch() {
    }

    default public void getNextEntries() {
    }

    default public void stopSearch() {
    }

    default public boolean hasOnlyOneEntry() {
    }

    default public boolean hasMoreEntries() {
    }

    default public boolean isFirstSearchResult() {
    }

    default public void resolveEntry(IOnlinePoiListElement iOnlinePoiListElement) {
    }
}

