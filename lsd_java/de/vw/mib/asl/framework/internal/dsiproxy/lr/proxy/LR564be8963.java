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
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.DSICarAirCondition;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public final class LR564be8963
extends AbstractProxy
implements DSICarAuxHeaterCooler,
DSICarAirCondition {
    private static final Method[] JMS = new Method[83];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR564be8963(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setAuxHeaterCoolerOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(0, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", -1328300977, -1653679357), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerRunningTime(short s) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(s);
            this.h.invoke(this, LR564be8963.gjm(1, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", -1933219398, -242842362), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(2, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", -1923044763, 1687814400), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerDefaultStartMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(3, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 1314114118, 1687814400), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerEngineHeater(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(4, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 1772979072, -1653679357), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerActiveTimer(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(5, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 1072469947, 1687814400), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = auxHeaterCoolerTimer;
            this.h.invoke(this, LR564be8963.gjm(6, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 918498480, 1208512944), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = auxHeaterCoolerTimer;
            this.h.invoke(this, LR564be8963.gjm(7, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 935275696, 1208512944), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = auxHeaterCoolerTimer;
            this.h.invoke(this, LR564be8963.gjm(8, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 952052912, 1208512944), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerPopup(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(9, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 1289603919, 1687814400), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterSetFactoryDefault() {
        try {
            this.h.invoke(this, LR564be8963.gjm(10, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", -806946783, 17), 10, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = auxHeaterCoolerExtendedConditioning;
            this.h.invoke(this, LR564be8963.gjm(11, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", -1432267240, -413485701), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerWindowHeating(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(12, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", -2109498531, -1653679357), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerUnlockClimating(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(13, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", -1631616081, 1687814400), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerTargetTemperature(float f2) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            this.h.invoke(this, LR564be8963.gjm(14, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 1133221588, -786116603), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAuxHeaterCoolerAirQuality(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(15, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 2146695657, -1653679357), 15, objectArray);
            return;
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
            this.h.invoke(this, LR564be8963.gjm(16, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR564be8963.gjm(17, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR564be8963.gjm(18, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR564be8963.gjm(19, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR564be8963.gjm(20, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR564be8963.gjm(21, "org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconAirCirculationMan(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(22, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1741641415, -1653679357), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconAirCirculationAuto(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(23, "org.dsi.ifc.caraircondition.DSICarAirCondition", 2070968315, -1653679357), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconMiddleExhaustion(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(24, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1573956914, 1687814400), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconRearWindowHeater(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(25, "org.dsi.ifc.caraircondition.DSICarAirCondition", 4998, -1653679357), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconIndirectVentilation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(26, "org.dsi.ifc.caraircondition.DSICarAirCondition", 1248609590, -1653679357), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconPopupTime(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(27, "org.dsi.ifc.caraircondition.DSICarAirCondition", 880463828, 1687814400), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconHeater(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(28, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1395872264, -1653679357), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconRearAuxHeater(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(29, "org.dsi.ifc.caraircondition.DSICarAirCondition", -659124116, -1653679357), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconFrontWindowHeater(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(30, "org.dsi.ifc.caraircondition.DSICarAirCondition", 291636815, -1653679357), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconDefrost(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(31, "org.dsi.ifc.caraircondition.DSICarAirCondition", -29050807, -1653679357), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconMaxDefrost(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(32, "org.dsi.ifc.caraircondition.DSICarAirCondition", -291128871, -1653679357), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSolar(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(33, "org.dsi.ifc.caraircondition.DSICarAirCondition", 1545723887, -1653679357), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconAC(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(34, "org.dsi.ifc.caraircondition.DSICarAirCondition", 295141965, -1653679357), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconMaxAC(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(35, "org.dsi.ifc.caraircondition.DSICarAirCondition", 559973615, -1653679357), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconEcoAC(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(36, "org.dsi.ifc.caraircondition.DSICarAirCondition", 241898735, -1653679357), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconRearControl(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(37, "org.dsi.ifc.caraircondition.DSICarAirCondition", 885717367, -1653679357), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconRearControlFondPlus(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(38, "org.dsi.ifc.caraircondition.DSICarAirCondition", -841673895, -1653679357), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = airconSteeringWheelHeater;
            this.h.invoke(this, LR564be8963.gjm(39, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1030395506, 1438747621), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconFrontWindowHeaterAuto(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(40, "org.dsi.ifc.caraircondition.DSICarAirCondition", -528124769, -1653679357), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = airconBlowerCompensation;
            this.h.invoke(this, LR564be8963.gjm(41, "org.dsi.ifc.caraircondition.DSICarAirCondition", -393173009, -182019978), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSynchronisation(AirconSynchronisation airconSynchronisation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = airconSynchronisation;
            this.h.invoke(this, LR564be8963.gjm(42, "org.dsi.ifc.caraircondition.DSICarAirCondition", 583724331, 901202624), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSuppressVisualisation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(43, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1309721268, -1653679357), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSystemOnOffRow(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(44, "org.dsi.ifc.caraircondition.DSICarAirCondition", 141355303, -1600866162), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconAirCirculationSensitivity(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(45, "org.dsi.ifc.caraircondition.DSICarAirCondition", -573505912, 1687814400), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconResidualHeat(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(46, "org.dsi.ifc.caraircondition.DSICarAirCondition", -462308856, -1653679357), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showAirconPopup(AirconContent airconContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = airconContent;
            this.h.invoke(this, LR564be8963.gjm(47, "org.dsi.ifc.caraircondition.DSICarAirCondition", -869338880, -1481751395), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void cancelAirconPopup(AirconContent airconContent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airconContent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(48, "org.dsi.ifc.caraircondition.DSICarAirCondition", 800819418, -1493401699), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconContent(AirconContent airconContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = airconContent;
            this.h.invoke(this, LR564be8963.gjm(49, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1795271898, -1481751395), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconTempZone(int n, AirconTemp airconTemp) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = airconTemp;
            this.h.invoke(this, LR564be8963.gjm(50, "org.dsi.ifc.caraircondition.DSICarAirCondition", 788606839, -543989963), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconAirVolume(int n, AirconAirVolume airconAirVolume) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = airconAirVolume;
            this.h.invoke(this, LR564be8963.gjm(51, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1624938006, -372872443), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconAirDistribution(int n, AirconAirDistribution airconAirDistribution) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = airconAirDistribution;
            this.h.invoke(this, LR564be8963.gjm(52, "org.dsi.ifc.caraircondition.DSICarAirCondition", 155274618, -79597027), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconFootwellTemp(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR564be8963.gjm(53, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1089323387, 1676164096), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSeatHeater(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR564be8963.gjm(54, "org.dsi.ifc.caraircondition.DSICarAirCondition", 299032904, 1043255048), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSeatVentilation(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR564be8963.gjm(55, "org.dsi.ifc.caraircondition.DSICarAirCondition", 856817884, 1043255048), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconHMIIsReady(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(56, "org.dsi.ifc.caraircondition.DSICarAirCondition", 76799371, -1653679357), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSeatHeaterDistribution(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR564be8963.gjm(57, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1242951947, 1676164096), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSeatVentilationDistribution(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR564be8963.gjm(58, "org.dsi.ifc.caraircondition.DSICarAirCondition", -687393734, 1676164096), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconTempStep(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR564be8963.gjm(59, "org.dsi.ifc.caraircondition.DSICarAirCondition", 1340353399, 1676164096), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconClimateStyle(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR564be8963.gjm(60, "org.dsi.ifc.caraircondition.DSICarAirCondition", 462930694, 1676164096), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSetFactoryDefaultMaster() {
        try {
            this.h.invoke(this, LR564be8963.gjm(61, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1231025293, 17), 61, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSetFactoryDefaultRow(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(62, "org.dsi.ifc.caraircondition.DSICarAirCondition", -789786713, 1687814400), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconNozzleControlRow1(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(63, "org.dsi.ifc.caraircondition.DSICarAirCondition", -716381056, 1687814400), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconNozzleControlRow2(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(64, "org.dsi.ifc.caraircondition.DSICarAirCondition", -699603840, 1687814400), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconNozzleControlRow3(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR564be8963.gjm(65, "org.dsi.ifc.caraircondition.DSICarAirCondition", -682826624, 1687814400), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestAirconNozzleListRow(int n, CarArrayListUpdateInfo carArrayListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = carArrayListUpdateInfo;
            this.h.invoke(this, LR564be8963.gjm(66, "org.dsi.ifc.caraircondition.DSICarAirCondition", 1355500075, -743549655), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconNozzleListRow(int n, CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = carArrayListUpdateInfo;
            objectArray[2] = airconNozzleListRecordArray;
            this.h.invoke(this, LR564be8963.gjm(67, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1659761225, 1093176124), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSideWindowDefrost(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(68, "org.dsi.ifc.caraircondition.DSICarAirCondition", 1473460693, -1653679357), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconPureAir(AirconPureAirSetup airconPureAirSetup) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = airconPureAirSetup;
            this.h.invoke(this, LR564be8963.gjm(69, "org.dsi.ifc.caraircondition.DSICarAirCondition", 1293513696, -954151869), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconFreshAirConfig(AirconFreshAirConfiguration airconFreshAirConfiguration) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = airconFreshAirConfiguration;
            this.h.invoke(this, LR564be8963.gjm(70, "org.dsi.ifc.caraircondition.DSICarAirCondition", -1382609193, -1997068910), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconAirQuality(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR564be8963.gjm(71, "org.dsi.ifc.caraircondition.DSICarAirCondition", 1678367331, 1676164096), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSeatNeckHeater(int n, boolean bl, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR564be8963.gjm(72, "org.dsi.ifc.caraircondition.DSICarAirCondition", -794077735, 2077903511), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconSeatSurfaceHeater(int n, boolean bl, boolean bl2, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(bl2);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR564be8963.gjm(73, "org.dsi.ifc.caraircondition.DSICarAirCondition", 1074172610, -203993492), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconIndividualClimatisation(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR564be8963.gjm(74, "org.dsi.ifc.caraircondition.DSICarAirCondition", -854861168, -1600866162), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconIonisator(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR564be8963.gjm(75, "org.dsi.ifc.caraircondition.DSICarAirCondition", 590142024, 1676164096), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAirconBodyCloseMeasures(int n, boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = airconBCMeasuresConfiguration;
            this.h.invoke(this, LR564be8963.gjm(76, "org.dsi.ifc.caraircondition.DSICarAirCondition", 116502712, 900101400), 76, objectArray);
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

