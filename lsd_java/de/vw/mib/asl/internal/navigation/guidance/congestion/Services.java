/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.congestion;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.navigation.guidance.congestion.HsmTargetCongestionAhead;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSIBlocking;
import org.dsi.ifc.navigation.DSIBlockingListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;

public final class Services
implements DSIServiceStateListener {
    DSINavigation dsiNavigation;
    DSIBlocking dsiBlocking;
    DSINavigationListener dsiNavigationListener;
    DSIBlockingListener dsiBlockingListener;
    private HsmTargetCongestionAhead target;
    private DSIServiceLocator locator;
    private static final int[] OBSERVER_DSINAV = new int[]{11};
    private static final int[] OBSERVER_DSIBLOCK = new int[]{2, 1};
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSIBlocking;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSIBlockingListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public Services(HsmTargetCongestionAhead hsmTargetCongestionAhead) {
        this.target = hsmTargetCongestionAhead;
        this.locator = ServiceManager.dsiServiceLocator;
        ServiceManager.dsiServiceLocator.addServiceStateListener(this);
    }

    public DSINavigation getNavigation() {
        return this.dsiNavigation;
    }

    public DSIBlocking getBlocking() {
        return this.dsiBlocking;
    }

    @Override
    public void registered(String string, int n) {
        if (this.target.isFirstStartupDone) {
            return;
        }
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
            this.target.trace("DSI_NAVIGATION service registered");
            this.initDsiNavigation();
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[77]) {
            this.target.trace("DSI_BLOCKING service registered");
            this.initDsiBlocking();
        }
        if (this.dsiNavigation != null && this.dsiBlocking != null) {
            this.target.isFirstStartupDone = true;
        }
    }

    void initDsiBlocking() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiBlocking = (DSIBlocking)dSIProxy.getService(this.target, class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = Services.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking);
        this.dsiBlockingListener = (DSIBlockingListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$navigation$DSIBlockingListener == null ? (class$org$dsi$ifc$navigation$DSIBlockingListener = Services.class$("org.dsi.ifc.navigation.DSIBlockingListener")) : class$org$dsi$ifc$navigation$DSIBlockingListener);
        dSIProxy.addResponseListener(this.target, class$org$dsi$ifc$navigation$DSIBlockingListener == null ? (class$org$dsi$ifc$navigation$DSIBlockingListener = Services.class$("org.dsi.ifc.navigation.DSIBlockingListener")) : class$org$dsi$ifc$navigation$DSIBlockingListener, this.dsiBlockingListener);
        this.dsiBlocking.setNotification(OBSERVER_DSIBLOCK, (DSIListener)this.dsiBlockingListener);
    }

    void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this.target, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Services.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = (DSINavigationListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Services.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Services.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        this.dsiNavigation.setNotification(OBSERVER_DSINAV, (DSIListener)this.dsiNavigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("HsmTargetAudio tries to unregister from ").append(string).append("...").log();
        }
        if (this.locator == null) {
            this.target.trace().append("dsiServiceLocator was null!");
            return;
        }
        String string2 = string.intern();
        try {
            if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
                this.unregisterDsiNavigation(string);
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[77]) {
                this.unregisterDsiBlocking(string);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiBlocking(String string) {
        if (this.dsiBlockingListener != null) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$navigation$DSIBlockingListener == null ? (class$org$dsi$ifc$navigation$DSIBlockingListener = Services.class$("org.dsi.ifc.navigation.DSIBlockingListener")) : class$org$dsi$ifc$navigation$DSIBlockingListener, this.dsiBlockingListener);
            this.dsiBlockingListener = null;
            this.traceUnregisteredDone(string);
        }
    }

    private void unregisterDsiNavigation(String string) {
        if (this.dsiNavigationListener != null) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Services.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
            this.traceUnregisteredDone(string);
        }
    }

    private void traceUnregisteredDone(String string) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("HsmTargetAudio unregistered from ").append(string).append("...").log();
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

