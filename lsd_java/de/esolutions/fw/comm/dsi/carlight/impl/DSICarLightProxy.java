/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carlight.DSICarLight;
import de.esolutions.fw.comm.dsi.carlight.DSICarLightC;
import de.esolutions.fw.comm.dsi.carlight.DSICarLightReply;
import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy$1;
import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy$2;
import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy$3;
import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy$4;
import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy$5;
import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy$6;
import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy$7;
import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public class DSICarLightProxy
implements DSICarLight,
DSICarLightC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carlight.DSICarLight");
    private Proxy proxy;

    public DSICarLightProxy(int n, DSICarLightReply dSICarLightReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("306b3d3d-c83e-51c7-938d-adf19a205555", n, "7615dcac-3068-5a0b-8757-307f1ecbad6a", "dsi.carlight.DSICarLight");
        DSICarLightReplyService dSICarLightReplyService = new DSICarLightReplyService(dSICarLightReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarLightReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setExtLightComingHome(TimeState timeState) {
        DSICarLightProxy$1 dSICarLightProxy$1 = new DSICarLightProxy$1(this, timeState);
        this.proxy.remoteCallMethod((short)8, dSICarLightProxy$1);
    }

    @Override
    public void setExtLightLeavingHome(TimeState timeState) {
        DSICarLightProxy$2 dSICarLightProxy$2 = new DSICarLightProxy$2(this, timeState);
        this.proxy.remoteCallMethod((short)12, dSICarLightProxy$2);
    }

    @Override
    public void setExtLightSwitchOnSensitivity(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void setExtLightDayLight(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void setExtLightHeadLightSystem(boolean bl) {
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
    public void setExtLightGlidingLightSystem(boolean bl) {
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
    public void setExtLightAdaptive(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void setExtLightTourist(boolean bl) {
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
    public void setExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings) {
        DSICarLightProxy$3 dSICarLightProxy$3 = new DSICarLightProxy$3(this, motorwayBlinkingSettings);
        this.proxy.remoteCallMethod((short)14, dSICarLightProxy$3);
    }

    @Override
    public void setExtLightMaskedHighBeam(boolean bl) {
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
    public void setExtLightAutomaticLight(boolean bl, boolean bl2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void setExtLightSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)15, null);
    }

    @Override
    public void setExtLightLaserLight(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)89, genericSerializable);
    }

    @Override
    public void setExtLightSignatureLight(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)96, genericSerializable);
    }

    @Override
    public void setExtLightHeadlightRange(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)95, genericSerializable);
    }

    @Override
    public void setIntLightIlluminationSet(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void setIntLightColour(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void setIntLightState(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    @Override
    public void setIntLightEnvironment(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void setIntLightSpeed(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    @Override
    public void setIntLightTemperature(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    @Override
    public void setIntLightBrightness(IntLightBrightness intLightBrightness) {
        DSICarLightProxy$4 dSICarLightProxy$4 = new DSICarLightProxy$4(this, intLightBrightness);
        this.proxy.remoteCallMethod((short)85, dSICarLightProxy$4);
    }

    @Override
    public void setIntLightSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)22, null);
    }

    @Override
    public void setIntLightIlluminationProfile(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)69, genericSerializable);
    }

    @Override
    public void setIntLightActiveProfile(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)65, genericSerializable);
    }

    @Override
    public void setIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues) {
        DSICarLightProxy$5 dSICarLightProxy$5 = new DSICarLightProxy$5(this, intLightRGBValues);
        this.proxy.remoteCallMethod((short)66, dSICarLightProxy$5);
    }

    @Override
    public void setIntLightContourLightColor(IntLightRGBValues intLightRGBValues) {
        DSICarLightProxy$6 dSICarLightProxy$6 = new DSICarLightProxy$6(this, intLightRGBValues);
        this.proxy.remoteCallMethod((short)67, dSICarLightProxy$6);
    }

    @Override
    public void setIntLightFollowUpTime(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)68, genericSerializable);
    }

    @Override
    public void setIntLightDoorContact(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)92, genericSerializable);
    }

    @Override
    public void requestIntLightRGBColorList(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        DSICarLightProxy$7 dSICarLightProxy$7 = new DSICarLightProxy$7(this, intLightRGBColorListUpdateInfo);
        this.proxy.remoteCallMethod((short)62, dSICarLightProxy$7);
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
        this.proxy.remoteCallMethod((short)27, genericSerializable);
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
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)26, null);
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
        this.proxy.remoteCallMethod((short)61, genericSerializable);
    }
}

