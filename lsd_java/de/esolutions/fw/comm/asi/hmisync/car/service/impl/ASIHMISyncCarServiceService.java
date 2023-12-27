/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceReply;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceS;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.service.ASIHMISyncCarService");
    private ASIHMISyncCarServiceS p_ASIHMISyncCarService;

    public ASIHMISyncCarServiceService(int n, ASIHMISyncCarServiceS aSIHMISyncCarServiceS) {
        super(new ServiceInstanceID("8ccf0676-352e-4fe1-a86e-ed15a11ea69e", n, "a5b91462-5820-555c-8411-698e8ac5864d", "asi.hmisync.car.service.ASIHMISyncCarService"));
        this.p_ASIHMISyncCarService = aSIHMISyncCarServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncCarServiceReplyProxy();
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
                    this.p_ASIHMISyncCarService.setNotification((ASIHMISyncCarServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarService.setNotification(l, (ASIHMISyncCarServiceReply)((ASIHMISyncCarServiceReplyProxy)iProxyFrontend));
                    break;
                }
                case 4: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarService.setNotification(lArray, (ASIHMISyncCarServiceReply)((ASIHMISyncCarServiceReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncCarService.clearNotification((ASIHMISyncCarServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarService.clearNotification(l, (ASIHMISyncCarServiceReply)((ASIHMISyncCarServiceReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarService.clearNotification(lArray, (ASIHMISyncCarServiceReply)((ASIHMISyncCarServiceReplyProxy)iProxyFrontend));
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

