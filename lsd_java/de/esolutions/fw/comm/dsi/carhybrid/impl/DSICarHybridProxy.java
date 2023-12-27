/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carhybrid.DSICarHybrid;
import de.esolutions.fw.comm.dsi.carhybrid.DSICarHybridC;
import de.esolutions.fw.comm.dsi.carhybrid.DSICarHybridReply;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$1;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$10;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$11;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$12;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$13;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$14;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$15;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$16;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$17;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$18;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$2;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$3;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$4;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$5;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$6;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$7;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$8;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy$9;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
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
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public class DSICarHybridProxy
implements DSICarHybrid,
DSICarHybridC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carhybrid.DSICarHybrid");
    private Proxy proxy;

    public DSICarHybridProxy(int n, DSICarHybridReply dSICarHybridReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9944bcd7-b459-5760-a9db-0c4cfcdff553", n, "78efa6f4-d9c1-5ee2-ae03-237bc421fed4", "dsi.carhybrid.DSICarHybrid");
        DSICarHybridReplyService dSICarHybridReplyService = new DSICarHybridReplyService(dSICarHybridReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarHybridReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setBatteryControlImmediately(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)68, genericSerializable);
    }

    @Override
    public void setBatteryControlTimerState(BatteryControlProgrammedTimer batteryControlProgrammedTimer) {
        DSICarHybridProxy$1 dSICarHybridProxy$1 = new DSICarHybridProxy$1(this, batteryControlProgrammedTimer);
        this.proxy.remoteCallMethod((short)28, dSICarHybridProxy$1);
    }

    @Override
    public void setBatteryControlTimer(int n, int n2, int n3, int n4, int n5, int n6, BatteryControlWeekdays batteryControlWeekdays, int n7) {
        DSICarHybridProxy$2 dSICarHybridProxy$2 = new DSICarHybridProxy$2(this, n, n2, n3, n4, n5, n6, batteryControlWeekdays, n7);
        this.proxy.remoteCallMethod((short)83, dSICarHybridProxy$2);
    }

    @Override
    public void setBatteryControlSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)26, null);
    }

    @Override
    public void setHybridTargetRange(short s, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)104, genericSerializable);
    }

    @Override
    public void setHybridEnergyAssistControl(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)119, genericSerializable);
    }

    @Override
    public void requestBatteryControlProfileList(BatteryControlProfilesAH batteryControlProfilesAH) {
        DSICarHybridProxy$3 dSICarHybridProxy$3 = new DSICarHybridProxy$3(this, batteryControlProfilesAH);
        this.proxy.remoteCallMethod((short)131, dSICarHybridProxy$3);
    }

    @Override
    public void setBatteryControlProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        DSICarHybridProxy$4 dSICarHybridProxy$4 = new DSICarHybridProxy$4(this, batteryControlProfilesAH, batteryControlProfileRA0Array);
        this.proxy.remoteCallMethod((short)151, dSICarHybridProxy$4);
    }

    @Override
    public void setBatteryControlProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        DSICarHybridProxy$5 dSICarHybridProxy$5 = new DSICarHybridProxy$5(this, batteryControlProfilesAH, batteryControlProfileRA1Array);
        this.proxy.remoteCallMethod((short)152, dSICarHybridProxy$5);
    }

    @Override
    public void setBatteryControlProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        DSICarHybridProxy$6 dSICarHybridProxy$6 = new DSICarHybridProxy$6(this, batteryControlProfilesAH, batteryControlProfileRA2Array);
        this.proxy.remoteCallMethod((short)153, dSICarHybridProxy$6);
    }

    @Override
    public void setBatteryControlProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        DSICarHybridProxy$7 dSICarHybridProxy$7 = new DSICarHybridProxy$7(this, batteryControlProfilesAH, batteryControlProfileRA3Array);
        this.proxy.remoteCallMethod((short)154, dSICarHybridProxy$7);
    }

    @Override
    public void setBatteryControlProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        DSICarHybridProxy$8 dSICarHybridProxy$8 = new DSICarHybridProxy$8(this, batteryControlProfilesAH, batteryControlProfileRA4Array);
        this.proxy.remoteCallMethod((short)155, dSICarHybridProxy$8);
    }

    @Override
    public void setBatteryControlProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        DSICarHybridProxy$9 dSICarHybridProxy$9 = new DSICarHybridProxy$9(this, batteryControlProfilesAH, batteryControlProfileRA5Array);
        this.proxy.remoteCallMethod((short)156, dSICarHybridProxy$9);
    }

    @Override
    public void setBatteryControlProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        DSICarHybridProxy$10 dSICarHybridProxy$10 = new DSICarHybridProxy$10(this, batteryControlProfilesAH, batteryControlProfileRA6Array);
        this.proxy.remoteCallMethod((short)157, dSICarHybridProxy$10);
    }

    @Override
    public void setBatteryControlProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        DSICarHybridProxy$11 dSICarHybridProxy$11 = new DSICarHybridProxy$11(this, batteryControlProfilesAH, batteryControlProfileRA7Array);
        this.proxy.remoteCallMethod((short)158, dSICarHybridProxy$11);
    }

    @Override
    public void setBatteryControlProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        DSICarHybridProxy$12 dSICarHybridProxy$12 = new DSICarHybridProxy$12(this, batteryControlProfilesAH, nArray);
        this.proxy.remoteCallMethod((short)159, dSICarHybridProxy$12);
    }

    @Override
    public void setBatteryControlPowerProviderRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        DSICarHybridProxy$13 dSICarHybridProxy$13 = new DSICarHybridProxy$13(this, batteryControlPowerProviderAH, batteryControlPowerProviderRA0Array);
        this.proxy.remoteCallMethod((short)146, dSICarHybridProxy$13);
    }

    @Override
    public void setBatteryControlPowerProviderRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        DSICarHybridProxy$14 dSICarHybridProxy$14 = new DSICarHybridProxy$14(this, batteryControlPowerProviderAH, batteryControlPowerProviderRA1Array);
        this.proxy.remoteCallMethod((short)147, dSICarHybridProxy$14);
    }

    @Override
    public void setBatteryControlPowerProviderRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        DSICarHybridProxy$15 dSICarHybridProxy$15 = new DSICarHybridProxy$15(this, batteryControlPowerProviderAH, batteryControlPowerProviderRA2Array);
        this.proxy.remoteCallMethod((short)148, dSICarHybridProxy$15);
    }

    @Override
    public void setBatteryControlPowerProviderRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        DSICarHybridProxy$16 dSICarHybridProxy$16 = new DSICarHybridProxy$16(this, batteryControlPowerProviderAH, batteryControlPowerProviderRAEArray);
        this.proxy.remoteCallMethod((short)149, dSICarHybridProxy$16);
    }

    @Override
    public void setBatteryControlPowerProviderRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        DSICarHybridProxy$17 dSICarHybridProxy$17 = new DSICarHybridProxy$17(this, batteryControlPowerProviderAH, nArray);
        this.proxy.remoteCallMethod((short)150, dSICarHybridProxy$17);
    }

    @Override
    public void requestBatteryControlPowerProviderList(BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
        DSICarHybridProxy$18 dSICarHybridProxy$18 = new DSICarHybridProxy$18(this, batteryControlPowerProviderAH);
        this.proxy.remoteCallMethod((short)130, dSICarHybridProxy$18);
    }

    @Override
    public void setBatteryControlPastErrorReason(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)113, genericSerializable);
    }

    @Override
    public void setBatteryControlRemainingChargeTime(int n, short s, int n2, short s2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt16(s);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt16(s2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)118, genericSerializable);
    }

    @Override
    public void setHybridActivePedal(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)160, genericSerializable);
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
        this.proxy.remoteCallMethod((short)30, genericSerializable);
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
        this.proxy.remoteCallMethod((short)31, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)29, null);
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
        this.proxy.remoteCallMethod((short)51, genericSerializable);
    }
}

