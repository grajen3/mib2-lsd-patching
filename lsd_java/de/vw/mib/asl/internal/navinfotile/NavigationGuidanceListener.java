/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile;

import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListenerAdapter;
import de.vw.mib.asl.internal.navinfotile.NavInfoTileTarget;

class NavigationGuidanceListener
extends NavigationGuidanceListenerAdapter {
    private final NavInfoTileTarget target;

    public NavigationGuidanceListener(NavInfoTileTarget navInfoTileTarget) {
        this.target = navInfoTileTarget;
    }

    @Override
    public void updateGuidanceState(int n, int n2) {
        this.target.updateGuidanceState(n, n2);
    }

    @Override
    public void updateWPMDistanceToNextWaypoint(int n) {
        this.target.notifierModel.notifyWayPointModeDistanceNextWPChanged(n);
    }

    @Override
    public void updateWPMInfoDirection(int n) {
        this.target.notifierModel.notifyWayPointModeInfoDirectionChanged(n);
    }

    @Override
    public void updateWPMIsRecordModeDestinationSet(boolean bl) {
        this.target.notifierModel.notifyWayPointModeRecordModeDestinationSet(bl);
    }

    @Override
    public void updateWPMNumberOfFreePointsInMemory(int n) {
        this.target.notifierModel.notifyWayPointModeNumberFreeWayPointsChanged(n);
    }

    @Override
    public void updateWPMNumberOfMaxPointsInMemory(int n) {
        this.target.notifierModel.notifyWayPointModeNumberMaxWayPointsChanged(n);
    }

    @Override
    public void updateWPMNumberOfPointsForCurrentRecord(int n) {
        this.target.notifierModel.notifyWayPointModeNumberAllWayPointsChanged(n);
    }

    public void updateExecutionMode(int n) {
        this.target.notifierModel.notifyExecutionMode(n);
    }

    @Override
    public void updateSatelliteSystem(int n) {
        this.target.notifierModel.notifySatelliteInfoChanged(n);
    }
}

