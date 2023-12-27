/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.mobilityhorizon.DSIMobilityHorizon;
import de.esolutions.fw.comm.dsi.mobilityhorizon.DSIMobilityHorizonC;
import de.esolutions.fw.comm.dsi.mobilityhorizon.DSIMobilityHorizonReply;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.DSIMobilityHorizonProxy$1;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.DSIMobilityHorizonProxy$2;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.DSIMobilityHorizonReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class DSIMobilityHorizonProxy
implements DSIMobilityHorizon,
DSIMobilityHorizonC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.mobilityhorizon.DSIMobilityHorizon");
    private Proxy proxy;

    public DSIMobilityHorizonProxy(int n, DSIMobilityHorizonReply dSIMobilityHorizonReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("10a21fa2-845e-5f9f-8283-ef042ff3cd6c", n, "5c4cdaf2-76e9-5a4d-980c-50fd93963747", "dsi.mobilityhorizon.DSIMobilityHorizon");
        DSIMobilityHorizonReplyService dSIMobilityHorizonReplyService = new DSIMobilityHorizonReplyService(dSIMobilityHorizonReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMobilityHorizonReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setConsumptionInfo(ConsumptionInfo[] consumptionInfoArray) {
        DSIMobilityHorizonProxy$1 dSIMobilityHorizonProxy$1 = new DSIMobilityHorizonProxy$1(this, consumptionInfoArray);
        this.proxy.remoteCallMethod((short)5, dSIMobilityHorizonProxy$1);
    }

    @Override
    public void setLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray) {
        DSIMobilityHorizonProxy$2 dSIMobilityHorizonProxy$2 = new DSIMobilityHorizonProxy$2(this, mobilityHorizonLocationArray);
        this.proxy.remoteCallMethod((short)6, dSIMobilityHorizonProxy$2);
    }

    @Override
    public void setConsideredLocationTypes(int[] nArray) {
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
    public void setDriveTrainMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void requestLocationRangeLevel(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
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
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }
}

