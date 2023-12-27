/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.generalvehiclestates.DSIGeneralVehicleStates;
import de.esolutions.fw.comm.dsi.generalvehiclestates.DSIGeneralVehicleStatesC;
import de.esolutions.fw.comm.dsi.generalvehiclestates.DSIGeneralVehicleStatesReply;
import de.esolutions.fw.comm.dsi.generalvehiclestates.impl.DSIGeneralVehicleStatesProxy$1;
import de.esolutions.fw.comm.dsi.generalvehiclestates.impl.DSIGeneralVehicleStatesReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.generalvehiclestates.TLOInfoElement;

public class DSIGeneralVehicleStatesProxy
implements DSIGeneralVehicleStates,
DSIGeneralVehicleStatesC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.generalvehiclestates.DSIGeneralVehicleStates");
    private Proxy proxy;

    public DSIGeneralVehicleStatesProxy(int n, DSIGeneralVehicleStatesReply dSIGeneralVehicleStatesReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("b42dbadf-a9fa-5690-a989-ecb909b18555", n, "9f1abdbc-e5ef-576b-8e65-c0aaee0e2484", "dsi.generalvehiclestates.DSIGeneralVehicleStates");
        DSIGeneralVehicleStatesReplyService dSIGeneralVehicleStatesReplyService = new DSIGeneralVehicleStatesReplyService(dSIGeneralVehicleStatesReply);
        this.proxy = new Proxy(serviceInstanceID, dSIGeneralVehicleStatesReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setDSSSKombiWarning(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    @Override
    public void setTLOData(int n, int n2, TLOInfoElement[] tLOInfoElementArray) {
        DSIGeneralVehicleStatesProxy$1 dSIGeneralVehicleStatesProxy$1 = new DSIGeneralVehicleStatesProxy$1(this, n, n2, tLOInfoElementArray);
        this.proxy.remoteCallMethod((short)36, dSIGeneralVehicleStatesProxy$1);
    }

    @Override
    public void setAppConnectState(boolean bl) {
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
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }
}

