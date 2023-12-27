/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.ppoi;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.util.PPoiDatapool;
import de.vw.mib.asl.internal.navigation.util.LocationWrapper;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultSelectedDetailsCollector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class PPoiStateDetail
extends PoiAbstractHsmState
implements CacheClient {
    private PPoiHsmTarget pPoiTarget;
    private NavigationPOIResultSelectedDetailsCollector pPoiDetailsCollector = new NavigationPOIResultSelectedDetailsCollector();
    private NavLocation currentDestinationLocation;

    public PPoiStateDetail(PPoiHsmTarget pPoiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.pPoiTarget = pPoiHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        this.pPoiTarget.myTrace(this, new StringBuffer().append("Received event ID:").append(eventGeneric.getReceiverEventId()).toString());
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.pPoiTarget.myTrace(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.pPoiTarget.myTrace(this, "HSM_START");
                this.handleHsmStart();
                break;
            }
            case 4: {
                this.pPoiTarget.myTrace(this, "HSM_EXIT");
                break;
            }
            case 1073742511: {
                this.pPoiTarget.myTrace(this, "ASL_NAVIGATION_P_POI_SEARCH_RESULT_DETAIL_VIEW_CLOSE");
                this.pPoiTarget.notifierModel.notifyNaviPoiDataLoadFinishedLeawDetailView();
                this.pPoiTarget.notifierModel.notifySearchStateSearching();
                this.pPoiTarget.transAfterCallback(this.pPoiTarget.statePPoiCategoy);
                break;
            }
            default: {
                this.pPoiTarget.myTrace(this, new StringBuffer().append("Received event which is not handled in this state (ID=").append(eventGeneric.getReceiverEventId()).append(")").toString());
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void handleHsmStart() {
        this.centerMapOnCurrentSelectedElement();
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPOILocation(this.currentDestinationLocation);
        LocationWrapper locationWrapper = new LocationWrapper(this.currentDestinationLocation);
        this.notifyPoiDetailsToModel(locationWrapper);
        this.pPoiTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.pPoiTarget.myTrace(this, new StringBuffer().append("handleIconCacheUpdate index: IconID:").append(resourceLocator.getId()).toString());
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_headline_icon = resourceLocator;
        this.pPoiTarget.notifierModel.notifyPoiDetails(this.pPoiDetailsCollector);
    }

    private void notifyPoiDetailsToModel(LocationWrapper locationWrapper) {
        ResourceLocator resourceLocator;
        this.pPoiTarget.myTrace(this, "writePoiDetails");
        int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(this.currentDestinationLocation.longitude, this.currentDestinationLocation.latitude, PPoiDatapool.getInstance().getReferenceLocation().getLongitude(), PPoiDatapool.getInstance().getReferenceLocation().getLatitude());
        int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDirectionIndex(PPoiDatapool.getInstance().getReferenceLocation().getLongitude(), PPoiDatapool.getInstance().getReferenceLocation().getLatitude(), this.currentDestinationLocation.longitude, this.currentDestinationLocation.latitude, PPoiDatapool.getInstance().getReferenceDirection());
        int n3 = locationWrapper.getIconIndex();
        int n4 = locationWrapper.getSubIconIndex();
        int n5 = locationWrapper.getLatitude();
        int n6 = locationWrapper.getLongitude();
        String string = locationWrapper.getPoiClass();
        String string2 = locationWrapper.getPoiCategory();
        String string3 = locationWrapper.getPoiName();
        String string4 = locationWrapper.getCountry();
        String string5 = locationWrapper.getCountryCode();
        String string6 = locationWrapper.getCity();
        String string7 = locationWrapper.getCityRefinement();
        String string8 = locationWrapper.getCityCenter();
        String string9 = locationWrapper.getStreet();
        String string10 = locationWrapper.getStreetRefinement();
        String string11 = locationWrapper.getCrossing();
        String string12 = locationWrapper.getHousenumber();
        String string13 = locationWrapper.getPostalCode();
        String string14 = locationWrapper.getMotorWayExit();
        String string15 = locationWrapper.getPhonenumber();
        String string16 = "";
        String string17 = "";
        try {
            string16 = locationWrapper.getState();
        }
        catch (Throwable throwable) {
            ServiceManager.logger.error(16384, "Workaround for wrong POIFactory", throwable);
        }
        try {
            string17 = locationWrapper.getProvince();
        }
        catch (Throwable throwable) {
            ServiceManager.logger.error(16384, "Workaround for wrong POIFactory", throwable);
        }
        if (this.pPoiTarget.getTextLogger().isTraceEnabled(this.pPoiTarget.getSubClassifier())) {
            this.pPoiTarget.makeTrace(this).append("distance=").append(n).log();
            this.pPoiTarget.makeTrace(this).append("direction=").append(n2).log();
            this.pPoiTarget.makeTrace(this).append("getIconIndex=").append(n3).log();
            this.pPoiTarget.makeTrace(this).append("getSubIconIndex=").append(n4).log();
            this.pPoiTarget.makeTrace(this).append("getLatitude=").append(n5).log();
            this.pPoiTarget.makeTrace(this).append("getLongitude=").append(n6).log();
            this.pPoiTarget.makeTrace(this).append("getPoiClass=").append(string).log();
            this.pPoiTarget.makeTrace(this).append("getPoiCategory=").append(string2).log();
            this.pPoiTarget.makeTrace(this).append("getPoiName=").append(string3).log();
            this.pPoiTarget.makeTrace(this).append("getCountry=").append(string4).log();
            this.pPoiTarget.makeTrace(this).append("getCountryAbbreviation=").append(string5).log();
            this.pPoiTarget.makeTrace(this).append("getTown=").append(string6).log();
            this.pPoiTarget.makeTrace(this).append("getTownRefinement=").append(string7).log();
            this.pPoiTarget.makeTrace(this).append("getTowncenter=").append(string8).log();
            this.pPoiTarget.makeTrace(this).append("getStreet=").append(string9).log();
            this.pPoiTarget.makeTrace(this).append("getStreetRefinement=").append(string10).log();
            this.pPoiTarget.makeTrace(this).append("getJunction=").append(string11).log();
            this.pPoiTarget.makeTrace(this).append("getHousenumber=").append(string12).log();
            this.pPoiTarget.makeTrace(this).append("getZipCode=").append(string13).log();
            this.pPoiTarget.makeTrace(this).append("getMotorWayExit=").append(string14).log();
            this.pPoiTarget.makeTrace(this).append("getPhonenumber=").append(string15).log();
            this.pPoiTarget.makeTrace(this).append("getState=").append(string16).log();
            this.pPoiTarget.makeTrace(this).append("getProvince=").append(string17).log();
        }
        this.pPoiDetailsCollector = new NavigationPOIResultSelectedDetailsCollector();
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_distance = n;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_direction_arrow_index = n2;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_headline_icon = resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(n3, n4, 0, this, null);
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_latitude = n5;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_longitude = n6;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_class = string;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_category = string2;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_name = string3;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_country = string4;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_country_code = string5;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_city = string6;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_city_refinement = string7;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_city_center = string8;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_street = string9;
        this.pPoiDetailsCollector.navigation_poi_result_selected_street_refinement = string10;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_crossing = string11;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_housenumber = string12;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_zip = string13;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_motorway_exit = string14;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_phone_number = string15;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_url = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_state = string16;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_province = string17;
        this.pPoiDetailsCollector.navigation_poi_result_selected_detail_address_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(locationWrapper);
        ServiceManager.aslPropertyManager.valueChangedString(-672133120, locationWrapper.getURLAddress());
        this.pPoiTarget.notifierModel.notifyPoiDetails(this.pPoiDetailsCollector);
    }

    public void clearModelData() {
        this.pPoiDetailsCollector = new NavigationPOIResultSelectedDetailsCollector();
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_distance = 0;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_latitude = 0;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_longitude = 0;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_class = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_category = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_name = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_country = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_country_code = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_zip = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_city = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_city_refinement = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_city_center = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_street = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_street_refinement = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_crossing = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_housenumber = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_zip = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_motorway_exit = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_phone_number = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_url = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_detail_address_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper());
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_inside_range = true;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_provider_available = false;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_provider = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_access = 0;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available = false;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_onsitepayment = "";
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum = 0;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_open24h = 0;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_payment = 0;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_subscription = 0;
        this.pPoiDetailsCollector.navigation_poi_result_selected_details_connector_count = 0;
        this.pPoiTarget.notifierModel.notifyPoiDetails(this.pPoiDetailsCollector);
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    private void centerMapOnCurrentSelectedElement() {
        MapConfiguration mapConfiguration = new MapConfiguration(this.currentDestinationLocation, 25, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(13, mapConfiguration);
        mapConfiguration.setPoiShowCategoryIcon(true);
    }

    public void setcurrentDestinationLocation(NavLocation navLocation) {
        this.currentDestinationLocation = navLocation;
    }
}

