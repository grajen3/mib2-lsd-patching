/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.system.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.system.DSIHMIWatchDog;
import de.esolutions.fw.comm.dsi.system.DSIHMIWatchDogC;
import de.esolutions.fw.comm.dsi.system.DSIHMIWatchDogReply;
import de.esolutions.fw.comm.dsi.system.impl.DSIHMIWatchDogReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIHMIWatchDogProxy
implements DSIHMIWatchDog,
DSIHMIWatchDogC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.system.DSIHMIWatchDog");
    private Proxy proxy;

    public DSIHMIWatchDogProxy(int n, DSIHMIWatchDogReply dSIHMIWatchDogReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("c6dbc5bd-24a2-53b2-837f-0fa20e31905a", n, "abf06958-052d-5701-838a-49b34c4accee", "dsi.system.DSIHMIWatchDog");
        DSIHMIWatchDogReplyService dSIHMIWatchDogReplyService = new DSIHMIWatchDogReplyService(dSIHMIWatchDogReply);
        this.proxy = new Proxy(serviceInstanceID, dSIHMIWatchDogReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void heartbeat(int n) {
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
    public void errorlogDumpResult(int n) {
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
    public void hmiReady() {
        this.proxy.remoteCallMethod((short)5, null);
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
        this.proxy.remoteCallMethod((short)1, genericSerializable);
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
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)0, null);
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
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }
}

