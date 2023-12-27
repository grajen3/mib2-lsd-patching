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
import org.dsi.ifc.carparkingsystem.ARACurrentTrailerAngle;
import org.dsi.ifc.carparkingsystem.ARAInfo;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCCrashWarning;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssistState;
import org.dsi.ifc.carparkingsystem.PDCPLABargraph;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;
import org.dsi.ifc.carparkingsystem.PDCWallDetection;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSCameraStates;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.carparkingsystem.VPSRimProtection;
import org.dsi.ifc.carparkingsystem.VPSVideoInfo;
import org.dsi.ifc.carparkingsystem.WCPanelInfo;
import org.dsi.ifc.carparkingsystem.WCPanelListRecord;
import org.dsi.ifc.carparkingsystem.WCPinPukState;
import org.dsi.ifc.carparkingsystem.WCVehiclePanelInfo;
import org.dsi.ifc.carparkingsystem.WCViewOptions;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DSICarplayListener;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.PlaybackInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.carplay.TrackData;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.ResourceLocator;

public final class LR5dbf5283b
extends AbstractProxy
implements DSICarParkingSystemListener,
DSICarplayListener {
    private static final Method[] JMS = new Method[123];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5dbf5283b(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = parkingSystemViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(0, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 271227292, 2067052858), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCDefaultParkingMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(1, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -182439067, 1676164096), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCFrequenceFront(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(2, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1018498430, 1676164096), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCFrequenceRear(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(3, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1149559259, 1676164096), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCFrequenceRight(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(4, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 798601854, 1676164096), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCFrequenceLeft(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(5, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 516037413, 1676164096), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCVolumeFront(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(6, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1589249276, 1676164096), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCVolumeRear(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(7, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1498055027, 1676164096), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCVolumeRight(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(8, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1369352700, 1676164096), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCVolumeLeft(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(9, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1131381133, 1676164096), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCMute(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(10, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 335638083, -1665395196), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCSystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(11, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1348281557, -1665395196), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCTrailerHitched(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(12, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1615315312, -1665395196), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCDistanceValuesFront(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCDistanceValuesFrontRear;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(13, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 565215679, 1348953182), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCDistanceValuesRear(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCDistanceValuesFrontRear;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(14, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 907050287, 1348953182), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCDistanceValuesRight(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCDistanceValuesRightLeft;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(15, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 345253568, 643841529), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCDistanceValuesLeft(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCDistanceValuesRightLeft;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(16, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1722385873, 643841529), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCStatusLevelFront(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCStatusLevelFrontRear;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(17, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1830797638, -374655301), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCStatusLevelRear(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCStatusLevelFrontRear;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(18, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1517482201, -374655301), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCStatusLevelRight(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCStatusLevelRightLeft;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(19, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -2050694214, -1079767210), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCStatusLevelLeft(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCStatusLevelRightLeft;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(20, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 148114471, -1079767210), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCOPSAutoActivation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(21, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 644041593, -1665395196), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCCrashWarning(PDCCrashWarning pDCCrashWarning, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCCrashWarning;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(22, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -258837173, 54259273), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCSteeringInformation(PDCSteeringInformation pDCSteeringInformation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCSteeringInformation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(23, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 720198161, -1792927924), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCFlankGuard(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(24, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1463278716, -1665395196), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCSoundReproduction;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(25, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1971747974, -174462320), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCInfo(PDCInfo pDCInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(26, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1458344893, -1139860805), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCFailure(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(27, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1175376312, -1665395196), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCDistanceValuesFrontExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCDistanceValuesFrontRearExt;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(28, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1249366739, 428791695), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCDistanceValuesRearExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCDistanceValuesFrontRearExt;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(29, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 363045961, 428791695), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCStatusLevelFrontExt(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCStatusLevelFrontRearExt;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(30, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 967178905, -531172280), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCStatusLevelRearExt(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCStatusLevelFrontRearExt;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(31, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1182521225, -531172280), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCWallDetection(PDCWallDetection pDCWallDetection, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCWallDetection;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(32, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1966571355, -167892625), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCPLAMessage(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(33, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -585052240, 1676164096), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCSoundFront(PDCSound pDCSound, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCSound;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(34, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -718781766, 689095329), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCSoundRear(PDCSound pDCSound, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCSound;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(35, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 45166763, 689095329), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCSoundLeft(PDCSound pDCSound, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCSound;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(36, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1710697899, 689095329), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCSoundRight(PDCSound pDCSound, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCSound;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(37, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -938678342, 689095329), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCPLAStatus(PDCPLAStatus pDCPLAStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCPLAStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(38, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -421286962, 1362104892), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCPLABargraph(PDCPLABargraph pDCPLABargraph, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCPLABargraph;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(39, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1334409244, -1159063317), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCPLAParkmodeSelection(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(40, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 363055055, 1676164096), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCPLASystemState(PDCPLASystemState pDCPLASystemState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCPLASystemState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(41, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -126889419, 199449754), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCOPSVisualisationPosition(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(42, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 2105795602, 1676164096), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCOffroadMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(43, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -2118222074, -1665395196), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCParkboxVisualisation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(44, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1517296406, -1665395196), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSFollowUpTime(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(45, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 504442126, 1676164096), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSVideoInfo(VPSVideoInfo vPSVideoInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vPSVideoInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(46, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1362877996, 420579393), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSColor(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(47, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1215570223, 1676164096), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSContrast(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(48, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 125677224, 1676164096), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSBrightness(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(49, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1458724664, 1676164096), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vPSDefaultMode;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(50, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1383495231, -728920870), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vPSDefaultMode;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(51, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -863401535, -728920870), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vPSDefaultMode;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(52, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 965249473, -728920870), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vPSDefaultMode;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(53, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1115190847, -728920870), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSDefaultView(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(54, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1798172683, 1676164096), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vPSDynParkingMode;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(55, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1040870045, 1514297429), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vPSOPSOverlay;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(56, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1139484195, 1443403611), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSSystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(57, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 112956873, -1665395196), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSFailure(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(58, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1872375667, -1665395196), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSExtCamConfig(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(59, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -719006905, 1676164096), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSExtCamManActivation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(60, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1486935658, -1665395196), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPS3DBirdview(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5dbf5283b.gjm(61, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1420720106, 1043255048), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSSystemState(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(62, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -2028416567, -1665395196), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSCameraStates(VPSCameraStates vPSCameraStates, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vPSCameraStates;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(63, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1930449055, -1617483680), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateParkingPopupContent(DisplayContent displayContent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = displayContent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(64, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -241654990, 1619717894), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestParkingPopup(DisplayContent displayContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = displayContent;
            this.h.invoke(this, LR5dbf5283b.gjm(65, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 2018166385, 1631368198), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeParkingPopup(DisplayContent displayContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = displayContent;
            this.h.invoke(this, LR5dbf5283b.gjm(66, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 93300274, 1631368198), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseLifeMonitoring(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5dbf5283b.gjm(67, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 2055292970, -1653679357), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgePdcSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5dbf5283b.gjm(68, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -613408031, -1653679357), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeVpsSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5dbf5283b.gjm(69, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 288229436, -1653679357), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateARAFailure(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(70, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 940170563, -1665395196), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateARAInfo(ARAInfo aRAInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = aRAInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(71, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1975208383, -1656724295), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateARACurrentTrailerAngle(ARACurrentTrailerAngle aRACurrentTrailerAngle, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = aRACurrentTrailerAngle;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(72, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1482045518, 316638189), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateARATargetTrailerAngle(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(73, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 755975669, 1676164096), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCManeuverAssistConfig(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(74, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 2144871189, 1676164096), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCManeuverAssist(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(75, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 495393583, -1665395196), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCManeuverAssistState(PDCManeuverAssistState pDCManeuverAssistState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCManeuverAssistState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(76, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1056697452, -1456428633), 76, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCManeuverAssistMessage(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(77, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1274506865, 1676164096), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCIPAMessage(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(78, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 147185235, 1676164096), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCContinueDrivingAssist(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(79, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1492553428, 1676164096), 79, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCIpaConfig(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(80, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1421496099, 1676164096), 80, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pDCPiloPaSystemState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(81, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -998181207, 799104448), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vPSCameraCleaning;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(82, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1124200597, 1450474234), 82, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVPSRimProtection(VPSRimProtection vPSRimProtection, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = vPSRimProtection;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(83, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1956709224, -539513807), 83, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCViewOptions(WCViewOptions wCViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = wCViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(84, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 432972279, 753602864), 84, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCSystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(85, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 21514470, -1665395196), 85, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCAutoActivation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(86, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1337411024, -1665395196), 86, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCPopupContent(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(87, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1749633103, 1676164096), 87, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCMessage(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(88, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1739308287, 1676164096), 88, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCPanelPosition(WCPanelInfo wCPanelInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = wCPanelInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(89, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1842509992, -2060490236), 89, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeWCSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5dbf5283b.gjm(90, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -969155604, -1653679357), 90, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestWCPopup(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(91, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1177965471, 1687814400), 91, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeWCPopup(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(92, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1718766627, 1687814400), 92, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCPanelListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = nArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(93, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1493628476, -1446739516), 93, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCPanelListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(94, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 61173641, 1676164096), 94, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCVehiclePanelInfo(WCVehiclePanelInfo wCVehiclePanelInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = wCVehiclePanelInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(95, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -262876398, 1528865848), 95, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCPinPukState(WCPinPukState wCPinPukState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = wCPinPukState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(96, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1073530707, -752834331), 96, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCScanningProgress(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(97, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -386984525, 1676164096), 97, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWCSoftwareUpdateProgress(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(98, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -951463590, 1676164096), 98, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeWCEnterPinPuk(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(99, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 377039983, 1687814400), 99, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeWCScanning(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(100, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1374844093, 1687814400), 100, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeWCPairing(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(101, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1251101402, 1687814400), 101, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeWCSoftwareUpdate(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(102, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", 1302110574, 1687814400), 102, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeWCChangePin(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(103, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1301770000, 1687814400), 103, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeWCChangePanelName(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(104, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -856723954, 1687814400), 104, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo, WCPanelListRecord[] wCPanelListRecordArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carArrayListUpdateInfo;
            objectArray[1] = wCPanelListRecordArray;
            this.h.invoke(this, LR5dbf5283b.gjm(105, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -361565464, 1075687367), 105, objectArray);
            return;
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
            this.h.invoke(this, LR5dbf5283b.gjm(106, "org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = resourceArray;
            objectArray[1] = appStateArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(107, "org.dsi.ifc.carplay.DSICarplayListener", -913782451, -85186737), 107, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCallState(CallState[] callStateArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = callStateArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(108, "org.dsi.ifc.carplay.DSICarplayListener", 2145441544, -1717684416), 108, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTelephonyState(TelephonyState telephonyState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = telephonyState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(109, "org.dsi.ifc.carplay.DSICarplayListener", -144512574, -1716859319), 109, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNowPlayingData(TrackData trackData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = trackData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(110, "org.dsi.ifc.carplay.DSICarplayListener", -522503428, -1123196354), 110, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = playbackInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(111, "org.dsi.ifc.carplay.DSICarplayListener", 1658809285, -1457050854), 111, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePlayposition(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(112, "org.dsi.ifc.carplay.DSICarplayListener", 995756741, 1676164096), 112, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceLocator;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(113, "org.dsi.ifc.carplay.DSICarplayListener", -1892111725, -1214164264), 113, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = deviceInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(114, "org.dsi.ifc.carplay.DSICarplayListener", 1112279010, 1692260465), 114, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMode(Resource[] resourceArray, AppState[] appStateArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = resourceArray;
            objectArray[1] = appStateArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(115, "org.dsi.ifc.carplay.DSICarplayListener", -2124654098, -85186737), 115, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestBTDeactivation(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(116, "org.dsi.ifc.carplay.DSICarplayListener", -1914695618, -645498553), 116, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTextInputState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(117, "org.dsi.ifc.carplay.DSICarplayListener", -1836338452, 1676164096), 117, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void duckAudio(int n, double d2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(d2);
            this.h.invoke(this, LR5dbf5283b.gjm(118, "org.dsi.ifc.carplay.DSICarplayListener", 302059412, 232310419), 118, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unduckAudio(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbf5283b.gjm(119, "org.dsi.ifc.carplay.DSICarplayListener", -1722932328, 1687814400), 119, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void oemAppSelected() {
        try {
            this.h.invoke(this, LR5dbf5283b.gjm(120, "org.dsi.ifc.carplay.DSICarplayListener", 2049999654, 17), 120, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMainAudioType(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbf5283b.gjm(121, "org.dsi.ifc.carplay.DSICarplayListener", -1551434752, 1676164096), 121, objectArray);
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

