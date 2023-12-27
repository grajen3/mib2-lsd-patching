/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionReply;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionS;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarZeroEmissionService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission");
    private ASIHMISyncCarZeroEmissionS p_ASIHMISyncCarZeroEmission;

    public ASIHMISyncCarZeroEmissionService(int n, ASIHMISyncCarZeroEmissionS aSIHMISyncCarZeroEmissionS) {
        super(new ServiceInstanceID("ca36882d-502d-46af-ab3e-d2c6400c0f8f", n, "a6b4ab1f-6788-5ff8-830d-83712694c53c", "asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission"));
        this.p_ASIHMISyncCarZeroEmission = aSIHMISyncCarZeroEmissionS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncCarZeroEmissionReplyProxy();
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
                    this.p_ASIHMISyncCarZeroEmission.setNotification((ASIHMISyncCarZeroEmissionReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarZeroEmission.setNotification(l, (ASIHMISyncCarZeroEmissionReply)((ASIHMISyncCarZeroEmissionReplyProxy)iProxyFrontend));
                    break;
                }
                case 4: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarZeroEmission.setNotification(lArray, (ASIHMISyncCarZeroEmissionReply)((ASIHMISyncCarZeroEmissionReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncCarZeroEmission.clearNotification((ASIHMISyncCarZeroEmissionReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarZeroEmission.clearNotification(l, (ASIHMISyncCarZeroEmissionReply)((ASIHMISyncCarZeroEmissionReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarZeroEmission.clearNotification(lArray, (ASIHMISyncCarZeroEmissionReply)((ASIHMISyncCarZeroEmissionReplyProxy)iProxyFrontend));
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

