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
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.BapManeuverDescriptor;
import org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener;
import org.dsi.ifc.navservicesapi.DSINavAsiaMapControlListener;
import org.dsi.ifc.navservicesapi.LDListElement;
import org.dsi.ifc.navservicesapi.NavLaneGuidanceData;
import org.dsi.ifc.navservicesapi.TrafficInfo;

public final class LR5a50a0ba2
extends AbstractProxy
implements DSINavAsiaBAPClusterInstrumentListener,
DSINavAsiaMapControlListener {
    private static final Method[] JMS = new Method[31];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5a50a0ba2(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateCompassInfo(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5a50a0ba2.gjm(0, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -863571291, 1043255048), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDistanceToNextManeuver(int n, int n2, boolean bl, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR5a50a0ba2.gjm(1, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -89148997, -642053452), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmLastDestinationsGetResult(int n, AddressData[] addressDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = addressDataArray;
            this.h.invoke(this, LR5a50a0ba2.gjm(2, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", 1687157326, -1626327342), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRGStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(3, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -974376778, 1676164096), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCurrentPositionInfo(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(4, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", 2084363871, -645498553), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTurnToInfo(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(5, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -990063686, -1028403557), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDistanceToDestination(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5a50a0ba2.gjm(6, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -894627166, 1043255048), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNavigationTimeInfoType(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(7, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -954919273, 1676164096), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRTT(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(8, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", 1583862155, -266965504), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateETA(int n, long l, boolean bl, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(9, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", 2117521803, 401010404), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCityName(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(10, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -190832417, -645498553), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSemiDynRoute(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(11, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -1125219291, -1665395196), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrafficOffset(int n, short s, short s2, short s3, boolean bl, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(s);
            objectArray[2] = RuntimeUtil.valueOf(s2);
            objectArray[3] = RuntimeUtil.valueOf(s3);
            objectArray[4] = RuntimeUtil.valueOf(bl);
            objectArray[5] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(12, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", 478775277, -550307285), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bapManeuverDescriptorArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(13, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", 1175162090, 1956540882), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLaneGuidance(boolean bl, NavLaneGuidanceData[] navLaneGuidanceDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = navLaneGuidanceDataArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(14, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", 1121961883, -1263650931), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrafficInformation(TrafficInfo[] trafficInfoArray, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = trafficInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(15, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", 226684003, -575291835), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDMLastDestinationsList(LDListElement[] lDListElementArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lDListElementArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(16, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -1059078256, 662227646), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void routeGuidanceActDeactResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(17, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -1837296300, 1687814400), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void repeatLastNavAnnouncementResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(18, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -340646603, 1687814400), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNavAnnouncementState(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(19, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -2054329057, -1665395196), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVoiceGuidanceState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(20, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", 625467281, 1676164096), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateInfoStates(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(21, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", 1859436930, 1676164096), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setActiveRGTypeResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(22, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -1981524864, 1687814400), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrafficBlockIndication(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(23, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -1426565655, 1676164096), 23, objectArray);
            return;
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
            this.h.invoke(this, LR5a50a0ba2.gjm(24, "org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDataRate(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(25, "org.dsi.ifc.navservicesapi.DSINavAsiaMapControlListener", 143818654, 1676164096), 25, objectArray);
            return;
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
            this.h.invoke(this, LR5a50a0ba2.gjm(26, "org.dsi.ifc.navservicesapi.DSINavAsiaMapControlListener", 498027689, -797832442), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRecommendedZoom(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a50a0ba2.gjm(27, "org.dsi.ifc.navservicesapi.DSINavAsiaMapControlListener", 981984723, -797832442), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMapStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(28, "org.dsi.ifc.navservicesapi.DSINavAsiaMapControlListener", 447233150, 1676164096), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateViewType(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a50a0ba2.gjm(29, "org.dsi.ifc.navservicesapi.DSINavAsiaMapControlListener", -584505989, 1676164096), 29, objectArray);
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

