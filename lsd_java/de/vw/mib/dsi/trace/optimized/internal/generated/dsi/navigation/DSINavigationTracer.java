/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.navigation;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.navigation.AdditionalTurnListIcon;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.BlockElement;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ManeuverElement;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavPhoneData;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRmRouteListData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavRouteListDataIcon;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.NavVersionInfo;
import org.dsi.ifc.navigation.PhonemeData;
import org.dsi.ifc.navigation.PoiExtendedInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.PosTimeInfo;
import org.dsi.ifc.navigation.PriceInfo;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RgTurnToInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RouteSectionInfo;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;
import org.dsi.ifc.navigation.TourImportStatus;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;

public final class DSINavigationTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ADDITIONALTURNLISTICON;
    private static final int ID_BAPMANEUVERDESCRIPTOR;
    private static final int ID_BAPTURNTOINFO;
    private static final int ID_BLOCKELEMENT;
    private static final int ID_BRAND;
    private static final int ID_CALCULATEDROUTELISTELEMENT;
    private static final int ID_CATEGORY;
    private static final int ID_COMBINEDROUTELISTELEMENT;
    private static final int ID_COUNTRYINFO;
    private static final int ID_DIRECTIONTOWAYPOINT;
    private static final int ID_DISTANCETONEXTMANEUVER;
    private static final int ID_LDLISTELEMENT;
    private static final int ID_LICITYHISTORYENTRY;
    private static final int ID_LIEXTDATA;
    private static final int ID_LISPELLERDATA;
    private static final int ID_LISTATEHISTORYENTRY;
    private static final int ID_LISTREETHISTORYENTRY;
    private static final int ID_LIVALUELIST;
    private static final int ID_LIVALUELISTELEMENT;
    private static final int ID_MANEUVERELEMENT;
    private static final int ID_NAVDATABASE;
    private static final int ID_NAVLANEGUIDANCEDATA;
    private static final int ID_NAVLASTDEST;
    private static final int ID_NAVNEXTWAYPOINTINFO;
    private static final int ID_NAVPHONEDATA;
    private static final int ID_NAVPOIINFO;
    private static final int ID_NAVPOIINFOCONFIGURATION;
    private static final int ID_NAVRMROUTELISTARRAYDATA;
    private static final int ID_NAVRMROUTELISTDATA;
    private static final int ID_NAVROUTELISTDATA;
    private static final int ID_NAVROUTELISTDATAICON;
    private static final int ID_NAVTRACELISTDATA;
    private static final int ID_NAVTRACEMEMORYUTILIZATION;
    private static final int ID_NAVVERSIONINFO;
    private static final int ID_PHONEMEDATA;
    private static final int ID_POIEXTENDEDINFO;
    private static final int ID_POSPOSITION;
    private static final int ID_POSTIMEINFO;
    private static final int ID_PRICEINFO;
    private static final int ID_RRLISTELEMENT;
    private static final int ID_RGINFOFORNEXTDESTINATION;
    private static final int ID_RGROUTECOSTCHANGEINFORMATION;
    private static final int ID_RGTURNTOINFO;
    private static final int ID_ROUTE;
    private static final int ID_ROUTEDESTINATION;
    private static final int ID_ROUTEOPTIONS;
    private static final int ID_ROUTEPROPERTIES;
    private static final int ID_ROUTESECTIONINFO;
    private static final int ID_RRDCALCULATIONINFO;
    private static final int ID_THESAURUSHISTORYENTRY;
    private static final int ID_TOURIMPORTSTATUS;
    private static final int ID_TRYBESTMATCHDATA;
    private static final int ID_TRYBESTMATCHRESULTDATA;
    private static final int ID_TRYMATCHLOCATIONDATA;
    private static final int ID_TRYMATCHLOCATIONRESULTDATA;
    private static final int ID_TURNLISTELEMENT;
    private static final int ID_VALUELISTSTATUS;
    private static final int ID_VIAPOINTLISTELEMENT;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$AdditionalTurnListIcon;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$BapManeuverDescriptor;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$BapTurnToInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$BlockElement;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$Brand;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$CalculatedRouteListElement;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$Category;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$CombinedRouteListElement;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$CountryInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DirectionToWaypoint;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DistanceToNextManeuver;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$LDListElement;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$LICityHistoryEntry;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$LIExtData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$LISpellerData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$LIStateHistoryEntry;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$LIStreetHistoryEntry;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$LIValueList;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$LIValueListElement;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$ManeuverElement;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavDataBase;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavLaneGuidanceData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavLastDest;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavNextWayPointInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavPhoneData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavPoiInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavPoiInfoConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavRmRouteListArrayData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavRmRouteListData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavRouteListData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavRouteListDataIcon;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavTraceListData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavTraceMemoryUtilization;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$NavVersionInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$PhonemeData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$PoiExtendedInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$PosPosition;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$PosTimeInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$PriceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$RRListElement;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$RgInfoForNextDestination;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$RgRouteCostChangeInformation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$RgTurnToInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$Route;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$RouteDestination;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$RouteOptions;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$RouteProperties;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$RouteSectionInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$RrdCalculationInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$ThesaurusHistoryEntry;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$TourImportStatus;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$TryBestMatchData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$TryBestMatchResultData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$TryMatchLocationData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$TryMatchLocationResultData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$TurnListElement;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$ValueListStatus;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$ViaPointListElement;

    public DSINavigationTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$AdditionalTurnListIcon == null ? (class$org$dsi$ifc$navigation$AdditionalTurnListIcon = DSINavigationTracer.class$("org.dsi.ifc.navigation.AdditionalTurnListIcon")) : class$org$dsi$ifc$navigation$AdditionalTurnListIcon, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$BapManeuverDescriptor == null ? (class$org$dsi$ifc$navigation$BapManeuverDescriptor = DSINavigationTracer.class$("org.dsi.ifc.navigation.BapManeuverDescriptor")) : class$org$dsi$ifc$navigation$BapManeuverDescriptor, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$BapTurnToInfo == null ? (class$org$dsi$ifc$navigation$BapTurnToInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.BapTurnToInfo")) : class$org$dsi$ifc$navigation$BapTurnToInfo, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$BlockElement == null ? (class$org$dsi$ifc$navigation$BlockElement = DSINavigationTracer.class$("org.dsi.ifc.navigation.BlockElement")) : class$org$dsi$ifc$navigation$BlockElement, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$Brand == null ? (class$org$dsi$ifc$navigation$Brand = DSINavigationTracer.class$("org.dsi.ifc.navigation.Brand")) : class$org$dsi$ifc$navigation$Brand, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$CalculatedRouteListElement == null ? (class$org$dsi$ifc$navigation$CalculatedRouteListElement = DSINavigationTracer.class$("org.dsi.ifc.navigation.CalculatedRouteListElement")) : class$org$dsi$ifc$navigation$CalculatedRouteListElement, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$Category == null ? (class$org$dsi$ifc$navigation$Category = DSINavigationTracer.class$("org.dsi.ifc.navigation.Category")) : class$org$dsi$ifc$navigation$Category, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$CombinedRouteListElement == null ? (class$org$dsi$ifc$navigation$CombinedRouteListElement = DSINavigationTracer.class$("org.dsi.ifc.navigation.CombinedRouteListElement")) : class$org$dsi$ifc$navigation$CombinedRouteListElement, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$CountryInfo == null ? (class$org$dsi$ifc$navigation$CountryInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.CountryInfo")) : class$org$dsi$ifc$navigation$CountryInfo, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$DirectionToWaypoint == null ? (class$org$dsi$ifc$navigation$DirectionToWaypoint = DSINavigationTracer.class$("org.dsi.ifc.navigation.DirectionToWaypoint")) : class$org$dsi$ifc$navigation$DirectionToWaypoint, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$DistanceToNextManeuver == null ? (class$org$dsi$ifc$navigation$DistanceToNextManeuver = DSINavigationTracer.class$("org.dsi.ifc.navigation.DistanceToNextManeuver")) : class$org$dsi$ifc$navigation$DistanceToNextManeuver, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$LDListElement == null ? (class$org$dsi$ifc$navigation$LDListElement = DSINavigationTracer.class$("org.dsi.ifc.navigation.LDListElement")) : class$org$dsi$ifc$navigation$LDListElement, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$LICityHistoryEntry == null ? (class$org$dsi$ifc$navigation$LICityHistoryEntry = DSINavigationTracer.class$("org.dsi.ifc.navigation.LICityHistoryEntry")) : class$org$dsi$ifc$navigation$LICityHistoryEntry, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$LIExtData == null ? (class$org$dsi$ifc$navigation$LIExtData = DSINavigationTracer.class$("org.dsi.ifc.navigation.LIExtData")) : class$org$dsi$ifc$navigation$LIExtData, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$LISpellerData == null ? (class$org$dsi$ifc$navigation$LISpellerData = DSINavigationTracer.class$("org.dsi.ifc.navigation.LISpellerData")) : class$org$dsi$ifc$navigation$LISpellerData, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$LIStateHistoryEntry == null ? (class$org$dsi$ifc$navigation$LIStateHistoryEntry = DSINavigationTracer.class$("org.dsi.ifc.navigation.LIStateHistoryEntry")) : class$org$dsi$ifc$navigation$LIStateHistoryEntry, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$LIStreetHistoryEntry == null ? (class$org$dsi$ifc$navigation$LIStreetHistoryEntry = DSINavigationTracer.class$("org.dsi.ifc.navigation.LIStreetHistoryEntry")) : class$org$dsi$ifc$navigation$LIStreetHistoryEntry, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$LIValueList == null ? (class$org$dsi$ifc$navigation$LIValueList = DSINavigationTracer.class$("org.dsi.ifc.navigation.LIValueList")) : class$org$dsi$ifc$navigation$LIValueList, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$LIValueListElement == null ? (class$org$dsi$ifc$navigation$LIValueListElement = DSINavigationTracer.class$("org.dsi.ifc.navigation.LIValueListElement")) : class$org$dsi$ifc$navigation$LIValueListElement, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$ManeuverElement == null ? (class$org$dsi$ifc$navigation$ManeuverElement = DSINavigationTracer.class$("org.dsi.ifc.navigation.ManeuverElement")) : class$org$dsi$ifc$navigation$ManeuverElement, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavDataBase == null ? (class$org$dsi$ifc$navigation$NavDataBase = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavDataBase")) : class$org$dsi$ifc$navigation$NavDataBase, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavLaneGuidanceData == null ? (class$org$dsi$ifc$navigation$NavLaneGuidanceData = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavLaneGuidanceData")) : class$org$dsi$ifc$navigation$NavLaneGuidanceData, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavLastDest == null ? (class$org$dsi$ifc$navigation$NavLastDest = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavLastDest")) : class$org$dsi$ifc$navigation$NavLastDest, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavNextWayPointInfo == null ? (class$org$dsi$ifc$navigation$NavNextWayPointInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavNextWayPointInfo")) : class$org$dsi$ifc$navigation$NavNextWayPointInfo, 24);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavPhoneData == null ? (class$org$dsi$ifc$navigation$NavPhoneData = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavPhoneData")) : class$org$dsi$ifc$navigation$NavPhoneData, 25);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavPoiInfo == null ? (class$org$dsi$ifc$navigation$NavPoiInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavPoiInfo")) : class$org$dsi$ifc$navigation$NavPoiInfo, 26);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavPoiInfoConfiguration == null ? (class$org$dsi$ifc$navigation$NavPoiInfoConfiguration = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavPoiInfoConfiguration")) : class$org$dsi$ifc$navigation$NavPoiInfoConfiguration, 27);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavRmRouteListArrayData == null ? (class$org$dsi$ifc$navigation$NavRmRouteListArrayData = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavRmRouteListArrayData")) : class$org$dsi$ifc$navigation$NavRmRouteListArrayData, 28);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavRmRouteListData == null ? (class$org$dsi$ifc$navigation$NavRmRouteListData = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavRmRouteListData")) : class$org$dsi$ifc$navigation$NavRmRouteListData, 29);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavRouteListData == null ? (class$org$dsi$ifc$navigation$NavRouteListData = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavRouteListData")) : class$org$dsi$ifc$navigation$NavRouteListData, 30);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavRouteListDataIcon == null ? (class$org$dsi$ifc$navigation$NavRouteListDataIcon = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavRouteListDataIcon")) : class$org$dsi$ifc$navigation$NavRouteListDataIcon, 31);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavTraceListData == null ? (class$org$dsi$ifc$navigation$NavTraceListData = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavTraceListData")) : class$org$dsi$ifc$navigation$NavTraceListData, 32);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavTraceMemoryUtilization == null ? (class$org$dsi$ifc$navigation$NavTraceMemoryUtilization = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavTraceMemoryUtilization")) : class$org$dsi$ifc$navigation$NavTraceMemoryUtilization, 33);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$NavVersionInfo == null ? (class$org$dsi$ifc$navigation$NavVersionInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.NavVersionInfo")) : class$org$dsi$ifc$navigation$NavVersionInfo, 34);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$PhonemeData == null ? (class$org$dsi$ifc$navigation$PhonemeData = DSINavigationTracer.class$("org.dsi.ifc.navigation.PhonemeData")) : class$org$dsi$ifc$navigation$PhonemeData, 35);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$PoiExtendedInfo == null ? (class$org$dsi$ifc$navigation$PoiExtendedInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.PoiExtendedInfo")) : class$org$dsi$ifc$navigation$PoiExtendedInfo, 36);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$PosPosition == null ? (class$org$dsi$ifc$navigation$PosPosition = DSINavigationTracer.class$("org.dsi.ifc.navigation.PosPosition")) : class$org$dsi$ifc$navigation$PosPosition, 37);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$PosTimeInfo == null ? (class$org$dsi$ifc$navigation$PosTimeInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.PosTimeInfo")) : class$org$dsi$ifc$navigation$PosTimeInfo, 38);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$PriceInfo == null ? (class$org$dsi$ifc$navigation$PriceInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.PriceInfo")) : class$org$dsi$ifc$navigation$PriceInfo, 39);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$RRListElement == null ? (class$org$dsi$ifc$navigation$RRListElement = DSINavigationTracer.class$("org.dsi.ifc.navigation.RRListElement")) : class$org$dsi$ifc$navigation$RRListElement, 40);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$RgInfoForNextDestination == null ? (class$org$dsi$ifc$navigation$RgInfoForNextDestination = DSINavigationTracer.class$("org.dsi.ifc.navigation.RgInfoForNextDestination")) : class$org$dsi$ifc$navigation$RgInfoForNextDestination, 41);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$RgRouteCostChangeInformation == null ? (class$org$dsi$ifc$navigation$RgRouteCostChangeInformation = DSINavigationTracer.class$("org.dsi.ifc.navigation.RgRouteCostChangeInformation")) : class$org$dsi$ifc$navigation$RgRouteCostChangeInformation, 42);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$RgTurnToInfo == null ? (class$org$dsi$ifc$navigation$RgTurnToInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.RgTurnToInfo")) : class$org$dsi$ifc$navigation$RgTurnToInfo, 43);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$Route == null ? (class$org$dsi$ifc$navigation$Route = DSINavigationTracer.class$("org.dsi.ifc.navigation.Route")) : class$org$dsi$ifc$navigation$Route, 44);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$RouteDestination == null ? (class$org$dsi$ifc$navigation$RouteDestination = DSINavigationTracer.class$("org.dsi.ifc.navigation.RouteDestination")) : class$org$dsi$ifc$navigation$RouteDestination, 45);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$RouteOptions == null ? (class$org$dsi$ifc$navigation$RouteOptions = DSINavigationTracer.class$("org.dsi.ifc.navigation.RouteOptions")) : class$org$dsi$ifc$navigation$RouteOptions, 46);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$RouteProperties == null ? (class$org$dsi$ifc$navigation$RouteProperties = DSINavigationTracer.class$("org.dsi.ifc.navigation.RouteProperties")) : class$org$dsi$ifc$navigation$RouteProperties, 47);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$RouteSectionInfo == null ? (class$org$dsi$ifc$navigation$RouteSectionInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.RouteSectionInfo")) : class$org$dsi$ifc$navigation$RouteSectionInfo, 48);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$RrdCalculationInfo == null ? (class$org$dsi$ifc$navigation$RrdCalculationInfo = DSINavigationTracer.class$("org.dsi.ifc.navigation.RrdCalculationInfo")) : class$org$dsi$ifc$navigation$RrdCalculationInfo, 49);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$ThesaurusHistoryEntry == null ? (class$org$dsi$ifc$navigation$ThesaurusHistoryEntry = DSINavigationTracer.class$("org.dsi.ifc.navigation.ThesaurusHistoryEntry")) : class$org$dsi$ifc$navigation$ThesaurusHistoryEntry, 50);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$TourImportStatus == null ? (class$org$dsi$ifc$navigation$TourImportStatus = DSINavigationTracer.class$("org.dsi.ifc.navigation.TourImportStatus")) : class$org$dsi$ifc$navigation$TourImportStatus, 51);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$TryBestMatchData == null ? (class$org$dsi$ifc$navigation$TryBestMatchData = DSINavigationTracer.class$("org.dsi.ifc.navigation.TryBestMatchData")) : class$org$dsi$ifc$navigation$TryBestMatchData, 52);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$TryBestMatchResultData == null ? (class$org$dsi$ifc$navigation$TryBestMatchResultData = DSINavigationTracer.class$("org.dsi.ifc.navigation.TryBestMatchResultData")) : class$org$dsi$ifc$navigation$TryBestMatchResultData, 53);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$TryMatchLocationData == null ? (class$org$dsi$ifc$navigation$TryMatchLocationData = DSINavigationTracer.class$("org.dsi.ifc.navigation.TryMatchLocationData")) : class$org$dsi$ifc$navigation$TryMatchLocationData, 54);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$TryMatchLocationResultData == null ? (class$org$dsi$ifc$navigation$TryMatchLocationResultData = DSINavigationTracer.class$("org.dsi.ifc.navigation.TryMatchLocationResultData")) : class$org$dsi$ifc$navigation$TryMatchLocationResultData, 55);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$TurnListElement == null ? (class$org$dsi$ifc$navigation$TurnListElement = DSINavigationTracer.class$("org.dsi.ifc.navigation.TurnListElement")) : class$org$dsi$ifc$navigation$TurnListElement, 56);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$ValueListStatus == null ? (class$org$dsi$ifc$navigation$ValueListStatus = DSINavigationTracer.class$("org.dsi.ifc.navigation.ValueListStatus")) : class$org$dsi$ifc$navigation$ValueListStatus, 57);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navigation$ViaPointListElement == null ? (class$org$dsi$ifc$navigation$ViaPointListElement = DSINavigationTracer.class$("org.dsi.ifc.navigation.ViaPointListElement")) : class$org$dsi$ifc$navigation$ViaPointListElement, 58);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAdditionalTurnListIcon(printWriter, (AdditionalTurnListIcon)object);
                break;
            }
            case 2: {
                this.traceBapManeuverDescriptor(printWriter, (BapManeuverDescriptor)object);
                break;
            }
            case 3: {
                this.traceBapTurnToInfo(printWriter, (BapTurnToInfo)object);
                break;
            }
            case 4: {
                this.traceBlockElement(printWriter, (BlockElement)object);
                break;
            }
            case 5: {
                this.traceBrand(printWriter, (Brand)object);
                break;
            }
            case 6: {
                this.traceCalculatedRouteListElement(printWriter, (CalculatedRouteListElement)object);
                break;
            }
            case 7: {
                this.traceCategory(printWriter, (Category)object);
                break;
            }
            case 8: {
                this.traceCombinedRouteListElement(printWriter, (CombinedRouteListElement)object);
                break;
            }
            case 9: {
                this.traceCountryInfo(printWriter, (CountryInfo)object);
                break;
            }
            case 10: {
                this.traceDirectionToWaypoint(printWriter, (DirectionToWaypoint)object);
                break;
            }
            case 11: {
                this.traceDistanceToNextManeuver(printWriter, (DistanceToNextManeuver)object);
                break;
            }
            case 12: {
                this.traceLDListElement(printWriter, (LDListElement)object);
                break;
            }
            case 13: {
                this.traceLICityHistoryEntry(printWriter, (LICityHistoryEntry)object);
                break;
            }
            case 14: {
                this.traceLIExtData(printWriter, (LIExtData)object);
                break;
            }
            case 15: {
                this.traceLISpellerData(printWriter, (LISpellerData)object);
                break;
            }
            case 16: {
                this.traceLIStateHistoryEntry(printWriter, (LIStateHistoryEntry)object);
                break;
            }
            case 17: {
                this.traceLIStreetHistoryEntry(printWriter, (LIStreetHistoryEntry)object);
                break;
            }
            case 18: {
                this.traceLIValueList(printWriter, (LIValueList)object);
                break;
            }
            case 19: {
                this.traceLIValueListElement(printWriter, (LIValueListElement)object);
                break;
            }
            case 20: {
                this.traceManeuverElement(printWriter, (ManeuverElement)object);
                break;
            }
            case 21: {
                this.traceNavDataBase(printWriter, (NavDataBase)object);
                break;
            }
            case 22: {
                this.traceNavLaneGuidanceData(printWriter, (NavLaneGuidanceData)object);
                break;
            }
            case 23: {
                this.traceNavLastDest(printWriter, (NavLastDest)object);
                break;
            }
            case 24: {
                this.traceNavNextWayPointInfo(printWriter, (NavNextWayPointInfo)object);
                break;
            }
            case 25: {
                this.traceNavPhoneData(printWriter, (NavPhoneData)object);
                break;
            }
            case 26: {
                this.traceNavPoiInfo(printWriter, (NavPoiInfo)object);
                break;
            }
            case 27: {
                this.traceNavPoiInfoConfiguration(printWriter, (NavPoiInfoConfiguration)object);
                break;
            }
            case 28: {
                this.traceNavRmRouteListArrayData(printWriter, (NavRmRouteListArrayData)object);
                break;
            }
            case 29: {
                this.traceNavRmRouteListData(printWriter, (NavRmRouteListData)object);
                break;
            }
            case 30: {
                this.traceNavRouteListData(printWriter, (NavRouteListData)object);
                break;
            }
            case 31: {
                this.traceNavRouteListDataIcon(printWriter, (NavRouteListDataIcon)object);
                break;
            }
            case 32: {
                this.traceNavTraceListData(printWriter, (NavTraceListData)object);
                break;
            }
            case 33: {
                this.traceNavTraceMemoryUtilization(printWriter, (NavTraceMemoryUtilization)object);
                break;
            }
            case 34: {
                this.traceNavVersionInfo(printWriter, (NavVersionInfo)object);
                break;
            }
            case 35: {
                this.tracePhonemeData(printWriter, (PhonemeData)object);
                break;
            }
            case 36: {
                this.tracePoiExtendedInfo(printWriter, (PoiExtendedInfo)object);
                break;
            }
            case 37: {
                this.tracePosPosition(printWriter, (PosPosition)object);
                break;
            }
            case 38: {
                this.tracePosTimeInfo(printWriter, (PosTimeInfo)object);
                break;
            }
            case 39: {
                this.tracePriceInfo(printWriter, (PriceInfo)object);
                break;
            }
            case 40: {
                this.traceRRListElement(printWriter, (RRListElement)object);
                break;
            }
            case 41: {
                this.traceRgInfoForNextDestination(printWriter, (RgInfoForNextDestination)object);
                break;
            }
            case 42: {
                this.traceRgRouteCostChangeInformation(printWriter, (RgRouteCostChangeInformation)object);
                break;
            }
            case 43: {
                this.traceRgTurnToInfo(printWriter, (RgTurnToInfo)object);
                break;
            }
            case 44: {
                this.traceRoute(printWriter, (Route)object);
                break;
            }
            case 45: {
                this.traceRouteDestination(printWriter, (RouteDestination)object);
                break;
            }
            case 46: {
                this.traceRouteOptions(printWriter, (RouteOptions)object);
                break;
            }
            case 47: {
                this.traceRouteProperties(printWriter, (RouteProperties)object);
                break;
            }
            case 48: {
                this.traceRouteSectionInfo(printWriter, (RouteSectionInfo)object);
                break;
            }
            case 49: {
                this.traceRrdCalculationInfo(printWriter, (RrdCalculationInfo)object);
                break;
            }
            case 50: {
                this.traceThesaurusHistoryEntry(printWriter, (ThesaurusHistoryEntry)object);
                break;
            }
            case 51: {
                this.traceTourImportStatus(printWriter, (TourImportStatus)object);
                break;
            }
            case 52: {
                this.traceTryBestMatchData(printWriter, (TryBestMatchData)object);
                break;
            }
            case 53: {
                this.traceTryBestMatchResultData(printWriter, (TryBestMatchResultData)object);
                break;
            }
            case 54: {
                this.traceTryMatchLocationData(printWriter, (TryMatchLocationData)object);
                break;
            }
            case 55: {
                this.traceTryMatchLocationResultData(printWriter, (TryMatchLocationResultData)object);
                break;
            }
            case 56: {
                this.traceTurnListElement(printWriter, (TurnListElement)object);
                break;
            }
            case 57: {
                this.traceValueListStatus(printWriter, (ValueListStatus)object);
                break;
            }
            case 58: {
                this.traceViaPointListElement(printWriter, (ViaPointListElement)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAdditionalTurnListIcon(PrintWriter printWriter, AdditionalTurnListIcon additionalTurnListIcon) {
        if (additionalTurnListIcon == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(additionalTurnListIcon.type);
        printWriter.print(additionalTurnListIcon.iconId);
        printWriter.print(additionalTurnListIcon.variant);
    }

    private void traceBapManeuverDescriptor(PrintWriter printWriter, BapManeuverDescriptor bapManeuverDescriptor) {
        if (bapManeuverDescriptor == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bapManeuverDescriptor.mainElement);
        printWriter.print(bapManeuverDescriptor.direction);
        printWriter.print(bapManeuverDescriptor.zLevelGuidance);
        if (bapManeuverDescriptor.sideStreets == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = bapManeuverDescriptor.sideStreets.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(bapManeuverDescriptor.sideStreets[i2]);
            }
        }
    }

    private void traceBapTurnToInfo(PrintWriter printWriter, BapTurnToInfo bapTurnToInfo) {
        if (bapTurnToInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bapTurnToInfo.turnToInfo);
        printWriter.print(bapTurnToInfo.signPost);
    }

    private void traceBlockElement(PrintWriter printWriter, BlockElement blockElement) {
        if (blockElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(blockElement.uid);
        printWriter.print(blockElement.type);
        printWriter.print(blockElement.distanceToDestination);
        printWriter.print(blockElement.onRoute);
        printWriter.print(blockElement.persistent);
        printWriter.print(blockElement.description);
    }

    private void traceBrand(PrintWriter printWriter, Brand brand) {
        if (brand == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(brand.brandUid);
        printWriter.print(brand.iconIndex);
        printWriter.print(brand.subIconIndex);
        printWriter.print(brand.visible);
        printWriter.print(brand.preferred);
        printWriter.print(brand.description);
    }

    private void traceCalculatedRouteListElement(PrintWriter printWriter, CalculatedRouteListElement calculatedRouteListElement) {
        int n;
        int n2;
        if (calculatedRouteListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(calculatedRouteListElement.distance);
        printWriter.print(calculatedRouteListElement.eta);
        printWriter.print(calculatedRouteListElement.etaWithSpeedAndFlow);
        printWriter.print(calculatedRouteListElement.ecologicalFactor);
        printWriter.print(calculatedRouteListElement.motorwayLength);
        printWriter.print(calculatedRouteListElement.tollLength);
        printWriter.print(calculatedRouteListElement.tollCostAmount);
        printWriter.print(calculatedRouteListElement.tollCostCurrency);
        printWriter.print(calculatedRouteListElement.hasTunnel);
        printWriter.print(calculatedRouteListElement.hasFerry);
        printWriter.print(calculatedRouteListElement.isTimeRestricted);
        printWriter.print(calculatedRouteListElement.hasCarTrain);
        printWriter.print(calculatedRouteListElement.isSeasonalRestricted);
        printWriter.print(calculatedRouteListElement.needsVignette);
        this.trace(printWriter, calculatedRouteListElement.segmentIDList);
        printWriter.print(calculatedRouteListElement.calculationState);
        printWriter.print(calculatedRouteListElement.calculationPercentage);
        printWriter.print(calculatedRouteListElement.numberOfTmcMessages);
        printWriter.print(calculatedRouteListElement.etaWithSpeedAndFlowStatus);
        if (calculatedRouteListElement.additionalRouteDataKeys == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = calculatedRouteListElement.additionalRouteDataKeys.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(calculatedRouteListElement.additionalRouteDataKeys[n]);
            }
        }
        if (calculatedRouteListElement.additionalRouteDataValues == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = calculatedRouteListElement.additionalRouteDataValues.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(calculatedRouteListElement.additionalRouteDataValues[n]);
            }
        }
        printWriter.print(calculatedRouteListElement.hasHovLane);
    }

    private void traceCategory(PrintWriter printWriter, Category category) {
        if (category == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(category.categoryUid);
        printWriter.print(category.iconIndex);
        printWriter.print(category.subIconIndex);
        printWriter.print(category.parent);
        printWriter.print(category.visible);
        printWriter.print(category.audible);
        printWriter.print(category.personal);
        printWriter.print(category.monitored);
        printWriter.print(category.description);
        printWriter.print(category.additionalFlags);
        printWriter.print(category.parentId);
    }

    private void traceCombinedRouteListElement(PrintWriter printWriter, CombinedRouteListElement combinedRouteListElement) {
        int n;
        int n2;
        if (combinedRouteListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(combinedRouteListElement.uid);
        printWriter.print(combinedRouteListElement.parent);
        if (combinedRouteListElement.type == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = combinedRouteListElement.type.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(combinedRouteListElement.type[n]);
            }
        }
        printWriter.print(combinedRouteListElement.startDistance);
        printWriter.print(combinedRouteListElement.endDistance);
        printWriter.print(combinedRouteListElement.startTime);
        printWriter.print(combinedRouteListElement.endTime);
        printWriter.print(combinedRouteListElement.description);
        printWriter.print(combinedRouteListElement.roadNumber);
        printWriter.print(combinedRouteListElement.streetIconText);
        printWriter.print(combinedRouteListElement.exitNumber);
        printWriter.print(combinedRouteListElement.signPostInfo);
        if (combinedRouteListElement.icons == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = combinedRouteListElement.icons.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, combinedRouteListElement.icons[n]);
            }
        }
        printWriter.print(combinedRouteListElement.startDistanceTraffic);
        printWriter.print(combinedRouteListElement.endDistanceTraffic);
        if (combinedRouteListElement.maneuver == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = combinedRouteListElement.maneuver.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, combinedRouteListElement.maneuver[n]);
            }
        }
        printWriter.print(combinedRouteListElement.blocked);
        printWriter.print(combinedRouteListElement.destinationIndex);
        printWriter.print(combinedRouteListElement.hasChildren);
        printWriter.print(combinedRouteListElement.countryAbbreviation);
    }

    private void traceCountryInfo(PrintWriter printWriter, CountryInfo countryInfo) {
        int n;
        int n2;
        if (countryInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(countryInfo.name);
        printWriter.print(countryInfo.countryAbbreviation);
        printWriter.print(countryInfo.iconIndex);
        printWriter.print(countryInfo.rightHandTraffic);
        if (countryInfo.additionalInfo == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = countryInfo.additionalInfo.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(countryInfo.additionalInfo[n]);
            }
        }
        if (countryInfo.additionalIcons == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = countryInfo.additionalIcons.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(countryInfo.additionalIcons[n]);
            }
        }
    }

    private void traceDirectionToWaypoint(PrintWriter printWriter, DirectionToWaypoint directionToWaypoint) {
        if (directionToWaypoint == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(directionToWaypoint.directionRelative);
        printWriter.print(directionToWaypoint.directionAbsolute);
    }

    private void traceDistanceToNextManeuver(PrintWriter printWriter, DistanceToNextManeuver distanceToNextManeuver) {
        if (distanceToNextManeuver == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(distanceToNextManeuver.showDistance);
        printWriter.print(distanceToNextManeuver.distance);
        printWriter.print(distanceToNextManeuver.showBargraph);
        printWriter.print(distanceToNextManeuver.bargraph);
    }

    private void traceLDListElement(PrintWriter printWriter, LDListElement lDListElement) {
        if (lDListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(lDListElement.id);
        printWriter.print(lDListElement.flag);
        printWriter.print(lDListElement.title);
        printWriter.print(lDListElement.codedTitle);
    }

    private void traceLICityHistoryEntry(PrintWriter printWriter, LICityHistoryEntry lICityHistoryEntry) {
        if (lICityHistoryEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(lICityHistoryEntry.name);
        printWriter.print(lICityHistoryEntry.streetsInCity);
        printWriter.print(lICityHistoryEntry.id);
        if (lICityHistoryEntry.extendedData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = lICityHistoryEntry.extendedData.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, lICityHistoryEntry.extendedData[i2]);
            }
        }
    }

    private void traceLIExtData(PrintWriter printWriter, LIExtData lIExtData) {
        if (lIExtData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(lIExtData.type);
        printWriter.print(lIExtData.data);
    }

    private void traceLISpellerData(PrintWriter printWriter, LISpellerData lISpellerData) {
        if (lISpellerData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (lISpellerData.spellerStateData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = lISpellerData.spellerStateData.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(lISpellerData.spellerStateData[i2]);
            }
        }
    }

    private void traceLIStateHistoryEntry(PrintWriter printWriter, LIStateHistoryEntry lIStateHistoryEntry) {
        if (lIStateHistoryEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(lIStateHistoryEntry.name);
        printWriter.print(lIStateHistoryEntry.citiesInState);
        printWriter.print(lIStateHistoryEntry.id);
        if (lIStateHistoryEntry.extendedData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = lIStateHistoryEntry.extendedData.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, lIStateHistoryEntry.extendedData[i2]);
            }
        }
    }

    private void traceLIStreetHistoryEntry(PrintWriter printWriter, LIStreetHistoryEntry lIStreetHistoryEntry) {
        if (lIStreetHistoryEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(lIStreetHistoryEntry.name);
        printWriter.print(lIStreetHistoryEntry.id);
        if (lIStreetHistoryEntry.extendedData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = lIStreetHistoryEntry.extendedData.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, lIStreetHistoryEntry.extendedData[i2]);
            }
        }
    }

    private void traceLIValueList(PrintWriter printWriter, LIValueList lIValueList) {
        if (lIValueList == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (lIValueList.list == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = lIValueList.list.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, lIValueList.list[i2]);
            }
        }
        printWriter.print(lIValueList.hasNextPage);
        printWriter.print(lIValueList.hasPrevPage);
    }

    private void traceLIValueListElement(PrintWriter printWriter, LIValueListElement lIValueListElement) {
        int n;
        int n2;
        if (lIValueListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(lIValueListElement.data);
        printWriter.print(lIValueListElement.validDestination);
        printWriter.print(lIValueListElement.toRefine);
        printWriter.print(lIValueListElement.criteriaNumber);
        printWriter.print(lIValueListElement.poiUniqueId);
        printWriter.print(lIValueListElement.iconIndex);
        printWriter.print(lIValueListElement.subIconIndex);
        printWriter.print(lIValueListElement.longitude);
        printWriter.print(lIValueListElement.latitude);
        printWriter.print(lIValueListElement.countryAbbreviation);
        printWriter.print(lIValueListElement.hasListIndex);
        printWriter.print(lIValueListElement.listIndex);
        printWriter.print(lIValueListElement.additionalFlags);
        printWriter.print(lIValueListElement.additionalData);
        printWriter.print(lIValueListElement.houseNumberInZipCode);
        printWriter.print(lIValueListElement.bestGuess);
        if (lIValueListElement.extendedData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = lIValueListElement.extendedData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, lIValueListElement.extendedData[n]);
            }
        }
        if (lIValueListElement.iconDecoratorInformation == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = lIValueListElement.iconDecoratorInformation.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(lIValueListElement.iconDecoratorInformation[n]);
            }
        }
    }

    private void traceManeuverElement(PrintWriter printWriter, ManeuverElement maneuverElement) {
        if (maneuverElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(maneuverElement.element);
        printWriter.print(maneuverElement.direction);
        printWriter.print(maneuverElement.attribute);
    }

    private void traceNavDataBase(PrintWriter printWriter, NavDataBase navDataBase) {
        if (navDataBase == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navDataBase.uid);
        printWriter.print(navDataBase.currentlyInUse);
        printWriter.print(navDataBase.name);
        printWriter.print(navDataBase.language);
        printWriter.print(navDataBase.path);
    }

    private void traceNavLaneGuidanceData(PrintWriter printWriter, NavLaneGuidanceData navLaneGuidanceData) {
        if (navLaneGuidanceData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navLaneGuidanceData.pos);
        printWriter.print(navLaneGuidanceData.laneDirection);
        if (navLaneGuidanceData.laneSideStreets == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = navLaneGuidanceData.laneSideStreets.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(navLaneGuidanceData.laneSideStreets[i2]);
            }
        }
        printWriter.print(navLaneGuidanceData.laneType);
        printWriter.print(navLaneGuidanceData.laneMarkingLeft);
        printWriter.print(navLaneGuidanceData.laneMarkingRight);
        printWriter.print(navLaneGuidanceData.laneDescription);
        printWriter.print(navLaneGuidanceData.guidanceInfo);
    }

    private void traceNavLastDest(PrintWriter printWriter, NavLastDest navLastDest) {
        if (navLastDest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navLastDest.title);
        this.trace(printWriter, navLastDest.location);
        printWriter.print(navLastDest.codedTitle);
    }

    private void traceNavNextWayPointInfo(PrintWriter printWriter, NavNextWayPointInfo navNextWayPointInfo) {
        if (navNextWayPointInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navNextWayPointInfo.longitude);
        printWriter.print(navNextWayPointInfo.latitude);
        printWriter.print(navNextWayPointInfo.distanceToDestination);
        printWriter.print(navNextWayPointInfo.timeToDestination);
        printWriter.print(navNextWayPointInfo.remainingWaypoints);
    }

    private void traceNavPhoneData(PrintWriter printWriter, NavPhoneData navPhoneData) {
        if (navPhoneData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navPhoneData.number);
        printWriter.print(navPhoneData.numberType);
    }

    private void traceNavPoiInfo(PrintWriter printWriter, NavPoiInfo navPoiInfo) {
        int n;
        int n2;
        if (navPoiInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navPoiInfo.distance);
        printWriter.print(navPoiInfo.remainingTime);
        if (navPoiInfo.poiLocations == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = navPoiInfo.poiLocations.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, navPoiInfo.poiLocations[n]);
            }
        }
        printWriter.print(navPoiInfo.exitNumber);
        printWriter.print(navPoiInfo.signpostInfo);
        printWriter.print(navPoiInfo.exitIconId);
        printWriter.print(navPoiInfo.sideOfStreet);
        printWriter.print(navPoiInfo.destinationIndex);
        printWriter.print(navPoiInfo.type);
        this.trace(printWriter, navPoiInfo.exitPoiLocation);
        if (navPoiInfo.poiIcons == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = navPoiInfo.poiIcons.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, navPoiInfo.poiIcons[n]);
            }
        }
    }

    private void traceNavPoiInfoConfiguration(PrintWriter printWriter, NavPoiInfoConfiguration navPoiInfoConfiguration) {
        if (navPoiInfoConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (navPoiInfoConfiguration.excludedTypes == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = navPoiInfoConfiguration.excludedTypes.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(navPoiInfoConfiguration.excludedTypes[i2]);
            }
        }
    }

    private void traceNavRmRouteListArrayData(PrintWriter printWriter, NavRmRouteListArrayData navRmRouteListArrayData) {
        if (navRmRouteListArrayData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navRmRouteListArrayData.rmId);
        if (navRmRouteListArrayData.routeList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = navRmRouteListArrayData.routeList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, navRmRouteListArrayData.routeList[i2]);
            }
        }
        printWriter.print(navRmRouteListArrayData.totalSlots);
    }

    private void traceNavRmRouteListData(PrintWriter printWriter, NavRmRouteListData navRmRouteListData) {
        if (navRmRouteListData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navRmRouteListData.routeId);
        printWriter.print(navRmRouteListData.name);
    }

    private void traceNavRouteListData(PrintWriter printWriter, NavRouteListData navRouteListData) {
        if (navRouteListData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (navRouteListData.icons == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = navRouteListData.icons.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, navRouteListData.icons[i2]);
            }
        }
        printWriter.print(navRouteListData.startDistance);
        printWriter.print(navRouteListData.endDistance);
        printWriter.print(navRouteListData.remainingTravelTime);
        printWriter.print(navRouteListData.timeLagToNextDest);
        printWriter.print(navRouteListData.streetname);
        printWriter.print(navRouteListData.inProgressData);
        printWriter.print(navRouteListData.motorwayLength);
        printWriter.print(navRouteListData.tollLength);
        printWriter.print(navRouteListData.tollCostAmount);
        printWriter.print(navRouteListData.tollCostCurrency);
        printWriter.print(navRouteListData.tunnelOnWay);
        printWriter.print(navRouteListData.ferryOnWay);
        printWriter.print(navRouteListData.timeRestricted);
        printWriter.print(navRouteListData.carTrainOnWay);
        printWriter.print(navRouteListData.seasonalRestricted);
        printWriter.print(navRouteListData.vignetteNeededOnWay);
        printWriter.print(navRouteListData.remainingTravelTimeStatus);
    }

    private void traceNavRouteListDataIcon(PrintWriter printWriter, NavRouteListDataIcon navRouteListDataIcon) {
        if (navRouteListDataIcon == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navRouteListDataIcon.type);
        printWriter.print(navRouteListDataIcon.criteria1);
        printWriter.print(navRouteListDataIcon.criteria2);
        if (navRouteListDataIcon.iconDecoratorInformation == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = navRouteListDataIcon.iconDecoratorInformation.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(navRouteListDataIcon.iconDecoratorInformation[i2]);
            }
        }
    }

    private void traceNavTraceListData(PrintWriter printWriter, NavTraceListData navTraceListData) {
        if (navTraceListData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navTraceListData.name);
        this.trace(printWriter, navTraceListData.traceID);
        printWriter.print(navTraceListData.startLongitude);
        printWriter.print(navTraceListData.startLatitude);
        printWriter.print(navTraceListData.endLongitude);
        printWriter.print(navTraceListData.endLatitude);
        printWriter.print(navTraceListData.length);
        printWriter.print(navTraceListData.numberOfTrackPoints);
    }

    private void traceNavTraceMemoryUtilization(PrintWriter printWriter, NavTraceMemoryUtilization navTraceMemoryUtilization) {
        if (navTraceMemoryUtilization == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navTraceMemoryUtilization.firstTrackpoint);
        printWriter.print(navTraceMemoryUtilization.numberOfTrackpoints);
        printWriter.print(navTraceMemoryUtilization.utilization);
        printWriter.print(navTraceMemoryUtilization.recordingDistance);
        printWriter.print(navTraceMemoryUtilization.remainingDistance);
        printWriter.print(navTraceMemoryUtilization.remainingTime);
        printWriter.print(navTraceMemoryUtilization.totalNumberOfTrackPoints);
        printWriter.print(navTraceMemoryUtilization.maximumNumberOfTrackPoints);
    }

    private void traceNavVersionInfo(PrintWriter printWriter, NavVersionInfo navVersionInfo) {
        if (navVersionInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (navVersionInfo.navVersion == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = navVersionInfo.navVersion.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(navVersionInfo.navVersion[i2]);
            }
        }
    }

    private void tracePhonemeData(PrintWriter printWriter, PhonemeData phonemeData) {
        if (phonemeData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(phonemeData.alphabet);
        printWriter.print(phonemeData.phoneme);
    }

    private void tracePoiExtendedInfo(PrintWriter printWriter, PoiExtendedInfo poiExtendedInfo) {
        if (poiExtendedInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(poiExtendedInfo.longitude);
        printWriter.print(poiExtendedInfo.latitude);
        this.trace(printWriter, poiExtendedInfo.timestamp);
        printWriter.print(poiExtendedInfo.description);
        if (poiExtendedInfo.pictureReferences == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = poiExtendedInfo.pictureReferences.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, poiExtendedInfo.pictureReferences[i2]);
            }
        }
        printWriter.print(poiExtendedInfo.unstructuredAddress);
        printWriter.print(poiExtendedInfo.emailAddress);
    }

    private void tracePosPosition(PrintWriter printWriter, PosPosition posPosition) {
        if (posPosition == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(posPosition.state);
        printWriter.print(posPosition.vdop);
        printWriter.print(posPosition.hdop);
        printWriter.print(posPosition.pdop);
        printWriter.print(posPosition.longitude);
        printWriter.print(posPosition.latitude);
        printWriter.print(posPosition.directionSymbolic);
        printWriter.print(posPosition.directionAngle);
        printWriter.print(posPosition.speed);
        printWriter.print(posPosition.reliability);
        printWriter.print(posPosition.height);
        printWriter.print(posPosition.visibleSatellites);
        printWriter.print(posPosition.usedSatellites);
        printWriter.print(posPosition.roadClass);
    }

    private void tracePosTimeInfo(PrintWriter printWriter, PosTimeInfo posTimeInfo) {
        if (posTimeInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(posTimeInfo.timeZoneOffset);
        printWriter.print(posTimeInfo.summerTimeValidity);
        printWriter.print(posTimeInfo.summerTimeMonthFrom);
        printWriter.print(posTimeInfo.summerTimeDayFrom);
        printWriter.print(posTimeInfo.summerTimeHourFrom);
        printWriter.print(posTimeInfo.summerTimeMonthTo);
        printWriter.print(posTimeInfo.summerTimeDayTo);
        printWriter.print(posTimeInfo.summerTimeHourTo);
        printWriter.print(posTimeInfo.summerTimeYearFrom);
        printWriter.print(posTimeInfo.summerTimeYearTo);
    }

    private void tracePriceInfo(PrintWriter printWriter, PriceInfo priceInfo) {
        if (priceInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(priceInfo.currency);
        printWriter.print(priceInfo.amount);
    }

    private void traceRRListElement(PrintWriter printWriter, RRListElement rRListElement) {
        if (rRListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rRListElement.id);
        printWriter.print(rRListElement.flag);
        printWriter.print(rRListElement.title);
    }

    private void traceRgInfoForNextDestination(PrintWriter printWriter, RgInfoForNextDestination rgInfoForNextDestination) {
        if (rgInfoForNextDestination == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rgInfoForNextDestination.airDistanceToNextDest);
        printWriter.print(rgInfoForNextDestination.distanceToNextDest);
        printWriter.print(rgInfoForNextDestination.timeToNextDest);
        printWriter.print(rgInfoForNextDestination.timeLagToNextDest);
        printWriter.print(rgInfoForNextDestination.directionToNextDest);
        printWriter.print(rgInfoForNextDestination.timeToNextDestStatus);
        printWriter.print(rgInfoForNextDestination.destinationIndex);
    }

    private void traceRgRouteCostChangeInformation(PrintWriter printWriter, RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        int n;
        int n2;
        if (rgRouteCostChangeInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, rgRouteCostChangeInformation.oldRoute);
        this.trace(printWriter, rgRouteCostChangeInformation.newRoute);
        printWriter.print(rgRouteCostChangeInformation.newRouteRecommended);
        printWriter.print(rgRouteCostChangeInformation.tmcMsgId);
        if (rgRouteCostChangeInformation.tmcMsgIds == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = rgRouteCostChangeInformation.tmcMsgIds.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(rgRouteCostChangeInformation.tmcMsgIds[n]);
            }
        }
        this.trace(printWriter, rgRouteCostChangeInformation.boundingRectangle);
        if (rgRouteCostChangeInformation.detours == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = rgRouteCostChangeInformation.detours.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, rgRouteCostChangeInformation.detours[n]);
            }
        }
    }

    private void traceRgTurnToInfo(PrintWriter printWriter, RgTurnToInfo rgTurnToInfo) {
        if (rgTurnToInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rgTurnToInfo.turnToStreet);
        printWriter.print(rgTurnToInfo.streetIconText);
        printWriter.print(rgTurnToInfo.streetIconId);
        printWriter.print(rgTurnToInfo.inProgressData);
        printWriter.print(rgTurnToInfo.signPost);
    }

    private void traceRoute(PrintWriter printWriter, Route route) {
        if (route == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(route.indexOfCurrentDestination);
        printWriter.print(route.routeID);
        if (route.routelist == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = route.routelist.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, route.routelist[i2]);
            }
        }
        printWriter.print(route.routename);
    }

    private void traceRouteDestination(PrintWriter printWriter, RouteDestination routeDestination) {
        if (routeDestination == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, routeDestination.routeLocation);
        if (routeDestination.routeOptions == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = routeDestination.routeOptions.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, routeDestination.routeOptions[i2]);
            }
        }
        printWriter.print(routeDestination.destinationType);
    }

    private void traceRouteOptions(PrintWriter printWriter, RouteOptions routeOptions) {
        int n;
        int n2;
        if (routeOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(routeOptions.routeType);
        printWriter.print(routeOptions.weighting);
        printWriter.print(routeOptions.hybridMode);
        printWriter.print(routeOptions.dynamic);
        printWriter.print(routeOptions.dynamicSpeedFlow);
        printWriter.print(routeOptions.dynamicTrafficPattern);
        printWriter.print(routeOptions.dynamicTrafficPatternOnline);
        printWriter.print(routeOptions.dynamicTrafficPatternRecorded);
        printWriter.print(routeOptions.motorways);
        printWriter.print(routeOptions.ferries);
        printWriter.print(routeOptions.tollroads);
        printWriter.print(routeOptions.tollroadsCostPenalty);
        printWriter.print(routeOptions.tunnels);
        printWriter.print(routeOptions.leftRightTurn);
        printWriter.print(routeOptions.slopes);
        printWriter.print(routeOptions.slopesMaxFactor);
        printWriter.print(routeOptions.vignette);
        if (routeOptions.vignetteCountryList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = routeOptions.vignetteCountryList.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(routeOptions.vignetteCountryList[n]);
            }
        }
        printWriter.print(routeOptions.cityMaut);
        if (routeOptions.cityMautList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = routeOptions.cityMautList.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(routeOptions.cityMautList[n]);
            }
        }
        printWriter.print(routeOptions.cartrain);
        printWriter.print(routeOptions.timeDomain);
        printWriter.print(routeOptions.seasonalTimeDomain);
        printWriter.print(routeOptions.unpaved);
        printWriter.print(routeOptions.residentialAreaHandling);
        printWriter.print(routeOptions.trailer);
        printWriter.print(routeOptions.hovCarPoolsLane);
        printWriter.print(routeOptions.border);
        printWriter.print(routeOptions.ipd);
        printWriter.print(routeOptions.trail);
        printWriter.print(routeOptions.waypointMode);
        printWriter.print(routeOptions.economicTurns);
        printWriter.print(routeOptions.styleId);
    }

    private void traceRouteProperties(PrintWriter printWriter, RouteProperties routeProperties) {
        if (routeProperties == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(routeProperties.isolatedMapArea);
        printWriter.print(routeProperties.vignetteDuty);
        printWriter.print(routeProperties.restrictedArea);
        printWriter.print(routeProperties.energyConsumption);
    }

    private void traceRouteSectionInfo(PrintWriter printWriter, RouteSectionInfo routeSectionInfo) {
        if (routeSectionInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(routeSectionInfo.startDistanceToDestination);
        printWriter.print(routeSectionInfo.length);
        printWriter.print(routeSectionInfo.startTimeToDestination);
        this.trace(printWriter, routeSectionInfo.boundingRectangle);
    }

    private void traceRrdCalculationInfo(PrintWriter printWriter, RrdCalculationInfo rrdCalculationInfo) {
        if (rrdCalculationInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rrdCalculationInfo.rrdInfo);
        printWriter.print(rrdCalculationInfo.rttInfo);
    }

    private void traceThesaurusHistoryEntry(PrintWriter printWriter, ThesaurusHistoryEntry thesaurusHistoryEntry) {
        if (thesaurusHistoryEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(thesaurusHistoryEntry.uid);
        printWriter.print(thesaurusHistoryEntry.expression);
    }

    private void traceTourImportStatus(PrintWriter printWriter, TourImportStatus tourImportStatus) {
        if (tourImportStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tourImportStatus.currentIndex);
        printWriter.print(tourImportStatus.lastIndex);
        printWriter.print(tourImportStatus.status);
    }

    private void traceTryBestMatchData(PrintWriter printWriter, TryBestMatchData tryBestMatchData) {
        if (tryBestMatchData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tryBestMatchData.streedAndOrHouseNumber);
        printWriter.print(tryBestMatchData.locality);
        printWriter.print(tryBestMatchData.country);
        if (tryBestMatchData.phoneNumbers == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = tryBestMatchData.phoneNumbers.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, tryBestMatchData.phoneNumbers[i2]);
            }
        }
        printWriter.print(tryBestMatchData.postOfficeBox);
        printWriter.print(tryBestMatchData.region);
        printWriter.print(tryBestMatchData.postalCode);
        printWriter.print(tryBestMatchData.unstructured);
    }

    private void traceTryBestMatchResultData(PrintWriter printWriter, TryBestMatchResultData tryBestMatchResultData) {
        if (tryBestMatchResultData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, tryBestMatchResultData.location);
    }

    private void traceTryMatchLocationData(PrintWriter printWriter, TryMatchLocationData tryMatchLocationData) {
        if (tryMatchLocationData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tryMatchLocationData.latitude);
        printWriter.print(tryMatchLocationData.longitude);
        printWriter.print(tryMatchLocationData.houseNumber);
        printWriter.print(tryMatchLocationData.junction);
        printWriter.print(tryMatchLocationData.street);
        printWriter.print(tryMatchLocationData.town);
        printWriter.print(tryMatchLocationData.country);
        if (tryMatchLocationData.phoneNumbers == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = tryMatchLocationData.phoneNumbers.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, tryMatchLocationData.phoneNumbers[i2]);
            }
        }
        printWriter.print(tryMatchLocationData.state);
        printWriter.print(tryMatchLocationData.poiName);
        printWriter.print(tryMatchLocationData.poiCategory);
        printWriter.print(tryMatchLocationData.postalCode);
        printWriter.print(tryMatchLocationData.unstructured);
        printWriter.print(tryMatchLocationData.origin);
        printWriter.print(tryMatchLocationData.dbVersion);
        printWriter.print(tryMatchLocationData.townPart);
    }

    private void traceTryMatchLocationResultData(PrintWriter printWriter, TryMatchLocationResultData tryMatchLocationResultData) {
        if (tryMatchLocationResultData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, tryMatchLocationResultData.location);
        printWriter.print(tryMatchLocationResultData.matchLevel);
    }

    private void traceTurnListElement(PrintWriter printWriter, TurnListElement turnListElement) {
        int n;
        int n2;
        if (turnListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(turnListElement.distance);
        printWriter.print(turnListElement.eta);
        printWriter.print(turnListElement.etaWithTimeDelay);
        if (turnListElement.maneuver == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = turnListElement.maneuver.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, turnListElement.maneuver[n]);
            }
        }
        printWriter.print(turnListElement.street);
        printWriter.print(turnListElement.turnToStreet);
        printWriter.print(turnListElement.streetIconText);
        printWriter.print(turnListElement.streetIconId);
        printWriter.print(turnListElement.exitNumber);
        printWriter.print(turnListElement.signPostInfo);
        printWriter.print(turnListElement.exitIconId);
        printWriter.print(turnListElement.countryAbbreviation);
        printWriter.print(turnListElement.type);
        if (turnListElement.additionalIcons == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = turnListElement.additionalIcons.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, turnListElement.additionalIcons[n]);
            }
        }
        if (turnListElement.laneGuidance == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = turnListElement.laneGuidance.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, turnListElement.laneGuidance[n]);
            }
        }
        printWriter.print(turnListElement.destinationIndex);
        this.trace(printWriter, turnListElement.tollcost);
        printWriter.print(turnListElement.length);
        printWriter.print(turnListElement.streetCardinalDirection);
    }

    private void traceValueListStatus(PrintWriter printWriter, ValueListStatus valueListStatus) {
        if (valueListStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(valueListStatus.status);
        printWriter.print(valueListStatus.numberOfAvailableItems);
        printWriter.print(valueListStatus.distance);
    }

    private void traceViaPointListElement(PrintWriter printWriter, ViaPointListElement viaPointListElement) {
        if (viaPointListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(viaPointListElement.id);
        printWriter.print(viaPointListElement.description);
        printWriter.print(viaPointListElement.roadIconId);
        printWriter.print(viaPointListElement.roadNumber);
        printWriter.print(viaPointListElement.hasChildren);
        printWriter.print(viaPointListElement.parentID);
        printWriter.print(viaPointListElement.numberOfViaPointsInNode);
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

