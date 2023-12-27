/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl;

import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDistanceToDestination;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDistanceToNextManeuver;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoEstimatedRemainingTripTime;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoEstimatedTimeOfArrival;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoTurnToInfo;

public interface NavInfoService {
    default public String getCityName() {
    }

    default public String getCurrentStreet() {
    }

    default public NavInfoDistanceToDestination getDistanceToDestination() {
    }

    default public NavInfoDistanceToNextManeuver getDistanceToNextMananeuver() {
    }

    default public NavInfoEstimatedRemainingTripTime getEstimatedRemainingTripTime() {
    }

    default public NavInfoEstimatedTimeOfArrival getEstimatedTimeArrival() {
    }

    default public int getRouteGuidanceMode() {
    }

    default public NavInfoTurnToInfo getTurnToInfo() {
    }
}

