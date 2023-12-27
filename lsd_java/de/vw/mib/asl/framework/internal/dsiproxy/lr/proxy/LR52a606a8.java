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
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DSIUnifiedTunerListener;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.DSIRadioDataListener;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public final class LR52a606a8
extends AbstractProxy
implements DSIRadioDataListener,
DSIUnifiedTunerListener {
    private static final Method[] JMS = new Method[39];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR52a606a8(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void profileReset(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(0, "org.dsi.ifc.radiodata.DSIRadioDataListener", -1689832120, 1676164096), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileResetAll(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(1, "org.dsi.ifc.radiodata.DSIRadioDataListener", 283450095, 1687814400), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR52a606a8.gjm(2, "org.dsi.ifc.radiodata.DSIRadioDataListener", 1184260366, 1043255048), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileChanged(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(3, "org.dsi.ifc.radiodata.DSIRadioDataListener", 1089708026, 1676164096), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR52a606a8.gjm(4, "org.dsi.ifc.radiodata.DSIRadioDataListener", 1112303269, 1043255048), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseRadioStationData(RadioStationDataResponse[] radioStationDataResponseArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = radioStationDataResponseArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(5, "org.dsi.ifc.radiodata.DSIRadioDataListener", -650322244, 1802113643), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = radioStationLogoResponseArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(6, "org.dsi.ifc.radiodata.DSIRadioDataListener", 603938783, -1966782441), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseDynamicDatabaseAlteration(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(7, "org.dsi.ifc.radiodata.DSIRadioDataListener", 1304177837, 1676164096), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseCountryList(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(8, "org.dsi.ifc.radiodata.DSIRadioDataListener", -925609396, -1034208512), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseDatabaseVersionInfo(int n, int n2, int n3, String string, int n4, int n5, int n6) {
        try {
            Object[] objectArray = this.p.borrowArray(7);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = string;
            objectArray[4] = RuntimeUtil.valueOf(n4);
            objectArray[5] = RuntimeUtil.valueOf(n5);
            objectArray[6] = RuntimeUtil.valueOf(n6);
            this.h.invoke(this, LR52a606a8.gjm(9, "org.dsi.ifc.radiodata.DSIRadioDataListener", -1613105218, 538024646), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDatabaseState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(10, "org.dsi.ifc.radiodata.DSIRadioDataListener", 46195372, 1676164096), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responsePersistStationLogos(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(11, "org.dsi.ifc.radiodata.DSIRadioDataListener", -1137504672, 1676164096), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = radioStationLogoResponseArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(12, "org.dsi.ifc.radiodata.DSIRadioDataListener", -1686404183, -1966782441), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseCountryRegionData(CountryRegionData[] countryRegionDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = countryRegionDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(13, "org.dsi.ifc.radiodata.DSIRadioDataListener", 674881361, -1689535898), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseCountryRegionTranslationData(CountryRegionTranslationData[] countryRegionTranslationDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = countryRegionTranslationDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(14, "org.dsi.ifc.radiodata.DSIRadioDataListener", -943633428, -17690485), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responsePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = radioStationDataArray;
            objectArray[1] = resourceLocatorArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(15, "org.dsi.ifc.radiodata.DSIRadioDataListener", 1075263135, -2035976393), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = radioStationDataArray;
            objectArray[1] = resourceLocatorArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(16, "org.dsi.ifc.radiodata.DSIRadioDataListener", -937861939, -2035976393), 16, objectArray);
            return;
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
            this.h.invoke(this, LR52a606a8.gjm(17, "org.dsi.ifc.radiodata.DSIRadioDataListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRadioText(UnifiedRadioText unifiedRadioText, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = unifiedRadioText;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(23, "org.dsi.ifc.radio.DSIUnifiedTunerListener", 1947403790, -2087877585), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAudioStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(24, "org.dsi.ifc.radio.DSIUnifiedTunerListener", 1424582358, 1676164096), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(25, "org.dsi.ifc.radio.DSIUnifiedTunerListener", 371972340, 1676164096), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dABSlideShowInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(26, "org.dsi.ifc.radio.DSIUnifiedTunerListener", 1217841997, -1001296408), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStationList(UnifiedStation[] unifiedStationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = unifiedStationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(27, "org.dsi.ifc.radio.DSIUnifiedTunerListener", -558557946, -1548827031), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void selectStationStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(28, "org.dsi.ifc.radio.DSIUnifiedTunerListener", 536699942, 1687814400), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = unifiedRadioTextPlus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(29, "org.dsi.ifc.radio.DSIUnifiedTunerListener", -1367495286, -1116760129), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSelectedStation(UnifiedStation unifiedStation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = unifiedStation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(30, "org.dsi.ifc.radio.DSIUnifiedTunerListener", -2058820697, -1344521301), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = unifiedRadioText;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(31, "org.dsi.ifc.radio.DSIUnifiedTunerListener", -1627575343, -2087877585), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = unifiedRadioTextPlus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(32, "org.dsi.ifc.radio.DSIUnifiedTunerListener", -666755561, -1116760129), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void listMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(33, "org.dsi.ifc.radio.DSIUnifiedTunerListener", -689884848, 1687814400), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void stationFollowingMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52a606a8.gjm(34, "org.dsi.ifc.radio.DSIUnifiedTunerListener", 1974798148, 1687814400), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSoftLinkSwitchStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(35, "org.dsi.ifc.radio.DSIUnifiedTunerListener", -1997638863, 1676164096), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRegModeStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(36, "org.dsi.ifc.radio.DSIUnifiedTunerListener", 1428361711, 1676164096), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDeviceUsageStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52a606a8.gjm(37, "org.dsi.ifc.radio.DSIUnifiedTunerListener", 1772684684, 1676164096), 37, objectArray);
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

