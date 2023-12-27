/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import de.vw.mib.asl.api.navigation.IGuidanceInfo;
import de.vw.mib.asl.api.navigation.IGuidanceLaneGuidance;
import de.vw.mib.asl.api.navigation.IGuidanceVZAVZEIcons;
import de.vw.mib.asl.api.navigation.IPnavLikelyDestination;

public interface NavigationGuidanceListener {
    default public void calculateRouteResult(int[] nArray, int n, int[] nArray2) {
    }

    default public void calculateRouteResult(int[] nArray, int[] nArray2, int[] nArray3) {
    }

    default public void calculateRouteUpdate(int[] nArray, int[] nArray2, int[] nArray3) {
    }

    default public void startGuidanceCalculatedRouteResult(int n, int n2) {
    }

    default public void updateGuidanceState(int n, boolean bl) {
    }

    default public void updateGuidanceState(int n, int n2) {
    }

    default public void updateGuidanceErrorState(int n) {
    }

    default public void updateGuidanceInfo(IGuidanceInfo[] iGuidanceInfoArray) {
    }

    default public void updateWPMCurrentMode(int n) {
    }

    default public void updateWPMNumberOfFreePointsInMemory(int n) {
    }

    default public void updateWPMNumberOfMaxPointsInMemory(int n) {
    }

    default public void updateWPMDistanceToNextWaypoint(int n) {
    }

    default public void updateWPMNumberOfPointsForCurrentRecord(int n) {
    }

    default public void updateWPMIsRecordModeDestinationSet(boolean bl) {
    }

    default public void updateWPMInfoDirection(int n) {
    }

    default public void updateTriggerEventAudioMessageResult(int n) {
    }

    default public void updatePNavStatus(int n) {
    }

    default public void updatePNavIsEnabled(boolean bl) {
    }

    default public void updatePNavCombinedCalculationState(int n) {
    }

    default public void updatePNavSelectedDestination(IPnavLikelyDestination iPnavLikelyDestination) {
    }

    default public void updatePNavLikelyDestinations(IPnavLikelyDestination[] iPnavLikelyDestinationArray) {
    }

    default public void updateVZAVZEIcons(IGuidanceVZAVZEIcons[] iGuidanceVZAVZEIconsArray) {
    }

    default public void updateLaneGuidance(IGuidanceLaneGuidance[] iGuidanceLaneGuidanceArray) {
    }

    default public void updateSpeedCameraWarningIcon(boolean bl) {
    }

    default public void updateSatelliteSystem(int n) {
    }

    default public void updateSetupTrafficSignMode(int n) {
    }
}

