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
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;
import org.dsi.ifc.komoview.DSIKOMOView;
import org.dsi.ifc.komoview.RouteInfoElement;

public final class LR51d51f8b3
extends AbstractProxy
implements DSIKOMOView,
DSIKOMONavInfo {
    private static final Method[] JMS = new Method[30];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR51d51f8b3(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void enableKomoView(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR51d51f8b3.gjm(0, "org.dsi.ifc.komoview.DSIKOMOView", -471419601, -1653679357), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void notifyVisibility(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR51d51f8b3.gjm(1, "org.dsi.ifc.komoview.DSIKOMOView", -1341032854, -1653679357), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRouteInfoElement(RouteInfoElement routeInfoElement) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = routeInfoElement;
            this.h.invoke(this, LR51d51f8b3.gjm(2, "org.dsi.ifc.komoview.DSIKOMOView", 1546618774, 399416174), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRouteInfo(RouteInfoElement[] routeInfoElementArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = routeInfoElementArray;
            this.h.invoke(this, LR51d51f8b3.gjm(3, "org.dsi.ifc.komoview.DSIKOMOView", -898450843, -541996280), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setKomoViewStyle(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR51d51f8b3.gjm(4, "org.dsi.ifc.komoview.DSIKOMOView", -643088447, 1687814400), 4, objectArray);
            return;
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
            this.h.invoke(this, LR51d51f8b3.gjm(5, "org.dsi.ifc.komoview.DSIKOMOView", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR51d51f8b3.gjm(6, "org.dsi.ifc.komoview.DSIKOMOView", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR51d51f8b3.gjm(7, "org.dsi.ifc.komoview.DSIKOMOView", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR51d51f8b3.gjm(8, "org.dsi.ifc.komoview.DSIKOMOView", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR51d51f8b3.gjm(9, "org.dsi.ifc.komoview.DSIKOMOView", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR51d51f8b3.gjm(10, "org.dsi.ifc.komoview.DSIKOMOView", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDistanceToNextManeuver(long l, int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR51d51f8b3.gjm(11, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", -745929792, -1673404256), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setETA(int n, short s, short s2, short s3, boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(s);
            objectArray[2] = RuntimeUtil.valueOf(s2);
            objectArray[3] = RuntimeUtil.valueOf(s3);
            objectArray[4] = RuntimeUtil.valueOf(bl);
            objectArray[5] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR51d51f8b3.gjm(12, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", 1163920074, 1284528019), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCurrentStreet(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR51d51f8b3.gjm(13, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", 258010325, -633848249), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTurnToStreet(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR51d51f8b3.gjm(14, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", -219591624, -412271469), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCityName(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR51d51f8b3.gjm(15, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", -1921264351, -633848249), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDistanceToDestination(long l, int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR51d51f8b3.gjm(16, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", -778887873, -1673404256), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSemiDynRoute(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR51d51f8b3.gjm(17, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", -707483402, -1653679357), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTrafficOffset(int n, short s, short s2, short s3, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(s);
            objectArray[2] = RuntimeUtil.valueOf(s2);
            objectArray[3] = RuntimeUtil.valueOf(s3);
            objectArray[4] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR51d51f8b3.gjm(18, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", 593944640, -799149515), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRTT(short s, short s2, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(s2);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR51d51f8b3.gjm(19, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", 630260426, -47233896), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRgSelect(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR51d51f8b3.gjm(20, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", -2003509612, 1687814400), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCapabilities(boolean[] blArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = blArray;
            this.h.invoke(this, LR51d51f8b3.gjm(21, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", -1382051778, 3540), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMapScale(int n, int n2, boolean[] blArray, int n3, int n4, int n5) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = blArray;
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = RuntimeUtil.valueOf(n4);
            objectArray[5] = RuntimeUtil.valueOf(n5);
            this.h.invoke(this, LR51d51f8b3.gjm(22, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", 1158581888, 134146313), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMapScaleResult(int n, int n2, boolean[] blArray, int n3, int n4, boolean[] blArray2, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(7);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = blArray;
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = RuntimeUtil.valueOf(n4);
            objectArray[5] = blArray2;
            objectArray[6] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR51d51f8b3.gjm(23, "org.dsi.ifc.komonavinfo.DSIKOMONavInfo", -2103026481, 599185780), 23, objectArray);
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

