/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.routeoptions.StateRouteOptionsWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.tmc.DSITmc;
import org.dsi.ifc.tmc.DSITmcListener;

public final class HsmTargetRouteOptions
extends AbstractResettableAslHsmTarget {
    static IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[RouteOptions] ");
    final StateRouteOptionsWork stateRouteOptionsWork;
    private DSINavigation dsiNavigation;
    private DSINavigationListener dsiNavigationListener;
    DSITmc dsiTmc;
    DSITmcListener dsiTmcListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public HsmTargetRouteOptions(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateRouteOptionsWork = new StateRouteOptionsWork(this, this.hsm, "stateRouteOptionsWork", this.getWorkStateParent());
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateRouteOptionsWork;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    void registerDsiServices(String string, int n) {
        if (this.isFirstStartupDone) {
            return;
        }
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetRouteOptions.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetRouteOptions tries to register to ").append(string).append("...").log();
            }
            this.initDsiNavigation();
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetRouteOptions registered to ").append(string).log();
            }
        } else if (string.intern() == (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = HsmTargetRouteOptions.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetRouteOptions tries to register to ").append(string).append("...").log();
            }
            this.initDsiTmc();
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetRouteOptions registered to ").append(string).log();
            }
        }
        if (this.dsiNavigation != null && this.dsiTmc != null) {
            this.isFirstStartupDone = true;
        }
    }

    public void initDsiTmc() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiTmc = (DSITmc)dSIProxy.getService(this, class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = HsmTargetRouteOptions.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc);
        this.dsiTmcListener = (DSITmcListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = HsmTargetRouteOptions.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = HsmTargetRouteOptions.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener, this.dsiTmcListener);
    }

    public void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetRouteOptions.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = (DSINavigationListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetRouteOptions.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetRouteOptions.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        this.dsiNavigation.setNotification(new int[]{11}, (DSIListener)this.dsiNavigationListener);
    }

    void unregisterDsiServices(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetRouteOptions tries to unregister from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetRouteOptions.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiNavigation(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = HsmTargetRouteOptions.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName().intern()) {
                this.dsiTmc = null;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetRouteOptions.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
            this.traceUnregisterDone(string);
        }
    }

    private void traceUnregisterDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetRouteOptions unregistered from ").append(string).log();
        }
    }

    void traceState(String string) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    DSINavigation getDsiNavigation() {
        return this.dsiNavigation;
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetRouteOptions.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = HsmTargetRouteOptions.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName(), 0);
        if (bl || bl2) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetRouteOptions: resetting values after DSI restart");
            }
            if (bl) {
                this.initDsiNavigation();
            }
            if (bl2) {
                this.initDsiTmc();
            }
            this.stateRouteOptionsWork.init();
            this.stateRouteOptionsWork.sendRouteOptionsToDsi();
            this.stateRouteOptionsWork.sendTmcStatisticalDataToDsi();
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetRouteOptions: no reset necessary because restarted DSI(s) is/are not used in target");
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

