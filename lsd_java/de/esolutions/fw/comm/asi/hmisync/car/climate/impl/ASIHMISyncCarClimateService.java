/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateS;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarClimateService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.climate.ASIHMISyncCarClimate");
    private ASIHMISyncCarClimateS p_ASIHMISyncCarClimate;

    public ASIHMISyncCarClimateService(int n, ASIHMISyncCarClimateS aSIHMISyncCarClimateS) {
        super(new ServiceInstanceID("ff03f2f6-eceb-470b-8239-62939e77c4ac", n, "c5ac76c2-2476-5a12-9346-cccd09428a82", "asi.hmisync.car.climate.ASIHMISyncCarClimate"));
        this.p_ASIHMISyncCarClimate = aSIHMISyncCarClimateS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncCarClimateReplyProxy();
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
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarClimate.setAirconAC(bl, (ASIHMISyncCarClimateReplyProxy)iProxyFrontend);
                    break;
                }
                case 4: {
                    this.p_ASIHMISyncCarClimate.setNotification((ASIHMISyncCarClimateReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarClimate.setNotification(l, (ASIHMISyncCarClimateReply)((ASIHMISyncCarClimateReplyProxy)iProxyFrontend));
                    break;
                }
                case 5: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarClimate.setNotification(lArray, (ASIHMISyncCarClimateReply)((ASIHMISyncCarClimateReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncCarClimate.clearNotification((ASIHMISyncCarClimateReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarClimate.clearNotification(l, (ASIHMISyncCarClimateReply)((ASIHMISyncCarClimateReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarClimate.clearNotification(lArray, (ASIHMISyncCarClimateReply)((ASIHMISyncCarClimateReplyProxy)iProxyFrontend));
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

