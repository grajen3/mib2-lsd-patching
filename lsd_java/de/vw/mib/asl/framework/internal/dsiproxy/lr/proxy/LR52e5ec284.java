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
import org.dsi.ifc.map.DSIMapViewerLandmarkPlayerListener;
import org.dsi.ifc.map.DSIMapViewerManeuverViewListener;

public final class LR52e5ec284
extends AbstractProxy
implements DSIMapViewerManeuverViewListener,
DSIMapViewerLandmarkPlayerListener {
    private static final Method[] JMS = new Method[6];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR52e5ec284(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateManoeuvreViewActive(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52e5ec284.gjm(0, "org.dsi.ifc.map.DSIMapViewerManeuverViewListener", 1530236983, 1676164096), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateManoeuvreViewsAvailable(short[] sArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52e5ec284.gjm(1, "org.dsi.ifc.map.DSIMapViewerManeuverViewListener", -882572331, -866436352), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBapExitViewId(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52e5ec284.gjm(2, "org.dsi.ifc.map.DSIMapViewerManeuverViewListener", 2072291805, 1676164096), 2, objectArray);
            return;
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
            this.h.invoke(this, LR52e5ec284.gjm(3, "org.dsi.ifc.map.DSIMapViewerManeuverViewListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showLandmark(float f2) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            this.h.invoke(this, LR52e5ec284.gjm(4, "org.dsi.ifc.map.DSIMapViewerLandmarkPlayerListener", -895493012, -786116603), 4, objectArray);
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

