/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.powermanagement;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.powermanagement.DSIPowerManagementReply;
import de.esolutions.fw.comm.dsi.powermanagement.impl.DSIPowerManagementProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.osgi.framework.BundleContext;

public class DSIPowerManagementProvider
extends AbstractProvider
implements DSIPowerManagement {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
    private DSIPowerManagementProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;

    public DSIPowerManagementProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = DSIPowerManagementProvider.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIPowerManagementProxy(this.instance, (DSIPowerManagementReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setHMIReady() {
        try {
            this.proxy.setHMIReady();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rebootSystem() {
        try {
            this.proxy.rebootSystem();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void displayReady() {
        try {
            this.proxy.displayReady();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rebootSystemCritical() {
        try {
            this.proxy.rebootSystemCritical();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setChildLockRSE(int n) {
        try {
            this.proxy.setChildLockRSE(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLastOn(int n) {
        try {
            this.proxy.setLastOn(n);
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

