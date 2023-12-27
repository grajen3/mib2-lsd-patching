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
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;
import org.dsi.ifc.carhybrid.DSICarHybrid;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public final class LR5391efb15
extends AbstractProxy
implements DSICarKombi,
DSICarHybrid {
    private static final Method[] JMS = new Method[85];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5391efb15(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void resetSIAValue(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5391efb15.gjm(0, "org.dsi.ifc.carkombi.DSICarKombi", 1249158377, 1687814400), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = carArrayListUpdateInfo;
            this.h.invoke(this, LR5391efb15.gjm(1, "org.dsi.ifc.carkombi.DSICarKombi", 1800180007, 344255931), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSIADistanceOilUser(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5391efb15.gjm(2, "org.dsi.ifc.carkombi.DSICarKombi", 877263906, 1676164096), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSIADistanceAirFilterUser(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5391efb15.gjm(3, "org.dsi.ifc.carkombi.DSICarKombi", 1155263148, 1676164096), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSIADistanceOilFilterUser(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5391efb15.gjm(4, "org.dsi.ifc.carkombi.DSICarKombi", -872040134, 1676164096), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSIAInspectionDistanceUser(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5391efb15.gjm(5, "org.dsi.ifc.carkombi.DSICarKombi", -761276152, 1676164096), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCVZADisplay(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(6, "org.dsi.ifc.carkombi.DSICarKombi", -574432040, -1653679357), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCLifeTipsDisplay(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(7, "org.dsi.ifc.carkombi.DSICarKombi", -1607629609, -1653679357), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCConsumerDisplay(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(8, "org.dsi.ifc.carkombi.DSICarKombi", -1102602731, -1653679357), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCMenueConfig(BCMenueConfiguration bCMenueConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCMenueConfiguration;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5391efb15.gjm(9, "org.dsi.ifc.carkombi.DSICarKombi", 441740114, -235534979), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void resetBCMenue(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5391efb15.gjm(10, "org.dsi.ifc.carkombi.DSICarKombi", 1807579283, 1687814400), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCOilTemperature(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(11, "org.dsi.ifc.carkombi.DSICarKombi", -1160655002, -1653679357), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCDigitalSpeed(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(12, "org.dsi.ifc.carkombi.DSICarKombi", 1201648042, -1653679357), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCStopwatch(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(13, "org.dsi.ifc.carkombi.DSICarKombi", -1621891528, -1653679357), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCVzaMFA(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(14, "org.dsi.ifc.carkombi.DSICarKombi", 59485356, -1653679357), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = bCSpeedWarningSettings;
            this.h.invoke(this, LR5391efb15.gjm(15, "org.dsi.ifc.carkombi.DSICarKombi", -1926785962, -1695919016), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCGearRecommendation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(16, "org.dsi.ifc.carkombi.DSICarKombi", 542053890, -1653679357), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCRearSeatbeltWarning(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(17, "org.dsi.ifc.carkombi.DSICarKombi", -84701569, -1653679357), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestVehicleStateList(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = bCVehicleStateUpdateInfoAH;
            this.h.invoke(this, LR5391efb15.gjm(18, "org.dsi.ifc.carkombi.DSICarKombi", 659995006, 1702896932), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBcSetFactoryDefault() {
        try {
            this.h.invoke(this, LR5391efb15.gjm(19, "org.dsi.ifc.carkombi.DSICarKombi", 1271910049, 17), 19, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void resetBCStatistics(BCStatisticsReset bCStatisticsReset) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = bCStatisticsReset;
            this.h.invoke(this, LR5391efb15.gjm(20, "org.dsi.ifc.carkombi.DSICarKombi", -2003208228, -1262174599), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCAstaMFA(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(21, "org.dsi.ifc.carkombi.DSICarKombi", 464790663, -1653679357), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHUDHeightAdjustment(byte by) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(by);
            this.h.invoke(this, LR5391efb15.gjm(22, "org.dsi.ifc.carkombi.DSICarKombi", -1090783256, 2103651840), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHUDBrightness(byte by) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(by);
            this.h.invoke(this, LR5391efb15.gjm(23, "org.dsi.ifc.carkombi.DSICarKombi", -617242387, 2103651840), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHUDContent(HUDContent hUDContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = hUDContent;
            this.h.invoke(this, LR5391efb15.gjm(24, "org.dsi.ifc.carkombi.DSICarKombi", -108022840, -1020699596), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHUDRotationAdjustment(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5391efb15.gjm(25, "org.dsi.ifc.carkombi.DSICarKombi", 356036639, 1687814400), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHUDColour(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5391efb15.gjm(26, "org.dsi.ifc.carkombi.DSICarKombi", -694608485, 1676164096), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHUDSetFactoryDefault() {
        try {
            this.h.invoke(this, LR5391efb15.gjm(27, "org.dsi.ifc.carkombi.DSICarKombi", -1713576195, 17), 27, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHUDSystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(28, "org.dsi.ifc.carkombi.DSICarKombi", 568876476, -1653679357), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCSetFactoryDefault() {
        try {
            this.h.invoke(this, LR5391efb15.gjm(29, "org.dsi.ifc.carkombi.DSICarKombi", -313595990, 17), 29, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCBrightness(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5391efb15.gjm(30, "org.dsi.ifc.carkombi.DSICarKombi", 133885485, 1687814400), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCVolume(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5391efb15.gjm(31, "org.dsi.ifc.carkombi.DSICarKombi", 1350424955, 1687814400), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCDisplay1MainSelection(DCMainItems dCMainItems) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dCMainItems;
            this.h.invoke(this, LR5391efb15.gjm(32, "org.dsi.ifc.carkombi.DSICarKombi", -123451958, 294157049), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCDisplay2MainSelection(DCMainItems dCMainItems) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dCMainItems;
            this.h.invoke(this, LR5391efb15.gjm(33, "org.dsi.ifc.carkombi.DSICarKombi", -1754389588, 294157049), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCDisplay3MainSelection(DCMainItems dCMainItems) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dCMainItems;
            this.h.invoke(this, LR5391efb15.gjm(34, "org.dsi.ifc.carkombi.DSICarKombi", 909640078, 294157049), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dCElementContentSelectionListUpdateInfo;
            this.h.invoke(this, LR5391efb15.gjm(35, "org.dsi.ifc.carkombi.DSICarKombi", -1268027669, 1855698157), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCElementContentSelectionListUpdateInfo;
            objectArray[1] = dCElementContentSelectionListRA1Array;
            this.h.invoke(this, LR5391efb15.gjm(36, "org.dsi.ifc.carkombi.DSICarKombi", -1953052169, 2119254695), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCElementContentSelectionListUpdateInfo;
            objectArray[1] = dCElementContentSelectionListRA2Array;
            this.h.invoke(this, LR5391efb15.gjm(37, "org.dsi.ifc.carkombi.DSICarKombi", -1936274953, -111852889), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dCElementContentSelectionListUpdateInfo;
            objectArray[1] = nArray;
            this.h.invoke(this, LR5391efb15.gjm(38, "org.dsi.ifc.carkombi.DSICarKombi", -1600730633, 680965869), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dCAdditionalInstrument;
            this.h.invoke(this, LR5391efb15.gjm(39, "org.dsi.ifc.carkombi.DSICarKombi", -1007111793, -1373705172), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dCAdditionalInstrument2;
            this.h.invoke(this, LR5391efb15.gjm(40, "org.dsi.ifc.carkombi.DSICarKombi", 258881581, -1905420432), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = carArrayListUpdateInfo;
            this.h.invoke(this, LR5391efb15.gjm(41, "org.dsi.ifc.carkombi.DSICarKombi", 1929386732, 344255931), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = dCDisplayPresetsListRecordArray;
            this.h.invoke(this, LR5391efb15.gjm(42, "org.dsi.ifc.carkombi.DSICarKombi", -962420520, -938859196), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dCDisplayDependency;
            this.h.invoke(this, LR5391efb15.gjm(43, "org.dsi.ifc.carkombi.DSICarKombi", 109443059, 927175622), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCActiveDisplayPreset(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5391efb15.gjm(44, "org.dsi.ifc.carkombi.DSICarKombi", 803830779, 1687814400), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dCDisplayViewConfiguration;
            this.h.invoke(this, LR5391efb15.gjm(45, "org.dsi.ifc.carkombi.DSICarKombi", -1515626703, 1869594488), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHUDLicense(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(46, "org.dsi.ifc.carkombi.DSICarKombi", -1042289511, -1653679357), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDCLEDConfiguration(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(47, "org.dsi.ifc.carkombi.DSICarKombi", -1593235615, -1653679357), 47, objectArray);
            return;
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
            this.h.invoke(this, LR5391efb15.gjm(48, "org.dsi.ifc.carkombi.DSICarKombi", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5391efb15.gjm(49, "org.dsi.ifc.carkombi.DSICarKombi", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5391efb15.gjm(50, "org.dsi.ifc.carkombi.DSICarKombi", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5391efb15.gjm(51, "org.dsi.ifc.carkombi.DSICarKombi", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5391efb15.gjm(52, "org.dsi.ifc.carkombi.DSICarKombi", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5391efb15.gjm(53, "org.dsi.ifc.carkombi.DSICarKombi", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlImmediately(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5391efb15.gjm(54, "org.dsi.ifc.carhybrid.DSICarHybrid", -2119369121, 1676164096), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlTimerState(BatteryControlProgrammedTimer batteryControlProgrammedTimer) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = batteryControlProgrammedTimer;
            this.h.invoke(this, LR5391efb15.gjm(55, "org.dsi.ifc.carhybrid.DSICarHybrid", -206874602, 509509303), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlTimer(int n, int n2, int n3, int n4, int n5, int n6, BatteryControlWeekdays batteryControlWeekdays, int n7) {
        try {
            Object[] objectArray = this.p.borrowArray(8);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(n5);
            objectArray[5] = RuntimeUtil.valueOf(n6);
            objectArray[6] = batteryControlWeekdays;
            objectArray[7] = RuntimeUtil.valueOf(n7);
            this.h.invoke(this, LR5391efb15.gjm(56, "org.dsi.ifc.carhybrid.DSICarHybrid", 1215936268, -1989669492), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlSetFactoryDefault() {
        try {
            this.h.invoke(this, LR5391efb15.gjm(57, "org.dsi.ifc.carhybrid.DSICarHybrid", -593554345, 17), 57, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHybridTargetRange(short s, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5391efb15.gjm(58, "org.dsi.ifc.carhybrid.DSICarHybrid", -1020261048, -254492666), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHybridEnergyAssistControl(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(59, "org.dsi.ifc.carhybrid.DSICarHybrid", -1547599786, -1653679357), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestBatteryControlProfileList(BatteryControlProfilesAH batteryControlProfilesAH) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = batteryControlProfilesAH;
            this.h.invoke(this, LR5391efb15.gjm(60, "org.dsi.ifc.carhybrid.DSICarHybrid", -572003361, 982829280), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA0Array;
            this.h.invoke(this, LR5391efb15.gjm(61, "org.dsi.ifc.carhybrid.DSICarHybrid", 1092580195, -466692679), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA1Array;
            this.h.invoke(this, LR5391efb15.gjm(62, "org.dsi.ifc.carhybrid.DSICarHybrid", 1109357411, 1597232569), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA2Array;
            this.h.invoke(this, LR5391efb15.gjm(63, "org.dsi.ifc.carhybrid.DSICarHybrid", 1126134627, -633875015), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA3Array;
            this.h.invoke(this, LR5391efb15.gjm(64, "org.dsi.ifc.carhybrid.DSICarHybrid", 1142911843, 1430050233), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA4Array;
            this.h.invoke(this, LR5391efb15.gjm(65, "org.dsi.ifc.carhybrid.DSICarHybrid", 1159689059, -801057351), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA5Array;
            this.h.invoke(this, LR5391efb15.gjm(66, "org.dsi.ifc.carhybrid.DSICarHybrid", 1176466275, 1262867897), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA6Array;
            this.h.invoke(this, LR5391efb15.gjm(67, "org.dsi.ifc.carhybrid.DSICarHybrid", 1193243491, -968239687), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = batteryControlProfileRA7Array;
            this.h.invoke(this, LR5391efb15.gjm(68, "org.dsi.ifc.carhybrid.DSICarHybrid", 1210020707, 1095685561), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlProfilesAH;
            objectArray[1] = nArray;
            this.h.invoke(this, LR5391efb15.gjm(69, "org.dsi.ifc.carhybrid.DSICarHybrid", 1461678947, -191968544), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlPowerProviderRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = batteryControlPowerProviderRA0Array;
            this.h.invoke(this, LR5391efb15.gjm(70, "org.dsi.ifc.carhybrid.DSICarHybrid", 843878186, 704123126), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlPowerProviderRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = batteryControlPowerProviderRA1Array;
            this.h.invoke(this, LR5391efb15.gjm(71, "org.dsi.ifc.carhybrid.DSICarHybrid", 860655402, -1526984458), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlPowerProviderRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = batteryControlPowerProviderRA2Array;
            this.h.invoke(this, LR5391efb15.gjm(72, "org.dsi.ifc.carhybrid.DSICarHybrid", 877432618, 520163830), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlPowerProviderRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = batteryControlPowerProviderRAEArray;
            this.h.invoke(this, LR5391efb15.gjm(73, "org.dsi.ifc.carhybrid.DSICarHybrid", 1196199722, 1079382518), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlPowerProviderRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = batteryControlPowerProviderAH;
            objectArray[1] = nArray;
            this.h.invoke(this, LR5391efb15.gjm(74, "org.dsi.ifc.carhybrid.DSICarHybrid", 1212976938, 952534399), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestBatteryControlPowerProviderList(BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = batteryControlPowerProviderAH;
            this.h.invoke(this, LR5391efb15.gjm(75, "org.dsi.ifc.carhybrid.DSICarHybrid", 169434906, 2127266687), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlPastErrorReason(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5391efb15.gjm(76, "org.dsi.ifc.carhybrid.DSICarHybrid", 2112341848, 1687814400), 76, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBatteryControlRemainingChargeTime(int n, short s, int n2, short s2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(s);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(s2);
            this.h.invoke(this, LR5391efb15.gjm(77, "org.dsi.ifc.carhybrid.DSICarHybrid", -1163957575, -13766565), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHybridActivePedal(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5391efb15.gjm(78, "org.dsi.ifc.carhybrid.DSICarHybrid", -1413445499, -1653679357), 78, objectArray);
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

