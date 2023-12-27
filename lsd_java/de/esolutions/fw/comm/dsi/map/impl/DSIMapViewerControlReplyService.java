/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerControlReply;
import de.esolutions.fw.comm.dsi.map.impl.AvailableRouteSerializer;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.comm.dsi.map.impl.PosInfoSerializer;
import de.esolutions.fw.comm.dsi.map.impl.RectSerializer;
import de.esolutions.fw.comm.dsi.map.impl.RouteBrowserInfoSerializer;
import de.esolutions.fw.comm.dsi.map.impl.ViewPortSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.ViewPort;

public class DSIMapViewerControlReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.map.DSIMapViewerControl");
    private static int dynamicHandle = 0;
    private DSIMapViewerControlReply p_DSIMapViewerControlReply;

    public DSIMapViewerControlReplyService(DSIMapViewerControlReply dSIMapViewerControlReply) {
        super(new ServiceInstanceID("e30ae106-0f98-5a42-ab6e-6d13db6eb9c9", DSIMapViewerControlReplyService.nextDynamicHandle(), "39c9b547-f991-57b5-be03-b01961183b13", "dsi.map.DSIMapViewerControl"));
        this.p_DSIMapViewerControlReply = dSIMapViewerControlReply;
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
                case 126: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateReady(bl, n);
                    break;
                }
                case 115: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateCurrentViewType(n, n2);
                    break;
                }
                case 116: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateDayNightView(bl, n);
                    break;
                }
                case 141: {
                    Rect rect = RectSerializer.getOptionalRect(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateViewScreenViewPort(rect, n);
                    break;
                }
                case 159: {
                    Rect rect = RectSerializer.getOptionalRect(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateViewScreenViewPortMaximum(rect, n);
                    break;
                }
                case 142: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateViewVisible(bl, n);
                    break;
                }
                case 139: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateViewFreeze(bl, n);
                    break;
                }
                case 143: {
                    float f2 = iDeserializer.getFloat();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateZoomLevel(f2, n);
                    break;
                }
                case 144: {
                    float[] fArray = iDeserializer.getOptionalFloatVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateZoomList(fArray, n);
                    break;
                }
                case 145: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateZoomListIndex(n, n3);
                    break;
                }
                case 121: {
                    short s2 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateMapRotation(s2, n);
                    break;
                }
                case 120: {
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateMapPosition(navLocationWgs84, n);
                    break;
                }
                case 119: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateMapOrientation(n, n4);
                    break;
                }
                case 111: {
                    Point point = PointSerializer.getOptionalPoint(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateCarPosition(point, n);
                    break;
                }
                case 138: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateTmcVisible(bl, n);
                    break;
                }
                case 118: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateMapMode(n, n5);
                    break;
                }
                case 128: {
                    PosInfo posInfo = PosInfoSerializer.getOptionalPosInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSelectedPoi(posInfo, n);
                    break;
                }
                case 137: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSpeedAndFlowVisible(bl, n);
                    break;
                }
                case 110: {
                    AvailableRoute[] availableRouteArray = AvailableRouteSerializer.getOptionalAvailableRouteVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateAvailableRoutes(availableRouteArray, n);
                    break;
                }
                case 140: {
                    ViewPort viewPort = ViewPortSerializer.getOptionalViewPort(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateViewPort(viewPort, n);
                    break;
                }
                case 129: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSoftJumpEnabled(bl, n);
                    break;
                }
                case 131: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSoftRotationEnabled(bl, n);
                    break;
                }
                case 133: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSoftTiltEnabled(bl, n);
                    break;
                }
                case 135: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSoftZoomEnabled(bl, n);
                    break;
                }
                case 130: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSoftJumpRunning(bl, n);
                    break;
                }
                case 132: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSoftRotationRunning(bl, n);
                    break;
                }
                case 134: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSoftTiltRunning(bl, n);
                    break;
                }
                case 136: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSoftZoomRunning(bl, n);
                    break;
                }
                case 127: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateRouteCalcModeEnabled(bl, n);
                    break;
                }
                case 125: {
                    RouteBrowserInfo routeBrowserInfo = RouteBrowserInfoSerializer.getOptionalRouteBrowserInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateRBInfoOfSelectedSegments(routeBrowserInfo, n);
                    break;
                }
                case 5: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    this.p_DSIMapViewerControlReply.configureFlags(lArray);
                    break;
                }
                case 16: {
                    PosInfo[] posInfoArray = PosInfoSerializer.getOptionalPosInfoVarArray(iDeserializer);
                    this.p_DSIMapViewerControlReply.getInfoForPosition(posInfoArray);
                    break;
                }
                case 19: {
                    long l = iDeserializer.getInt64();
                    this.p_DSIMapViewerControlReply.getNumberOfPOIs(l);
                    break;
                }
                case 108: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMapViewerControlReply.unpackPOIContainerResult(bl);
                    break;
                }
                case 113: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateCurrentLanduseStyle(n, n6);
                    break;
                }
                case 114: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateCurrentMetricSystem(n, n7);
                    break;
                }
                case 84: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.setViewFocusOnBlockResult(n);
                    break;
                }
                case 101: {
                    int n = iDeserializer.getInt32();
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    NavLocationWgs84 navLocationWgs842 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    this.p_DSIMapViewerControlReply.startToDrawNewRectangleInMapResult(n, navLocationWgs84, navLocationWgs842);
                    break;
                }
                case 78: {
                    int n = iDeserializer.getInt32();
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    this.p_DSIMapViewerControlReply.setSouthWestCornerOfRectangleInMapResult(n, navLocationWgs84);
                    break;
                }
                case 67: {
                    int n = iDeserializer.getInt32();
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    this.p_DSIMapViewerControlReply.setNorthEastCornerOfRectangleInMapResult(n, navLocationWgs84);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    NavLocationWgs84 navLocationWgs843 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    this.p_DSIMapViewerControlReply.finishDrawRectangleInMapResult(n, navLocationWgs84, navLocationWgs843);
                    break;
                }
                case 112: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateCityModelMode(n, n8);
                    break;
                }
                case 8: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMapViewerControlReply.displayRemainingRangeOfVehicleResult(bl);
                    break;
                }
                case 106: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMapViewerControlReply.touchApproachResult(bl);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.setBrandIconStyleResult(n);
                    break;
                }
                case 49: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.setGuidanceSymbolResult(n);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.setHOVLaneVisibilityResult(n);
                    break;
                }
                case 23: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.rbGetIDOfSelectedSegmentResult(l, n);
                    break;
                }
                case 25: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.rbGetRRDToSelectedSegmentResult(l, n, n9);
                    break;
                }
                case 81: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.setTollRoadHighLightingResult(bl, n);
                    break;
                }
                case 64: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.setMountainPeakMarkerResult(bl, n);
                    break;
                }
                case 104: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.suspendMapViewerResult(n);
                    break;
                }
                case 150: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.wakeupMapViewerResult(n);
                    break;
                }
                case 156: {
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMapViewerControlReply.isDetailedMapMaterialAvailable(navLocationWgs84, bl);
                    break;
                }
                case 122: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateMapViewerRunLevel(n, n10);
                    break;
                }
                case 124: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateMapViewerSuspensionSupported(n, n11);
                    break;
                }
                case 123: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateMapViewerSuspensionAndWakeUpProgress(n, n12);
                    break;
                }
                case 109: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateAvailableCountryOverviews(stringArray, n);
                    break;
                }
                case 117: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateGeneralPoiVisibility(bl, n);
                    break;
                }
                case 158: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateHorizonMarkerVisibility(bl, n);
                    break;
                }
                case 166: {
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateDragRoutePosition(navLocationWgs84, n);
                    break;
                }
                case 170: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateEhCategoryVisibility(nArray, n);
                    break;
                }
                case 173: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.setMapOverlaysResult(n, n13);
                    break;
                }
                case 174: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateMapLayerAvailable(nArray, n);
                    break;
                }
                case 175: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateMapLayerVisible(nArray, n);
                    break;
                }
                case 177: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateTemperatureScale(n, n14);
                    break;
                }
                case 180: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSpeedAndFlowRoadClass(n, n15);
                    break;
                }
                case 183: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateRouteVisibility(bl, n);
                    break;
                }
                case 186: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.updateSoftAnimationSpeed(n, n16);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSIMapViewerControlReply.asyncException(n, string, n17);
                    break;
                }
                case 151: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMapViewerControlReply.yyIndication(string, string2);
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

