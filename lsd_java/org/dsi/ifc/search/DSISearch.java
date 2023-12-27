/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public interface DSISearch
extends DSIBase {
    public static final String VERSION;
    public static final int IN_INVALIDATEDATA;
    public static final int IN_SOURCEDATAAVAILABILITYCHANGED;
    public static final int ATTR_SEARCHISACTIVE;
    public static final int ATTR_POTENTIALCONFLICT;
    public static final int ATTR_PROFILESTATE;
    public static final int RP_REQUESTSUPPORTEDCOUNTRIESRESULT;
    public static final int RP_SEARCHRESULT;
    public static final int RP_ADDTOHISTORYRESULT;
    public static final int RP_CANCELQUERYRESULT;
    public static final int RP_SETCURRENTPOSITIONRESULT;
    public static final int RP_SETROUTEPOINTSRESULT;
    public static final int RP_SETLANGUAGERESULT;
    public static final int RP_SETCARFUNCTIONSTATESRESULT;
    public static final int RP_SETRADIOSTATIONSRESULT;
    public static final int RP_SETACTIVEPROFILERESULT;
    public static final int RP_SETACTIVESEARCHCOUNTRIESRESULT;
    public static final int RP_RESETTOFACTORYSETTINGSRESULT;
    public static final int RP_PREPARESOURCESRESULT;
    public static final int RP_SETSEARCHFILTERRESULT;
    public static final int RP_REMOVEFROMHISTORYRESULT;
    public static final int RP_RESETAUTOCOMPLETIONRESULT;
    public static final int RP_REMOVEALLFROMHISTORYRESULT;
    public static final int RP_CREATEBACKUPFILERESULT;
    public static final int RP_IMPORTBACKUPFILERESULT;
    public static final int RP_SETENVIRONMENTRESULT;
    public static final int RP_REQUESTSUGGESTIONRESULT;
    public static final int RP_REMOVEALLFROMHISTORYBYSOURCERESULT;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;
    public static final int RT_SETACTIVEPROFILE;
    public static final int RT_REQUESTSUPPORTEDCOUNTRIES;
    public static final int RT_SETACTIVESEARCHCOUNTRIES;
    public static final int RT_SEARCH;
    public static final int RT_ADDTOHISTORY;
    public static final int RT_REQUESTSUGGESTION;
    public static final int RT_CANCELQUERY;
    public static final int RT_SETCURRENTPOSITION;
    public static final int RT_SETROUTEPOINTS;
    public static final int RT_SETLANGUAGE;
    public static final int RT_SETCARFUNCTIONSTATES;
    public static final int RT_SETRADIOSTATIONS;
    public static final int RT_RESETTOFACTORYSETTINGS;
    public static final int RT_PREPARESOURCES;
    public static final int RT_SETSEARCHFILTER;
    public static final int RT_REMOVEFROMHISTORY;
    public static final int RT_RESETAUTOCOMPLETION;
    public static final int RT_REMOVEALLFROMHISTORY;
    public static final int RT_CREATEBACKUPFILE;
    public static final int RT_IMPORTBACKUPFILE;
    public static final int RT_SETENVIRONMENT;
    public static final int RT_REMOVEALLFROMHISTORYBYSOURCE;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;

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
}

