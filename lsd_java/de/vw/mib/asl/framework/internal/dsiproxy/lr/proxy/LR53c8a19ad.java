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
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;
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
import org.dsi.ifc.carcomfort.UGDOSoftkeys;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistance;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.global.CarBCSpeed;

public final class LR53c8a19ad
extends AbstractProxy
implements DSICarComfort,
DSICarDriverAssistance {
    private static final Method[] JMS = new Method[167];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR53c8a19ad(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setRGSBeltPretensionerDataFront(RGSBeltPretensionData rGSBeltPretensionData) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = rGSBeltPretensionData;
            this.h.invoke(this, LR53c8a19ad.gjm(0, "org.dsi.ifc.carcomfort.DSICarComfort", 827017587, -415378654), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRGSBeltPretensionerDataRear(RGSBeltPretensionData rGSBeltPretensionData) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = rGSBeltPretensionData;
            this.h.invoke(this, LR53c8a19ad.gjm(1, "org.dsi.ifc.carcomfort.DSICarComfort", 651414853, -415378654), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRGSPreCrashSystem(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(2, "org.dsi.ifc.carcomfort.DSICarComfort", -1000049845, -1653679357), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRgsSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(3, "org.dsi.ifc.carcomfort.DSICarComfort", -1835008874, 17), 3, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRGSPreSenseSystem(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(4, "org.dsi.ifc.carcomfort.DSICarComfort", -1950103014, -1653679357), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRGSPreSenseWarning(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(5, "org.dsi.ifc.carcomfort.DSICarComfort", 171975145, 1687814400), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRGSLocalHazardInformation(RGSLocalHazardInformation rGSLocalHazardInformation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = rGSLocalHazardInformation;
            this.h.invoke(this, LR53c8a19ad.gjm(6, "org.dsi.ifc.carcomfort.DSICarComfort", 1088958560, -226402707), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = doorLockingComfortOpenSettings;
            this.h.invoke(this, LR53c8a19ad.gjm(7, "org.dsi.ifc.carcomfort.DSICarComfort", -412265029, 1964211751), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = doorLockingTheftWarningSettings;
            this.h.invoke(this, LR53c8a19ad.gjm(8, "org.dsi.ifc.carcomfort.DSICarComfort", 2096354949, -1358970210), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingClBootOpen(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(9, "org.dsi.ifc.carcomfort.DSICarComfort", 1098104278, -1653679357), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingBootOpen(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(10, "org.dsi.ifc.carcomfort.DSICarComfort", 2022298081, -1653679357), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingBootClose(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(11, "org.dsi.ifc.carcomfort.DSICarComfort", -728320937, -1653679357), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startDoorLockingRemoteLockUnlock(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR53c8a19ad.gjm(12, "org.dsi.ifc.carcomfort.DSICarComfort", 1364658306, -633848249), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortDoorLockingRemoteLockUnlock() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(13, "org.dsi.ifc.carcomfort.DSICarComfort", -1020807297, 17), 13, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void sendDoorLockingRemoteLockUnlockSignature(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR53c8a19ad.gjm(14, "org.dsi.ifc.carcomfort.DSICarComfort", -686960921, -633848249), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startDoorLockingRemoteBlinking(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(15, "org.dsi.ifc.carcomfort.DSICarComfort", 1219336809, 1687814400), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startDoorLockingRemoteHorn(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(16, "org.dsi.ifc.carcomfort.DSICarComfort", 1161206874, 1687814400), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingUnlockingMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(17, "org.dsi.ifc.carcomfort.DSICarComfort", 264859531, 1687814400), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingAutoLock(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(18, "org.dsi.ifc.carcomfort.DSICarComfort", -1775987009, 1687814400), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingAutoUnlock(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(19, "org.dsi.ifc.carcomfort.DSICarComfort", 802809665, -1653679357), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingClBootLock(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(20, "org.dsi.ifc.carcomfort.DSICarComfort", 571653334, -1653679357), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingMirrorProtection(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(21, "org.dsi.ifc.carcomfort.DSICarComfort", 350674126, -1653679357), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingConfirmation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(22, "org.dsi.ifc.carcomfort.DSICarComfort", -782410757, -1653679357), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingRainClosing(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(23, "org.dsi.ifc.carcomfort.DSICarComfort", -278116794, -1653679357), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = doorLockingRearBlind;
            this.h.invoke(this, LR53c8a19ad.gjm(24, "org.dsi.ifc.carcomfort.DSICarComfort", -1079500635, -850984441), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(25, "org.dsi.ifc.carcomfort.DSICarComfort", -2019103787, 17), 25, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestDoorLockingUserList(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = doorLockingUserListUpdateInfo;
            this.h.invoke(this, LR53c8a19ad.gjm(26, "org.dsi.ifc.carcomfort.DSICarComfort", -664260402, 237381767), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingUserListUpdateInfo;
            objectArray[1] = doorLockingUserListRA1Array;
            this.h.invoke(this, LR53c8a19ad.gjm(27, "org.dsi.ifc.carcomfort.DSICarComfort", -1485651113, 1040330213), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = doorLockingUserListUpdateInfo;
            objectArray[1] = nArray;
            this.h.invoke(this, LR53c8a19ad.gjm(28, "org.dsi.ifc.carcomfort.DSICarComfort", -1133329577, -937416057), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingActiveUser(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(29, "org.dsi.ifc.carcomfort.DSICarComfort", 1297840591, 1687814400), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = doorLockingUserProfileOnOff;
            this.h.invoke(this, LR53c8a19ad.gjm(30, "org.dsi.ifc.carcomfort.DSICarComfort", 1851543937, -1605271559), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startDoorLockingUserProfileControl(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53c8a19ad.gjm(31, "org.dsi.ifc.carcomfort.DSICarComfort", 2067561714, 1676164096), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortDoorLockingUserProfileControl() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(32, "org.dsi.ifc.carcomfort.DSICarComfort", 1840822335, 17), 32, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingWindowAutoClose(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(33, "org.dsi.ifc.carcomfort.DSICarComfort", 1736789059, -1653679357), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorlockingBlindsControl(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(34, "org.dsi.ifc.carcomfort.DSICarComfort", -845946876, 1687814400), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorlockingBlindsControlExtended(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(35, "org.dsi.ifc.carcomfort.DSICarComfort", 646813558, 1687814400), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingLeftSideBlindControl(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(36, "org.dsi.ifc.carcomfort.DSICarComfort", 49042527, 1687814400), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingRightSideBlindControl(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(37, "org.dsi.ifc.carcomfort.DSICarComfort", -1445427623, 1687814400), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingTurnIndRepeat(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(38, "org.dsi.ifc.carcomfort.DSICarComfort", -1962788788, -1653679357), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDoorLockingKeyless(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(39, "org.dsi.ifc.carcomfort.DSICarComfort", 1712315090, -1653679357), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWiperServicePosition(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(40, "org.dsi.ifc.carcomfort.DSICarComfort", 1794410415, -1653679357), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWiperRainSensorOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(41, "org.dsi.ifc.carcomfort.DSICarComfort", -1372322894, -1653679357), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWiperRainSensorConfig(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(42, "org.dsi.ifc.carcomfort.DSICarComfort", -1373698694, 1687814400), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWiperRearWiping(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(43, "org.dsi.ifc.carcomfort.DSICarComfort", 644038520, -1653679357), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWiperTearsWiping(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(44, "org.dsi.ifc.carcomfort.DSICarComfort", -506098333, -1653679357), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWiperWinterPosition(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(45, "org.dsi.ifc.carcomfort.DSICarComfort", -1408039903, -1653679357), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEasyEntrySteeringColumn(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(46, "org.dsi.ifc.carcomfort.DSICarComfort", -1978382919, -1653679357), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setWiperSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(47, "org.dsi.ifc.carcomfort.DSICarComfort", -2048480370, 17), 47, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOLearningData(UGDOLearningData uGDOLearningData) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOLearningData;
            this.h.invoke(this, LR53c8a19ad.gjm(48, "org.dsi.ifc.carcomfort.DSICarComfort", -52844644, 170942325), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showUGDOPopup(UGDOContent uGDOContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOContent;
            this.h.invoke(this, LR53c8a19ad.gjm(49, "org.dsi.ifc.carcomfort.DSICarComfort", 664277509, 562629727), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void cancelUGDOPopup(UGDOContent uGDOContent) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOContent;
            this.h.invoke(this, LR53c8a19ad.gjm(50, "org.dsi.ifc.carcomfort.DSICarComfort", 1256314682, 562629727), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteUGDOButton(UGDOSoftkeys uGDOSoftkeys) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOSoftkeys;
            this.h.invoke(this, LR53c8a19ad.gjm(51, "org.dsi.ifc.carcomfort.DSICarComfort", -1890711348, -1057754382), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(52, "org.dsi.ifc.carcomfort.DSICarComfort", 255952481, 17), 52, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDODestinationReached(UGDODestinationReached uGDODestinationReached) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDODestinationReached;
            this.h.invoke(this, LR53c8a19ad.gjm(53, "org.dsi.ifc.carcomfort.DSICarComfort", 955008238, -956351906), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOOpenDoor;
            this.h.invoke(this, LR53c8a19ad.gjm(54, "org.dsi.ifc.carcomfort.DSICarComfort", -1393411855, -1166067322), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOSynchronisation;
            this.h.invoke(this, LR53c8a19ad.gjm(55, "org.dsi.ifc.carcomfort.DSICarComfort", 2100307515, -1351144006), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOSynchronisation;
            this.h.invoke(this, LR53c8a19ad.gjm(56, "org.dsi.ifc.carcomfort.DSICarComfort", 1043736007, -1351144006), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startUGDOLearning(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53c8a19ad.gjm(57, "org.dsi.ifc.carcomfort.DSICarComfort", -1293654778, 1676164096), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortUGDOLearning() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(58, "org.dsi.ifc.carcomfort.DSICarComfort", -2139213208, 17), 58, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestUGDOButtonList(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = uGDOButtonListUpdateInfo;
            this.h.invoke(this, LR53c8a19ad.gjm(59, "org.dsi.ifc.carcomfort.DSICarComfort", 837073451, 1240672381), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA0Array;
            this.h.invoke(this, LR53c8a19ad.gjm(60, "org.dsi.ifc.carcomfort.DSICarComfort", -1477838414, -1142651250), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA1Array;
            this.h.invoke(this, LR53c8a19ad.gjm(61, "org.dsi.ifc.carcomfort.DSICarComfort", -1461061198, 921273998), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA2Array;
            this.h.invoke(this, LR53c8a19ad.gjm(62, "org.dsi.ifc.carcomfort.DSICarComfort", -1444283982, -1309833586), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA3Array;
            this.h.invoke(this, LR53c8a19ad.gjm(63, "org.dsi.ifc.carcomfort.DSICarComfort", -1427506766, 754091662), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA4Array;
            this.h.invoke(this, LR53c8a19ad.gjm(64, "org.dsi.ifc.carcomfort.DSICarComfort", -1410729550, -1477015922), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = uGDOButtonListRA5Array;
            this.h.invoke(this, LR53c8a19ad.gjm(65, "org.dsi.ifc.carcomfort.DSICarComfort", -1393952334, 586909326), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = uGDOButtonListUpdateInfo;
            objectArray[1] = nArray;
            this.h.invoke(this, LR53c8a19ad.gjm(66, "org.dsi.ifc.carcomfort.DSICarComfort", -1108739662, 65940093), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRDKSystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(67, "org.dsi.ifc.carcomfort.DSICarComfort", 1608462318, -1653679357), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRDKTireSetupSelectedTire(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(68, "org.dsi.ifc.carcomfort.DSICarComfort", 914872463, 1687814400), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRDKSpeedLimit(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(69, "org.dsi.ifc.carcomfort.DSICarComfort", 1084371148, 1687814400), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRDKTireChanged() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(70, "org.dsi.ifc.carcomfort.DSICarComfort", 1784146309, 17), 70, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRDKPressureChanged() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(71, "org.dsi.ifc.carcomfort.DSICarComfort", 1837436424, 17), 71, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestRDKLifeMonitoring() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(72, "org.dsi.ifc.carcomfort.DSICarComfort", -482545885, 17), 72, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRDKPressureLevel(byte by) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(by);
            this.h.invoke(this, LR53c8a19ad.gjm(73, "org.dsi.ifc.carcomfort.DSICarComfort", 1040136078, 2103651840), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRDKSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(74, "org.dsi.ifc.carcomfort.DSICarComfort", 1475208641, 17), 74, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMirrorLowering(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(75, "org.dsi.ifc.carcomfort.DSICarComfort", -1747353094, -1653679357), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMirrorSyncAdjust(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(76, "org.dsi.ifc.carcomfort.DSICarComfort", 545421941, -1653679357), 76, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMirrorFolding(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(77, "org.dsi.ifc.carcomfort.DSICarComfort", -1242768926, -1653679357), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMirrorDimming(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(78, "org.dsi.ifc.carcomfort.DSICarComfort", 1368515182, -1653679357), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMirrorHeating(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(79, "org.dsi.ifc.carcomfort.DSICarComfort", 1714422331, -1653679357), 79, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMirrorSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(80, "org.dsi.ifc.carcomfort.DSICarComfort", -1924340643, 17), 80, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBrakeElectricalParking(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(81, "org.dsi.ifc.carcomfort.DSICarComfort", 476753394, -1653679357), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBrakeAutoHold(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(82, "org.dsi.ifc.carcomfort.DSICarComfort", -1940886935, 1687814400), 82, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBrakeEscMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(83, "org.dsi.ifc.carcomfort.DSICarComfort", 75185255, 1687814400), 83, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBrakeHdcMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(84, "org.dsi.ifc.carcomfort.DSICarComfort", 1987794668, -1653679357), 84, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHMIIsReady(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(85, "org.dsi.ifc.carcomfort.DSICarComfort", 1816829296, -1653679357), 85, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showDoorLockingPrompt(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(86, "org.dsi.ifc.carcomfort.DSICarComfort", 98561331, 1687814400), 86, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void cancelDoorLockingPrompt(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(87, "org.dsi.ifc.carcomfort.DSICarComfort", 676705693, 1687814400), 87, objectArray);
            return;
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
            this.h.invoke(this, LR53c8a19ad.gjm(88, "org.dsi.ifc.carcomfort.DSICarComfort", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR53c8a19ad.gjm(89, "org.dsi.ifc.carcomfort.DSICarComfort", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR53c8a19ad.gjm(90, "org.dsi.ifc.carcomfort.DSICarComfort", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR53c8a19ad.gjm(91, "org.dsi.ifc.carcomfort.DSICarComfort", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR53c8a19ad.gjm(92, "org.dsi.ifc.carcomfort.DSICarComfort", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR53c8a19ad.gjm(93, "org.dsi.ifc.carcomfort.DSICarComfort", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCGongState(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(94, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -431180799, -1653679357), 94, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCGongVolume(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(95, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1356877255, 1687814400), 95, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCDrivingProgram(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(96, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -786615473, 1687814400), 96, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCTimeGap(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(97, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 2147350462, 1687814400), 97, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCDefaultMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(98, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1162102012, 1687814400), 98, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCCurveAssist(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(99, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1845517205, -1653679357), 99, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCSpeedLimitAdoption(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(100, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1064882606, -1653679357), 100, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCTrafficJamAssist(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(101, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -155252330, -1653679357), 101, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCSpeedLimitOffset(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(102, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1151403661, 1687814400), 102, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = aCCDistanceWarning;
            this.h.invoke(this, LR53c8a19ad.gjm(103, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1647981111, -1144977501), 103, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setACCSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(104, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1329524077, 17), 104, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPACCSensibility(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(105, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1122590054, -1653679357), 105, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPACCMaxSpeed(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53c8a19ad.gjm(106, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1266854299, 1676164096), 106, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPACCDrivingProgram(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(107, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -2053404747, 1687814400), 107, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAWVSystem(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(108, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -2100752847, 1687814400), 108, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAWVWarning(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(109, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -201826917, -1653679357), 109, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAWVGong(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(110, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1954008661, -1653679357), 110, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAWVGongVolume(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(111, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1850707168, 1687814400), 111, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAWVBrakeJerk(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(112, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1443061871, -1653679357), 112, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = aWVEmergencyBrake;
            this.h.invoke(this, LR53c8a19ad.gjm(113, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1828820751, -1895219541), 113, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAWVDistanceWarning(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(114, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1050011348, -1653679357), 114, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAWVWarningTimegap(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(115, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 2612712, 1687814400), 115, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAWVSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(116, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1331097578, 17), 116, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSWABrightness(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(117, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -508561795, 1687814400), 117, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSWAWarningTime(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(118, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1139642230, 1687814400), 118, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSWAFrequency(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(119, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1459072031, 1687814400), 119, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSWASystem(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(120, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1069284166, 1687814400), 120, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSWAGongState(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(121, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1778548037, -1653679357), 121, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSWAGongVolume(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(122, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1424359313, 1687814400), 122, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSWARCTA(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(123, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 235723532, -1653679357), 123, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSWAExitAssist(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(124, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1210284735, -1653679357), 124, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVActivation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(125, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -720838182, -1653679357), 125, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVContrast(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(126, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1097138373, 1687814400), 126, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVBrightness(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(127, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 280287367, 1687814400), 127, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVObjectDetection(NVObjectDetection nVObjectDetection) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nVObjectDetection;
            this.h.invoke(this, LR53c8a19ad.gjm(128, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1908002537, -1816038011), 128, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVColorPA(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(129, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -8544366, 1687814400), 129, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVDesignPA(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(130, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1856424739, 1687814400), 130, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVDisplay(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(131, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 766159805, 1687814400), 131, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVZoomPanning(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(132, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -370559650, 1687814400), 132, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVSound(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(133, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -90197501, 1687814400), 133, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVSymbol(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(134, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1462905459, -1653679357), 134, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(135, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -991403446, 17), 135, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVWarningTimegap(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(136, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1818273209, 1687814400), 136, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNVSystem(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(137, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -298963597, -1653679357), 137, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLDWWarningTime(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(138, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -2128344513, 1687814400), 138, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLDWSteeringWheelVibration(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(139, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1525793667, 1687814400), 139, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHCAInterventionStyle(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(140, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -348111438, 1687814400), 140, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setHCAToleranceLevel(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(141, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 282760721, 1687814400), 141, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLdwhcaSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(142, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -438299660, 17), 142, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLDWHCASystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(143, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1922986088, -1653679357), 143, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLDWHCAWarningSound(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(144, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 836222768, -1665395196), 144, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTSDSystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(145, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1823556235, -1653679357), 145, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = tSDRoadSignFilter;
            this.h.invoke(this, LR53c8a19ad.gjm(146, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 766159771, 1337086519), 146, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTsdSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(147, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1952337787, 17), 147, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = carBCSpeed;
            this.h.invoke(this, LR53c8a19ad.gjm(148, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -928614457, -2079242941), 148, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = carBCSpeed;
            this.h.invoke(this, LR53c8a19ad.gjm(149, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -112204754, 745743666), 149, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTSDSpeedWarningAcoustics(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(150, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1841208635, -1653679357), 150, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMKESystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(151, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1858320676, -1653679357), 151, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMKESetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(152, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 152959551, 17), 152, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPASystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(153, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1012094812, -1653679357), 153, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPASetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(154, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -1155546939, 17), 154, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPAConfigInformation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(155, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1818844116, -1653679357), 155, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPAConfigWarning(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(156, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1547782424, -1653679357), 156, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPAWarningTimegap(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53c8a19ad.gjm(157, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", -714815203, 1687814400), 157, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCurveAssistSystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(158, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1077176925, -1653679357), 158, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCurveAssistSetFactoryDefault() {
        try {
            this.h.invoke(this, LR53c8a19ad.gjm(159, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 2018863975, 17), 159, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setFTASystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53c8a19ad.gjm(160, "org.dsi.ifc.cardriverassistance.DSICarDriverAssistance", 1163791091, -1653679357), 160, objectArray);
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

