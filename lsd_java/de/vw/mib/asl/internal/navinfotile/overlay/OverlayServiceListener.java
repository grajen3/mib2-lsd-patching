/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.overlay;

import de.vw.mib.asl.api.navigation.IOverlayData;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListenerAdapter;
import de.vw.mib.asl.internal.navinfotile.overlay.NavInfoTileOverlayTarget;

public class OverlayServiceListener
extends NavigationSplitscreenListenerAdapter {
    NavInfoTileOverlayTarget target;

    public OverlayServiceListener(NavInfoTileOverlayTarget navInfoTileOverlayTarget) {
        this.target = navInfoTileOverlayTarget;
    }

    @Override
    public void updateOverlayCurrentContent(int n) {
        this.target.traceState("updateOverlayCurrentContent");
        this.target.notifierModel.updateOverlayCurrentContent(n);
    }

    @Override
    public void updateOverlayCount(int n) {
        this.target.traceState("updateOverlayCount");
        this.target.notifierModel.updateOverlayCount(n);
    }

    @Override
    public void updateOverlayIndex(int n) {
        this.target.traceState("updateOverlayIndex");
        this.target.notifierModel.updateOverlayIndex(n);
    }

    @Override
    public void updateOverlayData(IOverlayData iOverlayData) {
        this.target.traceState("updateOverlayData");
        this.target.notifierModel.updateOverlayData(iOverlayData);
    }
}

