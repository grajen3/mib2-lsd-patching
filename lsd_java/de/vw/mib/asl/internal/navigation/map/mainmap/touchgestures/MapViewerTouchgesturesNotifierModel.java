/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.map.clickinmap.transformer.NavigationMapClickInMapClickInMapDataCollector;

public class MapViewerTouchgesturesNotifierModel {
    private NavigationMapClickInMapClickInMapDataCollector[] collectorClickInMapLocationArray = null;
    private final GenericASLList listData;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerTouchgesturesModelNotifier]");

    public MapViewerTouchgesturesNotifierModel() {
        this.listData = ListManager.getGenericASLList(-1896869888);
    }

    void notifyBrowserSetInfoText(String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyBrowserSetInfoText(infoText=").append(string).append(")").log();
        }
        AbstractASLHsmTarget.writeStringToDatapool(0x11F01000, string);
    }

    void notifyBrowserSetURL(String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyBrowserSetURL(url=").append(string).append(")").log();
        }
        AbstractASLHsmTarget.writeStringToDatapool(0x10F01000, string);
    }

    void notifyClickedStatusNothingFound() {
        this.logger.trace("notifyClickedStatusNothingFound()");
        AbstractASLHsmTarget.writeIntegerToDatapool(864, 2);
    }

    void notifyClickenObjectTMCFalse() {
        this.logger.trace("notifyClickenObjectTMCFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(873, false);
    }

    void notifyClickInMapBrowserFooterDisabled() {
        this.logger.trace("notifyClickInMapBrowserFooterDisabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(1743785984, false);
    }

    void notifyClickInMapBrowserFooterEnabled() {
        this.logger.trace("notifyClickInMapBrowserFooterEnabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(1743785984, true);
    }

    void notifyClickInMapMenuNotReady() {
        this.logger.trace("notifyClickInMapMenuNotReady()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1913647104, false);
    }

    void notifyClickInMapMenuReady() {
        this.logger.trace("notifyClickInMapMenuReady()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1913647104, true);
    }

    void notifyMapMovedTrue() {
        this.logger.trace("notifyMapMovedTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(875, true);
    }

    void notifyObjectTypeOnMapXTRepresentation() {
        this.logger.trace("notifyObjectTypeOnMapXTRepresentation()");
        AbstractASLHsmTarget.writeIntegerToDatapool(867, 5);
    }

    void notifyStreetViewAvailable() {
        this.logger.trace("notifyStreetViewAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3805, true);
    }

    void notifyStreetViewNotAvailable() {
        this.logger.trace("notifyStreetViewNotAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3805, false);
    }

    protected void updateClickInMapPopUp(NavigationMapClickInMapClickInMapDataCollector navigationMapClickInMapClickInMapDataCollector) {
        this.logger.trace("updateClickInMapPopUp()");
        this.collectorClickInMapLocationArray = new NavigationMapClickInMapClickInMapDataCollector[]{navigationMapClickInMapClickInMapDataCollector};
        this.listData.updateList(this.collectorClickInMapLocationArray);
    }
}

