/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.startup.StateWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.trafficregulation.DSITrafficRegulation;

public final class HsmTargetNavigation
extends AbstractResettableAslHsmTarget
implements DSIServiceStateListener {
    private static final int[] OBSERVERS = new int[]{-872349632, -889126848};
    private static final int[] ATTRIBUTES_NAVIGATION = new int[]{43, 76, 55};
    private static final int[] ATTRIBUTES_TRAFFICREGULATION = new int[]{2};
    private static final int[] ATTRIBUTES_GENERALVEHICLESTATES = new int[]{22};
    public static final int NAVIPARTSTATEOFOPERATION_P0_NAVIPART;
    final StateWork stateWork;
    private DSINavigation navigationService;
    private DSITrafficRegulation trafficRegulationService;
    private DSIGeneralVehicleStates generalVehicleStatesService;
    protected DSIListener navigationListener;
    protected DSIListener trafficRegulationListener;
    protected DSIListener generalVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulation;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public HsmTargetNavigation(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateWork = new StateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.navigationService = null;
        this.trafficRegulationService = null;
        this.generalVehicleStatesService = null;
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetNavigation.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetNavigation.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetNavigation.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this);
    }

    void addObservers() {
        this.addObservers(OBSERVERS);
    }

    void removeObservers() {
        this.removeObservers(OBSERVERS);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    public void registered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetNavigation registered ").append(string).log();
        }
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetNavigation.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (!this.isFirstStartupDone) {
                this.initDsiNavigation();
            }
        } else if (string.intern() == (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetNavigation.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName().intern()) {
            if (!this.isFirstStartupDone) {
                this.initDsiTrafficRegulation();
            }
        } else if (string.intern() == (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetNavigation.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName().intern() && !this.isFirstStartupDone) {
            this.initDsiGeneralVehicleStates();
        }
        if (this.navigationService != null && this.trafficRegulationService != null && this.generalVehicleStatesService != null) {
            this.isFirstStartupDone = true;
        }
    }

    private void initDsiGeneralVehicleStates() {
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.generalVehicleStatesService = (DSIGeneralVehicleStates)dSIProxy.getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetNavigation.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
            this.generalVehicleStatesListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = HsmTargetNavigation.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener);
            this.generalVehicleStatesService.setNotification(ATTRIBUTES_GENERALVEHICLESTATES, this.generalVehicleStatesListener);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void initDsiTrafficRegulation() {
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.trafficRegulationService = (DSITrafficRegulation)dSIProxy.getService(this, class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetNavigation.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation);
            this.trafficRegulationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener = HsmTargetNavigation.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulationListener")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener);
            this.trafficRegulationService.setNotification(ATTRIBUTES_TRAFFICREGULATION, this.trafficRegulationListener);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void initDsiNavigation() {
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.navigationService = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetNavigation.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
            this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetNavigation.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
            this.navigationService.setNotification(ATTRIBUTES_NAVIGATION, this.navigationListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetNavigation.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().setNotification();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetNavigation tries to unregistered from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetNavigation.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiNavigation(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetNavigation.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName().intern()) {
                this.unregisterDsiTrafficRegulation(string);
            } else if (string.intern() == (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetNavigation.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName().intern()) {
                this.unregisterDsiGeneralVehicleStates(string);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiGeneralVehicleStates(String string) {
        this.generalVehicleStatesListener = null;
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiTrafficRegulation(String string) {
        this.trafficRegulationListener = null;
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetNavigation.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetNavigation unregistered from ").append(string).log();
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetNavigation.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetNavigation.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), 0);
        boolean bl3 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetNavigation.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName(), 0);
        if (bl || bl2 || bl3) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetBap: resetting values after DSI restart");
            }
            if (bl) {
                this.initDsiNavigation();
            }
            if (bl2) {
                this.initDsiGeneralVehicleStates();
            }
            if (bl3) {
                this.initDsiTrafficRegulation();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetBap: no reset necessary because restarted DSI(s) is/are not used in target");
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

