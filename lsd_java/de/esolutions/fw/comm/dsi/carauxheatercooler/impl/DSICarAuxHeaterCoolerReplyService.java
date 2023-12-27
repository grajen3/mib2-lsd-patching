/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carauxheatercooler.DSICarAuxHeaterCoolerReply;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerErrorReasonSerializer;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerExtendedConditioningSerializer;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerModeSerializer;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerTimerSerializer;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCTemperatureSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.global.CarBCTemperature;

public class DSICarAuxHeaterCoolerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carauxheatercooler.DSICarAuxHeaterCooler");
    private static int dynamicHandle = 0;
    private DSICarAuxHeaterCoolerReply p_DSICarAuxHeaterCoolerReply;

    public DSICarAuxHeaterCoolerReplyService(DSICarAuxHeaterCoolerReply dSICarAuxHeaterCoolerReply) {
        super(new ServiceInstanceID("2c84d2cf-fe11-563b-afb2-bf49ce13acf7", DSICarAuxHeaterCoolerReplyService.nextDynamicHandle(), "1145f0e8-59ff-5294-8be0-cf7da5c0d921", "dsi.carauxheatercooler.DSICarAuxHeaterCooler"));
        this.p_DSICarAuxHeaterCoolerReply = dSICarAuxHeaterCoolerReply;
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
                case 50: {
                    AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions = AuxHeaterCoolerViewOptionsSerializer.getOptionalAuxHeaterCoolerViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerViewOptions(auxHeaterCoolerViewOptions, n);
                    break;
                }
                case 35: {
                    AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason = AuxHeaterCoolerErrorReasonSerializer.getOptionalAuxHeaterCoolerErrorReason(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerCurrentHeaterState(auxHeaterCoolerErrorReason, n);
                    break;
                }
                case 36: {
                    AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason = AuxHeaterCoolerErrorReasonSerializer.getOptionalAuxHeaterCoolerErrorReason(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerErrorReason(auxHeaterCoolerErrorReason, n);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerState(n, n2);
                    break;
                }
                case 25: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerOnOff(bl, n);
                    break;
                }
                case 26: {
                    short s2 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerRemainingTime(s2, n);
                    break;
                }
                case 27: {
                    short s3 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerRunningTime(s3, n);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerMode(n, n3);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerDefaultStartMode(n, n4);
                    break;
                }
                case 21: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerEngineHeater(bl, n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerActiveTimer(n, n5);
                    break;
                }
                case 29: {
                    AuxHeaterCoolerTimer auxHeaterCoolerTimer = AuxHeaterCoolerTimerSerializer.getOptionalAuxHeaterCoolerTimer(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerTimer1(auxHeaterCoolerTimer, n);
                    break;
                }
                case 30: {
                    AuxHeaterCoolerTimer auxHeaterCoolerTimer = AuxHeaterCoolerTimerSerializer.getOptionalAuxHeaterCoolerTimer(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerTimer2(auxHeaterCoolerTimer, n);
                    break;
                }
                case 31: {
                    AuxHeaterCoolerTimer auxHeaterCoolerTimer = AuxHeaterCoolerTimerSerializer.getOptionalAuxHeaterCoolerTimer(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerTimer3(auxHeaterCoolerTimer, n);
                    break;
                }
                case 0: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarAuxHeaterCoolerReply.acknowledgeAuxHeaterSetFactoryDefault(bl);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerPopup(n, n6);
                    break;
                }
                case 45: {
                    AuxHeaterCoolerMode auxHeaterCoolerMode = AuxHeaterCoolerModeSerializer.getOptionalAuxHeaterCoolerMode(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerMode2(auxHeaterCoolerMode, n);
                    break;
                }
                case 44: {
                    AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning = AuxHeaterCoolerExtendedConditioningSerializer.getOptionalAuxHeaterCoolerExtendedConditioning(iDeserializer);
                    AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning2 = AuxHeaterCoolerExtendedConditioningSerializer.getOptionalAuxHeaterCoolerExtendedConditioning(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerExtendedConditioning(auxHeaterCoolerExtendedConditioning, auxHeaterCoolerExtendedConditioning2, n);
                    break;
                }
                case 49: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerWindowHeating(bl, bl2, n);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerUnlockClimating(n, n7);
                    break;
                }
                case 47: {
                    CarBCTemperature carBCTemperature = CarBCTemperatureSerializer.getOptionalCarBCTemperature(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerTargetTemperature(carBCTemperature, n);
                    break;
                }
                case 43: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl3 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.updateAuxHeaterCoolerAirQuality(bl, bl3, n);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSICarAuxHeaterCoolerReply.asyncException(n, string, n8);
                    break;
                }
                case 33: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarAuxHeaterCoolerReply.yyIndication(string, string2);
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

