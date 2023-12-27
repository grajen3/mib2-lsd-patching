/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StartGuidanceToListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StopGuidanceListener;

public interface GuidanceService {
    default public void startGuidanceTo(StartGuidanceToListener startGuidanceToListener, INavigationLocation iNavigationLocation) {
    }

    default public void addNextStopOver(StartGuidanceToListener startGuidanceToListener, INavigationLocation iNavigationLocation) {
    }

    default public void removeNextStopOver(StartGuidanceToListener startGuidanceToListener) {
    }

    default public void stopGuidance(StopGuidanceListener stopGuidanceListener) {
    }

    default public void stopSilentGuidance(StopGuidanceListener stopGuidanceListener) {
    }

    default public void stopRouteCalculation(StopGuidanceListener stopGuidanceListener) {
    }

    default public void stopWayPointMode(StopGuidanceListener stopGuidanceListener) {
    }

    default public int getRouteCalculationStatus() {
    }

    default public int getGuidanceStatus() {
    }

    default public int getSilentGuidanceStatus() {
    }

    default public int getWayPointModeStatus() {
    }

    default public boolean isGuidanceActive() {
    }

    default public boolean isStopoverDefined() {
    }

    default public boolean canAddStopover() {
    }

    default public void release() {
    }
}

