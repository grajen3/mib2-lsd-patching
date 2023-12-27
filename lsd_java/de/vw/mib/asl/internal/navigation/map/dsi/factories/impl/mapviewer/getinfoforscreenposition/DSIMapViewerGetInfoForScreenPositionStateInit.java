/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.StringBuilder;

public class DSIMapViewerGetInfoForScreenPositionStateInit
extends AbstractHsmState {
    private final IExtLogger logger;
    private final DSIMapViewerGetInfoForScreenPositionTargetHSM target;
    private final int[] ASL_OBSERVER = new int[]{1728708672, 224670976};
    private final int[] ASL_OBSERVER_MAIN_ONBOARD = new int[]{107230464, 124007680};
    private final int[] ASL_OBSERVER_MAIN_GOOGLE_EARTH = new int[]{174339328, 191116544};
    private final int[] ASL_SERVICES = new int[]{224670976, 241448192};

    public DSIMapViewerGetInfoForScreenPositionStateInit(DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerGetInfoForScreenPositionTargetHSM.getHsm(), string, hsmState);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, new StringBuilder("[DSIMapViewerGetInfoForScreenPositionStateInit-").append(dSIMapViewerGetInfoForScreenPositionTargetHSM.datapool.getServiceInstanceId()).append("]").toString());
        this.target = dSIMapViewerGetInfoForScreenPositionTargetHSM;
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
            case 3499014: {
                this.handleMapMainReady();
                break;
            }
            case 3499018: {
                this.handleMapMainReady();
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

    private void handleMapMainReady() {
        this.logger.trace("handleMapMainReady()");
        int n = this.target.datapool.getServiceInstanceId();
        int n2 = DSIMapViewerControlFactoryVW.getMapViewerInstanceIdCurrentMain();
        if (n == n2) {
            this.target.transStateMain();
        } else {
            this.target.transStateInactive();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        int n = this.target.datapool.getServiceInstanceId();
        if (n == 0) {
            this.target.registerServices(this.ASL_SERVICES, false);
            this.target.addObservers(this.ASL_OBSERVER_MAIN_ONBOARD);
        } else if (n == 1) {
            this.target.addObservers(this.ASL_OBSERVER_MAIN_GOOGLE_EARTH);
        }
        this.target.addObservers(this.ASL_OBSERVER);
    }
}

