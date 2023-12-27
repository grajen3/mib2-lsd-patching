/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;

final class Services
implements DSIServiceStateListener {
    private DSINavigation dsiNavigation;
    private DSINavigationListener dsiNavigationListener;
    private HsmTargetAudio target;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    Services(HsmTargetAudio hsmTargetAudio) {
        this.target = hsmTargetAudio;
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Services.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
    }

    DSINavigation getNavigation() {
        return this.dsiNavigation;
    }

    @Override
    public void registered(String string, int n) {
        if (this.target.isFirstStartupDone) {
            return;
        }
        if (string == null || !string.intern().equals(RuntimeGeneratedConstants.SERVICE_TS_NS[79])) {
            return;
        }
        this.initDsiNavigation();
        this.target.isFirstStartupDone = true;
    }

    public void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        HsmTargetAudio.getLogger().trace("DSI_NAVIGATION service registered");
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this.target, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Services.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = (DSINavigationListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Services.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Services.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        this.dsiNavigation.setNotification(new int[]{82, 11}, (DSIListener)this.dsiNavigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("HsmTargetAudio tries to unregister from ").append(string).append("...").log();
            }
            try {
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                if (dSIProxy == null) {
                    this.target.trace("DSIProxy was null!");
                    return;
                }
                this.target.getHsm().trans(this.target.stateDSINotAvailable);
                this.target.getHsm().activateTransition();
                this.unregisterDsiNavigation(string, dSIProxy);
                HsmTargetAudio.getLogger().trace("DSI_NAVIGATION service unregistered");
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Services.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
            this.traceUnregisterDone(string);
        }
    }

    private void traceUnregisterDone(String string) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("HsmTargetAudio unregistered from ").append(string).log();
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

