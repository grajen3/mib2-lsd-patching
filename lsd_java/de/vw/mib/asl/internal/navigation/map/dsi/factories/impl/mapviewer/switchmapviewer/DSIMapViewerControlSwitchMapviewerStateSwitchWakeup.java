/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

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

public class DSIMapViewerControlSwitchMapviewerStateSwitchWakeup
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapviewerStateSwitchWakeup]");
    private final DSIMapViewerControlSwitchMapviewerTargetHSM target;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControlListener;

    public DSIMapViewerControlSwitchMapviewerStateSwitchWakeup(DSIMapViewerControlSwitchMapviewerTargetHSM dSIMapViewerControlSwitchMapviewerTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerControlSwitchMapviewerTargetHSM.getHsm(), string, hsmState);
        this.target = dSIMapViewerControlSwitchMapviewerTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateMapViewerRunLevel(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateMapViewerRunLevel(").append(n).append(")").log();
        }
        if (n == 4) {
            this.updateMapViewerRunLevelAwake();
        } else if (n == 2) {
            this.updateMapViewerRunLevelWakeupInProgress();
        } else if (n == 6) {
            this.updateMapViewerRunLevelWakeupNotPossible();
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
        if (n == 0) {
            this.mapViewerResponseListenerAndNotificationAddOnboard();
        } else {
            this.mapViewerResponseListenerAndNotificationAddGoogleEarth();
        }
        this.timerWakeupStart();
        this.mapViewerWakeup();
    }

    private void handleSwitchMapViewerTimeOutWakeup() {
        this.logger.trace("handleSwitchMapViewerTimeOutWakeup()");
        if (this.target.datapool.isMapViewerCurrentAwakeReceived()) {
            this.logger.trace("The new MapViewer is awake, we ignore this timeout");
            return;
        }
        this.logger.makeError().append("The new MapViewer did not send the 'wakeupMapViewerResult(int)' response within '").append(5000).append("' milliseconds, so we now call this method directly to bring the model in an valid state").log();
        this.dsiMapViewerControlUpdateMapViewerRunLevel(4, 1);
    }

    private void mapViewerResponseListenerAndNotificationAddGoogleEarth() {
        this.logger.trace("mapViewerResponseListenerAndNotificationAddGoogleEarth()");
        DSIMapViewerControl[] dSIMapViewerControlArray = this.target.datapool.getDsiMapViewerControlsMainMap();
        this.target.proxy.addResponseListener(this.target, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerControlSwitchMapviewerStateSwitchWakeup.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, 1, this.target.datapool.getDsiMapViewerControlListener());
        DSIMapViewerControl dSIMapViewerControl = dSIMapViewerControlArray[1];
        dSIMapViewerControl.setNotification(DSIMapViewerControlSwitchMapviewerStateInit.ATTRIBUTES_MAPVIEWER_CONTROL, (DSIListener)this.target.datapool.getDsiMapViewerControlListener());
    }

    private void mapViewerResponseListenerAndNotificationAddOnboard() {
        this.logger.trace("mapViewerResponseListenerAndNotificationAddOnboard()");
        DSIMapViewerControl[] dSIMapViewerControlArray = this.target.datapool.getDsiMapViewerControlsMainMap();
        this.target.proxy.addResponseListener(this.target, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerControlSwitchMapviewerStateSwitchWakeup.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, 0, this.target.datapool.getDsiMapViewerControlListener());
        DSIMapViewerControl dSIMapViewerControl = dSIMapViewerControlArray[0];
        dSIMapViewerControl.setNotification(DSIMapViewerControlSwitchMapviewerStateInit.ATTRIBUTES_MAPVIEWER_CONTROL, (DSIListener)this.target.datapool.getDsiMapViewerControlListener());
    }

    private void mapViewerWakeup() {
        this.logger.trace("mapViewerCurrentWakeup()");
        this.target.datapool.setMapViewerCurrentAwakeReceived(false);
        DSIMapViewerControl dSIMapViewerControl = this.target.datapool.getDsiMapViewerControlCurrentMainMap();
        dSIMapViewerControl.wakeupMapViewer();
    }

    private void timerWakeupStart() {
        this.logger.trace("timerWakeupStart()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), 23344384);
        this.target.startTimer(eventGeneric, 0, false, true);
    }

    private void timerWakeupStop() {
        this.logger.trace("timerWakeupStop()");
        this.target.stopTimer(23344384);
    }

    private void updateMapViewerRunLevelAwake() {
        this.logger.trace("updateMapViewerRunLevelAwake()");
        this.timerWakeupStop();
        if (this.target.datapool.isMapViewerCurrentAwakeReceived()) {
            this.logger.error("The runlevel 'awake' was received, but the mapViewer is already awake, this update will be ignored");
            return;
        }
        this.target.datapool.setMapViewerCurrentAwakeReceived(true);
        this.target.datapool.setWakeupInProgress(false);
        this.target.transStateConfigureMapViewerNew();
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

