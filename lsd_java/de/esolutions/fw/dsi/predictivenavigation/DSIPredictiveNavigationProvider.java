/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.predictivenavigation;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.predictivenavigation.DSIPredictiveNavigationReply;
import de.esolutions.fw.comm.dsi.predictivenavigation.impl.DSIPredictiveNavigationProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation;
import org.osgi.framework.BundleContext;

public class DSIPredictiveNavigationProvider
extends AbstractProvider
implements DSIPredictiveNavigation {
    private static final int[] attributeIDs = new int[]{1, 2, 3};
    private DSIPredictiveNavigationProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation;

    public DSIPredictiveNavigationProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = DSIPredictiveNavigationProvider.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIPredictiveNavigationProxy(this.instance, (DSIPredictiveNavigationReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setOperationMode(int n) {
        try {
            this.proxy.setOperationMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMaxPredictions(int n) {
        try {
            this.proxy.setMaxPredictions(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearCache() {
        try {
            this.proxy.clearCache();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearCacheByDestination(NavLocation navLocation, int n) {
        try {
            this.proxy.clearCacheByDestination(navLocation, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearCacheByAge(long l) {
        try {
            this.proxy.clearCacheByAge(l);
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

