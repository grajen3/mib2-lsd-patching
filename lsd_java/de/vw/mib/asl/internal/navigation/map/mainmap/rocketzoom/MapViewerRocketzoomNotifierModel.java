/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class MapViewerRocketzoomNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerRocketzoomNotifierModel]");

    protected void notifyAutoZoomDisabled() {
        this.logger.trace("notifyAutoZoomDisabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(841, false);
    }

    void notifyRocketZoomOff() {
        this.logger.trace("notifyRocketZoomOff()");
        AbstractASLHsmTarget.writeBooleanToDatapool(877, false);
    }

    void notifyRocketZoomOn() {
        this.logger.trace("notifyRocketZoomOn()");
        AbstractASLHsmTarget.writeBooleanToDatapool(877, true);
    }

    void notifyRocketZoomEnabled() {
        this.logger.trace("notifyRocketZoomEnabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-554692608, true);
    }

    void notifyRocketZoomDisabled() {
        this.logger.trace("notifyRocketZoomDisabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-554692608, false);
    }
}

