/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.info;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceInfo;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceAPI;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.guidance.GuidanceInternalAPINotifier;
import de.vw.mib.asl.internal.navigation.guidance.info.Services;
import de.vw.mib.asl.internal.navigation.guidance.info.StateMain;
import de.vw.mib.asl.internal.navigation.guidance.info.StateRubberband;
import de.vw.mib.asl.internal.navigation.guidance.info.StateWaypointMode;
import de.vw.mib.asl.internal.navigation.guidance.info.StateWork;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.guidance.ASLNavigationGuidancePropertyManager;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceGuidanceInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceStatusLineInformationCollector;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavSelectedDestinationCollector;
import java.util.HashMap;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class HsmTargetInfo
extends AbstractResettableAslHsmTarget {
    public static final int WPM_RECORD_SPEED_KMH;
    public static final int GUIDANCE_INFO_SIZE;
    Services services;
    NavigationGuidanceStatusLineInformationCollector statusLineCollector = new NavigationGuidanceStatusLineInformationCollector();
    NavigationGuidanceGuidanceInfoCollector guidanceInfoCollector = new NavigationGuidanceGuidanceInfoCollector();
    NavigationPnavSelectedDestinationCollector pnavSelectedDestinationCollector = new NavigationPnavSelectedDestinationCollector();
    boolean isGuidanceInfoStopOver = false;
    boolean isStatusLineStopOver = false;
    NavRouteListData[] routeListData = new NavRouteListData[]{new NavRouteListData()};
    private boolean isServiceStateListenerAdded = false;
    Route currentRoute;
    RgInfoForNextDestination infoForNextDestination;
    CalculatedRouteListElement[] calculatedRouteListElements;
    ASLGuidanceInfo[] aslGuidanceInfo = new ASLGuidanceInfo[2];
    boolean rgActive;
    ASLNavigationGuidanceAPI aslNavigationGuidanceAPI;
    final INavigationDP navigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    public final StateWork stateWork = new StateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
    public final StateMain stateMain = new StateMain(this, this.hsm, "stateMain", this.stateWork);
    public final StateRubberband stateRubberband = new StateRubberband(this, this.hsm, "stateRubberband", this.stateWork);
    public final StateWaypointMode stateWaypointMode = new StateWaypointMode(this, this.hsm, "stateWaypointMode", this.stateWork);
    private GuidanceInternalAPINotifier guidanceInternalAPINotifier = new GuidanceInternalAPINotifier();
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;

    public HsmTargetInfo(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    public void traceState(HsmState hsmState, String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(".");
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    @Override
    public void trace(String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public void initDSI() {
        if (!this.isServiceStateListenerAdded) {
            this.isServiceStateListenerAdded = true;
            this.services = new Services(this);
        }
    }

    void updateGuidanceInfo() {
        if (this.isGuidanceActive()) {
            ListManager.getGenericASLList(827).updateList(new NavigationGuidanceGuidanceInfoCollector[]{this.guidanceInfoCollector});
        }
    }

    void updateStatusLine() {
        if (this.isGuidanceActive()) {
            ListManager.getGenericASLList(825).updateList(new NavigationGuidanceStatusLineInformationCollector[]{this.statusLineCollector});
            this.updateInternalAPI();
        }
    }

    boolean isGuidanceActive() {
        return this.aslNavigationGuidanceAPI.getGuidanceState() == 1 || this.aslNavigationGuidanceAPI.getGuidanceMode() == 1;
    }

    private void updateInternalAPI() {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(828126464);
        eventGeneric.setObject(0, this.aslGuidanceInfo);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void initGetterGroupDefaults() {
        this.aslGuidanceInfo[0] = null;
        this.aslGuidanceInfo[1] = null;
        this.statusLineCollector.navigation_guidance_status_line_information_dtd = 0;
        this.statusLineCollector.navigation_guidance_status_line_information_etad = 0;
        this.statusLineCollector.navigation_guidance_status_line_information_etah = 0;
        this.statusLineCollector.navigation_guidance_status_line_information_etam = 0;
        this.statusLineCollector.navigation_guidance_status_line_information_rtth = 0;
        this.statusLineCollector.navigation_guidance_status_line_information_rttm = 0;
        this.statusLineCollector.navigation_guidance_status_line_information_rtt_milliseconds = 0;
        this.updateStatusLine();
        this.guidanceInfoCollector.navigation_guidance_guidance_info_address_for_fix_formatter = ASLNavigationGuidancePropertyManager.GUIDANCE_INFO__GUIDANCE_INFO_ADDRESS_FOR_FIX_FORMATTER__DEFAULT_VALUE;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_add_info = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_city = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_city_refinement = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_country_code = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_dtm = 0;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_etad = 0;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_etah = 0;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_etam = 0;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_hn = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_icon_poi = ASLNavigationGuidancePropertyManager.GUIDANCE_INFO__GUIDANCE_INFO_ICON_POI__DEFAULT_VALUE;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_is_ferry = false;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_length_on_highways = 0;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_length_on_toll_roads = 0;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_name = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_rtth = 0;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_rttm = 0;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_rtt_milliseconds = 0;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_street = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_street_refinement = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_type = 0;
        this.guidanceInfoCollector.navigation_guidance_guidance_info_zip = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_infos_crossing = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_poi_category = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_poi_name = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_poi_phone_number = "";
        this.guidanceInfoCollector.navigation_guidance_guidance_info_poi_url = "";
        this.guidanceInfoCollector.navigation_guidance_current_dest_data_lat_degree = 0;
        this.guidanceInfoCollector.navigation_guidance_current_dest_data_lat_minutes = 0;
        this.guidanceInfoCollector.navigation_guidance_current_dest_data_lat_seconds = 0;
        this.guidanceInfoCollector.navigation_guidance_current_dest_data_lon_degree = 0;
        this.guidanceInfoCollector.navigation_guidance_current_dest_data_lon_minutes = 0;
        this.guidanceInfoCollector.navigation_guidance_current_dest_data_lon_seconds = 0;
        this.updateGuidanceInfo();
    }

    void initInternalAPIData() {
        if (this.currentRoute != null && this.currentRoute.routelist != null) {
            if (this.currentRoute.routelist.length > 1 && ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isIntermediateDestInRoute(this.currentRoute)) {
                this.aslGuidanceInfo[0] = new ASLGuidanceInfo();
                this.aslGuidanceInfo[1] = new ASLGuidanceInfo();
            } else if (this.currentRoute.routelist.length > 0) {
                this.aslGuidanceInfo[0] = null;
                this.aslGuidanceInfo[1] = new ASLGuidanceInfo();
            } else {
                this.aslGuidanceInfo[0] = null;
                this.aslGuidanceInfo[1] = null;
            }
        } else {
            this.aslGuidanceInfo[0] = null;
            this.aslGuidanceInfo[1] = null;
        }
    }

    void initInternalAPIDataForWPM(boolean bl) {
        if (bl) {
            this.aslGuidanceInfo[0] = null;
            this.aslGuidanceInfo[1] = new ASLGuidanceInfo();
        } else {
            this.aslGuidanceInfo[0] = null;
            this.aslGuidanceInfo[1] = null;
        }
    }

    void updatePnav() {
        if (this.isGuidanceActive()) {
            ListManager.getGenericASLList(2062553088).updateList(new NavigationPnavSelectedDestinationCollector[]{this.pnavSelectedDestinationCollector});
        }
    }

    public GuidanceInternalAPINotifier getGuidanceAPINotifier() {
        return this.guidanceInternalAPINotifier;
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetInfo.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = HsmTargetInfo.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage).getName(), 0);
        if (bl || bl2) {
            this.trace("HsmTargetInfo: resetting values after DSI restart");
            this.initLocalVariables();
            this.resetHsmToState(this.stateMain);
            if (bl) {
                this.services.initDsiNavigation();
            }
            if (bl2) {
                this.services.initDsiCarTimeUnitsLanguage();
            }
        } else {
            this.trace("HsmTargetInfo: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.statusLineCollector = new NavigationGuidanceStatusLineInformationCollector();
        this.guidanceInfoCollector = new NavigationGuidanceGuidanceInfoCollector();
        this.pnavSelectedDestinationCollector = new NavigationPnavSelectedDestinationCollector();
        this.isGuidanceInfoStopOver = false;
        this.isStatusLineStopOver = false;
        this.routeListData = new NavRouteListData[]{new NavRouteListData()};
        this.isServiceStateListenerAdded = false;
        this.currentRoute = null;
        this.infoForNextDestination = null;
        this.calculatedRouteListElements = null;
        this.aslGuidanceInfo = new ASLGuidanceInfo[2];
        this.rgActive = false;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

