/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.perspectives;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class MapViewerPerspectivesNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerPerspectivesNotifierModel]");

    void notifyAlternativeRouteMapActive() {
        this.logger.trace("notifyAlternativeRouteMapActive()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1527771136, true);
    }

    void notifyAlternativeRouteMapInactive() {
        this.logger.trace("notifyAlternativeRouteMapInactive()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1527771136, false);
    }

    void notifyDestinationZoomOff() {
        this.logger.trace("notifyDestinationZoomOff()");
        AbstractASLHsmTarget.writeBooleanToDatapool(880, false);
    }

    void notifyDestinationZoomOn() {
        this.logger.trace("notifyHmiDestinationZoomOn()");
        AbstractASLHsmTarget.writeBooleanToDatapool(880, true);
    }

    void notifyMapMovedFalse() {
        this.logger.trace("notifyMapMovedFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(875, false);
    }

    void notifyMapMovedTrue() {
        this.logger.trace("notifyMapMovedTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(875, true);
    }

    void notifyOverviewZoomOff() {
        this.logger.trace("informHmiOverviewZoom(isActive=false)");
        AbstractASLHsmTarget.writeBooleanToDatapool(876, false);
    }

    void notifyOverviewZoomOn() {
        this.logger.trace("informHmiOverviewZoom(isActive=true)");
        AbstractASLHsmTarget.writeBooleanToDatapool(876, true);
    }

    void notifyPerspective25DHeading() {
        this.logger.trace("notifyPerspective25DHeading()");
        AbstractASLHsmTarget.writeIntegerToDatapool(840, 2);
    }

    void notifyPerspective2DHeading() {
        this.logger.trace("notifyPerspective2DHeading()");
        AbstractASLHsmTarget.writeIntegerToDatapool(840, 1);
    }

    void notifyPerspective2DNorth() {
        this.logger.trace("notifyPerspective2DNorth()");
        AbstractASLHsmTarget.writeIntegerToDatapool(840, 0);
    }

    void notifyPerspective3DDTM() {
        this.logger.trace("notifyViewPerspective3DDTM()");
        AbstractASLHsmTarget.writeIntegerToDatapool(840, 4);
    }

    void notifyPerspective3DHeading() {
        this.logger.trace("notifyPerspective3DHeading()");
        AbstractASLHsmTarget.writeIntegerToDatapool(840, 3);
    }

    void notifyRangeViewDisabled() {
        this.logger.trace("informHmiOverviewZoom(isActive=true)");
        AbstractASLHsmTarget.writeBooleanToDatapool(3589, false);
    }

    void notifyRangeViewEnabled() {
        this.logger.trace("notifyRangeViewEnabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3589, true);
    }

    void notifyRocketZoomOff() {
        this.logger.trace("notifyRocketZoomOff()");
        AbstractASLHsmTarget.writeBooleanToDatapool(877, false);
    }

    void notifyRocketZoomOn() {
        this.logger.trace("notifyRocketZoomOn()");
        AbstractASLHsmTarget.writeBooleanToDatapool(877, true);
    }

    void notifySurroundingZoomOff() {
        this.logger.trace("notifySurroundingZoomOff()");
        AbstractASLHsmTarget.writeBooleanToDatapool(878, false);
    }
}

