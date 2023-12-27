/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.trafficregulation;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public interface DSITrafficRegulationListener
extends DSIListener {
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
}

