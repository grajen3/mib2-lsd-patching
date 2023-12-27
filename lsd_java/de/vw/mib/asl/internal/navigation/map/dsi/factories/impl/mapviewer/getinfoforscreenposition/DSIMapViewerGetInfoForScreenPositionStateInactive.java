/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.StringBuilder;

public class DSIMapViewerGetInfoForScreenPositionStateInactive
extends AbstractHsmState {
    private final IExtLogger logger;
    private final DSIMapViewerGetInfoForScreenPositionTargetHSM target;

    public DSIMapViewerGetInfoForScreenPositionStateInactive(DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerGetInfoForScreenPositionTargetHSM.getHsm(), string, hsmState);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, new StringBuilder("[DSIMapViewerGetInfoForScreenPositionStateInactive-").append(dSIMapViewerGetInfoForScreenPositionTargetHSM.datapool.getServiceInstanceId()).append("]").toString());
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
                this.handleMapMainReadyOnboard();
                break;
            }
            case 3499018: {
                this.handleMapMainReadyGoogleEarth();
                break;
            }
            case 1073744487: {
                this.handleASLNavigationOnlineServiceChangeMapType(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationOnlineServiceChangeMapType(EventGeneric eventGeneric) {
        int n;
        int n2 = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationOnlineServiceChangeMapType(mapViewerNewId=").append(n2).append(")").log();
        }
        if (n2 == 0) {
            int n3 = this.target.datapool.getServiceInstanceId();
            if (n3 == 0) {
                this.target.transStateMain();
            }
        } else if (n2 == 1 && (n = this.target.datapool.getServiceInstanceId()) == 1) {
            this.target.transStateMain();
        }
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

    private void handleMapMainReadyGoogleEarth() {
        int n = this.target.datapool.getServiceInstanceId();
        if (n == 1) {
            this.logger.trace("handleMapMainReadyGoogleEarth()");
            this.target.transStateMain();
        }
    }

    private void handleMapMainReadyOnboard() {
        int n = this.target.datapool.getServiceInstanceId();
        if (n == 0) {
            this.logger.trace("handleMapMainReadyOnboard()");
            this.target.transStateMain();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }
}

