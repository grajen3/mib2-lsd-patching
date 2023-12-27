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
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirQuality;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirCartridge;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.DSICarAirConditionListener;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.CarBCTemperature;

public final class LR53eabf113
extends AbstractProxy
implements DSICarAirConditionListener,
DSICarAuxHeaterCoolerListener {
    private static final Method[] JMS = new Method[176];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR53eabf113(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void requestAirconPopup(AirconContent airconContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = airconContent;
            this.h.invoke(this, LR53eabf113.gjm(0, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -100178785, -1481751395), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowlegdeAirconPopup(AirconContent airconContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = airconContent;
            this.h.invoke(this, LR53eabf113.gjm(1, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 667378262, -1481751395), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconContent(AirconContent airconContent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconContent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(2, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1927152686, -1493401699), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirCirculationMan(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(3, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1370537907, -1665395196), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirCirculationAuto(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(4, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -488165180, -1665395196), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirCirculationSensitivity(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(5, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1769497947, 1676164096), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirCirculationMiddleExhaustion(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(6, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1175965471, 1676164096), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconRearWindowHeater(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(7, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 656785793, -1665395196), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIndirectVentilation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(8, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1008616828, -1665395196), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconPopupTime(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(9, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -306038284, 1676164096), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconHeater(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(10, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1813608153, -1665395196), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconRearAuxHeater(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(11, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 301712839, -1665395196), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconFrontWindowHeater(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(12, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -891216695, -1665395196), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconDefrost(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(13, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -144220170, -1665395196), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconMaxDefrost(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(14, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1433704615, -1665395196), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSolar(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(15, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1783712709, -1665395196), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAC(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(16, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 2025639178, -1665395196), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconMaxAC(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(17, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1525504315, -1665395196), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconEcoAC(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(18, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1207494970, -1665395196), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconRearControl(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(19, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1379339163, -1665395196), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconRearControlFondPlus(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(20, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1179355559, -1665395196), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconSteeringWheelHeater;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(21, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 990633948, 1410320357), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconFrontWindowHeaterAuto(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(22, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 427909670, -1665395196), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconBlowerCompensation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(23, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1325949368, -193670282), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSynchronisation(AirconSynchronisation airconSynchronisation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconSynchronisation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(24, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 467985038, 872775360), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSuppressVisualisation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(25, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -353752109, -1665395196), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconResidualHeat(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(26, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1958600742, -1665395196), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSystemOnOffRow1(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(27, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1826961464, -1665395196), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSystemOnOffRow2(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(28, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1843738680, -1665395196), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSystemOnOffRow3(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(29, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1860515896, -1665395196), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconTemp;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(30, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -450684018, 803180725), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirVolume;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(31, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1475222337, -244700824), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirDistribution;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(32, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -312788932, 461167886), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconFootwellTempZone1(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(33, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 158503260, 1676164096), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterZone1(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(34, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 923810249, 1043255048), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationZone1(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(35, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 62212870, 1043255048), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconTemp;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(36, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -433906802, 803180725), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirVolume;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(37, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1491999553, -244700824), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirDistribution;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(38, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -296011716, 461167886), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconFootwellTempZone2(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(39, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 175280476, 1676164096), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterZone2(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(40, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 940587465, 1043255048), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationZone2(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(41, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 78990086, 1043255048), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempZone3(AirconTemp airconTemp, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconTemp;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(42, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -417129586, 803180725), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirVolume;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(43, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1508776769, -244700824), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirDistribution;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(44, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -279234500, 461167886), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconFootwellTempZone3(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(45, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 192057692, 1676164096), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterZone3(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(46, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 957364681, 1043255048), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationZone3(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(47, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 95767302, 1043255048), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempZone4(AirconTemp airconTemp, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconTemp;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(48, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -400352370, 803180725), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirVolume;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(49, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1525553985, -244700824), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirDistribution;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(50, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -262457284, 461167886), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconFootwellTempZone4(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(51, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 208834908, 1676164096), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterZone4(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(52, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 974141897, 1043255048), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationZone4(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(53, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 112544518, 1043255048), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempZone5(AirconTemp airconTemp, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconTemp;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(54, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -383575154, 803180725), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirVolumeZone5(AirconAirVolume airconAirVolume, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirVolume;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(55, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1542331201, -244700824), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirDistributionZone5(AirconAirDistribution airconAirDistribution, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirDistribution;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(56, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -245680068, 461167886), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconFootwellTempZone5(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(57, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 225612124, 1676164096), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterZone5(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(58, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 990919113, 1043255048), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationZone5(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(59, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 129321734, 1043255048), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempZone6(AirconTemp airconTemp, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconTemp;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(60, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -366797938, 803180725), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirVolumeZone6(AirconAirVolume airconAirVolume, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirVolume;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(61, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1559108417, -244700824), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirDistributionZone6(AirconAirDistribution airconAirDistribution, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirDistribution;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(62, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -228902852, 461167886), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconFootwellTempZone6(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(63, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 242389340, 1676164096), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterZone6(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(64, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1007696329, 1043255048), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationZone6(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(65, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 146098950, 1043255048), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone1(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(66, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1819219522, 1676164096), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone2(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(67, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1802442306, 1676164096), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone3(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(68, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1785665090, 1676164096), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone4(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(69, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1768887874, 1676164096), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone5(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(70, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1752110658, 1676164096), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone6(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(71, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1735333442, 1676164096), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone1(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(72, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1600360433, 1676164096), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone2(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(73, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1617137649, 1676164096), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone3(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(74, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1633914865, 1676164096), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone4(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(75, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1650692081, 1676164096), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone5(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(76, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1667469297, 1676164096), 76, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone6(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(77, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1684246513, 1676164096), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempStepZone1(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(78, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -102861294, 1043255048), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempStepZone2(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(79, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -86084078, 1043255048), 79, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempStepZone3(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(80, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -69306862, 1043255048), 80, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempStepZone4(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(81, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -52529646, 1043255048), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempStepZone5(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(82, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -35752430, 1043255048), 82, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconTempStepZone6(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53eabf113.gjm(83, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -18975214, 1043255048), 83, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconMasterViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(84, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1330278503, 1683077606), 84, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconRowViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(85, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -2069909162, -1709692612), 85, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconViewOptionsRow2(AirconRowViewOptions airconRowViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconRowViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(86, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -2053131946, -1709692612), 86, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconViewOptionsRow3(AirconRowViewOptions airconRowViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconRowViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(87, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -2036354730, -1709692612), 87, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeAirconSetFactoryDefaultMaster(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53eabf113.gjm(88, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1138952678, -1653679357), 88, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeAirconSetFactoryDefaultRow(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53eabf113.gjm(89, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1973512098, -1600866162), 89, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeAirconNozzleControlRow1(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR53eabf113.gjm(90, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1539654937, -647458158), 90, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeAirconNozzleControlRow2(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR53eabf113.gjm(91, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1556432153, -647458158), 91, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeAirconNozzleControlRow3(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR53eabf113.gjm(92, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1573209369, -647458158), 92, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = airconNozzleListRecordArray;
            this.h.invoke(this, LR53eabf113.gjm(93, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -576096738, 1781368757), 93, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseAirconNozzleListRow2(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = airconNozzleListRecordArray;
            this.h.invoke(this, LR53eabf113.gjm(94, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -559319522, 1781368757), 94, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseAirconNozzleListRow3(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = airconNozzleListRecordArray;
            this.h.invoke(this, LR53eabf113.gjm(95, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -542542306, 1781368757), 95, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconNozzleListUpdateInfoRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = nArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(96, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -596352720, -1446739516), 96, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconNozzleListUpdateInfoRow2(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = nArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(97, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -579575504, -1446739516), 97, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconNozzleListUpdateInfoRow3(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = nArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(98, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -562798288, -1446739516), 98, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconNozzleListTotalNumberOfElementsRow1(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(99, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1847704502, 1676164096), 99, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconNozzleListTotalNumberOfElementsRow2(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(100, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1864481718, 1676164096), 100, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconNozzleListTotalNumberOfElementsRow3(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(101, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1881258934, 1676164096), 101, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSideWindowDefrost(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(102, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 273895503, -1665395196), 102, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconPureAir(AirconPureAirSetup airconPureAirSetup, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = airconPureAirSetup;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(103, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1178344077, -1581999796), 103, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconFreshAirState(AirconFreshAirCartridge airconFreshAirCartridge, AirconFreshAirCartridge airconFreshAirCartridge2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = airconFreshAirCartridge;
            objectArray[1] = airconFreshAirCartridge2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(104, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1981649937, -1274353353), 104, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconFreshAirConfig(AirconFreshAirConfiguration airconFreshAirConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconFreshAirConfiguration;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(105, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1797619230, -2025496174), 105, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconAirQuality(AirconAirQuality airconAirQuality, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconAirQuality;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(106, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -875055055, 1883910039), 106, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconNozzleStatusRow1(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(107, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -103491121, -1665395196), 107, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconNozzleStatusRow2(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(108, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -86713905, -1665395196), 108, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconNozzleStatusRow3(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(109, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -69936689, -1665395196), 109, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStyleZone1(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(110, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 759684322, 1676164096), 110, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStyleZone2(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(111, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 776461538, 1676164096), 111, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStyleZone3(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(112, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 793238754, 1676164096), 112, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStyleZone4(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(113, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 810015970, 1676164096), 113, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStyleZone5(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(114, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 826793186, 1676164096), 114, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStyleZone6(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(115, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 843570402, 1676164096), 115, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStateZone1(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(116, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1307374028, 1676164096), 116, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStateZone2(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(117, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1324151244, 1676164096), 117, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStateZone3(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(118, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1340928460, 1676164096), 118, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStateZone4(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(119, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1357705676, 1676164096), 119, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStateZone5(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(120, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1374482892, 1676164096), 120, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconClimateStateZone6(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(121, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1391260108, 1676164096), 121, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone1(boolean bl, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(122, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1490137605, 1996663052), 122, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone2(boolean bl, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(123, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1506914821, 1996663052), 123, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone3(boolean bl, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(124, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1523692037, 1996663052), 124, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone4(boolean bl, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(125, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1540469253, 1996663052), 125, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone5(boolean bl, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(126, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1557246469, 1996663052), 126, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone6(boolean bl, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(127, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1574023685, 1996663052), 127, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone1(boolean bl, boolean bl2, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(128, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1450416605, 1539786968), 128, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone2(boolean bl, boolean bl2, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(129, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1467193821, 1539786968), 129, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone3(boolean bl, boolean bl2, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(130, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1483971037, 1539786968), 130, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone4(boolean bl, boolean bl2, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(131, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1500748253, 1539786968), 131, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone5(boolean bl, boolean bl2, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(132, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1517525469, 1539786968), 132, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone6(boolean bl, boolean bl2, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(133, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1534302685, 1539786968), 133, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone1(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(134, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1458246902, -1665395196), 134, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone2(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(135, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1441469686, -1665395196), 135, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone3(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(136, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1424692470, -1665395196), 136, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone4(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(137, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1407915254, -1665395196), 137, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone5(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(138, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1391138038, -1665395196), 138, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone6(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(139, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1374360822, -1665395196), 139, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIonisatorZone1(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(140, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1398447711, 1676164096), 140, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIonisatorZone2(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(141, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1415224927, 1676164096), 141, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIonisatorZone3(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(142, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1432002143, 1676164096), 142, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIonisatorZone4(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(143, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1448779359, 1676164096), 143, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIonisatorZone5(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(144, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1465556575, 1676164096), 144, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconIonisatorZone6(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(145, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1482333791, 1676164096), 145, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone1(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = airconBCMeasuresConfiguration;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(146, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1347689642, 692930991), 146, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone2(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = airconBCMeasuresConfiguration;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(147, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1364466858, 692930991), 147, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone3(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = airconBCMeasuresConfiguration;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(148, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1381244074, 692930991), 148, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone4(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = airconBCMeasuresConfiguration;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(149, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1398021290, 692930991), 149, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone5(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = airconBCMeasuresConfiguration;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(150, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1414798506, 692930991), 150, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone6(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = airconBCMeasuresConfiguration;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(151, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", 1431575722, 692930991), 151, objectArray);
            return;
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
            this.h.invoke(this, LR53eabf113.gjm(152, "org.dsi.ifc.caraircondition.DSICarAirConditionListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = auxHeaterCoolerViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(153, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 1084886832, -1153660080), 153, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerCurrentHeaterState(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = auxHeaterCoolerErrorReason;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(154, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 1592222703, -296299949), 154, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerErrorReason(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = auxHeaterCoolerErrorReason;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(155, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 1942246963, -296299949), 155, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(156, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 410282843, 1676164096), 156, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(157, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", -1760153509, -1665395196), 157, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerRemainingTime(short s, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(158, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 1778851900, -254492666), 158, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerRunningTime(short s, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(159, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 872391226, -254492666), 159, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(160, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", -962273344, 1676164096), 160, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerDefaultStartMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(161, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 118122083, 1676164096), 161, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerEngineHeater(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(162, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", -1566019321, -1665395196), 162, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerActiveTimer(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(163, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", -433729221, 1676164096), 163, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = auxHeaterCoolerTimer;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(164, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 802758931, 1196862640), 164, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = auxHeaterCoolerTimer;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(165, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 819536147, 1196862640), 165, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = auxHeaterCoolerTimer;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(166, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 836313363, 1196862640), 166, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeAuxHeaterSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53eabf113.gjm(167, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", -1990671912, -1653679357), 167, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerPopup(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(168, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 857751387, 1676164096), 168, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerMode2(AuxHeaterCoolerMode auxHeaterCoolerMode, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = auxHeaterCoolerMode;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(169, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 1990857819, -914239326), 169, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning, AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = auxHeaterCoolerExtendedConditioning;
            objectArray[1] = auxHeaterCoolerExtendedConditioning2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(170, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", -481077634, -1329496731), 170, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerWindowHeating(boolean bl, boolean bl2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(171, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", 1773104308, -1263655781), 171, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerUnlockClimating(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53eabf113.gjm(172, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", -976377449, 1676164096), 172, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerTargetTemperature(CarBCTemperature carBCTemperature, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCTemperature;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(173, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", -1431604917, 1483909880), 173, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAuxHeaterCoolerAirQuality(boolean bl, boolean bl2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53eabf113.gjm(174, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener", -127373512, -1263655781), 174, objectArray);
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

