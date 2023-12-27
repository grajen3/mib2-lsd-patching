/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.DSIMapViewerControl;

public class DSIMapViewerControlSwitchMapviewerStateGoogleEarthStart
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapviewerStateGoogleEarthStart]");
    private final DSIMapViewerControlSwitchMapviewerTargetHSM target;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public DSIMapViewerControlSwitchMapviewerStateGoogleEarthStart(DSIMapViewerControlSwitchMapviewerTargetHSM dSIMapViewerControlSwitchMapviewerTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerControlSwitchMapviewerTargetHSM.getHsm(), string, hsmState);
        this.target = dSIMapViewerControlSwitchMapviewerTargetHSM;
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
        boolean bl = this.target.datapool.isGoogleEarthRegistered();
        if (bl) {
            this.logger.error("Google Earth is already registered, a second registration is an Error!");
            return;
        }
        this.target.datapool.setGoogleEarthRegistered(true);
        this.initGoogleEarthMapViewer();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapSwitcherReady();
        this.switchToGoogleEarth();
    }

    private void initGoogleEarthMapViewer() {
        DSIMapViewerControl dSIMapViewerControl = (DSIMapViewerControl)this.target.proxy.getService(this.target, class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerControlSwitchMapviewerStateGoogleEarthStart.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, 1);
        DSIMapViewerControl[] dSIMapViewerControlArray = this.target.datapool.getDsiMapViewerControlsMainMap();
        if (dSIMapViewerControlArray.length == 1) {
            this.target.datapool.setDsiMapViewerControlsMainMap(new DSIMapViewerControl[]{dSIMapViewerControlArray[0], dSIMapViewerControl});
        }
    }

    private void switchToGoogleEarth() {
        int n = this.target.datapool.getDsiMapViewerControlCurrentMainMapInstanceId();
        if (n == 1) {
            try {
                this.target.transStateGoogleEarthRestart();
                this.myHsm.activateTransition();
            }
            catch (Exception exception) {
                this.logger.error("error while configuring the google earth mapviewer after a restart");
            }
        } else if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("switchToGoogleEarth() - not switching Id=").append(n).log();
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

