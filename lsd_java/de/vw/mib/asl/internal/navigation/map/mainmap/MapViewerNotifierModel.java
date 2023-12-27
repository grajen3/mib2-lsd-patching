/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class MapViewerNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerNotifierModel]");

    void notifyHeadingValueChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyHeadingValueChanged( value=").append(n).append(" )").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(866, n);
    }

    void notifyZoomLevelChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyZoomLevelChanged( zoomLevel=").append(n).append(" )").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(872, n);
    }

    void notifyZoomListIndexChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyZoomListIndexChanged( zoomListIndex=").append(n).append(" )").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(871, n);
    }

    void notifyZoomListIndexMaximumReachedFalse() {
        AbstractASLHsmTarget.writeBooleanToDatapool(879, false);
    }

    void notifyZoomListIndexMaximumReachedTrue() {
        AbstractASLHsmTarget.writeBooleanToDatapool(879, true);
    }

    void notifyZoomListIndexMinimumReachedFalse() {
        AbstractASLHsmTarget.writeBooleanToDatapool(3691, false);
    }

    void notifyZoomListIndexMinimumReachedTrue() {
        AbstractASLHsmTarget.writeBooleanToDatapool(3691, true);
    }
}

