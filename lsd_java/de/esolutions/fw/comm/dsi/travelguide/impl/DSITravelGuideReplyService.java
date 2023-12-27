/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.travelguide.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.travelguide.DSITravelGuideReply;
import de.esolutions.fw.comm.dsi.travelguide.impl.TravelGuideMemoryListElementSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.travelguide.TravelGuideMemoryListElement;

public class DSITravelGuideReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.travelguide.DSITravelGuide");
    private static int dynamicHandle = 0;
    private DSITravelGuideReply p_DSITravelGuideReply;

    public DSITravelGuideReplyService(DSITravelGuideReply dSITravelGuideReply) {
        super(new ServiceInstanceID("9e6ce532-4a34-5e70-9afe-46d5debc1126", DSITravelGuideReplyService.nextDynamicHandle(), "5c1eb755-beb0-51c7-b069-79b0037789b9", "dsi.travelguide.DSITravelGuide"));
        this.p_DSITravelGuideReply = dSITravelGuideReply;
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
                case 7: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSITravelGuideReply.importTravelGuideResult(n, n2);
                    break;
                }
                case 12: {
                    TravelGuideMemoryListElement travelGuideMemoryListElement = TravelGuideMemoryListElementSerializer.getOptionalTravelGuideMemoryListElement(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITravelGuideReply.updateTravelGuideMemoryListElement(travelGuideMemoryListElement, n, n3);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITravelGuideReply.deleteTravelGuideResult(n);
                    break;
                }
                case 11: {
                    TravelGuideMemoryListElement[] travelGuideMemoryListElementArray = TravelGuideMemoryListElementSerializer.getOptionalTravelGuideMemoryListElementVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITravelGuideReply.updateTravelGuideMemoryList(travelGuideMemoryListElementArray, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSITravelGuideReply.asyncException(n, string, n4);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITravelGuideReply.yyIndication(string, string2);
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

