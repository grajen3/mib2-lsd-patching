/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search;

import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public interface DSISearchC {
    default public void requestSupportedCountries() {
    }

    default public void setActiveSearchCountries(String[] stringArray) {
    }

    default public void search(SearchQuery searchQuery) {
    }

    default public void addToHistory(SearchResult searchResult) {
    }

    default public void requestSuggestion(SearchQuery searchQuery) {
    }

    default public void cancelQuery(int n) {
    }

    default public void setCurrentPosition(NavPosition navPosition) {
    }

    default public void setRoutePoints(NavPosition[] navPositionArray) {
    }

    default public void setLanguage(String string) {
    }

    default public void setActiveProfile(int n) {
    }

    default public void setCarFunctionStates(CarFunction[] carFunctionArray) {
    }

    default public void setRadioStations(int n, RadioStation[] radioStationArray) {
    }

    default public void setSearchFilter(int n, SearchFilter searchFilter) {
    }

    default public void prepareSources(int[] nArray) {
    }

    default public void resetToFactorySettings() {
    }

    default public void removeFromHistory(long l) {
    }

    default public void removeAllFromHistory() {
    }

    default public void removeAllFromHistoryBySource(int n) {
    }

    default public void resetAutocompletion(int n) {
    }

    default public void createBackupFile(String string) {
    }

    default public void importBackupFile(String string) {
    }

    default public void setEnvironment(Environment environment) {
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

