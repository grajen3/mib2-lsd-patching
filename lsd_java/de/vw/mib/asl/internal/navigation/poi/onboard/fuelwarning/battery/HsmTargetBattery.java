/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.Services;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.StateActivateBatteryCheck;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.StateIdleRgActive;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.StateIdleRgNotActive;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.StateInit;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.StateRangeWarningCanceled;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.StateRangeWarningDestination;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.StateRangeWarningHome;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.StateRemainingRangeNotValid;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.StateWork;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class HsmTargetBattery
extends AbstractResettableAslHsmTarget {
    public static final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(512, "[HsmTargetBattery] ");
    Services services;
    public final StateActivateBatteryCheck stateActivateBatteryCheck;
    public final StateWork stateWork;
    public final StateRangeWarningCanceled stateRangeWarningCanceled;
    public final StateInit stateInit;
    public final StateIdleRgActive stateIdleRgActive;
    public final StateIdleRgNotActive stateIdleRgNotActive;
    public final StateRangeWarningHome stateRangeWarningHome;
    public final StateRangeWarningDestination stateRangeWarningDestination;
    public final StateRemainingRangeNotValid stateRemainingRangeNotValid;
    public static final int EV_ASL_INT_CHECK_DISTANCE;
    public static final int EV_ASL_INT_CHECK_DISTANCE_INTERVAL_MS;
    boolean isDestinationWarning;
    boolean isHomeWarning;
    boolean isPreventFirstHomeWarning;
    boolean isRgActive;
    int remainingRange;
    Route currentRoute;
    boolean isCharging;
    RgInfoForNextDestination infoForNextDestination;
    boolean isHomeWarningCanceled;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybrid;

    public HsmTargetBattery(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateActivateBatteryCheck = new StateActivateBatteryCheck(this, this.hsm, "stateActivateBatteryCheck", this.getWorkStateParent());
        this.stateWork = new StateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.stateRangeWarningCanceled = new StateRangeWarningCanceled(this, this.hsm, "stateRangeWarningCanceled", this.stateWork);
        this.stateInit = new StateInit(this, this.hsm, "stateInit", this.stateWork);
        this.stateIdleRgActive = new StateIdleRgActive(this, this.hsm, "stateIdleRgActive", this.stateWork);
        this.stateIdleRgNotActive = new StateIdleRgNotActive(this, this.hsm, "stateIdleRgNotActive", this.stateWork);
        this.stateRangeWarningHome = new StateRangeWarningHome(this, this.hsm, "stateRangeWarningActiveHome", this.stateWork);
        this.stateRangeWarningDestination = new StateRangeWarningDestination(this, this.hsm, "stateRangeWarningActiveDestination", this.stateWork);
        this.stateRemainingRangeNotValid = new StateRemainingRangeNotValid(this, this.hsm, "stateRemainingRangeNotValid", this.stateWork);
        this.isDestinationWarning = false;
        this.isHomeWarning = false;
        this.isPreventFirstHomeWarning = false;
        this.isRgActive = false;
        this.remainingRange = -16842752;
        this.currentRoute = null;
        this.isCharging = false;
        this.infoForNextDestination = null;
        this.isHomeWarningCanceled = false;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateActivateBatteryCheck;
    }

    public void traceState(AbstractHsmState abstractHsmState, String string) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(".");
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public void warnState(AbstractHsmState abstractHsmState, String string) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.warn(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(".");
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public void initDSI() {
        this.services = new Services(this);
    }

    boolean isRemainingRangeValid() {
        return this.remainingRange != -16842752 && this.remainingRange != -65536;
    }

    boolean isInfoForNextDestValid() {
        return this.infoForNextDestination != null;
    }

    boolean isCurrentRouteValid() {
        return this.currentRoute != null && this.currentRoute.routelist != null && this.currentRoute.routelist.length > 0;
    }

    public void resetGuidanceData() {
        this.currentRoute = null;
        this.infoForNextDestination = null;
    }

    public void preventValueInconsistence(AbstractHsmState abstractHsmState) {
        NavLocation navLocation;
        if (this.isHomeWarning && ((navLocation = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation()) == null || !navLocation.isPositionValid())) {
            this.warnState(abstractHsmState, "Home destination is null or not valid-> Home range warning will be deactivated!");
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(151650368);
            eventGeneric.setBoolean(0, false);
            this.send(eventGeneric);
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBattery.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = HsmTargetBattery.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco).getName(), 0);
        boolean bl3 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$carhybrid$DSICarHybrid == null ? (class$org$dsi$ifc$carhybrid$DSICarHybrid = HsmTargetBattery.class$("org.dsi.ifc.carhybrid.DSICarHybrid")) : class$org$dsi$ifc$carhybrid$DSICarHybrid).getName(), 0);
        if (bl || bl2 || bl3) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetBattery: resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateRemainingRangeNotValid);
            this.initLocalVariables();
            if (this.services != null) {
                if (bl) {
                    this.services.initDsiNavigation();
                }
                if (bl2) {
                    this.services.initDsiCarEco();
                }
                if (bl3) {
                    this.services.initDsiCarHybrid();
                }
            } else {
                this.warn("HsmTargetBattery: Service instance is null!");
            }
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetBattery: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.isDestinationWarning = false;
        this.isHomeWarning = false;
        this.isPreventFirstHomeWarning = false;
        this.isRgActive = false;
        this.remainingRange = -16842752;
        this.currentRoute = null;
        this.isCharging = false;
        this.infoForNextDestination = null;
        this.isHomeWarningCanceled = false;
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

