/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.proxy;

import de.vw.mib.reflection.AbstractProxy;
import de.vw.mib.reflection.InvocationHandler;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrl;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.PoiListElement;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public final class LR526b2d74a
extends AbstractProxy
implements DSIMapViewerControl,
DSIMapViewerGoogleCtrl {
    private static final Method[] JMS = new Method[121];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR526b2d74a(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(0, "org.dsi.ifc.map.DSIMapViewerControl", -1704243850, 1687814400), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBrandIconStyle(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(1, "org.dsi.ifc.map.DSIMapViewerControl", 1760099288, -1034208512), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void configureFlags(int n, MapFlag[] mapFlagArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = mapFlagArray;
            this.h.invoke(this, LR526b2d74a.gjm(2, "org.dsi.ifc.map.DSIMapViewerControl", -1233287177, 1689297601), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dragMap(short s, short s2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(s2);
            this.h.invoke(this, LR526b2d74a.gjm(3, "org.dsi.ifc.map.DSIMapViewerControl", -41550223, 1359336183), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ensureTMCVisibility(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR526b2d74a.gjm(4, "org.dsi.ifc.map.DSIMapViewerControl", -1818040700, -238538240), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getInfoForPosition() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(5, "org.dsi.ifc.map.DSIMapViewerControl", -1011929340, 17), 5, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getInfoForScreenPosition(Point point) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = point;
            this.h.invoke(this, LR526b2d74a.gjm(6, "org.dsi.ifc.map.DSIMapViewerControl", -1892141387, 228217929), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getNumberOfPOIs() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(7, "org.dsi.ifc.map.DSIMapViewerControl", 1960522648, 17), 7, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void goToTMCMessage(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR526b2d74a.gjm(8, "org.dsi.ifc.map.DSIMapViewerControl", -175161107, -238538240), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void packPOIContainer() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(9, "org.dsi.ifc.map.DSIMapViewerControl", -2054391769, 17), 9, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rbSelectAlternativeRoute(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(10, "org.dsi.ifc.map.DSIMapViewerControl", 2102972952, 1687814400), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rbSelectNextSegment() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(11, "org.dsi.ifc.map.DSIMapViewerControl", 1226585571, 17), 11, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rbSelectPreviousSegment() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(12, "org.dsi.ifc.map.DSIMapViewerControl", -973747635, 17), 12, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rbSetPosition(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(13, "org.dsi.ifc.map.DSIMapViewerControl", -803870418, 1687814400), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void scrollToDirection(short s, int n, short s2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(s2);
            this.h.invoke(this, LR526b2d74a.gjm(14, "org.dsi.ifc.map.DSIMapViewerControl", -1398487987, -803680282), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void selectNextPOI() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(15, "org.dsi.ifc.map.DSIMapViewerControl", 821311129, 17), 15, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void selectPrevPOI() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(16, "org.dsi.ifc.map.DSIMapViewerControl", -258726120, 17), 16, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void set3DLandmarksVisible(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(17, "org.dsi.ifc.map.DSIMapViewerControl", -1625904214, -1653679357), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCarPosition(Point point) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = point;
            this.h.invoke(this, LR526b2d74a.gjm(18, "org.dsi.ifc.map.DSIMapViewerControl", -802854965, 228217929), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDayView() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(19, "org.dsi.ifc.map.DSIMapViewerControl", 345015559, 17), 19, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEnableRouteCalcMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(20, "org.dsi.ifc.map.DSIMapViewerControl", -240616670, -1653679357), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEnableSoftJump(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(21, "org.dsi.ifc.map.DSIMapViewerControl", -1832543207, -1653679357), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEnableSoftRotation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(22, "org.dsi.ifc.map.DSIMapViewerControl", 1657869494, -1653679357), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEnableSoftTilt(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(23, "org.dsi.ifc.map.DSIMapViewerControl", 556048665, -1653679357), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEnableSoftZoom(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(24, "org.dsi.ifc.map.DSIMapViewerControl", 938844953, -1653679357), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHotPoint(Point point) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = point;
            this.h.invoke(this, LR526b2d74a.gjm(25, "org.dsi.ifc.map.DSIMapViewerControl", 974810724, 228217929), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLocation(int n, short s) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(s);
            this.h.invoke(this, LR526b2d74a.gjm(26, "org.dsi.ifc.map.DSIMapViewerControl", -1405033753, -1005039887), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLocationByLocation(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR526b2d74a.gjm(27, "org.dsi.ifc.map.DSIMapViewerControl", 952975578, -2012328694), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLocationByLocationAndView(NavLocation navLocation, short s, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(s);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(28, "org.dsi.ifc.map.DSIMapViewerControl", 1310949659, -1009636604), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMapPosition(NavLocationWgs84 navLocationWgs84) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocationWgs84;
            this.h.invoke(this, LR526b2d74a.gjm(29, "org.dsi.ifc.map.DSIMapViewerControl", 1480838515, 17850877), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMapViewPort(NavLocationWgs84 navLocationWgs84, short s, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = navLocationWgs84;
            objectArray[1] = RuntimeUtil.valueOf(s);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(30, "org.dsi.ifc.map.DSIMapViewerControl", -183074674, 1020542967), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMapViewPortByLD(NavLocation navLocation, NavLocation navLocation2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = navLocation;
            objectArray[1] = navLocation2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(31, "org.dsi.ifc.map.DSIMapViewerControl", 614957423, -1771371888), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNightView() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(32, "org.dsi.ifc.map.DSIMapViewerControl", 276507053, 17), 32, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setOrientation(int n, Point point) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = point;
            this.h.invoke(this, LR526b2d74a.gjm(33, "org.dsi.ifc.map.DSIMapViewerControl", -2085458406, -790938727), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRotation(short s) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(s);
            this.h.invoke(this, LR526b2d74a.gjm(34, "org.dsi.ifc.map.DSIMapViewerControl", 1974479732, -242842362), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setViewType(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(35, "org.dsi.ifc.map.DSIMapViewerControl", 1980029629, 1687814400), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setZoomArea(Rect rect) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = rect;
            this.h.invoke(this, LR526b2d74a.gjm(36, "org.dsi.ifc.map.DSIMapViewerControl", -135840085, 1371138611), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setZoomLevel(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(37, "org.dsi.ifc.map.DSIMapViewerControl", -1540934723, -797832442), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCountryOverviewCountry(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR526b2d74a.gjm(38, "org.dsi.ifc.map.DSIMapViewerControl", -567394938, -633848249), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showTMCMessages(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(39, "org.dsi.ifc.map.DSIMapViewerControl", -1367906263, -1653679357), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startScrollToDirection(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(40, "org.dsi.ifc.map.DSIMapViewerControl", 1781544904, 1687814400), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void stopScrollToDirection() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(41, "org.dsi.ifc.map.DSIMapViewerControl", -895465725, 17), 41, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unpackPOIContainer(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR526b2d74a.gjm(42, "org.dsi.ifc.map.DSIMapViewerControl", 508109479, -238538240), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void viewFreeze(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(43, "org.dsi.ifc.map.DSIMapViewerControl", 286568826, -1653679357), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void viewSetScreenViewport(Rect rect) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = rect;
            this.h.invoke(this, LR526b2d74a.gjm(44, "org.dsi.ifc.map.DSIMapViewerControl", -2077462475, 1371138611), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void viewSetScreenViewportMaximum(Rect rect) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = rect;
            this.h.invoke(this, LR526b2d74a.gjm(45, "org.dsi.ifc.map.DSIMapViewerControl", -2037927831, 1371138611), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void viewSetVisible(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(46, "org.dsi.ifc.map.DSIMapViewerControl", -1438105485, -1653679357), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMetricSystem(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(47, "org.dsi.ifc.map.DSIMapViewerControl", -153108488, 1687814400), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setViewFocusOnBlock(long[] lArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = lArray;
            this.h.invoke(this, LR526b2d74a.gjm(48, "org.dsi.ifc.map.DSIMapViewerControl", 855154621, 3524), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setViewFocusOnPoi(PoiListElement[] poiListElementArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = poiListElementArray;
            this.h.invoke(this, LR526b2d74a.gjm(49, "org.dsi.ifc.map.DSIMapViewerControl", -277756899, -211582805), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startToDrawNewRectangleInMap() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(50, "org.dsi.ifc.map.DSIMapViewerControl", -1676252754, 17), 50, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void editRectangleInMap(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR526b2d74a.gjm(51, "org.dsi.ifc.map.DSIMapViewerControl", -417021886, -238538240), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSouthWestCornerOfRectangleInMap(Point point) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = point;
            this.h.invoke(this, LR526b2d74a.gjm(52, "org.dsi.ifc.map.DSIMapViewerControl", -485119279, 228217929), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNorthEastCornerOfRectangleInMap(Point point) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = point;
            this.h.invoke(this, LR526b2d74a.gjm(53, "org.dsi.ifc.map.DSIMapViewerControl", -378395205, 228217929), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void finishDrawRectangleInMap() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(54, "org.dsi.ifc.map.DSIMapViewerControl", -1809820480, 17), 54, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCityModelMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(55, "org.dsi.ifc.map.DSIMapViewerControl", 1946201506, 1687814400), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void displayRemainingRangeOfVehicle(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(56, "org.dsi.ifc.map.DSIMapViewerControl", -2113991343, -1653679357), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void touchApproach(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(57, "org.dsi.ifc.map.DSIMapViewerControl", 2091818612, -1653679357), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startScrollByVector(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526b2d74a.gjm(58, "org.dsi.ifc.map.DSIMapViewerControl", -563514207, 1676164096), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setGuidanceSymbol(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(59, "org.dsi.ifc.map.DSIMapViewerControl", -2019392818, 1687814400), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHOVLaneVisibility(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(60, "org.dsi.ifc.map.DSIMapViewerControl", -2146034908, -1653679357), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rbGetIDOfSelectedSegment() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(61, "org.dsi.ifc.map.DSIMapViewerControl", 365944469, 17), 61, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rbGetRRDToSelectedSegment(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR526b2d74a.gjm(62, "org.dsi.ifc.map.DSIMapViewerControl", -195256231, -238538240), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTollRoadHighLighting(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(63, "org.dsi.ifc.map.DSIMapViewerControl", 1621865782, -1653679357), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMountainPeakMarker(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(64, "org.dsi.ifc.map.DSIMapViewerControl", -580979013, -1653679357), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setViewFocusOnCombinedRouteListElements(long[] lArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = lArray;
            this.h.invoke(this, LR526b2d74a.gjm(65, "org.dsi.ifc.map.DSIMapViewerControl", -1101799278, 3524), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setFrameRateMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(66, "org.dsi.ifc.map.DSIMapViewerControl", 1660974799, 1687814400), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setScrollByCrossHairs(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(67, "org.dsi.ifc.map.DSIMapViewerControl", 215660643, -1653679357), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setScrollByCrossHairsBoundingBox(Rect rect) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = rect;
            this.h.invoke(this, LR526b2d74a.gjm(68, "org.dsi.ifc.map.DSIMapViewerControl", -445963411, 1371138611), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRouteColoringPolicy(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(69, "org.dsi.ifc.map.DSIMapViewerControl", 227660647, 1687814400), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWeatherVisualization(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(70, "org.dsi.ifc.map.DSIMapViewerControl", -2029539835, -1653679357), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPictureNavigationIconVisibility(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(71, "org.dsi.ifc.map.DSIMapViewerControl", 1890888584, -1665395196), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMobilityHorizonVisibility(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(72, "org.dsi.ifc.map.DSIMapViewerControl", -719819085, -1653679357), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTrafficMapStyle(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(73, "org.dsi.ifc.map.DSIMapViewerControl", -2060949055, -1653679357), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showSpeedAndFlowFreeFlow(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(74, "org.dsi.ifc.map.DSIMapViewerControl", 1250069133, -1653679357), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showSpeedAndFlowCongestions(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(75, "org.dsi.ifc.map.DSIMapViewerControl", -1498741209, -1653679357), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showRichContent(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(76, "org.dsi.ifc.map.DSIMapViewerControl", 905137959, -1653679357), 76, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setGeneralPoiVisibility(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(77, "org.dsi.ifc.map.DSIMapViewerControl", -336978068, -1653679357), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCrossHairsColor(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(78, "org.dsi.ifc.map.DSIMapViewerControl", 636471302, 1687814400), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setViewPortBorder(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(79, "org.dsi.ifc.map.DSIMapViewerControl", 165156152, 1687814400), 79, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTerrainElevation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(80, "org.dsi.ifc.map.DSIMapViewerControl", -1627032021, -1653679357), 80, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ensurePoiVisibility(NavLocation[] navLocationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocationArray;
            this.h.invoke(this, LR526b2d74a.gjm(81, "org.dsi.ifc.map.DSIMapViewerControl", -754489878, -1941743767), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void suspendMapViewer() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(82, "org.dsi.ifc.map.DSIMapViewerControl", 659826520, 17), 82, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void wakeupMapViewer() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(83, "org.dsi.ifc.map.DSIMapViewerControl", -2074025294, 17), 83, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMobilityHorizonZoomMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(84, "org.dsi.ifc.map.DSIMapViewerControl", 1507965333, 1687814400), 84, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocationWgs84;
            this.h.invoke(this, LR526b2d74a.gjm(85, "org.dsi.ifc.map.DSIMapViewerControl", -183437494, 17850877), 85, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHorizonMarkerVisibility(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(86, "org.dsi.ifc.map.DSIMapViewerControl", 1515864655, -1653679357), 86, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ensureTrafficEventIconsVisibility(long[] lArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = lArray;
            this.h.invoke(this, LR526b2d74a.gjm(87, "org.dsi.ifc.map.DSIMapViewerControl", -964363224, 3524), 87, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMapViewPortByWGS84Rectangle(NavRectangle navRectangle, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navRectangle;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(88, "org.dsi.ifc.map.DSIMapViewerControl", -1672110053, 1159578057), 88, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startRouteDragging(NavLocationWgs84 navLocationWgs84) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocationWgs84;
            this.h.invoke(this, LR526b2d74a.gjm(89, "org.dsi.ifc.map.DSIMapViewerControl", -340296071, 17850877), 89, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dragRoute(short s, short s2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(s2);
            this.h.invoke(this, LR526b2d74a.gjm(90, "org.dsi.ifc.map.DSIMapViewerControl", -357058324, 1359336183), 90, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDragRouteMarker(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(91, "org.dsi.ifc.map.DSIMapViewerControl", -1023934693, 1687814400), 91, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void highlightRouteBasedOnLength(long l, long l2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(92, "org.dsi.ifc.map.DSIMapViewerControl", -131545548, 739712016), 92, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nArray;
            objectArray[2] = blArray;
            this.h.invoke(this, LR526b2d74a.gjm(93, "org.dsi.ifc.map.DSIMapViewerControl", 1154778948, -382972672), 93, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehSetCategoryVisibilityToDefault(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(94, "org.dsi.ifc.map.DSIMapViewerControl", -1407682096, 1687814400), 94, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMapOverlays(int n, MapOverlay[] mapOverlayArray, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = mapOverlayArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR526b2d74a.gjm(95, "org.dsi.ifc.map.DSIMapViewerControl", 1391513190, -1868542303), 95, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMapLayerVisible(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR526b2d74a.gjm(96, "org.dsi.ifc.map.DSIMapViewerControl", 277048502, 3523), 96, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTemperatureScale(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(97, "org.dsi.ifc.map.DSIMapViewerControl", 765168969, 1687814400), 97, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSoftAnimationSpeed(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(98, "org.dsi.ifc.map.DSIMapViewerControl", 1687985398, 1687814400), 98, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSpeedAndFlowRoadClass(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(99, "org.dsi.ifc.map.DSIMapViewerControl", -1387676670, 1687814400), 99, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRouteVisibility(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526b2d74a.gjm(100, "org.dsi.ifc.map.DSIMapViewerControl", -287884491, -1653679357), 100, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVisibleRoutes(NavSegmentID[] navSegmentIDArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navSegmentIDArray;
            this.h.invoke(this, LR526b2d74a.gjm(101, "org.dsi.ifc.map.DSIMapViewerControl", -1879336317, 295822757), 101, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showTrafficEventListView(long[] lArray, boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = lArray;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR526b2d74a.gjm(102, "org.dsi.ifc.map.DSIMapViewerControl", 840945631, -1405998801), 102, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR526b2d74a.gjm(103, "org.dsi.ifc.map.DSIMapViewerControl", -501696838, -904616957), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR526b2d74a.gjm(104, "org.dsi.ifc.map.DSIMapViewerControl", -501696838, 1805755651), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR526b2d74a.gjm(105, "org.dsi.ifc.map.DSIMapViewerControl", -501696838, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR526b2d74a.gjm(106, "org.dsi.ifc.map.DSIMapViewerControl", 1300919239, -904616957), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR526b2d74a.gjm(107, "org.dsi.ifc.map.DSIMapViewerControl", 1300919239, 1805755651), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR526b2d74a.gjm(108, "org.dsi.ifc.map.DSIMapViewerControl", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLanguage(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR526b2d74a.gjm(109, "org.dsi.ifc.map.DSIMapViewerGoogleCtrl", 1328833814, -633848249), 109, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestClearCache() {
        try {
            this.h.invoke(this, LR526b2d74a.gjm(110, "org.dsi.ifc.map.DSIMapViewerGoogleCtrl", -1726277346, 17), 110, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLayerVisibility(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR526b2d74a.gjm(111, "org.dsi.ifc.map.DSIMapViewerGoogleCtrl", -154126698, 3523), 111, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setConnectionInformation(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526b2d74a.gjm(112, "org.dsi.ifc.map.DSIMapViewerGoogleCtrl", -1580290821, 1687814400), 112, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void loadKml(String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = stringArray;
            this.h.invoke(this, LR526b2d74a.gjm(113, "org.dsi.ifc.map.DSIMapViewerGoogleCtrl", -109965292, -1166448617), 113, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCopyrightPosition(Rect rect, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = rect;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526b2d74a.gjm(114, "org.dsi.ifc.map.DSIMapViewerGoogleCtrl", 1129319460, 726513724), 114, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}

