/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombisync2;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombisync2.DSIKombiSyncReply;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.kombisync2.DSIKombiSync;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.MenuState;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;
import org.osgi.framework.BundleContext;

public class DSIKombiSyncProvider
extends AbstractProvider
implements DSIKombiSync {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7};
    private DSIKombiSyncProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$DSIKombiSync;

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
        return (class$org$dsi$ifc$kombisync2$DSIKombiSync == null ? (class$org$dsi$ifc$kombisync2$DSIKombiSync = DSIKombiSyncProvider.class$("org.dsi.ifc.kombisync2.DSIKombiSync")) : class$org$dsi$ifc$kombisync2$DSIKombiSync).getName();
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
    public void setMMIDisplayRequestResponse(DisplayRequestResponse displayRequestResponse) {
        try {
            this.proxy.setMMIDisplayRequestResponse(displayRequestResponse);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMMIDisplayStatus(DisplayStatus displayStatus) {
        try {
            this.proxy.setMMIDisplayStatus(displayStatus);
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
    public void setMMIPopupRegisterRequest(PopupRegisterRequestResponse popupRegisterRequestResponse) {
        try {
            this.proxy.setMMIPopupRegisterRequest(popupRegisterRequestResponse);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMMIPopupActionResponse(PopupActionRequestResponse popupActionRequestResponse) {
        try {
            this.proxy.setMMIPopupActionResponse(popupActionRequestResponse);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMMIPopupStatus(PopupStatus popupStatus) {
        try {
            this.proxy.setMMIPopupStatus(popupStatus);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMMIDisplayIdentification(DisplayIdentification displayIdentification) {
        try {
            this.proxy.setMMIDisplayIdentification(displayIdentification);
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

