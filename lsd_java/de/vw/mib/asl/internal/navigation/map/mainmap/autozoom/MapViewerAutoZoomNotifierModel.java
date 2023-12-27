/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.autozoom;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class MapViewerAutoZoomNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerAutoZoomModelNotifier]");

    protected void notifyAutoZoomDisabled() {
        this.logger.trace("notifyAutoZoomDisabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(841, false);
    }

    protected void notifyAutoZoomEnabled() {
        this.logger.trace("notifyAutoZoomEnabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(841, true);
    }

    protected void notifyZoomLevelChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyZoomLevelChanged( zoomLevel=").append(n).append(" )").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(872, n);
    }
}

