/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerLandmarkPlayer;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerLandmarkPlayerC;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerLandmarkPlayerReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerLandmarkPlayerProxy$1;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerLandmarkPlayerReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.map.Point;

public class DSIMapViewerLandmarkPlayerProxy
implements DSIMapViewerLandmarkPlayer,
DSIMapViewerLandmarkPlayerC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.map.DSIMapViewerLandmarkPlayer");
    private Proxy proxy;

    public DSIMapViewerLandmarkPlayerProxy(int n, DSIMapViewerLandmarkPlayerReply dSIMapViewerLandmarkPlayerReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("1945ffac-113f-5ea3-a4be-edd3fa5eee39", n, "b04d0457-4466-56f6-b245-d20642571a45", "dsi.map.DSIMapViewerLandmarkPlayer");
        DSIMapViewerLandmarkPlayerReplyService dSIMapViewerLandmarkPlayerReplyService = new DSIMapViewerLandmarkPlayerReplyService(dSIMapViewerLandmarkPlayerReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMapViewerLandmarkPlayerReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void hideLandmark() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void showLandmark(Point point, long l) {
        DSIMapViewerLandmarkPlayerProxy$1 dSIMapViewerLandmarkPlayerProxy$1 = new DSIMapViewerLandmarkPlayerProxy$1(this, point, l);
        this.proxy.remoteCallMethod((short)9, dSIMapViewerLandmarkPlayerProxy$1);
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
        this.proxy.remoteCallMethod((short)6, genericSerializable);
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
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)5, null);
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

