/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.info;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.guidance.info.HsmTargetInfo;
import de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavLikelyDestinationListCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavSelectedDestinationCollector;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class StateMain
extends AbstractHsmState
implements CacheClient {
    private HsmTargetInfo target;

    StateMain(HsmTargetInfo hsmTargetInfo, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetInfo;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.target.initGetterGroupDefaults();
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            case 100105: {
                this.target.traceState(this, "EV_ASL_INT_PREDICTIVE_GUIDANCE_ACTIVE");
                this.updatePnavInitial(eventGeneric.getObject(0));
                break;
            }
            case 1073742374: {
                this.target.traceState(this, "ASL_NAVIGATION_GUIDANCE_TOGGLE_GUIDANCE_INFO_DEST_TYPE");
                this.target.guidanceInfoCollector.navigation_guidance_guidance_info_stop_over = this.target.isGuidanceInfoStopOver = !this.target.isGuidanceInfoStopOver;
                this.updateRouteInfoLocation();
                this.updateRouteCost();
                this.updateTime();
                this.updateDistance();
                this.updateGuidanceInfoAddress(this.target.currentRoute);
                this.target.updateGuidanceInfo();
                this.target.updatePnav();
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(478);
                break;
            }
            case 3497003: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_SETUP_STATUS_LINE_INFORMATION");
                this.target.isStatusLineStopOver = eventGeneric.getBoolean(0);
                this.checkStopOverExistence();
                this.updateRouteCost();
                this.updateTime();
                this.updateDistance();
                this.updateGuidanceInfoAddress(this.target.currentRoute);
                this.target.updateGuidanceInfo();
                this.target.updateStatusLine();
                this.target.updatePnav();
                break;
            }
            case 3497023: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_SETUP_TIME_DISPLAY_SET");
                this.target.updateStatusLine();
                break;
            }
            case 4300052: {
                this.target.traceState(this, "ASL_SYSTEM_VALID_TIME_DATE_AVAILABLE");
                this.updateTime();
                this.target.updateGuidanceInfo();
                this.target.updateStatusLine();
                this.target.updatePnav();
                break;
            }
            case 4300051: {
                this.target.traceState(this, "ASL_SYSTEM_MINUTE_TRIGGER");
                this.updateTime();
                this.target.updateGuidanceInfo();
                this.target.updateStatusLine();
                this.target.updatePnav();
                break;
            }
            case 4300006: {
                this.target.traceState(this, "ASL_SYSTEM_NEW_DATE_TIME");
                this.updateTime();
                this.target.updateGuidanceInfo();
                this.target.updateStatusLine();
                this.target.updatePnav();
                break;
            }
            case 3497006: {
                boolean bl;
                this.target.traceState(this, "EV_NAVI_GUIDANCE_GUIDANCE_STATE");
                boolean bl2 = bl = eventGeneric.getInt(0) == 1;
                if (bl) break;
                this.target.initGetterGroupDefaults();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private int getRttMsToStopOver() {
        int n = 0;
        if (this.target.infoForNextDestination != null && this.target.routeListData != null && this.target.currentRoute != null) {
            n = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttToNextStopOver(this.target.infoForNextDestination, this.target.routeListData, this.target.currentRoute);
        }
        return n;
    }

    private int getRttMsToFinalDest() {
        int n = 0;
        if (this.target.infoForNextDestination != null && this.target.routeListData != null) {
            n = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getLastDestinationRtt(this.target.infoForNextDestination, this.target.routeListData, this.target.currentRoute);
        }
        return n;
    }

    protected void updateTime() {
        this.target.traceState(this, "updateTime()");
        ClockTime clockTime = ASLSystemFactory.getSystemApi().getCurrentTime();
        int n = this.getRttMsToStopOver();
        this.target.trace(new StringBuffer("rttMsToStopOver = ").append(n).toString());
        int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateRttHours(n);
        int n3 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateRttMinutes(n);
        int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateEta(n2, n3, clockTime);
        int n4 = this.getRttMsToFinalDest();
        this.target.trace(new StringBuffer("rttMsToFinalDest = ").append(n4).toString());
        int n5 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateRttHours(n4);
        int n6 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateRttMinutes(n4);
        int[] nArray2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateEta(n5, n6, clockTime);
        if (this.target.aslGuidanceInfo[0] != null) {
            this.target.aslGuidanceInfo[0].setDestinationType(0);
            this.target.aslGuidanceInfo[0].setEtaDays(nArray[2]);
            this.target.aslGuidanceInfo[0].setEtaHours(nArray[0]);
            this.target.aslGuidanceInfo[0].setEtaMinutes(nArray[1]);
            this.target.aslGuidanceInfo[0].setRttHours(n2);
            this.target.aslGuidanceInfo[0].setRttMinutes(n3);
            this.target.aslGuidanceInfo[0].setRttMilliseconds(n);
        }
        if (this.target.aslGuidanceInfo[1] != null) {
            this.target.aslGuidanceInfo[1].setDestinationType(1);
            this.target.aslGuidanceInfo[1].setEtaDays(nArray2[2]);
            this.target.aslGuidanceInfo[1].setEtaHours(nArray2[0]);
            this.target.aslGuidanceInfo[1].setEtaMinutes(nArray2[1]);
            this.target.aslGuidanceInfo[1].setRttHours(n5);
            this.target.aslGuidanceInfo[1].setRttMinutes(n6);
            this.target.aslGuidanceInfo[1].setRttMilliseconds(n4);
        }
        if (this.target.isGuidanceInfoStopOver) {
            this.target.traceState(this, "Guidance info: Stopover values are shown");
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etad = nArray[2];
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etah = nArray[0];
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etam = nArray[1];
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_rtth = n2;
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_rttm = n3;
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_rtt_milliseconds = n;
            if (ServiceManager.logger2.isTraceEnabled(this.target.getSubClassifier())) {
                LogMessage logMessage = ServiceManager.logger2.trace(this.target.getSubClassifier());
                logMessage.append("GUIDANCE INFO STOPOVER: etad=");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etad);
                logMessage.append(", etah=");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etah);
                logMessage.append(", etam=");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etam);
                logMessage.append(", rtth=");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_rtth);
                logMessage.append(", rttm=");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_rttm);
                logMessage.log();
            }
        } else {
            this.target.traceState(this, "Guidance info: Final destination values are shown.");
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etad = nArray2[2];
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etah = nArray2[0];
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etam = nArray2[1];
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_rtth = n5;
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_rttm = n6;
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_rtt_milliseconds = n4;
            if (ServiceManager.logger2.isTraceEnabled(this.target.getSubClassifier())) {
                LogMessage logMessage = ServiceManager.logger2.trace(this.target.getSubClassifier());
                logMessage.append("GUIDANCE INFO FINAL: etad=");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etad);
                logMessage.append(", etah=");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etah);
                logMessage.append(", etam=");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_etam);
                logMessage.append(", rtth=");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_rtth);
                logMessage.append(", rttm=");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_rttm);
                logMessage.log();
            }
        }
        this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_rtt = n4;
        this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_time_delay = this.getDelayToFinalDest();
    }

    private int getDelayToFinalDest() {
        int n = 0;
        if (this.target.infoForNextDestination != null && this.target.routeListData != null) {
            n = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDelayToFinalDest(this.target.infoForNextDestination, this.target.routeListData, this.target.currentRoute);
        }
        return n;
    }

    private void updateGuidanceInfoAddress(Route route) {
        this.target.traceState(this, "updateGuidanceInfoAddress()");
        if (route != null && route.routelist != null) {
            if (route.routelist.length > 0) {
                if (route.routelist[0].routeLocation != null) {
                    ILocationWrapper iLocationWrapper;
                    if (this.target.isGuidanceInfoStopOver) {
                        iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(route.routelist[(int)route.indexOfCurrentDestination].routeLocation);
                        this.target.traceState(this, "Use stop over location.");
                    } else {
                        iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(route.routelist[route.routelist.length - 1].routeLocation);
                        this.target.traceState(this, "Use final destination location.");
                    }
                    this.target.navigationDP.setGuidanceInfoLocation(iLocationWrapper.getLocation());
                    this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_address_data_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(route.routelist[route.routelist.length - 1].routeLocation));
                    this.target.guidanceInfoCollector.navigation_guidance_guidance_info_address_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
                    this.target.guidanceInfoCollector.navigation_guidance_guidance_info_country_code = iLocationWrapper.getCountryCode();
                    this.target.guidanceInfoCollector.navigation_guidance_guidance_info_city = iLocationWrapper.getCity();
                    this.target.guidanceInfoCollector.navigation_guidance_guidance_info_city_refinement = iLocationWrapper.getCityRefinement();
                    this.target.guidanceInfoCollector.navigation_guidance_guidance_info_zip = iLocationWrapper.getPostalCode();
                    this.target.guidanceInfoCollector.navigation_guidance_guidance_info_street = iLocationWrapper.getStreet();
                    this.target.guidanceInfoCollector.navigation_guidance_guidance_info_street_refinement = iLocationWrapper.getStreetRefinement();
                    this.target.guidanceInfoCollector.navigation_guidance_guidance_info_hn = iLocationWrapper.getHousenumber();
                    this.target.guidanceInfoCollector.navigation_guidance_guidance_infos_crossing = iLocationWrapper.getCrossing();
                    this.target.guidanceInfoCollector.navigation_guidance_guidance_info_name = iLocationWrapper.getMmiInternalDataValue(1);
                    this.target.guidanceInfoCollector.navigation_guidance_current_dest_data_lat_degree = iLocationWrapper.getLatitudeDegrees();
                    this.target.guidanceInfoCollector.navigation_guidance_current_dest_data_lat_minutes = iLocationWrapper.getLatitudeMinutes();
                    this.target.guidanceInfoCollector.navigation_guidance_current_dest_data_lat_seconds = iLocationWrapper.getLatitudeSeconds();
                    this.target.guidanceInfoCollector.navigation_guidance_current_dest_data_lon_degree = iLocationWrapper.getLongitudeDegrees();
                    this.target.guidanceInfoCollector.navigation_guidance_current_dest_data_lon_minutes = iLocationWrapper.getLongitudeMinutes();
                    this.target.guidanceInfoCollector.navigation_guidance_current_dest_data_lon_seconds = iLocationWrapper.getLongitudeSeconds();
                    this.target.traceState(this, "Use final destination location.");
                    if (iLocationWrapper.getLocationType() == 3) {
                        this.target.guidanceInfoCollector.navigation_guidance_guidance_info_type = 1;
                        this.target.guidanceInfoCollector.navigation_guidance_guidance_info_poi_category = iLocationWrapper.getPoiCategory();
                        this.target.guidanceInfoCollector.navigation_guidance_guidance_info_poi_name = iLocationWrapper.getPoiName();
                        this.target.guidanceInfoCollector.navigation_guidance_guidance_info_icon_poi = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, this, new Boolean(this.target.isGuidanceInfoStopOver));
                        this.target.guidanceInfoCollector.navigation_guidance_guidance_info_poi_phone_number = iLocationWrapper.getPhonenumber();
                        this.target.guidanceInfoCollector.navigation_guidance_guidance_info_poi_url = "";
                    } else {
                        this.target.guidanceInfoCollector.navigation_guidance_guidance_info_type = 0;
                    }
                } else {
                    this.target.traceState(this, "Route.routelist[0].routeLocation is 'null'.");
                }
            } else {
                this.target.traceState(this, "Route.routelist.lenght >= 0.");
            }
        } else {
            this.target.traceState(this, "Route or route.routelist is 'null'.");
        }
    }

    private int getDtmInMeterStopOver() {
        if (this.target.infoForNextDestination != null && this.target.routeListData != null && this.target.currentRoute != null) {
            return (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getNextStopDistance(this.target.infoForNextDestination, this.target.routeListData, this.target.currentRoute);
        }
        return 0;
    }

    private int getDtmInMeterFinalDest() {
        if (this.target.infoForNextDestination != null && this.target.routeListData != null && this.target.currentRoute != null) {
            return (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getLastDestinationDistance(this.target.infoForNextDestination, this.target.routeListData, this.target.currentRoute);
        }
        return 0;
    }

    protected void updateDistance() {
        this.target.traceState(this, "updateDistance()");
        int n = this.getDtmInMeterStopOver();
        this.target.traceState(this, new StringBuffer().append("Distance to stop over: ").append(n).toString());
        int n2 = this.getDtmInMeterFinalDest();
        this.target.traceState(this, new StringBuffer().append("Distance to final dest: ").append(n2).toString());
        if (this.target.aslGuidanceInfo[0] != null) {
            this.target.aslGuidanceInfo[0].setDistance(n);
        }
        if (this.target.aslGuidanceInfo[1] != null) {
            this.target.aslGuidanceInfo[1].setDistance(n2);
        }
        if (this.target.isGuidanceInfoStopOver) {
            this.target.traceState(this, "Guidance info: Set stop over values.");
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_dtm = n;
        } else {
            this.target.traceState(this, "Guidance info: Set final destination values.");
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_dtm = n2;
        }
        this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_dtd = n2;
    }

    void checkStopOverExistence() {
        this.target.traceState(this, "checkStopOverExistence()");
        if (this.target.currentRoute != null && this.target.currentRoute.routelist != null) {
            if (!ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isIntermediateDestInRoute(this.target.currentRoute)) {
                this.target.traceState(this, "No stop over existent");
                this.target.isGuidanceInfoStopOver = false;
            }
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_stop_over = this.target.isGuidanceInfoStopOver;
        }
    }

    protected void updateRouteCost() {
        this.target.traceState(this, "updateRouteCost()");
        if (this.target.routeListData != null && this.target.routeListData.length > 0 && this.target.currentRoute != null && this.target.currentRoute.routelist != null && (int)this.target.currentRoute.indexOfCurrentDestination < this.target.routeListData.length) {
            int n;
            int n2 = 0;
            int n3 = 0;
            boolean bl = false;
            if (this.target.isGuidanceInfoStopOver) {
                this.target.traceState(this, "stop over values will be set.");
                this.target.traceState(this, "using CurrentRoute.indexOfCurrentDestination to define next destination.");
                n = (int)this.target.currentRoute.indexOfCurrentDestination;
                n2 = (int)this.target.routeListData[n].motorwayLength;
                n3 = (int)this.target.routeListData[n].tollLength;
                bl = this.target.routeListData[n].ferryOnWay;
            } else {
                this.target.traceState(this, "final destination values will be set.");
                for (int i2 = n = (int)this.target.currentRoute.indexOfCurrentDestination; i2 < this.target.routeListData.length; ++i2) {
                    n2 = (int)((long)n2 + this.target.routeListData[i2].motorwayLength);
                    n3 = (int)((long)n3 + this.target.routeListData[i2].tollLength);
                    if (!this.target.routeListData[i2].ferryOnWay) continue;
                    bl = true;
                }
            }
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_length_on_highways = n2;
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_length_on_toll_roads = n3;
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_is_ferry = bl;
            if (ServiceManager.logger2.isTraceEnabled(this.target.getSubClassifier())) {
                LogMessage logMessage = ServiceManager.logger2.trace(this.target.getSubClassifier());
                logMessage.append("updateRouteCost: highways -> ");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_length_on_highways);
                logMessage.append(", toll_roads -> ");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_length_on_toll_roads);
                logMessage.append(", is_ferry -> ");
                logMessage.append(this.target.guidanceInfoCollector.navigation_guidance_guidance_info_is_ferry);
                logMessage.log();
            }
        }
    }

    void updatePnavInitial(Object object) {
        if (object != null && object instanceof NavigationPnavLikelyDestinationListCollector) {
            NavigationPnavLikelyDestinationListCollector navigationPnavLikelyDestinationListCollector = (NavigationPnavLikelyDestinationListCollector)object;
            this.target.traceState(this, "updatePnavInitial()");
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_address_data_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navigationPnavLikelyDestinationListCollector.getDestination()));
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navigationPnavLikelyDestinationListCollector.getDestination());
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_calculation_state = navigationPnavLikelyDestinationListCollector.getCalculationState();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_calculation_progress = navigationPnavLikelyDestinationListCollector.getCalculationProgress();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_city = iLocationWrapper.getCity();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_city_refinement = iLocationWrapper.getCityRefinement();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_cross_street = iLocationWrapper.getCrossing();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_dtd = (int)navigationPnavLikelyDestinationListCollector.getDistance();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_housenumber = iLocationWrapper.getHousenumber();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_latitude = iLocationWrapper.getLatitude();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_likelihood = navigationPnavLikelyDestinationListCollector.getLikelihood();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_longitude = iLocationWrapper.getLongitude();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_route_color = navigationPnavLikelyDestinationListCollector.getRouteColor();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_route_color_icon = navigationPnavLikelyDestinationListCollector.getRouteColorIcon();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_rtt = (int)navigationPnavLikelyDestinationListCollector.getRemainingTravelTime();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_street_refinement = iLocationWrapper.getStreetRefinement();
            this.target.pnavSelectedDestinationCollector.navigation_pnav_selected_destination_time_delay = (int)navigationPnavLikelyDestinationListCollector.getTimeDelay();
            ListManager.getGenericASLList(2062553088).updateList(new NavigationPnavSelectedDestinationCollector[]{this.target.pnavSelectedDestinationCollector});
        }
    }

    void updateRouteInfoLocation() {
        if (this.target.currentRoute != null && this.target.currentRoute.routelist != null) {
            int n;
            int n2 = n = this.target.isGuidanceInfoStopOver ? (int)this.target.currentRoute.indexOfCurrentDestination : this.target.currentRoute.routelist.length - 1;
            if (n >= 0 && n < this.target.currentRoute.routelist.length) {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setRouteInfoLocation(this.target.currentRoute.routelist[n].routeLocation);
            } else if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.error();
                logMessage.append(super.getClass());
                logMessage.append(".");
                logMessage.append(super.getClass());
                logMessage.append(": ");
                logMessage.append("Tried to access a Route.routeList element that does not exist. ID: ");
                logMessage.append(n).log();
            }
        }
    }

    public void dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgInfoForNextDestination()");
        this.target.infoForNextDestination = rgInfoForNextDestination;
        this.updateTime();
        this.updateDistance();
        this.target.updateGuidanceInfo();
        this.target.updateStatusLine();
        this.target.updatePnav();
    }

    public void dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgCurrentRoute()");
        this.target.currentRoute = route;
        this.target.initInternalAPIData();
        this.checkStopOverExistence();
        this.updateGuidanceInfoAddress(this.target.currentRoute);
        this.updateRouteCost();
        this.updateRouteInfoLocation();
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(70)) {
            this.target.traceState(this, "FEAT_IS_HIGH -> update time and distance!");
            this.updateDistance();
            this.updateTime();
            this.target.updateStatusLine();
        }
        this.target.updateGuidanceInfo();
        this.target.updatePnav();
    }

    public void dsiNavigationUpdateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgDestinationInfo()");
        this.target.routeListData = navRouteListDataArray;
        this.updateRouteCost();
        this.target.updateGuidanceInfo();
        this.target.updateStatusLine();
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgActive");
        this.target.rgActive = bl;
        if (!bl) {
            this.target.initGetterGroupDefaults();
        }
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.target.traceState(this, "handleIconCacheUpdate");
        if ((Boolean)object == this.target.isGuidanceInfoStopOver) {
            this.target.guidanceInfoCollector.navigation_guidance_guidance_info_icon_poi = resourceLocator;
            this.target.updateGuidanceInfo();
        } else {
            this.target.traceState(this, "received icon was not requested for the shown data. This can happen while toggling between destination types.");
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }
}

