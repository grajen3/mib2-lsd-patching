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
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.DSICombinedRouteList;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public final class LR597368c67
extends AbstractProxy
implements DSICombinedRouteList,
DSINavigation {
    private static final Method[] JMS = new Method[198];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR597368c67(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void requestCombinedRouteListWindow(int n, int n2, long[] lArray, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = lArray;
            objectArray[3] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(0, "org.dsi.ifc.navigation.DSICombinedRouteList", 2022331253, -17567424), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestTrafficInformation(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(1, "org.dsi.ifc.navigation.DSICombinedRouteList", 1402349074, -238538240), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestPOIInformation(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(2, "org.dsi.ifc.navigation.DSICombinedRouteList", 1712846518, -238538240), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getBoundingRectangleOfCombinedRouteListElements(long[] lArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = lArray;
            this.h.invoke(this, LR597368c67.gjm(3, "org.dsi.ifc.navigation.DSICombinedRouteList", -1025824159, 3524), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestPriceInfo(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(4, "org.dsi.ifc.navigation.DSICombinedRouteList", 1029578801, -238538240), 4, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(5, "org.dsi.ifc.navigation.DSICombinedRouteList", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(6, "org.dsi.ifc.navigation.DSICombinedRouteList", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(7, "org.dsi.ifc.navigation.DSICombinedRouteList", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(8, "org.dsi.ifc.navigation.DSICombinedRouteList", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(9, "org.dsi.ifc.navigation.DSICombinedRouteList", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(10, "org.dsi.ifc.navigation.DSICombinedRouteList", 1300919239, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(11, "org.dsi.ifc.navigation.DSINavigation", 1328833814, -633848249), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void createExportFile(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(12, "org.dsi.ifc.navigation.DSINavigation", -503889799, -645498553), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void importFile(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(13, "org.dsi.ifc.navigation.DSINavigation", 914728574, -645498553), 13, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(14, "org.dsi.ifc.navigation.DSINavigation", 787086500, 1687814400), 14, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(15, "org.dsi.ifc.navigation.DSINavigation", 867405578, 1676164096), 15, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(16, "org.dsi.ifc.navigation.DSINavigation", -1689832120, 1687814400), 16, objectArray);
            return;
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
            this.h.invoke(this, LR597368c67.gjm(17, "org.dsi.ifc.navigation.DSINavigation", 283450095, 17), 17, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nArray;
            objectArray[2] = blArray;
            this.h.invoke(this, LR597368c67.gjm(18, "org.dsi.ifc.navigation.DSINavigation", 1154778948, -382972672), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehSetCategoryVisibilityToDefault(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(19, "org.dsi.ifc.navigation.DSINavigation", -1407682096, 1687814400), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void afaRepeat(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(20, "org.dsi.ifc.navigation.DSINavigation", 209752878, 1687814400), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmFlagDestinationSet(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(21, "org.dsi.ifc.navigation.DSINavigation", -564752530, -2012328694), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmFlagDestinationRemove() {
        try {
            this.h.invoke(this, LR597368c67.gjm(22, "org.dsi.ifc.navigation.DSINavigation", -1835943433, 17), 22, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmFlagDestinationSetName(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(23, "org.dsi.ifc.navigation.DSINavigation", 166310196, -633848249), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmLastDestinationsAddList(NavLastDest[] navLastDestArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLastDestArray;
            this.h.invoke(this, LR597368c67.gjm(24, "org.dsi.ifc.navigation.DSINavigation", 818975342, -128339745), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmLastDestinationsDelete(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(25, "org.dsi.ifc.navigation.DSINavigation", -996934673, -238538240), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmLastDestinationsDeleteAll() {
        try {
            this.h.invoke(this, LR597368c67.gjm(26, "org.dsi.ifc.navigation.DSINavigation", 1203516172, 17), 26, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmLastDestinationsGet(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(27, "org.dsi.ifc.navigation.DSINavigation", -1480033053, -238538240), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmLastDestinationsReplace(long l, NavLocation navLocation, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = navLocation;
            objectArray[2] = string;
            this.h.invoke(this, LR597368c67.gjm(28, "org.dsi.ifc.navigation.DSINavigation", 85871092, 93000569), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmRecentRoutesAdd(Route route, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = route;
            objectArray[1] = string;
            this.h.invoke(this, LR597368c67.gjm(29, "org.dsi.ifc.navigation.DSINavigation", -2006512923, -679063699), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmRecentRoutesDelete(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(30, "org.dsi.ifc.navigation.DSINavigation", 1861147065, -238538240), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmRecentRoutesDeleteAll() {
        try {
            this.h.invoke(this, LR597368c67.gjm(31, "org.dsi.ifc.navigation.DSINavigation", 1567214774, 17), 31, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmRecentRoutesGet(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(32, "org.dsi.ifc.navigation.DSINavigation", 1031670501, -238538240), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmRecentRoutesReplace(long l, Route route, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = route;
            objectArray[2] = string;
            this.h.invoke(this, LR597368c67.gjm(33, "org.dsi.ifc.navigation.DSINavigation", -1692912026, -1891388980), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void enableRgStreetLists(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(34, "org.dsi.ifc.navigation.DSINavigation", -1893890901, -1653679357), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void enableRgLaneGuidance(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(35, "org.dsi.ifc.navigation.DSINavigation", 293844458, -1653679357), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void enableRgPoiInfo(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(36, "org.dsi.ifc.navigation.DSINavigation", 1441449112, -1653679357), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcGetCountryAbbreviation(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(37, "org.dsi.ifc.navigation.DSINavigation", -137106757, -633848249), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcSetDemoMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(38, "org.dsi.ifc.navigation.DSINavigation", -373515722, -1653679357), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcSetDemoModeSpeed(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(39, "org.dsi.ifc.navigation.DSINavigation", -1463762679, -238538240), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcSetMetricSystem(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(40, "org.dsi.ifc.navigation.DSINavigation", -1036828141, 1687814400), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcSelectDatabase(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(41, "org.dsi.ifc.navigation.DSINavigation", -1057773264, 1687814400), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcSelectNavDataBase(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(42, "org.dsi.ifc.navigation.DSINavigation", -2096048593, 1687814400), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void languageSpellableCharacters(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(43, "org.dsi.ifc.navigation.DSINavigation", -1986640995, -633848249), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetCurrentState() {
        try {
            this.h.invoke(this, LR597368c67.gjm(44, "org.dsi.ifc.navigation.DSINavigation", 1183901448, 17), 44, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetLastCityHistoryEntry(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(45, "org.dsi.ifc.navigation.DSINavigation", -1381174380, -238538240), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetLastStreetHistoryEntry(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(46, "org.dsi.ifc.navigation.DSINavigation", -2051050613, -238538240), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetLocationDescriptionTransform(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(47, "org.dsi.ifc.navigation.DSINavigation", -754086145, -2012328694), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetLocationDescriptionTransformNearBy(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(48, "org.dsi.ifc.navigation.DSINavigation", 312670840, -2012328694), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetState() {
        try {
            this.h.invoke(this, LR597368c67.gjm(49, "org.dsi.ifc.navigation.DSINavigation", -317648808, 17), 49, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetLastStateHistoryEntry(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(50, "org.dsi.ifc.navigation.DSINavigation", -708682364, -238538240), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastStateHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = string;
            this.h.invoke(this, LR597368c67.gjm(51, "org.dsi.ifc.navigation.DSINavigation", 552814670, -1514946156), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastStateHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = string;
            objectArray[3] = lIExtDataArray;
            this.h.invoke(this, LR597368c67.gjm(52, "org.dsi.ifc.navigation.DSINavigation", 2045337679, 696049932), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastStateHistoryDelete(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(53, "org.dsi.ifc.navigation.DSINavigation", -694464481, -238538240), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastStateHistoryDeleteAll() {
        try {
            this.h.invoke(this, LR597368c67.gjm(54, "org.dsi.ifc.navigation.DSINavigation", -169711324, 17), 54, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastCityHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = string;
            this.h.invoke(this, LR597368c67.gjm(55, "org.dsi.ifc.navigation.DSINavigation", 1077298371, -1514946156), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastCityHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = string;
            objectArray[3] = lIExtDataArray;
            this.h.invoke(this, LR597368c67.gjm(56, "org.dsi.ifc.navigation.DSINavigation", -1727203574, 696049932), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastCityHistoryDelete(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(57, "org.dsi.ifc.navigation.DSINavigation", -1241187998, -238538240), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastCityHistoryDeleteAll() {
        try {
            this.h.invoke(this, LR597368c67.gjm(58, "org.dsi.ifc.navigation.DSINavigation", 357461647, 17), 58, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastStreetHistoryAdd(NavLocation navLocation, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocation;
            objectArray[1] = string;
            this.h.invoke(this, LR597368c67.gjm(59, "org.dsi.ifc.navigation.DSINavigation", 414597739, -1790751914), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastStreetHistoryAddExtended(NavLocation navLocation, String string, LIExtData[] lIExtDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = navLocation;
            objectArray[1] = string;
            objectArray[2] = lIExtDataArray;
            this.h.invoke(this, LR597368c67.gjm(60, "org.dsi.ifc.navigation.DSINavigation", 1899283681, -911205591), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastStreetHistoryDelete(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(61, "org.dsi.ifc.navigation.DSINavigation", -564832244, -238538240), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastStreetHistoryDeleteAll() {
        try {
            this.h.invoke(this, LR597368c67.gjm(62, "org.dsi.ifc.navigation.DSINavigation", -309619814, 17), 62, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liRestoreState(LISpellerData lISpellerData) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = lISpellerData;
            this.h.invoke(this, LR597368c67.gjm(63, "org.dsi.ifc.navigation.DSINavigation", 897301128, 53949725), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liSetCountryForCityAndStreetHistory(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(64, "org.dsi.ifc.navigation.DSINavigation", 1923703613, -633848249), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liSetHistory(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR597368c67.gjm(65, "org.dsi.ifc.navigation.DSINavigation", -1537142864, -412271469), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liSetStreetForCityHistory(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(66, "org.dsi.ifc.navigation.DSINavigation", -1121042437, -633848249), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liDeleteHistory() {
        try {
            this.h.invoke(this, LR597368c67.gjm(67, "org.dsi.ifc.navigation.DSINavigation", 1627927527, 17), 67, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liSetCurrentLD(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(68, "org.dsi.ifc.navigation.DSINavigation", 26152362, -2012328694), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispAddCharacter(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(69, "org.dsi.ifc.navigation.DSINavigation", -1216918733, -633848249), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispCancelSpeller() {
        try {
            this.h.invoke(this, LR597368c67.gjm(70, "org.dsi.ifc.navigation.DSINavigation", -163847743, 17), 70, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispDeleteAllCharacters() {
        try {
            this.h.invoke(this, LR597368c67.gjm(71, "org.dsi.ifc.navigation.DSINavigation", 2075327713, 17), 71, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispRequestValueListByListIndex(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(72, "org.dsi.ifc.navigation.DSINavigation", -1204740982, -1600866162), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispSelectListItem(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(73, "org.dsi.ifc.navigation.DSINavigation", -1670908172, 1687814400), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispSelectItemFromLocation(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(74, "org.dsi.ifc.navigation.DSINavigation", -47424948, -2012328694), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispSelectByCategoryUid(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(75, "org.dsi.ifc.navigation.DSINavigation", 2061072051, 1687814400), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispSelectByMultipleCategoryUids(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR597368c67.gjm(76, "org.dsi.ifc.navigation.DSINavigation", -1286534338, 3523), 76, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispSetInput(String string, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(77, "org.dsi.ifc.navigation.DSINavigation", -1208635838, 372504021), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispGetMatchingNVC(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(78, "org.dsi.ifc.navigation.DSINavigation", -682223667, -633848249), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispUndoCharacter() {
        try {
            this.h.invoke(this, LR597368c67.gjm(79, "org.dsi.ifc.navigation.DSINavigation", -1601255388, 17), 79, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liStartMultiCriteriaSpeller(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            objectArray[3] = RuntimeUtil.valueOf(bl2);
            objectArray[4] = RuntimeUtil.valueOf(bl3);
            this.h.invoke(this, LR597368c67.gjm(80, "org.dsi.ifc.navigation.DSINavigation", -150239896, -1217415725), 80, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liStartSpeller(int n, boolean bl, boolean bl2, boolean bl3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(bl2);
            objectArray[3] = RuntimeUtil.valueOf(bl3);
            this.h.invoke(this, LR597368c67.gjm(81, "org.dsi.ifc.navigation.DSINavigation", -1510644825, 686467679), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liTryBestMatch(TryBestMatchData tryBestMatchData) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = tryBestMatchData;
            this.h.invoke(this, LR597368c67.gjm(82, "org.dsi.ifc.navigation.DSINavigation", 1477667883, 2040115428), 82, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liValueListFilename(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(83, "org.dsi.ifc.navigation.DSINavigation", 1315652944, -633848249), 83, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liValueListOutputMethod(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(84, "org.dsi.ifc.navigation.DSINavigation", -1984868294, 1687814400), 84, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void locationToStream(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(85, "org.dsi.ifc.navigation.DSINavigation", 633574305, -2012328694), 85, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiSelectSelectionCriteria(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(86, "org.dsi.ifc.navigation.DSINavigation", 985726202, -238538240), 86, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiSetContext(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(87, "org.dsi.ifc.navigation.DSINavigation", 1283190305, -2012328694), 87, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiSetSortOrder2(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(88, "org.dsi.ifc.navigation.DSINavigation", 790919012, 1687814400), 88, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiStartSpellerAlongRoute(int n, long l, long l2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(l2);
            this.h.invoke(this, LR597368c67.gjm(89, "org.dsi.ifc.navigation.DSINavigation", -1099372578, -1529287658), 89, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiStartSpellerAlongRouteAdvanced(int n, long l, long l2, long l3, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(l2);
            objectArray[3] = RuntimeUtil.valueOf(l3);
            objectArray[4] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(90, "org.dsi.ifc.navigation.DSINavigation", 15505075, -791421351), 90, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestSoPosPositionDescriptionVehicle() {
        try {
            this.h.invoke(this, LR597368c67.gjm(91, "org.dsi.ifc.navigation.DSINavigation", -138516399, 17), 91, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgCalculateRoute(Route route, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = route;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(92, "org.dsi.ifc.navigation.DSINavigation", -1924499934, -912290783), 92, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgSetPosition(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(93, "org.dsi.ifc.navigation.DSINavigation", -1420795563, -2012328694), 93, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgSetRouteGuidanceMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(94, "org.dsi.ifc.navigation.DSINavigation", 213552258, 1687814400), 94, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgSetRouteOptions(RouteOptions routeOptions) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = routeOptions;
            this.h.invoke(this, LR597368c67.gjm(95, "org.dsi.ifc.navigation.DSINavigation", 392270318, -19404284), 95, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRoute(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(96, "org.dsi.ifc.navigation.DSINavigation", 992576415, 1687814400), 96, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgStopGuidance() {
        try {
            this.h.invoke(this, LR597368c67.gjm(97, "org.dsi.ifc.navigation.DSINavigation", -990771967, 17), 97, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmMakeRoutePersistent(Route route) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = route;
            this.h.invoke(this, LR597368c67.gjm(98, "org.dsi.ifc.navigation.DSINavigation", 743605202, -900640479), 98, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteAdd(int n, Route route, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = route;
            objectArray[2] = string;
            this.h.invoke(this, LR597368c67.gjm(99, "org.dsi.ifc.navigation.DSINavigation", 1749484782, 34963660), 99, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteDelete(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(100, "org.dsi.ifc.navigation.DSINavigation", -1904081592, -995993593), 100, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteDeleteAll(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(101, "org.dsi.ifc.navigation.DSINavigation", 1038161464, 1687814400), 101, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteGet(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(102, "org.dsi.ifc.navigation.DSINavigation", 492700910, -995993593), 102, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteRename(int n, long l, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = string;
            this.h.invoke(this, LR597368c67.gjm(103, "org.dsi.ifc.navigation.DSINavigation", 557115999, -1521674749), 103, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rrdStartCalculationByListIndex(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(104, "org.dsi.ifc.navigation.DSINavigation", 1731628235, -995993593), 104, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rrdStartCalculationForPosition(NavLocationWgs84[] navLocationWgs84Array) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocationWgs84Array;
            this.h.invoke(this, LR597368c67.gjm(105, "org.dsi.ifc.navigation.DSINavigation", 1017635741, 1964896540), 105, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rrdStopCalculation() {
        try {
            this.h.invoke(this, LR597368c67.gjm(106, "org.dsi.ifc.navigation.DSINavigation", 415069184, 17), 106, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void streamToLocation(byte[] byArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = byArray;
            this.h.invoke(this, LR597368c67.gjm(107, "org.dsi.ifc.navigation.DSINavigation", 1697974257, 3516), 107, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void translateRoute(Route route) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = route;
            this.h.invoke(this, LR597368c67.gjm(108, "org.dsi.ifc.navigation.DSINavigation", 276103106, -900640479), 108, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trCreateWaypoint() {
        try {
            this.h.invoke(this, LR597368c67.gjm(109, "org.dsi.ifc.navigation.DSINavigation", -1325804962, 17), 109, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trDeleteAllTraces() {
        try {
            this.h.invoke(this, LR597368c67.gjm(110, "org.dsi.ifc.navigation.DSINavigation", 2064382426, 17), 110, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trDeleteTrace(NavSegmentID navSegmentID) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navSegmentID;
            this.h.invoke(this, LR597368c67.gjm(111, "org.dsi.ifc.navigation.DSINavigation", 1905224352, 1707714853), 111, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trRenameTrace(NavSegmentID navSegmentID, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navSegmentID;
            objectArray[1] = string;
            this.h.invoke(this, LR597368c67.gjm(112, "org.dsi.ifc.navigation.DSINavigation", -1092508453, 1929291633), 112, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trStartTraceRecording(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(113, "org.dsi.ifc.navigation.DSINavigation", 1158085435, 1687814400), 113, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trStopTraceRecording() {
        try {
            this.h.invoke(this, LR597368c67.gjm(114, "org.dsi.ifc.navigation.DSINavigation", 1633434583, 17), 114, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trStoreTrace(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(115, "org.dsi.ifc.navigation.DSINavigation", 2010414967, -633848249), 115, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liStripLocation(NavLocation navLocation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(116, "org.dsi.ifc.navigation.DSINavigation", -450456528, -2023978998), 116, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liSetNVCRange(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(117, "org.dsi.ifc.navigation.DSINavigation", -1677377664, 1687814400), 117, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liValueListWindowSize(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(118, "org.dsi.ifc.navigation.DSINavigation", -664524245, 1687814400), 118, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestAudioTrigger(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(119, "org.dsi.ifc.navigation.DSINavigation", -1503677121, 1687814400), 119, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liThesaurusHistoryAdd(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(120, "org.dsi.ifc.navigation.DSINavigation", -1079934561, -633848249), 120, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liThesaurusHistoryGetEntry(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(121, "org.dsi.ifc.navigation.DSINavigation", 676096893, 1687814400), 121, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liThesaurusHistoryDelete(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(122, "org.dsi.ifc.navigation.DSINavigation", -680232462, 1687814400), 122, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liThesaurusHistoryDeleteAll() {
        try {
            this.h.invoke(this, LR597368c67.gjm(123, "org.dsi.ifc.navigation.DSINavigation", 1423894018, 17), 123, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehGetAllCategories(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(124, "org.dsi.ifc.navigation.DSINavigation", 523296784, 1687814400), 124, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehGetAllBrandsOfCategory(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR597368c67.gjm(125, "org.dsi.ifc.navigation.DSINavigation", 1679987608, 1676164096), 125, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehSetCategoryAudioWarning(int n, int[] nArray, boolean[] blArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nArray;
            objectArray[2] = blArray;
            this.h.invoke(this, LR597368c67.gjm(126, "org.dsi.ifc.navigation.DSINavigation", -662394682, -382972672), 126, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehSetCategoryMonitoring(int[] nArray, boolean[] blArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = blArray;
            this.h.invoke(this, LR597368c67.gjm(127, "org.dsi.ifc.navigation.DSINavigation", 2048210495, -234225152), 127, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehSetBrandVisibility(int n, int[] nArray, boolean[] blArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nArray;
            objectArray[2] = blArray;
            this.h.invoke(this, LR597368c67.gjm(128, "org.dsi.ifc.navigation.DSINavigation", -1350457291, -382972672), 128, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehSetBrandPreference(int n, int[] nArray, boolean[] blArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nArray;
            objectArray[2] = blArray;
            this.h.invoke(this, LR597368c67.gjm(129, "org.dsi.ifc.navigation.DSINavigation", 2027679338, -382972672), 129, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRemainingRangeOfVehicle(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(130, "org.dsi.ifc.navigation.DSINavigation", -515431668, 1687814400), 130, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUserDefinedPOIs(NavLocation[] navLocationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocationArray;
            this.h.invoke(this, LR597368c67.gjm(131, "org.dsi.ifc.navigation.DSINavigation", -97700557, -1941743767), 131, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTrailerStatus(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(132, "org.dsi.ifc.navigation.DSINavigation", 948233752, -1653679357), 132, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestCountryInfo(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(133, "org.dsi.ifc.navigation.DSINavigation", -900865081, -633848249), 133, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void jumpToNextManeuver() {
        try {
            this.h.invoke(this, LR597368c67.gjm(134, "org.dsi.ifc.navigation.DSINavigation", 1250490103, 17), 134, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetViaPointCountryList() {
        try {
            this.h.invoke(this, LR597368c67.gjm(135, "org.dsi.ifc.navigation.DSINavigation", -287960225, 17), 135, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liSetViaPointCountry(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(136, "org.dsi.ifc.navigation.DSINavigation", 610365847, -633848249), 136, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetViaPointList(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR597368c67.gjm(137, "org.dsi.ifc.navigation.DSINavigation", -1901120076, -448335035), 137, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liSelectViaPoint(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(138, "org.dsi.ifc.navigation.DSINavigation", -1873744833, 1687814400), 138, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navSegmentID;
            this.h.invoke(this, LR597368c67.gjm(139, "org.dsi.ifc.navigation.DSINavigation", -931184952, 1707714853), 139, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetSpellableCharacters(NavLocation navLocation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(140, "org.dsi.ifc.navigation.DSINavigation", -1472503760, -2023978998), 140, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liStopSpeller() {
        try {
            this.h.invoke(this, LR597368c67.gjm(141, "org.dsi.ifc.navigation.DSINavigation", 730482278, 17), 141, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liValueListMaximumLength(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(142, "org.dsi.ifc.navigation.DSINavigation", 153385589, 1687814400), 142, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPathsToPersonalPOIDataBases(String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = stringArray;
            this.h.invoke(this, LR597368c67.gjm(143, "org.dsi.ifc.navigation.DSINavigation", -903113512, -1166448617), 143, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deletePersonalPOIDataBases(String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = stringArray;
            this.h.invoke(this, LR597368c67.gjm(144, "org.dsi.ifc.navigation.DSINavigation", 778450609, -1166448617), 144, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgStopRouteCalculation() {
        try {
            this.h.invoke(this, LR597368c67.gjm(145, "org.dsi.ifc.navigation.DSINavigation", 752728194, 17), 145, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgSwitchToNextPossibleRoad() {
        try {
            this.h.invoke(this, LR597368c67.gjm(146, "org.dsi.ifc.navigation.DSINavigation", 2113372601, 17), 146, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVehicleFuelType(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(147, "org.dsi.ifc.navigation.DSINavigation", 265264665, 1687814400), 147, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void createNavLocationOfPOIUID(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(148, "org.dsi.ifc.navigation.DSINavigation", 1316020613, -238538240), 148, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispSelectListItemByIdent(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(149, "org.dsi.ifc.navigation.DSINavigation", 657413578, -633848249), 149, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteReplace(int n, long l, Route route) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = route;
            this.h.invoke(this, LR597368c67.gjm(150, "org.dsi.ifc.navigation.DSINavigation", 2064154013, 363410995), 150, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNavInternalDataToFactorySettings() {
        try {
            this.h.invoke(this, LR597368c67.gjm(151, "org.dsi.ifc.navigation.DSINavigation", -1624322626, 17), 151, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liTryMatchLocation(TryMatchLocationData tryMatchLocationData) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = tryMatchLocationData;
            this.h.invoke(this, LR597368c67.gjm(152, "org.dsi.ifc.navigation.DSINavigation", -1319611115, -758739631), 152, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trImportTrails(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(153, "org.dsi.ifc.navigation.DSINavigation", 1161237024, -633848249), 153, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trExportTrails(NavSegmentID[] navSegmentIDArray, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navSegmentIDArray;
            objectArray[1] = string;
            this.h.invoke(this, LR597368c67.gjm(154, "org.dsi.ifc.navigation.DSINavigation", 340795239, 517399537), 154, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgSkipNextWayPoints(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(155, "org.dsi.ifc.navigation.DSINavigation", -2142218424, 1687814400), 155, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgReverseTrailDirection() {
        try {
            this.h.invoke(this, LR597368c67.gjm(156, "org.dsi.ifc.navigation.DSINavigation", -617686465, 17), 156, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgPrepareRubberbandManipulation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(157, "org.dsi.ifc.navigation.DSINavigation", 1224912883, -1653679357), 157, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgStartRubberbandManipulation(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(158, "org.dsi.ifc.navigation.DSINavigation", 619366362, 1687814400), 158, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgSetRubberbandPosition(NavLocationWgs84 navLocationWgs84) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocationWgs84;
            this.h.invoke(this, LR597368c67.gjm(159, "org.dsi.ifc.navigation.DSINavigation", 1891628329, 17850877), 159, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgGetRouteBoundingRectangle(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(160, "org.dsi.ifc.navigation.DSINavigation", -1729517013, -1665395196), 160, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgGetLocationOnRoute(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR597368c67.gjm(161, "org.dsi.ifc.navigation.DSINavigation", -1984618016, -238538240), 161, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgStopRubberbandManipulation() {
        try {
            this.h.invoke(this, LR597368c67.gjm(162, "org.dsi.ifc.navigation.DSINavigation", 1320635326, 17), 162, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgDeleteCalculatedRubberbandPoint() {
        try {
            this.h.invoke(this, LR597368c67.gjm(163, "org.dsi.ifc.navigation.DSINavigation", 576797935, 17), 163, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgGetRubberBandPointPosition() {
        try {
            this.h.invoke(this, LR597368c67.gjm(164, "org.dsi.ifc.navigation.DSINavigation", 680472053, 17), 164, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgEnableEnhancedSignPostInfo(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(165, "org.dsi.ifc.navigation.DSINavigation", -1898227421, -1653679357), 165, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispGetLocationFromLiValueListElement(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(166, "org.dsi.ifc.navigation.DSINavigation", 976684864, 1687814400), 166, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgSetTurnListMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(167, "org.dsi.ifc.navigation.DSINavigation", 6312036, 1687814400), 167, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liHistoryAddLocation(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(168, "org.dsi.ifc.navigation.DSINavigation", 343011552, -2012328694), 168, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastCityHistorySetStreet(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(169, "org.dsi.ifc.navigation.DSINavigation", 618525127, -2012328694), 169, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastStreetHistorySetCity(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(170, "org.dsi.ifc.navigation.DSINavigation", 1689620632, -2012328694), 170, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void enableRgMotorwayInfo(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(171, "org.dsi.ifc.navigation.DSINavigation", -718576789, -1653679357), 171, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgTriggerRCCIUpdate() {
        try {
            this.h.invoke(this, LR597368c67.gjm(172, "org.dsi.ifc.navigation.DSINavigation", 2019986826, 17), 172, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiGetXt9LDBs(NavLocation navLocation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(173, "org.dsi.ifc.navigation.DSINavigation", 1337387530, -2023978998), 173, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiSetListStyle(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(174, "org.dsi.ifc.navigation.DSINavigation", 1347146798, 1687814400), 174, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcGetPositionTimeInfo(NavLocationWgs84 navLocationWgs84) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocationWgs84;
            this.h.invoke(this, LR597368c67.gjm(175, "org.dsi.ifc.navigation.DSINavigation", 465114870, 17850877), 175, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiGetCategoryTypesFromUId(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(176, "org.dsi.ifc.navigation.DSINavigation", 201556610, 1687814400), 176, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgDeletePersistedRouteData() {
        try {
            this.h.invoke(this, LR597368c67.gjm(177, "org.dsi.ifc.navigation.DSINavigation", 900483341, 17), 177, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgCalculate1stRouteAndPostponeRemaining(Route route, int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = route;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(178, "org.dsi.ifc.navigation.DSINavigation", 1176922856, 1976237761), 178, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liDisambiguateLocation(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(179, "org.dsi.ifc.navigation.DSINavigation", -369033398, -2012328694), 179, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void triggerEventAudioMessage(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(180, "org.dsi.ifc.navigation.DSINavigation", -1461525113, 1687814400), 180, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispAddStroke(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(181, "org.dsi.ifc.navigation.DSINavigation", 882737153, -633848249), 181, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispRequestNVCList(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR597368c67.gjm(182, "org.dsi.ifc.navigation.DSINavigation", -110697650, 1043255048), 182, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiConfigureContext(String string, int n, NavLocation navLocation, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = navLocation;
            objectArray[3] = nArray;
            this.h.invoke(this, LR597368c67.gjm(183, "org.dsi.ifc.navigation.DSINavigation", -928974157, -491970200), 183, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcTriggerNavigationRestart(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR597368c67.gjm(184, "org.dsi.ifc.navigation.DSINavigation", -1397594463, 1687814400), 184, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmImportToursFromGpxFile(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR597368c67.gjm(185, "org.dsi.ifc.navigation.DSINavigation", -76828041, 1909456715), 185, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmAbortImportToursFromGpxFile() {
        try {
            this.h.invoke(this, LR597368c67.gjm(186, "org.dsi.ifc.navigation.DSINavigation", -168339199, 17), 186, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void importRouteFromGpxFile(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR597368c67.gjm(187, "org.dsi.ifc.navigation.DSINavigation", -232405722, -633848249), 187, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiRequestExtendedInfo(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR597368c67.gjm(188, "org.dsi.ifc.navigation.DSINavigation", -2118543491, -2012328694), 188, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgConfigurePoiInfo(NavPoiInfoConfiguration navPoiInfoConfiguration) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navPoiInfoConfiguration;
            this.h.invoke(this, LR597368c67.gjm(189, "org.dsi.ifc.navigation.DSINavigation", 484911125, 47747735), 189, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trClearRecordedTraceCache() {
        try {
            this.h.invoke(this, LR597368c67.gjm(190, "org.dsi.ifc.navigation.DSINavigation", 1374769722, 17), 190, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVirtualRouteGuidance(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR597368c67.gjm(191, "org.dsi.ifc.navigation.DSINavigation", 1840331641, -1653679357), 191, objectArray);
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

