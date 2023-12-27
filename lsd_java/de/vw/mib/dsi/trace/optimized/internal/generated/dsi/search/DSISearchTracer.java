/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.search;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.Highlight;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.RawDataSet;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Searchable;
import org.dsi.ifc.search.Suggestion;
import org.dsi.ifc.search.Token;

public final class DSISearchTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_CARFUNCTION;
    private static final int ID_CONFLICTMATCH;
    private static final int ID_COUNTRY;
    private static final int ID_DATASET;
    private static final int ID_ENVIRONMENT;
    private static final int ID_HIGHLIGHT;
    private static final int ID_NAVPOSITION;
    private static final int ID_RADIOSTATION;
    private static final int ID_RAWDATASET;
    private static final int ID_SEARCHFILTER;
    private static final int ID_SEARCHQUERY;
    private static final int ID_SEARCHRESULT;
    private static final int ID_SEARCHABLE;
    private static final int ID_SUGGESTION;
    private static final int ID_TOKEN;
    static /* synthetic */ Class class$org$dsi$ifc$search$CarFunction;
    static /* synthetic */ Class class$org$dsi$ifc$search$ConflictMatch;
    static /* synthetic */ Class class$org$dsi$ifc$search$Country;
    static /* synthetic */ Class class$org$dsi$ifc$search$DataSet;
    static /* synthetic */ Class class$org$dsi$ifc$search$Environment;
    static /* synthetic */ Class class$org$dsi$ifc$search$Highlight;
    static /* synthetic */ Class class$org$dsi$ifc$search$NavPosition;
    static /* synthetic */ Class class$org$dsi$ifc$search$RadioStation;
    static /* synthetic */ Class class$org$dsi$ifc$search$RawDataSet;
    static /* synthetic */ Class class$org$dsi$ifc$search$SearchFilter;
    static /* synthetic */ Class class$org$dsi$ifc$search$SearchQuery;
    static /* synthetic */ Class class$org$dsi$ifc$search$SearchResult;
    static /* synthetic */ Class class$org$dsi$ifc$search$Searchable;
    static /* synthetic */ Class class$org$dsi$ifc$search$Suggestion;
    static /* synthetic */ Class class$org$dsi$ifc$search$Token;

    public DSISearchTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$CarFunction == null ? (class$org$dsi$ifc$search$CarFunction = DSISearchTracer.class$("org.dsi.ifc.search.CarFunction")) : class$org$dsi$ifc$search$CarFunction, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$ConflictMatch == null ? (class$org$dsi$ifc$search$ConflictMatch = DSISearchTracer.class$("org.dsi.ifc.search.ConflictMatch")) : class$org$dsi$ifc$search$ConflictMatch, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$Country == null ? (class$org$dsi$ifc$search$Country = DSISearchTracer.class$("org.dsi.ifc.search.Country")) : class$org$dsi$ifc$search$Country, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$DataSet == null ? (class$org$dsi$ifc$search$DataSet = DSISearchTracer.class$("org.dsi.ifc.search.DataSet")) : class$org$dsi$ifc$search$DataSet, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$Environment == null ? (class$org$dsi$ifc$search$Environment = DSISearchTracer.class$("org.dsi.ifc.search.Environment")) : class$org$dsi$ifc$search$Environment, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$Highlight == null ? (class$org$dsi$ifc$search$Highlight = DSISearchTracer.class$("org.dsi.ifc.search.Highlight")) : class$org$dsi$ifc$search$Highlight, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$NavPosition == null ? (class$org$dsi$ifc$search$NavPosition = DSISearchTracer.class$("org.dsi.ifc.search.NavPosition")) : class$org$dsi$ifc$search$NavPosition, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$RadioStation == null ? (class$org$dsi$ifc$search$RadioStation = DSISearchTracer.class$("org.dsi.ifc.search.RadioStation")) : class$org$dsi$ifc$search$RadioStation, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$RawDataSet == null ? (class$org$dsi$ifc$search$RawDataSet = DSISearchTracer.class$("org.dsi.ifc.search.RawDataSet")) : class$org$dsi$ifc$search$RawDataSet, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$SearchFilter == null ? (class$org$dsi$ifc$search$SearchFilter = DSISearchTracer.class$("org.dsi.ifc.search.SearchFilter")) : class$org$dsi$ifc$search$SearchFilter, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$SearchQuery == null ? (class$org$dsi$ifc$search$SearchQuery = DSISearchTracer.class$("org.dsi.ifc.search.SearchQuery")) : class$org$dsi$ifc$search$SearchQuery, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$SearchResult == null ? (class$org$dsi$ifc$search$SearchResult = DSISearchTracer.class$("org.dsi.ifc.search.SearchResult")) : class$org$dsi$ifc$search$SearchResult, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$Searchable == null ? (class$org$dsi$ifc$search$Searchable = DSISearchTracer.class$("org.dsi.ifc.search.Searchable")) : class$org$dsi$ifc$search$Searchable, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$Suggestion == null ? (class$org$dsi$ifc$search$Suggestion = DSISearchTracer.class$("org.dsi.ifc.search.Suggestion")) : class$org$dsi$ifc$search$Suggestion, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$search$Token == null ? (class$org$dsi$ifc$search$Token = DSISearchTracer.class$("org.dsi.ifc.search.Token")) : class$org$dsi$ifc$search$Token, 15);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceCarFunction(printWriter, (CarFunction)object);
                break;
            }
            case 2: {
                this.traceConflictMatch(printWriter, (ConflictMatch)object);
                break;
            }
            case 3: {
                this.traceCountry(printWriter, (Country)object);
                break;
            }
            case 4: {
                this.traceDataSet(printWriter, (DataSet)object);
                break;
            }
            case 5: {
                this.traceEnvironment(printWriter, (Environment)object);
                break;
            }
            case 6: {
                this.traceHighlight(printWriter, (Highlight)object);
                break;
            }
            case 7: {
                this.traceNavPosition(printWriter, (NavPosition)object);
                break;
            }
            case 8: {
                this.traceRadioStation(printWriter, (RadioStation)object);
                break;
            }
            case 9: {
                this.traceRawDataSet(printWriter, (RawDataSet)object);
                break;
            }
            case 10: {
                this.traceSearchFilter(printWriter, (SearchFilter)object);
                break;
            }
            case 11: {
                this.traceSearchQuery(printWriter, (SearchQuery)object);
                break;
            }
            case 12: {
                this.traceSearchResult(printWriter, (SearchResult)object);
                break;
            }
            case 13: {
                this.traceSearchable(printWriter, (Searchable)object);
                break;
            }
            case 14: {
                this.traceSuggestion(printWriter, (Suggestion)object);
                break;
            }
            case 15: {
                this.traceToken(printWriter, (Token)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceCarFunction(PrintWriter printWriter, CarFunction carFunction) {
        if (carFunction == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carFunction.id);
        printWriter.print(carFunction.enabled);
    }

    private void traceConflictMatch(PrintWriter printWriter, ConflictMatch conflictMatch) {
        if (conflictMatch == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, conflictMatch.token);
        this.trace(printWriter, conflictMatch.country);
        printWriter.print(conflictMatch.type);
    }

    private void traceCountry(PrintWriter printWriter, Country country) {
        if (country == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(country.countryID);
        printWriter.print(country.name);
        printWriter.print(country.code);
        printWriter.print(country.houseNumberFormatting);
        printWriter.print(country.stateName);
        printWriter.print(country.stateAbbreviation);
    }

    private void traceDataSet(PrintWriter printWriter, DataSet dataSet) {
        if (dataSet == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataSet.id);
        printWriter.print(dataSet.entryType);
        printWriter.print(dataSet.entryFlags);
        if (dataSet.data == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = dataSet.data.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, dataSet.data[i2]);
            }
        }
    }

    private void traceEnvironment(PrintWriter printWriter, Environment environment) {
        if (environment == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(environment.oem);
        printWriter.print(environment.region);
        printWriter.print(environment.countryCoding);
        printWriter.print(environment.dealer);
    }

    private void traceHighlight(PrintWriter printWriter, Highlight highlight) {
        if (highlight == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(highlight.highlightStart);
        printWriter.print(highlight.highlightEnd);
        printWriter.print(highlight.type);
    }

    private void traceNavPosition(PrintWriter printWriter, NavPosition navPosition) {
        if (navPosition == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navPosition.lat);
        printWriter.print(navPosition.lon);
    }

    private void traceRadioStation(PrintWriter printWriter, RadioStation radioStation) {
        if (radioStation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(radioStation.id);
        printWriter.print(radioStation.data1);
        printWriter.print(radioStation.data2);
        printWriter.print(radioStation.data3);
    }

    private void traceRawDataSet(PrintWriter printWriter, RawDataSet rawDataSet) {
        if (rawDataSet == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rawDataSet.id);
        printWriter.print(rawDataSet.entryType);
        printWriter.print(rawDataSet.entryFlags);
        if (rawDataSet.data == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = rawDataSet.data.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(rawDataSet.data[i2]);
            }
        }
    }

    private void traceSearchFilter(PrintWriter printWriter, SearchFilter searchFilter) {
        int n;
        int n2;
        if (searchFilter == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (searchFilter.matchInTokens == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = searchFilter.matchInTokens.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(searchFilter.matchInTokens[n]);
            }
        }
        if (searchFilter.tokenBasedFilters == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = searchFilter.tokenBasedFilters.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, searchFilter.tokenBasedFilters[n]);
            }
        }
        printWriter.print(searchFilter.entryFlagMask);
        if (searchFilter.entryTypeFilter == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = searchFilter.entryTypeFilter.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(searchFilter.entryTypeFilter[n]);
            }
        }
    }

    private void traceSearchQuery(PrintWriter printWriter, SearchQuery searchQuery) {
        int n;
        int n2;
        if (searchQuery == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(searchQuery.queryId);
        if (searchQuery.sources == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = searchQuery.sources.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(searchQuery.sources[n]);
            }
        }
        printWriter.print(searchQuery.needle);
        if (searchQuery.alternativeNeedles == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = searchQuery.alternativeNeedles.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(searchQuery.alternativeNeedles[n]);
            }
        }
        printWriter.print(searchQuery.offset);
        printWriter.print(searchQuery.count);
        printWriter.print(searchQuery.conflictMode);
        printWriter.print(searchQuery.conflictModeTypes);
        printWriter.print(searchQuery.matchingMode);
        if (searchQuery.maxCountPerSource == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = searchQuery.maxCountPerSource.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(searchQuery.maxCountPerSource[n]);
            }
        }
    }

    private void traceSearchResult(PrintWriter printWriter, SearchResult searchResult) {
        int n;
        int n2;
        if (searchResult == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(searchResult.queryId);
        printWriter.print(searchResult.source);
        printWriter.print(searchResult.listPosition);
        printWriter.print(searchResult.entryType);
        printWriter.print(searchResult.entryFlags);
        printWriter.print(searchResult.poiType);
        printWriter.print(searchResult.iconID);
        this.trace(printWriter, searchResult.position);
        printWriter.print(searchResult.distanceMeters);
        printWriter.print(searchResult.dataId);
        if (searchResult.tokens == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = searchResult.tokens.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, searchResult.tokens[n]);
            }
        }
        this.trace(printWriter, searchResult.suggestion);
        this.trace(printWriter, searchResult.country);
        if (searchResult.applicationData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = searchResult.applicationData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(searchResult.applicationData[n]);
            }
        }
    }

    private void traceSearchable(PrintWriter printWriter, Searchable searchable) {
        if (searchable == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(searchable.wordType);
        printWriter.print(searchable.token);
        printWriter.print(searchable.tokenPostProcessing);
    }

    private void traceSuggestion(PrintWriter printWriter, Suggestion suggestion) {
        if (suggestion == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suggestion.query);
        printWriter.print(suggestion.suggestion);
        printWriter.print(suggestion.fullSuggestion);
    }

    private void traceToken(PrintWriter printWriter, Token token) {
        if (token == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(token.wordType);
        printWriter.print(token.token);
        if (token.highlights == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = token.highlights.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, token.highlights[i2]);
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

