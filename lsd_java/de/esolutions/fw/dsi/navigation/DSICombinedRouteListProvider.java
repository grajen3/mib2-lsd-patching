/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.navigation;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.navigation.DSICombinedRouteListReply;
import de.esolutions.fw.comm.dsi.navigation.impl.DSICombinedRouteListProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.navigation.DSICombinedRouteList;
import org.osgi.framework.BundleContext;

public class DSICombinedRouteListProvider
extends AbstractProvider
implements DSICombinedRouteList {
    private static final int[] attributeIDs = new int[]{1};
    private DSICombinedRouteListProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSICombinedRouteList;

    public DSICombinedRouteListProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$navigation$DSICombinedRouteList == null ? (class$org$dsi$ifc$navigation$DSICombinedRouteList = DSICombinedRouteListProvider.class$("org.dsi.ifc.navigation.DSICombinedRouteList")) : class$org$dsi$ifc$navigation$DSICombinedRouteList).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICombinedRouteListProxy(this.instance, (DSICombinedRouteListReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestCombinedRouteListWindow(int n, int n2, long[] lArray, long l) {
        try {
            this.proxy.requestCombinedRouteListWindow(n, n2, lArray, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestTrafficInformation(long l) {
        try {
            this.proxy.requestTrafficInformation(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestPOIInformation(long l) {
        try {
            this.proxy.requestPOIInformation(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getBoundingRectangleOfCombinedRouteListElements(long[] lArray) {
        try {
            this.proxy.getBoundingRectangleOfCombinedRouteListElements(lArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestPriceInfo(long l) {
        try {
            this.proxy.requestPriceInfo(l);
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

