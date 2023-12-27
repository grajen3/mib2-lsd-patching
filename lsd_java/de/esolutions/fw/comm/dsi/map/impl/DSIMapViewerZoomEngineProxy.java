/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerZoomEngine;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerZoomEngineC;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerZoomEngineReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerZoomEngineProxy$1;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerZoomEngineProxy$2;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerZoomEngineProxy$3;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerZoomEngineReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class DSIMapViewerZoomEngineProxy
implements DSIMapViewerZoomEngine,
DSIMapViewerZoomEngineC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.map.DSIMapViewerZoomEngine");
    private Proxy proxy;

    public DSIMapViewerZoomEngineProxy(int n, DSIMapViewerZoomEngineReply dSIMapViewerZoomEngineReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f7dae942-62c8-5ee3-869f-c352122bc3e2", n, "211373f2-b137-5465-93f3-6cb833a66a12", "dsi.map.DSIMapViewerZoomEngine");
        DSIMapViewerZoomEngineReplyService dSIMapViewerZoomEngineReplyService = new DSIMapViewerZoomEngineReplyService(dSIMapViewerZoomEngineReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMapViewerZoomEngineReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void autoZoomEnable(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void manoeuvreZoomEnable(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void setViewType(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void setCarPosition(Point point) {
        DSIMapViewerZoomEngineProxy$1 dSIMapViewerZoomEngineProxy$1 = new DSIMapViewerZoomEngineProxy$1(this, point);
        this.proxy.remoteCallMethod((short)6, dSIMapViewerZoomEngineProxy$1);
    }

    @Override
    public void setMapRotation(short s) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setMapOrientation(int n, Point point) {
        DSIMapViewerZoomEngineProxy$2 dSIMapViewerZoomEngineProxy$2 = new DSIMapViewerZoomEngineProxy$2(this, n, point);
        this.proxy.remoteCallMethod((short)7, dSIMapViewerZoomEngineProxy$2);
    }

    @Override
    public void setZoomArea(Rect rect) {
        DSIMapViewerZoomEngineProxy$3 dSIMapViewerZoomEngineProxy$3 = new DSIMapViewerZoomEngineProxy$3(this, rect);
        this.proxy.remoteCallMethod((short)13, dSIMapViewerZoomEngineProxy$3);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)9, null);
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
        this.proxy.remoteCallMethod((short)3, genericSerializable);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)2, null);
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
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }
}

