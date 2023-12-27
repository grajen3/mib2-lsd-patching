/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic.impl;

import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericReply;
import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericS;
import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.GenericPacketSerializer;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncGenericService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.generic.ASIHMISyncGeneric");
    private ASIHMISyncGenericS p_ASIHMISyncGeneric;

    public ASIHMISyncGenericService(int n, ASIHMISyncGenericS aSIHMISyncGenericS) {
        super(new ServiceInstanceID("8240215d-ce8b-4cad-8c1c-31b07f57874c", n, "acbc4ddf-b980-5af2-a38a-506f1125c975", "asi.hmisync.generic.ASIHMISyncGeneric"));
        this.p_ASIHMISyncGeneric = aSIHMISyncGenericS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncGenericReplyProxy();
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
                    GenericPacket genericPacket = GenericPacketSerializer.getOptionalGenericPacket(iDeserializer);
                    this.p_ASIHMISyncGeneric.sendDataToUnit(genericPacket, (ASIHMISyncGenericReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    this.p_ASIHMISyncGeneric.setNotification((ASIHMISyncGenericReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncGeneric.setNotification(l, (ASIHMISyncGenericReply)((ASIHMISyncGenericReplyProxy)iProxyFrontend));
                    break;
                }
                case 6: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncGeneric.setNotification(lArray, (ASIHMISyncGenericReply)((ASIHMISyncGenericReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncGeneric.clearNotification((ASIHMISyncGenericReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncGeneric.clearNotification(l, (ASIHMISyncGenericReply)((ASIHMISyncGenericReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncGeneric.clearNotification(lArray, (ASIHMISyncGenericReply)((ASIHMISyncGenericReplyProxy)iProxyFrontend));
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

