/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.impl.FloatBaseTypeSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceReply;
import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.AdBlueInfoSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.OilLevelDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.SIAOilInspectionSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.SIAServiceDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.TireDisplayDataSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.service.ASIHMISyncCarService");
    private static int dynamicHandle = 0;
    private ASIHMISyncCarServiceReply p_ASIHMISyncCarServiceReply;

    public ASIHMISyncCarServiceReplyService(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        super(new ServiceInstanceID("7a1486d5-f261-4cc0-a776-d22b0205f993", ASIHMISyncCarServiceReplyService.nextDynamicHandle(), "7a22b628-8259-5dd8-ab90-23654e8883e0", "asi.hmisync.car.service.ASIHMISyncCarService"));
        this.p_ASIHMISyncCarServiceReply = aSIHMISyncCarServiceReply;
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
                    this.p_ASIHMISyncCarServiceReply.updateASIVersion(string, bl);
                    break;
                }
                case 14: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 13: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 11: {
                    OilLevelData oilLevelData = OilLevelDataSerializer.getOptionalOilLevelData(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateOilLevelData(oilLevelData, bl);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateOilLevelDataVisibilityState(n, bl);
                    break;
                }
                case 26: {
                    AdBlueInfo adBlueInfo = AdBlueInfoSerializer.getOptionalAdBlueInfo(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateAdBlueInfo(adBlueInfo, bl);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateAdBlueInfoVisibilityState(n, bl);
                    break;
                }
                case 15: {
                    SIAOilInspection sIAOilInspection = SIAOilInspectionSerializer.getOptionalSIAOilInspection(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateSIAOilInspection(sIAOilInspection, bl);
                    break;
                }
                case 16: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateSIAOilInspectionVisibilityState(nArray, bl);
                    break;
                }
                case 17: {
                    SIAServiceData sIAServiceData = SIAServiceDataSerializer.getOptionalSIAServiceData(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateSIAServiceData(sIAServiceData, bl);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateSIAServiceDataVisibilityState(n, bl);
                    break;
                }
                case 24: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateVinData(string, bl);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateVinDataVisibilityState(n, bl);
                    break;
                }
                case 9: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateKeyData(nArray, bl);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateKeyDataVisibilityState(n, bl);
                    break;
                }
                case 19: {
                    TireDisplayData tireDisplayData = TireDisplayDataSerializer.getOptionalTireDisplayData(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateTireDisplayData(tireDisplayData, bl);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateTireDisplayDataVisibilityState(n, bl);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateTireSystem(n, bl);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateVehicleSpeedVisibility(n, bl);
                    break;
                }
                case 22: {
                    FloatBaseType floatBaseType = FloatBaseTypeSerializer.getOptionalFloatBaseType(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarServiceReply.updateVehicleSpeed(floatBaseType, bl);
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

