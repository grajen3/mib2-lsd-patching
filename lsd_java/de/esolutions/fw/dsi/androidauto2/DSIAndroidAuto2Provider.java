/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.androidauto2;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.androidauto2.DSIAndroidAuto2Reply;
import de.esolutions.fw.comm.dsi.androidauto2.impl.DSIAndroidAuto2Proxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;
import org.dsi.ifc.androidauto2.ServiceConfiguration;
import org.dsi.ifc.androidauto2.TouchEvent;
import org.osgi.framework.BundleContext;

public class DSIAndroidAuto2Provider
extends AbstractProvider
implements DSIAndroidAuto2 {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private DSIAndroidAuto2Proxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$DSIAndroidAuto2;

    public DSIAndroidAuto2Provider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 = DSIAndroidAuto2Provider.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIAndroidAuto2Proxy(this.instance, (DSIAndroidAuto2Reply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void videoFocusNotification(int n, boolean bl) {
        try {
            this.proxy.videoFocusNotification(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void audioFocusNotification(int n, boolean bl) {
        try {
            this.proxy.audioFocusNotification(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void microphoneNotification(int n, boolean bl) {
        try {
            this.proxy.microphoneNotification(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void navFocusNotification(int n, boolean bl) {
        try {
            this.proxy.navFocusNotification(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
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
    public void setNightMode(boolean bl) {
        try {
            this.proxy.setNightMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void bluetoothPairingResponse(boolean bl) {
        try {
            this.proxy.bluetoothPairingResponse(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void bluetoothAuthenticationData(String string) {
        try {
            this.proxy.bluetoothAuthenticationData(string);
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

