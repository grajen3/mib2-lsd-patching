/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.comm.dsi.global.impl.NavSegmentIDSerializer;
import de.esolutions.fw.comm.dsi.navigation.DSINavigationReply;
import de.esolutions.fw.comm.dsi.navigation.impl.BapManeuverDescriptorSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.BapTurnToInfoSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.BrandSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.CalculatedRouteListElementSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.CategorySerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.CountryInfoSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DirectionToWaypointSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DistanceToNextManeuverSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.LDListElementSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.LICityHistoryEntrySerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.LISpellerDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.LIStateHistoryEntrySerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.LIStreetHistoryEntrySerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.LIValueListSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavDataBaseSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavLaneGuidanceDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavNextWayPointInfoSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavPoiInfoSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavRmRouteListArrayDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavRouteListDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavTraceListDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavTraceMemoryUtilizationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavVersionInfoSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.PoiExtendedInfoSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.PosPositionSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.PosTimeInfoSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RRListElementSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RgInfoForNextDestinationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RgRouteCostChangeInformationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RgTurnToInfoSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteOptionsSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RoutePropertiesSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RrdCalculationInfoSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.ThesaurusHistoryEntrySerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.TourImportStatusSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.TryBestMatchResultDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.TryMatchLocationResultDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.TurnListElementSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.ValueListStatusSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.ViaPointListElementSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.NavVersionInfo;
import org.dsi.ifc.navigation.PoiExtendedInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.PosTimeInfo;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RgTurnToInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;
import org.dsi.ifc.navigation.TourImportStatus;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;

public class DSINavigationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.navigation.DSINavigation");
    private static int dynamicHandle = 0;
    private DSINavigationReply p_DSINavigationReply;

    public DSINavigationReplyService(DSINavigationReply dSINavigationReply) {
        super(new ServiceInstanceID("efe47dec-8a76-5eaf-8f4c-7c62f0c19ca2", DSINavigationReplyService.nextDynamicHandle(), "241fe13c-64dd-573c-9ded-585e847b75d4", "dsi.navigation.DSINavigation"));
        this.p_DSINavigationReply = dSINavigationReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 206: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateAfaMode(n, n2);
                    break;
                }
                case 207: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateAfaSpeaking(bl, n);
                    break;
                }
                case 220: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateEtcDemoModeState(bl, n);
                    break;
                }
                case 221: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateEtcLanguageLoadProgress(l, n);
                    break;
                }
                case 222: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateEtcLanguageLoadStatus(n, n3);
                    break;
                }
                case 223: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateEtcMetricSystem(n, n4);
                    break;
                }
                case 327: {
                    LDListElement[] lDListElementArray = LDListElementSerializer.getOptionalLDListElementVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateDmLastDestinationsList(lDListElementArray, n);
                    break;
                }
                case 216: {
                    RRListElement[] rRListElementArray = RRListElementSerializer.getOptionalRRListElementVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateDmRecentRoutesList(rRListElementArray, n);
                    break;
                }
                case 231: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateLispIsSpellerActive(bl, n);
                    break;
                }
                case 238: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgActive(bl, n);
                    break;
                }
                case 315: {
                    RgInfoForNextDestination rgInfoForNextDestination = RgInfoForNextDestinationSerializer.getOptionalRgInfoForNextDestination(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgInfoForNextDestination(rgInfoForNextDestination, n);
                    break;
                }
                case 240: {
                    Route route = RouteSerializer.getOptionalRoute(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgCurrentRoute(route, n);
                    break;
                }
                case 241: {
                    RouteOptions routeOptions = RouteOptionsSerializer.getOptionalRouteOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgCurrentRouteOptions(routeOptions, n);
                    break;
                }
                case 245: {
                    NavLaneGuidanceData[] navLaneGuidanceDataArray = NavLaneGuidanceDataSerializer.getOptionalNavLaneGuidanceDataVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgLaneGuidance(navLaneGuidanceDataArray, bl, n);
                    break;
                }
                case 255: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgTurnToStreet(string, bl, n);
                    break;
                }
                case 256: {
                    RouteOptions routeOptions = RouteOptionsSerializer.getOptionalRouteOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgUnfulfilledRouteOptions(routeOptions, n);
                    break;
                }
                case 358: {
                    NavRouteListData[] navRouteListDataArray = NavRouteListDataSerializer.getOptionalNavRouteListDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgDestinationInfo(navRouteListDataArray, n);
                    break;
                }
                case 363: {
                    NavRouteListData[] navRouteListDataArray = NavRouteListDataSerializer.getOptionalNavRouteListDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgStreetList(navRouteListDataArray, n);
                    break;
                }
                case 362: {
                    NavPoiInfo[] navPoiInfoArray = NavPoiInfoSerializer.getOptionalNavPoiInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgPoiInfo(navPoiInfoArray, n);
                    break;
                }
                case 141: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rgException(n);
                    break;
                }
                case 250: {
                    RouteProperties routeProperties = RoutePropertiesSerializer.getOptionalRouteProperties(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgRouteProperties(routeProperties, n);
                    break;
                }
                case 351: {
                    PosPosition posPosition = PosPositionSerializer.getOptionalPosPosition(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateSoPosPosition(posPosition, n);
                    break;
                }
                case 264: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateSoPosPositionDescription(navLocation, bl, n);
                    break;
                }
                case 369: {
                    PosTimeInfo posTimeInfo = PosTimeInfoSerializer.getOptionalPosTimeInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateSoPosTimeInformation(posTimeInfo, n);
                    break;
                }
                case 261: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRrdActive(bl, n);
                    break;
                }
                case 262: {
                    RrdCalculationInfo[] rrdCalculationInfoArray = RrdCalculationInfoSerializer.getOptionalRrdCalculationInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRrdCalculationInfo(rrdCalculationInfoArray, n);
                    break;
                }
                case 224: {
                    NavVersionInfo navVersionInfo = NavVersionInfoSerializer.getOptionalNavVersionInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateEtcVersionInfo(navVersionInfo, n);
                    break;
                }
                case 217: {
                    NavDataBase[] navDataBaseArray = NavDataBaseSerializer.getOptionalNavDataBaseVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateEtcAvailableNavDataBases(navDataBaseArray, n);
                    break;
                }
                case 210: {
                    BapManeuverDescriptor[] bapManeuverDescriptorArray = BapManeuverDescriptorSerializer.getOptionalBapManeuverDescriptorVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateBapManeuverDescriptor(bapManeuverDescriptorArray, n);
                    break;
                }
                case 211: {
                    BapTurnToInfo[] bapTurnToInfoArray = BapTurnToInfoSerializer.getOptionalBapTurnToInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateBapTurnToInfo(bapTurnToInfoArray, n);
                    break;
                }
                case 257: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgiString(sArray, n);
                    break;
                }
                case 359: {
                    NavRouteListData[] navRouteListDataArray = NavRouteListDataSerializer.getOptionalNavRouteListDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgDetailedStreetList(navRouteListDataArray, n);
                    break;
                }
                case 258: {
                    Route route = RouteSerializer.getOptionalRoute(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRmPersistentRoute(route, n);
                    break;
                }
                case 252: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgTimeAfaToDestination(l, n);
                    break;
                }
                case 45: {
                    Route route = RouteSerializer.getOptionalRoute(iDeserializer);
                    this.p_DSINavigationReply.etcSensorDataReplayRoute(route);
                    break;
                }
                case 44: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSINavigationReply.etcSensorDataReplayGuidance(bl);
                    break;
                }
                case 407: {
                    CalculatedRouteListElement[] calculatedRouteListElementArray = CalculatedRouteListElementSerializer.getOptionalCalculatedRouteListElementVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgCalculatedRoutes(calculatedRouteListElementArray, n);
                    break;
                }
                case 408: {
                    RgRouteCostChangeInformation rgRouteCostChangeInformation = RgRouteCostChangeInformationSerializer.getOptionalRgRouteCostChangeInformation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgRouteCostChangeInformation(rgRouteCostChangeInformation, n);
                    break;
                }
                case 310: {
                    NavTraceMemoryUtilization navTraceMemoryUtilization = NavTraceMemoryUtilizationSerializer.getOptionalNavTraceMemoryUtilization(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateTrMemoryUtilization(navTraceMemoryUtilization, n);
                    break;
                }
                case 268: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateTrOperatingMode(n, n5);
                    break;
                }
                case 311: {
                    NavTraceListData[] navTraceListDataArray = NavTraceListDataSerializer.getOptionalNavTraceListDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateTrTraceList(navTraceListDataArray, n);
                    break;
                }
                case 388: {
                    NavRmRouteListArrayData[] navRmRouteListArrayDataArray = NavRmRouteListArrayDataSerializer.getOptionalNavRmRouteListArrayDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRmRouteList(navRmRouteListArrayDataArray, n);
                    break;
                }
                case 248: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgRouteCalculationState(n, n6);
                    break;
                }
                case 233: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateNavstateOfOperation(n, n7);
                    break;
                }
                case 232: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateNavMedia(stringArray, n);
                    break;
                }
                case 380: {
                    TurnListElement[] turnListElementArray = TurnListElementSerializer.getOptionalTurnListElementVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgTurnList(turnListElementArray, n);
                    break;
                }
                case 209: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateAvailableLanguages(stringArray, n);
                    break;
                }
                case 226: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateLanguage(string, n);
                    break;
                }
                case 213: {
                    DistanceToNextManeuver distanceToNextManeuver = DistanceToNextManeuverSerializer.getOptionalDistanceToNextManeuver(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateDistanceToNextManeuver(distanceToNextManeuver, n);
                    break;
                }
                case 219: {
                    NavDataBase navDataBase = NavDataBaseSerializer.getOptionalNavDataBase(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateEtcCurrentNavDataBase(navDataBase, n);
                    break;
                }
                case 266: {
                    DirectionToWaypoint directionToWaypoint = DirectionToWaypointSerializer.getOptionalDirectionToWaypoint(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateTrDirectionToWaypoint(directionToWaypoint, n);
                    break;
                }
                case 237: {
                    ValueListStatus valueListStatus = ValueListStatusSerializer.getOptionalValueListStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updatePoiSubstringSearchStatus(valueListStatus, n);
                    break;
                }
                case 269: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateTrRecordingState(n, n8);
                    break;
                }
                case 146: {
                    this.p_DSINavigationReply.rgSetRouteGuidanceModeResult();
                    break;
                }
                case 18: {
                    long l = iDeserializer.getInt64();
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    this.p_DSINavigationReply.dmLastDestinationsGetResult(l, navLocation);
                    break;
                }
                case 24: {
                    long l = iDeserializer.getInt64();
                    Route route = RouteSerializer.getOptionalRoute(iDeserializer);
                    this.p_DSINavigationReply.dmRecentRoutesGetResult(l, route);
                    break;
                }
                case 26: {
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    this.p_DSINavigationReply.dmResult(l, l2);
                    break;
                }
                case 70: {
                    LISpellerData lISpellerData = LISpellerDataSerializer.getOptionalLISpellerData(iDeserializer);
                    this.p_DSINavigationReply.liGetStateResult(lISpellerData);
                    break;
                }
                case 88: {
                    long l = iDeserializer.getInt64();
                    this.p_DSINavigationReply.liResult(l);
                    break;
                }
                case 126: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    String string2 = iDeserializer.getOptionalString();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    boolean bl3 = iDeserializer.getBool();
                    boolean bl4 = iDeserializer.getBool();
                    int n11 = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    this.p_DSINavigationReply.lispUpdateSpellerResult(string, n, bl, bl2, string2, n9, n10, bl3, bl4, n11, l);
                    break;
                }
                case 56: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
                    long l = iDeserializer.getInt64();
                    this.p_DSINavigationReply.liCurrentState(navLocation, nArray, nArray2, l);
                    break;
                }
                case 337: {
                    LIValueList lIValueList = LIValueListSerializer.getOptionalLIValueList(iDeserializer);
                    long l = iDeserializer.getInt64();
                    this.p_DSINavigationReply.liValueList(lIValueList, l);
                    break;
                }
                case 341: {
                    LIValueList lIValueList = LIValueListSerializer.getOptionalLIValueList(iDeserializer);
                    long l = iDeserializer.getInt64();
                    this.p_DSINavigationReply.poiValueList(lIValueList, l);
                    break;
                }
                case 66: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    this.p_DSINavigationReply.liGetLocationDescriptionTransformResult(navLocation);
                    break;
                }
                case 157: {
                    long l = iDeserializer.getInt64();
                    this.p_DSINavigationReply.rmMakeRoutePersistentResult(l);
                    break;
                }
                case 109: {
                    TryBestMatchResultData[] tryBestMatchResultDataArray = TryBestMatchResultDataSerializer.getOptionalTryBestMatchResultDataVarArray(iDeserializer);
                    this.p_DSINavigationReply.liTryBestMatchResult(tryBestMatchResultDataArray);
                    break;
                }
                case 41: {
                    String string = iDeserializer.getOptionalString();
                    long l = iDeserializer.getInt64();
                    this.p_DSINavigationReply.etcGetCountryAbbreviationResult(string, l);
                    break;
                }
                case 199: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.trStartTraceRecordingResult(n, l, n12);
                    break;
                }
                case 201: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.trStopTraceRecordingResult(n, l, n13);
                    break;
                }
                case 203: {
                    int n = iDeserializer.getInt32();
                    NavSegmentID navSegmentID = NavSegmentIDSerializer.getOptionalNavSegmentID(iDeserializer);
                    int n14 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.trStoreTraceResult(n, navSegmentID, n14);
                    break;
                }
                case 197: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.trRenameTraceResult(n, n15);
                    break;
                }
                case 195: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.trDeleteTraceResult(n, n16);
                    break;
                }
                case 193: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.trDeleteAllTracesResult(n, n17);
                    break;
                }
                case 159: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    this.p_DSINavigationReply.rmRouteAddResult(n, l);
                    break;
                }
                case 163: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rmRouteDeleteResult(n);
                    break;
                }
                case 162: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rmRouteDeleteAllResult(n);
                    break;
                }
                case 165: {
                    int n = iDeserializer.getInt32();
                    Route route = RouteSerializer.getOptionalRoute(iDeserializer);
                    this.p_DSINavigationReply.rmRouteGetResult(n, route);
                    break;
                }
                case 167: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rmRouteRenameResult(n);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSINavigationReply.createExportFileResult(n, bl);
                    break;
                }
                case 52: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSINavigationReply.importFileResult(n, bl);
                    break;
                }
                case 55: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSINavigationReply.languageSpellableCharactersResult(string);
                    break;
                }
                case 142: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rgNotPossible(n);
                    break;
                }
                case 205: {
                    Route route = RouteSerializer.getOptionalRoute(iDeserializer);
                    this.p_DSINavigationReply.translateRouteResult(route);
                    break;
                }
                case 128: {
                    boolean bl = iDeserializer.getBool();
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    this.p_DSINavigationReply.locationToStreamResult(bl, byArray);
                    break;
                }
                case 190: {
                    boolean bl = iDeserializer.getBool();
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    this.p_DSINavigationReply.streamToLocationResult(bl, navLocation);
                    break;
                }
                case 111: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSINavigationReply.liValueListFileStatus(n, n18, string);
                    break;
                }
                case 114: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.liValueListOutputMethod(n);
                    break;
                }
                case 214: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateDmFlagDestination(navLocation, n);
                    break;
                }
                case 60: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_DSINavigationReply.liGetLastCityHistoryEntryResult(navLocation, bl);
                    break;
                }
                case 64: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_DSINavigationReply.liGetLastStreetHistoryEntryResult(navLocation, bl);
                    break;
                }
                case 227: {
                    LICityHistoryEntry[] lICityHistoryEntryArray = LICityHistoryEntrySerializer.getOptionalLICityHistoryEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateLiCityHistory(lICityHistoryEntryArray, n);
                    break;
                }
                case 228: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateLiCountryForCityAndStreetHistory(string, n);
                    break;
                }
                case 74: {
                    long l = iDeserializer.getInt64();
                    this.p_DSINavigationReply.liLastCityAndStreetHistoryResult(l);
                    break;
                }
                case 230: {
                    LIStreetHistoryEntry[] lIStreetHistoryEntryArray = LIStreetHistoryEntrySerializer.getOptionalLIStreetHistoryEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateLiStreetHistory(lIStreetHistoryEntryArray, n);
                    break;
                }
                case 229: {
                    LIStateHistoryEntry[] lIStateHistoryEntryArray = LIStateHistoryEntrySerializer.getOptionalLIStateHistoryEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateLiStateHistory(lIStateHistoryEntryArray, n);
                    break;
                }
                case 73: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.liHistoryResult(n);
                    break;
                }
                case 62: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_DSINavigationReply.liGetLastStateHistoryEntryResult(navLocation, bl);
                    break;
                }
                case 254: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgTurnListCalculationHorizon(l, n);
                    break;
                }
                case 247: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgPoiInfoCalculationHorizon(l, n);
                    break;
                }
                case 188: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    this.p_DSINavigationReply.soPosPositionDescriptionVehicleResult(navLocation);
                    break;
                }
                case 99: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    this.p_DSINavigationReply.liStripLocationResult(navLocation);
                    break;
                }
                case 139: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.responseAudioTrigger(n);
                    break;
                }
                case 208: {
                    int n = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateAudioRequest(n, n19);
                    break;
                }
                case 92: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.liSetCountryForCityAndStreetHistoryResult(n);
                    break;
                }
                case 151: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rgStartGuidanceCalculatedRouteResult(n);
                    break;
                }
                case 155: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSINavigationReply.rgSwitchToNextPossibleRoadResult(bl);
                    break;
                }
                case 101: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.liThesaurusHistoryAddResult(n, n20);
                    break;
                }
                case 107: {
                    ThesaurusHistoryEntry thesaurusHistoryEntry = ThesaurusHistoryEntrySerializer.getOptionalThesaurusHistoryEntry(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.liThesaurusHistoryGetEntryResult(thesaurusHistoryEntry, n);
                    break;
                }
                case 105: {
                    int n = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.liThesaurusHistoryDeleteResult(n, n21);
                    break;
                }
                case 104: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.liThesaurusHistoryDeleteAllResult(n);
                    break;
                }
                case 225: {
                    ThesaurusHistoryEntry[] thesaurusHistoryEntryArray = ThesaurusHistoryEntrySerializer.getOptionalThesaurusHistoryEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateLIThesaurusHistory(thesaurusHistoryEntryArray, n);
                    break;
                }
                case 212: {
                    CountryInfo[] countryInfoArray = CountryInfoSerializer.getOptionalCountryInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateCountryInfo(countryInfoArray, n);
                    break;
                }
                case 137: {
                    CountryInfo countryInfo = CountryInfoSerializer.getOptionalCountryInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.requestCountryInfoResult(countryInfo, n);
                    break;
                }
                case 409: {
                    int n = iDeserializer.getInt32();
                    Category[] categoryArray = CategorySerializer.getOptionalCategoryVarArray(iDeserializer);
                    int n22 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.ehGetAllCategoriesResult(n, categoryArray, n22);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    Brand[] brandArray = BrandSerializer.getOptionalBrandVarArray(iDeserializer);
                    int n24 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.ehGetAllBrandsOfCategoryResult(n, n23, brandArray, n24);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.ehResult(n, n25);
                    break;
                }
                case 179: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.setRemainingRangeOfVehicleResult(n);
                    break;
                }
                case 185: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.setVehicleConsumptionInfoResult(n);
                    break;
                }
                case 183: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.setUserDefinedPOIsResult(n);
                    break;
                }
                case 181: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.setTrailerStatusResult(n);
                    break;
                }
                case 72: {
                    int n = iDeserializer.getInt32();
                    ViaPointListElement[] viaPointListElementArray = ViaPointListElementSerializer.getOptionalViaPointListElementVarArray(iDeserializer);
                    int n26 = iDeserializer.getInt32();
                    int n27 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.liGetViaPointListResult(n, viaPointListElementArray, n26, n27);
                    break;
                }
                case 90: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.liSelectViaPointResult(navLocation, n);
                    break;
                }
                case 265: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateStyleDBPaths(stringArray, n);
                    break;
                }
                case 260: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRouteResumePossible(bl, n);
                    break;
                }
                case 150: {
                    NavSegmentID navSegmentID = NavSegmentIDSerializer.getOptionalNavSegmentID(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rgStartGuidanceCalculatedRouteByUIDResult(navSegmentID, n);
                    break;
                }
                case 234: {
                    NavLocation[] navLocationArray = NavLocationSerializer.getOptionalNavLocationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updatePOIsEnteringProximityRange(navLocationArray, n);
                    break;
                }
                case 68: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n28 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.liGetSpellableCharactersResult(navLocation, n, string, n28);
                    break;
                }
                case 218: {
                    NavDataBase[] navDataBaseArray = NavDataBaseSerializer.getOptionalNavDataBaseVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateEtcAvailablePersonalPOIDataBases(navDataBaseArray, n);
                    break;
                }
                case 236: {
                    int n = iDeserializer.getInt32();
                    int n29 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updatePersonalPOISearchStatus(n, n29);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.deletePersonalPOIDataBasesResult(n);
                    break;
                }
                case 187: {
                    int n = iDeserializer.getInt32();
                    int n30 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.setVehicleFuelTypeResult(n, n30);
                    break;
                }
                case 8: {
                    long l = iDeserializer.getInt64();
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.createNavLocationOfPOIUIDResult(l, navLocation, n);
                    break;
                }
                case 169: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n31 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rmRouteReplaceResult(n, l, n31);
                    break;
                }
                case 278: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.setNavInternalDataToFactorySettingsResult(n);
                    break;
                }
                case 280: {
                    TryMatchLocationResultData[] tryMatchLocationResultDataArray = TryMatchLocationResultDataSerializer.getOptionalTryMatchLocationResultDataVarArray(iDeserializer);
                    this.p_DSINavigationReply.liTryMatchLocationResult(tryMatchLocationResultDataArray);
                    break;
                }
                case 286: {
                    int n = iDeserializer.getInt32();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n32 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateNavDbRegionsState(n, stringArray, n32);
                    break;
                }
                case 307: {
                    NavSegmentID[] navSegmentIDArray = NavSegmentIDSerializer.getOptionalNavSegmentIDVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.trImportTrailsResult(navSegmentIDArray, n);
                    break;
                }
                case 305: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.trExportTrailsResult(n);
                    break;
                }
                case 309: {
                    NavNextWayPointInfo navNextWayPointInfo = NavNextWayPointInfoSerializer.getOptionalNavNextWayPointInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateTrInfoForNextWaypoint(navNextWayPointInfo, n);
                    break;
                }
                case 302: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rgStartRubberbandManipulationResult(n);
                    break;
                }
                case 389: {
                    NavRectangle navRectangle = NavRectangleSerializer.getOptionalNavRectangle(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rgGetRouteBoundingRectangleResult(navRectangle, n);
                    break;
                }
                case 293: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rgGetLocationOnRouteResult(navLocation, n);
                    break;
                }
                case 297: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rgResult(n);
                    break;
                }
                case 314: {
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rgGetRubberBandPointPositionResult(navLocationWgs84, bl, n);
                    break;
                }
                case 308: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgEnhancedSignPostInfoStatus(bl, n);
                    break;
                }
                case 323: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.etcSetDemoModeResult(n);
                    break;
                }
                case 326: {
                    int n = iDeserializer.getInt32();
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    this.p_DSINavigationReply.lispGetLocationFromLiValueListResult(n, navLocation);
                    break;
                }
                case 320: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSINavigationReply.lispGetMatchingNVCResult(string);
                    break;
                }
                case 339: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_DSINavigationReply.poiGetXt9LDBsResult(stringArray);
                    break;
                }
                case 360: {
                    NavPoiInfo[] navPoiInfoArray = NavPoiInfoSerializer.getOptionalNavPoiInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgMotorwayInfo(navPoiInfoArray, n);
                    break;
                }
                case 350: {
                    RgInfoForNextDestination rgInfoForNextDestination = RgInfoForNextDestinationSerializer.getOptionalRgInfoForNextDestination(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgVirtualDestinationInfo(rgInfoForNextDestination, n);
                    break;
                }
                case 344: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rgTriggerRCCIUpdateResult(n);
                    break;
                }
                case 333: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    this.p_DSINavigationReply.liGetLocationDescriptionTransformNearByResult(navLocation);
                    break;
                }
                case 349: {
                    RgTurnToInfo rgTurnToInfo = RgTurnToInfoSerializer.getOptionalRgTurnToInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgTurnToInfo(rgTurnToInfo, n);
                    break;
                }
                case 364: {
                    PosTimeInfo posTimeInfo = PosTimeInfoSerializer.getOptionalPosTimeInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.etcGetPositionTimeInfoResult(posTimeInfo, n);
                    break;
                }
                case 355: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSINavigationReply.poiGetCategoryTypesFromUIdResult(nArray);
                    break;
                }
                case 361: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRgPersistedRouteDataAvailable(bl, n);
                    break;
                }
                case 366: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    NavLocation[] navLocationArray = NavLocationSerializer.getOptionalNavLocationVarArray(iDeserializer);
                    this.p_DSINavigationReply.liDisambiguateLocationResult(nArray, navLocationArray);
                    break;
                }
                case 375: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.triggerEventAudioMessageResult(n);
                    break;
                }
                case 379: {
                    int n = iDeserializer.getInt32();
                    int n33 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateMapIntegrationState(n, n33);
                    break;
                }
                case 378: {
                    int n = iDeserializer.getInt32();
                    int n34 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateMapIntegrationProgress(n, n34);
                    break;
                }
                case 377: {
                    int n = iDeserializer.getInt32();
                    int n35 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.etcTriggerNavigationRestartResult(n, n35);
                    break;
                }
                case 372: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n36 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.lispRequestNVCListResult(n, string, n36);
                    break;
                }
                case 386: {
                    int n = iDeserializer.getInt32();
                    int n37 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateBapManeuverState(n, n37);
                    break;
                }
                case 385: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.rmImportToursFromGpxFileResult(n);
                    break;
                }
                case 387: {
                    TourImportStatus tourImportStatus = TourImportStatusSerializer.getOptionalTourImportStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateRmImportToursFromGpxFileStatus(tourImportStatus, n);
                    break;
                }
                case 382: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    this.p_DSINavigationReply.importRouteFromGpxFileResult(navLocation);
                    break;
                }
                case 391: {
                    BapManeuverDescriptor[] bapManeuverDescriptorArray = BapManeuverDescriptorSerializer.getOptionalBapManeuverDescriptorVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n38 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateBapManeuverInformation(bapManeuverDescriptorArray, n, n38);
                    break;
                }
                case 395: {
                    PoiExtendedInfo poiExtendedInfo = PoiExtendedInfoSerializer.getOptionalPoiExtendedInfo(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_DSINavigationReply.poiRequestExtendedInfoResult(poiExtendedInfo, bl);
                    break;
                }
                case 405: {
                    this.p_DSINavigationReply.trClearRecordedTraceCacheResult();
                    break;
                }
                case 406: {
                    int n = iDeserializer.getInt32();
                    int n39 = iDeserializer.getInt32();
                    int n40 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.updateProfileState(n, n39, n40);
                    break;
                }
                case 397: {
                    int n = iDeserializer.getInt32();
                    int n41 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.profileChanged(n, n41);
                    break;
                }
                case 398: {
                    int n = iDeserializer.getInt32();
                    int n42 = iDeserializer.getInt32();
                    int n43 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.profileCopied(n, n42, n43);
                    break;
                }
                case 401: {
                    int n = iDeserializer.getInt32();
                    int n44 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.profileReset(n, n44);
                    break;
                }
                case 403: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavigationReply.profileResetAll(n);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n45 = iDeserializer.getInt32();
                    this.p_DSINavigationReply.asyncException(n, string, n45);
                    break;
                }
                case 271: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSINavigationReply.yyIndication(string, string3);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

