/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineTrafficProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.online.DSIOnlineTraffic;
import org.osgi.framework.BundleContext;

public class DSIOnlineTrafficProvider
extends AbstractProvider
implements DSIOnlineTraffic {
    private static final int[] attributeIDs = new int[]{1, 2};
    private DSIOnlineTrafficProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineTraffic;

    public DSIOnlineTrafficProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$online$DSIOnlineTraffic == null ? (class$org$dsi$ifc$online$DSIOnlineTraffic = DSIOnlineTrafficProvider.class$("org.dsi.ifc.online.DSIOnlineTraffic")) : class$org$dsi$ifc$online$DSIOnlineTraffic).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIOnlineTrafficProxy(this.instance, (DSIOnlineTrafficReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setOnlineTrafficDataStatus(int n) {
        try {
            this.proxy.setOnlineTrafficDataStatus(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getNewData() {
        try {
            this.proxy.getNewData();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNewData(String string) {
        try {
            this.proxy.setNewData(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTimeoutForFallback(long l) {
        try {
            this.proxy.setTimeoutForFallback(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNewSession() {
        try {
            this.proxy.setNewSession();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getNewFCDInformation() {
        try {
            this.proxy.getNewFCDInformation();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getInventory() {
        try {
            this.proxy.getInventory();
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

