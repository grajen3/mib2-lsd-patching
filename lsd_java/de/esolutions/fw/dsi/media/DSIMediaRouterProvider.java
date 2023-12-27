/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMediaRouterReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaRouterProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouter;
import org.osgi.framework.BundleContext;

public class DSIMediaRouterProvider
extends AbstractProvider
implements DSIMediaRouter {
    private static final int[] attributeIDs = new int[]{1, 2};
    private DSIMediaRouterProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRouter;

    public DSIMediaRouterProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$media$DSIMediaRouter == null ? (class$org$dsi$ifc$media$DSIMediaRouter = DSIMediaRouterProvider.class$("org.dsi.ifc.media.DSIMediaRouter")) : class$org$dsi$ifc$media$DSIMediaRouter).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMediaRouterProxy(this.instance, (DSIMediaRouterReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void registerClient(int n, String string, String string2) {
        try {
            this.proxy.registerClient(n, string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void unregisterClient(int n) {
        try {
            this.proxy.unregisterClient(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startStreaming(int n) {
        try {
            this.proxy.startStreaming(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void stopStreaming(int n) {
        try {
            this.proxy.stopStreaming(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestConfiguration(int n, int n2, int n3, int n4) {
        try {
            this.proxy.requestConfiguration(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAudioRoutes(AudioRoute[] audioRouteArray) {
        try {
            this.proxy.setAudioRoutes(audioRouteArray);
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

