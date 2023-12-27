/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.search.DSISearchReply;
import de.esolutions.fw.comm.dsi.search.impl.ConflictMatchSerializer;
import de.esolutions.fw.comm.dsi.search.impl.CountrySerializer;
import de.esolutions.fw.comm.dsi.search.impl.SearchResultSerializer;
import de.esolutions.fw.comm.dsi.search.impl.SuggestionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

public class DSISearchReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.search.DSISearch");
    private static int dynamicHandle = 0;
    private DSISearchReply p_DSISearchReply;

    public DSISearchReplyService(DSISearchReply dSISearchReply) {
        super(new ServiceInstanceID("0ff5e332-b87e-54b7-b7a5-4443f1ccedcd", DSISearchReplyService.nextDynamicHandle(), "401b0058-41e3-5f0a-90d4-8867c2944111", "dsi.search.DSISearch"));
        this.p_DSISearchReply = dSISearchReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 79: {
                    int n = iDeserializer.getInt32();
                    Country[] countryArray = CountrySerializer.getOptionalCountryVarArray(iDeserializer);
                    this.p_DSISearchReply.requestSupportedCountriesResult(n, countryArray);
                    break;
                }
                case 106: {
                    int n = iDeserializer.getInt32();
                    SearchResult searchResult = SearchResultSerializer.getOptionalSearchResult(iDeserializer);
                    this.p_DSISearchReply.searchResult(n, searchResult);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.addToHistoryResult(n);
                    break;
                }
                case 86: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    Suggestion[] suggestionArray = SuggestionSerializer.getOptionalSuggestionVarArray(iDeserializer);
                    this.p_DSISearchReply.requestSuggestionResult(n, n2, suggestionArray);
                    break;
                }
                case 97: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSISearchReply.cancelQueryResult(n, n3);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.setCurrentPositionResult(n);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.setRoutePointsResult(n);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.setLanguageResult(n);
                    break;
                }
                case 110: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSISearchReply.updateSearchIsActive(n, bl, n4);
                    break;
                }
                case 108: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    ConflictMatch conflictMatch = ConflictMatchSerializer.getOptionalConflictMatch(iDeserializer);
                    int n5 = iDeserializer.getInt32();
                    this.p_DSISearchReply.updatePotentialConflict(n, bl, conflictMatch, n5);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.setCarFunctionStatesResult(n);
                    break;
                }
                case 60: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSISearchReply.setRadioStationsResult(n, n6);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSISearchReply.setSearchFilterResult(n, n7);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.setActiveProfileResult(n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.setActiveSearchCountriesResult(n);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.resetToFactorySettingsResult(n);
                    break;
                }
                case 34: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSISearchReply.invalidateData(nArray);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.prepareSourcesResult(n);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.removeFromHistoryResult(n);
                    break;
                }
                case 62: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.removeAllFromHistoryResult(n);
                    break;
                }
                case 94: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.removeAllFromHistoryBySourceResult(n);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSISearchReply.resetAutocompletionResult(n, n8);
                    break;
                }
                case 58: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSISearchReply.sourceDataAvailabilityChanged(n, bl);
                    break;
                }
                case 64: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISearchReply.createBackupFileResult(n, string);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISearchReply.importBackupFileResult(n, string);
                    break;
                }
                case 75: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.setEnvironmentResult(n);
                    break;
                }
                case 109: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSISearchReply.updateProfileState(n, n9, n10);
                    break;
                }
                case 99: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSISearchReply.profileChanged(n, n11);
                    break;
                }
                case 100: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSISearchReply.profileCopied(n, n12, n13);
                    break;
                }
                case 103: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSISearchReply.profileReset(n, n14);
                    break;
                }
                case 105: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchReply.profileResetAll(n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSISearchReply.asyncException(n, string, n15);
                    break;
                }
                case 32: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISearchReply.yyIndication(string, string2);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

