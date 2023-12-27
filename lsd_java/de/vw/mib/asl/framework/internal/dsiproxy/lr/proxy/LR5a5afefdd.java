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
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public final class LR5a5afefdd
extends AbstractProxy
implements DSICarVehicleStatesListener,
DSICarTimeUnitsLanguageListener {
    private static final Method[] JMS = new Method[42];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5a5afefdd(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carViewOption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(0, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 174442378, 1030378054), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateOilLevelData(OilLevelData oilLevelData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oilLevelData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(1, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 2049284689, -24365529), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVINViewOption(CarViewOption carViewOption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carViewOption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(2, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 555901565, 1030378054), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVINData(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(3, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", -784338295, -645498553), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carViewOption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(4, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 1710725143, 1030378054), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateKeyData(KeyData keyData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = keyData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(5, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 358101878, 1877862961), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDrvSchoolSystem(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(6, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", -140095132, -1665395196), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vehicleInfoViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(7, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 2103473716, -1050339275), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dynamicVehicleInfoHighFrequentViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(8, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 2049240567, 337895296), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dynamicVehicleInfoMidFrequentViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(9, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", -1666078626, -1605396596), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dynamicVehicleInfoHighFrequent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(10, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 152313899, 1292143943), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dynamicVehicleInfoMidFrequent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(11, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 661182967, 1094169551), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions semiStaticDataViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = semiStaticDataViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(12, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 1567079509, 1498250642), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = semiStaticVehicleData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(13, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 113368442, 551226169), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dynamicVehicleInfoSCR;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(14, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", 323478817, 761336800), 14, objectArray);
            return;
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
            this.h.invoke(this, LR5a5afefdd.gjm(15, "org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = unitmasterViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(16, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -1617103334, -1514740036), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMenuLanguage(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(17, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -1243121879, 1676164096), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTemperatureUnit(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(18, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -2064683082, 1676164096), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDistanceUnit(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(19, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -142593909, 1676164096), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSpeedUnit(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(20, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 395244773, 1676164096), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePressureUnit(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(21, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 1197735692, 1676164096), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVolumeUnit(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(22, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -595070378, 1676164096), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateConsumptionPetrolUnit(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(23, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 454103081, 1676164096), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateConsumptionGasUnit(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(24, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 15673048, 1676164096), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateConsumptionElectricUnit(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(25, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -390931128, 1676164096), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateClockFormat(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(26, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -1857601937, 1676164096), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDateFormat(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(27, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 1665777084, 1676164096), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = clockViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(28, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -1447812679, 1099873457), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateClockDate(ClockDate clockDate, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = clockDate;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(29, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -2008803312, 250678428), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateClockTime(ClockTime clockTime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = clockTime;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(30, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -1482219760, 760485020), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateClockSource(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(31, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -1246269819, 1676164096), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateClockDayLightSaving(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(32, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 240250633, -1665395196), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = clockDayLightSavingData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(33, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 1488987342, -1628171818), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateClockTimeZoneOffset(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(34, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -1506741910, -797832442), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateClockTimeSourcesAvailable(ClockSources clockSources, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = clockSources;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(35, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", -1207622023, -1065139711), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateClockGPSSyncData(ClockGPSSyncData clockGPSSyncData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = clockGPSSyncData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(36, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 528773317, -1218638914), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeUmSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5a5afefdd.gjm(37, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 1519482257, -1653679357), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUTCOffset(UTCOffset uTCOffset, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uTCOffset;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a5afefdd.gjm(38, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 50586245, -1984965103), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSkin(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(39, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 1527274734, 1676164096), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWeightUnit(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a5afefdd.gjm(40, "org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener", 973381724, 1676164096), 40, objectArray);
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

