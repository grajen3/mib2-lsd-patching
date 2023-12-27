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
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;

public final class LR57d6f3a85
extends AbstractProxy
implements DSICarTimeUnitsLanguage,
DSICarVehicleStates {
    private static final Method[] JMS = new Method[34];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR57d6f3a85(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setMenuLanguage(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(0, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -825385990, 1687814400), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPressureUnit(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(1, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 1615406046, 1687814400), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVolumeUnit(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(2, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 891345855, 1687814400), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTemperatureUnit(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(3, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -878312041, 1687814400), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDistanceUnit(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(4, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 275207260, 1687814400), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSpeedUnit(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(5, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -1643717639, 1687814400), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setConsumptionPetrolUnit(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(6, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 586619590, 1687814400), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setConsumptionGasUnit(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(7, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 1495187974, 1687814400), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setConsumptionElectricUnit(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(8, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 791922638, 1687814400), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setClockFormat(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(9, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 1488611363, 1687814400), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDateFormat(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(10, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -1126062811, 1687814400), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setClockDate(ClockDate clockDate) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = clockDate;
            this.h.invoke(this, LR57d6f3a85.gjm(11, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 264109603, 262394267), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setClockTime(byte by, byte by2, byte by3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(by);
            objectArray[1] = RuntimeUtil.valueOf(by2);
            objectArray[2] = RuntimeUtil.valueOf(by3);
            this.h.invoke(this, LR57d6f3a85.gjm(12, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 773850660, -1519454978), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setClockSource(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(13, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 2083166521, 1687814400), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setClockDayLightSaving(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57d6f3a85.gjm(14, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -720586066, -1653679357), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setClockTimeZoneOffset(float f2) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            this.h.invoke(this, LR57d6f3a85.gjm(15, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 1844230927, -786116603), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setClockGPSSyncData(ClockGPSSyncData clockGPSSyncData) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = clockGPSSyncData;
            this.h.invoke(this, LR57d6f3a85.gjm(16, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -1196060169, -1206923075), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setClockSummerTimeData(ClockSummerTimeData clockSummerTimeData) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = clockSummerTimeData;
            this.h.invoke(this, LR57d6f3a85.gjm(17, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 1193536440, 1200215690), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUmSetFactoryDefault() {
        try {
            this.h.invoke(this, LR57d6f3a85.gjm(18, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -723179885, 17), 18, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSkin(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(19, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 1947684982, 1687814400), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWeightUnit(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d6f3a85.gjm(20, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -1818457915, 1687814400), 20, objectArray);
            return;
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
            this.h.invoke(this, LR57d6f3a85.gjm(21, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR57d6f3a85.gjm(22, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR57d6f3a85.gjm(23, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR57d6f3a85.gjm(24, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR57d6f3a85.gjm(25, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR57d6f3a85.gjm(26, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCarMenuState(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57d6f3a85.gjm(27, "org.dsi.ifc.carvehiclestates.DSICarVehicleStates", -184544288, -1653679357), 27, objectArray);
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

