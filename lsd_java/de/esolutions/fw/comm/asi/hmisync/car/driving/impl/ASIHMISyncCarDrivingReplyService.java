/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingReply;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADConfiguration;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.TADConfigurationSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.TADVehicleInfoSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarDrivingReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.driving.ASIHMISyncCarDriving");
    private static int dynamicHandle = 0;
    private ASIHMISyncCarDrivingReply p_ASIHMISyncCarDrivingReply;

    public ASIHMISyncCarDrivingReplyService(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        super(new ServiceInstanceID("cf0d1065-933d-46b1-baf6-eb334745e56f", ASIHMISyncCarDrivingReplyService.nextDynamicHandle(), "379cb220-0a06-531f-b0fc-2506d73807a9", "asi.hmisync.car.driving.ASIHMISyncCarDriving"));
        this.p_ASIHMISyncCarDrivingReply = aSIHMISyncCarDrivingReply;
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
                    this.p_ASIHMISyncCarDrivingReply.updateASIVersion(string, bl);
                    break;
                }
                case 10: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 9: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 20: {
                    TADVehicleInfo tADVehicleInfo = TADVehicleInfoSerializer.getOptionalTADVehicleInfo(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateTADVehicleInfo(tADVehicleInfo, bl);
                    break;
                }
                case 22: {
                    TADConfiguration tADConfiguration = TADConfigurationSerializer.getOptionalTADConfiguration(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateTADConfiguration(tADConfiguration, bl);
                    break;
                }
                case 15: {
                    float f2 = iDeserializer.getFloat();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateTADCurrentRollAngle(f2, bl);
                    break;
                }
                case 19: {
                    float f3 = iDeserializer.getFloat();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateTADPosMaxRollAngle(f3, bl);
                    break;
                }
                case 17: {
                    float f4 = iDeserializer.getFloat();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateTADNegMaxRollAngle(f4, bl);
                    break;
                }
                case 14: {
                    float f5 = iDeserializer.getFloat();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateTADCurrentPitchAngle(f5, bl);
                    break;
                }
                case 18: {
                    float f6 = iDeserializer.getFloat();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateTADPosMaxPitch(f6, bl);
                    break;
                }
                case 16: {
                    float f7 = iDeserializer.getFloat();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateTADNegMaxPitch(f7, bl);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateTADVisibilityState(n, bl);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateSuspensionControlCurrentLevel(n, bl);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateSuspensionControlTargetLevel(n, bl);
                    break;
                }
                case 13: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateSuspensionVisibilityState(nArray, bl);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateDriveSelectActiveProfile(n, bl);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarDrivingReply.updateDriveSelectActiveProfileVisibilityState(n, bl);
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

