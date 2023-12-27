/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.CharacterInfoSerializer;
import de.esolutions.fw.comm.dsi.media.DSIMediaBrowserReply;
import de.esolutions.fw.comm.dsi.media.impl.ListEntrySerializer;
import de.esolutions.fw.comm.dsi.media.impl.SearchListEntryExtSerializer;
import de.esolutions.fw.comm.dsi.media.impl.SearchListEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public class DSIMediaBrowserReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.media.DSIMediaBrowser");
    private static int dynamicHandle = 0;
    private DSIMediaBrowserReply p_DSIMediaBrowserReply;

    public DSIMediaBrowserReplyService(DSIMediaBrowserReply dSIMediaBrowserReply) {
        super(new ServiceInstanceID("4bd972e8-016b-5b8e-8843-5e9da71bd889", DSIMediaBrowserReplyService.nextDynamicHandle(), "eb2373f8-8839-59fb-ab05-f2b59647a61b", "dsi.media.DSIMediaBrowser"));
        this.p_DSIMediaBrowserReply = dSIMediaBrowserReply;
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
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.updateBrowseMode(n, n2);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.updateContentFilter(n, n3);
                    break;
                }
                case 34: {
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.updateBrowseMedia(l, l2, n);
                    break;
                }
                case 51: {
                    ListEntry[] listEntryArray = ListEntrySerializer.getOptionalListEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.updateBrowseFolder(listEntryArray, n);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.updateListSize(n, n4, n5);
                    break;
                }
                case 44: {
                    CharacterInfo[] characterInfoArray = CharacterInfoSerializer.getOptionalCharacterInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.updateAlphabeticalIndex(characterInfoArray, n);
                    break;
                }
                case 49: {
                    ListEntry[] listEntryArray = ListEntrySerializer.getOptionalListEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.responseList(listEntryArray, n);
                    break;
                }
                case 50: {
                    ListEntry[] listEntryArray = ListEntrySerializer.getOptionalListEntryVarArray(iDeserializer);
                    this.p_DSIMediaBrowserReply.responsePickList(listEntryArray);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    long l = iDeserializer.getInt64();
                    long l3 = iDeserializer.getInt64();
                    long l4 = iDeserializer.getInt64();
                    long l5 = iDeserializer.getInt64();
                    long l6 = iDeserializer.getInt64();
                    this.p_DSIMediaBrowserReply.selectionResult(n, n6, bl, l, l3, l4, l5, l6);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMediaBrowserReply.responseSetSearchCriteria(n, bl);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.updateSearchSize(n, n7, n8, n9, n10);
                    break;
                }
                case 19: {
                    long l = iDeserializer.getInt64();
                    long l7 = iDeserializer.getInt64();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMediaBrowserReply.responseSelectSearchResult(l, l7, bl);
                    break;
                }
                case 21: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMediaBrowserReply.responseSetSearchString(string, bl);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.updateSearchSpellerState(n, n11);
                    break;
                }
                case 17: {
                    SearchListEntry[] searchListEntryArray = SearchListEntrySerializer.getOptionalSearchListEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.responseSearchList(searchListEntryArray, n);
                    break;
                }
                case 55: {
                    SearchListEntryExt[] searchListEntryExtArray = SearchListEntryExtSerializer.getOptionalSearchListEntryExtVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.responseSearchListExt(searchListEntryExtArray, n);
                    break;
                }
                case 53: {
                    long l = iDeserializer.getInt64();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIMediaBrowserReply.responseFullyQualifiedName(l, string);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIMediaBrowserReply.asyncException(n, string, n12);
                    break;
                }
                case 40: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMediaBrowserReply.yyIndication(string, string2);
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

