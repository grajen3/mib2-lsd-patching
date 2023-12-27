/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.navigation.DSIBlocking;
import de.esolutions.fw.comm.dsi.navigation.DSIBlockingC;
import de.esolutions.fw.comm.dsi.navigation.DSIBlockingReply;
import de.esolutions.fw.comm.dsi.navigation.impl.DSIBlockingProxy$1;
import de.esolutions.fw.comm.dsi.navigation.impl.DSIBlockingProxy$2;
import de.esolutions.fw.comm.dsi.navigation.impl.DSIBlockingReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public class DSIBlockingProxy
implements DSIBlocking,
DSIBlockingC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.navigation.DSIBlocking");
    private Proxy proxy;

    public DSIBlockingProxy(int n, DSIBlockingReply dSIBlockingReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7e8d9639-93b7-5bee-ad23-11aa5a778dfa", n, "945c1bc3-5e89-5c88-b7e6-91bec707b2ec", "dsi.navigation.DSIBlocking");
        DSIBlockingReplyService dSIBlockingReplyService = new DSIBlockingReplyService(dSIBlockingReply);
        this.proxy = new Proxy(serviceInstanceID, dSIBlockingReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void blockArea(NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        DSIBlockingProxy$1 dSIBlockingProxy$1 = new DSIBlockingProxy$1(this, navLocationWgs84, navLocationWgs842);
        this.proxy.remoteCallMethod((short)1, dSIBlockingProxy$1);
    }

    @Override
    public void blockRouteSegments(long l, long l2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void blockRoadSegments(NavLocation navLocation) {
        DSIBlockingProxy$2 dSIBlockingProxy$2 = new DSIBlockingProxy$2(this, navLocation);
        this.proxy.remoteCallMethod((short)3, dSIBlockingProxy$2);
    }

    @Override
    public void blockRouteBasedOnLength(int n, int n2) {
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
    public void persistBlock(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void deleteBlock(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void setBlockDescription(long[] lArray, String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void getBoundingRectangleOfBlocks(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
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
        this.proxy.remoteCallMethod((short)21, genericSerializable);
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
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)20, null);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)9, null);
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
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }
}

