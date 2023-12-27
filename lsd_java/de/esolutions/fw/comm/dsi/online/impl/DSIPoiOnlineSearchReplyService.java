/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIPoiOnlineSearchReply;
import de.esolutions.fw.comm.dsi.online.impl.OSRServiceStateSerializer;
import de.esolutions.fw.comm.dsi.online.impl.PoiOnlineSearchValuelistSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public class DSIPoiOnlineSearchReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.online.DSIPoiOnlineSearch");
    private static int dynamicHandle = 0;
    private DSIPoiOnlineSearchReply p_DSIPoiOnlineSearchReply;

    public DSIPoiOnlineSearchReplyService(DSIPoiOnlineSearchReply dSIPoiOnlineSearchReply) {
        super(new ServiceInstanceID("66cd10bd-7fcb-5257-a3b3-fb17ef89a84c", DSIPoiOnlineSearchReplyService.nextDynamicHandle(), "570d8158-1fca-541c-bb86-991022902795", "dsi.online.DSIPoiOnlineSearch"));
        this.p_DSIPoiOnlineSearchReply = dSIPoiOnlineSearchReply;
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
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIPoiOnlineSearchReply.poiResult(n, n2, n3);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_DSIPoiOnlineSearchReply.poiSpellingSuggestion(n, string, stringArray);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    PoiOnlineSearchValuelist poiOnlineSearchValuelist = PoiOnlineSearchValuelistSerializer.getOptionalPoiOnlineSearchValuelist(iDeserializer);
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIPoiOnlineSearchReply.poiValueList(n, n4, poiOnlineSearchValuelist, n5, n6);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    OSRServiceState oSRServiceState = OSRServiceStateSerializer.getOptionalOSRServiceState(iDeserializer);
                    this.p_DSIPoiOnlineSearchReply.precheckDynamicPOICategoryResponse(n, oSRServiceState);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIPoiOnlineSearchReply.asyncException(n, string, n7);
                    break;
                }
                case 25: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIPoiOnlineSearchReply.yyIndication(string, string2);
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

