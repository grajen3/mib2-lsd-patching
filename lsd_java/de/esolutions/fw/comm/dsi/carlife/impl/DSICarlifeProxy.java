/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carlife.DSICarlife;
import de.esolutions.fw.comm.dsi.carlife.DSICarlifeC;
import de.esolutions.fw.comm.dsi.carlife.DSICarlifeReply;
import de.esolutions.fw.comm.dsi.carlife.impl.DSICarlifeProxy$1;
import de.esolutions.fw.comm.dsi.carlife.impl.DSICarlifeProxy$2;
import de.esolutions.fw.comm.dsi.carlife.impl.DSICarlifeProxy$3;
import de.esolutions.fw.comm.dsi.carlife.impl.DSICarlifeProxy$4;
import de.esolutions.fw.comm.dsi.carlife.impl.DSICarlifeReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;

public class DSICarlifeProxy
implements DSICarlife,
DSICarlifeC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carlife.DSICarlife");
    private Proxy proxy;

    public DSICarlifeProxy(int n, DSICarlifeReply dSICarlifeReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("cb507d49-a334-5d1c-a54e-98b3813496f3", n, "d18a17d8-40d1-5e95-ae5e-3766d4fdba21", "dsi.carlife.DSICarlife");
        DSICarlifeReplyService dSICarlifeReplyService = new DSICarlifeReplyService(dSICarlifeReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarlifeReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        DSICarlifeProxy$1 dSICarlifeProxy$1 = new DSICarlifeProxy$1(this, serviceConfiguration);
        this.proxy.remoteCallMethod((short)16, dSICarlifeProxy$1);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2) {
        DSICarlifeProxy$2 dSICarlifeProxy$2 = new DSICarlifeProxy$2(this, n, touchEventArray, n2);
        this.proxy.remoteCallMethod((short)7, dSICarlifeProxy$2);
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
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void postCharacterEvent(int n, String[] stringArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
        DSICarlifeProxy$3 dSICarlifeProxy$3 = new DSICarlifeProxy$3(this, resourceArray, appStateArray);
        this.proxy.remoteCallMethod((short)12, dSICarlifeProxy$3);
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
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        DSICarlifeProxy$4 dSICarlifeProxy$4 = new DSICarlifeProxy$4(this, resourceArray, appStateArray);
        this.proxy.remoteCallMethod((short)10, dSICarlifeProxy$4);
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
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }
}

