/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carhybrid.DSICarHybridReply;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlChargeStateSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlClimateStateSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPlugSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRA0Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRA1Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRA2Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRAESerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA0Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA1Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA2Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA3Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA4Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA5Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA6Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA7Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfilesAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlRemainingChargeTimeSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlTimerSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlTimerStateSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.HybridEnergyFlowStateSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.HybridInhibitReasonSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.HybridTargetRangeSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.HybridViewOptionsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlPlug;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlRemainingChargeTime;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridInhibitReason;
import org.dsi.ifc.carhybrid.HybridTargetRange;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public class DSICarHybridReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carhybrid.DSICarHybrid");
    private static int dynamicHandle = 0;
    private DSICarHybridReply p_DSICarHybridReply;

    public DSICarHybridReplyService(DSICarHybridReply dSICarHybridReply) {
        super(new ServiceInstanceID("023777d7-a4e9-5bf7-aab8-23522ef8034c", DSICarHybridReplyService.nextDynamicHandle(), "bd73133f-ab5d-5ae5-bf96-1d21680fa177", "dsi.carhybrid.DSICarHybrid"));
        this.p_DSICarHybridReply = dSICarHybridReply;
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
                case 165: {
                    HybridViewOptions hybridViewOptions = HybridViewOptionsSerializer.getOptionalHybridViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateHybridViewOptions(hybridViewOptions, n);
                    break;
                }
                case 92: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateHybridCharge(n, n2);
                    break;
                }
                case 47: {
                    HybridEnergyFlowState hybridEnergyFlowState = HybridEnergyFlowStateSerializer.getOptionalHybridEnergyFlowState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateHybridEnergyFlowState(hybridEnergyFlowState, n);
                    break;
                }
                case 94: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateHybridRecoveredEnergy(n, n3);
                    break;
                }
                case 93: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateHybridEnergyFlow(n, n4);
                    break;
                }
                case 127: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateHybridEnergyAssistControl(bl, n);
                    break;
                }
                case 128: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateHybridEnergyAssistState(n, n5);
                    break;
                }
                case 126: {
                    BatteryControlViewOptions batteryControlViewOptions = BatteryControlViewOptionsSerializer.getOptionalBatteryControlViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlViewOptions(batteryControlViewOptions, n);
                    break;
                }
                case 86: {
                    BatteryControlPlug batteryControlPlug = BatteryControlPlugSerializer.getOptionalBatteryControlPlug(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlPlug(batteryControlPlug, n);
                    break;
                }
                case 120: {
                    BatteryControlChargeState batteryControlChargeState = BatteryControlChargeStateSerializer.getOptionalBatteryControlChargeState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlChargeState(batteryControlChargeState, n);
                    break;
                }
                case 121: {
                    BatteryControlClimateState batteryControlClimateState = BatteryControlClimateStateSerializer.getOptionalBatteryControlClimateState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlClimateState(batteryControlClimateState, n);
                    break;
                }
                case 41: {
                    BatteryControlTimerState batteryControlTimerState = BatteryControlTimerStateSerializer.getOptionalBatteryControlTimerState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlTimerState(batteryControlTimerState, n);
                    break;
                }
                case 87: {
                    BatteryControlTimer batteryControlTimer = BatteryControlTimerSerializer.getOptionalBatteryControlTimer(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlTimer1(batteryControlTimer, n);
                    break;
                }
                case 88: {
                    BatteryControlTimer batteryControlTimer = BatteryControlTimerSerializer.getOptionalBatteryControlTimer(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlTimer2(batteryControlTimer, n);
                    break;
                }
                case 89: {
                    BatteryControlTimer batteryControlTimer = BatteryControlTimerSerializer.getOptionalBatteryControlTimer(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlTimer3(batteryControlTimer, n);
                    break;
                }
                case 90: {
                    BatteryControlTimer batteryControlTimer = BatteryControlTimerSerializer.getOptionalBatteryControlTimer(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlTimer4(batteryControlTimer, n);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlTotalNumberOfProfiles(n, n6);
                    break;
                }
                case 162: {
                    BatteryControlProfilesAH batteryControlProfilesAH = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlProfilesListUpdateInfo(batteryControlProfilesAH, nArray, n);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlTotalNumberOfPowerProvider(n, n7);
                    break;
                }
                case 161: {
                    BatteryControlPowerProviderAH batteryControlPowerProviderAH = BatteryControlPowerProviderAHSerializer.getOptionalBatteryControlPowerProviderAH(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlPowerProviderListUpdateInfo(batteryControlPowerProviderAH, nArray, n);
                    break;
                }
                case 1: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarHybridReply.acknowledgeBatteryControlSetFactoryDefault(bl);
                    break;
                }
                case 52: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.acknowledgeBatteryControlImmediately(bl, n);
                    break;
                }
                case 137: {
                    BatteryControlProfilesAH batteryControlProfilesAH = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
                    BatteryControlProfileRA0[] batteryControlProfileRA0Array = BatteryControlProfileRA0Serializer.getOptionalBatteryControlProfileRA0VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responseProfileListRA0(batteryControlProfilesAH, batteryControlProfileRA0Array);
                    break;
                }
                case 138: {
                    BatteryControlProfilesAH batteryControlProfilesAH = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
                    BatteryControlProfileRA1[] batteryControlProfileRA1Array = BatteryControlProfileRA1Serializer.getOptionalBatteryControlProfileRA1VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responseProfileListRA1(batteryControlProfilesAH, batteryControlProfileRA1Array);
                    break;
                }
                case 139: {
                    BatteryControlProfilesAH batteryControlProfilesAH = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
                    BatteryControlProfileRA2[] batteryControlProfileRA2Array = BatteryControlProfileRA2Serializer.getOptionalBatteryControlProfileRA2VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responseProfileListRA2(batteryControlProfilesAH, batteryControlProfileRA2Array);
                    break;
                }
                case 140: {
                    BatteryControlProfilesAH batteryControlProfilesAH = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
                    BatteryControlProfileRA3[] batteryControlProfileRA3Array = BatteryControlProfileRA3Serializer.getOptionalBatteryControlProfileRA3VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responseProfileListRA3(batteryControlProfilesAH, batteryControlProfileRA3Array);
                    break;
                }
                case 141: {
                    BatteryControlProfilesAH batteryControlProfilesAH = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
                    BatteryControlProfileRA4[] batteryControlProfileRA4Array = BatteryControlProfileRA4Serializer.getOptionalBatteryControlProfileRA4VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responseProfileListRA4(batteryControlProfilesAH, batteryControlProfileRA4Array);
                    break;
                }
                case 142: {
                    BatteryControlProfilesAH batteryControlProfilesAH = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
                    BatteryControlProfileRA5[] batteryControlProfileRA5Array = BatteryControlProfileRA5Serializer.getOptionalBatteryControlProfileRA5VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responseProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
                    break;
                }
                case 143: {
                    BatteryControlProfilesAH batteryControlProfilesAH = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
                    BatteryControlProfileRA6[] batteryControlProfileRA6Array = BatteryControlProfileRA6Serializer.getOptionalBatteryControlProfileRA6VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responseProfileListRA6(batteryControlProfilesAH, batteryControlProfileRA6Array);
                    break;
                }
                case 144: {
                    BatteryControlProfilesAH batteryControlProfilesAH = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
                    BatteryControlProfileRA7[] batteryControlProfileRA7Array = BatteryControlProfileRA7Serializer.getOptionalBatteryControlProfileRA7VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responseProfileListRA7(batteryControlProfilesAH, batteryControlProfileRA7Array);
                    break;
                }
                case 145: {
                    BatteryControlProfilesAH batteryControlProfilesAH = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICarHybridReply.responseProfileListRAF(batteryControlProfilesAH, nArray);
                    break;
                }
                case 132: {
                    BatteryControlPowerProviderAH batteryControlPowerProviderAH = BatteryControlPowerProviderAHSerializer.getOptionalBatteryControlPowerProviderAH(iDeserializer);
                    BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array = BatteryControlPowerProviderRA0Serializer.getOptionalBatteryControlPowerProviderRA0VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responsePowerProviderListRA0(batteryControlPowerProviderAH, batteryControlPowerProviderRA0Array);
                    break;
                }
                case 133: {
                    BatteryControlPowerProviderAH batteryControlPowerProviderAH = BatteryControlPowerProviderAHSerializer.getOptionalBatteryControlPowerProviderAH(iDeserializer);
                    BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array = BatteryControlPowerProviderRA1Serializer.getOptionalBatteryControlPowerProviderRA1VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responsePowerProviderListRA1(batteryControlPowerProviderAH, batteryControlPowerProviderRA1Array);
                    break;
                }
                case 134: {
                    BatteryControlPowerProviderAH batteryControlPowerProviderAH = BatteryControlPowerProviderAHSerializer.getOptionalBatteryControlPowerProviderAH(iDeserializer);
                    BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array = BatteryControlPowerProviderRA2Serializer.getOptionalBatteryControlPowerProviderRA2VarArray(iDeserializer);
                    this.p_DSICarHybridReply.responsePowerProviderListRA2(batteryControlPowerProviderAH, batteryControlPowerProviderRA2Array);
                    break;
                }
                case 135: {
                    BatteryControlPowerProviderAH batteryControlPowerProviderAH = BatteryControlPowerProviderAHSerializer.getOptionalBatteryControlPowerProviderAH(iDeserializer);
                    BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray = BatteryControlPowerProviderRAESerializer.getOptionalBatteryControlPowerProviderRAEVarArray(iDeserializer);
                    this.p_DSICarHybridReply.responsePowerProviderListRAE(batteryControlPowerProviderAH, batteryControlPowerProviderRAEArray);
                    break;
                }
                case 136: {
                    BatteryControlPowerProviderAH batteryControlPowerProviderAH = BatteryControlPowerProviderAHSerializer.getOptionalBatteryControlPowerProviderAH(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICarHybridReply.responsePowerProviderListRAF(batteryControlPowerProviderAH, nArray);
                    break;
                }
                case 106: {
                    HybridTargetRange hybridTargetRange = HybridTargetRangeSerializer.getOptionalHybridTargetRange(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateHybridTargetRange(hybridTargetRange, n);
                    break;
                }
                case 123: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlPastErrorReason(n, n8, n9, n10);
                    break;
                }
                case 124: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlPlugDisplayState(n, n11, n12);
                    break;
                }
                case 125: {
                    BatteryControlRemainingChargeTime batteryControlRemainingChargeTime = BatteryControlRemainingChargeTimeSerializer.getOptionalBatteryControlRemainingChargeTime(iDeserializer);
                    BatteryControlRemainingChargeTime batteryControlRemainingChargeTime2 = BatteryControlRemainingChargeTimeSerializer.getOptionalBatteryControlRemainingChargeTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlRemainingChargeTime(batteryControlRemainingChargeTime, batteryControlRemainingChargeTime2, n);
                    break;
                }
                case 122: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateBatteryControlLowestMaxCurrent(n, n13);
                    break;
                }
                case 164: {
                    HybridInhibitReason hybridInhibitReason = HybridInhibitReasonSerializer.getOptionalHybridInhibitReason(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateHybridInhibitReason(hybridInhibitReason, n);
                    break;
                }
                case 163: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.updateHybridActivePedal(bl, n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSICarHybridReply.asyncException(n, string, n14);
                    break;
                }
                case 50: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarHybridReply.yyIndication(string, string2);
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

