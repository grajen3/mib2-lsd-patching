/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class MapViewerMapSwitchNotifierModel {
    private final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMapSwitchNotifierModel] ");

    public void notifyAutoZoomEnabled() {
        this.LOGGER.trace("notifyAutoZoomEnabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(841, true);
    }

    public void notifyKombiMapInvisible() {
        this.LOGGER.trace("notifyKombiMapInvisile()");
        AbstractASLHsmTarget.writeIntegerToDatapool(502272000, 0);
    }

    public void notifyKombiMapVisible() {
        this.LOGGER.trace("notifyKombiMapVisible()");
        AbstractASLHsmTarget.writeIntegerToDatapool(502272000, 1);
    }

    public void notifyMainMapNotShownInABT() {
        this.LOGGER.trace("notifyMapNotShownInABT()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1762652160, false);
    }

    public void notifyMainMapShownInABT() {
        this.LOGGER.trace("notifyMapShownInABT()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1762652160, true);
    }

    public void notifyMapMovedFalse() {
        this.LOGGER.trace("notifyMapMovedFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(875, false);
    }

    public void notifyMapSwitchButtonDisabled() {
        this.LOGGER.trace("notifyMapSwitchButtonDisabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1779429376, false);
    }

    public void notifyZoomLevelChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyZoomLevelChanged( zoomLevel=").append(n).append(" )").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(872, n);
    }
}

