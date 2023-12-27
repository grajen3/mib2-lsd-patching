/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.framework.api.displaymanagement.displayable.DisplayableServiceAdapter;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchStateInit;

class MapViewerMapSwitchStateInit$1
extends DisplayableServiceAdapter {
    private final /* synthetic */ MapViewerMapSwitchStateInit this$0;

    MapViewerMapSwitchStateInit$1(MapViewerMapSwitchStateInit mapViewerMapSwitchStateInit) {
        this.this$0 = mapViewerMapSwitchStateInit;
    }

    @Override
    public void onDisplayableShown(int n) {
        MapViewerMapSwitchStateInit.access$000(this.this$0).makeTrace().append("onDisplayableShown(displayable = ").append(n).append(")").log();
        if (n == 3 && MapViewerMapSwitchStateInit.access$100((MapViewerMapSwitchStateInit)this.this$0).datapool.isMapFPKSwitchRunning()) {
            MapViewerMapSwitchStateInit.access$000(this.this$0).trace("Displayable Map is shown");
            MapViewerMapSwitchStateInit.access$100((MapViewerMapSwitchStateInit)this.this$0).datapool.setMainMapLocatedInAbt(true);
            MapViewerMapSwitchStateInit.access$100((MapViewerMapSwitchStateInit)this.this$0).datapool.setMapVisibilityForFPKSwitch(true);
            MapViewerMapSwitchStateInit.access$100((MapViewerMapSwitchStateInit)this.this$0).notifierDSI.touchApproach(MapViewerMapSwitchStateInit.access$100((MapViewerMapSwitchStateInit)this.this$0).datapool.isTouchApproximated());
            ASLNavigationMapFactory.getNavigationMapApi().sendEvKombiMapDisplayableMapShown();
        }
    }

    @Override
    public void onDisplayableHidden(int n) {
        MapViewerMapSwitchStateInit.access$000(this.this$0).makeTrace().append("onDisplayableHidden(displayable = ").append(n).append(")").log();
        if (n == 3 && MapViewerMapSwitchStateInit.access$100((MapViewerMapSwitchStateInit)this.this$0).datapool.isMapFPKSwitchRunning()) {
            MapViewerMapSwitchStateInit.access$000(this.this$0).trace("Displayable Map is hidden");
            MapViewerMapSwitchStateInit.access$100((MapViewerMapSwitchStateInit)this.this$0).datapool.setMainMapLocatedInAbt(false);
            MapViewerMapSwitchStateInit.access$100((MapViewerMapSwitchStateInit)this.this$0).datapool.setMapVisibilityForFPKSwitch(false);
            MapViewerMapSwitchStateInit.access$100((MapViewerMapSwitchStateInit)this.this$0).notifierDSI.touchApproach(false);
            ASLNavigationMapFactory.getNavigationMapApi().sendEvKombiMapDisplayableMapHidden();
        }
    }
}

