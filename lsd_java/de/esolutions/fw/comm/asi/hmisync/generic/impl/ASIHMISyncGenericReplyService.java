/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic.impl;

import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericReply;
import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.GenericPacketSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncGenericReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.generic.ASIHMISyncGeneric");
    private static int dynamicHandle = 0;
    private ASIHMISyncGenericReply p_ASIHMISyncGenericReply;

    public ASIHMISyncGenericReplyService(ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        super(new ServiceInstanceID("8194babf-6beb-418f-bd90-f74b3c21802b", ASIHMISyncGenericReplyService.nextDynamicHandle(), "a72d3c71-2310-5bc0-8a73-f82f260b9d4e", "asi.hmisync.generic.ASIHMISyncGeneric"));
        this.p_ASIHMISyncGenericReply = aSIHMISyncGenericReply;
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
                case 3: {
                    GenericPacket genericPacket = GenericPacketSerializer.getOptionalGenericPacket(iDeserializer);
                    this.p_ASIHMISyncGenericReply.sendDataFromUnit(genericPacket);
                    break;
                }
                case 8: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncGenericReply.updateASIVersion(string, bl);
                    break;
                }
                case 10: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncGenericReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 9: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncGenericReply.updateReplyIDs(sArray, bl);
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

