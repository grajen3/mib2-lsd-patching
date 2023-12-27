/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carauxheatercooler.DSICarAuxHeaterCooler;
import de.esolutions.fw.comm.dsi.carauxheatercooler.DSICarAuxHeaterCoolerC;
import de.esolutions.fw.comm.dsi.carauxheatercooler.DSICarAuxHeaterCoolerReply;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.DSICarAuxHeaterCoolerProxy$1;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.DSICarAuxHeaterCoolerProxy$2;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.DSICarAuxHeaterCoolerProxy$3;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.DSICarAuxHeaterCoolerProxy$4;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.DSICarAuxHeaterCoolerReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;

public class DSICarAuxHeaterCoolerProxy
implements DSICarAuxHeaterCooler,
DSICarAuxHeaterCoolerC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carauxheatercooler.DSICarAuxHeaterCooler");
    private Proxy proxy;

    public DSICarAuxHeaterCoolerProxy(int n, DSICarAuxHeaterCoolerReply dSICarAuxHeaterCoolerReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("b8841165-76a0-5918-9127-09550decc09b", n, "4b52ea2b-e87d-526f-bc2b-ce1fcada6f92", "dsi.carauxheatercooler.DSICarAuxHeaterCooler");
        DSICarAuxHeaterCoolerReplyService dSICarAuxHeaterCoolerReplyService = new DSICarAuxHeaterCoolerReplyService(dSICarAuxHeaterCoolerReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarAuxHeaterCoolerReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setAuxHeaterCoolerOnOff(boolean bl) {
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
    public void setAuxHeaterCoolerRunningTime(short s) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void setAuxHeaterCoolerMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setAuxHeaterCoolerDefaultStartMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void setAuxHeaterCoolerEngineHeater(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void setAuxHeaterCoolerActiveTimer(int n) {
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
    public void setAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        DSICarAuxHeaterCoolerProxy$1 dSICarAuxHeaterCoolerProxy$1 = new DSICarAuxHeaterCoolerProxy$1(this, auxHeaterCoolerTimer);
        this.proxy.remoteCallMethod((short)11, dSICarAuxHeaterCoolerProxy$1);
    }

    @Override
    public void setAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        DSICarAuxHeaterCoolerProxy$2 dSICarAuxHeaterCoolerProxy$2 = new DSICarAuxHeaterCoolerProxy$2(this, auxHeaterCoolerTimer);
        this.proxy.remoteCallMethod((short)12, dSICarAuxHeaterCoolerProxy$2);
    }

    @Override
    public void setAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        DSICarAuxHeaterCoolerProxy$3 dSICarAuxHeaterCoolerProxy$3 = new DSICarAuxHeaterCoolerProxy$3(this, auxHeaterCoolerTimer);
        this.proxy.remoteCallMethod((short)13, dSICarAuxHeaterCoolerProxy$3);
    }

    @Override
    public void setAuxHeaterCoolerPopup(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    @Override
    public void setAuxHeaterSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)14, null);
    }

    @Override
    public void setAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning) {
        DSICarAuxHeaterCoolerProxy$4 dSICarAuxHeaterCoolerProxy$4 = new DSICarAuxHeaterCoolerProxy$4(this, auxHeaterCoolerExtendedConditioning);
        this.proxy.remoteCallMethod((short)38, dSICarAuxHeaterCoolerProxy$4);
    }

    @Override
    public void setAuxHeaterCoolerWindowHeating(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    @Override
    public void setAuxHeaterCoolerUnlockClimating(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)41, genericSerializable);
    }

    @Override
    public void setAuxHeaterCoolerTargetTemperature(float f2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putFloat(f2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)40, genericSerializable);
    }

    @Override
    public void setAuxHeaterCoolerAirQuality(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
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
        this.proxy.remoteCallMethod((short)16, genericSerializable);
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
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)15, null);
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
        this.proxy.remoteCallMethod((short)3, genericSerializable);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)2, null);
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
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }
}

