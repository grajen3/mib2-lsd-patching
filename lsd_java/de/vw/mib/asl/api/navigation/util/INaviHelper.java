/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

public interface INaviHelper {
    public static final int ETA_INDEX_HOURS;
    public static final int ETA_INDEX_MINUTES;
    public static final int ETA_INDEX_DAYS;
    public static final int RTT_INDEX_HOURS;
    public static final int RTT_INDEX_MINUTES;
    public static final int RTT_INDEX_DAYS;
    public static final double EARTHSRADIUS;
    public static final int METRICSYSTEM_KILOMETERS_METERS;
    public static final int METRICSYSTEM_GB;
    public static final int METRICSYSTEM_US;
    public static final double MILE_KM_FACTOR;
    public static final int METERS_BETWEEN_DEGREES;

    default public int calculateRttMinutes(int n) {
    }

    default public int calculateRttMinutesRoundeDown(int n) {
    }

    default public int calculateRttMinutesRounded(int n) {
    }

    default public int calculateRttMinutesRoundedUp(int n) {
    }

    default public int calculateRttHours(int n) {
    }

    default public int[] calculateEta(int n, int n2, ClockTime clockTime) {
    }

    default public int[] calculateEta(long l) {
    }

    default public double[] dsiToDegMinSec(int n) {
    }

    default public double dsiToDecimal(int n) {
    }

    default public double[] decimalToDegMinSec(double d2) {
    }

    default public int decimalToDsi(double d2) {
    }

    default public int degMinSecToDsi(double[] dArray) {
    }

    default public int degMinSecToDsi(double[] dArray, boolean bl) {
    }

    default public int calculateBearing(int n, int n2, int n3, int n4) {
    }

    default public int calculateHeadingValue(int n, double d2) {
    }

    default public NavLocation createDSILocation(int n, int n2) {
    }

    default public int calculateDistance(int n, int n2, int n3, int n4) {
    }

    default public int calculateDistance(NavLocation navLocation, NavLocation navLocation2) {
    }

    default public int calculateDistance(PosPosition posPosition, NavLocation navLocation) {
    }

    default public int calculateDirectionIndex(int n, int n2, int n3, int n4, int n5) {
    }

    default public int calculateDirectionIndex(PosPosition posPosition, NavLocation navLocation, int n) {
    }

    default public int calculateDirectionIndexCCP2Loc(NavLocation navLocation, int n) {
    }

    default public int calculateDirectionIndexStartToEndLocation(PosPosition posPosition, NavLocation navLocation, int n, int n2) {
    }

    default public void resetNaviContext(String string) {
    }

    default public void resetNavigationModel() {
    }

    default public String splitTurnToInfoStreet(String string) {
    }

    default public long calculateDistanceFromCCPToFinalDest(RgInfoForNextDestination rgInfoForNextDestination, Route route, NavRouteListData[] navRouteListDataArray) {
    }

    default public int kmToMiles(int n) {
    }

    default public int milesToKm(int n) {
    }

    default public long getDistanceToRouteElement(NavPoiInfo navPoiInfo) {
    }

    default public long getDistanceToRouteElement(TmcMessage tmcMessage) {
    }

    default public long getDistanceToRouteElement(TurnListElement turnListElement) {
    }

    default public long getDistanceToRouteElement(long l, int n) {
    }

    default public long getDistanceToRouteIndex(int n) {
    }

    default public long getDistanceToRouteIndex(int n, RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, long l) {
    }

    default public long getNextStopDistance() {
    }

    default public long getNextStopDistance(RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, Route route) {
    }

    default public int getNextHardDestinationIndex() {
    }

    default public int getNextHardDestinationIndex(Route route) {
    }

    default public long getLastDestinationDistance() {
    }

    default public long getLastDestinationDistance(RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, Route route) {
    }

    default public long getRttToRouteElement(NavPoiInfo navPoiInfo) {
    }

    default public long getRttToRouteElement(TmcMessage tmcMessage) {
    }

    default public long getRttToRouteElement(TurnListElement turnListElement) {
    }

    default public long getRttToRouteElement(long l, int n) {
    }

    default public long getRttToNextStopOver(RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, Route route) {
    }

    default public long getRttToRouteIndex(int n) {
    }

    default public long getRttToRouteIndex(int n, RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, long l) {
    }

    default public int[] getRttHMToRouteElement(NavPoiInfo navPoiInfo) {
    }

    default public int[] getRttHMToRouteElement(TmcMessage tmcMessage) {
    }

    default public int[] getRttHMToRouteElement(TurnListElement turnListElement) {
    }

    default public int[] getRttHMToRouteElement(long l, int n) {
    }

    default public int[] getRttHMToRouteIndex(int n) {
    }

    default public int getItemIndex(long l, int n, int n2) {
    }

    default public int getCurrentNextRouteIndex(long l, int n) {
    }

    default public long getNextStopRtt() {
    }

    default public long getLastDestinationRtt() {
    }

    default public long getLastDestinationRtt(RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, Route route) {
    }

    default public long getDelayToFinalDest(RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray, Route route) {
    }

    default public int[] getEtaToRouteElement(NavPoiInfo navPoiInfo) {
    }

    default public int[] getEtaToRouteElement(TmcMessage tmcMessage) {
    }

    default public int[] getEtaToRouteElement(TurnListElement turnListElement) {
    }

    default public int[] getEtaToRouteIndex(int n) {
    }

    default public int[] getNextStopEta() {
    }

    default public int[] getLastDestinationEta() {
    }

    default public boolean isAlreadyPassed(TurnListElement turnListElement) {
    }

    default public boolean isAlreadyPassed(TmcMessage tmcMessage) {
    }

    default public boolean isAlreadyPassed(NavPoiInfo navPoiInfo) {
    }

    default public boolean isAlreadyPassed(int n, long l) {
    }

    default public int convertRTTHM2RTTM(int n, int n2) {
    }

    default public boolean isIntermediateDestInRoute(Route route) {
    }

    default public boolean isIntermediateDestInRoute() {
    }

    default public boolean isIntermediateDestInWholeRoute(Route route) {
    }

    default public Route copyRoute(Route route) {
    }
}

