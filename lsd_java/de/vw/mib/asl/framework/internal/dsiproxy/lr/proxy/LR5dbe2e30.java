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
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.DSIUnifiedTuner;
import org.dsi.ifc.radiodata.DSIRadioData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public final class LR5dbe2e30
extends AbstractProxy
implements DSIRadioData,
DSIUnifiedTuner {
    private static final Method[] JMS = new Method[35];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5dbe2e30(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void profileChange(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(0, "org.dsi.ifc.radiodata.DSIRadioData", 787086500, 1687814400), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileCopy(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbe2e30.gjm(1, "org.dsi.ifc.radiodata.DSIRadioData", 867405578, 1676164096), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileReset(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(2, "org.dsi.ifc.radiodata.DSIRadioData", -1689832120, 1687814400), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileResetAll() {
        try {
            this.h.invoke(this, LR5dbe2e30.gjm(3, "org.dsi.ifc.radiodata.DSIRadioData", 283450095, 17), -1, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestRadioStationData(RadioStationDataRequest[] radioStationDataRequestArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = radioStationDataRequestArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(4, "org.dsi.ifc.radiodata.DSIRadioData", 666876902, -2091232198), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestRadioStationLogos(RadioStationLogoRequest[] radioStationLogoRequestArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = radioStationLogoRequestArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(5, "org.dsi.ifc.radiodata.DSIRadioData", -1782172943, -2069928368), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestDynamicDatabaseAlteration(RadioStationData radioStationData, ResourceLocator resourceLocator, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = radioStationData;
            objectArray[1] = resourceLocator;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbe2e30.gjm(6, "org.dsi.ifc.radiodata.DSIRadioData", -1074675451, -322254790), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestCountryListUpdate(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(7, "org.dsi.ifc.radiodata.DSIRadioData", -478786829, 1687814400), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestDatabaseVersionInfo(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(8, "org.dsi.ifc.radiodata.DSIRadioData", -1853081945, 1687814400), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestPersistStationLogos(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = radioStationDataArray;
            objectArray[1] = resourceLocatorArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbe2e30.gjm(9, "org.dsi.ifc.radiodata.DSIRadioData", -1360638904, -2035976393), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestCountryRegionData(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(10, "org.dsi.ifc.radiodata.DSIRadioData", -1711230365, 1687814400), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestCountryRegionTranslationData(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dbe2e30.gjm(11, "org.dsi.ifc.radiodata.DSIRadioData", 356508263, 1276482132), 11, objectArray);
            return;
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
            this.h.invoke(this, LR5dbe2e30.gjm(12, "org.dsi.ifc.radiodata.DSIRadioData", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5dbe2e30.gjm(13, "org.dsi.ifc.radiodata.DSIRadioData", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5dbe2e30.gjm(14, "org.dsi.ifc.radiodata.DSIRadioData", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5dbe2e30.gjm(15, "org.dsi.ifc.radiodata.DSIRadioData", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5dbe2e30.gjm(16, "org.dsi.ifc.radiodata.DSIRadioData", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5dbe2e30.gjm(17, "org.dsi.ifc.radiodata.DSIRadioData", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void selectStation(int n, long l, int n2, int n3, int n4, int n5) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = RuntimeUtil.valueOf(n4);
            objectArray[5] = RuntimeUtil.valueOf(n5);
            this.h.invoke(this, LR5dbe2e30.gjm(22, "org.dsi.ifc.radio.DSIUnifiedTuner", 219351994, 2019970585), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void enableRadioTextPlus(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR5dbe2e30.gjm(23, "org.dsi.ifc.radio.DSIUnifiedTuner", 881826887, 3523), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setStationFollowingMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(24, "org.dsi.ifc.radio.DSIUnifiedTuner", -140499348, 1687814400), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setListMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(25, "org.dsi.ifc.radio.DSIUnifiedTuner", 1484833990, 1687814400), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSoftLinkSwitch(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(26, "org.dsi.ifc.radio.DSIUnifiedTuner", 256615625, 1687814400), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRegMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(27, "org.dsi.ifc.radio.DSIUnifiedTuner", 176746225, 1687814400), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void switchDeviceUsage(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dbe2e30.gjm(28, "org.dsi.ifc.radio.DSIUnifiedTuner", -1944102994, 1687814400), 28, objectArray);
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

