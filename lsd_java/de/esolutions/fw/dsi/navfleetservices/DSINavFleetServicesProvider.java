/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.navfleetservices;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.navfleetservices.DSINavFleetServicesReply;
import de.esolutions.fw.comm.dsi.navfleetservices.impl.DSINavFleetServicesProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.navfleetservices.DSINavFleetServices;
import org.osgi.framework.BundleContext;

public class DSINavFleetServicesProvider
extends AbstractProvider
implements DSINavFleetServices {
    private static final int[] attributeIDs = new int[0];
    private DSINavFleetServicesProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$navfleetservices$DSINavFleetServices;

    public DSINavFleetServicesProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$navfleetservices$DSINavFleetServices == null ? (class$org$dsi$ifc$navfleetservices$DSINavFleetServices = DSINavFleetServicesProvider.class$("org.dsi.ifc.navfleetservices.DSINavFleetServices")) : class$org$dsi$ifc$navfleetservices$DSINavFleetServices).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSINavFleetServicesProxy(this.instance, (DSINavFleetServicesReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setVZOTrackerState(int n) {
        try {
            this.proxy.setVZOTrackerState(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVZODownloadState(int n) {
        try {
            this.proxy.setVZODownloadState(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLGITrackerState(int n) {
        try {
            this.proxy.setLGITrackerState(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLGIDownloadState(int n) {
        try {
            this.proxy.setLGIDownloadState(n);
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

