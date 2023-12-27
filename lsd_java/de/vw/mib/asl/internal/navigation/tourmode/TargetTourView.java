/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.tourmode;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.AbstractResettableNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRmRouteAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRmRouteDelete;
import de.vw.mib.asl.internal.navigation.guidance.ASLNavGuidanceDP;
import de.vw.mib.asl.internal.navigation.tourmode.CollectorFiller;
import de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourDestinationCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.SpellerData;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourModeLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourModeLocationPOIDataCollector;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRmRouteListData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.util.RouteHelper;

public class TargetTourView
extends AbstractResettableNavGatewayTarget
implements CacheClient,
DSIServiceStateListener {
    public static final int EV_LOAD_TOUR;
    public static final int EV_LOAD_TOUR_P0_ROUTE_ID_LONG;
    public static final int EV_LOAD_LAST_TOUR;
    private static final int[] OBSERVER;
    private static final INavigationDP NAVIGATION_DP;
    private static final int RMID;
    private static final Integer ICON_FOR_DETAILS;
    private static final int MAX_ALLOWED_SPELLER_CHARACTERS;
    private DSINavigation dsiNavigation;
    private boolean editModeActive;
    private NavRmRouteListData[] tourMemList;
    private Route editModeTour;
    private final SpellerData spellerData = new SpellerData();
    private NavigationTourModeTourDestinationCollector[] modelTourList;
    private long sameNameRouteId;
    private boolean changesDiscarded;
    private RgInfoForNextDestination infoForNextDest;
    private Route rgCurrentRoute;
    private NavRouteListData[] rgDestinationInfo;
    private NavigationTourModeTourModeLocationPOIDataCollector detailsPoiCollector;
    private boolean tourListSavedBeforeLeaving;
    private boolean skippingStopover;
    private boolean isServiceStateListenerAdded = false;
    private DSIListener navigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public TargetTourView(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetTourView.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                }
                this.addObservers(OBSERVER);
                int n = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(3);
                int n2 = n - 1;
                ServiceManager.aslPropertyManager.valueChangedInteger(1458573312, n2);
                break;
            }
            case 107: {
                this.removeObservers(OBSERVER);
                break;
            }
            case 1073743734: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_SET_EDIT_MODE");
                }
                this.caseSetEditMode(eventGeneric.getBoolean(0));
                break;
            }
            case 1073742574: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_ADD_NEW_TOUR_LIST_ELEMENT");
                }
                this.caseNewTourListElement(eventGeneric);
                break;
            }
            case 1073742577: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_CLEAR_TOUR_LIST");
                }
                this.caseClearTourList();
                break;
            }
            case 1073742579: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_DELETE_TOUR_LIST_ELEMENT");
                }
                this.caseDeleteTourListElement(eventGeneric);
                break;
            }
            case 1073742575: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_CHECK_TOUR_LIST_NAME");
                }
                this.caseCheckTourListName();
                break;
            }
            case 1073742581: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_DISCARD_TOUR_LIST_CHANGES");
                }
                this.caseDiscardChanges();
                break;
            }
            case 1073742587: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_MOVE_TOUR_LIST_ELEMENT");
                }
                this.caseMoveTourListElement(eventGeneric);
                break;
            }
            case 1073743908: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_SKIP_NEXT_STOPOVER");
                }
                this.caseSkipNextStopover();
                break;
            }
            case 1073742591: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_SAVE_TOUR_LIST");
                }
                this.caseSaveTourList();
                break;
            }
            case 1073742597: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_START_ROUTE_CALC");
                }
                this.caseStartRouteCalc();
                break;
            }
            case 1073742598: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_START_ROUTE_CALC_DIRECT");
                }
                this.caseStartRouteCalcDirect(eventGeneric);
                break;
            }
            case 1073742588: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_RECALC_TOUR");
                }
                this.caseRecalculateTour();
                break;
            }
            case 1073742589: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_REPLACE_TOUR_IN_TOUR_MEM_LIST");
                }
                this.caseReplaceTourList();
                break;
            }
            case 1073742593: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_SPELLER_INIT");
                }
                this.caseInitSpeller();
                break;
            }
            case 1073742594: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_SPELLER_SET_CHAR");
                }
                this.caseSpellerSetChar(eventGeneric);
                break;
            }
            case 0x40000300: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_SPELLER_DELETE_CHAR");
                }
                this.caseSpellerDeleteChar();
                break;
            }
            case 0x40000303: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_SPELLER_SET_CURSOR_POSITION");
                }
                this.caseSpellerSetCursorPosition(eventGeneric);
                break;
            }
            case 1073742583: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: ASL_NAVIGATION_TOURMODE_LOAD_DETAILS_OF_TOUR_LIST_ELEMENT");
                }
                this.caseLoadTourListElementDetails(eventGeneric);
                break;
            }
            case 1074841881: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: LEAVE_TOUR_LIST");
                }
                this.caseLeaveTourList(eventGeneric);
                break;
            }
            case 1074841886: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: SPELLER_SET_CHAR_HWR");
                }
                this.caseSpellerSetCharHwr(eventGeneric);
                break;
            }
            case 1074841885: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: SPELLER_DELETE_ALL_CHARS");
                }
                ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().clear(this.spellerData);
                this.updateNameSpellerData();
                break;
            }
            case 1074841887: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: SET_HWR_SPELLER_MODE_ENABLED");
                }
                boolean bl = eventGeneric.getBoolean(0);
                ServiceManager.aslPropertyManager.valueChangedBoolean(1127358464, bl);
                break;
            }
            case 4300051: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: MINUTE_TRIGGER");
                }
                this.updateModelTourListDynamicData();
                break;
            }
            case 100100: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: EV_LOAD_TOUR");
                }
                this.sameNameRouteId = eventGeneric.getLong(0);
                this.dsiNavigation.rmRouteGet(1, this.sameNameRouteId);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace("TargetTourView: default event");
            }
        }
    }

    private void caseLeaveTourList(EventGeneric eventGeneric) {
        if (this.tourListSavedBeforeLeaving) {
            if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive() && this.rgCurrentRoute != null) {
                NAVIGATION_DP.setTourmodeRoute(this.rgCurrentRoute);
                this.updateModelTourListElements(this.rgCurrentRoute, true);
                this.updateModelTourListDynamicData();
            }
            this.tourListSavedBeforeLeaving = false;
        }
    }

    private void caseSkipNextStopover() {
        if (this.editModeTour != null) {
            long l = this.editModeTour.getIndexOfCurrentDestination();
            if (l < (long)(this.editModeTour.getRoutelist().length - 1)) {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView: Skipping next stopover");
                }
                this.editModeTour.indexOfCurrentDestination = l + 1L;
                this.skippingStopover = true;
            } else {
                this.warn("TargetTourView: Can't skip the last stopover in a tour. This call should have been avoided by the model");
            }
        }
    }

    private void caseClearTourList() {
        Route route = new Route();
        RouteHelper.deleteAllStopovers(route);
        NAVIGATION_DP.setTourmodeRoute(route);
        this.editModeTour = route;
        this.updateModelTourListElements(route, true);
        ServiceManager.aslPropertyManager.valueChangedString(998, "");
        ServiceManager.aslPropertyManager.valueChangedBoolean(1003, false);
    }

    private void caseLoadTourListElementDetails(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.isTraceEnabled()) {
            this.trace().append("Loading details for list item ").append(n).log();
        }
        if (this.modelTourList != null && this.modelTourList.length > n) {
            ResourceLocator resourceLocator;
            int n2;
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.modelTourList[n].getDestination().getRouteLocation());
            NavigationTourModeTourModeLocationCollector navigationTourModeTourModeLocationCollector = new NavigationTourModeTourModeLocationCollector();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_address_details_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_address_format = 0;
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_city = iLocationWrapper.getCity();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_city_center = iLocationWrapper.isCityCenter();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_city_refinement = iLocationWrapper.getCityRefinement();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_country = iLocationWrapper.getCountry();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_country_code = iLocationWrapper.getCountryCode();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_country_icon = null;
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_crossing = iLocationWrapper.getCrossing();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_empty = false;
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_full_postal_code = iLocationWrapper.isFullPostalCode();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_guideable = iLocationWrapper.isNavigable();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_housenumber = iLocationWrapper.getHousenumber();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_lat_degree = iLocationWrapper.getLatitudeDegrees();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_lat_minutes = iLocationWrapper.getLatitudeMinutes();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_lat_seconds = iLocationWrapper.getLatitudeSeconds();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_lon_degree = iLocationWrapper.getLongitudeDegrees();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_lon_minutes = iLocationWrapper.getLongitudeMinutes();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_lon_seconds = iLocationWrapper.getLongitudeSeconds();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_postal_code = iLocationWrapper.getPostalCode();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_postal_code_needed = iLocationWrapper.isPostalCodeNeeded();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_postal_code_spelled = iLocationWrapper.isPostalCodeSpelled();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_province = iLocationWrapper.getProvince();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_resolved = iLocationWrapper.isNavigable();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_state = iLocationWrapper.getState();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_stopover_index = n + 1;
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_street = iLocationWrapper.getStreet();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_street_refinement = iLocationWrapper.getStreetRefinement();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_street_refinement_needed = false;
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_town_order = iLocationWrapper.isTownorder9();
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_town_refinement_needed = iLocationWrapper.isCityRefinementNeeded();
            switch (iLocationWrapper.getLocationType()) {
                case 0: {
                    n2 = 1;
                    break;
                }
                case 3: {
                    n2 = 2;
                    break;
                }
                default: {
                    n2 = 0;
                }
            }
            navigationTourModeTourModeLocationCollector.navigation_tourmode_tour_mode_location_type = n2;
            ListManager.getGenericASLList(-17887232).updateList(new Object[]{navigationTourModeTourModeLocationCollector});
            this.detailsPoiCollector = new NavigationTourModeTourModeLocationPOIDataCollector();
            this.detailsPoiCollector.navigation_tourmode_tour_mode_location_poi_data_category = iLocationWrapper.getPoiCategory();
            this.detailsPoiCollector.navigation_tourmode_tour_mode_location_poi_data_icon = resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, this, ICON_FOR_DETAILS);
            this.detailsPoiCollector.navigation_tourmode_tour_mode_location_poi_data_name = iLocationWrapper.getPoiName();
            this.detailsPoiCollector.navigation_tourmode_tour_mode_location_poi_data_phone_number = iLocationWrapper.getPhonenumber();
            this.detailsPoiCollector.navigation_tourmode_tour_mode_location_poi_data_url = "";
            ListManager.getGenericASLList(-1110016).updateList(new Object[]{this.detailsPoiCollector});
            this.setMapLocation(iLocationWrapper.getLocation(), n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("modelTourList is null or < index ").log();
        }
        this.quitModelWaitState();
    }

    private void caseNewTourListElement(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        if (n2 == 8) {
            this.editModeTour = ASLNavGuidanceDP.getInstance().getTourBackup();
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1678766080, false);
        } else {
            NavLocation navLocation = this.getLocationFromInputSource(n2);
            if (navLocation != null) {
                RouteDestination routeDestination = new RouteDestination(navLocation, ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getSingleRouteOptions(), 1);
                this.editModeTour = this.removeSoftDestinations(this.editModeTour);
                switch (n) {
                    case 0: {
                        if (this.isTraceEnabled()) {
                            this.trace().append("TargetTourView: Adding new destination to tour as next stopover: ").append(routeDestination.toString()).log();
                        }
                        RouteHelper.addDestinationAtPosition(this.editModeTour, routeDestination, (int)this.editModeTour.getIndexOfCurrentDestination());
                        break;
                    }
                    case 1: {
                        if (this.isTraceEnabled()) {
                            this.trace().append("TargetTourView: Adding new destination to tour as last tour element: ").append(routeDestination.toString()).log();
                        }
                        RouteHelper.addDestinationAtPosition(this.editModeTour, routeDestination, this.editModeTour.getRoutelist() != null ? this.editModeTour.getRoutelist().length : 0);
                        break;
                    }
                }
            }
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1003, true);
        this.updateModelTourListElements(this.editModeTour, false);
    }

    private NavLocation getLocationFromInputSource(int n) {
        NavLocation navLocation;
        switch (n) {
            case 0: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView.getLocationFromInputSource: C0_ADDRESS_INPUT");
                }
                navLocation = NAVIGATION_DP.getDestInputLocation();
                break;
            }
            case 1: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView.getLocationFromInputSource: C1_MAP_INPUT");
                }
                navLocation = NAVIGATION_DP.getMapInputLocation();
                break;
            }
            case 2: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView.getLocationFromInputSource: C2_POI_INPUT");
                }
                navLocation = NAVIGATION_DP.getPOILocation();
                break;
            }
            case 3: 
            case 4: 
            case 5: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView.getLocationFromInputSource: C3_MEMORY_DETAIL, C4_MEM_FLAGDEST, C5_MEMORY_GPSPIC");
                }
                navLocation = NAVIGATION_DP.getMemoryLocation();
                break;
            }
            case 6: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView.getLocationFromInputSource: C6_NEW_ADDRESS");
                }
                navLocation = NAVIGATION_DP.getTourmodeLocation();
                break;
            }
            case 255: {
                this.warn("ADD_NEW_TOUR_LIST_ELEMENT__SOURCE__C7_UNUSED");
                navLocation = null;
                break;
            }
            case 7: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTourView.getLocationFromInputSource: C8_HOME");
                }
                navLocation = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation();
                break;
            }
            case 9: {
                if (this.isTraceEnabled()) {
                    this.trace("ADD_NEW_TOUR_LIST_ELEMENT__SOURCE__C10_NAV_DETAIL");
                }
                navLocation = NAVIGATION_DP.getDetailViewLocation();
                break;
            }
            default: {
                this.warn("DEFAULT handling");
                navLocation = null;
            }
        }
        return navLocation;
    }

    private void caseMoveTourListElement(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        if (this.isTraceEnabled()) {
            this.trace().append("Moving list element from index ").append(n).append(" to ").append(n2).log();
        }
        this.editModeTour = this.removeSoftDestinations(this.editModeTour);
        RouteHelper.moveDestination(this.editModeTour, n, n2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1003, true);
        this.updateModelTourListElements(this.editModeTour, false);
    }

    private void caseDeleteTourListElement(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.isTraceEnabled()) {
            this.trace().append("Deleting list element with index ").append(n).log();
        }
        this.editModeTour = this.removeSoftDestinations(this.editModeTour);
        if ((long)n < this.editModeTour.getIndexOfCurrentDestination()) {
            --this.editModeTour.indexOfCurrentDestination;
        }
        RouteHelper.deleteDestinationAtPosition(this.editModeTour, n);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1003, true);
        this.updateModelTourListElements(this.editModeTour, false);
    }

    private void caseDiscardChanges() {
        this.changesDiscarded = true;
        ServiceManager.aslPropertyManager.valueChangedBoolean(1003, false);
        this.quitModelWaitState();
    }

    private void caseStartRouteCalc() {
        if (this.editModeTour != null && this.editModeTour.getRoutelist() != null && this.editModeTour.getRoutelist().length > 0) {
            NAVIGATION_DP.setTourmodeRoute(this.editModeTour);
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1003, false);
        this.quitModelWaitState();
    }

    private void caseStartRouteCalcDirect(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.isTraceEnabled()) {
            this.trace().append("TargetTourView: Starting tour guidance from destination with index ").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1003, false);
        Route route = this.editModeActive ? this.editModeTour : NAVIGATION_DP.getTourmodeRoute();
        route.setIndexOfCurrentDestination(n);
        NAVIGATION_DP.setTourmodeRoute(route);
        this.quitModelWaitState();
    }

    private void caseRecalculateTour() {
        Route route;
        if (this.editModeTour != null) {
            this.warn("TargetTourView: Recalculating a tour with edit mode still active. Check sequence!");
            NAVIGATION_DP.setTourmodeRoute(this.editModeTour);
        }
        if (route.indexOfCurrentDestination >= (long)(route = NAVIGATION_DP.getTourmodeRoute()).getRoutelist().length) {
            route.setIndexOfCurrentDestination(0L);
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1003, false);
    }

    private void caseCheckTourListName() {
        boolean bl = false;
        String string = this.spellerData.getEnteredText();
        if (this.tourMemList != null) {
            for (int i2 = 0; i2 < this.tourMemList.length; ++i2) {
                if (this.tourMemList[i2].getName() == null || !this.tourMemList[i2].getName().equals(string)) continue;
                this.sameNameRouteId = this.tourMemList[i2].getRouteId();
                bl = true;
                break;
            }
        }
        ServiceManager.aslPropertyManager.valueChangedString(998, string);
        ServiceManager.aslPropertyManager.valueChangedBoolean(999, bl);
        this.quitModelWaitState();
    }

    private void caseSaveTourList() {
        String string = this.spellerData.getEnteredText();
        if (this.isTraceEnabled()) {
            this.trace().append("TargetTourView: Saving tour with name ").append(string != null ? string : "").log();
        }
        Route route = this.editModeActive ? this.editModeTour : NAVIGATION_DP.getTourmodeRoute();
        route.setRoutename(string);
        new CmdRmRouteAdd(this, route, 1, string).execute();
        ServiceManager.aslPropertyManager.valueChangedString(998, string);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1003, false);
        this.tourListSavedBeforeLeaving = true;
    }

    private void caseReplaceTourList() {
        Route route = this.editModeActive ? this.editModeTour : NAVIGATION_DP.getTourmodeRoute();
        for (int i2 = 0; i2 < this.tourMemList.length; ++i2) {
            if (this.tourMemList[i2].getRouteId() != this.sameNameRouteId) continue;
            String string = this.tourMemList[i2].getName();
            if (!StringUtil.isEmpty(string)) {
                route.setRoutename(string);
            }
            ServiceManager.aslPropertyManager.valueChangedString(998, route.getRoutename());
            break;
        }
        new CmdRmRouteDelete(this, this.sameNameRouteId, 1).execute();
        new CmdRmRouteAdd(this, route, 1, route.getRoutename()).execute();
        this.tourListSavedBeforeLeaving = true;
        ServiceManager.aslPropertyManager.valueChangedBoolean(1003, false);
        this.quitModelWaitState();
    }

    private void caseInitSpeller() {
        this.spellerData.setEnteredText("");
        this.spellerData.setCursorPosition(0);
        Route route = this.editModeActive ? this.editModeTour : NAVIGATION_DP.getTourmodeRoute();
        if (route != null && route.getRoutelist() != null && route.getRoutelist().length > 0) {
            String string = this.generateTourName(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(route.getRoutelist()[route.getRoutelist().length - 1].getRouteLocation()));
            this.spellerData.setEnteredText(string);
            this.spellerData.setCursorPosition(string.length());
            ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().selectAll(this.spellerData);
        }
        this.updateNameSpellerData();
        this.quitModelWaitState();
    }

    private void caseSpellerDeleteChar() {
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().deleteChar(this.spellerData);
        this.updateNameSpellerData();
    }

    private void caseSpellerSetChar(EventGeneric eventGeneric) {
        String string = eventGeneric.getString(0);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().addChar(this.spellerData, string);
        this.updateNameSpellerData();
    }

    private void caseSpellerSetCharHwr(EventGeneric eventGeneric) {
        String string = eventGeneric.getString(0);
        int n = eventGeneric.getInt(2);
        int n2 = eventGeneric.getInt(3);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().addChar(this.spellerData, string);
        this.spellerData.setSelectionStart(n);
        this.spellerData.setSelectionEnd(n2);
        if (this.isTraceEnabled()) {
            this.trace().append("spellerString: ").append(this.spellerData.getEnteredText()).log();
        }
        this.updateNameSpellerData();
    }

    private void caseSpellerSetCursorPosition(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().deselectAll(this.spellerData);
        this.spellerData.setCursorPosition(n);
        this.updateNameSpellerData();
    }

    private void caseSetEditMode(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetTourView: request to set edit mode to: ").append(bl).log();
        }
        if (this.editModeActive != bl) {
            if (this.isTraceEnabled()) {
                this.trace("TargetTourView: Changed edit mode");
            }
            this.editModeActive = bl;
            ServiceManager.aslPropertyManager.valueChangedBoolean(1004, bl);
            if (bl) {
                LogMessage logMessage = this.trace().append("TargetTourView.setEditMode: Using NavDP.tourmodeRoute as editModeTour");
                try {
                    if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive()) {
                        logMessage = this.trace().append("TargetTourView.setEditMode: Using NavDP.currentRoute as editModeTour");
                        this.editModeTour = (Route)CollectorFiller.genericClone(NAVIGATION_DP.getCurrentRoute());
                        String string = this.editModeTour.getRoutename();
                        if (string == null || string.length() == 0) {
                            ServiceManager.aslPropertyManager.valueChangedString(998, "");
                        }
                    } else {
                        this.editModeTour = (Route)CollectorFiller.genericClone(NAVIGATION_DP.getTourmodeRoute());
                    }
                }
                catch (Exception exception) {
                    if (this.isTraceEnabled()) {
                        logMessage.log();
                    }
                    this.warn("TargetTourView.setEditMode: Something went wrong while cloning the current or tourmode route");
                }
                if (this.editModeTour == null) {
                    logMessage = this.trace().append("TargetTourView.setEditMode: Using NavDP.currentRoute as editModeTour");
                    try {
                        this.editModeTour = (Route)CollectorFiller.genericClone(NAVIGATION_DP.getCurrentRoute());
                        if (this.editModeTour.getRoutelist().length == 1) {
                            ServiceManager.aslPropertyManager.valueChangedString(998, "");
                        }
                    }
                    catch (Exception exception) {
                        this.warn("TargetTourView.setEditMode: Something went wrong while cloning the currentRoute");
                    }
                    if (this.editModeTour == null) {
                        this.warn("TargetTourView.setEditmode: No tour selected that can be edited. Initializing with an empty tour!");
                        logMessage = this.trace().append("TargetTourView.setEditMode: Using empty tour as editModeTour");
                        this.editModeTour = new Route();
                    }
                }
            } else {
                boolean bl2 = false;
                if (this.changesDiscarded) {
                    NAVIGATION_DP.setTourmodeRoute(NAVIGATION_DP.getCurrentRoute());
                    bl2 = true;
                } else {
                    NAVIGATION_DP.setTourmodeRoute(this.editModeTour);
                }
                this.updateModelTourListElements(NAVIGATION_DP.getTourmodeRoute(), false);
                if (bl2) {
                    this.dsiNavigationUpdateRgInfoForNextDestination(this.infoForNextDest, 1);
                    bl2 = false;
                }
                this.changesDiscarded = false;
                this.editModeTour = null;
            }
        } else if (this.isTraceEnabled()) {
            this.trace("TargetTourView: edit mode not changed, state already up to date");
        }
    }

    private void updateNameSpellerData() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1001, this.spellerData.getEnteredText().trim().length() > 0);
        TargetTourView.writeSpellerDataToDatapool(996, this.spellerData);
    }

    private String generateTourName(ILocationWrapper iLocationWrapper) {
        String string = "";
        if (iLocationWrapper.getLocationType() == 3) {
            string = iLocationWrapper.getPoiName();
        } else {
            StringBuffer stringBuffer = new StringBuffer(iLocationWrapper.getCity());
            if (iLocationWrapper.isCityAvailable() && iLocationWrapper.isStreetAvailable()) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(iLocationWrapper.getStreet());
            string = stringBuffer.toString();
        }
        if (string.length() > 40) {
            string = string.substring(0, 40);
        }
        return string;
    }

    private void setMapLocation(NavLocation navLocation, int n) {
        if (navLocation.latitude != 0 && navLocation.longitude != 0) {
            MapConfiguration mapConfiguration = this.editModeActive || !ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive() ? new MapConfiguration(navLocation, 25, 0) : new MapConfiguration(navLocation, 29, 0);
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(25, mapConfiguration);
        }
    }

    private void updateModelTourListElements(Route route, boolean bl) {
        boolean[] blArray;
        if (route != null && route.getRoutelist() != null) {
            blArray = new boolean[route.getRoutelist().length];
            this.modelTourList = new NavigationTourModeTourDestinationCollector[route.getRoutelist().length];
            for (int i2 = 0; i2 < route.getRoutelist().length; ++i2) {
                NavigationTourModeTourDestinationCollector navigationTourModeTourDestinationCollector;
                boolean bl2 = blArray[i2] = route.getRoutelist()[i2].getDestinationType() != 2;
                if (bl) {
                    navigationTourModeTourDestinationCollector = new NavigationTourModeTourDestinationCollector(route.getRoutelist()[i2], 1006, i2);
                } else {
                    navigationTourModeTourDestinationCollector = (NavigationTourModeTourDestinationCollector)ListManager.getGenericASLList(1006).getRowItemCacheOnly(i2);
                    if (navigationTourModeTourDestinationCollector != null) {
                        navigationTourModeTourDestinationCollector.setDestination(route.getRoutelist()[i2]);
                        navigationTourModeTourDestinationCollector.setPassed((long)i2 < route.indexOfCurrentDestination);
                    } else {
                        navigationTourModeTourDestinationCollector = new NavigationTourModeTourDestinationCollector(route.getRoutelist()[i2], 1006, i2);
                    }
                }
                if (navigationTourModeTourDestinationCollector.routeLocation.getLocationType() == 3) {
                    navigationTourModeTourDestinationCollector.setPoiIcon(ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(navigationTourModeTourDestinationCollector.routeLocation.getIconIndex(), navigationTourModeTourDestinationCollector.routeLocation.getSubIconIndex(), 0, this, new Integer(i2)));
                }
                if (this.isTraceEnabled()) {
                    this.trace().append("DSI DestinationType = ").append(navigationTourModeTourDestinationCollector.routeLocation.getLocationDSIType()).log();
                }
                this.modelTourList[i2] = navigationTourModeTourDestinationCollector;
            }
            if (this.isTraceEnabled()) {
                this.trace("Updating model getter group NAVIGATION_TOURMODE_TOUR_LIST with tour destinations");
            }
            ListManager.getGenericASLList(1006).updateList(this.modelTourList);
        } else {
            this.warn("Route contains no RouteDestinations");
            this.modelTourList = new NavigationTourModeTourDestinationCollector[0];
            blArray = new boolean[]{};
            ListManager.getGenericASLList(1006).updateList(this.modelTourList);
        }
        TargetTourView.writeFlagVectorToDatapool(1794117632, blArray);
        this.quitModelWaitState();
    }

    private void updateModelTourListDynamicData() {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetTourView: updateRgInfoForNextDestination with currentRoute: ").append(this.rgCurrentRoute).log();
            this.trace().append("TargetTourView: updateRgInfoForNextDestination with destinationInfo: ").append(this.rgDestinationInfo).log();
            this.trace().append("TargetTourView: updateRgInfoForNextDestination with infoForNextDest: ").append(this.infoForNextDest).log();
        }
        if (this.infoForNextDest != null && this.rgCurrentRoute != null && this.rgDestinationInfo != null && this.rgCurrentRoute.getRoutelist() != null && this.rgCurrentRoute.getRoutelist().length > 0) {
            for (int i2 = 0; i2 < this.rgCurrentRoute.getRoutelist().length; ++i2) {
                long l = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteIndex(i2, this.infoForNextDest, this.rgDestinationInfo, this.rgCurrentRoute.indexOfCurrentDestination);
                long l2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttToRouteIndex(i2, this.infoForNextDest, this.rgDestinationInfo, this.rgCurrentRoute.indexOfCurrentDestination);
                boolean bl = NAVIGATION_DP.getRGIsActive() && i2 < (int)this.rgCurrentRoute.getIndexOfCurrentDestination();
                this.updateModelTourListElementDynamicData(i2, l, l2, bl);
            }
        }
    }

    private void updateModelTourListElementDynamicData(int n, long l, long l2, boolean bl) {
        if (!this.editModeActive && this.modelTourList != null && this.modelTourList.length > n) {
            this.modelTourList[n].setPassed(bl);
            if (bl) {
                this.modelTourList[n].setDtd(-1);
                this.modelTourList[n].setEtaD(-1);
                this.modelTourList[n].setEtaH(-1);
                this.modelTourList[n].setEtaM(-1);
            } else {
                this.modelTourList[n].setDtd((int)l);
                int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateEta(l2);
                this.modelTourList[n].setEtaD(nArray[2]);
                this.modelTourList[n].setEtaH(nArray[0]);
                this.modelTourList[n].setEtaM(nArray[1]);
            }
            ListManager.getGenericASLList(1006).updateListItem(n, this.modelTourList[n]);
        }
    }

    private void updateTourTollInfo() {
        if (this.isTraceEnabled()) {
            this.trace().append("updateTourTollInfo()").log();
        }
        if (this.rgDestinationInfo != null && this.modelTourList != null && this.rgDestinationInfo.length <= this.modelTourList.length) {
            int n;
            for (n = 0; n < this.rgDestinationInfo.length; ++n) {
                int n2 = n == 0 ? (int)this.rgDestinationInfo[n].getTollCostAmount() : this.modelTourList[n - 1].getTollCost() + (int)this.rgDestinationInfo[n].getTollCostAmount();
                this.modelTourList[n].setTollCost(n2);
                int n3 = n == 0 ? (int)this.rgDestinationInfo[n].getTollLength() : this.modelTourList[n - 1].getTollLength() + (int)this.rgDestinationInfo[n].getTollLength();
                this.modelTourList[n].setTollLength(n3);
                this.modelTourList[n].setTollCurrency(this.rgDestinationInfo[n].getTollCostCurrency());
            }
            for (n = 0; n < this.modelTourList.length; ++n) {
                this.modelTourList[n].setTollCost(this.modelTourList[n].getTollCost());
            }
            if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
                LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
                logMessage.append(this.modelTourList);
                logMessage.log();
            }
            if (this.isTraceEnabled()) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < this.modelTourList.length; ++i2) {
                    stringBuffer.append(i2).append(": ").append(this.modelTourList[i2]).append("\n");
                }
                this.trace().append("Collector Content after Toll Info. Update: ").append(stringBuffer.toString()).log();
            }
            ListManager.getGenericASLList(1006).updateList(this.modelTourList);
        } else if (this.isTraceEnabled()) {
            this.trace().append("rgDestinationInfo or modelTourList is null or not synchronized)").log();
        }
    }

    private Route removeSoftDestinations(Route route) {
        if (route != null && route.getRoutelist() != null) {
            int n;
            boolean[] blArray = new boolean[route.getRoutelist().length];
            for (n = route.getRoutelist().length - 1; n >= 0; --n) {
                if (route.getRoutelist()[n] == null) continue;
                blArray[n] = route.getRoutelist()[n].getDestinationType() == 2;
            }
            for (n = blArray.length - 1; n >= 0; --n) {
                if (!blArray[n]) continue;
                if ((long)n < route.getIndexOfCurrentDestination()) {
                    --route.indexOfCurrentDestination;
                }
                RouteHelper.deleteDestinationAtPosition(route, n);
            }
        }
        return route;
    }

    private void quitModelWaitState() {
        ServiceManager.aslPropertyManager.valueChangedInteger(3021, 0);
    }

    public void dsiNavigationUpdateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
        if (navRmRouteListArrayDataArray == null || navRmRouteListArrayDataArray.length == 0) {
            this.tourMemList = new NavRmRouteListData[0];
            return;
        }
        boolean bl = false;
        for (int i2 = 0; i2 < navRmRouteListArrayDataArray.length; ++i2) {
            if (navRmRouteListArrayDataArray[i2].getRmId() != 1) continue;
            bl = true;
            this.tourMemList = navRmRouteListArrayDataArray[i2].getRouteList();
            if (this.tourMemList != null) break;
            this.tourMemList = new NavRmRouteListData[0];
            break;
        }
        if (!bl) {
            this.tourMemList = new NavRmRouteListData[0];
        }
    }

    public void dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        if (rgInfoForNextDestination != null) {
            this.infoForNextDest = rgInfoForNextDestination;
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive()) {
            this.updateModelTourListDynamicData();
        }
    }

    public void dsiNavigationUpdateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
        if (navRouteListDataArray != null) {
            this.rgDestinationInfo = navRouteListDataArray;
        }
        this.updateModelTourListDynamicData();
        this.updateTourTollInfo();
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace("TargetTourView.updateRgActive()");
        }
        if (!this.skippingStopover && !bl && NAVIGATION_DP.getTourmodeRoute() != null && NAVIGATION_DP.getTourmodeRoute().getRoutelist() != null) {
            NAVIGATION_DP.getTourmodeRoute().setIndexOfCurrentDestination(0L);
        }
        this.skippingStopover = false;
        this.updateModelTourListDynamicData();
    }

    public void dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        if (route != null && route.getRoutelist() != null && route.getRoutelist().length > 0) {
            if (this.isTraceEnabled()) {
                this.trace("TargetTourView.updateRgCurrentRoute() with active guidance route");
            }
            NAVIGATION_DP.setTourmodeRoute(route);
            this.rgCurrentRoute = route;
            if (!this.editModeActive) {
                this.updateModelTourListElements(route, false);
                this.updateModelTourListDynamicData();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("TargetTourView.updateRgCurrentRoute(null)!");
        }
    }

    public void dsiNavigationRmRouteGetResult(int n, Route route) {
        if (n == 0) {
            if (this.isTraceEnabled()) {
                this.trace().append("dsiNavigationRmRouteGetResult returned route name: ").append(route.getRoutename()).log();
            }
            route.indexOfCurrentDestination = 0L;
            route = this.removeSoftDestinations(route);
            NAVIGATION_DP.setTourmodeRoute(route);
            ServiceManager.aslPropertyManager.valueChangedString(998, route.getRoutename());
            ServiceManager.aslPropertyManager.valueChangedBoolean(1003, false);
            this.updateModelTourListElements(route, true);
        } else {
            this.warn("Tour could not be loaded");
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("rmGetRouteResult returned with an error code");
        }
    }

    public void dsiNavigationRmRouteReplaceResult(int n, long l, int n2) {
        if (n2 == 0) {
            if (this.isTraceEnabled()) {
                this.trace().append("rmRouteReplaceResult successful, replaced route ID: ").append(l).log();
            }
        } else {
            this.warn("Tour could not be replaced in tour memory");
        }
        this.quitModelWaitState();
    }

    @Override
    public void handleCommandCmdRmRouteDelete(CmdRmRouteDelete cmdRmRouteDelete) {
        if (this.isTraceEnabled()) {
            this.trace("Route deleted");
        }
    }

    @Override
    public void handleCommandCmdRmRouteAdd(CmdRmRouteAdd cmdRmRouteAdd) {
        if (cmdRmRouteAdd.getResultCode() == 0) {
            if (this.isTraceEnabled()) {
                this.trace("Route added");
            }
            this.sameNameRouteId = cmdRmRouteAdd.getRouteId();
        } else {
            this.warn("Tour could not be saved to tour memory");
        }
        this.quitModelWaitState();
    }

    @Override
    public void registered(String string, int n) {
        if (this.isFirstStartupDone) {
            return;
        }
        if (string.intern() != (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetTourView.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            return;
        }
        this.initDsiNavigation();
        this.isFirstStartupDone = true;
    }

    private void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetTourView.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetTourView.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetTourView.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        this.dsiNavigation.setNotification(48, this.navigationListener);
        this.dsiNavigation.setNotification(75, this.navigationListener);
        this.dsiNavigation.setNotification(13, this.navigationListener);
        this.dsiNavigation.setNotification(23, this.navigationListener);
        this.dsiNavigation.setNotification(11, this.navigationListener);
        if (this.isTraceEnabled()) {
            this.trace().append("TargetTourView registered DsiNavigation").log();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetTourView tries to unregister from ").append(string).log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetTourView.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiNavigation(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetTourView.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
            this.traceUnregisterDone(string);
        }
    }

    private void traceUnregisterDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetTourView unregistered from ").append(string).log();
        }
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (this.isTraceEnabled()) {
            this.trace("TargetTourView: handleIconCacheUpdate");
        }
        if (object == ICON_FOR_DETAILS) {
            if (this.detailsPoiCollector != null) {
                this.detailsPoiCollector.navigation_tourmode_tour_mode_location_poi_data_icon = resourceLocator;
            }
            ListManager.getGenericASLList(-1110016).updateList(new Object[]{this.detailsPoiCollector});
        } else {
            int n = (Integer)object;
            NavigationTourModeTourDestinationCollector navigationTourModeTourDestinationCollector = (NavigationTourModeTourDestinationCollector)ListManager.getGenericASLList(1006).getRowItemCacheOnly(n);
            navigationTourModeTourDestinationCollector.setPoiIcon(resourceLocator);
            ListManager.getGenericASLList(1006).updateListItem(n, navigationTourModeTourDestinationCollector);
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetTourView.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("TargetTourView: resetting values after DSI restart");
            }
            this.initLocalVariables();
            this.initDsiNavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("TargetTourView: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.tourMemList = null;
        this.editModeTour = null;
        this.modelTourList = null;
        this.sameNameRouteId = 0L;
        this.changesDiscarded = false;
        this.infoForNextDest = null;
        this.rgCurrentRoute = null;
        this.rgDestinationInfo = null;
        this.detailsPoiCollector = null;
        this.tourListSavedBeforeLeaving = false;
        this.skippingStopover = false;
        this.caseSetEditMode(false);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        OBSERVER = new int[]{-251527104, -285081536, -184418240, -301858752, -217972672, -83754944, -16646080, -50200512, 84082752, 100859968, -66977728, 16973888, 33751104, 0x3030040, 196672, 516493376, 499716160, 533270592, -150863808, 604504128, 432607296, 1980170304, 329072896};
        NAVIGATION_DP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
        ICON_FOR_DETAILS = new Integer(-2);
    }
}

