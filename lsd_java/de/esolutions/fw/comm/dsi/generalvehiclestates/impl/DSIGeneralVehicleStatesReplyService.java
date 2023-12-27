/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.generalvehiclestates.DSIGeneralVehicleStatesReply;
import de.esolutions.fw.comm.dsi.generalvehiclestates.impl.AirbagDataSerializer;
import de.esolutions.fw.comm.dsi.generalvehiclestates.impl.TLOViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.generalvehiclestates.impl.TankInfoSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;

public class DSIGeneralVehicleStatesReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.generalvehiclestates.DSIGeneralVehicleStates");
    private static int dynamicHandle = 0;
    private DSIGeneralVehicleStatesReply p_DSIGeneralVehicleStatesReply;

    public DSIGeneralVehicleStatesReplyService(DSIGeneralVehicleStatesReply dSIGeneralVehicleStatesReply) {
        super(new ServiceInstanceID("be2f0709-0d19-5602-8c96-36664db9baa5", DSIGeneralVehicleStatesReplyService.nextDynamicHandle(), "1478b2dc-c598-51ec-96fc-05c4419eeba2", "dsi.generalvehiclestates.DSIGeneralVehicleStates"));
        this.p_DSIGeneralVehicleStatesReply = dSIGeneralVehicleStatesReply;
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
                case 8: {
                    AirbagData airbagData = AirbagDataSerializer.getOptionalAirbagData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateAirbagData(airbagData, n);
                    break;
                }
                case 28: {
                    TankInfo tankInfo = TankInfoSerializer.getOptionalTankInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateTankInfo(tankInfo, n);
                    break;
                }
                case 17: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateDimmedHeadlight(bl, n);
                    break;
                }
                case 7: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateAcousticParkingSystem(bl, n);
                    break;
                }
                case 31: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateReverseGear(bl, n);
                    break;
                }
                case 32: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateVehicleStandstill(bl, n);
                    break;
                }
                case 15: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateCarVelocityThreshold(bl, n);
                    break;
                }
                case 24: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateTVVelocityThreshold(bl, n);
                    break;
                }
                case 20: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateHDDVelocityThreshold(bl, n);
                    break;
                }
                case 12: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateBrowserSlideShowVelocityThreshold(bl, n);
                    break;
                }
                case 11: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateBrowserBordBookVelocityThreshold(bl, n);
                    break;
                }
                case 13: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateBrowserTravelAgentVelocityThreshold(bl, n);
                    break;
                }
                case 14: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateBrowserWebVelocityThreshold(bl, n);
                    break;
                }
                case 10: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateBWSVelocityThreshold(bl, n);
                    break;
                }
                case 23: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateRadiotextVelocityThreshold(bl, n);
                    break;
                }
                case 18: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateDisplayDayNightDesign(bl, n);
                    break;
                }
                case 9: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateBTBondingVelocityThreshold(bl, n);
                    break;
                }
                case 22: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateMessagingVelocityThreshold(bl, n);
                    break;
                }
                case 16: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateDestinationInputVelocityThreshold(bl, n);
                    break;
                }
                case 30: {
                    CarViewOption carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateDSSSViewOption(carViewOption, n);
                    break;
                }
                case 33: {
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateServiceKeyData(byArray, n);
                    break;
                }
                case 34: {
                    CarViewOption carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateServiceKeyViewOption(carViewOption, n);
                    break;
                }
                case 35: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updatePersonalizationStatus(bl, n, n2);
                    break;
                }
                case 39: {
                    TLOViewOptions tLOViewOptions = TLOViewOptionsSerializer.getOptionalTLOViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateTLOViewOptions(tLOViewOptions, n);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateEmergencyAssistVolLowering(n, n3);
                    break;
                }
                case 38: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateParkingBrake(bl, n);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateAppConnectTrigger(n, n4);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateSTPState(n, n5);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.updateAutomaticGearShiftTransMode(n, n6);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIGeneralVehicleStatesReply.asyncException(n, string, n7);
                    break;
                }
                case 26: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIGeneralVehicleStatesReply.yyIndication(string, string2);
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

