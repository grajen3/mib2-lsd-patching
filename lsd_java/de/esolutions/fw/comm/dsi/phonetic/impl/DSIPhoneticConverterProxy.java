/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.phonetic.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.phonetic.DSIPhoneticConverter;
import de.esolutions.fw.comm.dsi.phonetic.DSIPhoneticConverterC;
import de.esolutions.fw.comm.dsi.phonetic.DSIPhoneticConverterReply;
import de.esolutions.fw.comm.dsi.phonetic.impl.DSIPhoneticConverterReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIPhoneticConverterProxy
implements DSIPhoneticConverter,
DSIPhoneticConverterC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.phonetic.DSIPhoneticConverter");
    private Proxy proxy;

    public DSIPhoneticConverterProxy(int n, DSIPhoneticConverterReply dSIPhoneticConverterReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9169c119-ff4f-5acd-9e51-5dd7c0c9bb74", n, "781e2cf0-21d5-5992-b43a-a53217fadfc0", "dsi.phonetic.DSIPhoneticConverter");
        DSIPhoneticConverterReplyService dSIPhoneticConverterReplyService = new DSIPhoneticConverterReplyService(dSIPhoneticConverterReply);
        this.proxy = new Proxy(serviceInstanceID, dSIPhoneticConverterReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void hanziToPinYin(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void hanziToZhuYin(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }
}

