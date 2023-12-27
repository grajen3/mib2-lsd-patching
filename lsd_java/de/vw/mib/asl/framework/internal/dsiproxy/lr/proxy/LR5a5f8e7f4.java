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
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.DSIMapViewerRouteBlock;
import org.dsi.ifc.map.DSIMapViewerStreetViewCtrl;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public final class LR5a5f8e7f4
extends AbstractProxy
implements DSIMapViewerRouteBlock,
DSIMapViewerStreetViewCtrl {
    private static final Method[] JMS = new Method[40];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5a5f8e7f4(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void rBMarkNextSegment() {
        try {
            this.h.invoke(this, LR5a5f8e7f4.gjm(0, "org.dsi.ifc.map.DSIMapViewerRouteBlock", -132283578, 17), 0, ZOA);
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
    public void rBMarkPreviousSegment() {
        try {
            this.h.invoke(this, LR5a5f8e7f4.gjm(1, "org.dsi.ifc.map.DSIMapViewerRouteBlock", -192425359, 17), 1, ZOA);
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
    public void rBSetSegmentScales(long l, long l2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            this.h.invoke(this, LR5a5f8e7f4.gjm(2, "org.dsi.ifc.map.DSIMapViewerRouteBlock", -544190919, 1372686599), 2, objectArray);
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
    public void rBStartOfSelection() {
        try {
            this.h.invoke(this, LR5a5f8e7f4.gjm(3, "org.dsi.ifc.map.DSIMapViewerRouteBlock", 1477204943, 17), 3, ZOA);
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
    public void pickSegmentUidsInScreenSpace(Point point, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = point;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5f8e7f4.gjm(4, "org.dsi.ifc.map.DSIMapViewerRouteBlock", -169833809, 216567625), 4, objectArray);
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
    public void highLightSegmentUidsInMap(long[] lArray, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lArray;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5a5f8e7f4.gjm(5, "org.dsi.ifc.map.DSIMapViewerRouteBlock", -895607944, 571278), 5, objectArray);
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
            this.h.invoke(this, LR5a5f8e7f4.gjm(6, "org.dsi.ifc.map.DSIMapViewerRouteBlock", -501696838, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR5a5f8e7f4.gjm(7, "org.dsi.ifc.map.DSIMapViewerRouteBlock", -501696838, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR5a5f8e7f4.gjm(8, "org.dsi.ifc.map.DSIMapViewerRouteBlock", -501696838, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR5a5f8e7f4.gjm(9, "org.dsi.ifc.map.DSIMapViewerRouteBlock", 1300919239, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR5a5f8e7f4.gjm(10, "org.dsi.ifc.map.DSIMapViewerRouteBlock", 1300919239, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR5a5f8e7f4.gjm(11, "org.dsi.ifc.map.DSIMapViewerRouteBlock", 1300919239, -864245041), -1, objectArray);
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
    public void snapshot() {
        try {
            this.h.invoke(this, LR5a5f8e7f4.gjm(12, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 970521104, 17), 12, ZOA);
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
    public void setPosition(NavLocationWgs84 navLocationWgs84) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocationWgs84;
            this.h.invoke(this, LR5a5f8e7f4.gjm(13, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 540681635, 17850877), 13, objectArray);
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
    public void getInfoForScreenPosition(short s, short s2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(s2);
            this.h.invoke(this, LR5a5f8e7f4.gjm(14, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", -1892141387, 1359336183), 14, objectArray);
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
    public void streetViewEnabled(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5a5f8e7f4.gjm(15, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 1323283499, -1653679357), 15, objectArray);
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
    public void streetViewVisible(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5a5f8e7f4.gjm(16, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 2135193511, -1653679357), 16, objectArray);
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
    public void streetViewFreeze(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5a5f8e7f4.gjm(17, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 1951965740, -1653679357), 17, objectArray);
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
    public void goToView() {
        try {
            this.h.invoke(this, LR5a5f8e7f4.gjm(18, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 1035274321, 17), 18, ZOA);
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
    public void setStreetViewZoomIndex(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5f8e7f4.gjm(19, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 174806847, 1687814400), 19, objectArray);
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
    public void streetViewThumbnails(StreetViewThumbnail[] streetViewThumbnailArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = streetViewThumbnailArray;
            this.h.invoke(this, LR5a5f8e7f4.gjm(20, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", -453587627, 1977223710), 20, objectArray);
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
    public void loadStreetView(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5a5f8e7f4.gjm(21, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 1132583166, -1653679357), 21, objectArray);
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
    public void rotateView(short s, short s2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(s2);
            this.h.invoke(this, LR5a5f8e7f4.gjm(22, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 359223291, 1359336183), 22, objectArray);
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
    public void rotateViewByPolarCoordinates(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5f8e7f4.gjm(23, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", -1984959235, 1676164096), 23, objectArray);
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
    public void setAzimuth(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5f8e7f4.gjm(24, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 523347346, 1687814400), 24, objectArray);
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
    public void setInclination(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5f8e7f4.gjm(25, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", -1792950762, 1687814400), 25, objectArray);
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
    public void setCrossHairsVisibility(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5a5f8e7f4.gjm(26, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 1525712646, -1653679357), 26, objectArray);
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
    public void setDayNightView(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5a5f8e7f4.gjm(27, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", -1732061118, -1653679357), 27, objectArray);
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
    public void setViewRotationByPolarCoordinates(float f2, float f3) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(f3);
            this.h.invoke(this, LR5a5f8e7f4.gjm(28, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 1848643038, -1854609956), 28, objectArray);
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
    public void startViewRotationByPolarCoordinates(float f2, float f3) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(f3);
            this.h.invoke(this, LR5a5f8e7f4.gjm(29, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 1849170133, -1854609956), 29, objectArray);
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
    public void stopViewRotationByPolarCoordinates() {
        try {
            this.h.invoke(this, LR5a5f8e7f4.gjm(30, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 241461711, 17), 30, ZOA);
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
    public void setScreenViewport(Rect rect) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = rect;
            this.h.invoke(this, LR5a5f8e7f4.gjm(31, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", -1456946698, 1371138611), 31, objectArray);
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
    public void setCrossHairsPosition(Point point) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = point;
            this.h.invoke(this, LR5a5f8e7f4.gjm(32, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", 834658017, 228217929), 32, objectArray);
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
    public void setStreetViewZoomLevel(float f2) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            this.h.invoke(this, LR5a5f8e7f4.gjm(33, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrl", -1126335169, -786116603), 33, objectArray);
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

