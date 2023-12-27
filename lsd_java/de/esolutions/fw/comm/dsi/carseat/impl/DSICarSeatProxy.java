/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carseat.DSICarSeat;
import de.esolutions.fw.comm.dsi.carseat.DSICarSeatC;
import de.esolutions.fw.comm.dsi.carseat.DSICarSeatReply;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$1;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$10;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$11;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$12;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$13;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$2;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$3;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$4;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$5;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$6;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$7;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$8;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy$9;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public class DSICarSeatProxy
implements DSICarSeat,
DSICarSeatC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carseat.DSICarSeat");
    private Proxy proxy;

    public DSICarSeatProxy(int n, DSICarSeatReply dSICarSeatReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("976ded31-4347-5c8a-b0f7-4d6039c98f40", n, "6624341b-1b4d-57c4-90da-cc721454ffbb", "dsi.carseat.DSICarSeat");
        DSICarSeatReplyService dSICarSeatReplyService = new DSICarSeatReplyService(dSICarSeatReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarSeatReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setSeatRadioKeyAutomatic(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void setSeatCodriverSettingsFromRear(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setSeatCodriverSettingsFromDriver(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void setSeatEasyEntryFrontLeft(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void setSeatEasyEntryFrontRight(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void setSeatEasyEntryRearLeft(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void setSeatEasyEntryRearRight(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void setSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition) {
        DSICarSeatProxy$1 dSICarSeatProxy$1 = new DSICarSeatProxy$1(this, seatSpecialPosition);
        this.proxy.remoteCallMethod((short)18, dSICarSeatProxy$1);
    }

    @Override
    public void setSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition) {
        DSICarSeatProxy$2 dSICarSeatProxy$2 = new DSICarSeatProxy$2(this, seatSpecialPosition);
        this.proxy.remoteCallMethod((short)79, dSICarSeatProxy$2);
    }

    @Override
    public void showSeatPopup(SeatContent seatContent) {
        DSICarSeatProxy$3 dSICarSeatProxy$3 = new DSICarSeatProxy$3(this, seatContent);
        this.proxy.remoteCallMethod((short)85, dSICarSeatProxy$3);
    }

    @Override
    public void cancelSeatPopup(SeatContent seatContent, int n) {
        DSICarSeatProxy$4 dSICarSeatProxy$4 = new DSICarSeatProxy$4(this, seatContent, n);
        this.proxy.remoteCallMethod((short)72, dSICarSeatProxy$4);
    }

    @Override
    public void setSeatHMIIsReady(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void setSeatPneumaticCodriverSettingsFromDriver(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)49, genericSerializable);
    }

    @Override
    public void showSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        DSICarSeatProxy$5 dSICarSeatProxy$5 = new DSICarSeatProxy$5(this, seatPneumaticContent);
        this.proxy.remoteCallMethod((short)52, dSICarSeatProxy$5);
    }

    @Override
    public void cancelSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent, int n) {
        DSICarSeatProxy$6 dSICarSeatProxy$6 = new DSICarSeatProxy$6(this, seatPneumaticContent, n);
        this.proxy.remoteCallMethod((short)47, dSICarSeatProxy$6);
    }

    @Override
    public void setSeatSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)51, null);
    }

    @Override
    public void setSeatPneumaticSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)50, null);
    }

    @Override
    public void startSeatMoveRearSeatDisplay() {
        this.proxy.remoteCallMethod((short)87, null);
    }

    @Override
    public void abortSeatMoveRearSeatDisplay() {
        this.proxy.remoteCallMethod((short)68, null);
    }

    @Override
    public void setSeatMassageData(int n, MassageData massageData) {
        DSICarSeatProxy$7 dSICarSeatProxy$7 = new DSICarSeatProxy$7(this, n, massageData);
        this.proxy.remoteCallMethod((short)128, dSICarSeatProxy$7);
    }

    @Override
    public void setSeatSwitcherDataUp(int n, SwitcherDataUpDown switcherDataUpDown) {
        DSICarSeatProxy$8 dSICarSeatProxy$8 = new DSICarSeatProxy$8(this, n, switcherDataUpDown);
        this.proxy.remoteCallMethod((short)133, dSICarSeatProxy$8);
    }

    @Override
    public void setSeatSwitcherDataDown(int n, SwitcherDataUpDown switcherDataUpDown) {
        DSICarSeatProxy$9 dSICarSeatProxy$9 = new DSICarSeatProxy$9(this, n, switcherDataUpDown);
        this.proxy.remoteCallMethod((short)132, dSICarSeatProxy$9);
    }

    @Override
    public void setSeatSwitcherDataForward(int n, SwitcherDataBackForward switcherDataBackForward) {
        DSICarSeatProxy$10 dSICarSeatProxy$10 = new DSICarSeatProxy$10(this, n, switcherDataBackForward);
        this.proxy.remoteCallMethod((short)83, dSICarSeatProxy$10);
    }

    @Override
    public void setSeatSwitcherDataBack(int n, SwitcherDataBackForward switcherDataBackForward) {
        DSICarSeatProxy$11 dSICarSeatProxy$11 = new DSICarSeatProxy$11(this, n, switcherDataBackForward);
        this.proxy.remoteCallMethod((short)81, dSICarSeatProxy$11);
    }

    @Override
    public void setSeatAdjustment(int n, SeatAdjustment seatAdjustment) {
        DSICarSeatProxy$12 dSICarSeatProxy$12 = new DSICarSeatProxy$12(this, n, seatAdjustment);
        this.proxy.remoteCallMethod((short)74, dSICarSeatProxy$12);
    }

    @Override
    public void startSeatDeleteSpecialPosition(boolean bl, boolean bl2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)86, genericSerializable);
    }

    @Override
    public void setSeatCoDriverSettingsFromRearActivation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)75, genericSerializable);
    }

    @Override
    public void setSeatFoldHeadRestRearDriver(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)77, genericSerializable);
    }

    @Override
    public void setSeatFoldHeadRestRearCoDriver(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)76, genericSerializable);
    }

    @Override
    public void setSeatStopButton(int n, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)80, genericSerializable);
    }

    @Override
    public void setSeatPremiumMassageData(int n, MassageData massageData) {
        DSICarSeatProxy$13 dSICarSeatProxy$13 = new DSICarSeatProxy$13(this, n, massageData);
        this.proxy.remoteCallMethod((short)130, dSICarSeatProxy$13);
    }

    @Override
    public void setSeatPremiumMassageSwitcher(int n, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)131, genericSerializable);
    }

    @Override
    public void setSeatMassageSwitcher(int n, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)129, genericSerializable);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)7, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)3, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }
}

