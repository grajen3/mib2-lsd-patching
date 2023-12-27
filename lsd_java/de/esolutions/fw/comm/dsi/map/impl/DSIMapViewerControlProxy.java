/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerControl;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerControlC;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerControlReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$1;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$10;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$11;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$12;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$13;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$14;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$15;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$16;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$17;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$18;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$19;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$2;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$20;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$21;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$22;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$23;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$3;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$4;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$5;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$6;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$7;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$8;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy$9;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.PoiListElement;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class DSIMapViewerControlProxy
implements DSIMapViewerControl,
DSIMapViewerControlC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.map.DSIMapViewerControl");
    private Proxy proxy;

    public DSIMapViewerControlProxy(int n, DSIMapViewerControlReply dSIMapViewerControlReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3a421f5d-d9bc-5bdc-b07f-07d896eb7490", n, "e4e90991-b4f4-5a57-a32f-5a4c8fcc1f67", "dsi.map.DSIMapViewerControl");
        DSIMapViewerControlReplyService dSIMapViewerControlReplyService = new DSIMapViewerControlReplyService(dSIMapViewerControlReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMapViewerControlReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void configureFlags(int n, MapFlag[] mapFlagArray) {
        DSIMapViewerControlProxy$1 dSIMapViewerControlProxy$1 = new DSIMapViewerControlProxy$1(this, n, mapFlagArray);
        this.proxy.remoteCallMethod((short)6, dSIMapViewerControlProxy$1);
    }

    @Override
    public void dragMap(short s, short s2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putInt16(s2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void ensureTMCVisibility(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void getInfoForPosition() {
        this.proxy.remoteCallMethod((short)15, null);
    }

    @Override
    public void getInfoForScreenPosition(Point point) {
        DSIMapViewerControlProxy$2 dSIMapViewerControlProxy$2 = new DSIMapViewerControlProxy$2(this, point);
        this.proxy.remoteCallMethod((short)17, dSIMapViewerControlProxy$2);
    }

    @Override
    public void getNumberOfPOIs() {
        this.proxy.remoteCallMethod((short)18, null);
    }

    @Override
    public void goToTMCMessage(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void packPOIContainer() {
        this.proxy.remoteCallMethod((short)21, null);
    }

    @Override
    public void rbSelectAlternativeRoute(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    @Override
    public void rbSelectNextSegment() {
        this.proxy.remoteCallMethod((short)27, null);
    }

    @Override
    public void rbSelectPreviousSegment() {
        this.proxy.remoteCallMethod((short)28, null);
    }

    @Override
    public void rbSetPosition(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    @Override
    public void scrollToDirection(short s, int n, short s2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putInt32(n);
            genericSerializable.putInt16(s2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    @Override
    public void selectNextPOI() {
        this.proxy.remoteCallMethod((short)31, null);
    }

    @Override
    public void selectPrevPOI() {
        this.proxy.remoteCallMethod((short)32, null);
    }

    @Override
    public void set3DLandmarksVisible(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    @Override
    public void setCarPosition(Point point) {
        DSIMapViewerControlProxy$3 dSIMapViewerControlProxy$3 = new DSIMapViewerControlProxy$3(this, point);
        this.proxy.remoteCallMethod((short)36, dSIMapViewerControlProxy$3);
    }

    @Override
    public void setDayView() {
        this.proxy.remoteCallMethod((short)40, null);
    }

    @Override
    public void setEnableRouteCalcMode(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)41, genericSerializable);
    }

    @Override
    public void setEnableSoftJump(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    @Override
    public void setEnableSoftRotation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }

    @Override
    public void setEnableSoftTilt(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)44, genericSerializable);
    }

    @Override
    public void setEnableSoftZoom(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)45, genericSerializable);
    }

    @Override
    public void setHotPoint(Point point) {
        DSIMapViewerControlProxy$4 dSIMapViewerControlProxy$4 = new DSIMapViewerControlProxy$4(this, point);
        this.proxy.remoteCallMethod((short)52, dSIMapViewerControlProxy$4);
    }

    @Override
    public void setLocation(int n, short s) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt16(s);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)53, genericSerializable);
    }

    @Override
    public void setLocationByLocation(NavLocation navLocation) {
        DSIMapViewerControlProxy$5 dSIMapViewerControlProxy$5 = new DSIMapViewerControlProxy$5(this, navLocation);
        this.proxy.remoteCallMethod((short)54, dSIMapViewerControlProxy$5);
    }

    @Override
    public void setLocationByLocationAndView(NavLocation navLocation, short s, int n) {
        DSIMapViewerControlProxy$6 dSIMapViewerControlProxy$6 = new DSIMapViewerControlProxy$6(this, navLocation, s, n);
        this.proxy.remoteCallMethod((short)55, dSIMapViewerControlProxy$6);
    }

    @Override
    public void setMapPosition(NavLocationWgs84 navLocationWgs84) {
        DSIMapViewerControlProxy$7 dSIMapViewerControlProxy$7 = new DSIMapViewerControlProxy$7(this, navLocationWgs84);
        this.proxy.remoteCallMethod((short)56, dSIMapViewerControlProxy$7);
    }

    @Override
    public void setMapViewPort(NavLocationWgs84 navLocationWgs84, short s, int n) {
        DSIMapViewerControlProxy$8 dSIMapViewerControlProxy$8 = new DSIMapViewerControlProxy$8(this, navLocationWgs84, s, n);
        this.proxy.remoteCallMethod((short)57, dSIMapViewerControlProxy$8);
    }

    @Override
    public void setMapViewPortByLD(NavLocation navLocation, NavLocation navLocation2, int n) {
        DSIMapViewerControlProxy$9 dSIMapViewerControlProxy$9 = new DSIMapViewerControlProxy$9(this, navLocation, navLocation2, n);
        this.proxy.remoteCallMethod((short)58, dSIMapViewerControlProxy$9);
    }

    @Override
    public void setMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)62, genericSerializable);
    }

    @Override
    public void setNightView() {
        this.proxy.remoteCallMethod((short)65, null);
    }

    @Override
    public void setOrientation(int n, Point point) {
        DSIMapViewerControlProxy$10 dSIMapViewerControlProxy$10 = new DSIMapViewerControlProxy$10(this, n, point);
        this.proxy.remoteCallMethod((short)71, dSIMapViewerControlProxy$10);
    }

    @Override
    public void setRotation(short s) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)73, genericSerializable);
    }

    @Override
    public void setViewType(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)89, genericSerializable);
    }

    @Override
    public void setZoomArea(Rect rect) {
        DSIMapViewerControlProxy$11 dSIMapViewerControlProxy$11 = new DSIMapViewerControlProxy$11(this, rect);
        this.proxy.remoteCallMethod((short)91, dSIMapViewerControlProxy$11);
    }

    @Override
    public void setZoomLevel(float f2, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putFloat(f2);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)92, genericSerializable);
    }

    @Override
    public void setCountryOverviewCountry(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)38, genericSerializable);
    }

    @Override
    public void showTMCMessages(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)97, genericSerializable);
    }

    @Override
    public void startScrollToDirection(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)99, genericSerializable);
    }

    @Override
    public void stopScrollToDirection() {
        this.proxy.remoteCallMethod((short)102, null);
    }

    @Override
    public void unpackPOIContainer(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)107, genericSerializable);
    }

    @Override
    public void viewFreeze(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)146, genericSerializable);
    }

    @Override
    public void viewSetScreenViewport(Rect rect) {
        DSIMapViewerControlProxy$12 dSIMapViewerControlProxy$12 = new DSIMapViewerControlProxy$12(this, rect);
        this.proxy.remoteCallMethod((short)147, dSIMapViewerControlProxy$12);
    }

    @Override
    public void viewSetScreenViewportMaximum(Rect rect) {
        DSIMapViewerControlProxy$13 dSIMapViewerControlProxy$13 = new DSIMapViewerControlProxy$13(this, rect);
        this.proxy.remoteCallMethod((short)160, dSIMapViewerControlProxy$13);
    }

    @Override
    public void viewSetVisible(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)148, genericSerializable);
    }

    @Override
    public void setMetricSystem(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)59, genericSerializable);
    }

    @Override
    public void setViewFocusOnBlock(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)83, genericSerializable);
    }

    @Override
    public void setViewFocusOnPoi(PoiListElement[] poiListElementArray) {
        DSIMapViewerControlProxy$14 dSIMapViewerControlProxy$14 = new DSIMapViewerControlProxy$14(this, poiListElementArray);
        this.proxy.remoteCallMethod((short)87, dSIMapViewerControlProxy$14);
    }

    @Override
    public void startToDrawNewRectangleInMap() {
        this.proxy.remoteCallMethod((short)100, null);
    }

    @Override
    public void editRectangleInMap(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void setSouthWestCornerOfRectangleInMap(Point point) {
        DSIMapViewerControlProxy$15 dSIMapViewerControlProxy$15 = new DSIMapViewerControlProxy$15(this, point);
        this.proxy.remoteCallMethod((short)77, dSIMapViewerControlProxy$15);
    }

    @Override
    public void setNorthEastCornerOfRectangleInMap(Point point) {
        DSIMapViewerControlProxy$16 dSIMapViewerControlProxy$16 = new DSIMapViewerControlProxy$16(this, point);
        this.proxy.remoteCallMethod((short)66, dSIMapViewerControlProxy$16);
    }

    @Override
    public void finishDrawRectangleInMap() {
        this.proxy.remoteCallMethod((short)13, null);
    }

    @Override
    public void setCityModelMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    @Override
    public void displayRemainingRangeOfVehicle(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void touchApproach(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)105, genericSerializable);
    }

    @Override
    public void setBrandIconStyle(int[] nArray, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }

    @Override
    public void startScrollByVector(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)98, genericSerializable);
    }

    @Override
    public void setGuidanceSymbol(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)48, genericSerializable);
    }

    @Override
    public void setHOVLaneVisibility(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)50, genericSerializable);
    }

    @Override
    public void rbGetIDOfSelectedSegment() {
        this.proxy.remoteCallMethod((short)22, null);
    }

    @Override
    public void rbGetRRDToSelectedSegment(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    @Override
    public void setTollRoadHighLighting(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)80, genericSerializable);
    }

    @Override
    public void setMountainPeakMarker(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)63, genericSerializable);
    }

    @Override
    public void setViewFocusOnCombinedRouteListElements(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)85, genericSerializable);
    }

    @Override
    public void setFrameRateMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)46, genericSerializable);
    }

    @Override
    public void setScrollByCrossHairs(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)75, genericSerializable);
    }

    @Override
    public void setScrollByCrossHairsBoundingBox(Rect rect) {
        DSIMapViewerControlProxy$17 dSIMapViewerControlProxy$17 = new DSIMapViewerControlProxy$17(this, rect);
        this.proxy.remoteCallMethod((short)76, dSIMapViewerControlProxy$17);
    }

    @Override
    public void setRouteColoringPolicy(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)74, genericSerializable);
    }

    @Override
    public void setWeatherVisualization(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)90, genericSerializable);
    }

    @Override
    public void setPictureNavigationIconVisibility(boolean bl, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)72, genericSerializable);
    }

    @Override
    public void setMobilityHorizonVisibility(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)60, genericSerializable);
    }

    @Override
    public void setTrafficMapStyle(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)82, genericSerializable);
    }

    @Override
    public void showSpeedAndFlowFreeFlow(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)96, genericSerializable);
    }

    @Override
    public void showSpeedAndFlowCongestions(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)95, genericSerializable);
    }

    @Override
    public void showRichContent(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)93, genericSerializable);
    }

    @Override
    public void setGeneralPoiVisibility(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)47, genericSerializable);
    }

    @Override
    public void setCrossHairsColor(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    @Override
    public void setViewPortBorder(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)88, genericSerializable);
    }

    @Override
    public void setTerrainElevation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)79, genericSerializable);
    }

    @Override
    public void ensurePoiVisibility(NavLocation[] navLocationArray) {
        DSIMapViewerControlProxy$18 dSIMapViewerControlProxy$18 = new DSIMapViewerControlProxy$18(this, navLocationArray);
        this.proxy.remoteCallMethod((short)11, dSIMapViewerControlProxy$18);
    }

    @Override
    public void suspendMapViewer() {
        this.proxy.remoteCallMethod((short)103, null);
    }

    @Override
    public void wakeupMapViewer() {
        this.proxy.remoteCallMethod((short)149, null);
    }

    @Override
    public void setMobilityHorizonZoomMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)61, genericSerializable);
    }

    @Override
    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84) {
        DSIMapViewerControlProxy$19 dSIMapViewerControlProxy$19 = new DSIMapViewerControlProxy$19(this, navLocationWgs84);
        this.proxy.remoteCallMethod((short)155, dSIMapViewerControlProxy$19);
    }

    @Override
    public void setHorizonMarkerVisibility(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)157, genericSerializable);
    }

    @Override
    public void ensureTrafficEventIconsVisibility(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)162, genericSerializable);
    }

    @Override
    public void setMapViewPortByWGS84Rectangle(NavRectangle navRectangle, int n) {
        DSIMapViewerControlProxy$20 dSIMapViewerControlProxy$20 = new DSIMapViewerControlProxy$20(this, navRectangle, n);
        this.proxy.remoteCallMethod((short)185, dSIMapViewerControlProxy$20);
    }

    @Override
    public void startRouteDragging(NavLocationWgs84 navLocationWgs84) {
        DSIMapViewerControlProxy$21 dSIMapViewerControlProxy$21 = new DSIMapViewerControlProxy$21(this, navLocationWgs84);
        this.proxy.remoteCallMethod((short)165, dSIMapViewerControlProxy$21);
    }

    @Override
    public void dragRoute(short s, short s2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putInt16(s2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)161, genericSerializable);
    }

    @Override
    public void setDragRouteMarker(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)163, genericSerializable);
    }

    @Override
    public void highlightRouteBasedOnLength(long l, long l2, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)167, genericSerializable);
    }

    @Override
    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)168, genericSerializable);
    }

    @Override
    public void ehSetCategoryVisibilityToDefault(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)169, genericSerializable);
    }

    @Override
    public void setMapOverlays(int n, MapOverlay[] mapOverlayArray, int n2, int n3) {
        DSIMapViewerControlProxy$22 dSIMapViewerControlProxy$22 = new DSIMapViewerControlProxy$22(this, n, mapOverlayArray, n2, n3);
        this.proxy.remoteCallMethod((short)184, dSIMapViewerControlProxy$22);
    }

    @Override
    public void setMapLayerVisible(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)171, genericSerializable);
    }

    @Override
    public void setTemperatureScale(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)176, genericSerializable);
    }

    @Override
    public void setSoftAnimationSpeed(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)178, genericSerializable);
    }

    @Override
    public void setSpeedAndFlowRoadClass(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)179, genericSerializable);
    }

    @Override
    public void setRouteVisibility(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)182, genericSerializable);
    }

    @Override
    public void setVisibleRoutes(NavSegmentID[] navSegmentIDArray) {
        DSIMapViewerControlProxy$23 dSIMapViewerControlProxy$23 = new DSIMapViewerControlProxy$23(this, navSegmentIDArray);
        this.proxy.remoteCallMethod((short)187, dSIMapViewerControlProxy$23);
    }

    @Override
    public void showTrafficEventListView(long[] lArray, boolean bl, boolean bl2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)188, genericSerializable);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)69, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)70, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)68, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)152, genericSerializable);
    }
}

