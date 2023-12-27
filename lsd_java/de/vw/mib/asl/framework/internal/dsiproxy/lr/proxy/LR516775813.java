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
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.DSITmcOnRouteListener;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.tollcollect.DSITollCollectListener;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public final class LR516775813
extends AbstractProxy
implements DSITmcOnRouteListener,
DSITollCollectListener {
    private static final Method[] JMS = new Method[22];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR516775813(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tmcMessageArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(0, "org.dsi.ifc.tmc.DSITmcOnRouteListener", 1232115185, 2010712203), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUrgentMessages(TmcMessage[] tmcMessageArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tmcMessageArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(1, "org.dsi.ifc.tmc.DSITmcOnRouteListener", 1272649205, 2010712203), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void tmcMessage(TmcMessage tmcMessage) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = tmcMessage;
            this.h.invoke(this, LR516775813.gjm(2, "org.dsi.ifc.tmc.DSITmcOnRouteListener", 310026906, -1666704538), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTmcMessagesAheadCalculationHorizon(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(3, "org.dsi.ifc.tmc.DSITmcOnRouteListener", -81936291, -266965504), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTmcWarningModeResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(4, "org.dsi.ifc.tmc.DSITmcOnRouteListener", 1761788792, 1687814400), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCurrentlyBlockedTMCMessages(long[] lArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(5, "org.dsi.ifc.tmc.DSITmcOnRouteListener", 1010180790, -1017431296), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void blockTMCMessagesResult(long[] lArray, long[] lArray2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lArray;
            objectArray[1] = lArray2;
            this.h.invoke(this, LR516775813.gjm(6, "org.dsi.ifc.tmc.DSITmcOnRouteListener", -1694167121, -1559756288), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unblockTMCMessagesResult(long[] lArray, long[] lArray2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lArray;
            objectArray[1] = lArray2;
            this.h.invoke(this, LR516775813.gjm(7, "org.dsi.ifc.tmc.DSITmcOnRouteListener", 1948980669, -1559756288), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unblockAllTMCMessagesResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(8, "org.dsi.ifc.tmc.DSITmcOnRouteListener", -1154839395, 1687814400), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNaviCoreAvailableToChangeTMCBlockings(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR516775813.gjm(9, "org.dsi.ifc.tmc.DSITmcOnRouteListener", -817368010, 1676164096), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = tmcMessage;
            objectArray[1] = navRectangle;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(10, "org.dsi.ifc.tmc.DSITmcOnRouteListener", -2096718020, 551617679), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSpeedAndFlowAhead(SpeedAndFlowSegment[] speedAndFlowSegmentArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = speedAndFlowSegmentArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(11, "org.dsi.ifc.tmc.DSITmcOnRouteListener", -1345350853, 896829670), 11, objectArray);
            return;
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
            this.h.invoke(this, LR516775813.gjm(12, "org.dsi.ifc.tmc.DSITmcOnRouteListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLanguageResponse(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR516775813.gjm(13, "org.dsi.ifc.tollcollect.DSITollCollectListener", -1338868692, -1653679357), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCardState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR516775813.gjm(14, "org.dsi.ifc.tollcollect.DSITollCollectListener", 226465336, 1676164096), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCardError(TCCardError tCCardError, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tCCardError;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(15, "org.dsi.ifc.tollcollect.DSITollCollectListener", -2071146441, 2029214372), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCardDateInformation(TCCardDateInformation tCCardDateInformation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tCCardDateInformation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(16, "org.dsi.ifc.tollcollect.DSITollCollectListener", 1523776118, 239822588), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHardwareInformation(TCHardwareInformation[] tCHardwareInformationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tCHardwareInformationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(17, "org.dsi.ifc.tollcollect.DSITollCollectListener", 282721924, -262260825), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCurrentTollPayment(NavPriceInfo navPriceInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navPriceInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR516775813.gjm(18, "org.dsi.ifc.tollcollect.DSITollCollectListener", 809764165, 1831678472), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestPaymentHistoryListResult(TCPaymentInfo[] tCPaymentInfoArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = tCPaymentInfoArray;
            this.h.invoke(this, LR516775813.gjm(19, "org.dsi.ifc.tollcollect.DSITollCollectListener", -842754681, 1096472403), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestPaymentHistoryDetailsResult(int n, TCPaymentInfoDetails tCPaymentInfoDetails) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = tCPaymentInfoDetails;
            this.h.invoke(this, LR516775813.gjm(20, "org.dsi.ifc.tollcollect.DSITollCollectListener", 1472620794, -1025628275), 20, objectArray);
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

