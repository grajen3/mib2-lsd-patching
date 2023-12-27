/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.DSIMapViewerControl;

public class DSIMapViewerControlSwitchMapviewerStateGoogleEarthStop
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapviewerStateGoogleEarthStop]");
    private final DSIMapViewerControlSwitchMapviewerTargetHSM target;

    public DSIMapViewerControlSwitchMapviewerStateGoogleEarthStop(DSIMapViewerControlSwitchMapviewerTargetHSM dSIMapViewerControlSwitchMapviewerTargetHSM, String string, HsmState hsmState) {
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
        if (!bl) {
            this.logger.error("De-Registration of an not registered Service is an Error!");
            return;
        }
        this.target.datapool.setGoogleEarthRegistered(false);
        DSIMapViewerControl[] dSIMapViewerControlArray = this.target.datapool.getDsiMapViewerControlsMainMap();
        this.target.datapool.setDsiMapViewerControlsMainMap(new DSIMapViewerControl[]{dSIMapViewerControlArray[0]});
    }
}

