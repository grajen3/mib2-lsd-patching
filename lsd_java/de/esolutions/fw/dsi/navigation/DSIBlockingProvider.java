/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.navigation;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.navigation.DSIBlockingReply;
import de.esolutions.fw.comm.dsi.navigation.impl.DSIBlockingProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.DSIBlocking;
import org.osgi.framework.BundleContext;

public class DSIBlockingProvider
extends AbstractProvider
implements DSIBlocking {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private DSIBlockingProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSIBlocking;

    public DSIBlockingProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = DSIBlockingProvider.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIBlockingProxy(this.instance, (DSIBlockingReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void blockArea(NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        try {
            this.proxy.blockArea(navLocationWgs84, navLocationWgs842);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void blockRouteSegments(long l, long l2) {
        try {
            this.proxy.blockRouteSegments(l, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void blockRoadSegments(NavLocation navLocation) {
        try {
            this.proxy.blockRoadSegments(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void blockRouteBasedOnLength(int n, int n2) {
        try {
            this.proxy.blockRouteBasedOnLength(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void persistBlock(long[] lArray) {
        try {
            this.proxy.persistBlock(lArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteBlock(long[] lArray) {
        try {
            this.proxy.deleteBlock(lArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBlockDescription(long[] lArray, String string) {
        try {
            this.proxy.setBlockDescription(lArray, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getBoundingRectangleOfBlocks(long[] lArray) {
        try {
            this.proxy.getBoundingRectangleOfBlocks(lArray);
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

