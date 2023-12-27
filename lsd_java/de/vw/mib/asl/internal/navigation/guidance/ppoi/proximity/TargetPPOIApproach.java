/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.ppoi.proximity;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.guidance.GuidanceInternalAPINotifier;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DSINavigation;

public class TargetPPOIApproach
extends AbstractResettableAslTarget
implements DSIServiceStateListener {
    public static final int AW_ASL_INT_STOP_WARNING_ICON_DISPLAY;
    public static final int AW_ASL_INT_WARNING_ICON_DISPLAY_INTERVAL_MS;
    private DSINavigation dsiNavigation;
    private DSIListener navigationListener;
    private boolean isServiceStateListenerAdded = false;
    private GuidanceInternalAPINotifier guidanceInternalAPINotifier;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public TargetPPOIApproach(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.traceState("TargetPPOIApproach");
        this.guidanceInternalAPINotifier = new GuidanceInternalAPINotifier();
    }

    @Override
    public void registered(String string, int n) {
        if (this.isFirstStartupDone) {
            return;
        }
        if (string.intern() != (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetPPOIApproach.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            return;
        }
        if (this.isTraceEnabled()) {
            this.trace().append("TargetPPOIApproach tries to register to ").append(string).append("...").log();
        }
        this.initDSI();
        this.isFirstStartupDone = true;
        if (this.isTraceEnabled()) {
            this.trace().append("TargetPPOIApproach registered to ").append(string).log();
        }
    }

    private void initDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetPPOIApproach.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetPPOIApproach.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetPPOIApproach.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        this.dsiNavigation.setNotification(new int[]{89}, this.navigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetPPOIApproach.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace().append("TargetPPOIApproach tries to unregister from ").append(string).append("...").log();
            }
            try {
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                if (dSIProxy == null) {
                    this.trace().append("DSIProxy was null!");
                    return;
                }
                this.unregisterDsiNavigation(string, dSIProxy);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetPPOIApproach.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
            this.traceUnregisteredDone(string);
        }
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetPPOIApproach unregistered from ").append(string).log();
        }
    }

    public void traceState(String string) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append("PPOIAW: ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    public void dsiNavigationUpdatePOIsEnteringProximityRange(NavLocation[] navLocationArray, int n) {
        this.traceState(new StringBuffer("dsiNavigationUpdatePOIsEnteringProximityRange: ").append(n).toString());
        if (navLocationArray == null) {
            this.traceState("dsiNavigationUpdatePOIsEnteringProximityRange: No tone SHOULD be played");
        } else if (navLocationArray.length == 0) {
            this.traceState("dsiNavigationUpdatePOIsEnteringProximityRange: zero length list");
        } else if (n != 1) {
            this.traceState("dsiNavigationUpdatePOIsEnteringProximityRange: FLAG NOT VALID");
        } else {
            this.traceState(new StringBuffer("dsiNavigationUpdatePOIsEnteringProximityRange: poiLocations: ").append(navLocationArray[0].toString()).toString());
        }
        if (navLocationArray != null && navLocationArray.length > 0 && n == 1) {
            try {
                this.playPPOIAWTone();
                if (this.isSpeedCameraWarning()) {
                    this.displayWarningIcon();
                }
            }
            catch (GenericEventException genericEventException) {
                this.traceState("dsiNavigationUpdatePOIsEnteringProximityRange GenericEventException");
            }
        } else {
            this.traceState("dsiNavigationUpdatePOIsEnteringProximityRange: No tone played");
        }
    }

    private boolean isSpeedCameraWarning() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(158);
    }

    private void playPPOIAWTone() {
        this.traceState("playPPOIAWTone");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(638139648);
        eventGeneric.setInt(0, 3);
        this.send(eventGeneric);
    }

    private void displayWarningIcon() {
        this.traceState("displayWarningIcon");
        ServiceManager.aslPropertyManager.valueChangedBoolean(1592791040, true);
        this.guidanceInternalAPINotifier.sendEvSpeedCameraIconUpdate(true);
        this.startTimer(75956480, (long)0, false);
    }

    private void stopDisplayWarningIcon() {
        this.traceState("stopDisplayWarningIcon");
        ServiceManager.aslPropertyManager.valueChangedBoolean(1592791040, false);
        this.guidanceInternalAPINotifier.sendEvSpeedCameraIconUpdate(false);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isServiceStateListenerAdded) break;
                this.isServiceStateListenerAdded = true;
                ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetPPOIApproach.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                break;
            }
            case 100100: {
                this.traceState("AW_ASL_INT_STOP_WARNING_ICON_DISPLAY");
                this.stopDisplayWarningIcon();
                break;
            }
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isTraceEnabled()) {
            this.trace("TargetPPOIApproach: resetting values after DSI restart");
        }
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetPPOIApproach.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            this.initDSI();
        } else if (this.isTraceEnabled()) {
            this.trace("TargetPPOIApproach: no reset necessary because restarted DSI(s) is/are not used in target");
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

