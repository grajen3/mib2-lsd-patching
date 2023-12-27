/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.personalization.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.personalization.DSIPersonalization;
import de.esolutions.fw.comm.dsi.personalization.DSIPersonalizationC;
import de.esolutions.fw.comm.dsi.personalization.DSIPersonalizationReply;
import de.esolutions.fw.comm.dsi.personalization.impl.DSIPersonalizationReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIPersonalizationProxy
implements DSIPersonalization,
DSIPersonalizationC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.personalization.DSIPersonalization");
    private Proxy proxy;

    public DSIPersonalizationProxy(int n, DSIPersonalizationReply dSIPersonalizationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("dac5ecbb-68fd-5b58-b368-d4af0fca5fd7", n, "ab5ba4b3-3cc8-5d48-ad60-d69e77d8f4f5", "dsi.personalization.DSIPersonalization");
        DSIPersonalizationReplyService dSIPersonalizationReplyService = new DSIPersonalizationReplyService(dSIPersonalizationReply);
        this.proxy = new Proxy(serviceInstanceID, dSIPersonalizationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }
}

