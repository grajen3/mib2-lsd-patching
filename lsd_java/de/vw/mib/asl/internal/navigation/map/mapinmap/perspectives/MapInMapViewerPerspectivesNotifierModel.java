/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class MapInMapViewerPerspectivesNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerPerspectivesNotifierModel]");

    void notifyOverviewZoomOff() {
        this.logger.trace("notifyOverviewZoomOff()");
        AbstractASLHsmTarget.writeBooleanToDatapool(855, false);
    }

    void notifyOverviewZoomOn() {
        this.logger.trace("notifyOverviewZoomOn()");
        AbstractASLHsmTarget.writeBooleanToDatapool(855, true);
    }

    void notifyPerspectiveIs2DHeading() {
        this.logger.trace("notifyPerspectiveIs2DHeading()");
        AbstractASLHsmTarget.writeIntegerToDatapool(854, 1);
    }

    void notifyPerspectiveIs2DNorth() {
        this.logger.trace("notifyPerspectiveIs2DNorth()");
        AbstractASLHsmTarget.writeIntegerToDatapool(854, 0);
    }

    void notifyPerspectiveIs3DHeading() {
        this.logger.trace("notifyPerspectiveIs3DHeading()");
        AbstractASLHsmTarget.writeIntegerToDatapool(854, 2);
    }

    void notifyRangeViewDisabled() {
        this.logger.trace("notifyRangeViewDisabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3588, false);
    }

    void notifyRangeViewEnabled() {
        this.logger.trace("notifyRangeViewEnabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3588, true);
    }

    void notifyZoomLevelChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyZoomLevelChanged(").append(n).append(")").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(858, n);
    }
}

