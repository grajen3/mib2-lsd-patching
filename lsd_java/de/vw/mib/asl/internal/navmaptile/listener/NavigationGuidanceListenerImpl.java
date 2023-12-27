/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile.listener;

import de.vw.mib.asl.api.navigation.IGuidanceLaneGuidance;
import de.vw.mib.asl.api.navigation.IGuidanceVZAVZEIcons;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListenerAdapter;
import de.vw.mib.asl.internal.navmaptile.NavMapTileTargetHSM;

public class NavigationGuidanceListenerImpl
extends NavigationGuidanceListenerAdapter {
    private final NavMapTileTargetHSM target;

    public NavigationGuidanceListenerImpl(NavMapTileTargetHSM navMapTileTargetHSM) {
        this.target = navMapTileTargetHSM;
    }

    @Override
    public void updateGuidanceState(int n, int n2) {
        this.target.updateGuidanceState(n, n2);
    }

    @Override
    public void updateSetupTrafficSignMode(int n) {
        this.target.notifySetupTrafficSignMode(n);
    }

    @Override
    public void updateLaneGuidance(IGuidanceLaneGuidance[] iGuidanceLaneGuidanceArray) {
        this.target.updateCollectorLaneGuidance(iGuidanceLaneGuidanceArray);
    }

    @Override
    public void updateSpeedCameraWarningIcon(boolean bl) {
        this.target.notifySpeedCameraWarning(bl);
    }

    @Override
    public void updateVZAVZEIcons(IGuidanceVZAVZEIcons[] iGuidanceVZAVZEIconsArray) {
        this.target.updateCollectorVZAVZEIcons(iGuidanceVZAVZEIconsArray);
    }
}

