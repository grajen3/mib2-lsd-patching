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
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navfleetservices.DSINavFleetServicesListener;
import org.dsi.ifc.navigation.BlockElement;
import org.dsi.ifc.navigation.DSIBlockingListener;

public final class LR5f1d6a8ec
extends AbstractProxy
implements DSINavFleetServicesListener,
DSIBlockingListener {
    private static final Method[] JMS = new Method[22];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5f1d6a8ec(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setVZOTrackerStateResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(0, "org.dsi.ifc.navfleetservices.DSINavFleetServicesListener", 1956300746, 1687814400), 0, objectArray);
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
    public void setVZODownloadStateResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(1, "org.dsi.ifc.navfleetservices.DSINavFleetServicesListener", -1306835537, 1687814400), 1, objectArray);
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
    public void setLGITrackerStateResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(2, "org.dsi.ifc.navfleetservices.DSINavFleetServicesListener", -674247607, 1687814400), 2, objectArray);
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
    public void setLGIDownloadStateResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(3, "org.dsi.ifc.navfleetservices.DSINavFleetServicesListener", -1349327344, 1687814400), 3, objectArray);
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
            this.h.invoke(this, LR5f1d6a8ec.gjm(4, "org.dsi.ifc.navfleetservices.DSINavFleetServicesListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateListOfBlocks(BlockElement[] blockElementArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = blockElementArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(5, "org.dsi.ifc.navigation.DSIBlockingListener", -653601381, -1113314609), 5, objectArray);
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
    public void updateNaviCoreAvailableToSetBlocks(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f1d6a8ec.gjm(6, "org.dsi.ifc.navigation.DSIBlockingListener", -1490456409, 1676164096), 6, objectArray);
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
    public void updateMaximumNumberOfBlockedAreas(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f1d6a8ec.gjm(7, "org.dsi.ifc.navigation.DSIBlockingListener", 1189367005, 1676164096), 7, objectArray);
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
    public void updateMaximumNumberOfBlockedRouteSegments(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f1d6a8ec.gjm(8, "org.dsi.ifc.navigation.DSIBlockingListener", -919854247, 1676164096), 8, objectArray);
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
    public void updateMaximumNumberOfBlockedRoadSegments(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f1d6a8ec.gjm(9, "org.dsi.ifc.navigation.DSIBlockingListener", -1433214508, 1676164096), 9, objectArray);
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
    public void updateMaximumDimensionsOfBlockedArea(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5f1d6a8ec.gjm(10, "org.dsi.ifc.navigation.DSIBlockingListener", -743245302, 1043255048), 10, objectArray);
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
    public void updateMaximumSegmentLengthOfBlockedRouteSegment(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f1d6a8ec.gjm(11, "org.dsi.ifc.navigation.DSIBlockingListener", -762011139, 1676164096), 11, objectArray);
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
    public void updateMaximumLengthOfBlockRouteBasedOnLength(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f1d6a8ec.gjm(12, "org.dsi.ifc.navigation.DSIBlockingListener", 1576821744, 1676164096), 12, objectArray);
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
    public void blockAreaResult(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(13, "org.dsi.ifc.navigation.DSIBlockingListener", -331510027, -266965504), 13, objectArray);
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
    public void blockRouteSegmentsResult(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(14, "org.dsi.ifc.navigation.DSIBlockingListener", 782723516, -266965504), 14, objectArray);
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
    public void blockRoadSegmentsResult(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(15, "org.dsi.ifc.navigation.DSIBlockingListener", -9379847, -266965504), 15, objectArray);
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
    public void blockRouteBasedOnLengthResult(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(16, "org.dsi.ifc.navigation.DSIBlockingListener", -836025474, -266965504), 16, objectArray);
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
    public void persistBlockResult(long[] lArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(17, "org.dsi.ifc.navigation.DSIBlockingListener", 190795646, -1017431296), 17, objectArray);
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
    public void deleteBlockResult(long[] lArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(18, "org.dsi.ifc.navigation.DSIBlockingListener", -728363720, -1017431296), 18, objectArray);
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
    public void setBlockDescriptionResult(long[] lArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f1d6a8ec.gjm(19, "org.dsi.ifc.navigation.DSIBlockingListener", -1545096183, -1017431296), 19, objectArray);
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
    public void getBoundingRectangleOfBlocksResult(long[] lArray, NavRectangle navRectangle) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lArray;
            objectArray[1] = navRectangle;
            this.h.invoke(this, LR5f1d6a8ec.gjm(20, "org.dsi.ifc.navigation.DSIBlockingListener", 77755392, 1828738848), 20, objectArray);
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

