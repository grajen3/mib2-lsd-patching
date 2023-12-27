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
import org.dsi.ifc.map.DSIMapViewerRouteBlockListener;
import org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.StreetViewThumbnail;

public final class LR5fa9f2e50
extends AbstractProxy
implements DSIMapViewerStreetViewCtrlListener,
DSIMapViewerRouteBlockListener {
    private static final Method[] JMS = new Method[23];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5fa9f2e50(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void getInfoForPosition(PosInfo[] posInfoArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = posInfoArray;
            this.h.invoke(this, LR5fa9f2e50.gjm(0, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", -1011929340, 393196160), 0, objectArray);
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
            this.h.invoke(this, LR5fa9f2e50.gjm(1, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", 1323283499, -1653679357), 1, objectArray);
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
            this.h.invoke(this, LR5fa9f2e50.gjm(2, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", 2135193511, -1653679357), 2, objectArray);
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
            this.h.invoke(this, LR5fa9f2e50.gjm(3, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", 1951965740, -1653679357), 3, objectArray);
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
    public void updateStreetViewLoadStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fa9f2e50.gjm(4, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", -1105985310, 1676164096), 4, objectArray);
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
    public void updateStreetViewAvailable(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(5, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", 1304003085, -1665395196), 5, objectArray);
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
    public void updateStreetViewZoomListIndex(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fa9f2e50.gjm(6, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", 1164167389, 1676164096), 6, objectArray);
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
    public void updateStreetViewZoomList(float[] fArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = fArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(7, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", -1749048679, -1084540160), 7, objectArray);
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
    public void updateStreetViewThumbnails(StreetViewThumbnail[] streetViewThumbnailArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = streetViewThumbnailArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(8, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", 1294295177, 1948796446), 8, objectArray);
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
    public void updatePosition(NavLocationWgs84 navLocationWgs84, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocationWgs84;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(9, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", -2023788448, 6200573), 9, objectArray);
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
    public void updateRotation(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5fa9f2e50.gjm(10, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", -589990351, 1043255048), 10, objectArray);
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
    public void snapshotResult(StreetViewThumbnail streetViewThumbnail, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = streetViewThumbnail;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(11, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", 1982447502, 120771), 11, objectArray);
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
    public void updateScreenViewPort(Rect rect, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rect;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(12, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", -254218274, 1342645812), 12, objectArray);
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
    public void updateStreetViewZoomLevel(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(13, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", -182340710, -797832442), 13, objectArray);
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
    public void updateStreetViewPosition(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = navLocationWgs84;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(14, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", -1355709295, 407939732), 14, objectArray);
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
            this.h.invoke(this, LR5fa9f2e50.gjm(15, "org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener", -1459926625, 1276482132), -1, objectArray);
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
            this.h.invoke(this, LR5fa9f2e50.gjm(16, "org.dsi.ifc.map.DSIMapViewerRouteBlockListener", 785115396, 1493684582), 16, objectArray);
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
    public void pickSegmentUidsInScreenSpaceResult(Point point, int n, long[] lArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = point;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = lArray;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fa9f2e50.gjm(17, "org.dsi.ifc.map.DSIMapViewerRouteBlockListener", 850738188, -297599610), 17, objectArray);
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
    public void highLightSegmentUidsInMapResult(long[] lArray, boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = lArray;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(18, "org.dsi.ifc.map.DSIMapViewerRouteBlockListener", 1207900710, -615691881), 18, objectArray);
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
    public void rBStartOfSelectionResult(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(19, "org.dsi.ifc.map.DSIMapViewerRouteBlockListener", 1435109681, -266965504), 19, objectArray);
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
    public void rBMarkNextSegmentResult(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(20, "org.dsi.ifc.map.DSIMapViewerRouteBlockListener", -169671420, -266965504), 20, objectArray);
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
    public void rBMarkPreviousSegmentResult(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fa9f2e50.gjm(21, "org.dsi.ifc.map.DSIMapViewerRouteBlockListener", -236976967, -266965504), 21, objectArray);
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

