/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.androidauto;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.androidauto.DSIAndroidAutoReply;
import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.DSIAndroidAuto;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ServiceConfiguration;
import org.dsi.ifc.androidauto.TouchEvent;
import org.osgi.framework.BundleContext;

public class DSIAndroidAutoProvider
extends AbstractProvider
implements DSIAndroidAuto {
    private static final int[] attributeIDs = new int[]{3, 4, 5, 6, 7, 8, 11, 12};
    private DSIAndroidAutoProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$DSIAndroidAuto;

    public DSIAndroidAutoProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$androidauto$DSIAndroidAuto == null ? (class$org$dsi$ifc$androidauto$DSIAndroidAuto = DSIAndroidAutoProvider.class$("org.dsi.ifc.androidauto.DSIAndroidAuto")) : class$org$dsi$ifc$androidauto$DSIAndroidAuto).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIAndroidAutoProxy(this.instance, (DSIAndroidAutoReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        try {
            this.proxy.startService(serviceConfiguration);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void postButtonEvent(int n, int n2) {
        try {
            this.proxy.postButtonEvent(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2, int n3) {
        try {
            this.proxy.postTouchEvent(n, touchEventArray, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void postRotaryEvent(int n) {
        try {
            this.proxy.postRotaryEvent(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
        try {
            this.proxy.setMode(resourceArray, appStateArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        try {
            this.proxy.responseModeChange(resourceArray, appStateArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestNightMode(boolean bl) {
        try {
            this.proxy.requestNightMode(bl);
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

