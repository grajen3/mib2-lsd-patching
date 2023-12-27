/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephoneng.DSIMobileEquipmentTopology;
import de.esolutions.fw.comm.dsi.telephoneng.DSIMobileEquipmentTopologyC;
import de.esolutions.fw.comm.dsi.telephoneng.DSIMobileEquipmentTopologyReply;
import de.esolutions.fw.comm.dsi.telephoneng.impl.DSIMobileEquipmentTopologyReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIMobileEquipmentTopologyProxy
implements DSIMobileEquipmentTopology,
DSIMobileEquipmentTopologyC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.telephoneng.DSIMobileEquipmentTopology");
    private Proxy proxy;

    public DSIMobileEquipmentTopologyProxy(int n, DSIMobileEquipmentTopologyReply dSIMobileEquipmentTopologyReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9afc0af0-5cc2-581b-978c-9767a9c31424", n, "0973583d-c406-514d-9dcf-e7eabf37dcd9", "dsi.telephoneng.DSIMobileEquipmentTopology");
        DSIMobileEquipmentTopologyReplyService dSIMobileEquipmentTopologyReplyService = new DSIMobileEquipmentTopologyReplyService(dSIMobileEquipmentTopologyReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMobileEquipmentTopologyReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestChangeTopology(int[] nArray) {
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
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
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
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)6, null);
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

