/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.predictivenavigation.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.predictivenavigation.DSIPredictiveNavigation;
import de.esolutions.fw.comm.dsi.predictivenavigation.DSIPredictiveNavigationC;
import de.esolutions.fw.comm.dsi.predictivenavigation.DSIPredictiveNavigationReply;
import de.esolutions.fw.comm.dsi.predictivenavigation.impl.DSIPredictiveNavigationProxy$1;
import de.esolutions.fw.comm.dsi.predictivenavigation.impl.DSIPredictiveNavigationReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocation;

public class DSIPredictiveNavigationProxy
implements DSIPredictiveNavigation,
DSIPredictiveNavigationC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.predictivenavigation.DSIPredictiveNavigation");
    private Proxy proxy;

    public DSIPredictiveNavigationProxy(int n, DSIPredictiveNavigationReply dSIPredictiveNavigationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("544e7dc8-7f3f-5404-85fc-248e9e470a44", n, "90ccc0ce-a5f4-5d9b-b96f-a4a2ff55c1a2", "dsi.predictivenavigation.DSIPredictiveNavigation");
        DSIPredictiveNavigationReplyService dSIPredictiveNavigationReplyService = new DSIPredictiveNavigationReplyService(dSIPredictiveNavigationReply);
        this.proxy = new Proxy(serviceInstanceID, dSIPredictiveNavigationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setOperationMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void setMaxPredictions(int n) {
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
    public void clearCache() {
        this.proxy.remoteCallMethod((short)1, null);
    }

    @Override
    public void clearCacheByDestination(NavLocation navLocation, int n) {
        DSIPredictiveNavigationProxy$1 dSIPredictiveNavigationProxy$1 = new DSIPredictiveNavigationProxy$1(this, navLocation, n);
        this.proxy.remoteCallMethod((short)17, dSIPredictiveNavigationProxy$1);
    }

    @Override
    public void clearCacheByAge(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
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
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }
}

