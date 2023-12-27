/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerStateInit;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerControl;

public class DSIMapViewerControlSwitchMapviewerStateSwitch
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapviewerStateSwitch]");
    private final DSIMapViewerControlSwitchMapviewerTargetHSM target;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControlListener;

    public DSIMapViewerControlSwitchMapviewerStateSwitch(DSIMapViewerControlSwitchMapviewerTargetHSM dSIMapViewerControlSwitchMapviewerTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerControlSwitchMapviewerTargetHSM.getHsm(), string, hsmState);
        this.target = dSIMapViewerControlSwitchMapviewerTargetHSM;
    }

    public HsmState dsiMapViewerControlSuspendMapViewerResult(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlSuspendMapViewerResult(").append(n).append(")").log();
        }
        return null;
    }

    public HsmState dsiMapViewerControlUpdateMapViewerRunLevel(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateMapViewerRunLevel(").append(n).append(")").log();
        }
        if (n == 4) {
            this.updateMapViewerRunLevelAwake();
        } else if (n == 5) {
            this.updateMapViewerRunLevelSuspensionNotPossible();
        } else if (n == 6) {
            this.updateMapViewerRunLevelWakeupNotPossible();
        } else if (n == 1) {
            this.updateMapViewerRunLevelSuspended();
        } else if (n == 0) {
            this.updateMapViewerRunLevelSuspensionsInProgress();
        } else if (n == 2) {
            this.updateMapViewerRunLevelWakeupInProgress();
        } else {
            this.logger.makeWarn().append("undefined dsi response, mapViewerRunlevel '").append(n).append("' is unknown").log();
        }
        return null;
    }

    public HsmState dsiMapViewerControlWakeupMapViewerResult(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlWakeupMapViewerResult(").append(n).append(")").log();
        }
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 3499009: {
                this.handleSwitchMapViewerTimeOutWakeup();
                break;
            }
            case 3499010: {
                this.handleSwitchMapViewerTimeOutSuspend();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        int n = this.target.datapool.getMapViewerNewId();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("switchToMapViewer=").append(n).log();
        }
        if (n != 0 && n != 1) {
            this.logger.makeWarn().append("mapViewerInstanceId '").append(n).append("' is invalid, the mapViewer won't be switched").log();
            return;
        }
        DSIMapViewerControl[] dSIMapViewerControlArray = this.target.datapool.getDsiMapViewerControlsMainMap();
        if (dSIMapViewerControlArray.length <= 1) {
            this.logger.error("MapViewer won't be switched, because there is only one MapViewer at the moment");
            return;
        }
        this.target.managerTarget.setCreateMainMapMapViewerEnabled(false);
        this.target.managerTarget.mapViewerFacadesSetStatusMainMap(false);
        if (!this.target.datapool.isGoogleEarthRegistered()) {
            this.logger.trace("the google earth MapViewer is not available anymore, so we don't have to suspend him. We just wake up the onboard MapViewer");
            this.dsiMapViewerControlSuspendMapViewerResult(0);
            return;
        }
        int n2 = this.target.datapool.getDsiMapViewerControlCurrentMainMapInstanceId();
        if (n == n2) {
            this.logger.makeError().append("MapViewer with instanceId '").append(n2).append("' is the current MapViewerInstance, a second switch to this mapViewer is an error, but we'll try it anyway").log();
            this.dsiMapViewerControlSuspendMapViewerResult(0);
        } else {
            this.target.notifierModel.notifyMapViewerSwitchRunning();
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainSwitchMapViewerRunning();
            this.startTimerSuspend();
            this.mapViewerCurrentSuspend();
        }
    }

    private void handleSwitchMapViewerTimeOutSuspend() {
        this.logger.trace("handleSwitchMapViewerTimeOutSuspend()");
        if (this.target.datapool.isMapViewerCurrentSuspendedReceived()) {
            this.logger.trace("The old MapViewer is suspended, we ignore this timeout");
            return;
        }
        this.logger.makeError().append("The old MapViewer '").append(this.target.datapool.getMapViewerNewId()).append("' did not send the 'suspendMapViewerResult(int)' response within '").append(5000).append("' milliseconds, so we now call this method directly to bring the model in an valid state").log();
        this.dsiMapViewerControlSuspendMapViewerResult(0);
    }

    private void handleSwitchMapViewerTimeOutWakeup() {
        this.logger.trace("handleSwitchMapViewerTimeOutWakeup()");
        if (this.target.datapool.isMapViewerCurrentAwakeReceived()) {
            this.logger.trace("The new MapViewer is awake, we ignore this timeout");
            return;
        }
        this.logger.makeError().append("The new MapViewer did not send the 'wakeupMapViewerResult(int)' response within '").append(5000).append("' milliseconds, so we now call this method directly to bring the model in an valid state").log();
        this.updateMapViewerRunLevelAwake();
    }

    private void mapViewerCurrentSuspend() {
        this.logger.trace("mapViewerCurrentSuspend()");
        this.target.datapool.setSuspendInProgress(true);
        this.target.datapool.setMapViewerCurrentSuspendedReceived(false);
        DSIMapViewerControl dSIMapViewerControl = this.target.datapool.getDsiMapViewerControlCurrentMainMap();
        dSIMapViewerControl.suspendMapViewer();
    }

    private void mapViewerCurrentSwitchToNew(int n) {
        this.logger.trace("mapViewerCurrentSwitchToNew()");
        DSIMapViewerControl[] dSIMapViewerControlArray = this.target.datapool.getDsiMapViewerControlsMainMap();
        if (n == 0) {
            this.target.datapool.setDsiMapViewerControlCurrentMainMap(dSIMapViewerControlArray[0]);
            this.target.datapool.setDsiMapViewerControlCurrentMainMapInstanceId(0);
        } else if (n == 1) {
            this.target.datapool.setDsiMapViewerControlCurrentMainMap(dSIMapViewerControlArray[1]);
            this.target.datapool.setDsiMapViewerControlCurrentMainMapInstanceId(1);
        }
    }

    private void mapViewerCurrentWakeup() {
        this.logger.trace("mapViewerCurrentWakeup()");
        this.target.datapool.setMapViewerCurrentAwakeReceived(false);
        DSIMapViewerControl dSIMapViewerControl = this.target.datapool.getDsiMapViewerControlCurrentMainMap();
        dSIMapViewerControl.wakeupMapViewer();
    }

    private void mapViewerResponseListenerAndNotificationAddGoogleEarth() {
        this.logger.trace("mapViewerResponseListenerAndNotificationAddGoogleEarth()");
        DSIMapViewerControl[] dSIMapViewerControlArray = this.target.datapool.getDsiMapViewerControlsMainMap();
        this.target.proxy.addResponseListener(this.target, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerControlSwitchMapviewerStateSwitch.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, 1, this.target.datapool.getDsiMapViewerControlListener());
        DSIMapViewerControl dSIMapViewerControl = dSIMapViewerControlArray[1];
        dSIMapViewerControl.setNotification(DSIMapViewerControlSwitchMapviewerStateInit.ATTRIBUTES_MAPVIEWER_CONTROL, (DSIListener)this.target.datapool.getDsiMapViewerControlListener());
    }

    private void mapViewerResponseListenerAndNotificationAddOnboard() {
        this.logger.trace("mapViewerResponseListenerAndNotificationAddOnboard()");
        DSIMapViewerControl[] dSIMapViewerControlArray = this.target.datapool.getDsiMapViewerControlsMainMap();
        this.target.proxy.addResponseListener(this.target, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerControlSwitchMapviewerStateSwitch.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, 0, this.target.datapool.getDsiMapViewerControlListener());
        DSIMapViewerControl dSIMapViewerControl = dSIMapViewerControlArray[0];
        dSIMapViewerControl.setNotification(DSIMapViewerControlSwitchMapviewerStateInit.ATTRIBUTES_MAPVIEWER_CONTROL, (DSIListener)this.target.datapool.getDsiMapViewerControlListener());
    }

    private void mapViewerResponseListenerAndNotificationRemoveGoogleEarth() {
        this.logger.trace("mapViewerResponseListenerAndNotificationRemoveGoogleEarth()");
        if (!this.target.datapool.isGoogleEarthRegistered()) {
            return;
        }
        DSIMapViewerControl[] dSIMapViewerControlArray = this.target.datapool.getDsiMapViewerControlsMainMap();
        this.target.proxy.removeResponseListener(this.target, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerControlSwitchMapviewerStateSwitch.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, 1, this.target.datapool.getDsiMapViewerControlListener());
        dSIMapViewerControlArray[1].clearNotification(DSIMapViewerControlSwitchMapviewerStateInit.ATTRIBUTES_MAPVIEWER_CONTROL, (DSIListener)this.target.datapool.getDsiMapViewerControlListener());
    }

    private void mapViewerResponseListenerAndNotificationRemoveOnboard() {
        this.logger.trace("mapViewerResponseListenerAndNotificationRemoveOnboard()");
        DSIMapViewerControl[] dSIMapViewerControlArray = this.target.datapool.getDsiMapViewerControlsMainMap();
        this.target.proxy.removeResponseListener(this.target, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerControlSwitchMapviewerStateSwitch.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, 0, this.target.datapool.getDsiMapViewerControlListener());
        dSIMapViewerControlArray[0].clearNotification(DSIMapViewerControlSwitchMapviewerStateInit.ATTRIBUTES_MAPVIEWER_CONTROL, (DSIListener)this.target.datapool.getDsiMapViewerControlListener());
    }

    private void startTimerSuspend() {
        this.logger.trace("startTimerSuspend()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), 40121600);
        this.target.startTimer(eventGeneric, 0, false, true);
    }

    private void startTimerWakeup() {
        this.logger.trace("startTimerWakeup()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), 23344384);
        this.target.startTimer(eventGeneric, 0, false, true);
    }

    private void updateMapViewerRunLevelAwake() {
        this.logger.trace("updateMapViewerRunLevelAwake()");
        this.target.stopTimer(23344384);
        if (this.target.datapool.isMapViewerCurrentAwakeReceived()) {
            this.logger.error("The runlevel 'awake' was received, but the mapViewer is already awake, this update will be ignored");
            return;
        }
        this.target.datapool.setMapViewerCurrentAwakeReceived(true);
        this.target.datapool.setWakeupInProgress(false);
        this.target.transStateConfigureMapViewerNew();
    }

    private void updateMapViewerRunLevelSuspended() {
        this.logger.trace("updateMapViewerRunLevelSuspended()");
        if (this.target.datapool.isWakeupInProgress()) {
            if (!this.target.datapool.isRunlevelSuspendedReveivedAfterSetNotification()) {
                this.target.datapool.setRunlevelSuspendedReveivedAfterSetNotification(true);
                return;
            }
            this.target.datapool.setRunlevelSuspendedReveivedAfterSetNotification(false);
        }
        this.target.stopTimer(40121600);
        this.target.datapool.setMapViewerCurrentSuspendedReceived(true);
        this.target.datapool.setSuspendInProgress(false);
        this.target.datapool.setWakeupInProgress(true);
        int n = this.target.datapool.getMapViewerNewId();
        if (n == 0) {
            this.target.managerTarget.mapViewersResponseListenerAndNotificationRemove(1);
            this.mapViewerResponseListenerAndNotificationRemoveGoogleEarth();
            this.mapViewerResponseListenerAndNotificationAddOnboard();
        } else {
            this.target.managerTarget.mapViewersResponseListenerAndNotificationRemove(0);
            this.mapViewerResponseListenerAndNotificationRemoveOnboard();
            this.mapViewerResponseListenerAndNotificationAddGoogleEarth();
        }
        this.mapViewerCurrentSwitchToNew(n);
        this.startTimerWakeup();
        this.mapViewerCurrentWakeup();
    }

    private void updateMapViewerRunLevelSuspensionNotPossible() {
        this.logger.error("updateMapViewerRunLevelSuspensionNotPossible()");
    }

    private void updateMapViewerRunLevelSuspensionsInProgress() {
        this.logger.trace("updateMapViewerRunLevelSuspensionsInProgress()");
    }

    private void updateMapViewerRunLevelWakeupInProgress() {
        this.logger.trace("updateMapViewerRunLevelWakeupInProgress()");
    }

    private void updateMapViewerRunLevelWakeupNotPossible() {
        this.logger.error("updateMapViewerRunLevelWakeupNotPossible()");
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

