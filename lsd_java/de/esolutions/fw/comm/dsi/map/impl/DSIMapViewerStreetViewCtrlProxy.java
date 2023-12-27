/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerStreetViewCtrl;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerStreetViewCtrlC;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerStreetViewCtrlReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlProxy$1;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlProxy$2;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlProxy$3;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlProxy$4;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public class DSIMapViewerStreetViewCtrlProxy
implements DSIMapViewerStreetViewCtrl,
DSIMapViewerStreetViewCtrlC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.map.DSIMapViewerStreetViewCtrl");
    private Proxy proxy;

    public DSIMapViewerStreetViewCtrlProxy(int n, DSIMapViewerStreetViewCtrlReply dSIMapViewerStreetViewCtrlReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("58b23955-bf82-5e0e-af58-d2410665a24d", n, "1bf14722-a655-566e-86b3-82a41cb866bd", "dsi.map.DSIMapViewerStreetViewCtrl");
        DSIMapViewerStreetViewCtrlReplyService dSIMapViewerStreetViewCtrlReplyService = new DSIMapViewerStreetViewCtrlReplyService(dSIMapViewerStreetViewCtrlReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMapViewerStreetViewCtrlReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void streetViewEnabled(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    @Override
    public void streetViewVisible(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    @Override
    public void streetViewFreeze(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    @Override
    public void goToView() {
        this.proxy.remoteCallMethod((short)42, null);
    }

    @Override
    public void setStreetViewZoomIndex(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void streetViewThumbnails(StreetViewThumbnail[] streetViewThumbnailArray) {
        DSIMapViewerStreetViewCtrlProxy$1 dSIMapViewerStreetViewCtrlProxy$1 = new DSIMapViewerStreetViewCtrlProxy$1(this, streetViewThumbnailArray);
        this.proxy.remoteCallMethod((short)28, dSIMapViewerStreetViewCtrlProxy$1);
    }

    @Override
    public void loadStreetView(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void rotateView(short s, short s2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putInt16(s2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void rotateViewByPolarCoordinates(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void setAzimuth(int n) {
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
    public void setInclination(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void getInfoForScreenPosition(short s, short s2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putInt16(s2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void setPosition(NavLocationWgs84 navLocationWgs84) {
        DSIMapViewerStreetViewCtrlProxy$2 dSIMapViewerStreetViewCtrlProxy$2 = new DSIMapViewerStreetViewCtrlProxy$2(this, navLocationWgs84);
        this.proxy.remoteCallMethod((short)17, dSIMapViewerStreetViewCtrlProxy$2);
    }

    @Override
    public void setCrossHairsVisibility(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setDayNightView(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void snapshot() {
        this.proxy.remoteCallMethod((short)20, null);
    }

    @Override
    public void setViewRotationByPolarCoordinates(float f2, float f3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putFloat(f2);
            genericSerializable.putFloat(f3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void startViewRotationByPolarCoordinates(float f2, float f3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putFloat(f2);
            genericSerializable.putFloat(f3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    @Override
    public void stopViewRotationByPolarCoordinates() {
        this.proxy.remoteCallMethod((short)23, null);
    }

    @Override
    public void setScreenViewport(Rect rect) {
        DSIMapViewerStreetViewCtrlProxy$3 dSIMapViewerStreetViewCtrlProxy$3 = new DSIMapViewerStreetViewCtrlProxy$3(this, rect);
        this.proxy.remoteCallMethod((short)44, dSIMapViewerStreetViewCtrlProxy$3);
    }

    @Override
    public void setCrossHairsPosition(Point point) {
        DSIMapViewerStreetViewCtrlProxy$4 dSIMapViewerStreetViewCtrlProxy$4 = new DSIMapViewerStreetViewCtrlProxy$4(this, point);
        this.proxy.remoteCallMethod((short)43, dSIMapViewerStreetViewCtrlProxy$4);
    }

    @Override
    public void setStreetViewZoomLevel(float f2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putFloat(f2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)46, genericSerializable);
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
        this.proxy.remoteCallMethod((short)15, genericSerializable);
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
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)14, null);
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
        this.proxy.remoteCallMethod((short)41, genericSerializable);
    }
}

