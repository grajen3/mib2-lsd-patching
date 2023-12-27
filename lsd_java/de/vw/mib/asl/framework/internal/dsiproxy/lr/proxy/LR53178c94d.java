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
import org.dsi.ifc.tpegservices.DSITPEGServicesListener;
import org.dsi.ifc.tpegservices.FuelPriceInformation;
import org.dsi.ifc.tpegservices.NewsCategory;
import org.dsi.ifc.tpegservices.ResourceInformation;
import org.dsi.ifc.tpegservices.SimpleMapData;
import org.dsi.ifc.tpegservices.WeatherInfo;
import org.dsi.ifc.trafficregulation.DSITrafficRegulationListener;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public final class LR53178c94d
extends AbstractProxy
implements DSITrafficRegulationListener,
DSITPEGServicesListener {
    private static final Method[] JMS = new Method[19];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR53178c94d(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateCountrySpeedInformation(RoadClassSpeedInfo[] roadClassSpeedInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = roadClassSpeedInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53178c94d.gjm(0, "org.dsi.ifc.trafficregulation.DSITrafficRegulationListener", -2022049781, -200198824), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCurrentTrafficSign(TrafficSignInformation trafficSignInformation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = trafficSignInformation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53178c94d.gjm(1, "org.dsi.ifc.trafficregulation.DSITrafficRegulationListener", 1071241195, -207367584), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrafficSignOnRoute(TrafficSignInformationOnRoute[] trafficSignInformationOnRouteArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = trafficSignInformationOnRouteArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53178c94d.gjm(2, "org.dsi.ifc.trafficregulation.DSITrafficRegulationListener", 248525921, -1243969024), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestRoadClassSpeedInfoForCountryResult(RoadClassSpeedInfo[] roadClassSpeedInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = roadClassSpeedInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53178c94d.gjm(3, "org.dsi.ifc.trafficregulation.DSITrafficRegulationListener", -881147335, -200198824), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTrailerStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53178c94d.gjm(4, "org.dsi.ifc.trafficregulation.DSITrafficRegulationListener", 833064389, 1676164096), 4, objectArray);
            return;
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
            this.h.invoke(this, LR53178c94d.gjm(5, "org.dsi.ifc.trafficregulation.DSITrafficRegulationListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = resourceInformation;
            this.h.invoke(this, LR53178c94d.gjm(6, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", 85267463, 313129090), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLanguageResponse(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53178c94d.gjm(7, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", -1338868692, -1653679357), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTPEGContentAvailability(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53178c94d.gjm(8, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", 44805550, -1034208512), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSimpleMapsBookmarks(SimpleMapData[] simpleMapDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = simpleMapDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53178c94d.gjm(9, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", -2142772341, 912445903), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestLocationDetailsResponse(NavLocation navLocation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = navLocation;
            this.h.invoke(this, LR53178c94d.gjm(10, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", 345504957, -2012328694), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestFuelPriceInformationResponse(FuelPriceInformation[] fuelPriceInformationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = fuelPriceInformationArray;
            this.h.invoke(this, LR53178c94d.gjm(11, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", -28718471, 1558953715), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestNewsInformationResponse(NewsCategory newsCategory) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = newsCategory;
            this.h.invoke(this, LR53178c94d.gjm(12, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", -1608079689, -218740935), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestSimpleMapListResponse(int n, int n2, SimpleMapData[] simpleMapDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = simpleMapDataArray;
            this.h.invoke(this, LR53178c94d.gjm(13, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", -1895459676, -1717055975), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void addSimpleMapBookmarkResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53178c94d.gjm(14, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", 1906211691, 1676164096), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteSimpleMapBookmarkResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53178c94d.gjm(15, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", 663144197, 1676164096), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteAllSimpleMapBookmarksResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53178c94d.gjm(16, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", 1536552046, 1687814400), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestWeatherInfoResult(WeatherInfo weatherInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = weatherInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53178c94d.gjm(17, "org.dsi.ifc.tpegservices.DSITPEGServicesListener", 636574150, 718986701), 17, objectArray);
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

