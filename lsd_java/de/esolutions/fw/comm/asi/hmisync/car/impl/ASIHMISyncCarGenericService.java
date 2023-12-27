/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.impl;

import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericReply;
import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericS;
import de.esolutions.fw.comm.asi.hmisync.car.impl.ASIHMISyncCarGenericReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarGenericService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.ASIHMISyncCarGeneric");
    private ASIHMISyncCarGenericS p_ASIHMISyncCarGeneric;

    public ASIHMISyncCarGenericService(int n, ASIHMISyncCarGenericS aSIHMISyncCarGenericS) {
        super(new ServiceInstanceID("5b840a23-d8e1-48db-bd23-f4040e6a7520", n, "53d5f21b-54ec-5e84-8236-10ea0e3da972", "asi.hmisync.car.ASIHMISyncCarGeneric"));
        this.p_ASIHMISyncCarGeneric = aSIHMISyncCarGenericS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncCarGenericReplyProxy();
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
                    this.p_ASIHMISyncCarGeneric.setNotification((ASIHMISyncCarGenericReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarGeneric.setNotification(l, (ASIHMISyncCarGenericReply)((ASIHMISyncCarGenericReplyProxy)iProxyFrontend));
                    break;
                }
                case 4: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarGeneric.setNotification(lArray, (ASIHMISyncCarGenericReply)((ASIHMISyncCarGenericReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncCarGeneric.clearNotification((ASIHMISyncCarGenericReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarGeneric.clearNotification(l, (ASIHMISyncCarGenericReply)((ASIHMISyncCarGenericReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarGeneric.clearNotification(lArray, (ASIHMISyncCarGenericReply)((ASIHMISyncCarGenericReplyProxy)iProxyFrontend));
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

