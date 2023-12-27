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
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TrafficSource;

public final class LR54589f17b
extends AbstractProxy
implements DSIMobileEquipmentTopologyListener,
DSITmcListener {
    private static final Method[] JMS = new Method[22];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR54589f17b(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void responseChangeTopology(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(0, "org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener", 1432814863, 1687814400), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTopology(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(1, "org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener", -846714885, -1034208512), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUsage(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(2, "org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener", -848542499, -1034208512), 2, objectArray);
            return;
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
            this.h.invoke(this, LR54589f17b.gjm(3, "org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener", -1459926625, 1276482132), -1, objectArray);
            return;
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
            this.h.invoke(this, LR54589f17b.gjm(4, "org.dsi.ifc.tmc.DSITmcListener", 1575143008, -645498553), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEventsOnRoute(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(5, "org.dsi.ifc.tmc.DSITmcListener", 2110315588, -266965504), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEventsTotal(int n, long l, long l2, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(l2);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR54589f17b.gjm(6, "org.dsi.ifc.tmc.DSITmcListener", -1759818761, 1274089556), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTmcState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR54589f17b.gjm(7, "org.dsi.ifc.tmc.DSITmcListener", 99656825, 1676164096), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateActiveTrafficSources(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(8, "org.dsi.ifc.tmc.DSITmcListener", 2130970850, -1034208512), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIsEngineeringMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(9, "org.dsi.ifc.tmc.DSITmcListener", 2025944187, -1665395196), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIsTmcProAvailable(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(10, "org.dsi.ifc.tmc.DSITmcListener", -393807785, -1665395196), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void windowChange(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(11, "org.dsi.ifc.tmc.DSITmcListener", 891981729, 1687814400), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void tmcWindowResult(int n, int n2, TmcListElement[] tmcListElementArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = tmcListElementArray;
            this.h.invoke(this, LR54589f17b.gjm(12, "org.dsi.ifc.tmc.DSITmcListener", -860596252, 857119746), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMessageFilterResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR54589f17b.gjm(13, "org.dsi.ifc.tmc.DSITmcListener", 254206946, 1676164096), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getMessageIdsForListElementResult(long[] lArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = lArray;
            this.h.invoke(this, LR54589f17b.gjm(14, "org.dsi.ifc.tmc.DSITmcListener", -1367964385, 3524), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navRectangle;
            this.h.invoke(this, LR54589f17b.gjm(15, "org.dsi.ifc.tmc.DSITmcListener", -1488630153, 1188005321), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAreaWarning(AreaWarningInfo areaWarningInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = areaWarningInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(16, "org.dsi.ifc.tmc.DSITmcListener", 997784944, -940610354), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAreaWarnings(AreaWarningInfo[] areaWarningInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = areaWarningInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(17, "org.dsi.ifc.tmc.DSITmcListener", -498749010, 220435470), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = localHazardInformationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(18, "org.dsi.ifc.tmc.DSITmcListener", 769937629, 1172734531), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrafficFlowStatisticsStatus(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(19, "org.dsi.ifc.tmc.DSITmcListener", -857609887, -1665395196), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrafficSourceInformation(TrafficSource[] trafficSourceArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = trafficSourceArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54589f17b.gjm(20, "org.dsi.ifc.tmc.DSITmcListener", -223239612, 1385999773), 20, objectArray);
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

