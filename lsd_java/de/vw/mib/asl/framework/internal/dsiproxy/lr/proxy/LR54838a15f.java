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
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.careco.StartStopListUpdateInfo;

public final class LR54838a15f
extends AbstractProxy
implements DSICarDrivingCharacteristics,
DSICarEco {
    private static final Method[] JMS = new Method[60];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR54838a15f(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setHMIIsReady(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(0, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1816829296, -1653679357), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSuspensionControlLiftMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(1, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1632037554, -1653679357), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSuspensionControlCarJackMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(2, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 755990691, -1653679357), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSuspensionControlTrailerMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(3, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -1922893116, -1653679357), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSuspensionControlLoadingMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(4, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 377659561, -1653679357), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSuspensionControlActiveProfile(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54838a15f.gjm(5, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1520498264, 1687814400), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSuspensionControlSnowChainMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(6, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1480471048, -1653679357), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSuspensionControlActiveMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54838a15f.gjm(7, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1559327062, 1687814400), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void seteABCEasyEntry(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(8, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -1506198167, -1653679357), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void seteABCPitchControl(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(9, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 827540805, -1653679357), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void seteABCSpecialPosition(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(10, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1481406883, -1653679357), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void seteABCPreview(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54838a15f.gjm(11, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 506234763, 1687814400), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCharismaActiveProfile(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54838a15f.gjm(12, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -1029262493, 1687814400), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCharismaActiveOperationMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54838a15f.gjm(13, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -1022795567, 1687814400), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCharismaTrailerSetting(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(14, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -937388282, -1653679357), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCharismaProgButton(CharismaProgButton charismaProgButton) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = charismaProgButton;
            this.h.invoke(this, LR54838a15f.gjm(15, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1473578386, 619323385), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestCharismaProfileFunction(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = charismaSetupTableWithoutOptionMaskArray;
            this.h.invoke(this, LR54838a15f.gjm(16, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1403787254, 187343945), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestCharismaList(CharismaListUpdateInfo charismaListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = charismaListUpdateInfo;
            this.h.invoke(this, LR54838a15f.gjm(17, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -166355960, -854988625), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showCharismaPopup(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR54838a15f.gjm(18, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -265945026, 1676164096), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void cancelCharismaPopup(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR54838a15f.gjm(19, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -1826167281, 1676164096), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCharismaSetFactoryDefault() {
        try {
            this.h.invoke(this, LR54838a15f.gjm(20, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -661327329, 17), 20, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCharismaSound(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(21, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 248181898, -1653679357), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void showTADPopup(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR54838a15f.gjm(22, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -413181242, 1676164096), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void cancelTADPopup(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR54838a15f.gjm(23, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1692796294, 1676164096), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTADSetFactoryDefault() {
        try {
            this.h.invoke(this, LR54838a15f.gjm(24, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -112906808, 17), 24, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTADMaxMinAngleReset(TADMaxMinAngleReset tADMaxMinAngleReset) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = tADMaxMinAngleReset;
            this.h.invoke(this, LR54838a15f.gjm(25, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -1803474340, 1728467928), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSpoilerSetFactoryDefault() {
        try {
            this.h.invoke(this, LR54838a15f.gjm(26, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 775562410, 17), 26, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSpoilerPositionSelection(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54838a15f.gjm(27, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -1201837754, 1687814400), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSpoilerActuation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(28, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 126230032, -1653679357), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSpoilerSystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(29, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1985544899, -1653679357), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSoundSetFactoryDefault() {
        try {
            this.h.invoke(this, LR54838a15f.gjm(30, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 33511105, 17), 30, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSoundStyle(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54838a15f.gjm(31, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1505645063, 1687814400), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSoundSystemOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(32, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -1980198571, -1653679357), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSoundOnOff(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(33, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -1207494905, -1653679357), 33, objectArray);
            return;
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
            this.h.invoke(this, LR54838a15f.gjm(34, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR54838a15f.gjm(35, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR54838a15f.gjm(36, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR54838a15f.gjm(37, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR54838a15f.gjm(38, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR54838a15f.gjm(39, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = bCmEListUpdateInfo;
            this.h.invoke(this, LR54838a15f.gjm(40, "org.dsi.ifc.careco.DSICarEco", -777748864, 777275727), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBCmELiveTip(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(41, "org.dsi.ifc.careco.DSICarEco", 697895406, -1600866162), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBcmeSetFactoryDefault() {
        try {
            this.h.invoke(this, LR54838a15f.gjm(42, "org.dsi.ifc.careco.DSICarEco", 1938928284, 17), 42, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestStartStopProhibitList(StartStopListUpdateInfo startStopListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = startStopListUpdateInfo;
            this.h.invoke(this, LR54838a15f.gjm(43, "org.dsi.ifc.careco.DSICarEco", -417373843, -1556977295), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestStartStopRestartList(StartStopListUpdateInfo startStopListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = startStopListUpdateInfo;
            this.h.invoke(this, LR54838a15f.gjm(44, "org.dsi.ifc.careco.DSICarEco", -843252755, -1556977295), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestStartStopRestartProhibitList(StartStopListUpdateInfo startStopListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = startStopListUpdateInfo;
            this.h.invoke(this, LR54838a15f.gjm(45, "org.dsi.ifc.careco.DSICarEco", 1283837854, -1556977295), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestBCmEConsumerListConsumption(BCmEListUpdateInfo bCmEListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = bCmEListUpdateInfo;
            this.h.invoke(this, LR54838a15f.gjm(46, "org.dsi.ifc.careco.DSICarEco", 338303812, 777275727), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestBCmEConsumerListRange(BCmEListUpdateInfo bCmEListUpdateInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = bCmEListUpdateInfo;
            this.h.invoke(this, LR54838a15f.gjm(47, "org.dsi.ifc.careco.DSICarEco", -1228798671, 777275727), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRDSetFactoryDefault() {
        try {
            this.h.invoke(this, LR54838a15f.gjm(48, "org.dsi.ifc.careco.DSICarEco", -1702245714, 17), 48, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEASystem(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(49, "org.dsi.ifc.careco.DSICarEco", -1027711115, -1653679357), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEAPedalJerk(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(50, "org.dsi.ifc.careco.DSICarEco", -441393189, -1653679357), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEASetFactoryDefault() {
        try {
            this.h.invoke(this, LR54838a15f.gjm(51, "org.dsi.ifc.careco.DSICarEco", 1894542831, 17), 51, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEAFreeWheeling(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(52, "org.dsi.ifc.careco.DSICarEco", 1181212967, -1653679357), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEAStartStop(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54838a15f.gjm(53, "org.dsi.ifc.careco.DSICarEco", 458990381, -1653679357), 53, objectArray);
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

