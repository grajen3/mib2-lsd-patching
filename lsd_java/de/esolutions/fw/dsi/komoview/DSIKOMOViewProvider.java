/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.komoview;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.komoview.DSIKOMOViewReply;
import de.esolutions.fw.comm.dsi.komoview.impl.DSIKOMOViewProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.komoview.DSIKOMOView;
import org.dsi.ifc.komoview.RouteInfoElement;
import org.osgi.framework.BundleContext;

public class DSIKOMOViewProvider
extends AbstractProvider
implements DSIKOMOView {
    private static final int[] attributeIDs = new int[]{1, 2, 3};
    private DSIKOMOViewProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$komoview$DSIKOMOView;

    public DSIKOMOViewProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$komoview$DSIKOMOView == null ? (class$org$dsi$ifc$komoview$DSIKOMOView = DSIKOMOViewProvider.class$("org.dsi.ifc.komoview.DSIKOMOView")) : class$org$dsi$ifc$komoview$DSIKOMOView).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIKOMOViewProxy(this.instance, (DSIKOMOViewReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void enableKomoView(boolean bl) {
        try {
            this.proxy.enableKomoView(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void notifyVisibility(boolean bl) {
        try {
            this.proxy.notifyVisibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRouteInfoElement(RouteInfoElement routeInfoElement) {
        try {
            this.proxy.setRouteInfoElement(routeInfoElement);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRouteInfo(RouteInfoElement[] routeInfoElementArray) {
        try {
            this.proxy.setRouteInfo(routeInfoElementArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setKomoViewStyle(int n) {
        try {
            this.proxy.setKomoViewStyle(n);
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

