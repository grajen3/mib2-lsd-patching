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
import org.dsi.ifc.carseat.DSICarSeatListener;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.RestSeatStatus;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;
import org.dsi.ifc.carstopwatch.DSICarStopWatchListener;
import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;

public final class LR5d7f7c1af
extends AbstractProxy
implements DSICarSeatListener,
DSICarStopWatchListener {
    private static final Method[] JMS = new Method[85];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5d7f7c1af(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateSeatViewOptions(SeatViewOptions seatViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(0, "org.dsi.ifc.carseat.DSICarSeatListener", 1620784809, -307957125), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatRadioKeyAutomatic(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(1, "org.dsi.ifc.carseat.DSICarSeatListener", -822917102, -1665395196), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatSpecialPosition;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(2, "org.dsi.ifc.carseat.DSICarSeatListener", 702002206, -1234605052), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatSpecialPosition;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(3, "org.dsi.ifc.carseat.DSICarSeatListener", -1054414261, -1234605052), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatFrontLeftStopButton(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(4, "org.dsi.ifc.carseat.DSICarSeatListener", -346533473, -1665395196), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatFrontRightStopButton(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(5, "org.dsi.ifc.carseat.DSICarSeatListener", -1434352933, -1665395196), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatRearLeftStopButton(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(6, "org.dsi.ifc.carseat.DSICarSeatListener", -2104110094, -1665395196), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatRearRightStopButton(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(7, "org.dsi.ifc.carseat.DSICarSeatListener", -203995144, -1665395196), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatCodriverSettingsFromDriver(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(8, "org.dsi.ifc.carseat.DSICarSeatListener", 740271377, -1665395196), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatCodriverSettingsFromRear(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(9, "org.dsi.ifc.carseat.DSICarSeatListener", 1756947282, -1665395196), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatMassageData1RL(MassageData massageData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = massageData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(10, "org.dsi.ifc.carseat.DSICarSeatListener", -1185513377, 1317957025), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatMassageData1RR(MassageData massageData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = massageData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(11, "org.dsi.ifc.carseat.DSICarSeatListener", -1084850081, 1317957025), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatMassageData2RL(MassageData massageData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = massageData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(12, "org.dsi.ifc.carseat.DSICarSeatListener", 2052751455, 1317957025), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatMassageData2RR(MassageData massageData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = massageData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(13, "org.dsi.ifc.carseat.DSICarSeatListener", -2141552545, 1317957025), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(14, "org.dsi.ifc.carseat.DSICarSeatListener", -326677564, -1224039854), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(15, "org.dsi.ifc.carseat.DSICarSeatListener", -989173666, -1224039854), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(16, "org.dsi.ifc.carseat.DSICarSeatListener", 1420319549, -1393824524), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(17, "org.dsi.ifc.carseat.DSICarSeatListener", 1619565787, -1393824524), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(18, "org.dsi.ifc.carseat.DSICarSeatListener", -226014268, -1224039854), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(19, "org.dsi.ifc.carseat.DSICarSeatListener", -888510370, -1224039854), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(20, "org.dsi.ifc.carseat.DSICarSeatListener", 1520982845, -1393824524), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(21, "org.dsi.ifc.carseat.DSICarSeatListener", 1720229083, -1393824524), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataUp2RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(22, "org.dsi.ifc.carseat.DSICarSeatListener", -1383380028, -1224039854), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataDown2RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(23, "org.dsi.ifc.carseat.DSICarSeatListener", -2045876130, -1224039854), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataForward2RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(24, "org.dsi.ifc.carseat.DSICarSeatListener", 363617085, -1393824524), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataBack2RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(25, "org.dsi.ifc.carseat.DSICarSeatListener", 562863323, -1393824524), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataUp2RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(26, "org.dsi.ifc.carseat.DSICarSeatListener", -1282716732, -1224039854), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataDown2RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(27, "org.dsi.ifc.carseat.DSICarSeatListener", -1945212834, -1224039854), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataForward2RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(28, "org.dsi.ifc.carseat.DSICarSeatListener", 464280381, -1393824524), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatSwitcherDataBack2RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(29, "org.dsi.ifc.carseat.DSICarSeatListener", 663526619, -1393824524), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatContent(SeatContent seatContent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatContent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(30, "org.dsi.ifc.carseat.DSICarSeatListener", -1603752485, 761872838), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatEasyEntryFrontLeft(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(31, "org.dsi.ifc.carseat.DSICarSeatListener", -1554003351, -1665395196), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatEasyEntryFrontRight(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(32, "org.dsi.ifc.carseat.DSICarSeatListener", 1252841423, -1665395196), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatEasyEntryRearLeft(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(33, "org.dsi.ifc.carseat.DSICarSeatListener", 586389852, -1665395196), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatEasyEntryRearRight(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(34, "org.dsi.ifc.carseat.DSICarSeatListener", -1417086410, -1665395196), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestSeatPopup(SeatContent seatContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = seatContent;
            this.h.invoke(this, LR5d7f7c1af.gjm(35, "org.dsi.ifc.carseat.DSICarSeatListener", 1296971804, 773523142), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeSeatPopup(SeatContent seatContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = seatContent;
            this.h.invoke(this, LR5d7f7c1af.gjm(36, "org.dsi.ifc.carseat.DSICarSeatListener", -534978493, 773523142), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticViewOptions(SeatPneumaticViewOptions seatPneumaticViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatPneumaticViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(37, "org.dsi.ifc.carseat.DSICarSeatListener", -1878632109, -1044876681), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticCodriverSettingsFromDriver(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(38, "org.dsi.ifc.carseat.DSICarSeatListener", -51554078, -1665395196), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticMassageData1RL(MassageData massageData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = massageData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(39, "org.dsi.ifc.carseat.DSICarSeatListener", -1981950182, 1317957025), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticMassageData1RR(MassageData massageData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = massageData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(40, "org.dsi.ifc.carseat.DSICarSeatListener", -1881286886, 1317957025), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(41, "org.dsi.ifc.carseat.DSICarSeatListener", 483384562, -1224039854), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(42, "org.dsi.ifc.carseat.DSICarSeatListener", -179977171, -1224039854), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(43, "org.dsi.ifc.carseat.DSICarSeatListener", 610232315, -1393824524), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(44, "org.dsi.ifc.carseat.DSICarSeatListener", -1866205014, -1393824524), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(45, "org.dsi.ifc.carseat.DSICarSeatListener", 584047858, -1224039854), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataUpDown;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(46, "org.dsi.ifc.carseat.DSICarSeatListener", -79313875, -1224039854), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(47, "org.dsi.ifc.carseat.DSICarSeatListener", 710895611, -1393824524), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = switcherDataBackForward;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(48, "org.dsi.ifc.carseat.DSICarSeatListener", -1765541718, -1393824524), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPneumaticContent(SeatPneumaticContent seatPneumaticContent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatPneumaticContent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(49, "org.dsi.ifc.carseat.DSICarSeatListener", -789863264, 25685098), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = seatPneumaticContent;
            this.h.invoke(this, LR5d7f7c1af.gjm(50, "org.dsi.ifc.carseat.DSICarSeatListener", -921906620, 37335402), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = seatPneumaticContent;
            this.h.invoke(this, LR5d7f7c1af.gjm(51, "org.dsi.ifc.carseat.DSICarSeatListener", -1762443992, 37335402), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeSeatSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5d7f7c1af.gjm(52, "org.dsi.ifc.carseat.DSICarSeatListener", -1927806776, -1653679357), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeSeatPneumaticSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5d7f7c1af.gjm(53, "org.dsi.ifc.carseat.DSICarSeatListener", 1133409057, -1653679357), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeSeatDeleteSpecialPosition(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5d7f7c1af.gjm(54, "org.dsi.ifc.carseat.DSICarSeatListener", 193648638, -1653679357), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeSeatMoveRearSeatDisplay(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5d7f7c1af.gjm(55, "org.dsi.ifc.carseat.DSICarSeatListener", -1676362428, -1653679357), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatAdjustment1RL(SeatAdjustment seatAdjustment, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatAdjustment;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(56, "org.dsi.ifc.carseat.DSICarSeatListener", 1172871550, -1577990491), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatAdjustment1RR(SeatAdjustment seatAdjustment, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatAdjustment;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(57, "org.dsi.ifc.carseat.DSICarSeatListener", 1273534846, -1577990491), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatAdjustment2RL(SeatAdjustment seatAdjustment, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatAdjustment;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(58, "org.dsi.ifc.carseat.DSICarSeatListener", 116169086, -1577990491), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatAdjustment2RR(SeatAdjustment seatAdjustment, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatAdjustment;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(59, "org.dsi.ifc.carseat.DSICarSeatListener", 216832382, -1577990491), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatCoDriverSettingsFromRearActivation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(60, "org.dsi.ifc.carseat.DSICarSeatListener", -24834235, -1665395196), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatRestSeatStatus(RestSeatStatus restSeatStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = restSeatStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(61, "org.dsi.ifc.carseat.DSICarSeatListener", -829031226, -1710398211), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatFoldHeadRestRearDriver(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(62, "org.dsi.ifc.carseat.DSICarSeatListener", 1149546084, -1665395196), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatFoldHeadRestRearCoDriver(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(63, "org.dsi.ifc.carseat.DSICarSeatListener", 279848877, -1665395196), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPremiumMassageData1RL(MassageData massageData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = massageData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(64, "org.dsi.ifc.carseat.DSICarSeatListener", 352175672, 1317957025), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPremiumMassageData1RR(MassageData massageData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = massageData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(65, "org.dsi.ifc.carseat.DSICarSeatListener", 452838968, 1317957025), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPremiumMassageData2RL(MassageData massageData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = massageData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(66, "org.dsi.ifc.carseat.DSICarSeatListener", -721369288, 1317957025), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPremiumMassageData2RR(MassageData massageData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = massageData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(67, "org.dsi.ifc.carseat.DSICarSeatListener", -620705992, 1317957025), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPremiumMassageSwitcher1RL(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(68, "org.dsi.ifc.carseat.DSICarSeatListener", 2103905724, -1665395196), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPremiumMassageSwitcher1RR(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(69, "org.dsi.ifc.carseat.DSICarSeatListener", -2090398276, -1665395196), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPremiumMassageSwitcher2RL(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(70, "org.dsi.ifc.carseat.DSICarSeatListener", 1047203260, -1665395196), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatPremiumMassageSwitcher2RR(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(71, "org.dsi.ifc.carseat.DSICarSeatListener", 1147866556, -1665395196), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatMassageSwitcher1RL(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(72, "org.dsi.ifc.carseat.DSICarSeatListener", -1570338867, -1665395196), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatMassageSwitcher1RR(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(73, "org.dsi.ifc.carseat.DSICarSeatListener", -1469675571, -1665395196), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatMassageSwitcher2RL(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(74, "org.dsi.ifc.carseat.DSICarSeatListener", 1667925965, -1665395196), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSeatMassageSwitcher2RR(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(75, "org.dsi.ifc.carseat.DSICarSeatListener", 1768589261, -1665395196), 75, objectArray);
            return;
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
            this.h.invoke(this, LR5d7f7c1af.gjm(76, "org.dsi.ifc.carseat.DSICarSeatListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStopWatchViewOptions(StopWatchViewOptions stopWatchViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stopWatchViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(77, "org.dsi.ifc.carstopwatch.DSICarStopWatchListener", -354126470, -272796491), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStopWatchState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d7f7c1af.gjm(78, "org.dsi.ifc.carstopwatch.DSICarStopWatchListener", 1115034899, 1676164096), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStopWatchCurrentLapNumber(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d7f7c1af.gjm(79, "org.dsi.ifc.carstopwatch.DSICarStopWatchListener", 79261364, 1676164096), 79, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStopWatchTotalTime(StopWatchTime stopWatchTime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stopWatchTime;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(80, "org.dsi.ifc.carstopwatch.DSICarStopWatchListener", -502038470, 1061947932), 80, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStopWatchLastSplitTime(int n, StopWatchTime stopWatchTime, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = stopWatchTime;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d7f7c1af.gjm(81, "org.dsi.ifc.carstopwatch.DSICarStopWatchListener", -1030710505, 178093581), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStopWatchCurrentLapTime(StopWatchTime stopWatchTime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stopWatchTime;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(82, "org.dsi.ifc.carstopwatch.DSICarStopWatchListener", 139097730, 1061947932), 82, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStopWatchLastLapTime(StopWatchTime stopWatchTime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stopWatchTime;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d7f7c1af.gjm(83, "org.dsi.ifc.carstopwatch.DSICarStopWatchListener", 1133037618, 1061947932), 83, objectArray);
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

