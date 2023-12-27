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
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.DSINavServicesAPIListener;
import org.dsi.ifc.navservicesapi.TunerData;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

public final class LR5903d4a1b
extends AbstractProxy
implements DSIDataConfigurationListener,
DSINavServicesAPIListener {
    private static final Method[] JMS = new Method[38];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5903d4a1b(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void restoreFactorySettingsResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(0, "org.dsi.ifc.networking.DSIDataConfigurationListener", -1249184069, 1687814400), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAvailableProfiles(CDataProfile[] cDataProfileArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = cDataProfileArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(1, "org.dsi.ifc.networking.DSIDataConfigurationListener", 2136388917, -1325784054), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateActiveProfile(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5903d4a1b.gjm(2, "org.dsi.ifc.networking.DSIDataConfigurationListener", -283697244, 1676164096), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRoamingState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5903d4a1b.gjm(3, "org.dsi.ifc.networking.DSIDataConfigurationListener", -691460226, 1676164096), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateConnectionMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5903d4a1b.gjm(4, "org.dsi.ifc.networking.DSIDataConfigurationListener", 1057062634, 1676164096), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDataRequest(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5903d4a1b.gjm(5, "org.dsi.ifc.networking.DSIDataConfigurationListener", 1909528229, 1676164096), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRequestSetting(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5903d4a1b.gjm(6, "org.dsi.ifc.networking.DSIDataConfigurationListener", 1610123174, 1043255048), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDataProfileResponse(CDataProfile cDataProfile, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = cDataProfile;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(7, "org.dsi.ifc.networking.DSIDataConfigurationListener", -1289302479, 1157101275), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void automaticProfileResponse(int n, CDataProfile cDataProfile, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = cDataProfile;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5903d4a1b.gjm(8, "org.dsi.ifc.networking.DSIDataConfigurationListener", -724231563, -1017859126), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRoamingStateResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(9, "org.dsi.ifc.networking.DSIDataConfigurationListener", 1343126955, 1687814400), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setConnectionModeResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(10, "org.dsi.ifc.networking.DSIDataConfigurationListener", 2045412085, 1687814400), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRequestSettingResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(11, "org.dsi.ifc.networking.DSIDataConfigurationListener", -1715391704, 1687814400), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acceptDataRequestResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(12, "org.dsi.ifc.networking.DSIDataConfigurationListener", 861108787, 1687814400), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void resetPacketCounterResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(13, "org.dsi.ifc.networking.DSIDataConfigurationListener", 466173802, 1687814400), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePacketCounter(CPacketCounter cPacketCounter, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = cPacketCounter;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(14, "org.dsi.ifc.networking.DSIDataConfigurationListener", -2143225060, -1182249309), 14, objectArray);
            return;
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
            this.h.invoke(this, LR5903d4a1b.gjm(15, "org.dsi.ifc.networking.DSIDataConfigurationListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void createExportFile(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5903d4a1b.gjm(16, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", -503889799, -1600866162), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void importFile(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5903d4a1b.gjm(17, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 914728574, -1600866162), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void resetToFactorySettingsResult() {
        try {
            this.h.invoke(this, LR5903d4a1b.gjm(18, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 902702266, 17), 18, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateReceivableStations(TunerData[] tunerDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tunerDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(19, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 428836069, -1455132039), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(20, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 1882612247, -1178098921), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLanguage(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(21, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", -1235636013, -645498553), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNavigationState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5903d4a1b.gjm(22, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 1236122486, 1676164096), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void initiatePhoneCallToADBEntry(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR5903d4a1b.gjm(23, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", -688418417, -412271469), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIconDirectory(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(24, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 541202575, -645498553), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void phoneDialNumber(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR5903d4a1b.gjm(25, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 1546206326, -412271469), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void audioRequest(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5903d4a1b.gjm(26, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 1309983202, -1653679357), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteCustomerDataResult() {
        try {
            this.h.invoke(this, LR5903d4a1b.gjm(27, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 1705675640, 17), 27, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setBrowserURL(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5903d4a1b.gjm(28, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", -1636457198, -633848249), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void prepareAndPlayTTS2Announcement(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5903d4a1b.gjm(29, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", -1090201479, -633848249), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortTTS2Announcement() {
        try {
            this.h.invoke(this, LR5903d4a1b.gjm(30, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 1270167320, 17), 30, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCurrentPosition(float f2, float f3, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(f3);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(31, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 786990829, 1824159717), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void efiLinkSelectedResult(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5903d4a1b.gjm(32, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", -1356743494, -1653679357), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void selectRemoteSearchLocationResult(AddressData[] addressDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = addressDataArray;
            this.h.invoke(this, LR5903d4a1b.gjm(33, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", -239009705, -266440678), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void checkLicense(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5903d4a1b.gjm(34, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", -1912581370, 1687814400), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void checkDataConnection() {
        try {
            this.h.invoke(this, LR5903d4a1b.gjm(35, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", -981231985, 17), 35, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestRrdForLocationDataResult(int n, String[] stringArray, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = stringArray;
            objectArray[2] = nArray;
            this.h.invoke(this, LR5903d4a1b.gjm(36, "org.dsi.ifc.navservicesapi.DSINavServicesAPIListener", 85145814, -1284742046), 36, objectArray);
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

