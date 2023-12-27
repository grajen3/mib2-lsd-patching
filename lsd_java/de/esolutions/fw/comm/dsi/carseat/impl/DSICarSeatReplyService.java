/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carseat.DSICarSeatReply;
import de.esolutions.fw.comm.dsi.carseat.impl.MassageDataSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.RestSeatStatusSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatAdjustmentSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatContentSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatPneumaticContentSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatPneumaticViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatSpecialPositionSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SwitcherDataBackForwardSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SwitcherDataUpDownSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.RestSeatStatus;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public class DSICarSeatReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carseat.DSICarSeat");
    private static int dynamicHandle = 0;
    private DSICarSeatReply p_DSICarSeatReply;

    public DSICarSeatReplyService(DSICarSeatReply dSICarSeatReply) {
        super(new ServiceInstanceID("21b97a0b-812b-5d11-a709-028b7bf33cd2", DSICarSeatReplyService.nextDynamicHandle(), "b7b75143-6736-5b96-9460-67acad1509d9", "dsi.carseat.DSICarSeat"));
        this.p_DSICarSeatReply = dSICarSeatReply;
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
                case 166: {
                    SeatViewOptions seatViewOptions = SeatViewOptionsSerializer.getOptionalSeatViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatViewOptions(seatViewOptions, n);
                    break;
                }
                case 31: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatRadioKeyAutomatic(bl, n);
                    break;
                }
                case 32: {
                    SeatSpecialPosition seatSpecialPosition = SeatSpecialPositionSerializer.getOptionalSeatSpecialPosition(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSpecialPosition(seatSpecialPosition, n);
                    break;
                }
                case 110: {
                    SeatSpecialPosition seatSpecialPosition = SeatSpecialPositionSerializer.getOptionalSeatSpecialPosition(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSpecialPositionRearCoDriver(seatSpecialPosition, n);
                    break;
                }
                case 27: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatFrontLeftStopButton(bl, n);
                    break;
                }
                case 28: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatFrontRightStopButton(bl, n);
                    break;
                }
                case 107: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatRearLeftStopButton(bl, n);
                    break;
                }
                case 108: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatRearRightStopButton(bl, n);
                    break;
                }
                case 20: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatCodriverSettingsFromDriver(bl, n);
                    break;
                }
                case 21: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatCodriverSettingsFromRear(bl, n);
                    break;
                }
                case 134: {
                    MassageData massageData = MassageDataSerializer.getOptionalMassageData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatMassageData1RL(massageData, n);
                    break;
                }
                case 135: {
                    MassageData massageData = MassageDataSerializer.getOptionalMassageData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatMassageData1RR(massageData, n);
                    break;
                }
                case 136: {
                    MassageData massageData = MassageDataSerializer.getOptionalMassageData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatMassageData2RL(massageData, n);
                    break;
                }
                case 137: {
                    MassageData massageData = MassageDataSerializer.getOptionalMassageData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatMassageData2RR(massageData, n);
                    break;
                }
                case 162: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataUp1RL(switcherDataUpDown, n);
                    break;
                }
                case 158: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataDown1RL(switcherDataUpDown, n);
                    break;
                }
                case 119: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataForward1RL(switcherDataBackForward, n);
                    break;
                }
                case 111: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataBack1RL(switcherDataBackForward, n);
                    break;
                }
                case 163: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataUp1RR(switcherDataUpDown, n);
                    break;
                }
                case 159: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataDown1RR(switcherDataUpDown, n);
                    break;
                }
                case 120: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataForward1RR(switcherDataBackForward, n);
                    break;
                }
                case 112: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataBack1RR(switcherDataBackForward, n);
                    break;
                }
                case 164: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataUp2RL(switcherDataUpDown, n);
                    break;
                }
                case 160: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataDown2RL(switcherDataUpDown, n);
                    break;
                }
                case 121: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataForward2RL(switcherDataBackForward, n);
                    break;
                }
                case 113: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataBack2RL(switcherDataBackForward, n);
                    break;
                }
                case 165: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataUp2RR(switcherDataUpDown, n);
                    break;
                }
                case 161: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataDown2RR(switcherDataUpDown, n);
                    break;
                }
                case 122: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataForward2RR(switcherDataBackForward, n);
                    break;
                }
                case 114: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatSwitcherDataBack2RR(switcherDataBackForward, n);
                    break;
                }
                case 93: {
                    SeatContent seatContent = SeatContentSerializer.getOptionalSeatContent(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatContent(seatContent, n);
                    break;
                }
                case 23: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatEasyEntryFrontLeft(bl, n);
                    break;
                }
                case 24: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatEasyEntryFrontRight(bl, n);
                    break;
                }
                case 25: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatEasyEntryRearLeft(bl, n);
                    break;
                }
                case 26: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatEasyEntryRearRight(bl, n);
                    break;
                }
                case 73: {
                    SeatContent seatContent = SeatContentSerializer.getOptionalSeatContent(iDeserializer);
                    this.p_DSICarSeatReply.requestSeatPopup(seatContent);
                    break;
                }
                case 71: {
                    SeatContent seatContent = SeatContentSerializer.getOptionalSeatContent(iDeserializer);
                    this.p_DSICarSeatReply.acknowledgeSeatPopup(seatContent);
                    break;
                }
                case 148: {
                    SeatPneumaticViewOptions seatPneumaticViewOptions = SeatPneumaticViewOptionsSerializer.getOptionalSeatPneumaticViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticViewOptions(seatPneumaticViewOptions, n);
                    break;
                }
                case 53: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticCodriverSettingsFromDriver(bl, n);
                    break;
                }
                case 142: {
                    MassageData massageData = MassageDataSerializer.getOptionalMassageData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticMassageData1RL(massageData, n);
                    break;
                }
                case 143: {
                    MassageData massageData = MassageDataSerializer.getOptionalMassageData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticMassageData1RR(massageData, n);
                    break;
                }
                case 146: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticSwitcherDataUp1RL(switcherDataUpDown, n);
                    break;
                }
                case 144: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticSwitcherDataDown1RL(switcherDataUpDown, n);
                    break;
                }
                case 102: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticSwitcherDataForward1RL(switcherDataBackForward, n);
                    break;
                }
                case 98: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticSwitcherDataBack1RL(switcherDataBackForward, n);
                    break;
                }
                case 147: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticSwitcherDataUp1RR(switcherDataUpDown, n);
                    break;
                }
                case 145: {
                    SwitcherDataUpDown switcherDataUpDown = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticSwitcherDataDown1RR(switcherDataUpDown, n);
                    break;
                }
                case 103: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticSwitcherDataForward1RR(switcherDataBackForward, n);
                    break;
                }
                case 99: {
                    SwitcherDataBackForward switcherDataBackForward = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticSwitcherDataBack1RR(switcherDataBackForward, n);
                    break;
                }
                case 54: {
                    SeatPneumaticContent seatPneumaticContent = SeatPneumaticContentSerializer.getOptionalSeatPneumaticContent(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPneumaticContent(seatPneumaticContent, n);
                    break;
                }
                case 48: {
                    SeatPneumaticContent seatPneumaticContent = SeatPneumaticContentSerializer.getOptionalSeatPneumaticContent(iDeserializer);
                    this.p_DSICarSeatReply.requestSeatPneumaticPopup(seatPneumaticContent);
                    break;
                }
                case 44: {
                    SeatPneumaticContent seatPneumaticContent = SeatPneumaticContentSerializer.getOptionalSeatPneumaticContent(iDeserializer);
                    this.p_DSICarSeatReply.acknowledgeSeatPneumaticPopup(seatPneumaticContent);
                    break;
                }
                case 46: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarSeatReply.acknowledgeSeatSetFactoryDefault(bl);
                    break;
                }
                case 45: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarSeatReply.acknowledgeSeatPneumaticSetFactoryDefault(bl);
                    break;
                }
                case 69: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarSeatReply.acknowledgeSeatDeleteSpecialPosition(bl);
                    break;
                }
                case 70: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarSeatReply.acknowledgeSeatMoveRearSeatDisplay(bl);
                    break;
                }
                case 88: {
                    SeatAdjustment seatAdjustment = SeatAdjustmentSerializer.getOptionalSeatAdjustment(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatAdjustment1RL(seatAdjustment, n);
                    break;
                }
                case 89: {
                    SeatAdjustment seatAdjustment = SeatAdjustmentSerializer.getOptionalSeatAdjustment(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatAdjustment1RR(seatAdjustment, n);
                    break;
                }
                case 90: {
                    SeatAdjustment seatAdjustment = SeatAdjustmentSerializer.getOptionalSeatAdjustment(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatAdjustment2RL(seatAdjustment, n);
                    break;
                }
                case 91: {
                    SeatAdjustment seatAdjustment = SeatAdjustmentSerializer.getOptionalSeatAdjustment(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatAdjustment2RR(seatAdjustment, n);
                    break;
                }
                case 92: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatCoDriverSettingsFromRearActivation(bl, n);
                    break;
                }
                case 157: {
                    RestSeatStatus restSeatStatus = RestSeatStatusSerializer.getOptionalRestSeatStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatRestSeatStatus(restSeatStatus, n);
                    break;
                }
                case 95: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatFoldHeadRestRearDriver(bl, n);
                    break;
                }
                case 94: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatFoldHeadRestRearCoDriver(bl, n);
                    break;
                }
                case 149: {
                    MassageData massageData = MassageDataSerializer.getOptionalMassageData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPremiumMassageData1RL(massageData, n);
                    break;
                }
                case 150: {
                    MassageData massageData = MassageDataSerializer.getOptionalMassageData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPremiumMassageData1RR(massageData, n);
                    break;
                }
                case 151: {
                    MassageData massageData = MassageDataSerializer.getOptionalMassageData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPremiumMassageData2RL(massageData, n);
                    break;
                }
                case 152: {
                    MassageData massageData = MassageDataSerializer.getOptionalMassageData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPremiumMassageData2RR(massageData, n);
                    break;
                }
                case 153: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPremiumMassageSwitcher1RL(bl, n);
                    break;
                }
                case 154: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPremiumMassageSwitcher1RR(bl, n);
                    break;
                }
                case 155: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPremiumMassageSwitcher2RL(bl, n);
                    break;
                }
                case 156: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatPremiumMassageSwitcher2RR(bl, n);
                    break;
                }
                case 138: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatMassageSwitcher1RL(bl, n);
                    break;
                }
                case 139: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatMassageSwitcher1RR(bl, n);
                    break;
                }
                case 140: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatMassageSwitcher2RL(bl, n);
                    break;
                }
                case 141: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.updateSeatMassageSwitcher2RR(bl, n);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarSeatReply.asyncException(n, string, n2);
                    break;
                }
                case 42: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarSeatReply.yyIndication(string, string2);
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

