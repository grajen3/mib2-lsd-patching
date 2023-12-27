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
import org.dsi.ifc.carseat.DSICarSeat;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;
import org.dsi.ifc.carstopwatch.DSICarStopWatch;
import org.dsi.ifc.carstopwatch.StopWatchTime;

public final class LR5bed69dcf
extends AbstractProxy
implements DSICarStopWatch,
DSICarSeat {
    private static final Method[] JMS = new Method[51];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5bed69dcf(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setStopWatchFastestLapTime(StopWatchTime stopWatchTime) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = stopWatchTime;
            this.h.invoke(this, LR5bed69dcf.gjm(0, "org.dsi.ifc.carstopwatch.DSICarStopWatch", -19231454, 1090440731), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setStopWatchLapRating(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5bed69dcf.gjm(1, "org.dsi.ifc.carstopwatch.DSICarStopWatch", 574810410, 1687814400), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setStopWatchLapProgress(float f2) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            this.h.invoke(this, LR5bed69dcf.gjm(2, "org.dsi.ifc.carstopwatch.DSICarStopWatch", -1307673152, -786116603), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setStopWatchLapGPSTrigger() {
        try {
            this.h.invoke(this, LR5bed69dcf.gjm(3, "org.dsi.ifc.carstopwatch.DSICarStopWatch", 867580420, 17), 3, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setStopWatchControl(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5bed69dcf.gjm(4, "org.dsi.ifc.carstopwatch.DSICarStopWatch", -1486261121, 1687814400), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setStopWatchSlowestLapTime(StopWatchTime stopWatchTime) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = stopWatchTime;
            this.h.invoke(this, LR5bed69dcf.gjm(5, "org.dsi.ifc.carstopwatch.DSICarStopWatch", 1675778426, 1090440731), 5, objectArray);
            return;
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
            this.h.invoke(this, LR5bed69dcf.gjm(6, "org.dsi.ifc.carstopwatch.DSICarStopWatch", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5bed69dcf.gjm(7, "org.dsi.ifc.carstopwatch.DSICarStopWatch", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5bed69dcf.gjm(8, "org.dsi.ifc.carstopwatch.DSICarStopWatch", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5bed69dcf.gjm(9, "org.dsi.ifc.carstopwatch.DSICarStopWatch", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5bed69dcf.gjm(10, "org.dsi.ifc.carstopwatch.DSICarStopWatch", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5bed69dcf.gjm(11, "org.dsi.ifc.carstopwatch.DSICarStopWatch", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatRadioKeyAutomatic(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(12, "org.dsi.ifc.carseat.DSICarSeat", -707177553, -1653679357), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatCodriverSettingsFromRear(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(13, "org.dsi.ifc.carseat.DSICarSeat", -2125720836, -1653679357), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatCodriverSettingsFromDriver(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(14, "org.dsi.ifc.carseat.DSICarSeat", 85032745, -1653679357), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatEasyEntryFrontLeft(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(15, "org.dsi.ifc.carseat.DSICarSeat", 2084183150, -1653679357), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatEasyEntryFrontRight(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(16, "org.dsi.ifc.carseat.DSICarSeat", -1859337899, -1653679357), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatEasyEntryRearLeft(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(17, "org.dsi.ifc.carseat.DSICarSeat", 702129401, -1653679357), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatEasyEntryRearRight(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(18, "org.dsi.ifc.carseat.DSICarSeat", -2073867205, -1653679357), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = seatSpecialPosition;
            this.h.invoke(this, LR5bed69dcf.gjm(19, "org.dsi.ifc.carseat.DSICarSeat", -258834493, -1222954748), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = seatSpecialPosition;
            this.h.invoke(this, LR5bed69dcf.gjm(20, "org.dsi.ifc.carseat.DSICarSeat", 141577775, -1222954748), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showSeatPopup(SeatContent seatContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = seatContent;
            this.h.invoke(this, LR5bed69dcf.gjm(21, "org.dsi.ifc.carseat.DSICarSeat", -1627314874, 773523142), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void cancelSeatPopup(SeatContent seatContent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatContent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5bed69dcf.gjm(22, "org.dsi.ifc.carseat.DSICarSeat", -1035277701, 761872838), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatHMIIsReady(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(23, "org.dsi.ifc.carseat.DSICarSeat", 1361173619, -1653679357), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatPneumaticCodriverSettingsFromDriver(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(24, "org.dsi.ifc.carseat.DSICarSeat", 1124097988, -1653679357), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = seatPneumaticContent;
            this.h.invoke(this, LR5bed69dcf.gjm(25, "org.dsi.ifc.carseat.DSICarSeat", -1208679394, 37335402), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void cancelSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seatPneumaticContent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5bed69dcf.gjm(26, "org.dsi.ifc.carseat.DSICarSeat", -196924179, 25685098), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatSetFactoryDefault() {
        try {
            this.h.invoke(this, LR5bed69dcf.gjm(27, "org.dsi.ifc.carseat.DSICarSeat", -2026459614, 17), 27, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatPneumaticSetFactoryDefault() {
        try {
            this.h.invoke(this, LR5bed69dcf.gjm(28, "org.dsi.ifc.carseat.DSICarSeat", -1987506484, 17), 28, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startSeatMoveRearSeatDisplay() {
        try {
            this.h.invoke(this, LR5bed69dcf.gjm(29, "org.dsi.ifc.carseat.DSICarSeat", 378808680, 17), 29, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortSeatMoveRearSeatDisplay() {
        try {
            this.h.invoke(this, LR5bed69dcf.gjm(30, "org.dsi.ifc.carseat.DSICarSeat", -2006079861, 17), 30, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatMassageData(int n, MassageData massageData) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = massageData;
            this.h.invoke(this, LR5bed69dcf.gjm(31, "org.dsi.ifc.carseat.DSICarSeat", 1124507855, 1524843596), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatSwitcherDataUp(int n, SwitcherDataUpDown switcherDataUpDown) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = switcherDataUpDown;
            this.h.invoke(this, LR5bed69dcf.gjm(32, "org.dsi.ifc.carseat.DSICarSeat", 34749548, -2015438104), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatSwitcherDataDown(int n, SwitcherDataUpDown switcherDataUpDown) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = switcherDataUpDown;
            this.h.invoke(this, LR5bed69dcf.gjm(33, "org.dsi.ifc.carseat.DSICarSeat", -1984729523, -2015438104), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatSwitcherDataForward(int n, SwitcherDataBackForward switcherDataBackForward) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = switcherDataBackForward;
            this.h.invoke(this, LR5bed69dcf.gjm(34, "org.dsi.ifc.carseat.DSICarSeat", -2007245747, -262034083), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatSwitcherDataBack(int n, SwitcherDataBackForward switcherDataBackForward) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = switcherDataBackForward;
            this.h.invoke(this, LR5bed69dcf.gjm(35, "org.dsi.ifc.carseat.DSICarSeat", -829199027, -262034083), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatAdjustment(int n, SeatAdjustment seatAdjustment) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = seatAdjustment;
            this.h.invoke(this, LR5bed69dcf.gjm(36, "org.dsi.ifc.carseat.DSICarSeat", -909345899, 1497247981), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startSeatDeleteSpecialPosition(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR5bed69dcf.gjm(37, "org.dsi.ifc.carseat.DSICarSeat", 85140217, -647458158), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatCoDriverSettingsFromRearActivation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(38, "org.dsi.ifc.carseat.DSICarSeat", -678532466, -1653679357), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatFoldHeadRestRearDriver(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(39, "org.dsi.ifc.carseat.DSICarSeat", -1656064540, -1653679357), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatFoldHeadRestRearCoDriver(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(40, "org.dsi.ifc.carseat.DSICarSeat", 692213334, -1653679357), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatStopButton(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(41, "org.dsi.ifc.carseat.DSICarSeat", 812730290, -1600866162), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatPremiumMassageData(int n, MassageData massageData) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = massageData;
            this.h.invoke(this, LR5bed69dcf.gjm(42, "org.dsi.ifc.carseat.DSICarSeat", 1520035804, 1524843596), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatPremiumMassageSwitcher(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(43, "org.dsi.ifc.carseat.DSICarSeat", 291190768, -1600866162), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSeatMassageSwitcher(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5bed69dcf.gjm(44, "org.dsi.ifc.carseat.DSICarSeat", 2049682885, -1600866162), 44, objectArray);
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

