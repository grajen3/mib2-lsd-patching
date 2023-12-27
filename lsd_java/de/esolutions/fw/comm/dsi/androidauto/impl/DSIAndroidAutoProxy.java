/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.androidauto.DSIAndroidAuto;
import de.esolutions.fw.comm.dsi.androidauto.DSIAndroidAutoC;
import de.esolutions.fw.comm.dsi.androidauto.DSIAndroidAutoReply;
import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoProxy$1;
import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoProxy$2;
import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoProxy$3;
import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoProxy$4;
import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ServiceConfiguration;
import org.dsi.ifc.androidauto.TouchEvent;

public class DSIAndroidAutoProxy
implements DSIAndroidAuto,
DSIAndroidAutoC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.androidauto.DSIAndroidAuto");
    private Proxy proxy;

    public DSIAndroidAutoProxy(int n, DSIAndroidAutoReply dSIAndroidAutoReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("56c4920d-793f-525f-85a8-8f22d26bea9c", n, "c1be70e5-c44d-508b-a79a-90d0b4d8659a", "dsi.androidauto.DSIAndroidAuto");
        DSIAndroidAutoReplyService dSIAndroidAutoReplyService = new DSIAndroidAutoReplyService(dSIAndroidAutoReply);
        this.proxy = new Proxy(serviceInstanceID, dSIAndroidAutoReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        DSIAndroidAutoProxy$1 dSIAndroidAutoProxy$1 = new DSIAndroidAutoProxy$1(this, serviceConfiguration);
        this.proxy.remoteCallMethod((short)37, dSIAndroidAutoProxy$1);
    }

    @Override
    public void postButtonEvent(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2, int n3) {
        DSIAndroidAutoProxy$2 dSIAndroidAutoProxy$2 = new DSIAndroidAutoProxy$2(this, n, touchEventArray, n2, n3);
        this.proxy.remoteCallMethod((short)35, dSIAndroidAutoProxy$2);
    }

    @Override
    public void postRotaryEvent(int n) {
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
    public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
        DSIAndroidAutoProxy$3 dSIAndroidAutoProxy$3 = new DSIAndroidAutoProxy$3(this, resourceArray, appStateArray);
        this.proxy.remoteCallMethod((short)32, dSIAndroidAutoProxy$3);
    }

    @Override
    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        DSIAndroidAutoProxy$4 dSIAndroidAutoProxy$4 = new DSIAndroidAutoProxy$4(this, resourceArray, appStateArray);
        this.proxy.remoteCallMethod((short)31, dSIAndroidAutoProxy$4);
    }

    @Override
    public void requestNightMode(boolean bl) {
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
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
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
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)13, null);
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
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }
}

