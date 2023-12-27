/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.BapManeuverDescriptor;
import org.dsi.ifc.navservicesapi.LDListElement;
import org.dsi.ifc.navservicesapi.NavLaneGuidanceData;
import org.dsi.ifc.navservicesapi.TrafficInfo;

public interface DSINavAsiaBAPClusterInstrumentListener
extends DSIListener {
    default public void updateCompassInfo(int n, int n2, int n3) {
    }

    default public void updateRGStatus(int n, int n2) {
    }

    default public void updateDistanceToNextManeuver(int n, int n2, boolean bl, int n3, int n4) {
    }

    default public void updateCurrentPositionInfo(String string, int n) {
    }

    default public void updateTurnToInfo(String string, String string2, int n) {
    }

    default public void updateDistanceToDestination(int n, int n2, int n3) {
    }

    default public void updateNavigationTimeInfoType(int n, int n2) {
    }

    default public void updateRTT(long l, int n) {
    }

    default public void updateETA(int n, long l, boolean bl, int n2) {
    }

    default public void updateCityName(String string, int n) {
    }

    default public void updateSemiDynRoute(boolean bl, int n) {
    }

    default public void updateTrafficOffset(int n, short s, short s2, short s3, boolean bl, int n2) {
    }

    default public void updateManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
    }

    default public void updateLaneGuidance(boolean bl, NavLaneGuidanceData[] navLaneGuidanceDataArray, int n) {
    }

    default public void updateTrafficInformation(TrafficInfo[] trafficInfoArray, int n, int n2) {
    }

    default public void updateDMLastDestinationsList(LDListElement[] lDListElementArray, int n) {
    }

    default public void dmLastDestinationsGetResult(int n, AddressData[] addressDataArray) {
    }

    default public void routeGuidanceActDeactResult(int n) {
    }

    default public void repeatLastNavAnnouncementResult(int n) {
    }

    default public void updateNavAnnouncementState(boolean bl, int n) {
    }

    default public void updateVoiceGuidanceState(int n, int n2) {
    }

    default public void updateInfoStates(int n, int n2) {
    }

    default public void setActiveRGTypeResult(int n) {
    }

    default public void updateTrafficBlockIndication(int n, int n2) {
    }
}

