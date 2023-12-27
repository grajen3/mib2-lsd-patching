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
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DSICombinedRouteListListener;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.NavVersionInfo;
import org.dsi.ifc.navigation.PoiExtendedInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.PosTimeInfo;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RgTurnToInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;
import org.dsi.ifc.navigation.TourImportStatus;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;
import org.dsi.ifc.tmc.TmcMessage;

public final class LR58f943ddf
extends AbstractProxy
implements DSICombinedRouteListListener,
DSINavigationListener {
    private static final Method[] JMS = new Method[184];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR58f943ddf(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void windowChanged(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(0, "org.dsi.ifc.navigation.DSICombinedRouteListListener", 433280400, 1687814400), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = combinedRouteListElementArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(1, "org.dsi.ifc.navigation.DSICombinedRouteListListener", 872606029, 920388178), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trafficInformationResult(TmcMessage tmcMessage, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tmcMessage;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(2, "org.dsi.ifc.navigation.DSICombinedRouteListListener", 1632773196, -1678354842), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navPoiInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(3, "org.dsi.ifc.navigation.DSICombinedRouteListListener", -1262127219, 1564608395), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateElementsTotal(long l, long l2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(4, "org.dsi.ifc.navigation.DSICombinedRouteListListener", -1183570438, 739712016), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lArray;
            objectArray[1] = navRectangle;
            this.h.invoke(this, LR58f943ddf.gjm(5, "org.dsi.ifc.navigation.DSICombinedRouteListListener", 1067636476, 1828738848), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestPriceInfoResult(NavPriceInfo navPriceInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navPriceInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(6, "org.dsi.ifc.navigation.DSICombinedRouteListListener", 2048704917, 1831678472), 6, objectArray);
            return;
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
            this.h.invoke(this, LR58f943ddf.gjm(7, "org.dsi.ifc.navigation.DSICombinedRouteListListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileReset(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(8, "org.dsi.ifc.navigation.DSINavigationListener", -1689832120, 1676164096), 8, objectArray);
            return;
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
            this.h.invoke(this, LR58f943ddf.gjm(9, "org.dsi.ifc.navigation.DSINavigationListener", 283450095, 1687814400), 9, objectArray);
            return;
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
            this.h.invoke(this, LR58f943ddf.gjm(10, "org.dsi.ifc.navigation.DSINavigationListener", -1984868294, 1687814400), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58f943ddf.gjm(11, "org.dsi.ifc.navigation.DSINavigationListener", 518768834, -1600866162), 11, objectArray);
            return;
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
            this.h.invoke(this, LR58f943ddf.gjm(12, "org.dsi.ifc.navigation.DSINavigationListener", 1184260366, 1043255048), 12, objectArray);
            return;
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
            this.h.invoke(this, LR58f943ddf.gjm(13, "org.dsi.ifc.navigation.DSINavigationListener", 1089708026, 1676164096), 13, objectArray);
            return;
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
            this.h.invoke(this, LR58f943ddf.gjm(14, "org.dsi.ifc.navigation.DSINavigationListener", 1112303269, 1043255048), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(15, "org.dsi.ifc.navigation.DSINavigationListener", -1212426072, 1676164096), 15, objectArray);
            return;
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
            this.h.invoke(this, LR58f943ddf.gjm(16, "org.dsi.ifc.navigation.DSINavigationListener", 1882612247, -1178098921), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAfaMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(17, "org.dsi.ifc.navigation.DSINavigationListener", 200711013, 1676164096), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAfaSpeaking(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(18, "org.dsi.ifc.navigation.DSINavigationListener", -1204189138, -1665395196), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEtcDemoModeState(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(19, "org.dsi.ifc.navigation.DSINavigationListener", 903796187, -1665395196), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEtcLanguageLoadProgress(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(20, "org.dsi.ifc.navigation.DSINavigationListener", -884762034, -266965504), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEtcLanguageLoadStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(21, "org.dsi.ifc.navigation.DSINavigationListener", -804811889, 1676164096), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEtcMetricSystem(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(22, "org.dsi.ifc.navigation.DSINavigationListener", 522628782, 1676164096), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lDListElementArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(23, "org.dsi.ifc.navigation.DSINavigationListener", -527442397, 746133882), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rRListElementArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(24, "org.dsi.ifc.navigation.DSINavigationListener", -1979108296, -192055600), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(25, "org.dsi.ifc.navigation.DSINavigationListener", 597028210, -1665395196), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgActive(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(26, "org.dsi.ifc.navigation.DSINavigationListener", -117220813, -1665395196), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rgInfoForNextDestination;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(27, "org.dsi.ifc.navigation.DSINavigationListener", 1398105594, -585071033), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgCurrentRoute(Route route, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = route;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(28, "org.dsi.ifc.navigation.DSINavigationListener", -1011423606, -912290783), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgCurrentRouteOptions(RouteOptions routeOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = routeOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(29, "org.dsi.ifc.navigation.DSINavigationListener", -443006567, -47897083), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = navLaneGuidanceDataArray;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(30, "org.dsi.ifc.navigation.DSINavigationListener", -681328119, -115882523), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgTurnToStreet(String string, boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(31, "org.dsi.ifc.navigation.DSINavigationListener", 1854415829, -243759138), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = routeOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(32, "org.dsi.ifc.navigation.DSINavigationListener", -1840942734, -47897083), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navRouteListDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(33, "org.dsi.ifc.navigation.DSINavigationListener", -1814849243, 1587919693), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navRouteListDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(34, "org.dsi.ifc.navigation.DSINavigationListener", 886113362, 1587919693), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navPoiInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(35, "org.dsi.ifc.navigation.DSINavigationListener", -819645339, -141377623), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgException(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(36, "org.dsi.ifc.navigation.DSINavigationListener", 252716647, 1687814400), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgRouteProperties(RouteProperties routeProperties, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = routeProperties;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(37, "org.dsi.ifc.navigation.DSINavigationListener", 318949629, -593361741), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSoPosPosition(PosPosition posPosition, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = posPosition;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(38, "org.dsi.ifc.navigation.DSINavigationListener", -844416330, 487638186), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(39, "org.dsi.ifc.navigation.DSINavigationListener", -105029143, -1622239583), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSoPosTimeInformation(PosTimeInfo posTimeInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = posTimeInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(40, "org.dsi.ifc.navigation.DSINavigationListener", -2061008455, 259283458), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRrdActive(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(41, "org.dsi.ifc.navigation.DSINavigationListener", -155902545, -1665395196), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rrdCalculationInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(42, "org.dsi.ifc.navigation.DSINavigationListener", 1909683089, -638790105), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navVersionInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(43, "org.dsi.ifc.navigation.DSINavigationListener", 274191700, 1801798329), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navDataBaseArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(44, "org.dsi.ifc.navigation.DSINavigationListener", -397136060, 341124178), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bapManeuverDescriptorArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(45, "org.dsi.ifc.navigation.DSINavigationListener", 1168867756, 2043315704), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bapTurnToInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(46, "org.dsi.ifc.navigation.DSINavigationListener", -1022652969, -1145889529), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgiString(short[] sArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(47, "org.dsi.ifc.navigation.DSINavigationListener", -1311664800, -866436352), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navRouteListDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(48, "org.dsi.ifc.navigation.DSINavigationListener", 76065041, 1587919693), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRmPersistentRoute(Route route, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = route;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(49, "org.dsi.ifc.navigation.DSINavigationListener", -480577170, -912290783), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgTimeAfaToDestination(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(50, "org.dsi.ifc.navigation.DSINavigationListener", 2000464577, -266965504), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcSensorDataReplayRoute(Route route) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = route;
            this.h.invoke(this, LR58f943ddf.gjm(51, "org.dsi.ifc.navigation.DSINavigationListener", -1090374731, -900640479), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcSensorDataReplayGuidance(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58f943ddf.gjm(52, "org.dsi.ifc.navigation.DSINavigationListener", 743729931, -1653679357), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = calculatedRouteListElementArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(53, "org.dsi.ifc.navigation.DSINavigationListener", 455496032, -653036081), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rgRouteCostChangeInformation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(54, "org.dsi.ifc.navigation.DSINavigationListener", 969823891, 1138497487), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navTraceMemoryUtilization;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(55, "org.dsi.ifc.navigation.DSINavigationListener", 1874776404, 528007529), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrOperatingMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(56, "org.dsi.ifc.navigation.DSINavigationListener", 315609785, 1676164096), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navTraceListDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(57, "org.dsi.ifc.navigation.DSINavigationListener", -1850474337, -494801057), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navRmRouteListArrayDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(58, "org.dsi.ifc.navigation.DSINavigationListener", 2025364110, -1191841119), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgRouteCalculationState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(59, "org.dsi.ifc.navigation.DSINavigationListener", -394064159, 1676164096), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNavstateOfOperation(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(60, "org.dsi.ifc.navigation.DSINavigationListener", 243156970, 1676164096), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNavMedia(String[] stringArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(61, "org.dsi.ifc.navigation.DSINavigationListener", -539319377, -1178098921), 61, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = turnListElementArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(62, "org.dsi.ifc.navigation.DSINavigationListener", 788303663, 293113262), 62, objectArray);
            return;
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
            this.h.invoke(this, LR58f943ddf.gjm(63, "org.dsi.ifc.navigation.DSINavigationListener", -1235636013, -645498553), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = distanceToNextManeuver;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(64, "org.dsi.ifc.navigation.DSINavigationListener", -89148997, 1147312894), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navDataBase;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(65, "org.dsi.ifc.navigation.DSINavigationListener", -2049012156, 1588906783), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = directionToWaypoint;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(66, "org.dsi.ifc.navigation.DSINavigationListener", 1237196833, -70755089), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = valueListStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(67, "org.dsi.ifc.navigation.DSINavigationListener", -541537236, 18961586), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrRecordingState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(68, "org.dsi.ifc.navigation.DSINavigationListener", -1663542003, 1676164096), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
        try {
            this.h.invoke(this, LR58f943ddf.gjm(69, "org.dsi.ifc.navigation.DSINavigationListener", 153184195, 17), 69, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = navLocation;
            this.h.invoke(this, LR58f943ddf.gjm(70, "org.dsi.ifc.navigation.DSINavigationListener", 1687157326, 618681725), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmRecentRoutesGetResult(long l, Route route) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = route;
            this.h.invoke(this, LR58f943ddf.gjm(71, "org.dsi.ifc.navigation.DSINavigationListener", 2050790393, -1365707824), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void dmResult(long l, long l2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            this.h.invoke(this, LR58f943ddf.gjm(72, "org.dsi.ifc.navigation.DSINavigationListener", 2071506859, 1372686599), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = lISpellerData;
            this.h.invoke(this, LR58f943ddf.gjm(73, "org.dsi.ifc.navigation.DSINavigationListener", 709634023, 53949725), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liResult(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR58f943ddf.gjm(74, "org.dsi.ifc.navigation.DSINavigationListener", 1878138647, -238538240), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(11);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            objectArray[3] = RuntimeUtil.valueOf(bl2);
            objectArray[4] = string2;
            objectArray[5] = RuntimeUtil.valueOf(n2);
            objectArray[6] = RuntimeUtil.valueOf(n3);
            objectArray[7] = RuntimeUtil.valueOf(bl3);
            objectArray[8] = RuntimeUtil.valueOf(bl4);
            objectArray[9] = RuntimeUtil.valueOf(n4);
            objectArray[10] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR58f943ddf.gjm(75, "org.dsi.ifc.navigation.DSINavigationListener", -2072406855, -69669298), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = navLocation;
            objectArray[1] = nArray;
            objectArray[2] = nArray2;
            objectArray[3] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR58f943ddf.gjm(76, "org.dsi.ifc.navigation.DSINavigationListener", 715914877, -2079390645), 76, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lIValueList;
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR58f943ddf.gjm(77, "org.dsi.ifc.navigation.DSINavigationListener", 663184716, -1290860902), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lIValueList;
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR58f943ddf.gjm(78, "org.dsi.ifc.navigation.DSINavigationListener", -84358296, -1290860902), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR58f943ddf.gjm(79, "org.dsi.ifc.navigation.DSINavigationListener", -1874602369, -2012328694), 79, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR58f943ddf.gjm(80, "org.dsi.ifc.navigation.DSINavigationListener", 690082578, -238538240), 80, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = tryBestMatchResultDataArray;
            this.h.invoke(this, LR58f943ddf.gjm(81, "org.dsi.ifc.navigation.DSINavigationListener", 1431435719, 553619691), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcGetCountryAbbreviationResult(String string, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR58f943ddf.gjm(82, "org.dsi.ifc.navigation.DSINavigationListener", -1260493303, 977376590), 82, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trStartTraceRecordingResult(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(83, "org.dsi.ifc.navigation.DSINavigationListener", -2103562413, -1612125681), 83, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trStopTraceRecordingResult(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(84, "org.dsi.ifc.navigation.DSINavigationListener", -1628469857, -1612125681), 84, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = navSegmentID;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(85, "org.dsi.ifc.navigation.DSINavigationListener", 880761204, 1677270394), 85, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trRenameTraceResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(86, "org.dsi.ifc.navigation.DSINavigationListener", 993762245, 1676164096), 86, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trDeleteTraceResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(87, "org.dsi.ifc.navigation.DSINavigationListener", -1365858635, 1676164096), 87, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(88, "org.dsi.ifc.navigation.DSINavigationListener", 946038499, 1676164096), 88, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR58f943ddf.gjm(89, "org.dsi.ifc.navigation.DSINavigationListener", 1698299466, -995993593), 89, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteDeleteResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(90, "org.dsi.ifc.navigation.DSINavigationListener", 184554570, 1687814400), 90, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteDeleteAllResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(91, "org.dsi.ifc.navigation.DSINavigationListener", 2053081564, 1687814400), 91, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = route;
            this.h.invoke(this, LR58f943ddf.gjm(92, "org.dsi.ifc.navigation.DSINavigationListener", 1521802618, 560644816), 92, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteRenameResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(93, "org.dsi.ifc.navigation.DSINavigationListener", 1593254774, 1687814400), 93, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void importFileResult(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58f943ddf.gjm(94, "org.dsi.ifc.navigation.DSINavigationListener", -1285258553, -1600866162), 94, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void languageSpellableCharactersResult(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR58f943ddf.gjm(95, "org.dsi.ifc.navigation.DSINavigationListener", -957615316, -633848249), 95, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgNotPossible(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(96, "org.dsi.ifc.navigation.DSINavigationListener", 1678659832, 1687814400), 96, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void translateRouteResult(Route route) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = route;
            this.h.invoke(this, LR58f943ddf.gjm(97, "org.dsi.ifc.navigation.DSINavigationListener", 222887808, -900640479), 97, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = byArray;
            this.h.invoke(this, LR58f943ddf.gjm(98, "org.dsi.ifc.navigation.DSINavigationListener", 1647558531, 1416158467), 98, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = navLocation;
            this.h.invoke(this, LR58f943ddf.gjm(99, "org.dsi.ifc.navigation.DSINavigationListener", -1560943632, -796524928), 99, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liValueListFileStatus(int n, int n2, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = string;
            this.h.invoke(this, LR58f943ddf.gjm(100, "org.dsi.ifc.navigation.DSINavigationListener", 1431405095, 1150548731), 100, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDmFlagDestination(NavLocation navLocation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(101, "org.dsi.ifc.navigation.DSINavigationListener", -439543284, -2023978998), 101, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58f943ddf.gjm(102, "org.dsi.ifc.navigation.DSINavigationListener", -355066918, -1006107495), 102, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58f943ddf.gjm(103, "org.dsi.ifc.navigation.DSINavigationListener", -1033434941, -1006107495), 103, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lICityHistoryEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(104, "org.dsi.ifc.navigation.DSINavigationListener", 403170512, -972423086), 104, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLiCountryForCityAndStreetHistory(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(105, "org.dsi.ifc.navigation.DSINavigationListener", 861717909, -645498553), 105, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR58f943ddf.gjm(106, "org.dsi.ifc.navigation.DSINavigationListener", 176522865, -238538240), 106, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lIStreetHistoryEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(107, "org.dsi.ifc.navigation.DSINavigationListener", 2062194, 775630887), 107, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lIStateHistoryEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(108, "org.dsi.ifc.navigation.DSINavigationListener", 2116319495, -534202681), 108, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liHistoryResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(109, "org.dsi.ifc.navigation.DSINavigationListener", -913196677, 1687814400), 109, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58f943ddf.gjm(110, "org.dsi.ifc.navigation.DSINavigationListener", 313464351, -1006107495), 110, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgTurnListCalculationHorizon(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(111, "org.dsi.ifc.navigation.DSINavigationListener", -1604667571, -266965504), 111, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgPoiInfoCalculationHorizon(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(112, "org.dsi.ifc.navigation.DSINavigationListener", 29239940, -266965504), 112, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR58f943ddf.gjm(113, "org.dsi.ifc.navigation.DSINavigationListener", 53468429, -2012328694), 113, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR58f943ddf.gjm(114, "org.dsi.ifc.navigation.DSINavigationListener", 583488904, -2012328694), 114, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseAudioTrigger(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(115, "org.dsi.ifc.navigation.DSINavigationListener", 1485180489, 1687814400), 115, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(116, "org.dsi.ifc.navigation.DSINavigationListener", -278148470, 1687814400), 116, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(117, "org.dsi.ifc.navigation.DSINavigationListener", -131017895, 1687814400), 117, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58f943ddf.gjm(118, "org.dsi.ifc.navigation.DSINavigationListener", -1161471388, -1653679357), 118, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liThesaurusHistoryAddResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(119, "org.dsi.ifc.navigation.DSINavigationListener", 2083966485, 1676164096), 119, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry thesaurusHistoryEntry, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = thesaurusHistoryEntry;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(120, "org.dsi.ifc.navigation.DSINavigationListener", 632209078, -654615933), 120, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liThesaurusHistoryDeleteResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(121, "org.dsi.ifc.navigation.DSINavigationListener", -1806175797, 1676164096), 121, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liThesaurusHistoryDeleteAllResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(122, "org.dsi.ifc.navigation.DSINavigationListener", 1374639705, 1687814400), 122, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] thesaurusHistoryEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = thesaurusHistoryEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(123, "org.dsi.ifc.navigation.DSINavigationListener", -705383177, 448199346), 123, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCountryInfo(CountryInfo[] countryInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = countryInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(124, "org.dsi.ifc.navigation.DSINavigationListener", 1354697060, 1313881078), 124, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = countryInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(125, "org.dsi.ifc.navigation.DSINavigationListener", 1198400423, -462836873), 125, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = categoryArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(126, "org.dsi.ifc.navigation.DSINavigationListener", -595795949, -1249243306), 126, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = brandArray;
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR58f943ddf.gjm(127, "org.dsi.ifc.navigation.DSINavigationListener", 1642537844, 218596504), 127, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void ehResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(128, "org.dsi.ifc.navigation.DSINavigationListener", 360517899, 1676164096), 128, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRemainingRangeOfVehicleResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(129, "org.dsi.ifc.navigation.DSINavigationListener", 507227926, 1687814400), 129, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVehicleConsumptionInfoResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(130, "org.dsi.ifc.navigation.DSINavigationListener", -1859630319, 1687814400), 130, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUserDefinedPOIsResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(131, "org.dsi.ifc.navigation.DSINavigationListener", 2003482864, 1687814400), 131, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setTrailerStatusResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(132, "org.dsi.ifc.navigation.DSINavigationListener", 899306293, 1687814400), 132, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = viaPointListElementArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR58f943ddf.gjm(133, "org.dsi.ifc.navigation.DSINavigationListener", 191737418, -457258613), 133, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(134, "org.dsi.ifc.navigation.DSINavigationListener", -1916472086, -2023978998), 134, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStyleDBPaths(String[] stringArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(135, "org.dsi.ifc.navigation.DSINavigationListener", 498748980, -1178098921), 135, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRouteResumePossible(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(136, "org.dsi.ifc.navigation.DSINavigationListener", 1397120769, -1665395196), 136, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navSegmentID;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(137, "org.dsi.ifc.navigation.DSINavigationListener", -978779067, 1679287589), 137, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(138, "org.dsi.ifc.navigation.DSINavigationListener", -1895447112, -1953394071), 138, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = string;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(139, "org.dsi.ifc.navigation.DSINavigationListener", -1510137401, 253782595), 139, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navDataBaseArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(140, "org.dsi.ifc.navigation.DSINavigationListener", 21500645, 341124178), 140, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePersonalPOISearchStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(141, "org.dsi.ifc.navigation.DSINavigationListener", 809521868, 1676164096), 141, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deletePersonalPOIDataBasesResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(142, "org.dsi.ifc.navigation.DSINavigationListener", -1414810811, 1687814400), 142, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setVehicleFuelTypeResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(143, "org.dsi.ifc.navigation.DSINavigationListener", -869824314, 1676164096), 143, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void createNavLocationOfPOIUIDResult(long l, NavLocation navLocation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = navLocation;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(144, "org.dsi.ifc.navigation.DSINavigationListener", -878889399, -14292859), 144, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmRouteReplaceResult(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(145, "org.dsi.ifc.navigation.DSINavigationListener", 950024192, -1612125681), 145, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNavInternalDataToFactorySettingsResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(146, "org.dsi.ifc.navigation.DSINavigationListener", 1553708162, 1687814400), 146, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = tryMatchLocationResultDataArray;
            this.h.invoke(this, LR58f943ddf.gjm(147, "org.dsi.ifc.navigation.DSINavigationListener", -294705839, 664485980), 147, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = stringArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(148, "org.dsi.ifc.navigation.DSINavigationListener", 531141075, -1401574038), 148, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navSegmentIDArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(149, "org.dsi.ifc.navigation.DSINavigationListener", -2112921957, 284106918), 149, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trExportTrailsResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(150, "org.dsi.ifc.navigation.DSINavigationListener", 286352128, 1687814400), 150, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navNextWayPointInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(151, "org.dsi.ifc.navigation.DSINavigationListener", -1123143723, -2053992272), 151, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgStartRubberbandManipulationResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(152, "org.dsi.ifc.navigation.DSINavigationListener", 568267748, 1687814400), 152, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navRectangle;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(153, "org.dsi.ifc.navigation.DSINavigationListener", -1787310384, 1159578057), 153, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navLocation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(154, "org.dsi.ifc.navigation.DSINavigationListener", -959807950, -2023978998), 154, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(155, "org.dsi.ifc.navigation.DSINavigationListener", 663329308, 1687814400), 155, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = navLocationWgs84;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(156, "org.dsi.ifc.navigation.DSINavigationListener", 632390166, 407939732), 156, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgEnhancedSignPostInfoStatus(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(157, "org.dsi.ifc.navigation.DSINavigationListener", 652649339, -1665395196), 157, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcSetDemoModeResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(158, "org.dsi.ifc.navigation.DSINavigationListener", 650783788, 1687814400), 158, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = navLocation;
            this.h.invoke(this, LR58f943ddf.gjm(159, "org.dsi.ifc.navigation.DSINavigationListener", -1453859850, -1749998467), 159, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispGetMatchingNVCResult(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR58f943ddf.gjm(160, "org.dsi.ifc.navigation.DSINavigationListener", -1799807555, -633848249), 160, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = stringArray;
            this.h.invoke(this, LR58f943ddf.gjm(161, "org.dsi.ifc.navigation.DSINavigationListener", 211786060, -1166448617), 161, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = navPoiInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(162, "org.dsi.ifc.navigation.DSINavigationListener", -1693683574, -141377623), 162, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rgInfoForNextDestination;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(163, "org.dsi.ifc.navigation.DSINavigationListener", 1148205658, -585071033), 163, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rgTriggerRCCIUpdateResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(164, "org.dsi.ifc.navigation.DSINavigationListener", 0x75CC57CC, 1687814400), 164, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR58f943ddf.gjm(165, "org.dsi.ifc.navigation.DSINavigationListener", -1888736169, -2012328694), 165, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rgTurnToInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(166, "org.dsi.ifc.navigation.DSINavigationListener", -1717411687, -1557790221), 166, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcGetPositionTimeInfoResult(PosTimeInfo posTimeInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = posTimeInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(167, "org.dsi.ifc.navigation.DSINavigationListener", -665275622, 259283458), 167, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR58f943ddf.gjm(168, "org.dsi.ifc.navigation.DSINavigationListener", 162169310, 3523), 168, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRgPersistedRouteDataAvailable(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(169, "org.dsi.ifc.navigation.DSINavigationListener", 9992148, -1665395196), 169, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = navLocationArray;
            this.h.invoke(this, LR58f943ddf.gjm(170, "org.dsi.ifc.navigation.DSINavigationListener", 1732850882, -1966171079), 170, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(171, "org.dsi.ifc.navigation.DSINavigationListener", -1520136489, 1687814400), 171, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMapIntegrationState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(172, "org.dsi.ifc.navigation.DSINavigationListener", -2055753430, 1676164096), 172, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMapIntegrationProgress(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(173, "org.dsi.ifc.navigation.DSINavigationListener", -1009800778, 1676164096), 173, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void etcTriggerNavigationRestartResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(174, "org.dsi.ifc.navigation.DSINavigationListener", -1457402700, 1676164096), 174, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void lispRequestNVCListResult(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(175, "org.dsi.ifc.navigation.DSINavigationListener", 916992288, 1276482132), 175, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBapManeuverState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(176, "org.dsi.ifc.navigation.DSINavigationListener", 89777310, 1676164096), 176, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void rmImportToursFromGpxFileResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(177, "org.dsi.ifc.navigation.DSINavigationListener", -1201425126, 1687814400), 177, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tourImportStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58f943ddf.gjm(178, "org.dsi.ifc.navigation.DSINavigationListener", -1234553940, 1466890078), 178, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void importRouteFromGpxFileResult(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR58f943ddf.gjm(179, "org.dsi.ifc.navigation.DSINavigationListener", 1871199263, -2012328694), 179, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = bapManeuverDescriptorArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58f943ddf.gjm(180, "org.dsi.ifc.navigation.DSINavigationListener", 1615779007, 1410340865), 180, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = poiExtendedInfo;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58f943ddf.gjm(181, "org.dsi.ifc.navigation.DSINavigationListener", -1091293359, -1365027086), 181, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void trClearRecordedTraceCacheResult() {
        try {
            this.h.invoke(this, LR58f943ddf.gjm(182, "org.dsi.ifc.navigation.DSINavigationListener", -1911523641, 17), 182, ZOA);
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

