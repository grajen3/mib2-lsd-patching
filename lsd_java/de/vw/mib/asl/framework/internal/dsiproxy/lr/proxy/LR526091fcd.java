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
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlPlug;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlRemainingChargeTime;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.DSICarHybridListener;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridInhibitReason;
import org.dsi.ifc.carhybrid.HybridTargetRange;
import org.dsi.ifc.carhybrid.HybridViewOptions;
import org.dsi.ifc.carkombi.BCAverageRecoveredEnergy;
import org.dsi.ifc.carkombi.BCComfortPowerConsumption;
import org.dsi.ifc.carkombi.BCCycleGeneralData;
import org.dsi.ifc.carkombi.BCIndications;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.carkombi.BCMaxValues;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCRefuelVolume;
import org.dsi.ifc.carkombi.BCResetTimeStamp;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsAC;
import org.dsi.ifc.carkombi.BCStatisticsConfig;
import org.dsi.ifc.carkombi.BCStatisticsDistanceEU;
import org.dsi.ifc.carkombi.BCStatisticsRE;
import org.dsi.ifc.carkombi.BCStatisticsZE;
import org.dsi.ifc.carkombi.BCTankLevel;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteTime;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.carkombi.DSICarKombiListener;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;
import org.dsi.ifc.carkombi.SIADistanceData;
import org.dsi.ifc.carkombi.SIAHistoryListRecord;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCTemperature;
import org.dsi.ifc.global.CarBCTime;

public final class LR526091fcd
extends AbstractProxy
implements DSICarHybridListener,
DSICarKombiListener {
    private static final Method[] JMS = new Method[170];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR526091fcd(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = hybridViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(0, "org.dsi.ifc.carhybrid.DSICarHybridListener", 1234566247, 231529538), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHybridCharge(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(1, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1364363122, 1676164096), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = hybridEnergyFlowState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(2, "org.dsi.ifc.carhybrid.DSICarHybridListener", -337279593, 791841360), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHybridRecoveredEnergy(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(3, "org.dsi.ifc.carhybrid.DSICarHybridListener", -71285007, 1676164096), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHybridEnergyFlow(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(4, "org.dsi.ifc.carhybrid.DSICarHybridListener", 1357134594, 1676164096), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHybridEnergyAssistControl(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(5, "org.dsi.ifc.carhybrid.DSICarHybridListener", 473429668, -1665395196), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHybridEnergyAssistState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(6, "org.dsi.ifc.carhybrid.DSICarHybridListener", -790566703, 1676164096), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(7, "org.dsi.ifc.carhybrid.DSICarHybridListener", 890614734, -105458462), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlPlug(BatteryControlPlug batteryControlPlug, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPlug;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(8, "org.dsi.ifc.carhybrid.DSICarHybridListener", 1556587052, 910546598), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlChargeState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(9, "org.dsi.ifc.carhybrid.DSICarHybridListener", 969407573, -43508118), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlClimateState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(10, "org.dsi.ifc.carhybrid.DSICarHybridListener", 989612097, 342845610), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlTimerState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(11, "org.dsi.ifc.carhybrid.DSICarHybridListener", 1512248031, -200270971), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlTimer1(BatteryControlTimer batteryControlTimer, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlTimer;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(12, "org.dsi.ifc.carhybrid.DSICarHybridListener", 447326869, 97989933), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlTimer2(BatteryControlTimer batteryControlTimer, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlTimer;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(13, "org.dsi.ifc.carhybrid.DSICarHybridListener", 464104085, 97989933), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlTimer;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(14, "org.dsi.ifc.carhybrid.DSICarHybridListener", 480881301, 97989933), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlTimer4(BatteryControlTimer batteryControlTimer, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlTimer;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(15, "org.dsi.ifc.carhybrid.DSICarHybridListener", 497658517, 97989933), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlTotalNumberOfProfiles(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(16, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1431926818, 1676164096), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlProfilesListUpdateInfo(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = nArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(17, "org.dsi.ifc.carhybrid.DSICarHybridListener", 1831903830, -808166167), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlTotalNumberOfPowerProvider(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(18, "org.dsi.ifc.carhybrid.DSICarHybridListener", 547302264, 1676164096), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlPowerProviderListUpdateInfo(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = nArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(19, "org.dsi.ifc.carhybrid.DSICarHybridListener", 126297261, 319559816), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeBatteryControlSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526091fcd.gjm(20, "org.dsi.ifc.carhybrid.DSICarHybridListener", 1647464622, -1653679357), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeBatteryControlImmediately(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(21, "org.dsi.ifc.carhybrid.DSICarHybridListener", -2028215195, -1665395196), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA0Array;
            this.h.invoke(this, LR526091fcd.gjm(22, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1328992974, -466692679), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA1Array;
            this.h.invoke(this, LR526091fcd.gjm(23, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1312215758, 1597232569), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA2Array;
            this.h.invoke(this, LR526091fcd.gjm(24, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1295438542, -633875015), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA3Array;
            this.h.invoke(this, LR526091fcd.gjm(25, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1278661326, 1430050233), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA4Array;
            this.h.invoke(this, LR526091fcd.gjm(26, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1261884110, -801057351), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA5Array;
            this.h.invoke(this, LR526091fcd.gjm(27, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1245106894, 1262867897), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA6Array;
            this.h.invoke(this, LR526091fcd.gjm(28, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1228329678, -968239687), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA7Array;
            this.h.invoke(this, LR526091fcd.gjm(29, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1211552462, 1095685561), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = nArray;
            this.h.invoke(this, LR526091fcd.gjm(30, "org.dsi.ifc.carhybrid.DSICarHybridListener", -959894222, -191968544), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responsePowerProviderListRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = batteryControlPowerProviderRA0Array;
            this.h.invoke(this, LR526091fcd.gjm(31, "org.dsi.ifc.carhybrid.DSICarHybridListener", -476884077, 704123126), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responsePowerProviderListRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = batteryControlPowerProviderRA1Array;
            this.h.invoke(this, LR526091fcd.gjm(32, "org.dsi.ifc.carhybrid.DSICarHybridListener", -460106861, -1526984458), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responsePowerProviderListRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = batteryControlPowerProviderRA2Array;
            this.h.invoke(this, LR526091fcd.gjm(33, "org.dsi.ifc.carhybrid.DSICarHybridListener", -443329645, 520163830), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responsePowerProviderListRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = batteryControlPowerProviderRAEArray;
            this.h.invoke(this, LR526091fcd.gjm(34, "org.dsi.ifc.carhybrid.DSICarHybridListener", -124562541, 1079382518), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responsePowerProviderListRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = nArray;
            this.h.invoke(this, LR526091fcd.gjm(35, "org.dsi.ifc.carhybrid.DSICarHybridListener", -107785325, 952534399), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHybridTargetRange(HybridTargetRange hybridTargetRange, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = hybridTargetRange;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(36, "org.dsi.ifc.carhybrid.DSICarHybridListener", 1009715254, 6744080), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlPastErrorReason(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR526091fcd.gjm(37, "org.dsi.ifc.carhybrid.DSICarHybridListener", 1995973596, -448335035), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlPlugDisplayState(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR526091fcd.gjm(38, "org.dsi.ifc.carhybrid.DSICarHybridListener", -337821636, 1043255048), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlRemainingChargeTime(BatteryControlRemainingChargeTime batteryControlRemainingChargeTime, BatteryControlRemainingChargeTime batteryControlRemainingChargeTime2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = batteryControlRemainingChargeTime;
            objectArray[1] = batteryControlRemainingChargeTime2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(39, "org.dsi.ifc.carhybrid.DSICarHybridListener", 864875293, 912563667), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBatteryControlLowestMaxCurrent(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(40, "org.dsi.ifc.carhybrid.DSICarHybridListener", 363805741, 1676164096), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHybridInhibitReason(HybridInhibitReason hybridInhibitReason, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = hybridInhibitReason;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(41, "org.dsi.ifc.carhybrid.DSICarHybridListener", -607799351, 1608450191), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHybridActivePedal(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(42, "org.dsi.ifc.carhybrid.DSICarHybridListener", 616530803, -1665395196), 42, objectArray);
            return;
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
            this.h.invoke(this, LR526091fcd.gjm(43, "org.dsi.ifc.carhybrid.DSICarHybridListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSIAViewOptions(SIAViewOptions sIAViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sIAViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(44, "org.dsi.ifc.carkombi.DSICarKombiListener", 202785573, -1362357492), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSIAServiceData(SIAServiceData sIAServiceData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sIAServiceData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(45, "org.dsi.ifc.carkombi.DSICarKombiListener", -766683395, 1946429412), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sIAOilInspection;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(46, "org.dsi.ifc.carkombi.DSICarKombiListener", 958341337, 456735088), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicateEndOfSIAReset(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526091fcd.gjm(47, "org.dsi.ifc.carkombi.DSICarKombiListener", -1295925868, -1653679357), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSIAHistoryListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = nArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(48, "org.dsi.ifc.carkombi.DSICarKombiListener", 1558898503, -1446739516), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo, SIAHistoryListRecord[] sIAHistoryListRecordArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = sIAHistoryListRecordArray;
            this.h.invoke(this, LR526091fcd.gjm(49, "org.dsi.ifc.carkombi.DSICarKombiListener", -1651623105, -253238490), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSIAHistoryListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(50, "org.dsi.ifc.carkombi.DSICarKombiListener", 540097596, 1676164096), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSIADistanceOilUser(SIADistanceData sIADistanceData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sIADistanceData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(51, "org.dsi.ifc.carkombi.DSICarKombiListener", -619093516, -757996214), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSIADistanceAirFilterUser(SIADistanceData sIADistanceData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sIADistanceData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(52, "org.dsi.ifc.carkombi.DSICarKombiListener", -1420647307, -757996214), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSIADistanceOilFilterUser(SIADistanceData sIADistanceData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sIADistanceData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(53, "org.dsi.ifc.carkombi.DSICarKombiListener", 863859203, -757996214), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSIAInspectionDistanceUser(SIADistanceData sIADistanceData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sIADistanceData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(54, "org.dsi.ifc.carkombi.DSICarKombiListener", 1259687767, -757996214), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSIADailyAverageMileage(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR526091fcd.gjm(55, "org.dsi.ifc.carkombi.DSICarKombiListener", 960651448, 1043255048), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(56, "org.dsi.ifc.carkombi.DSICarKombiListener", -2075794842, -2146781421), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCIndications(BCIndications bCIndications, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCIndications;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(57, "org.dsi.ifc.carkombi.DSICarKombiListener", -495746206, -566732785), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCCurrentConsumption1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(58, "org.dsi.ifc.carkombi.DSICarKombiListener", 1520651832, 2141253554), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCCurrentConsumption2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(59, "org.dsi.ifc.carkombi.DSICarKombiListener", 1537429048, 2141253554), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCCurrentRange1(CarBCCurrentRange carBCCurrentRange, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCCurrentRange;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(60, "org.dsi.ifc.carkombi.DSICarKombiListener", 942751856, 1217466906), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCCurrentRange2(CarBCCurrentRange carBCCurrentRange, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCCurrentRange;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(61, "org.dsi.ifc.carkombi.DSICarKombiListener", 959529072, 1217466906), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCTotalDistance(CarBCDistance carBCDistance, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCDistance;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(62, "org.dsi.ifc.carkombi.DSICarKombiListener", 614404352, -111842013), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(63, "org.dsi.ifc.carkombi.DSICarKombiListener", -360687478, 2141253554), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(64, "org.dsi.ifc.carkombi.DSICarKombiListener", -343910262, 2141253554), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCShortTermGeneral(BCShortTermGeneralData bCShortTermGeneralData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCShortTermGeneralData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(65, "org.dsi.ifc.carkombi.DSICarKombiListener", 523139833, -1961859894), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCLongTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(66, "org.dsi.ifc.carkombi.DSICarKombiListener", -693024096, 2141253554), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCLongTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(67, "org.dsi.ifc.carkombi.DSICarKombiListener", -676246880, 2141253554), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCLongTermGeneral(BCLongTermGeneralData bCLongTermGeneralData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCLongTermGeneralData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(68, "org.dsi.ifc.carkombi.DSICarKombiListener", 190962963, -788463319), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCCycleAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(69, "org.dsi.ifc.carkombi.DSICarKombiListener", 1280512486, 2141253554), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCCycleAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(70, "org.dsi.ifc.carkombi.DSICarKombiListener", 1297289702, 2141253554), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCCycleGeneral(BCCycleGeneralData bCCycleGeneralData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCCycleGeneralData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(71, "org.dsi.ifc.carkombi.DSICarKombiListener", -2130501051, 1840175177), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCVZADisplay(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(72, "org.dsi.ifc.carkombi.DSICarKombiListener", -992167929, -1665395196), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCLifeTipsDisplay(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(73, "org.dsi.ifc.carkombi.DSICarKombiListener", 422346693, -1665395196), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCConsumerDisplay(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(74, "org.dsi.ifc.carkombi.DSICarKombiListener", 927373571, -1665395196), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCTankLevel1(BCTankLevel bCTankLevel, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCTankLevel;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(75, "org.dsi.ifc.carkombi.DSICarKombiListener", -1766101684, -1043640351), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCTankLevel2(BCTankLevel bCTankLevel, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCTankLevel;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(76, "org.dsi.ifc.carkombi.DSICarKombiListener", -1749324468, -1043640351), 76, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCRefuelVolume1(BCRefuelVolume bCRefuelVolume, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCRefuelVolume;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(77, "org.dsi.ifc.carkombi.DSICarKombiListener", 2041926656, -455114596), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCRefuelVolume2(BCRefuelVolume bCRefuelVolume, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCRefuelVolume;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(78, "org.dsi.ifc.carkombi.DSICarKombiListener", 2058703872, -455114596), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCMenue1Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCMenueConfiguration;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(79, "org.dsi.ifc.carkombi.DSICarKombiListener", -1939142432, -235534979), 79, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCMenue2Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCMenueConfiguration;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(80, "org.dsi.ifc.carkombi.DSICarKombiListener", -844698092, -235534979), 80, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCMenue3Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCMenueConfiguration;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(81, "org.dsi.ifc.carkombi.DSICarKombiListener", 249746505, -235534979), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCOilTemperature(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(82, "org.dsi.ifc.carkombi.DSICarKombiListener", 564178484, -1665395196), 82, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCDigitalSpeed(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(83, "org.dsi.ifc.carkombi.DSICarKombiListener", 1859907218, -1665395196), 83, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStopwatch(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(84, "org.dsi.ifc.carkombi.DSICarKombiListener", -656360572, -1665395196), 84, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCVzaMFA(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(85, "org.dsi.ifc.carkombi.DSICarKombiListener", 1789982569, -1665395196), 85, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCSpeedWarningSettings;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(86, "org.dsi.ifc.carkombi.DSICarKombiListener", -1268526786, -1724346280), 86, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCGearRecommendation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(87, "org.dsi.ifc.carkombi.DSICarKombiListener", 127043853, -1665395196), 87, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCRearSeatbeltWarning(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(88, "org.dsi.ifc.carkombi.DSICarKombiListener", -217217822, -1665395196), 88, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCOutsideTemperature(CarBCTemperature carBCTemperature, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCTemperature;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(89, "org.dsi.ifc.carkombi.DSICarKombiListener", 1849770268, 1483909880), 89, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicateEndOfBCMenuReset(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526091fcd.gjm(90, "org.dsi.ifc.carkombi.DSICarKombiListener", -342653673, -1653679357), 90, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCVehicleStateListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(91, "org.dsi.ifc.carkombi.DSICarKombiListener", 65984641, 1676164096), 91, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseVehicleStateUpdateInfo(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCVehicleStateUpdateInfoAH;
            objectArray[1] = nArray;
            this.h.invoke(this, LR526091fcd.gjm(92, "org.dsi.ifc.carkombi.DSICarKombiListener", -763643375, 528164644), 92, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseVehicleStateListWarningIDdynValueAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, int n2, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = bCVehicleStateUpdateInfoAH;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = string;
            objectArray[4] = string2;
            this.h.invoke(this, LR526091fcd.gjm(93, "org.dsi.ifc.carkombi.DSICarKombiListener", 1141190970, -40655928), 93, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseVehicleStateListWarningIDdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListWarningIDsDynValues[] listWarningIDsDynValuesArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCVehicleStateUpdateInfoAH;
            objectArray[1] = listWarningIDsDynValuesArray;
            this.h.invoke(this, LR526091fcd.gjm(94, "org.dsi.ifc.carkombi.DSICarKombiListener", -1598113316, -2107705080), 94, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseVehicleStateListAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = bCVehicleStateUpdateInfoAH;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = string;
            this.h.invoke(this, LR526091fcd.gjm(95, "org.dsi.ifc.carkombi.DSICarKombiListener", -340362134, 1165565472), 95, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseVehicleStateListdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListDynValues[] listDynValuesArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCVehicleStateUpdateInfoAH;
            objectArray[1] = listDynValuesArray;
            this.h.invoke(this, LR526091fcd.gjm(96, "org.dsi.ifc.carkombi.DSICarKombiListener", 1366203496, -1775390996), 96, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseVehicleStateListPos(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCVehicleStateUpdateInfoAH;
            objectArray[1] = nArray;
            this.h.invoke(this, LR526091fcd.gjm(97, "org.dsi.ifc.carkombi.DSICarKombiListener", -985631464, 528164644), 97, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeBcSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526091fcd.gjm(98, "org.dsi.ifc.carkombi.DSICarKombiListener", -780526176, -1653679357), 98, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeHUDSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526091fcd.gjm(99, "org.dsi.ifc.carkombi.DSICarKombiListener", -744395319, -1653679357), 99, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeDCSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR526091fcd.gjm(100, "org.dsi.ifc.carkombi.DSICarKombiListener", 1945777577, -1653679357), 100, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeBcStatisticsReset(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(101, "org.dsi.ifc.carkombi.DSICarKombiListener", -1532619916, 1687814400), 101, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsDistanceAC1(BCStatisticsAC bCStatisticsAC, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCStatisticsAC;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(102, "org.dsi.ifc.carkombi.DSICarKombiListener", -494657098, -2040689080), 102, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsDistanceAC2(BCStatisticsAC bCStatisticsAC, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCStatisticsAC;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(103, "org.dsi.ifc.carkombi.DSICarKombiListener", -477879882, -2040689080), 103, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsDistanceRE(BCStatisticsRE bCStatisticsRE, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCStatisticsRE;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(104, "org.dsi.ifc.carkombi.DSICarKombiListener", -901068894, -1755345336), 104, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsDistanceZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = bCStatisticsZE;
            objectArray[1] = bCZeroEmissionAbsoluteDistance;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(105, "org.dsi.ifc.carkombi.DSICarKombiListener", -1035221086, -2016183794), 105, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalAC1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(106, "org.dsi.ifc.carkombi.DSICarKombiListener", -393024545, 2141253554), 106, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalAC2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(107, "org.dsi.ifc.carkombi.DSICarKombiListener", -376247329, 2141253554), 107, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCAverageRecoveredEnergy;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(108, "org.dsi.ifc.carkombi.DSICarKombiListener", 73670820, 1334994738), 108, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = bCZeroEmissionRelative;
            objectArray[1] = bCZeroEmissionAbsoluteDistance;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(109, "org.dsi.ifc.carkombi.DSICarKombiListener", -60546908, 872896471), 109, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsTimeAC1(BCStatisticsAC bCStatisticsAC, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCStatisticsAC;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(110, "org.dsi.ifc.carkombi.DSICarKombiListener", -1975471880, -2040689080), 110, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsTimeAC2(BCStatisticsAC bCStatisticsAC, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCStatisticsAC;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(111, "org.dsi.ifc.carkombi.DSICarKombiListener", -1958694664, -2040689080), 111, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsTimeRE(BCStatisticsRE bCStatisticsRE, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCStatisticsRE;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(112, "org.dsi.ifc.carkombi.DSICarKombiListener", 578428523, -1755345336), 112, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsTimeZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = bCStatisticsZE;
            objectArray[1] = bCZeroEmissionAbsoluteTime;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(113, "org.dsi.ifc.carkombi.DSICarKombiListener", 444276331, 1065922520), 113, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodAC1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(114, "org.dsi.ifc.carkombi.DSICarKombiListener", 70571792, 2141253554), 114, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodAC2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(115, "org.dsi.ifc.carkombi.DSICarKombiListener", 87349008, 2141253554), 115, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCAverageRecoveredEnergy;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(116, "org.dsi.ifc.carkombi.DSICarKombiListener", 1747971724, 1334994738), 116, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = bCZeroEmissionRelative;
            objectArray[1] = bCZeroEmissionAbsoluteTime;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(117, "org.dsi.ifc.carkombi.DSICarKombiListener", 1613819532, -323253343), 117, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticsConfig(BCStatisticsConfig bCStatisticsConfig, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCStatisticsConfig;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(118, "org.dsi.ifc.carkombi.DSICarKombiListener", -1541443250, -959691099), 118, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticDistanceEUkm(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCStatisticsDistanceEU;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(119, "org.dsi.ifc.carkombi.DSICarKombiListener", -1037371177, -374586791), 119, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCStatisticDistanceEUmls(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCStatisticsDistanceEU;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(120, "org.dsi.ifc.carkombi.DSICarKombiListener", -1628763097, -374586791), 120, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCOilTemperatureValue(CarBCTemperature carBCTemperature, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCTemperature;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(121, "org.dsi.ifc.carkombi.DSICarKombiListener", -1699653989, 1483909880), 121, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCCoolantTemperature(CarBCTemperature carBCTemperature, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCTemperature;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(122, "org.dsi.ifc.carkombi.DSICarKombiListener", 1977298650, 1483909880), 122, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCComfortPowerConsumption(BCComfortPowerConsumption bCComfortPowerConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCComfortPowerConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(123, "org.dsi.ifc.carkombi.DSICarKombiListener", -1914467893, 152394615), 123, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCTotalCurrentRange(CarBCDistance carBCDistance, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCDistance;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(124, "org.dsi.ifc.carkombi.DSICarKombiListener", 1932878785, -111842013), 124, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCZeroEmissionDistanceST(CarBCDistance carBCDistance, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCDistance;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(125, "org.dsi.ifc.carkombi.DSICarKombiListener", -1540293900, -111842013), 125, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCZeroEmissionDistanceLT(CarBCDistance carBCDistance, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCDistance;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(126, "org.dsi.ifc.carkombi.DSICarKombiListener", -886048012, -111842013), 126, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCZeroEmissionDistanceCY(CarBCDistance carBCDistance, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCDistance;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(127, "org.dsi.ifc.carkombi.DSICarKombiListener", -1188103436, -111842013), 127, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCZeroEmissionTimeST(CarBCTime carBCTime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCTime;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(128, "org.dsi.ifc.carkombi.DSICarKombiListener", -65691797, -781955632), 128, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCZeroEmissionTimeLT(CarBCTime carBCTime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCTime;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(129, "org.dsi.ifc.carkombi.DSICarKombiListener", 588619627, -781955632), 129, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCZeroEmissionTimeCY(CarBCTime carBCTime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCTime;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(130, "org.dsi.ifc.carkombi.DSICarKombiListener", 286564203, -781955632), 130, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCMaxValues(BCMaxValues bCMaxValues, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCMaxValues;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(131, "org.dsi.ifc.carkombi.DSICarKombiListener", 1896281091, -1385773887), 131, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCResetTimeStampST(BCResetTimeStamp bCResetTimeStamp, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCResetTimeStamp;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(132, "org.dsi.ifc.carkombi.DSICarKombiListener", 1744214965, 674632799), 132, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCResetTimeStampLT(BCResetTimeStamp bCResetTimeStamp, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCResetTimeStamp;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(133, "org.dsi.ifc.carkombi.DSICarKombiListener", -1896506443, 674632799), 133, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCResetTimeStampCY(BCResetTimeStamp bCResetTimeStamp, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCResetTimeStamp;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(134, "org.dsi.ifc.carkombi.DSICarKombiListener", 2096405429, 674632799), 134, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCAstaMFA(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(135, "org.dsi.ifc.carkombi.DSICarKombiListener", -1808056717, -1665395196), 135, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHUDViewOptions(HUDViewOptions hUDViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = hUDViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(136, "org.dsi.ifc.carkombi.DSICarKombiListener", 1621816501, 39962012), 136, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHUDHeightAdjustment(byte by, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(by);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(137, "org.dsi.ifc.carkombi.DSICarKombiListener", -146854588, 2092001536), 137, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHUDBrightness(byte by, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(by);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(138, "org.dsi.ifc.carkombi.DSICarKombiListener", -732412006, 2092001536), 138, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHUDColour(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR526091fcd.gjm(139, "org.dsi.ifc.carkombi.DSICarKombiListener", 1327576967, 1043255048), 139, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHUDContent(HUDContent hUDContent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = hUDContent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(140, "org.dsi.ifc.carkombi.DSICarKombiListener", -1594373537, -1032349900), 140, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHUDInfo(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(141, "org.dsi.ifc.carkombi.DSICarKombiListener", -1313649991, -1665395196), 141, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHUDSystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(142, "org.dsi.ifc.carkombi.DSICarKombiListener", 1210358692, -1665395196), 142, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHUDRotationAdjustment(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(143, "org.dsi.ifc.carkombi.DSICarKombiListener", 240297346, 1676164096), 143, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCViewOptions(DCViewOptions dCViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(144, "org.dsi.ifc.carkombi.DSICarKombiListener", -2041386941, -2112373264), 144, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCBrightness(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(145, "org.dsi.ifc.carkombi.DSICarKombiListener", -300692644, 1676164096), 145, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCVolume(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(146, "org.dsi.ifc.carkombi.DSICarKombiListener", -1214110663, 1676164096), 146, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(147, "org.dsi.ifc.carkombi.DSICarKombiListener", -1418860566, 1676164096), 147, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCDisplay1Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = dCMainItems;
            objectArray[1] = dCDisplayedAdditionalInfos;
            objectArray[2] = dCAdditionalInfo;
            objectArray[3] = dCAdditionalInfo2;
            objectArray[4] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(148, "org.dsi.ifc.carkombi.DSICarKombiListener", 1542213113, -1474934342), 148, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCDisplay2Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = dCMainItems;
            objectArray[1] = dCDisplayedAdditionalInfos;
            objectArray[2] = dCAdditionalInfo;
            objectArray[3] = dCAdditionalInfo2;
            objectArray[4] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(149, "org.dsi.ifc.carkombi.DSICarKombiListener", -87817477, -1474934342), 149, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCDisplay3Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = dCMainItems;
            objectArray[1] = dCDisplayedAdditionalInfos;
            objectArray[2] = dCAdditionalInfo;
            objectArray[3] = dCAdditionalInfo2;
            objectArray[4] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(150, "org.dsi.ifc.carkombi.DSICarKombiListener", -1717716996, -1474934342), 150, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCDisplay1MainSelection(DCMainItems dCMainItems, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCMainItems;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(151, "org.dsi.ifc.carkombi.DSICarKombiListener", -1323017148, 282506745), 151, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCDisplay2MainSelection(DCMainItems dCMainItems, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCMainItems;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(152, "org.dsi.ifc.carkombi.DSICarKombiListener", 1357789478, 282506745), 152, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCDisplay3MainSelection(DCMainItems dCMainItems, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCMainItems;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(153, "org.dsi.ifc.carkombi.DSICarKombiListener", -273213688, 282506745), 153, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCElementContentSelectionListUpdateInfo;
            objectArray[1] = nArray;
            this.h.invoke(this, LR526091fcd.gjm(154, "org.dsi.ifc.carkombi.DSICarKombiListener", 2142392255, 680965869), 154, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCElementContentSelectionListUpdateInfo;
            objectArray[1] = dCElementContentSelectionListRA1Array;
            this.h.invoke(this, LR526091fcd.gjm(155, "org.dsi.ifc.carkombi.DSICarKombiListener", 1790070719, 2119254695), 155, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCElementContentSelectionListUpdateInfo;
            objectArray[1] = dCElementContentSelectionListRA2Array;
            this.h.invoke(this, LR526091fcd.gjm(156, "org.dsi.ifc.carkombi.DSICarKombiListener", 1806847935, -111852889), 156, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = dCElementContentSelectionListUpdateInfo;
            objectArray[1] = nArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(157, "org.dsi.ifc.carkombi.DSICarKombiListener", -1323924165, 64768246), 157, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCAdditionalInstrument;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(158, "org.dsi.ifc.carkombi.DSICarKombiListener", -51142890, -1385421011), 158, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCAdditionalInstrument2;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(159, "org.dsi.ifc.carkombi.DSICarKombiListener", -153548412, -1917070736), 159, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCDisplayPresetsListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(160, "org.dsi.ifc.carkombi.DSICarKombiListener", -1735028270, 1676164096), 160, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = dCDisplayPresetsListRecordArray;
            this.h.invoke(this, LR526091fcd.gjm(161, "org.dsi.ifc.carkombi.DSICarKombiListener", 626361036, -938859196), 161, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCDisplayPresetsListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = dCDisplayPresetsListRecordArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(162, "org.dsi.ifc.carkombi.DSICarKombiListener", -459275030, -1554991284), 162, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCDisplayDependency;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(163, "org.dsi.ifc.carkombi.DSICarKombiListener", 1845276860, 915525318), 163, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCActiveDisplayPreset(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR526091fcd.gjm(164, "org.dsi.ifc.carkombi.DSICarKombiListener", 671314270, 1676164096), 164, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCDisplayViewConfiguration;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(165, "org.dsi.ifc.carkombi.DSICarKombiListener", 1289984177, 1857944184), 165, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCompassInfo(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR526091fcd.gjm(166, "org.dsi.ifc.carkombi.DSICarKombiListener", -863571291, 1043255048), 166, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHUDLicense(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(167, "org.dsi.ifc.carkombi.DSICarKombiListener", 1749484593, -1665395196), 167, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDCLEDConfiguration(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR526091fcd.gjm(168, "org.dsi.ifc.carkombi.DSICarKombiListener", 1222282034, -1665395196), 168, objectArray);
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

