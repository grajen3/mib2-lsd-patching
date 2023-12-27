/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombisync;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombisync.DSIKombiSyncReply;
import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.kombisync.DSIKombiSync;
import org.dsi.ifc.kombisync.MMIDisplayRequest;
import org.dsi.ifc.kombisync.MMIDisplayStatus;
import org.dsi.ifc.kombisync.MMIPopupRequest;
import org.dsi.ifc.kombisync.MenuState;
import org.osgi.framework.BundleContext;

public class DSIKombiSyncProvider
extends AbstractProvider
implements DSIKombiSync {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4};
    private DSIKombiSyncProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync$DSIKombiSync;

    public DSIKombiSyncProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$kombisync$DSIKombiSync == null ? (class$org$dsi$ifc$kombisync$DSIKombiSync = DSIKombiSyncProvider.class$("org.dsi.ifc.kombisync.DSIKombiSync")) : class$org$dsi$ifc$kombisync$DSIKombiSync).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIKombiSyncProxy(this.instance, (DSIKombiSyncReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setMMIDisplayStatus(MMIDisplayStatus mMIDisplayStatus) {
        try {
            this.proxy.setMMIDisplayStatus(mMIDisplayStatus);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMMIDisplayRequest(MMIDisplayRequest mMIDisplayRequest) {
        try {
            this.proxy.setMMIDisplayRequest(mMIDisplayRequest);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMenuState(MenuState menuState) {
        try {
            this.proxy.setMenuState(menuState);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMMIPopupRequest(MMIPopupRequest mMIPopupRequest) {
        try {
            this.proxy.setMMIPopupRequest(mMIPopupRequest);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHMIIsReady(boolean bl) {
        try {
            this.proxy.setHMIIsReady(bl);
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

