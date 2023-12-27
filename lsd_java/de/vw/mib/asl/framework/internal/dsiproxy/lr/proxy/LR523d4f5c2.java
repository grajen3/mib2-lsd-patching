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
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.DSIMapViewerControlListener;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.ViewPort;

public final class LR523d4f5c2
extends AbstractProxy
implements DSIMapViewerControlListener,
DSIMapViewerGoogleCtrlListener {
    private static final Method[] JMS = new Method[77];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR523d4f5c2(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void configureFlags(long[] lArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = lArray;
            this.h.invoke(this, LR523d4f5c2.gjm(0, "org.dsi.ifc.map.DSIMapViewerControlListener", -1233287177, 3524), 0, objectArray);
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
    public void getInfoForPosition(PosInfo[] posInfoArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = posInfoArray;
            this.h.invoke(this, LR523d4f5c2.gjm(1, "org.dsi.ifc.map.DSIMapViewerControlListener", -1011929340, 393196160), 1, objectArray);
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
    public void getNumberOfPOIs(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR523d4f5c2.gjm(2, "org.dsi.ifc.map.DSIMapViewerControlListener", 1960522648, -238538240), 2, objectArray);
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
    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocationWgs84;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR523d4f5c2.gjm(3, "org.dsi.ifc.map.DSIMapViewerControlListener", -183437494, 1024071820), 3, objectArray);
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
    public void setBrandIconStyleResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(4, "org.dsi.ifc.map.DSIMapViewerControlListener", 1696266667, 1687814400), 4, objectArray);
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
    public void updateReady(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(5, "org.dsi.ifc.map.DSIMapViewerControlListener", -808971299, -1665395196), 5, objectArray);
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
    public void updateCurrentViewType(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(6, "org.dsi.ifc.map.DSIMapViewerControlListener", -2068694264, 1676164096), 6, objectArray);
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
    public void updateDayNightView(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(7, "org.dsi.ifc.map.DSIMapViewerControlListener", 2145170545, -1665395196), 7, objectArray);
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
    public void updateViewScreenViewPort(Rect rect, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rect;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(8, "org.dsi.ifc.map.DSIMapViewerControlListener", 1964953076, 1342645812), 8, objectArray);
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
    public void updateViewScreenViewPortMaximum(Rect rect, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rect;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(9, "org.dsi.ifc.map.DSIMapViewerControlListener", 1974734257, 1342645812), 9, objectArray);
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
    public void updateViewVisible(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(10, "org.dsi.ifc.map.DSIMapViewerControlListener", -113028649, -1665395196), 10, objectArray);
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
    public void updateViewFreeze(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(11, "org.dsi.ifc.map.DSIMapViewerControlListener", -1165939410, -1665395196), 11, objectArray);
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
    public void updateZoomLevel(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(12, "org.dsi.ifc.map.DSIMapViewerControlListener", 498027689, -797832442), 12, objectArray);
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
    public void updateZoomList(float[] fArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = fArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(13, "org.dsi.ifc.map.DSIMapViewerControlListener", 1877839464, -1084540160), 13, objectArray);
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
    public void updateZoomListIndex(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(14, "org.dsi.ifc.map.DSIMapViewerControlListener", 1830553533, 1676164096), 14, objectArray);
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
    public void updateMapRotation(short s, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(15, "org.dsi.ifc.map.DSIMapViewerControlListener", -431576688, -254492666), 15, objectArray);
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
    public void updateMapPosition(NavLocationWgs84 navLocationWgs84, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocationWgs84;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(16, "org.dsi.ifc.map.DSIMapViewerControlListener", -1848597825, 6200573), 16, objectArray);
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
    public void updateMapOrientation(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(17, "org.dsi.ifc.map.DSIMapViewerControlListener", 1924805781, 1676164096), 17, objectArray);
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
    public void updateCarPosition(Point point, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = point;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(18, "org.dsi.ifc.map.DSIMapViewerControlListener", 162741271, 216567625), 18, objectArray);
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
    public void updateTmcVisible(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(19, "org.dsi.ifc.map.DSIMapViewerControlListener", 651691313, -1665395196), 19, objectArray);
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
    public void updateMapMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(20, "org.dsi.ifc.map.DSIMapViewerControlListener", -1948077608, 1676164096), 20, objectArray);
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
    public void updateSelectedPoi(PosInfo posInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = posInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(21, "org.dsi.ifc.map.DSIMapViewerControlListener", -1681443383, -1636744121), 21, objectArray);
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
    public void updateSpeedAndFlowVisible(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(22, "org.dsi.ifc.map.DSIMapViewerControlListener", 537933567, -1665395196), 22, objectArray);
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
    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = availableRouteArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(23, "org.dsi.ifc.map.DSIMapViewerControlListener", -540468911, 1183213157), 23, objectArray);
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
    public void updateViewPort(ViewPort viewPort, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = viewPort;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(24, "org.dsi.ifc.map.DSIMapViewerControlListener", 607331195, 853462710), 24, objectArray);
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
    public void updateSoftJumpEnabled(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(25, "org.dsi.ifc.map.DSIMapViewerControlListener", 365669458, -1665395196), 25, objectArray);
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
    public void updateSoftRotationEnabled(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(26, "org.dsi.ifc.map.DSIMapViewerControlListener", 1171771976, -1665395196), 26, objectArray);
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
    public void updateSoftTiltEnabled(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(27, "org.dsi.ifc.map.DSIMapViewerControlListener", -1497535813, -1665395196), 27, objectArray);
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
    public void updateSoftZoomEnabled(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(28, "org.dsi.ifc.map.DSIMapViewerControlListener", -794352424, -1665395196), 28, objectArray);
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
    public void updateSoftJumpRunning(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(29, "org.dsi.ifc.map.DSIMapViewerControlListener", -1823142897, -1665395196), 29, objectArray);
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
    public void updateSoftRotationRunning(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(30, "org.dsi.ifc.map.DSIMapViewerControlListener", -1017040379, -1665395196), 30, objectArray);
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
    public void updateSoftTiltRunning(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(31, "org.dsi.ifc.map.DSIMapViewerControlListener", 608750199, -1665395196), 31, objectArray);
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
    public void updateSoftZoomRunning(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(32, "org.dsi.ifc.map.DSIMapViewerControlListener", 1311933588, -1665395196), 32, objectArray);
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
    public void updateRouteCalcModeEnabled(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(33, "org.dsi.ifc.map.DSIMapViewerControlListener", -563240647, -1665395196), 33, objectArray);
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
    public void updateRBInfoOfSelectedSegments(RouteBrowserInfo routeBrowserInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = routeBrowserInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(34, "org.dsi.ifc.map.DSIMapViewerControlListener", 785115396, 1493684582), 34, objectArray);
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
    public void unpackPOIContainerResult(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR523d4f5c2.gjm(35, "org.dsi.ifc.map.DSIMapViewerControlListener", -1684372041, -1653679357), 35, objectArray);
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
    public void updateCurrentLanduseStyle(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(36, "org.dsi.ifc.map.DSIMapViewerControlListener", 1522677464, 1676164096), 36, objectArray);
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
    public void updateCurrentMetricSystem(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(37, "org.dsi.ifc.map.DSIMapViewerControlListener", 81223615, 1676164096), 37, objectArray);
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
    public void setViewFocusOnBlockResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(38, "org.dsi.ifc.map.DSIMapViewerControlListener", -1347764032, 1687814400), 38, objectArray);
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
    public void startToDrawNewRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = navLocationWgs84;
            objectArray[2] = navLocationWgs842;
            this.h.invoke(this, LR523d4f5c2.gjm(39, "org.dsi.ifc.map.DSIMapViewerControlListener", -1714352359, -2078140517), 39, objectArray);
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
    public void setSouthWestCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = navLocationWgs84;
            this.h.invoke(this, LR523d4f5c2.gjm(40, "org.dsi.ifc.map.DSIMapViewerControlListener", -1593888819, 350750879), 40, objectArray);
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
    public void setNorthEastCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = navLocationWgs84;
            this.h.invoke(this, LR523d4f5c2.gjm(41, "org.dsi.ifc.map.DSIMapViewerControlListener", 637556559, 350750879), 41, objectArray);
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
    public void finishDrawRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = navLocationWgs84;
            objectArray[2] = navLocationWgs842;
            this.h.invoke(this, LR523d4f5c2.gjm(42, "org.dsi.ifc.map.DSIMapViewerControlListener", -1853761243, -2078140517), 42, objectArray);
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
    public void updateCityModelMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(43, "org.dsi.ifc.map.DSIMapViewerControlListener", 1831031887, 1676164096), 43, objectArray);
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
    public void displayRemainingRangeOfVehicleResult(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR523d4f5c2.gjm(44, "org.dsi.ifc.map.DSIMapViewerControlListener", -1095083736, -1653679357), 44, objectArray);
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
    public void touchApproachResult(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR523d4f5c2.gjm(45, "org.dsi.ifc.map.DSIMapViewerControlListener", 2030169273, -1653679357), 45, objectArray);
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
    public void setGuidanceSymbolResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(46, "org.dsi.ifc.map.DSIMapViewerControlListener", 1149365651, 1687814400), 46, objectArray);
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
    public void setHOVLaneVisibilityResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(47, "org.dsi.ifc.map.DSIMapViewerControlListener", 2102793016, 1687814400), 47, objectArray);
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
    public void rbGetIDOfSelectedSegmentResult(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(48, "org.dsi.ifc.map.DSIMapViewerControlListener", 1384852816, -266965504), 48, objectArray);
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
    public void rbGetRRDToSelectedSegmentResult(long l, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(49, "org.dsi.ifc.map.DSIMapViewerControlListener", -235577758, -883163127), 49, objectArray);
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
    public void setTollRoadHighLightingResult(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(50, "org.dsi.ifc.map.DSIMapViewerControlListener", 1573118674, -1665395196), 50, objectArray);
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
    public void setMountainPeakMarkerResult(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(51, "org.dsi.ifc.map.DSIMapViewerControlListener", 438697015, -1665395196), 51, objectArray);
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
    public void suspendMapViewerResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(52, "org.dsi.ifc.map.DSIMapViewerControlListener", -461738351, 1687814400), 52, objectArray);
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
    public void wakeupMapViewerResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(53, "org.dsi.ifc.map.DSIMapViewerControlListener", -2129832778, 1687814400), 53, objectArray);
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
    public void updateMapViewerRunLevel(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(54, "org.dsi.ifc.map.DSIMapViewerControlListener", 329900491, 1676164096), 54, objectArray);
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
    public void updateMapViewerSuspensionSupported(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(55, "org.dsi.ifc.map.DSIMapViewerControlListener", -1043922790, 1676164096), 55, objectArray);
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
    public void updateMapViewerSuspensionAndWakeUpProgress(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(56, "org.dsi.ifc.map.DSIMapViewerControlListener", 1985035688, 1676164096), 56, objectArray);
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
    public void updateAvailableCountryOverviews(String[] stringArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(57, "org.dsi.ifc.map.DSIMapViewerControlListener", -1187179835, -1178098921), 57, objectArray);
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
    public void updateGeneralPoiVisibility(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(58, "org.dsi.ifc.map.DSIMapViewerControlListener", -768765065, -1665395196), 58, objectArray);
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
    public void updateHorizonMarkerVisibility(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(59, "org.dsi.ifc.map.DSIMapViewerControlListener", 333076681, -1665395196), 59, objectArray);
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
    public void updateDragRoutePosition(NavLocationWgs84 navLocationWgs84, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocationWgs84;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(60, "org.dsi.ifc.map.DSIMapViewerControlListener", 1778560295, 6200573), 60, objectArray);
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
    public void updateEhCategoryVisibility(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(61, "org.dsi.ifc.map.DSIMapViewerControlListener", -1852989230, -1034208512), 61, objectArray);
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
    public void setMapOverlaysResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(62, "org.dsi.ifc.map.DSIMapViewerControlListener", -821387787, 1676164096), 62, objectArray);
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
    public void updateMapLayerAvailable(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(63, "org.dsi.ifc.map.DSIMapViewerControlListener", -1598721248, -1034208512), 63, objectArray);
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
    public void updateMapLayerVisible(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(64, "org.dsi.ifc.map.DSIMapViewerControlListener", -909388075, -1034208512), 64, objectArray);
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
    public void updateTemperatureScale(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(65, "org.dsi.ifc.map.DSIMapViewerControlListener", -1805030377, 1676164096), 65, objectArray);
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
    public void updateSpeedAndFlowRoadClass(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(66, "org.dsi.ifc.map.DSIMapViewerControlListener", -1503415963, 1676164096), 66, objectArray);
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
    public void updateRouteVisibility(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(67, "org.dsi.ifc.map.DSIMapViewerControlListener", -1491032492, -1665395196), 67, objectArray);
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
    public void updateSoftAnimationSpeed(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(68, "org.dsi.ifc.map.DSIMapViewerControlListener", 191693256, 1676164096), 68, objectArray);
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
    public void asyncException(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(69, "org.dsi.ifc.map.DSIMapViewerControlListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateAvailableLayers(LayerProperty[] layerPropertyArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = layerPropertyArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(70, "org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener", -687400634, -1299105535), 70, objectArray);
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
    public void updateVisibleLayers(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(71, "org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener", -2141437659, -1034208512), 71, objectArray);
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
    public void updateAvailableLanguages(String[] stringArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(72, "org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener", 1882612247, -1178098921), 72, objectArray);
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
    public void updateCurrentLanguage(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR523d4f5c2.gjm(73, "org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener", 1575143008, -645498553), 73, objectArray);
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
    public void updateGoogleDataStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR523d4f5c2.gjm(74, "org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener", -1290240649, 1676164096), 74, objectArray);
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
    public void updateCopyrightPosition(Rect rect, int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = rect;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR523d4f5c2.gjm(75, "org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener", -1135737070, -765076359), 75, objectArray);
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

