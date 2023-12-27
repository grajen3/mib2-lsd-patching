/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

public interface DSISearchListener
extends DSIListener {
    default public void requestSupportedCountriesResult(int n, Country[] countryArray) {
    }

    default public void searchResult(int n, SearchResult searchResult) {
    }

    default public void addToHistoryResult(int n) {
    }

    default public void requestSuggestionResult(int n, int n2, Suggestion[] suggestionArray) {
    }

    default public void cancelQueryResult(int n, int n2) {
    }

    default public void setCurrentPositionResult(int n) {
    }

    default public void setRoutePointsResult(int n) {
    }

    default public void setLanguageResult(int n) {
    }

    default public void updateSearchIsActive(int n, boolean bl, int n2) {
    }

    default public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
    }

    default public void setCarFunctionStatesResult(int n) {
    }

    default public void setRadioStationsResult(int n, int n2) {
    }

    default public void setSearchFilterResult(int n, int n2) {
    }

    default public void setActiveProfileResult(int n) {
    }

    default public void setActiveSearchCountriesResult(int n) {
    }

    default public void resetToFactorySettingsResult(int n) {
    }

    default public void invalidateData(int[] nArray) {
    }

    default public void prepareSourcesResult(int n) {
    }

    default public void removeFromHistoryResult(int n) {
    }

    default public void removeAllFromHistoryResult(int n) {
    }

    default public void removeAllFromHistoryBySourceResult(int n) {
    }

    default public void resetAutocompletionResult(int n, int n2) {
    }

    default public void sourceDataAvailabilityChanged(int n, boolean bl) {
    }

    default public void createBackupFileResult(int n, String string) {
    }

    default public void importBackupFileResult(int n, String string) {
    }

    default public void setEnvironmentResult(int n) {
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

