/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.IASLNavigationInternalServiceFirst;
import java.util.Collection;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;

public interface ASLNavigationTruffelAPI
extends IASLNavigationInternalServiceFirst {
    public static final int EV_ASL_NAVIGATION_INTERNAL_TRUFFEL_GET_CODING;
    public static final int EV_ASL_NAVIGATION_INTERNAL_TRUFFEL_SELECT_BY_INDEX;
    public static final int EV_ASL_NAVIGATION_INTERNAL_TRUFFEL_SELECT_BY_INDEX_P0;
    public static final int EV_ASL_NAVIGATION_INTERNAL_TRUFFEL_SELECT_BY_INDEX_P1;
    public static final int EV_ASL_NAVIGATION_INTERNAL_TRUFFEL_RESTORE_SPELLER;
    public static final int EV_ASL_NAVIGATION_INTERNAL_TRUFFEL_RESOLVE_RESULT;
    public static final int EV_ASL_NAVIGATION_INTERNAL_TRUFFEL_RESOLVE_RESULT_P0;
    public static final int EV_ASL_NAVIGATION_INTERNAL_TRUFFEL_RESULT_RESOLVED;
    public static final int EV_ASL_NAVIGATION_INTERNAL_TRUFFEL_RESULT_RESOLVED_P0;
    public static final int EV_ASL_NAVIGATION_INTERNAL_TRUFFEL_RESULT_RESOLVED_P1;

    default public void resetSHIELDHousenumber() {
    }

    default public String getShieldHouseNumber() {
    }

    default public boolean addNavLocationToHistory() {
    }

    default public NavLocation getNavLocation() {
    }

    default public void setNavLocation(NavLocation navLocation) {
    }

    default public SearchResult getSearchResult() {
    }

    default public void spellerTextChanged() {
    }

    default public void setShieldHouseNumber(String string) {
    }

    default public int getLastDestsGeoPos() {
    }

    default public void setSearchResults(Vector vector, boolean bl, NavLocation navLocation, boolean bl2) {
    }

    default public void setSearchResult(NavLocation navLocation, int n, NavLocation navLocation2, boolean bl, NavLocation navLocation3, boolean bl2) {
    }

    default public void setSelectedSearchResult(NavLocation navLocation, Integer n) {
    }

    default public Collection getSearchResults() {
    }

    default public Object getSearchResult(int n) {
    }

    default public void switchToResultMapView(boolean bl) {
    }

    default public boolean isWaitingForTryMatchLocationResults() {
    }

    default public void allowReceivingEvents(boolean bl) {
    }

    default public void stopSearch() {
    }

    default public void initXt9Finished() {
    }
}

