/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionRequest;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionTargetHSM;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.StringBuilder;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.map.PosInfo;

public class DSIMapViewerGetInfoForScreenPositionStateGetInfo
extends AbstractHsmState {
    private final IExtLogger logger;
    private final DSIMapViewerGetInfoForScreenPositionTargetHSM target;

    public DSIMapViewerGetInfoForScreenPositionStateGetInfo(DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerGetInfoForScreenPositionTargetHSM.getHsm(), string, hsmState);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, new StringBuilder("[DSIMapViewerGetInfoForScreenPositionStateGetInfo-").append(dSIMapViewerGetInfoForScreenPositionTargetHSM.datapool.getServiceInstanceId()).append("]").toString());
        this.target = dSIMapViewerGetInfoForScreenPositionTargetHSM;
    }

    public void dsiMapViewerControlGetInfoForPosition(PosInfo[] posInfoArray) {
        this.logger.trace("dsiMapViewerControlGetInfoForPosition()");
        AbstractTarget abstractTarget = this.target.datapool.getTargetCurrentRequest();
        DSIMapViewerGetInfoForScreenPositionRequest dSIMapViewerGetInfoForScreenPositionRequest = this.existsNewRequestForCurrentTarget(abstractTarget);
        if (dSIMapViewerGetInfoForScreenPositionRequest == null) {
            this.target.notifierASL.sendEventGetInfoForScreenPositionResult(this.target, abstractTarget, posInfoArray);
            this.target.transStateMain();
            return;
        }
        this.target.datapool.getRequests().remove(dSIMapViewerGetInfoForScreenPositionRequest);
        this.requestGetInfoForScreenPosition(dSIMapViewerGetInfoForScreenPositionRequest);
    }

    private DSIMapViewerGetInfoForScreenPositionRequest existsNewRequestForCurrentTarget(AbstractTarget abstractTarget) {
        List list = this.target.datapool.getRequests();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerGetInfoForScreenPositionRequest dSIMapViewerGetInfoForScreenPositionRequest = (DSIMapViewerGetInfoForScreenPositionRequest)iterator.next();
            if (abstractTarget != dSIMapViewerGetInfoForScreenPositionRequest.getTarget()) continue;
            this.logger.trace("A new request for the target is in the queue, we make a new call");
            return dSIMapViewerGetInfoForScreenPositionRequest;
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
        List list = this.target.datapool.getRequests();
        if (list.size() == 0) {
            this.logger.warn("no requests, stopping execution");
            this.target.transStateMain();
        }
        DSIMapViewerGetInfoForScreenPositionRequest dSIMapViewerGetInfoForScreenPositionRequest = (DSIMapViewerGetInfoForScreenPositionRequest)list.remove(0);
        this.requestGetInfoForScreenPosition(dSIMapViewerGetInfoForScreenPositionRequest);
    }

    private void requestGetInfoForScreenPosition(DSIMapViewerGetInfoForScreenPositionRequest dSIMapViewerGetInfoForScreenPositionRequest) {
        this.logger.trace("makeRequest()");
        this.target.datapool.setTargetCurrentRequest(dSIMapViewerGetInfoForScreenPositionRequest.getTarget());
        this.target.notifierDSI.getInfoForScreenPosition(dSIMapViewerGetInfoForScreenPositionRequest.getPoint());
    }
}

