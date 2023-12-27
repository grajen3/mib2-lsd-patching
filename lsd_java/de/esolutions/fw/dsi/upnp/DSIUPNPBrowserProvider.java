/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.upnp;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPBrowserReply;
import de.esolutions.fw.comm.dsi.upnp.impl.DSIUPNPBrowserProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.upnp.DSIUPNPBrowser;
import org.dsi.ifc.upnp.ListEntry;
import org.osgi.framework.BundleContext;

public class DSIUPNPBrowserProvider
extends AbstractProvider
implements DSIUPNPBrowser {
    private static final int[] attributeIDs = new int[]{1, 2};
    private DSIUPNPBrowserProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$upnp$DSIUPNPBrowser;

    public DSIUPNPBrowserProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$upnp$DSIUPNPBrowser == null ? (class$org$dsi$ifc$upnp$DSIUPNPBrowser = DSIUPNPBrowserProvider.class$("org.dsi.ifc.upnp.DSIUPNPBrowser")) : class$org$dsi$ifc$upnp$DSIUPNPBrowser).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIUPNPBrowserProxy(this.instance, (DSIUPNPBrowserReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void changeFolder(ListEntry[] listEntryArray) {
        try {
            this.proxy.changeFolder(listEntryArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestList(String string, int n, int n2, int n3) {
        try {
            this.proxy.requestList(string, n, n2, n3);
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

