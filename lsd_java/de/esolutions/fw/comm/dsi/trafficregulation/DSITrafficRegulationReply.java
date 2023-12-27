/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.trafficregulation;

import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public interface DSITrafficRegulationReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateCountrySpeedInformation(RoadClassSpeedInfo[] roadClassSpeedInfoArray, int n) {
    }

    default public void updateCurrentTrafficSign(TrafficSignInformation trafficSignInformation, int n) {
    }

    default public void updateTrafficSignOnRoute(TrafficSignInformationOnRoute[] trafficSignInformationOnRouteArray, int n) {
    }

    default public void requestRoadClassSpeedInfoForCountryResult(RoadClassSpeedInfo[] roadClassSpeedInfoArray, int n) {
    }

    default public void updateTrailerStatus(int n, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

