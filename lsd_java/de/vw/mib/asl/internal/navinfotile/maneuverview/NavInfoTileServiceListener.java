/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.maneuverview;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListenerAdapter;
import de.vw.mib.asl.internal.navinfotile.maneuverview.NavInfoTileManeuverViewTarget;

public class NavInfoTileServiceListener
extends NavigationSplitscreenListenerAdapter {
    NavInfoTileManeuverViewTarget target;

    public NavInfoTileServiceListener(NavInfoTileManeuverViewTarget navInfoTileManeuverViewTarget) {
        this.target = navInfoTileManeuverViewTarget;
    }

    @Override
    public void updateRMLInformation(IManeuverViewElement[] iManeuverViewElementArray) {
        this.target.updateRMLInformation(iManeuverViewElementArray);
    }
}

