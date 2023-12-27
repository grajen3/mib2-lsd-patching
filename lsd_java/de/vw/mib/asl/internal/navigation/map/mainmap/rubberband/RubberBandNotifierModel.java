/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rubberband;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class RubberBandNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[RubberBandNotifierModel]");

    public void notifyLoadingStatusComplete() {
        this.logger.trace("notifyLoadingStatusComplete()");
        AbstractASLHsmTarget.writeIntegerToDatapool(401608704, 2);
    }

    public void notifyLoadingStatusIdle() {
        this.logger.trace("notifyLoadingStatusIdle()");
        AbstractASLHsmTarget.writeIntegerToDatapool(401608704, 0);
    }

    public void notifyLoadingStatusLoading() {
        this.logger.trace("notifyLoadingStatusLoading()");
        AbstractASLHsmTarget.writeIntegerToDatapool(401608704, 1);
    }

    public void notifyMapMovedFalse() {
        this.logger.trace("notifyMapMovedFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(418385920, false);
    }

    public void notifyMapMovedTrue() {
        this.logger.trace("notifyMapMovedTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(418385920, true);
    }

    void notifyOverviewZoomOff() {
        this.logger.trace("informHmiOverviewZoom(isActive=false)");
        AbstractASLHsmTarget.writeBooleanToDatapool(876, false);
    }

    void notifyOverviewZoomOn() {
        this.logger.trace("informHmiOverviewZoom(isActive=true)");
        AbstractASLHsmTarget.writeBooleanToDatapool(876, true);
    }

    public void notifyRouteAdjustedFalse() {
        this.logger.trace("notifyRouteAdjustedFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(468717568, false);
    }

    public void notifyRouteAdjustedTrue() {
        this.logger.trace("notifyRouteAdjustedTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(468717568, true);
    }

    public void notifyRouteSegmentViaPointFalse() {
        this.logger.trace("notifyRouteSegmentViaPointFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(451940352, false);
    }

    public void notifyRouteSegmentViaPointTrue() {
        this.logger.trace("notifyRouteSegmentViaPointTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(451940352, true);
    }

    public void notifyRouteViaPointFalse() {
        this.logger.trace("notifyRouteViaPointFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(435163136, false);
    }

    public void notifyRouteViaPointTrue() {
        this.logger.trace("notifyRouteViaPointTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(435163136, true);
    }

    public void notifyRubberBandPointAvailable() {
        this.logger.trace("notifyRubberBandPointAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(435163136, true);
    }

    public void notifyRubberBandPointUnavailable() {
        this.logger.trace("notifyRubberBandPointUnavailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(435163136, false);
    }
}

