/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListenerAdapter;
import de.vw.mib.asl.internal.navinfotile.NavInfoTileTarget;

class NavigationSplitscreenListener
extends NavigationSplitscreenListenerAdapter {
    private final NavInfoTileTarget target;

    NavigationSplitscreenListener(NavInfoTileTarget navInfoTileTarget) {
        this.target = navInfoTileTarget;
    }

    @Override
    public void updateCompassDegree(int n) {
        this.target.traceState("updateCompassDegree");
        this.target.notifierModel.updateCollectorCompassDataRotation(n);
    }

    @Override
    public void updateCompassStreet(String string) {
        this.target.traceState("updateCompassStreet");
        this.target.notifierModel.updateCollectorCompassDataStreet(string);
    }

    @Override
    public void updateLocationInfo(INavigationLocation iNavigationLocation) {
        this.target.traceState("updateLocationInfo");
        this.target.notifierModel.updateCollectorLocation(iNavigationLocation);
    }

    @Override
    public void updatePositionInfo(INavigationPosPosition iNavigationPosPosition) {
        this.target.traceState("updatePositionInfo");
        this.target.notifierModel.updateCollectorGPSViewer(iNavigationPosPosition);
    }

    @Override
    public void updateRMLInformation(IManeuverViewElement[] iManeuverViewElementArray) {
        this.target.traceState("updateRMLInformation");
    }
}

