/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.IEConnector;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementNoSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateFreetextSpeller;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSelectFromResultList;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiConnectorDetailsCollector;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultSelectedDetailsCollector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public final class PoiStateDetail
extends PoiAbstractHsmState
implements CacheClient {
    private PoiHsmTarget myTarget;
    public static int currentDetailsIndex;
    private NavigationPOIResultSelectedDetailsCollector poiDetailsCollector = new NavigationPOIResultSelectedDetailsCollector();
    public static NavLocation currentDestinationLocation;
    public static boolean isChild;

    public PoiStateDetail(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = poiHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("Received event ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.myTarget.myTrace(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.myTarget.myTrace(this, "HSM_START");
                this.handleHsmStart();
                break;
            }
            case 4: {
                this.myTarget.myTrace(this, "HSM_EXIT");
                break;
            }
            case 3492006: {
                currentDetailsIndex = eventGeneric.getInt(0);
                PoiStateSelectFromResultList.restore = true;
                this.myTarget.transAfterCallback(this.myTarget.statePoiSelectFromResultList);
                break;
            }
            case 1073742503: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_RESULT_SELECT_NEXT_DETAILS");
                this.handleRESULTSELECTNEXTDETAILS();
                break;
            }
            case 1073742504: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_RESULT_SELECT_PREV_DETAILS");
                this.handleRESULTSELECTPREVDETAILS();
                break;
            }
            case 1073742511: {
                this.myTarget.myTrace(this, "ASL_NAVIGATION_POI_SEARCH_RESULT_DETAIL_VIEW_CLOSE");
                this.detailsClosed();
                break;
            }
            default: {
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("Received event which is not handled in this state (ID=").append(eventGeneric.getReceiverEventId()).append(")").log();
                }
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void clearModelData() {
        this.poiDetailsCollector = new NavigationPOIResultSelectedDetailsCollector();
        this.poiDetailsCollector.navigation_poi_result_selected_details_distance = 0;
        this.poiDetailsCollector.navigation_poi_result_selected_details_latitude = 0;
        this.poiDetailsCollector.navigation_poi_result_selected_details_longitude = 0;
        this.poiDetailsCollector.navigation_poi_result_selected_details_class = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_category = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_name = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_country = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_country_code = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_zip = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_city = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_city_refinement = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_city_center = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_street = "";
        this.poiDetailsCollector.navigation_poi_result_selected_street_refinement = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_crossing = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_housenumber = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_zip = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_motorway_exit = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_phone_number = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_url = "";
        this.poiDetailsCollector.navigation_poi_result_selected_detail_address_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper());
        this.poiDetailsCollector.navigation_poi_result_selected_details_inside_range = true;
        this.poiDetailsCollector.navigation_poi_result_selected_details_provider_available = false;
        this.poiDetailsCollector.navigation_poi_result_selected_details_provider = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_access = 0;
        this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available = false;
        this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum = 0;
        this.poiDetailsCollector.navigation_poi_result_selected_details_open24h = 0;
        this.poiDetailsCollector.navigation_poi_result_selected_details_payment = 0;
        this.poiDetailsCollector.navigation_poi_result_selected_details_subscription = 0;
        this.poiDetailsCollector.navigation_poi_result_selected_details_connector_count = 0;
        this.myTarget.notifierModel.notifyPoiDetails(this.poiDetailsCollector);
        PoiConnectorDetailsCollector[] poiConnectorDetailsCollectorArray = new PoiConnectorDetailsCollector[]{};
        this.myTarget.notifierModel.notifyPoiConnectorDetails(poiConnectorDetailsCollectorArray);
    }

    public void detailsClosed() {
        this.myTarget.myTrace(this, "detailsClosed");
        if (PoiDatapool.getInstance().getCurrentUseCase() == 19) {
            PoiStateFreetextSpeller.parentPOIState = PoiStateSelectFromResultList.currentSpellerState;
            PoiAbstractElementCommon.continueSearch = true;
            this.myTarget.transAfterCallback(this.myTarget.statePoiFreetextSpeller);
        } else if (PoiDatapool.getInstance().getCurrentUseCase() == 0) {
            PoiStateElementNoSurrounding.parentPOIState = PoiStateSelectFromResultList.currentSpellerState;
            PoiAbstractElementCommon.continueSearch = true;
            this.myTarget.transAfterCallback(this.myTarget.statePoiElementNoSurrounding);
        } else if (PoiDatapool.getInstance().getCurrentUseCase() == 2) {
            this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        } else {
            if (!isChild) {
                PoiStateElementSurrounding.runningSearchState = PoiStateSelectFromResultList.currentSpellerState;
            }
            PoiAbstractElementCommon.continueSearch = true;
            this.myTarget.transAfterCallback(this.myTarget.statePoiElementSurrounding);
        }
    }

    private void handleHsmStart() {
        MapConfiguration mapConfiguration = new MapConfiguration(currentDestinationLocation, 25, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(13, mapConfiguration);
        mapConfiguration.setPoiShowCategoryIcon(true);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPOILocation(currentDestinationLocation);
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(currentDestinationLocation);
        this.writePoiDetails(iLocationWrapper);
        try {
            this.writePoiChargingStationDetails(iLocationWrapper);
        }
        catch (Throwable throwable) {
            ServiceManager.logger.error(16384, "Workaround for wrong POIFactory", throwable);
        }
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    private void writePoiDetails(ILocationWrapper iLocationWrapper) {
        ResourceLocator resourceLocator;
        this.myTarget.myTrace(this, "writePoiDetails");
        int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(PoiStateDetail.currentDestinationLocation.longitude, PoiStateDetail.currentDestinationLocation.latitude, PoiDatapool.getInstance().getReferenceLocation().getLongitude(), PoiDatapool.getInstance().getReferenceLocation().getLatitude());
        int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDirectionIndex(PoiDatapool.getInstance().getReferenceLocation().getLongitude(), PoiDatapool.getInstance().getReferenceLocation().getLatitude(), PoiStateDetail.currentDestinationLocation.longitude, PoiStateDetail.currentDestinationLocation.latitude, PoiDatapool.getInstance().getReferenceDirection());
        int n3 = iLocationWrapper.getIconIndex();
        int n4 = iLocationWrapper.getSubIconIndex();
        int n5 = iLocationWrapper.getLatitude();
        int n6 = iLocationWrapper.getLongitude();
        String string = iLocationWrapper.getPoiClass();
        String string2 = iLocationWrapper.getPoiCategory();
        String string3 = iLocationWrapper.getPoiName();
        String string4 = iLocationWrapper.getCountry();
        String string5 = iLocationWrapper.getCountryCode();
        String string6 = iLocationWrapper.getCity();
        String string7 = iLocationWrapper.getCityRefinement();
        String string8 = iLocationWrapper.getCityCenter();
        String string9 = iLocationWrapper.getStreet();
        String string10 = iLocationWrapper.getStreetRefinement();
        String string11 = iLocationWrapper.getCrossing();
        String string12 = iLocationWrapper.getHousenumber();
        String string13 = iLocationWrapper.getPostalCode();
        String string14 = iLocationWrapper.getMotorWayExit();
        String string15 = iLocationWrapper.getPhonenumber();
        String string16 = "";
        String string17 = "";
        try {
            string16 = iLocationWrapper.getState();
        }
        catch (Throwable throwable) {
            ServiceManager.logger.error(16384, "Workaround for wrong POIFactory", throwable);
        }
        try {
            string17 = iLocationWrapper.getProvince();
        }
        catch (Throwable throwable) {
            ServiceManager.logger.error(16384, "Workaround for wrong POIFactory", throwable);
        }
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("distance=").append(n).log();
            this.myTarget.makeTrace(this).append("direction=").append(n2).log();
            this.myTarget.makeTrace(this).append("getIconIndex=").append(n3).log();
            this.myTarget.makeTrace(this).append("getSubIconIndex=").append(n4).log();
            this.myTarget.makeTrace(this).append("getLatitude=").append(n5).log();
            this.myTarget.makeTrace(this).append("getLongitude=").append(n6).log();
            this.myTarget.makeTrace(this).append("getPoiClass=").append(string).log();
            this.myTarget.makeTrace(this).append("getPoiCategory=").append(string2).log();
            this.myTarget.makeTrace(this).append("getPoiName=").append(string3).log();
            this.myTarget.makeTrace(this).append("getCountry=").append(string4).log();
            this.myTarget.makeTrace(this).append("getCountryAbbreviation=").append(string5).log();
            this.myTarget.makeTrace(this).append("getTown=").append(string6).log();
            this.myTarget.makeTrace(this).append("getTownRefinement=").append(string7).log();
            this.myTarget.makeTrace(this).append("getTowncenter=").append(string8).log();
            this.myTarget.makeTrace(this).append("getStreet=").append(string9).log();
            this.myTarget.makeTrace(this).append("getStreetRefinement=").append(string10).log();
            this.myTarget.makeTrace(this).append("getJunction=").append(string11).log();
            this.myTarget.makeTrace(this).append("getHousenumber=").append(string12).log();
            this.myTarget.makeTrace(this).append("getZipCode=").append(string13).log();
            this.myTarget.makeTrace(this).append("getMotorWayExit=").append(string14).log();
            this.myTarget.makeTrace(this).append("getPhonenumber=").append(string15).log();
            this.myTarget.makeTrace(this).append("getState=").append(string16).log();
            this.myTarget.makeTrace(this).append("getProvince=").append(string17).log();
        }
        this.poiDetailsCollector = new NavigationPOIResultSelectedDetailsCollector();
        this.poiDetailsCollector.navigation_poi_result_selected_details_distance = n;
        this.poiDetailsCollector.navigation_poi_result_selected_details_direction_arrow_index = n2;
        this.poiDetailsCollector.navigation_poi_result_selected_details_headline_icon = resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(n3, n4, 0, this, null);
        this.poiDetailsCollector.navigation_poi_result_selected_details_latitude = n5;
        this.poiDetailsCollector.navigation_poi_result_selected_details_longitude = n6;
        this.poiDetailsCollector.navigation_poi_result_selected_details_class = string;
        this.poiDetailsCollector.navigation_poi_result_selected_details_category = string2;
        this.poiDetailsCollector.navigation_poi_result_selected_details_name = string3;
        this.poiDetailsCollector.navigation_poi_result_selected_details_country = string4;
        this.poiDetailsCollector.navigation_poi_result_selected_details_country_code = string5;
        this.poiDetailsCollector.navigation_poi_result_selected_details_city = string6;
        this.poiDetailsCollector.navigation_poi_result_selected_details_city_refinement = string7;
        this.poiDetailsCollector.navigation_poi_result_selected_details_city_center = string8;
        this.poiDetailsCollector.navigation_poi_result_selected_details_street = string9;
        this.poiDetailsCollector.navigation_poi_result_selected_street_refinement = string10;
        this.poiDetailsCollector.navigation_poi_result_selected_details_crossing = string11;
        this.poiDetailsCollector.navigation_poi_result_selected_details_housenumber = string12;
        this.poiDetailsCollector.navigation_poi_result_selected_details_zip = string13;
        this.poiDetailsCollector.navigation_poi_result_selected_details_motorway_exit = string14;
        this.poiDetailsCollector.navigation_poi_result_selected_details_phone_number = string15;
        this.poiDetailsCollector.navigation_poi_result_selected_details_url = "";
        this.poiDetailsCollector.navigation_poi_result_selected_details_state = string16;
        this.poiDetailsCollector.navigation_poi_result_selected_details_province = string17;
        this.poiDetailsCollector.navigation_poi_result_selected_detail_address_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        this.myTarget.notifierModel.notifyPoiName(string3);
        ServiceManager.aslPropertyManager.valueChangedString(-672133120, iLocationWrapper.getURLAddress());
        this.myTarget.notifierModel.notifyPoiDetails(this.poiDetailsCollector);
    }

    private void writePoiChargingStationDetails(ILocationWrapper iLocationWrapper) {
        int n;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("writePoiChargingStationDetails").log();
        }
        String string = iLocationWrapper.getChargingStationProvider() != null ? iLocationWrapper.getChargingStationProvider() : "";
        int n2 = iLocationWrapper.getChargingStationAccess();
        int n3 = iLocationWrapper.getChargingStationOnSitePayment();
        int n4 = iLocationWrapper.getChargingStationOpen24h();
        int n5 = iLocationWrapper.getChargingStationPay();
        int n6 = iLocationWrapper.getChargingStationSubscription();
        int n7 = iLocationWrapper.getEConnectorCount();
        IEConnector[] iEConnectorArray = iLocationWrapper.getEConnectors();
        boolean bl = true;
        if (ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV()) {
            int n8 = NaviHelper.getInstance().calculateDistance(iLocationWrapper.getLongitude(), iLocationWrapper.getLatitude(), PoiDatapool.getInstance().getCcp().getLongitude(), PoiDatapool.getInstance().getCcp().getLatitude());
            n = (int)((double)PoiDatapool.getInstance().getRemainingBatteryRangeFixed() * 0.95 / 1.25);
            if (n < n8) {
                // empty if block
            }
        }
        this.poiDetailsCollector.navigation_poi_result_selected_details_inside_range = bl;
        this.poiDetailsCollector.navigation_poi_result_selected_details_provider_available = string != null && string.length() > 0;
        this.poiDetailsCollector.navigation_poi_result_selected_details_provider = string;
        switch (n2) {
            case -1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 0;
                break;
            }
            case 0: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 1;
                break;
            }
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 2;
                break;
            }
            case 2: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 3;
                break;
            }
            case 3: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 4;
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_access = 0;
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this).append("'chargingAccess' unknown value!").log();
            }
        }
        switch (n3) {
            case -1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available = false;
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment = "";
                break;
            }
            case 0: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available = false;
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment = "";
                break;
            }
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available = true;
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment = ":-)";
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available = false;
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment = "";
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this).append("'chargingStationOnSitePayment' unknown value!").log();
            }
        }
        switch (n3) {
            case -1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum = 0;
                break;
            }
            case 0: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum = 2;
                break;
            }
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum = 1;
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum = 0;
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this).append("'chargingStationOnSitePayment' unknown value!").log();
            }
        }
        switch (n4) {
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_open24h = 2;
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_open24h = 0;
            }
        }
        switch (n5) {
            case -1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_payment = 0;
                break;
            }
            case 0: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_payment = 2;
                break;
            }
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_payment = 1;
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_payment = 0;
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this).append("'chargingStationPay' unknown value!").log();
            }
        }
        switch (n6) {
            case -1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_subscription = 0;
                break;
            }
            case 0: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_subscription = 2;
                break;
            }
            case 1: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_subscription = 1;
                break;
            }
            default: {
                this.poiDetailsCollector.navigation_poi_result_selected_details_subscription = 0;
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this).append("'chargingStationSubscription' unknown value!").log();
            }
        }
        this.poiDetailsCollector.navigation_poi_result_selected_details_connector_count = n7;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("chargingProvider=").append(string).log();
            this.myTarget.makeTrace(this).append("chargingAccess=").append(n2).log();
            this.myTarget.makeTrace(this).append("chargingStationOnSitePayment=").append(n3).log();
            this.myTarget.makeTrace(this).append("chargingStationOpen24h=").append(n4).log();
            this.myTarget.makeTrace(this).append("chargingStationPay=").append(n5).log();
            this.myTarget.makeTrace(this).append("chargingStationSubscription=").append(n6).log();
            this.myTarget.makeTrace(this).append("eConnectorCount=").append(n7).log();
        }
        this.myTarget.notifierModel.notifyPoiDetails(this.poiDetailsCollector);
        PoiConnectorDetailsCollector[] poiConnectorDetailsCollectorArray = new PoiConnectorDetailsCollector[n7];
        for (n = 0; n < n7; ++n) {
            String string2;
            String string3;
            int n9;
            String string4;
            String string5;
            poiConnectorDetailsCollectorArray[n] = new PoiConnectorDetailsCollector(0, "", "", "", "", 0, 0);
            if (iEConnectorArray[n] == null) {
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) continue;
                this.myTarget.makeError(this).append("eConnector[").append(n).append("] == null!").log();
                continue;
            }
            poiConnectorDetailsCollectorArray[n].chargeMode = string5 = iEConnectorArray[n].getChargeMode() != null ? iEConnectorArray[n].getChargeMode() : "";
            poiConnectorDetailsCollectorArray[n].chargeLevel = string4 = iEConnectorArray[n].getChargeLevel() != null ? iEConnectorArray[n].getChargeLevel() : "";
            poiConnectorDetailsCollectorArray[n].count = n9 = iEConnectorArray[n].getCountAvailable();
            poiConnectorDetailsCollectorArray[n].fuseProtection = string3 = iEConnectorArray[n].getFuseProtection() != null ? iEConnectorArray[n].getFuseProtection() : "";
            poiConnectorDetailsCollectorArray[n].name = string2 = iEConnectorArray[n].getName() != null ? iEConnectorArray[n].getName() : "";
            float f2 = iEConnectorArray[n].getPowerOutput();
            poiConnectorDetailsCollectorArray[n].poweroutput = (int)(f2 * 31300);
            int n10 = iEConnectorArray[n].getType();
            switch (n10) {
                case -1: {
                    poiConnectorDetailsCollectorArray[n].type = 0;
                    break;
                }
                case 15: {
                    poiConnectorDetailsCollectorArray[n].type = 1;
                    break;
                }
                case 32: {
                    poiConnectorDetailsCollectorArray[n].type = 2;
                    break;
                }
                case 33: {
                    poiConnectorDetailsCollectorArray[n].type = 3;
                    break;
                }
                case 42: {
                    poiConnectorDetailsCollectorArray[n].type = 4;
                    break;
                }
                case 43: {
                    poiConnectorDetailsCollectorArray[n].type = 5;
                    break;
                }
                case 31: {
                    poiConnectorDetailsCollectorArray[n].type = 6;
                    break;
                }
                case 41: {
                    poiConnectorDetailsCollectorArray[n].type = 7;
                    break;
                }
                default: {
                    poiConnectorDetailsCollectorArray[n].type = 0;
                    if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                    this.myTarget.makeError(this).append("'type' unknown value!").log();
                }
            }
            if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) continue;
            this.myTarget.makeTrace(this).append("chargeMode=").append(string5).log();
            this.myTarget.makeTrace(this).append("chargeLevel=").append(string4).log();
            this.myTarget.makeTrace(this).append("countAvailable=").append(n9).log();
            this.myTarget.makeTrace(this).append("fuseProtection=").append(string3).log();
            this.myTarget.makeTrace(this).append("name=").append(string2).log();
            this.myTarget.makeTrace(this).append("powerOutput=").append(f2).log();
            this.myTarget.makeTrace(this).append("type=").append(n10).log();
        }
        this.myTarget.notifierModel.notifyPoiConnectorDetails(poiConnectorDetailsCollectorArray);
    }

    private void handleRESULTSELECTNEXTDETAILS() {
        ++currentDetailsIndex;
        PoiStateSelectFromResultList.restore = true;
        this.myTarget.transAfterCallback(this.myTarget.statePoiSelectFromResultList);
    }

    private void handleRESULTSELECTPREVDETAILS() {
        if (currentDetailsIndex > 0) {
            --currentDetailsIndex;
            PoiStateSelectFromResultList.restore = true;
            this.myTarget.transAfterCallback(this.myTarget.statePoiSelectFromResultList);
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("handleIconCacheUpdate index:").append(" IconID:").append(resourceLocator.getId()).log();
        }
        this.poiDetailsCollector.navigation_poi_result_selected_details_headline_icon = resourceLocator;
        this.myTarget.notifierModel.notifyPoiDetails(this.poiDetailsCollector);
    }

    static {
        isChild = false;
    }
}

