/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerLandmarkPlayerReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerLandmarkPlayerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.map.DSIMapViewerLandmarkPlayer;
import org.dsi.ifc.map.Point;
import org.osgi.framework.BundleContext;

public class DSIMapViewerLandmarkPlayerProvider
extends AbstractProvider
implements DSIMapViewerLandmarkPlayer {
    private static final int[] attributeIDs = new int[0];
    private DSIMapViewerLandmarkPlayerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerLandmarkPlayer;

    public DSIMapViewerLandmarkPlayerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$map$DSIMapViewerLandmarkPlayer == null ? (class$org$dsi$ifc$map$DSIMapViewerLandmarkPlayer = DSIMapViewerLandmarkPlayerProvider.class$("org.dsi.ifc.map.DSIMapViewerLandmarkPlayer")) : class$org$dsi$ifc$map$DSIMapViewerLandmarkPlayer).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMapViewerLandmarkPlayerProxy(this.instance, (DSIMapViewerLandmarkPlayerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void hideLandmark() {
        try {
            this.proxy.hideLandmark();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showLandmark(Point point, long l) {
        try {
            this.proxy.showLandmark(point, l);
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

