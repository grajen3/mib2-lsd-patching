/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;
import de.esolutions.fw.comm.asi.hmisync.car.impl.IntBaseTypeSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarClimateReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.climate.ASIHMISyncCarClimate");
    private static int dynamicHandle = 0;
    private ASIHMISyncCarClimateReply p_ASIHMISyncCarClimateReply;

    public ASIHMISyncCarClimateReplyService(ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        super(new ServiceInstanceID("5ffc8a82-9fd6-4d5f-9e5b-b7d05d798bc3", ASIHMISyncCarClimateReplyService.nextDynamicHandle(), "b433dc69-1912-5b9a-900b-83fe40f977cc", "asi.hmisync.car.climate.ASIHMISyncCarClimate"));
        this.p_ASIHMISyncCarClimateReply = aSIHMISyncCarClimateReply;
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
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarClimateReply.updateASIVersion(string, bl);
                    break;
                }
                case 12: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarClimateReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 11: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarClimateReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 9: {
                    IntBaseType intBaseType = IntBaseTypeSerializer.getOptionalIntBaseType(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarClimateReply.updateAirconTempZone1(intBaseType, bl);
                    break;
                }
                case 10: {
                    IntBaseType intBaseType = IntBaseTypeSerializer.getOptionalIntBaseType(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarClimateReply.updateAirconTempZone2(intBaseType, bl);
                    break;
                }
                case 8: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    this.p_ASIHMISyncCarClimateReply.updateAirconMaxAC(bl, bl2);
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

