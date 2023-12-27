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
import org.dsi.ifc.carparkingsystem.DSICarParkingSystem;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.DSICarplay;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public final class LR59f6592c3
extends AbstractProxy
implements DSICarParkingSystem,
DSICarplay {
    private static final Method[] JMS = new Method[96];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR59f6592c3(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setHMIStateIsReady(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(0, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1615795426, -1653679357), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCDefaultParkingMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(1, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -66699774, 1687814400), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCMute(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(2, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1542444621, -1653679357), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCFrequenceFront(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(3, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1011477872, 1687814400), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCFrequenceRear(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(4, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1420640087, 1687814400), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCVolumeFront(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(5, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 931055379, 1687814400), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCVolumeRear(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(6, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1613224646, 1687814400), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCAutoActivation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(7, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 661495359, -1653679357), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCSystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(8, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 690087916, -1653679357), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCFrequenceRight(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(9, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1231374448, 1687814400), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCFrequenceLeft(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(10, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1208796073, 1687814400), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCVolumeRight(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(11, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 711093268, 1687814400), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCVolumeLeft(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(12, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1016211514, 1687814400), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCFlankGuard(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(13, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1348109097, -1653679357), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = pDCSoundReproduction;
            this.h.invoke(this, LR59f6592c3.gjm(14, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1556737937, -162812016), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCSoundFront(PDCSound pDCSound) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = pDCSound;
            this.h.invoke(this, LR59f6592c3.gjm(15, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -603612403, 717522593), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCSoundRear(PDCSound pDCSound) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = pDCSound;
            this.h.invoke(this, LR59f6592c3.gjm(16, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 462902396, 717522593), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCSoundLeft(PDCSound pDCSound) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = pDCSound;
            this.h.invoke(this, LR59f6592c3.gjm(17, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 2128433532, 717522593), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCSoundRight(PDCSound pDCSound) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = pDCSound;
            this.h.invoke(this, LR59f6592c3.gjm(18, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -806797554, 717522593), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCPLAPreSelection(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(19, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 906941689, 1687814400), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCPLAParkMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(20, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1165970462, 1687814400), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCPLASystemState(PDCPLASystemState pDCPLASystemState) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = pDCPLASystemState;
            this.h.invoke(this, LR59f6592c3.gjm(21, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 2138167111, 211100058), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCOffroadMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(22, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1518486046, -1653679357), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCVisualisationParkbox(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(23, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1736313705, -1653679357), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCOPSVisualisationPosition(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(24, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1149826699, 1687814400), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSFollowUpTime(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(25, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1707655918, 1687814400), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSColor(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(26, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -514926991, 1687814400), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSContrast(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(27, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -823142308, 1687814400), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSBrightness(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(28, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1573894283, 1687814400), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = vPSDefaultMode;
            this.h.invoke(this, LR59f6592c3.gjm(29, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1186704115, -717270566), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = vPSDefaultMode;
            this.h.invoke(this, LR59f6592c3.gjm(30, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -759584013, -717270566), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = vPSDefaultMode;
            this.h.invoke(this, LR59f6592c3.gjm(31, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1706797811, -717270566), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = vPSDefaultMode;
            this.h.invoke(this, LR59f6592c3.gjm(32, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1455008499, -717270566), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSDefaultView(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(33, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1156690467, 1687814400), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = vPSOPSOverlay;
            this.h.invoke(this, LR59f6592c3.gjm(34, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1254653814, 1471830875), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = vPSDynParkingMode;
            this.h.invoke(this, LR59f6592c3.gjm(35, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -925130752, 1542724693), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSSystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(36, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -545367839, -1653679357), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSExtCamConfig(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(37, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 484206632, 1687814400), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSExtCamManActivation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(38, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -2143650918, -1653679357), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPS3DBirdview(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR59f6592c3.gjm(39, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1535889469, 1676164096), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSSystemState(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(40, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1625068513, -1653679357), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showParkingPopup(DisplayContent displayContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = displayContent;
            this.h.invoke(this, LR59f6592c3.gjm(41, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -419570367, 1631368198), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void cancelParkingPopup(DisplayContent displayContent, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = displayContent;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(42, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -469944421, 1619717894), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestLifeMonitoring(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(43, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1212128786, -1653679357), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPdcSetFactoryDefault() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(44, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1582589163, 17), 44, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVpsSetFactoryDefault() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(45, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -681016976, 17), 45, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setARATargetTrailerAngle(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(46, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 888491922, 1687814400), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCManeuverAssistConfig(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(47, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -967307877, 1687814400), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCManeuverAssist(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(48, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1534582719, -1653679357), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCContinueDrivingAssist(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(49, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -243346165, 1687814400), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCIpaConfig(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(50, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1003760466, 1687814400), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = pDCPiloPaSystemState;
            this.h.invoke(this, LR59f6592c3.gjm(51, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -583171170, 810754752), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = vPSCameraCleaning;
            this.h.invoke(this, LR59f6592c3.gjm(52, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -905775705, 1462124538), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWCAutoActivation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(53, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -387422718, -1653679357), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWCSystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(54, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 136683833, -1653679357), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWCSetFactoryDefault() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(55, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1083215086, 17), 55, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showWCPopup(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(56, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 412489765, 1687814400), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void cancelWCPopup(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR59f6592c3.gjm(57, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -70528164, 1676164096), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = carArrayListUpdateInfo;
            this.h.invoke(this, LR59f6592c3.gjm(58, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -600341404, 344255931), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void enterWCPinPuk(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR59f6592c3.gjm(59, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1778672123, -412271469), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortWCEnterPinPuk() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(60, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 46782457, 17), 60, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startWCScanning() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(61, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -185654628, 17), 61, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortWCScanning() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(62, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1118127988, 17), 62, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startWCPairing(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR59f6592c3.gjm(63, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1356196550, -412271469), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortWCPairing() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(64, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1584136706, 17), 64, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startWCSoftwareUpdate(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR59f6592c3.gjm(65, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 322059377, -633848249), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortWCSoftwareUpdate() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(66, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -516658300, 17), 66, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void changeWCPin(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR59f6592c3.gjm(67, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -295183460, -412271469), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortWCChangePin() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(68, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1631361321, 17), 68, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void changeWCPanelName(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR59f6592c3.gjm(69, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 143799446, -412271469), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortWCChangePanelName() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(70, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -1201022799, 17), 70, ZOA);
            return;
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
            this.h.invoke(this, LR59f6592c3.gjm(71, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR59f6592c3.gjm(72, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR59f6592c3.gjm(73, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR59f6592c3.gjm(74, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR59f6592c3.gjm(75, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR59f6592c3.gjm(76, "org.dsi.ifc.carparkingsystem.DSICarParkingSystem", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = serviceConfiguration;
            this.h.invoke(this, LR59f6592c3.gjm(77, "org.dsi.ifc.carplay.DSICarplay", 1749696622, -2108627486), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void postButtonEvent(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR59f6592c3.gjm(78, "org.dsi.ifc.carplay.DSICarplay", 1031315929, 1676164096), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void postTouchEvent(int n, int n2, TouchEvent[] touchEventArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = touchEventArray;
            this.h.invoke(this, LR59f6592c3.gjm(79, "org.dsi.ifc.carplay.DSICarplay", -796821186, 1915459703), 79, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void postRotaryEvent(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(80, "org.dsi.ifc.carplay.DSICarplay", -1633028759, 1687814400), 80, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestNightMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR59f6592c3.gjm(81, "org.dsi.ifc.carplay.DSICarplay", -2115617535, -1653679357), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void postCharacterEvent(int n, String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = stringArray;
            this.h.invoke(this, LR59f6592c3.gjm(82, "org.dsi.ifc.carplay.DSICarplay", 640192477, -785441950), 82, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = resourceRequestArray;
            objectArray[1] = appStateRequestArray;
            objectArray[2] = string;
            this.h.invoke(this, LR59f6592c3.gjm(83, "org.dsi.ifc.carplay.DSICarplay", -1755491709, 1589838380), 83, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseUpdateMode(Resource[] resourceArray, AppState[] appStateArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceArray;
            objectArray[1] = appStateArray;
            this.h.invoke(this, LR59f6592c3.gjm(84, "org.dsi.ifc.carplay.DSICarplay", -1565578748, 531076422), 84, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseBTDeactivation() {
        try {
            this.h.invoke(this, LR59f6592c3.gjm(85, "org.dsi.ifc.carplay.DSICarplay", -1088242859, 17), 85, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestUI(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(86, "org.dsi.ifc.carplay.DSICarplay", -661169111, 1687814400), 86, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestSIRIAction(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(87, "org.dsi.ifc.carplay.DSICarplay", -414107872, 1687814400), 87, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseUpdateMainAudioType(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f6592c3.gjm(88, "org.dsi.ifc.carplay.DSICarplay", -1574408141, 1687814400), 88, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestUI2(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR59f6592c3.gjm(89, "org.dsi.ifc.carplay.DSICarplay", -1541851646, -633848249), 89, objectArray);
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

