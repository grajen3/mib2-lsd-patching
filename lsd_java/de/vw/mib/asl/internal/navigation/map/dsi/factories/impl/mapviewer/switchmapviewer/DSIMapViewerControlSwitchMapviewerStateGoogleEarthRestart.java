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

public class DSIMapViewerControlSwitchMapviewerStateGoogleEarthRestart
extends AbstractHsmState {
    private static final int TIMEOUT_WAKEUP;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapviewerStateGoogleEarthRestart]");
    private final DSIMapViewerControlSwitchMapviewerTargetHSM target;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControlListener;

    public DSIMapViewerControlSwitchMapviewerStateGoogleEarthRestart(DSIMapViewerControlSwitchMapviewerTargetHSM dSIMapViewerControlSwitchMapviewerTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerControlSwitchMapviewerTargetHSM.getHsm(), string, hsmState);
        this.target = dSIMapViewerControlSwitchMapviewerTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateMapViewerRunLevel(int n, int n2) {
        this.target.stopTimer(23344384);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateMapViewerRunLevel(").append(n).append(")").log();
        }
        if (n == 4) {
            this.target.transStateConfigureMapViewerNew();
        }
        return null;
    }

    public void dsiMapViewerControlUpdateReady(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateReady(ready=").append(bl).append(")").log();
        }
        this.startTimerWakeup();
        DSIMapViewerControl dSIMapViewerControl = this.target.datapool.getDsiMapViewerControlCurrentMainMap();
        dSIMapViewerControl.wakeupMapViewer();
    }

    private void startTimerWakeup() {
        this.logger.trace("startTimerWakeup()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), 23344384);
        this.target.startTimer(eventGeneric, 0, false, true);
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
                this.handleMapviewerTimeoutWakeup();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleMapviewerTimeoutWakeup() {
        this.logger.trace("handleMapviewerTimeoutWakeup()");
        this.target.transStateConfigureMapViewerNew();
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
        DSIMapViewerControl dSIMapViewerControl = this.target.datapool.getDsiMapViewerControlsMainMap()[1];
        this.target.proxy.addResponseListener(this.target, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerControlSwitchMapviewerStateGoogleEarthRestart.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, 1, this.target.datapool.getDsiMapViewerControlListener());
        dSIMapViewerControl.setNotification(DSIMapViewerControlSwitchMapviewerStateInit.ATTRIBUTES_MAPVIEWER_CONTROL, (DSIListener)this.target.datapool.getDsiMapViewerControlListener());
        this.target.managerTarget.mapViewerFacadesSetStatusMainMap(true);
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

