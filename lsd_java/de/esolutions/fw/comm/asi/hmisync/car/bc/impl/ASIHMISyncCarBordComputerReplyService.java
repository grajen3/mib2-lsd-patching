/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerReply;
import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.BCTermGeneralDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.impl.FloatBaseTypeSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.impl.IntBaseTypeSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarBordComputerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.bc.ASIHMISyncCarBordComputer");
    private static int dynamicHandle = 0;
    private ASIHMISyncCarBordComputerReply p_ASIHMISyncCarBordComputerReply;

    public ASIHMISyncCarBordComputerReplyService(ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        super(new ServiceInstanceID("6d65ca53-0148-4329-8b3c-e8cd1fbade7a", ASIHMISyncCarBordComputerReplyService.nextDynamicHandle(), "d1b91a1b-f081-5c4c-bc68-8c00a93879a4", "asi.hmisync.car.bc.ASIHMISyncCarBordComputer"));
        this.p_ASIHMISyncCarBordComputerReply = aSIHMISyncCarBordComputerReply;
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
                    this.p_ASIHMISyncCarBordComputerReply.updateASIVersion(string, bl);
                    break;
                }
                case 24: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 23: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption1Visibility(n, bl);
                    break;
                }
                case 17: {
                    FloatBaseType floatBaseType = FloatBaseTypeSerializer.getOptionalFloatBaseType(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption1(floatBaseType, bl);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption2Visibility(n, bl);
                    break;
                }
                case 19: {
                    FloatBaseType floatBaseType = FloatBaseTypeSerializer.getOptionalFloatBaseType(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption2(floatBaseType, bl);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption1Visibility(n, bl);
                    break;
                }
                case 11: {
                    FloatBaseType floatBaseType = FloatBaseTypeSerializer.getOptionalFloatBaseType(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption1(floatBaseType, bl);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption2Visibility(n, bl);
                    break;
                }
                case 13: {
                    FloatBaseType floatBaseType = FloatBaseTypeSerializer.getOptionalFloatBaseType(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption2(floatBaseType, bl);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCCurrentRange1Visibility(n, bl);
                    break;
                }
                case 7: {
                    IntBaseType intBaseType = IntBaseTypeSerializer.getOptionalIntBaseType(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCCurrentRange1(intBaseType, bl);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCCurrentRange2Visibility(n, bl);
                    break;
                }
                case 9: {
                    IntBaseType intBaseType = IntBaseTypeSerializer.getOptionalIntBaseType(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCCurrentRange2(intBaseType, bl);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCShortTermGeneralVisibility(n, bl);
                    break;
                }
                case 21: {
                    BCTermGeneralData bCTermGeneralData = BCTermGeneralDataSerializer.getOptionalBCTermGeneralData(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCShortTermGeneral(bCTermGeneralData, bl);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCLongTermGeneralVisibility(n, bl);
                    break;
                }
                case 15: {
                    BCTermGeneralData bCTermGeneralData = BCTermGeneralDataSerializer.getOptionalBCTermGeneralData(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarBordComputerReply.updateBCLongTermGeneral(bCTermGeneralData, bl);
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

