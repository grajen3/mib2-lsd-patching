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
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public final class LR5fcb79c81
extends AbstractProxy
implements DSICarLight,
DSICarlife {
    private static final Method[] JMS = new Method[50];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5fcb79c81(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void requestIntLightRGBColorList(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = intLightRGBColorListUpdateInfo;
            this.h.invoke(this, LR5fcb79c81.gjm(0, "org.dsi.ifc.carlight.DSICarLight", -847667, -845171466), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightComingHome(TimeState timeState) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = timeState;
            this.h.invoke(this, LR5fcb79c81.gjm(1, "org.dsi.ifc.carlight.DSICarLight", 215425797, -209046552), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightLeavingHome(TimeState timeState) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = timeState;
            this.h.invoke(this, LR5fcb79c81.gjm(2, "org.dsi.ifc.carlight.DSICarLight", -1315122520, -209046552), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightSwitchOnSensitivity(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fcb79c81.gjm(3, "org.dsi.ifc.carlight.DSICarLight", 1785665195, 1687814400), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightDayLight(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(4, "org.dsi.ifc.carlight.DSICarLight", 1722302595, -1653679357), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightHeadLightSystem(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(5, "org.dsi.ifc.carlight.DSICarLight", 1660983217, -1653679357), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightGlidingLightSystem(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(6, "org.dsi.ifc.carlight.DSICarLight", 789796850, -1653679357), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightAdaptive(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(7, "org.dsi.ifc.carlight.DSICarLight", 47995843, -1653679357), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightTourist(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(8, "org.dsi.ifc.carlight.DSICarLight", -1330665837, -1653679357), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = motorwayBlinkingSettings;
            this.h.invoke(this, LR5fcb79c81.gjm(9, "org.dsi.ifc.carlight.DSICarLight", 210134939, 1045440080), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightMaskedHighBeam(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(10, "org.dsi.ifc.carlight.DSICarLight", 1754145268, -1653679357), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightAutomaticLight(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR5fcb79c81.gjm(11, "org.dsi.ifc.carlight.DSICarLight", -137551341, -647458158), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightSetFactoryDefault() {
        try {
            this.h.invoke(this, LR5fcb79c81.gjm(12, "org.dsi.ifc.carlight.DSICarLight", 396110377, 17), 12, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightLaserLight(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(13, "org.dsi.ifc.carlight.DSICarLight", -676852191, -1653679357), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightSignatureLight(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(14, "org.dsi.ifc.carlight.DSICarLight", -1971866974, -1653679357), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setExtLightHeadlightRange(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fcb79c81.gjm(15, "org.dsi.ifc.carlight.DSICarLight", -203434065, 1687814400), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightIlluminationSet(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fcb79c81.gjm(16, "org.dsi.ifc.carlight.DSICarLight", 1595320943, 1676164096), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightColour(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fcb79c81.gjm(17, "org.dsi.ifc.carlight.DSICarLight", -1971171579, 1687814400), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightState(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fcb79c81.gjm(18, "org.dsi.ifc.carlight.DSICarLight", -1659394989, 1687814400), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightEnvironment(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(19, "org.dsi.ifc.carlight.DSICarLight", -545813641, -1653679357), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightSpeed(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(20, "org.dsi.ifc.carlight.DSICarLight", 1397989971, -1653679357), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightTemperature(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(21, "org.dsi.ifc.carlight.DSICarLight", 1074517903, -1653679357), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightBrightness(IntLightBrightness intLightBrightness) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = intLightBrightness;
            this.h.invoke(this, LR5fcb79c81.gjm(22, "org.dsi.ifc.carlight.DSICarLight", -1885043034, 325305637), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightSetFactoryDefault() {
        try {
            this.h.invoke(this, LR5fcb79c81.gjm(23, "org.dsi.ifc.carlight.DSICarLight", 1698421857, 17), 23, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightIlluminationProfile(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fcb79c81.gjm(24, "org.dsi.ifc.carlight.DSICarLight", -1495290086, 1676164096), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightActiveProfile(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fcb79c81.gjm(25, "org.dsi.ifc.carlight.DSICarLight", -811898718, 1687814400), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = intLightRGBValues;
            this.h.invoke(this, LR5fcb79c81.gjm(26, "org.dsi.ifc.carlight.DSICarLight", 828495870, -683654680), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightContourLightColor(IntLightRGBValues intLightRGBValues) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = intLightRGBValues;
            this.h.invoke(this, LR5fcb79c81.gjm(27, "org.dsi.ifc.carlight.DSICarLight", -203534421, -683654680), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightFollowUpTime(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fcb79c81.gjm(28, "org.dsi.ifc.carlight.DSICarLight", 387543181, 1687814400), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setIntLightDoorContact(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fcb79c81.gjm(29, "org.dsi.ifc.carlight.DSICarLight", 1593751993, -1653679357), 29, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(30, "org.dsi.ifc.carlight.DSICarLight", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(31, "org.dsi.ifc.carlight.DSICarLight", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(32, "org.dsi.ifc.carlight.DSICarLight", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(33, "org.dsi.ifc.carlight.DSICarLight", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(34, "org.dsi.ifc.carlight.DSICarLight", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(35, "org.dsi.ifc.carlight.DSICarLight", 1300919239, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(36, "org.dsi.ifc.carlife.DSICarlife", 1749696622, -1160141618), 36, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(37, "org.dsi.ifc.carlife.DSICarlife", 1031315929, 1676164096), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = touchEventArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fcb79c81.gjm(38, "org.dsi.ifc.carlife.DSICarlife", -796821186, 1247205152), 38, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(39, "org.dsi.ifc.carlife.DSICarlife", -1633028759, 1687814400), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceArray;
            objectArray[1] = appStateArray;
            this.h.invoke(this, LR5fcb79c81.gjm(40, "org.dsi.ifc.carlife.DSICarlife", -1704243850, -820350045), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceArray;
            objectArray[1] = appStateArray;
            this.h.invoke(this, LR5fcb79c81.gjm(41, "org.dsi.ifc.carlife.DSICarlife", -913782451, -820350045), 41, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(42, "org.dsi.ifc.carlife.DSICarlife", -2115617535, -1653679357), 42, objectArray);
            return;
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
            this.h.invoke(this, LR5fcb79c81.gjm(43, "org.dsi.ifc.carlife.DSICarlife", 640192477, -785441950), 43, objectArray);
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

