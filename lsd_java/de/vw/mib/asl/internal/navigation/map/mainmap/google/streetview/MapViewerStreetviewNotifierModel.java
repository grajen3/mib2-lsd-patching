/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.onlineservice.transformer.NavigationOnlineServiceStreetViewLocationDataCollector;
import org.dsi.ifc.global.NavLocation;

public class MapViewerStreetviewNotifierModel {
    private static final int STREET_VIEW_LOCATION_DATA_ROW_ITEM_INDEX;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerStreetviewNotifierModel]");
    private final GenericASLList streetViewLocationData = ListManager.getGenericASLList(3775);
    private final NavigationOnlineServiceStreetViewLocationDataCollector streetViewLocationDataCollector;

    public MapViewerStreetviewNotifierModel() {
        Object object = this.streetViewLocationData.getRowItemCacheOnly(0);
        this.streetViewLocationDataCollector = object instanceof NavigationOnlineServiceStreetViewLocationDataCollector ? (NavigationOnlineServiceStreetViewLocationDataCollector)object : new NavigationOnlineServiceStreetViewLocationDataCollector();
    }

    void notifyStreetViewAvailable() {
        this.logger.trace("notifyStreetViewAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3805, true);
    }

    void notifyStreetViewHeadingValueChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyStreetViewHeadingValueChanged(").append(n).append(")").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(3774, n);
    }

    void notifyStreetViewLoadStatus(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyStreetViewLoadStatus(").append(n).append(")").log();
        }
        if (n == 0) {
            AbstractASLHsmTarget.writeIntegerToDatapool(3717, 0);
        } else if (n == 1) {
            AbstractASLHsmTarget.writeIntegerToDatapool(3717, 1);
        } else if (n == 2) {
            AbstractASLHsmTarget.writeIntegerToDatapool(3717, 2);
        } else {
            this.logger.makeWarn().append("the streetViewLoadStatus '").append(n).append("' is unknown, the status will be set to 'idle'").log();
            AbstractASLHsmTarget.writeIntegerToDatapool(3717, 0);
        }
    }

    void notifyStreetViewLocationDataChanged(NavLocation navLocation) {
        double[] dArray;
        this.logger.trace("notifyStreetViewLocationDataChanged()");
        if (navLocation == null) {
            this.logger.warn("streetViewLocation is not set, can't update the detail line");
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_city = "";
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_city_refinement = "";
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_street = "";
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_street_refinement = "";
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_degree = 0;
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_minutes = 0;
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_seconds = 0;
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_degree = 0;
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_minutes = 0;
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_seconds = 0;
            this.streetViewLocationData.updateListItem(0, this.streetViewLocationDataCollector);
            return;
        }
        this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_city = navLocation.getTown() == null ? "" : navLocation.getTown();
        this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_city_refinement = navLocation.getTownRefinement() == null ? "" : navLocation.getTownRefinement();
        this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_street = navLocation.getStreet() == null ? "" : navLocation.getStreet();
        this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_street_refinement = navLocation.getStreetRefinement() == null ? "" : navLocation.getStreetRefinement();
        if (navLocation.getLatitude() == 0) {
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_degree = 0;
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_minutes = 0;
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_seconds = 0;
        } else {
            dArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDegMinSec(navLocation.getLatitude());
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_degree = (int)dArray[0];
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_minutes = (int)dArray[1];
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_seconds = (int)(10.0 * dArray[2]);
        }
        if (navLocation.getLongitude() == 0) {
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_degree = 0;
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_minutes = 0;
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_seconds = 0;
        } else {
            dArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDegMinSec(navLocation.getLongitude());
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_degree = (int)dArray[0];
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_minutes = (int)dArray[1];
            this.streetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_seconds = (int)(10.0 * dArray[2]);
        }
        this.streetViewLocationData.updateListItem(0, this.streetViewLocationDataCollector);
    }

    void notifyStreetViewNotAvailable() {
        this.logger.trace("notifyStreetViewNotAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3805, false);
    }

    void notifyStreetViewServiceAvailable() {
        this.logger.trace("notifyStreetViewServiceAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3714, true);
    }

    void notifyStreetViewServiceNotAvailable() {
        this.logger.trace("notifyStreetViewNotAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3714, false);
    }

    void notifyStreetViewZoomListIndexChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyZoomListIndexChanged( zoomListIndex = ").append(n).append(" )").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(3767, n);
    }

    void notifyStreetViewZoomListIndexMaximumReachedFalse() {
        this.logger.trace("notifyStreetViewZoomListIndexMaximumReachedFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3770, false);
    }

    void notifyStreetViewZoomListIndexMaximumReachedTrue() {
        this.logger.trace("notifyStreetViewZoomListIndexMaximumReachedTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3770, true);
    }

    void notifyStreetViewZoomListIndexMinimumReachedFalse() {
        this.logger.trace("notifyStreetViewZoomListIndexMinimumReachedFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3772, false);
    }

    void notifyStreetViewZoomListIndexMinimumReachedTrue() {
        this.logger.trace("notifyStreetViewZoomListIndexMinimumReachedTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3772, true);
    }

    void notifyTwoFingerZoomActive() {
        this.logger.trace("notifyTwoFingerZoomActive");
        AbstractASLHsmTarget.writeBooleanToDatapool(-185659392, true);
    }
}

