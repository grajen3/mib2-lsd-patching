/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingReply;
import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingS;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarDrivingService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.driving.ASIHMISyncCarDriving");
    private ASIHMISyncCarDrivingS p_ASIHMISyncCarDriving;

    public ASIHMISyncCarDrivingService(int n, ASIHMISyncCarDrivingS aSIHMISyncCarDrivingS) {
        super(new ServiceInstanceID("4100596a-a26d-4625-84dc-0b3013890cde", n, "a3a2eb6d-2c8e-59dd-b6c4-6d6508e2f15f", "asi.hmisync.car.driving.ASIHMISyncCarDriving"));
        this.p_ASIHMISyncCarDriving = aSIHMISyncCarDrivingS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncCarDrivingReplyProxy();
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
                    this.p_ASIHMISyncCarDriving.setNotification((ASIHMISyncCarDrivingReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarDriving.setNotification(l, (ASIHMISyncCarDrivingReply)((ASIHMISyncCarDrivingReplyProxy)iProxyFrontend));
                    break;
                }
                case 4: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarDriving.setNotification(lArray, (ASIHMISyncCarDrivingReply)((ASIHMISyncCarDrivingReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncCarDriving.clearNotification((ASIHMISyncCarDrivingReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarDriving.clearNotification(l, (ASIHMISyncCarDrivingReply)((ASIHMISyncCarDrivingReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarDriving.clearNotification(lArray, (ASIHMISyncCarDrivingReply)((ASIHMISyncCarDrivingReplyProxy)iProxyFrontend));
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

