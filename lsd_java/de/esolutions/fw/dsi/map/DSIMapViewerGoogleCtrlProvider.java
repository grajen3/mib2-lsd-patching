/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerGoogleCtrlReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerGoogleCtrlProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrl;
import org.dsi.ifc.map.Rect;
import org.osgi.framework.BundleContext;

public class DSIMapViewerGoogleCtrlProvider
extends AbstractProvider
implements DSIMapViewerGoogleCtrl {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 6, 7};
    private DSIMapViewerGoogleCtrlProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl;

    public DSIMapViewerGoogleCtrlProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = DSIMapViewerGoogleCtrlProvider.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMapViewerGoogleCtrlProxy(this.instance, (DSIMapViewerGoogleCtrlReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestClearCache() {
        try {
            this.proxy.requestClearCache();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLanguage(String string) {
        try {
            this.proxy.setLanguage(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLayerVisibility(int[] nArray) {
        try {
            this.proxy.setLayerVisibility(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setConnectionInformation(int n) {
        try {
            this.proxy.setConnectionInformation(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void loadKml(String[] stringArray) {
        try {
            this.proxy.loadKml(stringArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCopyrightPosition(Rect rect, int n, int n2) {
        try {
            this.proxy.setCopyrightPosition(rect, n, n2);
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

