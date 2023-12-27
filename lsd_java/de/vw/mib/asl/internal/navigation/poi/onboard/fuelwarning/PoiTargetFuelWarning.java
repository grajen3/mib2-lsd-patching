/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.poi.setup.PersistedPoiSetup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.generalvehiclestates.TankInfo;

public class PoiTargetFuelWarning
extends AbstractResettableAslTarget
implements DSIServiceStateListener,
TargetForResetNavigation {
    private DSIGeneralVehicleStates dsiGeneralVehicleStates;
    private static final int[] OBSERVERS = new int[]{-603848640};
    private DSIListener generalVehicleStatesListener;
    private static final int[] ATTIBUTES_GENERAL_VEHICLE_STATES = new int[]{4};
    private boolean wasServiceStateListenerRegistered = false;
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;

    public PoiTargetFuelWarning(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    public void traceState(String string) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public void errorState(String string) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.error(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                this.traceState("NAVI_TARGET_PREPARE_ON");
                break;
            }
            case 101001: {
                this.traceState("NAVI_TARGET_GO_ON");
                if (!this.wasServiceStateListenerRegistered) {
                    ServiceManager.dsiServiceLocator.addServiceStateListener(this);
                    this.wasServiceStateListenerRegistered = true;
                }
                this.addObservers(OBSERVERS);
                if (this.navigationResetParticipant != null) break;
                this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
                break;
            }
            case 101002: {
                this.traceState("NAVI_TARGET_PREPARE_OFF");
                break;
            }
            case 101000: {
                this.traceState("NAVI_TARGET_GO_OFF");
                this.removeObservers(OBSERVERS);
                if (this.navigationResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
                this.navigationResetParticipant = null;
                break;
            }
            case 106: {
                this.traceState("POWER_ON");
                break;
            }
            case 107: {
                this.traceState("POWER_OFF");
                break;
            }
            case 1073742556: {
                this.traceState("LOW_FUEL_WARNING");
                this.toggleLowFuelWarning();
                break;
            }
            default: {
                this.errorState("Unknown event!");
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[42] && !this.isFirstStartupDone) {
            this.initGeneralVehicleState();
            this.isFirstStartupDone = true;
        }
    }

    private void initGeneralVehicleState() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.traceState("DSI_GENERAL_VEHICLE_STATES service registered");
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        this.generalVehicleStatesListener = dSIServiceLocator.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = PoiTargetFuelWarning.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener);
        this.dsiGeneralVehicleStates = (DSIGeneralVehicleStates)dSIProxy.getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = PoiTargetFuelWarning.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
        this.dsiGeneralVehicleStates.setNotification(ATTIBUTES_GENERAL_VEHICLE_STATES, this.generalVehicleStatesListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = PoiTargetFuelWarning.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener, this.generalVehicleStatesListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("PoiTargetFuelWarning tries to unregistered from ").append(string).append("...").log();
        }
        try {
            String string2 = string.intern();
            if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[42]) {
                this.unregisterDsiGeneralVehicleStates(string);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiGeneralVehicleStates(String string) {
        if (this.generalVehicleStatesListener != null) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
            } else {
                dSIProxy.removeResponseListener(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = PoiTargetFuelWarning.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener, this.generalVehicleStatesListener);
                this.generalVehicleStatesListener = null;
            }
            this.traceUnregisteredDone(string);
        }
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("PoiTargetFuelWarning unregistered from ").append(string).log();
        }
    }

    public void dsiGeneralVehicleStatesUpdateTankInfo(TankInfo tankInfo, int n) {
        this.traceState("dsiGeneralVehicleStatesUpdateTankInfo");
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(523) && PersistedPoiSetup.getInstance().getFuelOptionsFuelWarning() && n == 1 && tankInfo != null && (tankInfo.fuelWarning || tankInfo.fuelWarningSecondary)) {
            this.showFuelWarningPopup(tankInfo.fuelWarning, tankInfo.fuelWarningSecondary);
        }
    }

    private void toggleLowFuelWarning() {
        this.traceState("toggleLowFuelWarning");
        this.setLowFuelWarning(!PersistedPoiSetup.getInstance().getFuelOptionsFuelWarning());
    }

    private void setLowFuelWarning(boolean bl) {
        this.traceState("setLowFuelWarning");
        PersistedPoiSetup.getInstance().setFuelOptionsFuelWarning(bl);
        PersistedPoiSetup.getInstance().updatePropertyFuelOptionsFuelWarning();
        if (PersistedPoiSetup.getInstance().getFuelOptionsFuelWarning()) {
            this.forceUpdateOfTankInfo();
        }
    }

    void forceUpdateOfTankInfo() {
        this.traceState("forceUpdateOfTankInfo");
        this.dsiGeneralVehicleStates.setNotification(4, this.generalVehicleStatesListener);
    }

    private void showFuelWarningPopup(boolean bl, boolean bl2) {
        this.traceState("showFuelWarningPopup");
        int n = ServiceManager.configManagerDiag.getPrimaryFuelType();
        int n2 = ServiceManager.configManagerDiag.getSecondaryFuelType();
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(" : showFuelWarningPopup  primary:");
            logMessage.append(bl ? "TRUE" : "FALSE");
            logMessage.append(bl2 ? "  secondary:TRUE" : "  secondary:FALSE");
            logMessage.append("  .getPrimaryFuelType():");
            logMessage.append(n);
            logMessage.append("  .getSecondaryFuelType():");
            logMessage.append(n2);
            logMessage.log();
        }
        int n3 = -1;
        if (bl && !bl2) {
            n3 = n == 1 ? -101773312 : -118550528;
        } else if (!bl && bl2) {
            if (n == 2) {
                n3 = -84996096;
            } else if (n == 3) {
                n3 = -51441664;
            }
        } else if (bl && bl2) {
            if (n == 2 || n2 == 2) {
                n3 = -68218880;
            } else if (n == 3 || n2 == 3) {
                n3 = -34664448;
            } else if (n == 0 && n2 == 0) {
                n3 = -118550528;
            } else if (n == 1) {
                n3 = -101773312;
            }
        }
        this.traceState(String.valueOf(n3));
        if (n3 == -1) {
            this.errorState("No mapping for this engine types available");
        } else if (n3 == -101773312 || n3 == -118550528) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(81);
        } else {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n3);
        }
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.setLowFuelWarning(true);
        this.navigationResetParticipant.notifyResetDone();
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = PoiTargetFuelWarning.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetDestList: resetting values after DSI restart");
            }
            this.initLocalVariables();
            this.initGeneralVehicleState();
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetDestList: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.wasServiceStateListenerRegistered = false;
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

