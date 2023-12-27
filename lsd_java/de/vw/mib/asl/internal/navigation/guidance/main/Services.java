/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;
import org.dsi.ifc.swdlselection.DSISwdlSelection;
import org.dsi.ifc.swdlselection.DSISwdlSelectionListener;

final class Services
implements DSIServiceStateListener {
    private DSINavigation dsiNavigation;
    private DSIPowerManagement dsiPowerManagement;
    private DSIGeneralVehicleStates dsiGeneralVehicleStates;
    private DSINavigationListener dsiNavigationListener;
    private DSIPowerManagementListener dsiPowerManagementListener;
    private DSIGeneralVehicleStatesListener dsiGeneralVehicleStatesListener;
    private DSISwdlSelection dsiSwdlSelection;
    private DSISwdlSelectionListener dsiSwdlSelectionListener;
    private HsmTargetGuidance target;
    private static final int[] OBSERVER_DSINAV = new int[]{49, 11, 42, 4, 13, 23, 38, 75, 52, 14, 77};
    private static final int[] OBSERVER_DSISWDL = new int[]{3};
    private static final int[] OBSERVER_DSIPOWERMNG = new int[]{1, 4};
    private static final int[] OBSERVER_DSIGENERALVS = new int[]{22};
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelection;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener;

    Services(HsmTargetGuidance hsmTargetGuidance) {
        this.target = hsmTargetGuidance;
        ServiceManager.dsiServiceLocator.addServiceStateListener(this);
    }

    DSINavigation getNavigation() {
        return this.dsiNavigation;
    }

    DSIPowerManagement getPowermanagement() {
        return this.dsiPowerManagement;
    }

    DSIGeneralVehicleStates getGeneralVehicleStates() {
        return this.dsiGeneralVehicleStates;
    }

    @Override
    public void registered(String string, int n) {
        if (this.target.isFirstStartupDone) {
            return;
        }
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[133]) {
            this.initDsiSwdlSelection();
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
            this.initDsiNavigation();
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[112]) {
            this.initDsiPowerManagement();
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[42]) {
            this.initDsiGeneralVehicleStates();
        }
        if (this.dsiNavigation != null && this.dsiGeneralVehicleStates != null && this.dsiPowerManagement != null && this.dsiSwdlSelection != null) {
            this.target.isFirstStartupDone = true;
        }
    }

    void initDsiGeneralVehicleStates() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.target.traceState("DSI_GENERAL_VEHICLE_STATES service registered");
        this.dsiGeneralVehicleStates = (DSIGeneralVehicleStates)dSIProxy.getService(this.target, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = Services.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
        this.dsiGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = Services.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener);
        dSIProxy.addResponseListener(this.target, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = Services.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener, this.dsiGeneralVehicleStatesListener);
        this.dsiGeneralVehicleStates.setNotification(OBSERVER_DSIGENERALVS, (DSIListener)this.dsiGeneralVehicleStatesListener);
    }

    void initDsiPowerManagement() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.target.traceState("DSI_POWERMANAGEMENT service registered");
        this.dsiPowerManagement = (DSIPowerManagement)dSIProxy.getService(this.target, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = Services.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        this.dsiPowerManagementListener = (DSIPowerManagementListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = Services.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
        dSIProxy.addResponseListener(this.target, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = Services.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener, this.dsiPowerManagementListener);
        this.dsiPowerManagement.setNotification(OBSERVER_DSIPOWERMNG, (DSIListener)this.dsiPowerManagementListener);
    }

    void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.target.traceState("DSI_NAVIGATION service registered");
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this.target, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Services.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = (DSINavigationListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Services.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Services.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        this.dsiNavigation.setNotification(OBSERVER_DSINAV, (DSIListener)this.dsiNavigationListener);
    }

    void initDsiSwdlSelection() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.target.traceState("DSI_SWDLSELECTION service registered");
        this.dsiSwdlSelection = (DSISwdlSelection)dSIProxy.getService(this.target, class$org$dsi$ifc$swdlselection$DSISwdlSelection == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelection = Services.class$("org.dsi.ifc.swdlselection.DSISwdlSelection")) : class$org$dsi$ifc$swdlselection$DSISwdlSelection);
        this.dsiSwdlSelectionListener = (DSISwdlSelectionListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener = Services.class$("org.dsi.ifc.swdlselection.DSISwdlSelectionListener")) : class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener);
        this.dsiSwdlSelection.setNotification(OBSERVER_DSISWDL, (DSIListener)this.dsiSwdlSelectionListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("HsmTarget Guidance Main tries to unregister from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.target.trace().append("DSIProxy was null!");
                return;
            }
            String string2 = string.intern();
            if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[133]) {
                this.unregisterDsiSwdlSelection(string);
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
                this.target.getHsm().trans(this.target.stateDSINotAvailable);
                this.target.getHsm().activateTransition();
                this.unregisterDsiNavigation(string, dSIProxy);
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[112]) {
                this.unregisterDsiPowerManagement(string, dSIProxy);
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[42]) {
                this.unregisterDsiGeneralVehicleStates(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiGeneralVehicleStates(String string, DSIProxy dSIProxy) {
        if (this.dsiGeneralVehicleStatesListener != null) {
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = Services.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener, this.dsiGeneralVehicleStatesListener);
            this.dsiGeneralVehicleStatesListener = null;
        }
        this.traceUnregisterDone(string);
    }

    private void unregisterDsiPowerManagement(String string, DSIProxy dSIProxy) {
        if (this.dsiPowerManagementListener != null) {
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = Services.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener, this.dsiPowerManagementListener);
            this.dsiPowerManagementListener = null;
            this.traceUnregisterDone(string);
        }
        this.target.traceState("DSI_POWERMANAGEMENT service unregistered");
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Services.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
            this.traceUnregisterDone(string);
        }
        this.target.traceState("DSI_NAVIGATION service unregistered");
    }

    private void unregisterDsiSwdlSelection(String string) {
        if (this.dsiSwdlSelectionListener != null) {
            this.dsiSwdlSelectionListener = null;
            this.traceUnregisterDone(string);
        }
        this.target.traceState("DSI_SWDLSELECTION service unregistered");
    }

    private void traceUnregisterDone(String string) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("HsmTarget Guidance Main unregistered from ").append(string).log();
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

