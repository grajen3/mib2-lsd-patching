/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.focus;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class MapViewerFocusNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerFocusModelNotifier]");

    void notifyAutozoomTrue() {
        this.logger.trace("notifyAutozoomTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(841, true);
    }

    void notifyMapMovedFalse() {
        this.logger.trace("notifyMapMovedFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(875, false);
    }

    void notifyMapMovedTrue() {
        this.logger.trace("notifyMapMovedTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(875, true);
    }

    void notifySurroundingZoomOff() {
        this.logger.trace("notifySurroundingZoomOff()");
        AbstractASLHsmTarget.writeBooleanToDatapool(878, false);
    }

    void notifySurroundingZoomOn() {
        this.logger.trace("notifySurroundingZoomOn()");
        AbstractASLHsmTarget.writeBooleanToDatapool(878, true);
    }
}

