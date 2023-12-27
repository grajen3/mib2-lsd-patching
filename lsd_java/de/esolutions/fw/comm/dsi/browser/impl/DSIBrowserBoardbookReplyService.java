/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBoardbookReply;
import de.esolutions.fw.comm.dsi.browser.impl.SearchHitSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.browser.SearchHit;

public class DSIBrowserBoardbookReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.browser.DSIBrowserBoardbook");
    private static int dynamicHandle = 0;
    private DSIBrowserBoardbookReply p_DSIBrowserBoardbookReply;

    public DSIBrowserBoardbookReplyService(DSIBrowserBoardbookReply dSIBrowserBoardbookReply) {
        super(new ServiceInstanceID("03f95510-eeb3-5745-b7b4-d75d7d980f85", DSIBrowserBoardbookReplyService.nextDynamicHandle(), "4cab68e7-314f-5431-9fb3-c957c73e6c7e", "dsi.browser.DSIBrowserBoardbook"));
        this.p_DSIBrowserBoardbookReply = dSIBrowserBoardbookReply;
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
                case 4: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    SearchHit[] searchHitArray = SearchHitSerializer.getOptionalSearchHitVarArray(iDeserializer);
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIBrowserBoardbookReply.indicateSearchResults(string, n, searchHitArray, n2);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIBrowserBoardbookReply.updateBoardbookStatus(n, n3);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIBrowserBoardbookReply.asyncException(n, string, n4);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIBrowserBoardbookReply.yyIndication(string, string2);
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

