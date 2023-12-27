/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerRouteBlockReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerRouteBlockProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.map.DSIMapViewerRouteBlock;
import org.dsi.ifc.map.Point;
import org.osgi.framework.BundleContext;

public class DSIMapViewerRouteBlockProvider
extends AbstractProvider
implements DSIMapViewerRouteBlock {
    private static final int[] attributeIDs = new int[]{1};
    private DSIMapViewerRouteBlockProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerRouteBlock;

    public DSIMapViewerRouteBlockProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$map$DSIMapViewerRouteBlock == null ? (class$org$dsi$ifc$map$DSIMapViewerRouteBlock = DSIMapViewerRouteBlockProvider.class$("org.dsi.ifc.map.DSIMapViewerRouteBlock")) : class$org$dsi$ifc$map$DSIMapViewerRouteBlock).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMapViewerRouteBlockProxy(this.instance, (DSIMapViewerRouteBlockReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void rBMarkNextSegment() {
        try {
            this.proxy.rBMarkNextSegment();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rBMarkPreviousSegment() {
        try {
            this.proxy.rBMarkPreviousSegment();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rBSetSegmentScales(long l, long l2) {
        try {
            this.proxy.rBSetSegmentScales(l, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rBStartOfSelection() {
        try {
            this.proxy.rBStartOfSelection();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pickSegmentUidsInScreenSpace(Point point, int n) {
        try {
            this.proxy.pickSegmentUidsInScreenSpace(point, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void highLightSegmentUidsInMap(long[] lArray, boolean bl) {
        try {
            this.proxy.highLightSegmentUidsInMap(lArray, bl);
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

