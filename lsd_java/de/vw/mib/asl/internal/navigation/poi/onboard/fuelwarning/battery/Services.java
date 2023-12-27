/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.HsmTargetBattery;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.careco.DSICarEcoListener;
import org.dsi.ifc.carhybrid.DSICarHybrid;
import org.dsi.ifc.carhybrid.DSICarHybridListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;

public final class Services
implements DSIServiceStateListener {
    private HsmTargetBattery target;
    DSICarEco dsiCarEco = null;
    private DSICarEcoListener dsiCarEcoListener;
    DSICarHybrid dsiCarHybrid = null;
    private DSICarHybridListener dsiCarHybridListener;
    DSINavigation dsiNavigation = null;
    private DSINavigationListener dsiNavigationListener;
    private DSIServiceLocator locator;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybrid;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybridListener;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEcoListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public Services(HsmTargetBattery hsmTargetBattery) {
        this.target = hsmTargetBattery;
        this.locator = ServiceManager.dsiServiceLocator;
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Services.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = Services.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$carhybrid$DSICarHybrid == null ? (class$org$dsi$ifc$carhybrid$DSICarHybrid = Services.class$("org.dsi.ifc.carhybrid.DSICarHybrid")) : class$org$dsi$ifc$carhybrid$DSICarHybrid, this);
    }

    public boolean isDsiRegistered() {
        boolean bl = false;
        if (this.dsiCarEco != null && this.dsiCarHybrid != null && this.dsiNavigation != null) {
            bl = true;
        }
        return bl;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (!this.target.isFirstStartupDone) {
            if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
                this.initDsiNavigation();
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[21]) {
                this.initDsiCarEco();
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[22]) {
                this.initDsiCarHybrid();
            }
        }
        if (this.dsiNavigation != null && this.dsiCarEco != null && this.dsiCarHybrid != null) {
            this.target.isFirstStartupDone = true;
        }
    }

    void initDsiCarHybrid() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.target.traceState(this.target.stateInit, "[HsmTargetBEV] Services.registered(): DSICarHybrid");
        this.dsiCarHybrid = (DSICarHybrid)dSIProxy.getService(this.target, class$org$dsi$ifc$carhybrid$DSICarHybrid == null ? (class$org$dsi$ifc$carhybrid$DSICarHybrid = Services.class$("org.dsi.ifc.carhybrid.DSICarHybrid")) : class$org$dsi$ifc$carhybrid$DSICarHybrid);
        if (this.dsiCarHybrid == null) {
            this.target.warn("Instance of DSICarHybrid was null!");
            return;
        }
        this.dsiCarHybridListener = (DSICarHybridListener)this.locator.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$carhybrid$DSICarHybridListener == null ? (class$org$dsi$ifc$carhybrid$DSICarHybridListener = Services.class$("org.dsi.ifc.carhybrid.DSICarHybridListener")) : class$org$dsi$ifc$carhybrid$DSICarHybridListener);
        if (this.dsiCarHybridListener == null) {
            this.target.warn("Instance of DSICarHybridListener was null!");
            return;
        }
        this.dsiCarHybrid.setNotification(8, (DSIListener)this.dsiCarHybridListener);
    }

    void initDsiCarEco() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.target.traceState(this.target.stateInit, "[HsmTargetBEV] Services.registered(): DSICarEco");
        this.dsiCarEco = (DSICarEco)dSIProxy.getService(this.target, class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = Services.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco);
        if (this.dsiCarEco == null) {
            this.target.warn("Instance of DSICarEco was null!");
            return;
        }
        this.dsiCarEcoListener = (DSICarEcoListener)this.locator.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = Services.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener);
        if (this.dsiCarEcoListener == null) {
            this.target.warn("Instance of DSICarEcoListener was null!");
            return;
        }
        this.dsiCarEco.setNotification(new int[]{38}, (DSIListener)this.dsiCarEcoListener);
    }

    void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.target.traceState(this.target.stateInit, "[HsmTargetBEV] Services.registered(): DSINavigation");
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this.target, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Services.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        if (this.dsiNavigation == null) {
            this.target.warn("Instance of DSINavigation was null!");
            return;
        }
        this.dsiNavigationListener = (DSINavigationListener)this.locator.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Services.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        if (this.dsiNavigationListener == null) {
            this.target.warn("Instance of DSINavigationListener was null!");
            return;
        }
        this.dsiNavigation.setNotification(new int[]{11, 13, 75}, (DSIListener)this.dsiNavigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("HsmTargetBattery tries to unregistered from ").append(string).append("...").log();
        }
        try {
            String string2 = string.intern();
            if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
                this.unregisterDsiNavigation(string);
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[21]) {
                this.unregisterDsiCarEco(string);
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[22]) {
                this.unregisterDsiCarHybrid(string);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void unregisterDsiCarHybrid(String string) {
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiCarEco(String string) {
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiNavigation(String string) {
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("HsmTargetBattery unregistered from ").append(string).log();
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

