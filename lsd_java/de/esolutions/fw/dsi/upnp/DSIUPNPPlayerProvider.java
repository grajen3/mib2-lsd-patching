/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.upnp;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPPlayerReply;
import de.esolutions.fw.comm.dsi.upnp.impl.DSIUPNPPlayerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.upnp.DSIUPNPPlayer;
import org.dsi.ifc.upnp.ListEntry;
import org.osgi.framework.BundleContext;

public class DSIUPNPPlayerProvider
extends AbstractProvider
implements DSIUPNPPlayer {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7};
    private DSIUPNPPlayerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$upnp$DSIUPNPPlayer;

    public DSIUPNPPlayerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$upnp$DSIUPNPPlayer == null ? (class$org$dsi$ifc$upnp$DSIUPNPPlayer = DSIUPNPPlayerProvider.class$("org.dsi.ifc.upnp.DSIUPNPPlayer")) : class$org$dsi$ifc$upnp$DSIUPNPPlayer).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIUPNPPlayerProxy(this.instance, (DSIUPNPPlayerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setPlaybackMode(String string, int n) {
        try {
            this.proxy.setPlaybackMode(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEntry(String[] stringArray, String string, ListEntry[] listEntryArray, int n) {
        try {
            this.proxy.setEntry(stringArray, string, listEntryArray, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resume(String string) {
        try {
            this.proxy.resume(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pause(String string) {
        try {
            this.proxy.pause(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void skip(String string, int n, int n2) {
        try {
            this.proxy.skip(string, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void seek(String string, int n, int n2) {
        try {
            this.proxy.seek(string, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void increaseVolume(String string) {
        try {
            this.proxy.increaseVolume(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void decreaseVolume(String string) {
        try {
            this.proxy.decreaseVolume(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVolume(String string, int n) {
        try {
            this.proxy.setVolume(string, n);
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

