/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.tenpluszero;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListenerAdapter;
import de.vw.mib.asl.internal.navinfotile.tenpluszero.NavInfoTile10Plus0Target;

public class NavInfoTileServiceListener
extends NavigationSplitscreenListenerAdapter {
    NavInfoTile10Plus0Target target;

    public NavInfoTileServiceListener(NavInfoTile10Plus0Target navInfoTile10Plus0Target) {
        this.target = navInfoTile10Plus0Target;
    }

    @Override
    public void updateRMLInformation(IManeuverViewElement[] iManeuverViewElementArray) {
        this.target.notifierModel.updateManeuverViewTenItemsData(iManeuverViewElementArray);
    }

    @Override
    public void updateCompassDegree(int n) {
    }

    @Override
    public void updateCompassStreet(String string) {
    }

    @Override
    public void updateLocationInfo(INavigationLocation iNavigationLocation) {
    }

    @Override
    public void updatePositionInfo(INavigationPosPosition iNavigationPosPosition) {
    }
}

