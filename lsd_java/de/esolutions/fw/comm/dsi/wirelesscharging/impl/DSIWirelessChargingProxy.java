/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.wirelesscharging.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.wirelesscharging.DSIWirelessCharging;
import de.esolutions.fw.comm.dsi.wirelesscharging.DSIWirelessChargingC;
import de.esolutions.fw.comm.dsi.wirelesscharging.DSIWirelessChargingReply;
import de.esolutions.fw.comm.dsi.wirelesscharging.impl.DSIWirelessChargingReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIWirelessChargingProxy
implements DSIWirelessCharging,
DSIWirelessChargingC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.wirelesscharging.DSIWirelessCharging");
    private Proxy proxy;

    public DSIWirelessChargingProxy(int n, DSIWirelessChargingReply dSIWirelessChargingReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9e32ff1c-d58b-52cb-be94-93c9612e6748", n, "5536b794-4ea5-521b-b621-5bb7efd1ce30", "dsi.wirelesscharging.DSIWirelessCharging");
        DSIWirelessChargingReplyService dSIWirelessChargingReplyService = new DSIWirelessChargingReplyService(dSIWirelessChargingReply);
        this.proxy = new Proxy(serviceInstanceID, dSIWirelessChargingReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setWLCState(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
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
        this.proxy.remoteCallMethod((short)5, genericSerializable);
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
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)4, null);
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
        this.proxy.remoteCallMethod((short)2, genericSerializable);
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
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }
}

