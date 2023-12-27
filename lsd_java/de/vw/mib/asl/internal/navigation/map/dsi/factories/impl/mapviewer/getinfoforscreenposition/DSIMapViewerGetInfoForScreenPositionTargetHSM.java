/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionDatapool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionNotifierASL;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionRequest;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionStateGetInfo;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionStateInactive;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionStateInit;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionStateMain;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.StringBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.Point;

public class DSIMapViewerGetInfoForScreenPositionTargetHSM
extends AbstractResettableAslHsmTarget {
    protected final DSIMapViewerGetInfoForScreenPositionDatapool datapool;
    private final IExtLogger logger;
    protected final DSIMapViewerGetInfoForScreenPositionNotifierASL notifierASL;
    protected final DSIMapViewerGetInfoForScreenPositionNotifierDSI notifierDSI;
    private final DSIMapViewerGetInfoForScreenPositionStateGetInfo stateGetInfo;
    private final DSIMapViewerGetInfoForScreenPositionStateInit stateInit;
    private final DSIMapViewerGetInfoForScreenPositionStateMain stateMain;
    private final DSIMapViewerGetInfoForScreenPositionStateInactive stateInactiveHSM;

    public DSIMapViewerGetInfoForScreenPositionTargetHSM(GenericEvents genericEvents, int n, String string, int n2) {
        super(genericEvents, n, string);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, new StringBuilder("[DSIMapViewerGetInfoForScreenPositionTargetHSM-").append(n2).append("]").toString());
        this.datapool = new DSIMapViewerGetInfoForScreenPositionDatapool(n2);
        this.notifierDSI = new DSIMapViewerGetInfoForScreenPositionNotifierDSI();
        this.notifierASL = new DSIMapViewerGetInfoForScreenPositionNotifierASL();
        this.stateInit = new DSIMapViewerGetInfoForScreenPositionStateInit(this, "stateInit", this.getWorkStateParent());
        this.stateInactiveHSM = new DSIMapViewerGetInfoForScreenPositionStateInactive(this, "stateInactiveHSM", this.getWorkStateParent());
        this.stateMain = new DSIMapViewerGetInfoForScreenPositionStateMain(this, "stateMain", this.getWorkStateParent());
        this.stateGetInfo = new DSIMapViewerGetInfoForScreenPositionStateGetInfo(this, "stateGetInfo", (HsmState)this.stateMain);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    public boolean isStateGetInfoInactive() {
        return !this.getHsm().isActive(this.stateGetInfo);
    }

    protected boolean requestsContainsTarget(DSIMapViewerGetInfoForScreenPositionStateMain dSIMapViewerGetInfoForScreenPositionStateMain, AbstractTarget abstractTarget, Point point) {
        List list = this.datapool.getRequests();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerGetInfoForScreenPositionRequest dSIMapViewerGetInfoForScreenPositionRequest = (DSIMapViewerGetInfoForScreenPositionRequest)iterator.next();
            if (abstractTarget != dSIMapViewerGetInfoForScreenPositionRequest.getTarget()) continue;
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("A request for the targetId is already in the queue, we just update the Point");
            }
            dSIMapViewerGetInfoForScreenPositionRequest.setPoint(point);
            return true;
        }
        return false;
    }

    void resetRequests() {
        try {
            this.logger.error("An Error occures while DSIMapViewerControl.getInfoForScreenPosition(Point), all request will be removed, the HSM will be resetted. The HSM will now allow new requests.");
            this.datapool.getRequests().clear();
            this.transStateMain();
        }
        catch (Exception exception) {
            this.logger.error(exception.toString());
        }
    }

    public void setMapViewer(DSIMapViewerControl dSIMapViewerControl) {
        this.logger.trace("setMapViewer()");
        this.notifierDSI.setMapViewerControl(dSIMapViewerControl);
    }

    protected void transStateGetInfo() {
        this.logger.trace("transStateGetInfo()");
        this.getHsm().trans(this.stateGetInfo);
    }

    protected void transStateInactive() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateInactiveHSM);
    }

    protected void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Ignoring reset. Reinitialization handled by when MapViewerControl is ready.");
        }
    }

    public void clearQueue() {
        this.resetRequests();
    }
}

