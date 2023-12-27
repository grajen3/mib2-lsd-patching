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
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.RawDataSet;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public final class LR5c9247a9c
extends AbstractProxy
implements DSISearch,
DSISearchDataProvider {
    private static final Method[] JMS = new Method[44];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5c9247a9c(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void search(SearchQuery searchQuery) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = searchQuery;
            this.h.invoke(this, LR5c9247a9c.gjm(0, "org.dsi.ifc.search.DSISearch", 493419209, 365114342), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLanguage(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5c9247a9c.gjm(1, "org.dsi.ifc.search.DSISearch", 1328833814, -633848249), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void resetToFactorySettings() {
        try {
            this.h.invoke(this, LR5c9247a9c.gjm(2, "org.dsi.ifc.search.DSISearch", 951627279, 17), 2, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileChange(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9247a9c.gjm(3, "org.dsi.ifc.search.DSISearch", 787086500, 1687814400), 3, objectArray);
            return;
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
            this.h.invoke(this, LR5c9247a9c.gjm(4, "org.dsi.ifc.search.DSISearch", 867405578, 1676164096), 4, objectArray);
            return;
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
            this.h.invoke(this, LR5c9247a9c.gjm(5, "org.dsi.ifc.search.DSISearch", -1689832120, 1687814400), 5, objectArray);
            return;
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
            this.h.invoke(this, LR5c9247a9c.gjm(6, "org.dsi.ifc.search.DSISearch", 283450095, 17), 6, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setActiveProfile(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9247a9c.gjm(7, "org.dsi.ifc.search.DSISearch", -151750665, 1687814400), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void createBackupFile(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5c9247a9c.gjm(8, "org.dsi.ifc.search.DSISearch", -274588619, -633848249), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void importBackupFile(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5c9247a9c.gjm(9, "org.dsi.ifc.search.DSISearch", 1492579110, -633848249), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestSupportedCountries() {
        try {
            this.h.invoke(this, LR5c9247a9c.gjm(10, "org.dsi.ifc.search.DSISearch", 169156842, 17), 10, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setActiveSearchCountries(String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = stringArray;
            this.h.invoke(this, LR5c9247a9c.gjm(11, "org.dsi.ifc.search.DSISearch", 960883416, -1166448617), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void addToHistory(SearchResult searchResult) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = searchResult;
            this.h.invoke(this, LR5c9247a9c.gjm(12, "org.dsi.ifc.search.DSISearch", 1829561803, -1172496671), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestSuggestion(SearchQuery searchQuery) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = searchQuery;
            this.h.invoke(this, LR5c9247a9c.gjm(13, "org.dsi.ifc.search.DSISearch", 1760869778, 365114342), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void cancelQuery(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9247a9c.gjm(14, "org.dsi.ifc.search.DSISearch", -470250079, 1687814400), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCurrentPosition(NavPosition navPosition) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navPosition;
            this.h.invoke(this, LR5c9247a9c.gjm(15, "org.dsi.ifc.search.DSISearch", 1973361870, -2121650919), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRoutePoints(NavPosition[] navPositionArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navPositionArray;
            this.h.invoke(this, LR5c9247a9c.gjm(16, "org.dsi.ifc.search.DSISearch", 1058922988, -1287223754), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCarFunctionStates(CarFunction[] carFunctionArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = carFunctionArray;
            this.h.invoke(this, LR5c9247a9c.gjm(17, "org.dsi.ifc.search.DSISearch", 562814558, 1407360162), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRadioStations(int n, RadioStation[] radioStationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = radioStationArray;
            this.h.invoke(this, LR5c9247a9c.gjm(18, "org.dsi.ifc.search.DSISearch", 228093544, 400996240), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSearchFilter(int n, SearchFilter searchFilter) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = searchFilter;
            this.h.invoke(this, LR5c9247a9c.gjm(19, "org.dsi.ifc.search.DSISearch", 936352391, -127966309), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void prepareSources(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR5c9247a9c.gjm(20, "org.dsi.ifc.search.DSISearch", 650337969, 3523), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void removeFromHistory(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5c9247a9c.gjm(21, "org.dsi.ifc.search.DSISearch", -616004173, -238538240), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void removeAllFromHistory() {
        try {
            this.h.invoke(this, LR5c9247a9c.gjm(22, "org.dsi.ifc.search.DSISearch", 1114744376, 17), 22, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void removeAllFromHistoryBySource(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9247a9c.gjm(23, "org.dsi.ifc.search.DSISearch", -1271137615, 1687814400), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void resetAutocompletion(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9247a9c.gjm(24, "org.dsi.ifc.search.DSISearch", 1873300828, 1687814400), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = environment;
            this.h.invoke(this, LR5c9247a9c.gjm(25, "org.dsi.ifc.search.DSISearch", -957473685, 686423297), 25, objectArray);
            return;
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
            this.h.invoke(this, LR5c9247a9c.gjm(26, "org.dsi.ifc.search.DSISearch", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5c9247a9c.gjm(27, "org.dsi.ifc.search.DSISearch", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5c9247a9c.gjm(28, "org.dsi.ifc.search.DSISearch", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5c9247a9c.gjm(29, "org.dsi.ifc.search.DSISearch", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5c9247a9c.gjm(30, "org.dsi.ifc.search.DSISearch", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5c9247a9c.gjm(31, "org.dsi.ifc.search.DSISearch", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void registerProviderSource(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9247a9c.gjm(32, "org.dsi.ifc.search.DSISearchDataProvider", 1686498887, 1687814400), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5c9247a9c.gjm(33, "org.dsi.ifc.search.DSISearchDataProvider", -1450131609, -1600866162), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void invalidateAllData(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9247a9c.gjm(34, "org.dsi.ifc.search.DSISearchDataProvider", -1513783590, 1687814400), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void storeDataSets(int n, DataSet[] dataSetArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dataSetArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9247a9c.gjm(35, "org.dsi.ifc.search.DSISearchDataProvider", -1858226714, -1918090874), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void storeRawDataSets(int n, RawDataSet[] rawDataSetArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = rawDataSetArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9247a9c.gjm(36, "org.dsi.ifc.search.DSISearchDataProvider", 936308181, -12576506), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteDataSet(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5c9247a9c.gjm(37, "org.dsi.ifc.search.DSISearchDataProvider", -1565863863, -995993593), 37, objectArray);
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

