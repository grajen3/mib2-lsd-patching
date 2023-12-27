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
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.carlight.DSICarLightListener;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionStateTrailer;
import org.dsi.ifc.carlight.ExtLightSensorErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;
import org.dsi.ifc.global.ResourceLocator;

public final class LR5357f4369
extends AbstractProxy
implements DSICarlifeListener,
DSICarLightListener {
    private static final Method[] JMS = new Method[65];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5357f4369(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceArray;
            objectArray[1] = appStateArray;
            this.h.invoke(this, LR5357f4369.gjm(0, "org.dsi.ifc.carlife.DSICarlifeListener", -1755491709, -820350045), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCallState(CallState callState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = callState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(1, "org.dsi.ifc.carlife.DSICarlifeListener", 2145441544, -1014726651), 1, objectArray);
            return;
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
            this.h.invoke(this, LR5357f4369.gjm(2, "org.dsi.ifc.carlife.DSICarlifeListener", -522503428, -2062025617), 2, objectArray);
            return;
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
            this.h.invoke(this, LR5357f4369.gjm(3, "org.dsi.ifc.carlife.DSICarlifeListener", 1658809285, -513227954), 3, objectArray);
            return;
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
            this.h.invoke(this, LR5357f4369.gjm(4, "org.dsi.ifc.carlife.DSICarlifeListener", 995756741, 1676164096), 4, objectArray);
            return;
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
            this.h.invoke(this, LR5357f4369.gjm(5, "org.dsi.ifc.carlife.DSICarlifeListener", -1892111725, -1214164264), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceArray;
            objectArray[1] = appStateArray;
            this.h.invoke(this, LR5357f4369.gjm(6, "org.dsi.ifc.carlife.DSICarlifeListener", 433364121, -820350045), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePlaymodeState(PlaymodeInfo playmodeInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = playmodeInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(7, "org.dsi.ifc.carlife.DSICarlifeListener", 641750781, -1646303317), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNavigationNextTurnInfo(String string, int n, int n2, int n3, int n4, int n5) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = RuntimeUtil.valueOf(n4);
            objectArray[5] = RuntimeUtil.valueOf(n5);
            this.h.invoke(this, LR5357f4369.gjm(8, "org.dsi.ifc.carlife.DSICarlifeListener", -1338383551, -1924501671), 8, objectArray);
            return;
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
            this.h.invoke(this, LR5357f4369.gjm(9, "org.dsi.ifc.carlife.DSICarlifeListener", 1112279010, -1676902285), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVideoAvailable(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(10, "org.dsi.ifc.carlife.DSICarlifeListener", 753200773, -1665395196), 10, objectArray);
            return;
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
            this.h.invoke(this, LR5357f4369.gjm(11, "org.dsi.ifc.carlife.DSICarlifeListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightViewOptions(IntLightViewOptions intLightViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = intLightViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(12, "org.dsi.ifc.carlight.DSICarLightListener", 1041945740, 3568538), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationSet1(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(13, "org.dsi.ifc.carlight.DSICarLightListener", 1675841870, 1676164096), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationSet2(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(14, "org.dsi.ifc.carlight.DSICarLightListener", 1692619086, 1676164096), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationSet3(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(15, "org.dsi.ifc.carlight.DSICarLightListener", 1709396302, 1676164096), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationSet4(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(16, "org.dsi.ifc.carlight.DSICarLightListener", 1726173518, 1676164096), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationSet5(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(17, "org.dsi.ifc.carlight.DSICarLightListener", 1742950734, 1676164096), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationSet6(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(18, "org.dsi.ifc.carlight.DSICarLightListener", 1759727950, 1676164096), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationSet7(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(19, "org.dsi.ifc.carlight.DSICarLightListener", 1776505166, 1676164096), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationSet8(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(20, "org.dsi.ifc.carlight.DSICarLightListener", 1793282382, 1676164096), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightTemperature(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(21, "org.dsi.ifc.carlight.DSICarLightListener", 2035223787, -1665395196), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightColour(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(22, "org.dsi.ifc.carlight.DSICarLightListener", -1312912147, 1676164096), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(23, "org.dsi.ifc.carlight.DSICarLightListener", -1774564608, 1676164096), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightEnvironment(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(24, "org.dsi.ifc.carlight.DSICarLightListener", 415023314, -1665395196), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightSpeed(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(25, "org.dsi.ifc.carlight.DSICarLightListener", 1282820352, -1665395196), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightBrightness(IntLightBrightness intLightBrightness, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = intLightBrightness;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(26, "org.dsi.ifc.carlight.DSICarLightListener", 913697655, 313589798), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationProfile1(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(27, "org.dsi.ifc.carlight.DSICarLightListener", 2083986834, 1676164096), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationProfile2(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(28, "org.dsi.ifc.carlight.DSICarLightListener", 2100764050, 1676164096), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationProfile3(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(29, "org.dsi.ifc.carlight.DSICarLightListener", 2117541266, 1676164096), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationProfile4(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(30, "org.dsi.ifc.carlight.DSICarLightListener", 2134318482, 1676164096), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationProfile5(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(31, "org.dsi.ifc.carlight.DSICarLightListener", -2143871598, 1676164096), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationProfile6(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(32, "org.dsi.ifc.carlight.DSICarLightListener", -2127094382, 1676164096), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationProfile7(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(33, "org.dsi.ifc.carlight.DSICarLightListener", -2110317166, 1676164096), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightIlluminationProfile8(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(34, "org.dsi.ifc.carlight.DSICarLightListener", -2093539950, 1676164096), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightActiveProfile(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(35, "org.dsi.ifc.carlight.DSICarLightListener", -927638267, 1676164096), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = intLightRGBValues;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(36, "org.dsi.ifc.carlight.DSICarLightListener", -1428796339, -695304984), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightContourLightColor(IntLightRGBValues intLightRGBValues, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = intLightRGBValues;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(37, "org.dsi.ifc.carlight.DSICarLightListener", 1817495033, -695304984), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightFollowUpTime(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(38, "org.dsi.ifc.carlight.DSICarLightListener", -27532392, 1676164096), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightDoorContact(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(39, "org.dsi.ifc.carlight.DSICarLightListener", -1757221100, -1665395196), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightRGBColorListUpdateInfo(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = intLightRGBColorListUpdateInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(40, "org.dsi.ifc.carlight.DSICarLightListener", 1888827666, -856821770), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntLightRGBColorListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(41, "org.dsi.ifc.carlight.DSICarLightListener", -1936612664, 1676164096), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseIntLightRGBColorListRA0(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = intLightRGBColorListUpdateInfo;
            objectArray[1] = intLightRGBColorListRA0Array;
            this.h.invoke(this, LR5357f4369.gjm(42, "org.dsi.ifc.carlight.DSICarLightListener", -1702963885, -739126954), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseIntLightRGBColorListRAF(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = intLightRGBColorListUpdateInfo;
            objectArray[1] = nArray;
            this.h.invoke(this, LR5357f4369.gjm(43, "org.dsi.ifc.carlight.DSICarLightListener", -1333865133, -2019903754), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightComingHome(TimeState timeState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = timeState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(44, "org.dsi.ifc.carlight.DSICarLightListener", -1280866090, -220696856), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightLeavingHome(TimeState timeState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = timeState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(45, "org.dsi.ifc.carlight.DSICarLightListener", -354416892, -220696856), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightSwitchOnSensitivity(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(46, "org.dsi.ifc.carlight.DSICarLightListener", -1553333198, 1676164096), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightDaylight(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(47, "org.dsi.ifc.carlight.DSICarLightListener", -312024494, -1665395196), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightTourist(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(48, "org.dsi.ifc.carlight.DSICarLightListener", 1777864883, -1665395196), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightAdaptive(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(49, "org.dsi.ifc.carlight.DSICarLightListener", 1772763793, -1665395196), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightHeadLightSystem(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(50, "org.dsi.ifc.carlight.DSICarLightListener", 478194987, -1665395196), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightGlidingSystem(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(51, "org.dsi.ifc.carlight.DSICarLightListener", -1470683332, -1665395196), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightViewOptions(ExtLightViewOptions extLightViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = extLightViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(52, "org.dsi.ifc.carlight.DSICarLightListener", 1885920515, 847543313), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = motorwayBlinkingSettings;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(53, "org.dsi.ifc.carlight.DSICarLightListener", 1945968740, 1033789776), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightMaskedHighBeam(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(54, "org.dsi.ifc.carlight.DSICarLightListener", -1884041233, -1665395196), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightLampErrorDetection(ExtLightLampErrorDetectionState[] extLightLampErrorDetectionStateArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = extLightLampErrorDetectionStateArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(55, "org.dsi.ifc.carlight.DSICarLightListener", -927758484, -570599496), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightLampErrorDetectionTrailer(ExtLightLampErrorDetectionStateTrailer[] extLightLampErrorDetectionStateTrailerArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = extLightLampErrorDetectionStateTrailerArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(56, "org.dsi.ifc.carlight.DSICarLightListener", -706069441, 243880278), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightSensorErrorDetection(ExtLightSensorErrorDetectionState[] extLightSensorErrorDetectionStateArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = extLightSensorErrorDetectionStateArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(57, "org.dsi.ifc.carlight.DSICarLightListener", -1434832692, 1059640276), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightAutomaticLight(boolean bl, boolean bl2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(58, "org.dsi.ifc.carlight.DSICarLightListener", 519294990, -1263655781), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeIntLightSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5357f4369.gjm(59, "org.dsi.ifc.carlight.DSICarLightListener", 1806352743, -1653679357), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeExtLightSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5357f4369.gjm(60, "org.dsi.ifc.carlight.DSICarLightListener", 487264303, -1653679357), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightLaserLight(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(61, "org.dsi.ifc.carlight.DSICarLightListener", 2121888754, -1665395196), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightSignatureLight(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5357f4369.gjm(62, "org.dsi.ifc.carlight.DSICarLightListener", -1315151714, -1665395196), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExtLightHeadlightRange(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5357f4369.gjm(63, "org.dsi.ifc.carlight.DSICarLightListener", 436569771, 1676164096), 63, objectArray);
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

