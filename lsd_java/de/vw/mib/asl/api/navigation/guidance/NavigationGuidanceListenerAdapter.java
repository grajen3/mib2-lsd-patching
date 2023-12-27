/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import de.vw.mib.asl.api.navigation.IGuidanceInfo;
import de.vw.mib.asl.api.navigation.IGuidanceLaneGuidance;
import de.vw.mib.asl.api.navigation.IGuidanceVZAVZEIcons;
import de.vw.mib.asl.api.navigation.IPnavLikelyDestination;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListener;

public class NavigationGuidanceListenerAdapter
implements NavigationGuidanceListener {
    @Override
    public void calculateRouteResult(int[] nArray, int n, int[] nArray2) {
    }

    @Override
    public void startGuidanceCalculatedRouteResult(int n, int n2) {
    }

    @Override
    public void updateGuidanceState(int n, boolean bl) {
    }

    @Override
    public void calculateRouteResult(int[] nArray, int[] nArray2, int[] nArray3) {
        this.calculateRouteResult(nArray, nArray2[0], nArray3);
    }

    @Override
    public void updateGuidanceState(int n, int n2) {
        this.updateGuidanceState(n2, false);
    }

    @Override
    public void calculateRouteUpdate(int[] nArray, int[] nArray2, int[] nArray3) {
        this.calculateRouteResult(nArray, nArray2, nArray3);
    }

    @Override
    public void updateGuidanceErrorState(int n) {
    }

    @Override
    public void updateGuidanceInfo(IGuidanceInfo[] iGuidanceInfoArray) {
    }

    @Override
    public void updateWPMCurrentMode(int n) {
    }

    @Override
    public void updateWPMNumberOfFreePointsInMemory(int n) {
    }

    @Override
    public void updateWPMNumberOfMaxPointsInMemory(int n) {
    }

    @Override
    public void updateWPMDistanceToNextWaypoint(int n) {
    }

    @Override
    public void updateWPMNumberOfPointsForCurrentRecord(int n) {
    }

    @Override
    public void updateWPMIsRecordModeDestinationSet(boolean bl) {
    }

    @Override
    public void updateWPMInfoDirection(int n) {
    }

    @Override
    public void updateTriggerEventAudioMessageResult(int n) {
    }

    @Override
    public void updatePNavStatus(int n) {
    }

    @Override
    public void updatePNavIsEnabled(boolean bl) {
    }

    @Override
    public void updatePNavCombinedCalculationState(int n) {
    }

    @Override
    public void updatePNavSelectedDestination(IPnavLikelyDestination iPnavLikelyDestination) {
    }

    @Override
    public void updatePNavLikelyDestinations(IPnavLikelyDestination[] iPnavLikelyDestinationArray) {
    }

    @Override
    public void updateVZAVZEIcons(IGuidanceVZAVZEIcons[] iGuidanceVZAVZEIconsArray) {
    }

    @Override
    public void updateLaneGuidance(IGuidanceLaneGuidance[] iGuidanceLaneGuidanceArray) {
    }

    @Override
    public void updateSpeedCameraWarningIcon(boolean bl) {
    }

    @Override
    public void updateSatelliteSystem(int n) {
    }

    @Override
    public void updateSetupTrafficSignMode(int n) {
    }
}

