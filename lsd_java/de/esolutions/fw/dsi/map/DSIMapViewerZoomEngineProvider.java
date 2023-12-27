/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerZoomEngineReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerZoomEngineProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.map.DSIMapViewerZoomEngine;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.osgi.framework.BundleContext;

public class DSIMapViewerZoomEngineProvider
extends AbstractProvider
implements DSIMapViewerZoomEngine {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4};
    private DSIMapViewerZoomEngineProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerZoomEngine;

    public DSIMapViewerZoomEngineProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = DSIMapViewerZoomEngineProvider.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMapViewerZoomEngineProxy(this.instance, (DSIMapViewerZoomEngineReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void autoZoomEnable(boolean bl) {
        try {
            this.proxy.autoZoomEnable(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void manoeuvreZoomEnable(boolean bl) {
        try {
            this.proxy.manoeuvreZoomEnable(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setViewType(int n) {
        try {
            this.proxy.setViewType(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCarPosition(Point point) {
        try {
            this.proxy.setCarPosition(point);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMapRotation(short s) {
        try {
            this.proxy.setMapRotation(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMapOrientation(int n, Point point) {
        try {
            this.proxy.setMapOrientation(n, point);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setZoomArea(Rect rect) {
        try {
            this.proxy.setZoomArea(rect);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

