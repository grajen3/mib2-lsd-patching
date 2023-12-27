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
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
import org.dsi.ifc.carcomfort.DoorLockingBootBlindState;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingLockStatus;
import org.dsi.ifc.carcomfort.DoorLockingMessage;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingWindowStatus;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.carcomfort.RDKResidualBatteryLifetime;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardDetection;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.carcomfort.UGDOVersionData;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.carcomfort.WiperViewOptions;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener;
import org.dsi.ifc.cardriverassistance.FTASensorData;
import org.dsi.ifc.cardriverassistance.FTAViewOptions;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.NVViewOptions;
import org.dsi.ifc.cardriverassistance.PAViewOptions;
import org.dsi.ifc.cardriverassistance.SWARCTASensorData;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.cardriverassistance.TSDSignFct;
import org.dsi.ifc.cardriverassistance.TSDSystemMessages;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCSpeed;

public final class LR58448d4c5
extends AbstractProxy
implements DSICarDriverAssistanceListener,
DSICarComfortListener {
    private static final Method[] JMS = new Method[197];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR58448d4c5(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = aCCViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(0, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1777533765, -1931910444), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateACCGongState(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(1, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -848916432, -1665395196), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateACCGongVolume(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(2, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1472046618, 1676164096), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateACCDrivingProgram(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(3, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1243360829, 1676164096), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateACCTimeGap(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(4, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 644157270, 1676164096), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateACCDefaultMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(5, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -503842580, 1676164096), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateACCCurveAssist(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(6, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1791190915, -1665395196), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateACCSpeedLimitAdoption(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(7, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1180621899, -1665395196), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateACCTrafficJamAssist(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(8, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 788807665, -1665395196), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateACCSpeedLimitOffset(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(9, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -190697777, 1676164096), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = aCCDistanceWarning;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(10, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1150694043, -1173404765), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePACCSensibility(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(11, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1985940666, -1665395196), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePACCMaxSpeed(CarBCSpeed carBCSpeed, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCSpeed;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(12, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 849118666, 734093362), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePACCMeanVelocity(CarBCSpeed carBCSpeed, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCSpeed;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(13, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1312454918, 734093362), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePACCMeanConsumption(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(14, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1373582861, 2141253554), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePACCCoastingPercentage(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(15, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1242354692, 1676164096), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePACCDrivingProgram(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(16, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 745335942, 1676164096), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePACCSystemState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(17, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1567619674, 1676164096), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeACCSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(18, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1996262343, -1653679357), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAWVDistanceWarning(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(19, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -446346330, -1665395196), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAWVViewOptions(AWVViewOptions aWVViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = aWVViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(20, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1210816528, -1381904888), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAWVSystem(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(21, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -78632931, 1676164096), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAWVWarning(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(22, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1704954574, -1665395196), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAWVGong(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(23, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 763979083, -1665395196), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAWVGongVolume(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(24, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1735537549, 1676164096), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAWVBrakeJerk(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(25, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1025326238, -1665395196), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = aWVEmergencyBrake;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(26, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -419458563, -1906869845), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAWVWarningTimegap(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(27, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 2032523478, 1676164096), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeAWVSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(28, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -361850911, -1653679357), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSWAViewOptions(SWAViewOptions sWAViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sWAViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(29, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 443641136, 272553032), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSWABrightness(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(30, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -623731414, 1676164096), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSWAWarningTime(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(31, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1781124446, 1676164096), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSWAFrequency(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(32, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1024559438, 1676164096), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSWASystem(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(33, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1203628749, 1676164096), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSWAGongState(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(34, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1360812404, -1665395196), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSWAGongVolume(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(35, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1539463397, 1676164096), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSWARCTASensorData(SWARCTASensorData sWARCTASensorData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sWARCTASensorData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(36, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -339354680, -1826765962), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSWARCTA(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(37, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -954371582, -1665395196), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSWAExitAssist(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(38, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1325454098, -1665395196), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVViewOptions(NVViewOptions nVViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nVViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(39, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1646709465, -982651138), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVActivation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(40, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1138574071, -1665395196), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVContrast(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(41, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -389277860, 1676164096), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVBrightness(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(42, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -137513802, 1676164096), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVObjectDetection(NVObjectDetection nVObjectDetection, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nVObjectDetection;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(43, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -357053993, -1844465275), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVColorPA(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(44, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 2013641086, 1676164096), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVDesignPA(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(45, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 353297338, 1676164096), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVDisplay(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(46, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1506687575, 1676164096), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVZoomPanning(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(47, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -502506229, 1676164096), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVSound(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(48, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1280226823, 1676164096), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVSymbol(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(49, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1101564624, -1665395196), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeNVSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(50, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1251258696, -1653679357), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVSystem(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(51, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1431599152, -1665395196), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNVWarningTimegap(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(52, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -751926137, 1676164096), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLDWHCAViewOptions(LDWHCAViewOptions lDWHCAViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lDWHCAViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(53, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 518448023, -969028795), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLDWWarningTime(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(54, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1470085337, 1676164096), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLDWSteeringWheelVibration(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(55, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -748275246, 1676164096), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHCAInterventionStyle(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(56, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -763121475, 1676164096), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHCAToleranceLevel(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(57, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1982295553, 1676164096), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeLdwhcaSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(58, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1801024908, -1653679357), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLDWHCASystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(59, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 106990214, -1665395196), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLDWHCAWarningSound(boolean bl, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(60, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -660134910, 1996663052), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tSDViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(61, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -770681745, -924992889), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDSystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(62, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1165297059, -1665395196), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDTrailerDetection(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(63, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1664736665, -1665395196), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDSign1(TSDSignFct tSDSignFct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tSDSignFct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(64, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1379575835, 1762879402), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDSign2(TSDSignFct tSDSignFct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tSDSignFct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(65, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1362798619, 1762879402), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDSign3(TSDSignFct tSDSignFct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tSDSignFct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(66, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1346021403, 1762879402), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDSign4(TSDSignFct tSDSignFct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tSDSignFct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(67, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1329244187, 1762879402), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDSign5(TSDSignFct tSDSignFct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tSDSignFct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(68, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1312466971, 1762879402), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tSDRoadSignFilter;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(69, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1498896759, 1308659255), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeTsdSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(70, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -983156911, -1653679357), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = carBCSpeed;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(71, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 790507920, 1599592267), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCSpeed;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(72, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -527280326, 734093362), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDSystemMessages(TSDSystemMessages tSDSystemMessages, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tSDSystemMessages;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(73, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1817838328, 347269541), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTSDSpeedWarningAcoustics(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(74, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -734701820, -1665395196), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMKEViewOptions(MKEViewOptions mKEViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = mKEViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(75, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -788603691, -959757330), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMKESystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(76, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1200061500, -1665395196), 76, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeMKESetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(77, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1138917387, -1653679357), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePAViewOptions(PAViewOptions pAViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pAViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(78, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -732583582, -51814086), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePASystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(79, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1127264431, -1665395196), 79, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgePASetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(80, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1103826628, -1653679357), 80, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePAConfigInformation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(81, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1515352017, -1665395196), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePAConfigWarning(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(82, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 361411383, -1665395196), 82, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePAWarningTimegap(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(83, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1010018539, 1676164096), 83, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCurveAssistSystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(84, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1733892185, -1665395196), 84, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeCurveAssistSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(85, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1304371571, -1653679357), 85, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateFTAViewOptions(FTAViewOptions fTAViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = fTAViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(86, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -2078236180, 2062354181), 86, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateFTASystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(87, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1822050267, -1665395196), 87, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateFTASensorData(FTASensorData fTASensorData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = fTASensorData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(88, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", 1672231734, -1958677491), 88, objectArray);
            return;
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
            this.h.invoke(this, LR58448d4c5.gjm(89, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rGSViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(90, "org.dsi.ifc.carcomfort.DSICarComfortListener", 434167024, 2138303583), 90, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rGSBeltPretensionData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(91, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1705592069, -427094493), 91, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRGSBeltPretensionDataRear(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rGSBeltPretensionData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(92, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1927180808, -427094493), 92, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRGSPreCrashSystem(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(93, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1029926457, -1665395196), 93, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeRgsSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(94, "org.dsi.ifc.carcomfort.DSICarComfortListener", -865827998, -1653679357), 94, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRGSPreSenseSystem(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(95, "org.dsi.ifc.carcomfort.DSICarComfortListener", 79873288, -1665395196), 95, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRGSPreSenseWarning(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(96, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1324316998, 1676164096), 96, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRGSLocalHazardDetection(RGSLocalHazardDetection rGSLocalHazardDetection, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rGSLocalHazardDetection;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(97, "org.dsi.ifc.carcomfort.DSICarComfortListener", 307866288, -1970955323), 97, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(98, "org.dsi.ifc.carcomfort.DSICarComfortListener", -823686385, 874778500), 98, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingMessage(DoorLockingMessage doorLockingMessage, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingMessage;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(99, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1662535411, -2106602812), 99, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingLockStatus(DoorLockingLockStatus doorLockingLockStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingLockStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(100, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1379845101, 179657573), 100, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingWindowStatus(DoorLockingWindowStatus doorLockingWindowStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingWindowStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(101, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1463146933, -815674678), 101, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingComfortOpenSettings;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(102, "org.dsi.ifc.carcomfort.DSICarComfortListener", 243039139, 1952561447), 102, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingTheftWarningSettings;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(103, "org.dsi.ifc.carcomfort.DSICarComfortListener", 900362914, -1387397474), 103, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingClBootOpen(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(104, "org.dsi.ifc.carcomfort.DSICarComfortListener", 982364729, -1665395196), 104, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingBootOpen(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(105, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1311963587, -1665395196), 105, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingBootClose(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(106, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1143396509, -1665395196), 106, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingUnlockingMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(107, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1983916372, 1676164096), 107, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingAutoLock(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(108, "org.dsi.ifc.carcomfort.DSICarComfortListener", -815215846, 1676164096), 108, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingAutoUnlock(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(109, "org.dsi.ifc.carcomfort.DSICarComfortListener", 687070372, -1665395196), 109, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingClBootLock(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(110, "org.dsi.ifc.carcomfort.DSICarComfortListener", 455913785, -1665395196), 110, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingMirrorProtection(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(111, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1306643029, -1665395196), 111, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingConfirmation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(112, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1965198987, -1665395196), 112, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingRainClosing(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(113, "org.dsi.ifc.carcomfort.DSICarComfortListener", 378729537, -1665395196), 113, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingRearBlind;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(114, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1494510672, -862634745), 114, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeDoorLockingSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(115, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1047437572, -1653679357), 115, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeDoorLockingRemoteLockUnlock(String string, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(116, "org.dsi.ifc.carcomfort.DSICarComfortListener", -685490960, 372504021), 116, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeDoorLockingRemoteBlinking(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(117, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1311002735, -1653679357), 117, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeDoorLockingRemoteHorn(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(118, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1260388921, -1653679357), 118, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void receivedDoorLockingRemoteLockUnlockSignatureVerification(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR58448d4c5.gjm(119, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1809424159, -633848249), 119, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void receivedDoorLockingRemoteLockUnlockAuthentification(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(120, "org.dsi.ifc.carcomfort.DSICarComfortListener", 218947477, -645498553), 120, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingUserListUpdateInfo;
            objectArray[1] = doorLockingUserListRA1Array;
            this.h.invoke(this, LR58448d4c5.gjm(121, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1174995674, 1040330213), 121, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingUserListUpdateInfo;
            objectArray[1] = nArray;
            this.h.invoke(this, LR58448d4c5.gjm(122, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1527317210, -937416057), 122, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingUserListUpdateInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(123, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1439104741, 225731463), 123, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingUserListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(124, "org.dsi.ifc.carcomfort.DSICarComfortListener", -2024822648, 1676164096), 124, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingActiveUser(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(125, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1182101042, 1676164096), 125, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingUserProfileOnOff;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(126, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1487454456, -1616921863), 126, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeDoorLockingUserProfileControl(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(127, "org.dsi.ifc.carcomfort.DSICarComfortListener", -2118061406, -1600866162), 127, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingUserProfileControlProcessing(boolean bl, int n, boolean bl2, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(bl2);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(128, "org.dsi.ifc.carcomfort.DSICarComfortListener", -403869710, -268456735), 128, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingWindowAutoClose(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(129, "org.dsi.ifc.carcomfort.DSICarComfortListener", 247432643, -1665395196), 129, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingBlindsControl(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(130, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1413439449, 1676164096), 130, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingBlindsControlExtended(DoorLockingBootBlindState doorLockingBootBlindState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingBootBlindState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(131, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1379839533, 1536069676), 131, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingLeftSideBlindControl(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(132, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1146949509, 1676164096), 132, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingRightSideBlindControl(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(133, "org.dsi.ifc.carcomfort.DSICarComfortListener", 284778960, 1676164096), 133, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingTurnIndRepeat(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(134, "org.dsi.ifc.carcomfort.DSICarComfortListener", -226889452, -1665395196), 134, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingKeyless(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(135, "org.dsi.ifc.carcomfort.DSICarComfortListener", 232799908, -1665395196), 135, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = wiperViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(136, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1943555009, 855492426), 136, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWiperServicePosition(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(137, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1362623418, -1665395196), 137, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWiperRainSensorOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(138, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1787332931, -1665395196), 138, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWiperRainSensorConfig(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(139, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1489372452, 1676164096), 139, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWiperRearWiping(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(140, "org.dsi.ifc.carcomfort.DSICarComfortListener", -542398057, -1665395196), 140, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWiperTearsWiping(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(141, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1218735153, -1665395196), 141, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWiperWinterPosition(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(142, "org.dsi.ifc.carcomfort.DSICarComfortListener", -447268484, -1665395196), 142, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEasyEntrySteeringColumn(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(143, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1133796147, -1665395196), 143, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeWiperSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(144, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1061525139, -1653679357), 144, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(145, "org.dsi.ifc.carcomfort.DSICarComfortListener", -399807549, 1625381423), 145, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUGDOLearningData(UGDOLearningData uGDOLearningData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOLearningData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(146, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1671988842, 159292021), 146, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUGDODestinationReached(UGDODestinationReached uGDODestinationReached, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDODestinationReached;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(147, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1595012073, -984779170), 147, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOOpenDoor;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(148, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1827924704, -1177717626), 148, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUGDOContent(UGDOContent uGDOContent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOContent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(149, "org.dsi.ifc.carcomfort.DSICarComfortListener", 679317397, 550979423), 149, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUGDOVersionData(UGDOVersionData uGDOVersionData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOVersionData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(150, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1374716215, -911904349), 150, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeUGDOSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(151, "org.dsi.ifc.carcomfort.DSICarComfortListener", 354670598, -1653679357), 151, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(152, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1576918021, 1212245117), 152, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateUGDOButtonListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(153, "org.dsi.ifc.carcomfort.DSICarComfortListener", 441529736, 1676164096), 153, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestUGDOPopup(UGDOContent uGDOContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOContent;
            this.h.invoke(this, LR58448d4c5.gjm(154, "org.dsi.ifc.carcomfort.DSICarComfortListener", -706468389, 562629727), 154, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeUGDOPopup(UGDOContent uGDOContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOContent;
            this.h.invoke(this, LR58448d4c5.gjm(155, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1756613890, 562629727), 155, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeUGDODeleteButton(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(156, "org.dsi.ifc.carcomfort.DSICarComfortListener", 195107785, -1653679357), 156, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOSynchronisation;
            this.h.invoke(this, LR58448d4c5.gjm(157, "org.dsi.ifc.carcomfort.DSICarComfortListener", 64779321, -1351144006), 157, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeUGDOLearning(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(158, "org.dsi.ifc.carcomfort.DSICarComfortListener", -327467660, 1676164096), 158, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOSynchronisation;
            this.h.invoke(this, LR58448d4c5.gjm(159, "org.dsi.ifc.carcomfort.DSICarComfortListener", 820601775, -1351144006), 159, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA0Array;
            this.h.invoke(this, LR58448d4c5.gjm(160, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1469328938, -1142651250), 160, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA1Array;
            this.h.invoke(this, LR58448d4c5.gjm(161, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1452551722, 921273998), 161, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA2Array;
            this.h.invoke(this, LR58448d4c5.gjm(162, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1435774506, -1309833586), 162, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA3Array;
            this.h.invoke(this, LR58448d4c5.gjm(163, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1418997290, 754091662), 163, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA4Array;
            this.h.invoke(this, LR58448d4c5.gjm(164, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1402220074, -1477015922), 164, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA5Array;
            this.h.invoke(this, LR58448d4c5.gjm(165, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1385442858, 586909326), 165, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = nArray;
            this.h.invoke(this, LR58448d4c5.gjm(166, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1100230186, 65940093), 166, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rDKViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(167, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1633564953, 70637142), 167, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDKSystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(168, "org.dsi.ifc.carcomfort.DSICarComfortListener", -2045022762, -1665395196), 168, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rDKTireInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(169, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1608996201, 1602759608), 169, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDKTireSetupSelectedTire(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(170, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1644261032, 1676164096), 170, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rDKTireDisplayData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(171, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1622556507, 1334887783), 171, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDKSpeedLimit(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(172, "org.dsi.ifc.carcomfort.DSICarComfortListener", 969267064, 1676164096), 172, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseRDKTireChanged(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(173, "org.dsi.ifc.carcomfort.DSICarComfortListener", 167582504, 1687814400), 173, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseRDKPressureChanged(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(174, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1941756065, 1687814400), 174, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseRDKLifeMonitoring() {
        try {
            this.h.invoke(this, LR58448d4c5.gjm(175, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1903500306, 17), 175, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDKPressureLevel(byte by, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(by);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(176, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1530063268, 2092001536), 176, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeRDKSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(177, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1850577779, -1653679357), 177, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeRDKPressureChanged(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(178, "org.dsi.ifc.carcomfort.DSICarComfortListener", 659626347, -1653679357), 178, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMirrorViewOptions(MirrorViewOptions mirrorViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = mirrorViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(179, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1495027838, -560061485), 179, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMirrorLowering(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(180, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1105870878, -1665395196), 180, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMirrorSyncAdjust(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(181, "org.dsi.ifc.carcomfort.DSICarComfortListener", -2024777405, -1665395196), 181, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMirrorFolding(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(182, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1374715505, -1665395196), 182, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMirrorDimming(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(183, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1253345563, -1665395196), 183, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMirrorHeating(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(184, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1599318503, -1665395196), 184, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeMirrorSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58448d4c5.gjm(185, "org.dsi.ifc.carcomfort.DSICarComfortListener", 331695606, -1653679357), 185, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBrakeViewOptions(BrakeViewOptions brakeViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = brakeViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(186, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1822523870, 309827049), 186, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBrakeElectricalParking(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(187, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1133468654, -1665395196), 187, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBrakeAutoHold(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(188, "org.dsi.ifc.carcomfort.DSICarComfortListener", -2056056554, 1676164096), 188, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBrakeEscMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(189, "org.dsi.ifc.carcomfort.DSICarComfortListener", -342615914, 1676164096), 189, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBrakeHdcMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(190, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1570058779, -1665395196), 190, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDKDifferentialPressure(RDKWheelPressures rDKWheelPressures, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rDKWheelPressures;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(191, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1707095596, 1890980438), 191, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDKResidualBatteryLifetime(RDKResidualBatteryLifetime rDKResidualBatteryLifetime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rDKResidualBatteryLifetime;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(192, "org.dsi.ifc.carcomfort.DSICarComfortListener", -703598558, -1128237253), 192, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeDoorLockingPrompt(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(193, "org.dsi.ifc.carcomfort.DSICarComfortListener", 1177140771, 1687814400), 193, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestDoorLockingPrompt(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58448d4c5.gjm(194, "org.dsi.ifc.carcomfort.DSICarComfortListener", -1281525666, 1687814400), 194, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDoorLockingPromptContent(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58448d4c5.gjm(195, "org.dsi.ifc.carcomfort.DSICarComfortListener", 174775542, 1676164096), 195, objectArray);
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

