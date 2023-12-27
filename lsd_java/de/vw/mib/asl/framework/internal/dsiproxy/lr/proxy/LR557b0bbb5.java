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
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.AudioStatus;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DSIAMFMTunerListener;
import org.dsi.ifc.radio.DSIDABTunerListener;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.IntellitextMenu;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public final class LR557b0bbb5
extends AbstractProxy
implements DSIDABTunerListener,
DSIAMFMTunerListener {
    private static final Method[] JMS = new Method[76];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR557b0bbb5(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void profileReset(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(0, "org.dsi.ifc.radio.DSIDABTunerListener", -1689832120, 1676164096), -1, objectArray);
            return;
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
            this.h.invoke(this, LR557b0bbb5.gjm(1, "org.dsi.ifc.radio.DSIDABTunerListener", 283450095, 1687814400), -1, objectArray);
            return;
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
            this.h.invoke(this, LR557b0bbb5.gjm(2, "org.dsi.ifc.radio.DSIDABTunerListener", 1184260366, 1043255048), -1, objectArray);
            return;
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
            this.h.invoke(this, LR557b0bbb5.gjm(3, "org.dsi.ifc.radio.DSIDABTunerListener", 1089708026, 1676164096), -1, objectArray);
            return;
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
            this.h.invoke(this, LR557b0bbb5.gjm(4, "org.dsi.ifc.radio.DSIDABTunerListener", 1112303269, 1043255048), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRadioText(DABRadioText dABRadioText, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dABRadioText;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(5, "org.dsi.ifc.radio.DSIDABTunerListener", 1947403790, 1880443989), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSyncStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(6, "org.dsi.ifc.radio.DSIDABTunerListener", -1952002256, 1676164096), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateServiceList(ServiceInfo[] serviceInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(7, "org.dsi.ifc.radio.DSIDABTunerListener", -539878327, -704460289), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = ensembleInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(8, "org.dsi.ifc.radio.DSIDABTunerListener", 572700038, 74293957), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSelectedService(ServiceInfo serviceInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(9, "org.dsi.ifc.radio.DSIDABTunerListener", 101596047, 505129260), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSelectedComponent(ComponentInfo componentInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = componentInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(10, "org.dsi.ifc.radio.DSIDABTunerListener", 1318963300, -1505778758), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = frequencyInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(11, "org.dsi.ifc.radio.DSIDABTunerListener", -1392177740, -2057261434), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEnsembleList(EnsembleInfo[] ensembleInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = ensembleInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(12, "org.dsi.ifc.radio.DSIDABTunerListener", 636186942, -1366246895), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateComponentList(ComponentInfo[] componentInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = componentInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(13, "org.dsi.ifc.radio.DSIDABTunerListener", 1740869474, 248457129), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dataServiceInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(14, "org.dsi.ifc.radio.DSIDABTunerListener", 1432978903, -1599988199), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = frequencyInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(15, "org.dsi.ifc.radio.DSIDABTunerListener", 1189386798, 264929374), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateQuality(short s, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(s);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(16, "org.dsi.ifc.radio.DSIDABTunerListener", 1801365197, -254492666), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDRCSwitchStatus(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(17, "org.dsi.ifc.radio.DSIDABTunerListener", -418347411, -1665395196), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLinkingSwitchStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(18, "org.dsi.ifc.radio.DSIDABTunerListener", -94097015, 1676164096), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateFrequencyTableSwitchStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(19, "org.dsi.ifc.radio.DSIDABTunerListener", 1445180943, 1676164096), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLinkingStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(20, "org.dsi.ifc.radio.DSIDABTunerListener", -430727384, 1676164096), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLinkingUsageStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(21, "org.dsi.ifc.radio.DSIDABTunerListener", 1230356940, 1676164096), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAudioStatus(AudioStatus audioStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = audioStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(22, "org.dsi.ifc.radio.DSIDABTunerListener", 1424582358, -2088897351), 22, objectArray);
            return;
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
            this.h.invoke(this, LR557b0bbb5.gjm(23, "org.dsi.ifc.radio.DSIDABTunerListener", 371972340, 1676164096), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateQualityInfo(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(24, "org.dsi.ifc.radio.DSIDABTunerListener", 961326746, -645498553), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void selectServiceStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(25, "org.dsi.ifc.radio.DSIDABTunerListener", -522381116, 1687814400), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void seekServiceStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(26, "org.dsi.ifc.radio.DSIDABTunerListener", -460484406, 1687814400), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void tuneEnsembleStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(27, "org.dsi.ifc.radio.DSIDABTunerListener", -388590101, 1687814400), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void selectDataServiceStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(28, "org.dsi.ifc.radio.DSIDABTunerListener", 1452323995, 1687814400), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dABRadioTextPlusInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(29, "org.dsi.ifc.radio.DSIDABTunerListener", -65946060, -121224653), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDecodedDataService(DataServiceInfo dataServiceInfo, boolean bl, String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = dataServiceInfo;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = string;
            objectArray[3] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(30, "org.dsi.ifc.radio.DSIDABTunerListener", -1284467168, 1502183526), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void forceLMUpdateStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(31, "org.dsi.ifc.radio.DSIDABTunerListener", 1546959972, 1687814400), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void prepareTuningStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(32, "org.dsi.ifc.radio.DSIDABTunerListener", 598799770, 1687814400), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEpgLogo(int[] nArray, ResourceLocator[] resourceLocatorArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = nArray;
            objectArray[1] = resourceLocatorArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(33, "org.dsi.ifc.radio.DSIDABTunerListener", 1400019274, -171652701), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEpgLogoList(EPGLogo[] ePGLogoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = ePGLogoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(34, "org.dsi.ifc.radio.DSIDABTunerListener", 293119614, 1927289583), 34, objectArray);
            return;
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
            this.h.invoke(this, LR557b0bbb5.gjm(35, "org.dsi.ifc.radio.DSIDABTunerListener", 1217841997, -1001296408), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAvailability(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(36, "org.dsi.ifc.radio.DSIDABTunerListener", 968828733, 1676164096), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateIntellitext(IntellitextMenu[] intellitextMenuArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = intellitextMenuArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(37, "org.dsi.ifc.radio.DSIDABTunerListener", 1820504319, 1525206959), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEPGMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(38, "org.dsi.ifc.radio.DSIDABTunerListener", 1273117458, 1676164096), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEPGListData(EPGShortInfo[] ePGShortInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = ePGShortInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(39, "org.dsi.ifc.radio.DSIDABTunerListener", -1863564988, 1471383326), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEPGDetailData(EPGFullInfo ePGFullInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = ePGFullInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(40, "org.dsi.ifc.radio.DSIDABTunerListener", 65176834, 872936230), 40, objectArray);
            return;
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
            this.h.invoke(this, LR557b0bbb5.gjm(41, "org.dsi.ifc.radio.DSIDABTunerListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRadioText(AMFMRadioText aMFMRadioText, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = aMFMRadioText;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(47, "org.dsi.ifc.radio.DSIAMFMTunerListener", 1947403790, -1868348557), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStationList(Station[] stationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(52, "org.dsi.ifc.radio.DSIAMFMTunerListener", -558557946, -977708484), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStationListMW(Station[] stationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(53, "org.dsi.ifc.radio.DSIAMFMTunerListener", 1216968407, -977708484), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStationListLW(Station[] stationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(54, "org.dsi.ifc.radio.DSIAMFMTunerListener", 696874711, -977708484), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = wavebandInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(55, "org.dsi.ifc.radio.DSIAMFMTunerListener", -1734674813, 694476754), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAFSwitchStatus(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(56, "org.dsi.ifc.radio.DSIAMFMTunerListener", -1993309761, -1665395196), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateREGSwitchStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(57, "org.dsi.ifc.radio.DSIAMFMTunerListener", 1723682457, 1676164096), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void tuneFrequencyStepsStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(58, "org.dsi.ifc.radio.DSIAMFMTunerListener", -1965976916, 1687814400), 58, objectArray);
            return;
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
            this.h.invoke(this, LR557b0bbb5.gjm(59, "org.dsi.ifc.radio.DSIAMFMTunerListener", 536699942, 1687814400), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void seekStationStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(60, "org.dsi.ifc.radio.DSIAMFMTunerListener", 598596652, 1687814400), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = nArray;
            objectArray[1] = stringArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(61, "org.dsi.ifc.radio.DSIAMFMTunerListener", -1367495286, 199863146), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSelectedStation(Station station, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = station;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(62, "org.dsi.ifc.radio.DSIAMFMTunerListener", -2058820697, -808826396), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSelectedStationHD(Station station, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = station;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(63, "org.dsi.ifc.radio.DSIAMFMTunerListener", -2129843652, -1441735444), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void selectFrequencyStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(64, "org.dsi.ifc.radio.DSIAMFMTunerListener", 1195026254, 1687814400), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAMBandRangeStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(65, "org.dsi.ifc.radio.DSIAMFMTunerListener", -1583714038, 1687814400), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void forceFMUpdateStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(66, "org.dsi.ifc.radio.DSIAMFMTunerListener", -1569027815, 1687814400), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePiIgnoreSwitchStatus(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(67, "org.dsi.ifc.radio.DSIAMFMTunerListener", -281980340, -1665395196), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void forceAMUpdateStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(68, "org.dsi.ifc.radio.DSIAMFMTunerListener", -2020985680, 1687814400), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDSIgnoreSwitchStatus(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(69, "org.dsi.ifc.radio.DSIAMFMTunerListener", -977921161, -1665395196), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMESwitchStatus(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(70, "org.dsi.ifc.radio.DSIAMFMTunerListener", 2090689383, -1665395196), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHdStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(71, "org.dsi.ifc.radio.DSIAMFMTunerListener", 1826781605, 1676164096), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHdMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR557b0bbb5.gjm(72, "org.dsi.ifc.radio.DSIAMFMTunerListener", 1569275316, 1676164096), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateHdStationInfo(HdStationInfo hdStationInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = hdStationInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(73, "org.dsi.ifc.radio.DSIAMFMTunerListener", -1840387696, -1055523096), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateElectronicSerialCode(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR557b0bbb5.gjm(74, "org.dsi.ifc.radio.DSIAMFMTunerListener", 2079996622, -645498553), 74, objectArray);
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

