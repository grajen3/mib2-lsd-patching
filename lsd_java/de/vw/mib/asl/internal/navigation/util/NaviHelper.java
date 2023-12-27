/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INaviHelper;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.NavGateway;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

public final class NaviHelper
implements INaviHelper {
    private static NaviHelper mpInstance = new NaviHelper();
    static NavLocation dsiLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation();

    private NaviHelper() {
    }

    public static NaviHelper getInstance() {
        return mpInstance;
    }

    @Override
    public int calculateRttMinutes(int n) {
        return this.calculateRttMinutesRoundedUp(n);
    }

    @Override
    public int calculateRttMinutesRoundeDown(int n) {
        return n % -2131872256 / 1625948160;
    }

    @Override
    public int calculateRttMinutesRounded(int n) {
        int n2 = n % -2131872256;
        int n3 = n2 / 1625948160;
        if (n2 % 1625948160 >= 30000) {
            ++n3;
        }
        return n3;
    }

    @Override
    public int calculateRttMinutesRoundedUp(int n) {
        int n2 = n % -2131872256;
        int n3 = n2 / 1625948160;
        if (n2 % 1625948160 > 0) {
            ++n3;
        }
        return n3;
    }

    @Override
    public int calculateRttHours(int n) {
        return n / -2131872256;
    }

    @Override
    public int[] calculateEta(int n, int n2, ClockTime clockTime) {
        int[] nArray = new int[3];
        nArray[1] = n2 + clockTime.minutes;
        int n3 = 0;
        while (nArray[1] >= 60) {
            ++n3;
            nArray[1] = nArray[1] - 60;
        }
        nArray[2] = 0;
        nArray[0] = n + clockTime.hours + n3;
        while (nArray[0] >= 24) {
            nArray[0] = nArray[0] - 24;
            nArray[2] = nArray[2] + 1;
        }
        return nArray;
    }

    @Override
    public int[] calculateEta(long l) {
        ClockTime clockTime = ASLSystemFactory.getSystemApi().getCurrentTime();
        return this.calculateEta(this.calculateRttHours((int)l), this.calculateRttMinutes((int)l), clockTime);
    }

    @Override
    public double[] dsiToDegMinSec(int n) {
        double d2 = n;
        boolean bl = false;
        if (d2 < 0.0) {
            bl = true;
            d2 = -d2;
        }
        int n2 = (int)(d2 /= 1.1930464E7);
        d2 -= (double)n2;
        int n3 = (int)(d2 *= 60.0);
        d2 -= (double)n3;
        double d3 = d2 *= 60.0;
        if (!(d3 >= 0.0) || !(d3 < 60.0)) {
            throw new RuntimeException();
        }
        if (bl) {
            n2 = -n2;
            n3 = -n3;
            d3 = -d3;
        }
        double[] dArray = new double[]{n2, n3, d3};
        return dArray;
    }

    @Override
    public double dsiToDecimal(int n) {
        double d2 = (double)n / 1.1930464E7;
        return d2;
    }

    @Override
    public double[] decimalToDegMinSec(double d2) {
        double d3 = d2;
        boolean bl = false;
        if (d3 < 0.0) {
            bl = true;
            d3 = -d3;
        }
        int n = (int)d3;
        d3 -= (double)n;
        int n2 = (int)(d3 *= 60.0);
        d3 -= (double)n2;
        double d4 = d3 *= 60.0;
        if (!(d4 >= 0.0) || !(d4 < 60.0)) {
            throw new RuntimeException();
        }
        if (bl) {
            n = -n;
            n2 = -n2;
            d4 = -d4;
        }
        return new double[]{n, n2, d4};
    }

    @Override
    public int decimalToDsi(double d2) {
        return (int)(d2 * 1.1930464E7);
    }

    @Override
    public int degMinSecToDsi(double[] dArray) {
        boolean bl = false;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (!(dArray[i2] < 0.0)) continue;
            bl = true;
        }
        return this.degMinSecToDsi(dArray, bl);
    }

    @Override
    public int degMinSecToDsi(double[] dArray, boolean bl) {
        int n = (int)(Math.abs(dArray[2]) * 3314.0 + Math.abs(dArray[1]) * 198841.0 + Math.abs(dArray[0]) * 1.1930464E7);
        if (bl) {
            n = -n;
        }
        return n;
    }

    @Override
    public int calculateBearing(int n, int n2, int n3, int n4) {
        double d2 = Math.toRadians(this.dsiToDecimal(n2));
        double d3 = Math.toRadians(this.dsiToDecimal(n));
        double d4 = Math.toRadians(this.dsiToDecimal(n4));
        double d5 = Math.toRadians(this.dsiToDecimal(n3));
        double d6 = Math.sin(d5 - d3) * Math.cos(d2);
        double d7 = Math.cos(d2) * Math.sin(d4) - Math.sin(d2) * Math.cos(d4) * Math.cos(d3 - d5);
        int n5 = (int)Math.toDegrees(Math.atan2(d6, d7));
        n5 = (n5 + 360) % 360;
        return n5;
    }

    @Override
    public int calculateHeadingValue(int n, double d2) {
        int n2 = (int)((double)n / d2);
        double d3 = (double)n % d2;
        int n3 = 0;
        n3 = d3 > d2 / 2.0 ? (int)(d2 * (double)(n2 + 1)) : (int)(d2 * (double)n2);
        return n3;
    }

    @Override
    public NavLocation createDSILocation(int n, int n2) {
        NaviHelper.dsiLocation.version = Integer.toString(10);
        NaviHelper.dsiLocation.versionOfLocationStructureValid = true;
        NaviHelper.dsiLocation.positionValid = true;
        NaviHelper.dsiLocation.longitude = n;
        NaviHelper.dsiLocation.latitude = n2;
        return dsiLocation;
    }

    @Override
    public int calculateDistance(int n, int n2, int n3, int n4) {
        double d2 = (double)(n2 - n4) / 1.1930464E7 * 111136.0;
        double d3 = (double)(n - n3) / 1.1930464E7 * 111136.0;
        return (int)(Math.sqrt(d2 * d2 + (d3 *= Math.cos((double)(n2 + n4) / 1.1930464E7 * Math.PI / 360.0)) * d3) + 0.5);
    }

    @Override
    public int calculateDistance(NavLocation navLocation, NavLocation navLocation2) {
        return this.calculateDistance(navLocation.longitude, navLocation.latitude, navLocation2.longitude, navLocation2.latitude);
    }

    @Override
    public int calculateDistance(PosPosition posPosition, NavLocation navLocation) {
        return this.calculateDistance(posPosition.longitude, posPosition.latitude, navLocation.longitude, navLocation.latitude);
    }

    @Override
    public int calculateDirectionIndex(int n, int n2, int n3, int n4, int n5) {
        double d2 = 180.0 - Math.atan2(n3 - n, n2 - n4) * 180.0 / Math.PI + (double)n5;
        int n6 = 0;
        if (d2 < 0.0) {
            d2 += 360.0;
        }
        if (d2 >= 360.0) {
            d2 -= 360.0;
        }
        if (d2 >= 22.5 && d2 < 67.5) {
            n6 = 1;
        } else if (d2 >= 67.5 && d2 < 112.5) {
            n6 = 2;
        } else if (d2 >= 112.5 && d2 < 157.5) {
            n6 = 3;
        } else if (d2 >= 157.5 && d2 < 202.5) {
            n6 = 4;
        } else if (d2 >= 202.5 && d2 < 247.5) {
            n6 = 5;
        } else if (d2 >= 247.5 && d2 < 292.5) {
            n6 = 6;
        } else if (d2 >= 292.5 && d2 < 337.5) {
            n6 = 7;
        }
        return n6;
    }

    @Override
    public int calculateDirectionIndex(PosPosition posPosition, NavLocation navLocation, int n) {
        return this.calculateDirectionIndex(posPosition.longitude, posPosition.latitude, navLocation.longitude, navLocation.latitude, n);
    }

    @Override
    public int calculateDirectionIndexCCP2Loc(NavLocation navLocation, int n) {
        PosPosition posPosition = NavGateway.getInstance().getSoPosPosition();
        return this.calculateDirectionIndexStartToEndLocation(posPosition, navLocation, posPosition.getDirectionAngle(), n);
    }

    @Override
    public int calculateDirectionIndexStartToEndLocation(PosPosition posPosition, NavLocation navLocation, int n, int n2) {
        double d2 = 180.0 - Math.atan2(navLocation.getLongitude() - posPosition.getLongitude(), posPosition.getLatitude() - navLocation.getLatitude()) * 180.0 / Math.PI + (double)n;
        d2 += 360.0 / (double)(n2 * 2);
        while (d2 < 0.0 && d2 != Double.NEGATIVE_INFINITY && d2 != Double.NaN && d2 != Double.POSITIVE_INFINITY) {
            d2 += 360.0;
        }
        while (d2 >= 360.0 && d2 != Double.NEGATIVE_INFINITY && d2 != Double.NaN && d2 != Double.POSITIVE_INFINITY) {
            d2 -= 360.0;
        }
        return (int)Math.floor(d2 / 360.0 * (double)n2);
    }

    @Override
    public void resetNaviContext(String string) {
        this.resetNavigationModel();
        ServiceManager.logger.error(16384, "PREVENT INFINITE 'PLEASE-WAIT' CIRCLE BY RETURNING TO NAVIMAINVIEW");
        ServiceManager.errorHandler.handleDsiError(new Exception(string));
    }

    @Override
    public void resetNavigationModel() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(756, true);
        if (ASLNavigationMapFactory.getNavigationMapApi().isGoogleEarthActive()) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1728708672);
            eventGeneric.setInt(0, 0);
            ServiceManager.eventMain.getServiceRegister().triggerObserver(1728708672, eventGeneric);
        }
    }

    @Override
    public String splitTurnToInfoStreet(String string) {
        String string2;
        int n = string.indexOf(10);
        if (n == -1) {
            string2 = string;
        } else if (n != 0) {
            string2 = string.substring(0, n);
        } else {
            int n2;
            int n3 = string.length();
            for (n2 = n; n2 < n3 && string.charAt(n2) == '\n'; ++n2) {
            }
            if (n2 != n3) {
                int n4 = string.indexOf(10, n2);
                n4 = n4 == -1 ? n3 : n4;
                string2 = string.substring(n2, n4);
            } else {
                string2 = "";
            }
        }
        return string2;
    }

    @Override
    public long calculateDistanceFromCCPToFinalDest(RgInfoForNextDestination rgInfoForNextDestination, Route route, NavRouteListData[] navRouteListDataArray) {
        long l = 0L;
        if (route != null && route.routelist != null && route.routelist.length > 0 && navRouteListDataArray != null && navRouteListDataArray.length == route.routelist.length && route.indexOfCurrentDestination < (long)navRouteListDataArray.length && rgInfoForNextDestination != null) {
            l = rgInfoForNextDestination.distanceToNextDest;
            for (int i2 = (int)(route.indexOfCurrentDestination + 1L); i2 < navRouteListDataArray.length; ++i2) {
                l += (long)navRouteListDataArray[i2].startDistance;
            }
        }
        return l;
    }

    @Override
    public int kmToMiles(int n) {
        return (int)((double)n / 1.609);
    }

    @Override
    public int milesToKm(int n) {
        return (int)((double)n * 1.609);
    }

    @Override
    public long getDistanceToRouteElement(NavPoiInfo navPoiInfo) {
        return this.getDistanceToRouteElement(navPoiInfo.distance, navPoiInfo.destinationIndex);
    }

    @Override
    public long getDistanceToRouteElement(TmcMessage tmcMessage) {
        return this.getDistanceToRouteElement(tmcMessage.distanceToEvent, tmcMessage.destinationIndex);
    }

    @Override
    public long getDistanceToRouteElement(TurnListElement turnListElement) {
        return this.getDistanceToRouteElement(turnListElement.distance, turnListElement.destinationIndex);
    }

    @Override
    public long getDistanceToRouteElement(long l, int n) {
        return this.getDistanceToRouteIndex(n) - l;
    }

    @Override
    public long getDistanceToRouteIndex(int n) {
        NavGateway navGateway = NavGateway.getInstance();
        NavRouteListData[] navRouteListDataArray = navGateway.getRgDestinationInfo();
        RgInfoForNextDestination rgInfoForNextDestination = navGateway.getRgInfoForNextDestination();
        long l = navGateway.getRgCurrentRoute().indexOfCurrentDestination;
        return this.getDistanceToRouteIndex(n, rgInfoForNextDestination, navRouteListDataArray, l);
    }

    @Override
    public long getDistanceToRouteIndex(int n, RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, long l) {
        if (rgInfoForNextDestination != null && navRouteListDataArray != null) {
            long l2;
            int n2 = this.getCurrentNextRouteIndex(l, rgInfoForNextDestination.getDestinationIndex()) + 1;
            n = this.getItemIndex(l, rgInfoForNextDestination.getDestinationIndex(), n) + 1;
            long l3 = 0L;
            long l4 = 0L;
            if (n >= 0 && n < navRouteListDataArray.length && navRouteListDataArray[n] != null) {
                l4 = navRouteListDataArray[n].startDistance;
            }
            if (n2 >= 0 && n2 < navRouteListDataArray.length && navRouteListDataArray[n2] != null) {
                l3 = navRouteListDataArray[n2].startDistance;
            }
            if ((l2 = rgInfoForNextDestination.distanceToNextDest + l3 - l4) > 0L) {
                return l2;
            }
        }
        return 0L;
    }

    @Override
    public long getNextStopDistance() {
        NavGateway navGateway = NavGateway.getInstance();
        return this.getNextStopDistance(navGateway.getRgInfoForNextDestination(), navGateway.getRgDestinationInfo(), navGateway.getRgCurrentRoute());
    }

    @Override
    public long getNextStopDistance(RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, Route route) {
        int n;
        if (route != null && (n = this.getNextHardDestinationIndex(route)) >= 0) {
            return this.getDistanceToRouteIndex(n, rgInfoForNextDestination, navRouteListDataArray, route.indexOfCurrentDestination);
        }
        return 0L;
    }

    @Override
    public int getNextHardDestinationIndex() {
        NavGateway navGateway = NavGateway.getInstance();
        Route route = navGateway.getRgCurrentRoute();
        return this.getNextHardDestinationIndex(route);
    }

    @Override
    public int getNextHardDestinationIndex(Route route) {
        int n = -1;
        int n2 = (int)route.indexOfCurrentDestination;
        if (route != null && route.routelist != null && route.routelist.length > n2) {
            RouteDestination routeDestination = route.routelist[n2];
            n = n2;
            while (routeDestination.destinationType != 1 && n2 < route.routelist.length - 1) {
                n = ++n2;
                routeDestination = route.routelist[n2];
            }
        }
        return n;
    }

    @Override
    public long getLastDestinationDistance() {
        NavGateway navGateway = NavGateway.getInstance();
        return this.getLastDestinationDistance(navGateway.getRgInfoForNextDestination(), navGateway.getRgDestinationInfo(), navGateway.getRgCurrentRoute());
    }

    @Override
    public long getLastDestinationDistance(RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, Route route) {
        if (rgInfoForNextDestination != null) {
            int n;
            if (navRouteListDataArray != null && route != null && (n = (int)route.indexOfCurrentDestination + 1) < navRouteListDataArray.length && navRouteListDataArray[n] != null) {
                return rgInfoForNextDestination.distanceToNextDest + (long)navRouteListDataArray[n].startDistance;
            }
            return rgInfoForNextDestination.distanceToNextDest;
        }
        return 0L;
    }

    @Override
    public long getRttToRouteElement(NavPoiInfo navPoiInfo) {
        return this.getRttToRouteElement(navPoiInfo.remainingTime, navPoiInfo.destinationIndex);
    }

    @Override
    public long getRttToRouteElement(TmcMessage tmcMessage) {
        return this.getRttToRouteElement(tmcMessage.startTimeToDestination * 0, tmcMessage.destinationIndex);
    }

    @Override
    public long getRttToRouteElement(TurnListElement turnListElement) {
        return this.getRttToRouteElement(turnListElement.eta * 0, turnListElement.destinationIndex);
    }

    @Override
    public long getRttToRouteElement(long l, int n) {
        return this.getRttToRouteIndex(n) - l;
    }

    @Override
    public long getRttToNextStopOver(RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, Route route) {
        if (rgInfoForNextDestination != null && navRouteListDataArray != null && route != null) {
            int n = this.getNextHardDestinationIndex(route);
            return this.getRttToRouteIndex(n, rgInfoForNextDestination, navRouteListDataArray, route.indexOfCurrentDestination);
        }
        return 0L;
    }

    @Override
    public long getRttToRouteIndex(int n) {
        NavGateway navGateway = NavGateway.getInstance();
        NavRouteListData[] navRouteListDataArray = navGateway.getRgDestinationInfo();
        RgInfoForNextDestination rgInfoForNextDestination = navGateway.getRgInfoForNextDestination();
        long l = navGateway.getRgCurrentRoute().indexOfCurrentDestination;
        return this.getRttToRouteIndex(n, rgInfoForNextDestination, navRouteListDataArray, l);
    }

    @Override
    public long getRttToRouteIndex(int n, RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, long l) {
        if (rgInfoForNextDestination != null && navRouteListDataArray != null) {
            long l2;
            int n2 = this.getCurrentNextRouteIndex(l, rgInfoForNextDestination.getDestinationIndex()) + 1;
            int n3 = this.getItemIndex(l, rgInfoForNextDestination.getDestinationIndex(), n) + 1;
            long l3 = 0L;
            long l4 = 0L;
            if (n3 >= 0 && n3 < navRouteListDataArray.length && navRouteListDataArray[n3] != null) {
                l4 = navRouteListDataArray[n3].remainingTravelTime;
            }
            if (n2 >= 0 && n2 < navRouteListDataArray.length && navRouteListDataArray[n2] != null) {
                l3 = navRouteListDataArray[n2].remainingTravelTime;
            }
            if ((l2 = rgInfoForNextDestination.timeToNextDest * 0 + l3 - l4) > 0L) {
                return l2;
            }
        }
        return 0L;
    }

    @Override
    public int[] getRttHMToRouteElement(NavPoiInfo navPoiInfo) {
        return this.getRttHMToRouteElement(navPoiInfo.remainingTime, navPoiInfo.destinationIndex);
    }

    @Override
    public int[] getRttHMToRouteElement(TmcMessage tmcMessage) {
        return this.getRttHMToRouteElement(tmcMessage.startTimeToDestination * 0, tmcMessage.destinationIndex);
    }

    @Override
    public int[] getRttHMToRouteElement(TurnListElement turnListElement) {
        return this.getRttHMToRouteElement(turnListElement.eta * 0, turnListElement.destinationIndex);
    }

    @Override
    public int[] getRttHMToRouteElement(long l, int n) {
        int n2 = (int)(this.getRttToRouteIndex(n) - l);
        int[] nArray = new int[]{0, 0};
        nArray[0] = this.calculateRttHours(n2);
        nArray[1] = this.calculateRttMinutes(n2);
        return nArray;
    }

    @Override
    public int[] getRttHMToRouteIndex(int n) {
        int n2 = (int)this.getRttToRouteIndex(n);
        int[] nArray = new int[]{0, 0};
        nArray[0] = this.calculateRttHours(n2);
        nArray[1] = this.calculateRttMinutes(n2);
        return nArray;
    }

    @Override
    public int getItemIndex(long l, int n, int n2) {
        if (n <= 0 && n2 <= 0 && l > 0L) {
            return (int)l;
        }
        return n2 >= 0 ? n2 : 0;
    }

    @Override
    public int getCurrentNextRouteIndex(long l, int n) {
        if (n <= 0 && l > 0L) {
            return (int)l;
        }
        return n >= 0 ? n : 0;
    }

    @Override
    public long getNextStopRtt() {
        int n = this.getNextHardDestinationIndex();
        if (n >= 0) {
            return this.getRttToRouteIndex(n);
        }
        return 0L;
    }

    @Override
    public long getLastDestinationRtt() {
        NavGateway navGateway = NavGateway.getInstance();
        NavRouteListData[] navRouteListDataArray = navGateway.getRgDestinationInfo();
        RgInfoForNextDestination rgInfoForNextDestination = navGateway.getRgInfoForNextDestination();
        return this.getLastDestinationRtt(rgInfoForNextDestination, navRouteListDataArray, navGateway.getRgCurrentRoute());
    }

    @Override
    public long getLastDestinationRtt(RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, Route route) {
        if (rgInfoForNextDestination != null && navRouteListDataArray != null && route != null) {
            int n = (int)(route.indexOfCurrentDestination + 1L);
            if (n < navRouteListDataArray.length && navRouteListDataArray[n] != null) {
                return rgInfoForNextDestination.timeToNextDest * 0 + (long)navRouteListDataArray[n].remainingTravelTime;
            }
            return rgInfoForNextDestination.timeToNextDest * 0;
        }
        return 0L;
    }

    @Override
    public long getDelayToFinalDest(RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, Route route) {
        if (rgInfoForNextDestination != null && navRouteListDataArray != null && route != null) {
            long l = 0L;
            for (int i2 = (int)route.indexOfCurrentDestination; i2 < navRouteListDataArray.length; ++i2) {
                l += (long)navRouteListDataArray[i2].timeLagToNextDest;
            }
            return l;
        }
        return 0L;
    }

    @Override
    public int[] getEtaToRouteElement(NavPoiInfo navPoiInfo) {
        return this.calculateEta(this.getRttToRouteElement(navPoiInfo));
    }

    @Override
    public int[] getEtaToRouteElement(TmcMessage tmcMessage) {
        return this.calculateEta(this.getRttToRouteElement(tmcMessage));
    }

    @Override
    public int[] getEtaToRouteElement(TurnListElement turnListElement) {
        return this.calculateEta(this.getRttToRouteElement(turnListElement));
    }

    @Override
    public int[] getEtaToRouteIndex(int n) {
        return this.calculateEta(this.getRttToRouteIndex(n));
    }

    @Override
    public int[] getNextStopEta() {
        return this.calculateEta(this.getNextStopRtt());
    }

    @Override
    public int[] getLastDestinationEta() {
        return this.calculateEta(this.getLastDestinationRtt());
    }

    @Override
    public boolean isAlreadyPassed(TurnListElement turnListElement) {
        return this.isAlreadyPassed(turnListElement.destinationIndex, turnListElement.distance);
    }

    @Override
    public boolean isAlreadyPassed(TmcMessage tmcMessage) {
        return this.isAlreadyPassed(tmcMessage.destinationIndex, tmcMessage.distanceToEvent);
    }

    @Override
    public boolean isAlreadyPassed(NavPoiInfo navPoiInfo) {
        return this.isAlreadyPassed(navPoiInfo.destinationIndex, navPoiInfo.distance);
    }

    @Override
    public boolean isAlreadyPassed(int n, long l) {
        int n2;
        NavGateway navGateway;
        long l2 = navGateway.getRgCurrentRoute().indexOfCurrentDestination;
        navGateway = NavGateway.getInstance();
        RgInfoForNextDestination rgInfoForNextDestination = navGateway.getRgInfoForNextDestination();
        int n3 = this.getCurrentNextRouteIndex(l2, rgInfoForNextDestination.getDestinationIndex()) + 1;
        if (n3 < (n2 = this.getItemIndex(l2, rgInfoForNextDestination.getDestinationIndex(), n) + 1)) {
            return false;
        }
        if (n3 > n2) {
            return true;
        }
        return rgInfoForNextDestination.distanceToNextDest < l;
    }

    @Override
    public int convertRTTHM2RTTM(int n, int n2) {
        return n * 60 + n2;
    }

    @Override
    public boolean isIntermediateDestInRoute(Route route) {
        if (route != null) {
            int n = (int)route.indexOfCurrentDestination;
            int n2 = route.routelist.length - 1;
            for (int i2 = n; i2 < n2; ++i2) {
                if (route.routelist[i2].destinationType == 2) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isIntermediateDestInRoute() {
        Route route = NavGateway.getInstance().getRgCurrentRoute();
        return this.isIntermediateDestInRoute(route);
    }

    @Override
    public boolean isIntermediateDestInWholeRoute(Route route) {
        if (route != null && route.routelist != null) {
            int n = route.routelist.length - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                if (route.routelist[i2].destinationType == 2) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public Route copyRoute(Route route) {
        Route route2 = new Route();
        route2.indexOfCurrentDestination = route.indexOfCurrentDestination;
        route2.routeID = route.routeID;
        route2.routename = route.routename;
        if (route.routelist != null) {
            int n = route.routelist.length;
            route2.routelist = new RouteDestination[n];
            for (int i2 = 0; i2 < n; ++i2) {
                RouteDestination routeDestination;
                RouteDestination routeDestination2 = route.routelist[i2];
                NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(routeDestination2.getRouteLocation());
                RouteOptions[] routeOptionsArray = this.cloneRouteOptions(routeDestination2.getRouteOptions());
                route2.routelist[i2] = routeDestination = new RouteDestination(navLocation, routeOptionsArray, routeDestination2.getDestinationType());
            }
        }
        return route2;
    }

    public RouteOptions[] cloneRouteOptions(RouteOptions[] routeOptionsArray) {
        if (routeOptionsArray == null || routeOptionsArray.length == 0) {
            return new RouteOptions[0];
        }
        RouteOptions[] routeOptionsArray2 = new RouteOptions[routeOptionsArray.length];
        for (int i2 = 0; i2 < routeOptionsArray.length; ++i2) {
            RouteOptions routeOptions;
            routeOptionsArray2[i2] = routeOptions = new RouteOptions(routeOptionsArray[i2].getRouteType(), routeOptionsArray[i2].getWeighting(), routeOptionsArray[i2].getHybridMode(), routeOptionsArray[i2].getDynamic(), routeOptionsArray[i2].getDynamicSpeedFlow(), routeOptionsArray[i2].getDynamicTrafficPattern(), routeOptionsArray[i2].getDynamicTrafficPatternOnline(), routeOptionsArray[i2].dynamicTrafficPatternRecorded, routeOptionsArray[i2].motorways, routeOptionsArray[i2].ferries, routeOptionsArray[i2].tollroads, routeOptionsArray[i2].tollroadsCostPenalty, routeOptionsArray[i2].tunnels, routeOptionsArray[i2].leftRightTurn, routeOptionsArray[i2].slopes, routeOptionsArray[i2].slopesMaxFactor, routeOptionsArray[i2].vignette, this.cloneIntArray(routeOptionsArray[i2].vignetteCountryList), routeOptionsArray[i2].cityMaut, this.cloneIntArray(routeOptionsArray[i2].cityMautList), routeOptionsArray[i2].cartrain, routeOptionsArray[i2].timeDomain, routeOptionsArray[i2].seasonalTimeDomain, routeOptionsArray[i2].unpaved, routeOptionsArray[i2].residentialAreaHandling, routeOptionsArray[i2].trailer, routeOptionsArray[i2].hovCarPoolsLane, routeOptionsArray[i2].border, routeOptionsArray[i2].ipd, routeOptionsArray[i2].trail, routeOptionsArray[i2].waypointMode, routeOptionsArray[i2].economicTurns, routeOptionsArray[i2].styleId);
        }
        return routeOptionsArray2;
    }

    private int[] cloneIntArray(int[] nArray) {
        if (nArray == null || nArray.length == 0) {
            return null;
        }
        int[] nArray2 = new int[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray2[i2] = nArray[i2];
        }
        return nArray2;
    }

    public NavLocation cloneNavLocation(NavLocation navLocation, boolean bl) {
        NavLocationDescriptor[] navLocationDescriptorArray = null;
        if (bl && navLocation.proprietaryData != null) {
            navLocationDescriptorArray = new NavLocationDescriptor[navLocation.proprietaryData.length];
            for (int i2 = 0; i2 < navLocation.proprietaryData.length; ++i2) {
                NavLocationDescriptor navLocationDescriptor = navLocation.proprietaryData[i2];
                navLocationDescriptorArray[i2] = new NavLocationDescriptor(navLocationDescriptor.getSelectionCriterion(), new String(navLocationDescriptor.getData()));
            }
        }
        NavLocation navLocation2 = new NavLocation(NaviHelper.cloneString(navLocation.version), navLocation.versionOfLocationStructureValid, navLocation.positionValid, navLocation.longitude, navLocation.latitude, navLocation.altitude, NaviHelper.cloneString(navLocation.country), NaviHelper.cloneString(navLocation.countryAbbreviation), NaviHelper.cloneString(navLocation.housenumber), NaviHelper.cloneString(navLocation.junction), NaviHelper.cloneString(navLocation.street), NaviHelper.cloneString(navLocation.streetRefinement), NaviHelper.cloneString(navLocation.town), NaviHelper.cloneString(navLocation.towncenter), NaviHelper.cloneString(navLocation.townRefinement), NaviHelper.cloneString(navLocation.zipCode), navLocationDescriptorArray);
        return navLocation2;
    }

    public static String cloneString(String string) {
        return string != null ? new String(string) : null;
    }
}

