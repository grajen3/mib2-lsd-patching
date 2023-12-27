/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.bluetooth;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.bluetooth.DSIObexAuthenticationReply;
import de.esolutions.fw.comm.dsi.bluetooth.impl.DSIObexAuthenticationProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.bluetooth.DSIObexAuthentication;
import org.osgi.framework.BundleContext;

public class DSIObexAuthenticationProvider
extends AbstractProvider
implements DSIObexAuthentication {
    private static final int[] attributeIDs = new int[0];
    private DSIObexAuthenticationProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObexAuthentication;

    public DSIObexAuthenticationProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$bluetooth$DSIObexAuthentication == null ? (class$org$dsi$ifc$bluetooth$DSIObexAuthentication = DSIObexAuthenticationProvider.class$("org.dsi.ifc.bluetooth.DSIObexAuthentication")) : class$org$dsi$ifc$bluetooth$DSIObexAuthentication).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIObexAuthenticationProxy(this.instance, (DSIObexAuthenticationReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setAuthenticationInfo(int n, String string, String string2) {
        try {
            this.proxy.setAuthenticationInfo(n, string, string2);
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

