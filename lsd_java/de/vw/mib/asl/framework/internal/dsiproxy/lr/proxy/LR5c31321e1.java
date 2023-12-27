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
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;
import org.dsi.ifc.has.DSIHASListener;
import org.dsi.ifc.has.HASDataContainer;

public final class LR5c31321e1
extends AbstractProxy
implements DSIGeneralVehicleStatesListener,
DSIHASListener {
    private static final Method[] JMS = new Method[36];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5c31321e1(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateAirbagData(AirbagData airbagData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = airbagData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(0, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 1718295617, 1041280648), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTankInfo(TankInfo tankInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tankInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(1, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 374332946, 785816057), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDimmedHeadlight(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(2, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -1107180958, -1665395196), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAcousticParkingSystem(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(3, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 816953197, -1665395196), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateReverseGear(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(4, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 2099886358, -1665395196), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVehicleStandstill(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(5, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -1978871085, -1665395196), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCarVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(6, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 2013477531, -1665395196), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTVVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(7, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -1202426727, -1665395196), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHDDVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(8, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -461447294, -1665395196), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBrowserSlideShowVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(9, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 1412811348, -1665395196), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBrowserBordBookVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(10, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 1012120743, -1665395196), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBrowserTravelAgentVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(11, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 2008762246, -1665395196), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBrowserWebVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(12, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 1320081611, -1665395196), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBWSVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(13, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -822524451, -1665395196), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRadiotextVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(14, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 1678759898, -1665395196), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDisplayDayNightDesign(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(15, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 1219841382, -1665395196), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBTBondingVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(16, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -7658346, -1665395196), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMessagingVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(17, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -2006990041, -1665395196), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDestinationInputVelocityThreshold(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(18, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -1094860640, -1665395196), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDSSSViewOption(CarViewOption carViewOption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carViewOption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(19, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -2027982349, 1030378054), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateServiceKeyData(byte[] byArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = byArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(20, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -755390476, -1151649024), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateServiceKeyViewOption(CarViewOption carViewOption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carViewOption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(21, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 1654082248, 1030378054), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePersonalizationStatus(boolean bl, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c31321e1.gjm(22, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 1648890632, 1996663052), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTLOViewOptions(TLOViewOptions tLOViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tLOViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(23, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 1627283518, -1198601806), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEmergencyAssistVolLowering(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c31321e1.gjm(24, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -1735308830, 1676164096), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateParkingBrake(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(25, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 837069145, -1665395196), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAppConnectTrigger(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c31321e1.gjm(26, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -1685656470, 1676164096), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSTPState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c31321e1.gjm(27, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", 15129542, 1676164096), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAutomaticGearShiftTransMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c31321e1.gjm(28, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -272199307, 1676164096), 28, objectArray);
            return;
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
            this.h.invoke(this, LR5c31321e1.gjm(29, "org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void actionRequest(int n, int n2, HASDataContainer[] hASDataContainerArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = hASDataContainerArray;
            this.h.invoke(this, LR5c31321e1.gjm(30, "org.dsi.ifc.has.DSIHASListener", -289075820, -1565610619), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void subscribeRequest(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c31321e1.gjm(31, "org.dsi.ifc.has.DSIHASListener", 1510526173, 1676164096), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unsubscribeRequest(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(32, "org.dsi.ifc.has.DSIHASListener", -205228707, 1687814400), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unsubscribeAllRequest() {
        try {
            this.h.invoke(this, LR5c31321e1.gjm(33, "org.dsi.ifc.has.DSIHASListener", -727590756, 17), 33, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getPropertyRequest(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c31321e1.gjm(34, "org.dsi.ifc.has.DSIHASListener", 959943429, 1687814400), 34, objectArray);
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

