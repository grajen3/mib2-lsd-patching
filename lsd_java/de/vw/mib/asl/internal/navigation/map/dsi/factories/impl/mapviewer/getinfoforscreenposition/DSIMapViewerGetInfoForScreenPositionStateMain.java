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
import org.dsi.ifc.map.Point;

public class DSIMapViewerGetInfoForScreenPositionStateMain
extends AbstractHsmState {
    private final IExtLogger logger;
    private final DSIMapViewerGetInfoForScreenPositionTargetHSM target;

    public DSIMapViewerGetInfoForScreenPositionStateMain(DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerGetInfoForScreenPositionTargetHSM.getHsm(), string, hsmState);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, new StringBuilder("[DSIMapViewerGetInfoForScreenPositionStateMain-").append(dSIMapViewerGetInfoForScreenPositionTargetHSM.datapool.getServiceInstanceId()).append("]").toString());
        this.target = dSIMapViewerGetInfoForScreenPositionTargetHSM;
    }

    private void datapoolAddRequest(AbstractTarget abstractTarget, Point point) {
        DSIMapViewerGetInfoForScreenPositionRequest dSIMapViewerGetInfoForScreenPositionRequest;
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("datapoolAddRequest(target.targetId=").append(abstractTarget.getTargetId()).append(", point=").append(point).log();
        }
        boolean bl = false;
        List list = this.target.datapool.getRequests();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            dSIMapViewerGetInfoForScreenPositionRequest = (DSIMapViewerGetInfoForScreenPositionRequest)iterator.next();
            if (abstractTarget != dSIMapViewerGetInfoForScreenPositionRequest.getTarget()) continue;
            this.logger.trace("A request for the targetId is already in the queue, we just update the Point");
            dSIMapViewerGetInfoForScreenPositionRequest.setPoint(point);
            bl = true;
        }
        if (!bl) {
            dSIMapViewerGetInfoForScreenPositionRequest = new DSIMapViewerGetInfoForScreenPositionRequest(abstractTarget, point);
            this.target.datapool.getRequests().add(dSIMapViewerGetInfoForScreenPositionRequest);
        }
    }

    public void dsiMapViewerControlAsyncException(int n, String string, int n2) {
        if (n2 == 1006) {
            this.logger.makeError().append("dsiMapViewerControlAsyncException(errorCode = ").append(n).append(", errorMsg=").append(string).append(", requestType=").append(n2).append(") - DSIMapViewerControl.getInfoForScreenPosition(Point)").log();
            this.target.resetRequests();
            this.target.notifierASL.sendEvMapMainGetInfoForScreenPositionResultAsyncException(this.target, this.target.datapool.getTargetCurrentRequest(), n2, n);
        }
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
            case 3499021: {
                this.handleGetInfoForScreenPosition(eventGeneric);
                break;
            }
            case 3499015: {
                this.handleMapViewerNotReadyOnboard();
                break;
            }
            case 3499019: {
                this.handleMapViewerNotReadyGoogleEarth();
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
            if (n3 == 1) {
                this.target.transStateInactive();
            }
        } else if (n2 == 1 && (n = this.target.datapool.getServiceInstanceId()) == 0) {
            this.target.transStateInactive();
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

    private void handleGetInfoForScreenPosition(EventGeneric eventGeneric) {
        AbstractTarget abstractTarget = (AbstractTarget)eventGeneric.getObject(0);
        Point point = (Point)eventGeneric.getObject(1);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleGetInfoForScreenPosition(target.targetId=").append(abstractTarget.getTargetId()).append(", point=").append(point).append(")").log();
        }
        this.datapoolAddRequest(abstractTarget, point);
        if (this.target.isStateGetInfoInactive()) {
            this.target.transStateGetInfo();
        }
    }

    private void handleMapViewerNotReadyGoogleEarth() {
        this.logger.trace("handleMapViewerNotReadyGoogleEarth()");
        int n = this.target.datapool.getServiceInstanceId();
        if (n == 1) {
            this.target.transStateInactive();
        }
    }

    private void handleMapViewerNotReadyOnboard() {
        this.logger.trace("handleMapViewerNotReadyOnboard()");
        int n = this.target.datapool.getServiceInstanceId();
        if (n == 0) {
            this.target.transStateInactive();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        if (this.target.datapool.getRequests().size() > 0) {
            this.target.transStateGetInfo();
        }
    }
}

