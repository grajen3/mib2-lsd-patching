/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.impl;

import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarGenericReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.ASIHMISyncCarGeneric");
    private static int dynamicHandle = 0;
    private ASIHMISyncCarGenericReply p_ASIHMISyncCarGenericReply;

    public ASIHMISyncCarGenericReplyService(ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        super(new ServiceInstanceID("4bec9bb4-6e17-4b7b-80ff-a9b336700c76", ASIHMISyncCarGenericReplyService.nextDynamicHandle(), "0455eeb3-67d3-5538-a0cf-8ec326f2a00e", "asi.hmisync.car.ASIHMISyncCarGeneric"));
        this.p_ASIHMISyncCarGenericReply = aSIHMISyncCarGenericReply;
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
                case 6: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarGenericReply.updateASIVersion(string, bl);
                    break;
                }
                case 8: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarGenericReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 7: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarGenericReply.updateReplyIDs(sArray, bl);
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

