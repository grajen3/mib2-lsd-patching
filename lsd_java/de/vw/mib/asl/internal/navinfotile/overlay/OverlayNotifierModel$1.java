/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.overlay;

import de.vw.mib.asl.api.navigation.IOverlayData;
import de.vw.mib.asl.internal.navinfotile.overlay.OverlayNotifierModel;
import generated.de.vw.mib.asl.internal.navinfotile.overlay.ASLNavInfoTileOverlayPropertyManager;
import org.dsi.ifc.global.ResourceLocator;

class OverlayNotifierModel$1
implements IOverlayData {
    private final /* synthetic */ OverlayNotifierModel this$0;

    OverlayNotifierModel$1(OverlayNotifierModel overlayNotifierModel) {
        this.this$0 = overlayNotifierModel;
    }

    @Override
    public String getSignPostInfo() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getLaneNumber() {
        return 0;
    }

    @Override
    public int[] getLaneMarkingsRight() {
        return ASLNavInfoTileOverlayPropertyManager.OVERLAY_DATA_LANE_MARKINGS_RIGHT__DEFAULT_VALUE;
    }

    @Override
    public int[] getLaneMarkingsLeft() {
        return ASLNavInfoTileOverlayPropertyManager.OVERLAY_DATA_LANE_MARKINGS_LEFT__DEFAULT_VALUE;
    }

    @Override
    public int[] getLaneInfos() {
        return ASLNavInfoTileOverlayPropertyManager.OVERLAY_DATA_LANE_INFOS__DEFAULT_VALUE;
    }

    @Override
    public boolean getLaneGuidanceAvailable() {
        return false;
    }

    @Override
    public int[] getLaneDirections() {
        return ASLNavInfoTileOverlayPropertyManager.OVERLAY_DATA_LANE_DIRECTIONS__DEFAULT_VALUE;
    }

    @Override
    public boolean getHeadlineIconVisibility() {
        return false;
    }

    @Override
    public ResourceLocator getHeadlineIcon() {
        return ASLNavInfoTileOverlayPropertyManager.OVERLAY_DATA_HEADLINE_ICON__DEFAULT_VALUE;
    }

    @Override
    public boolean getExitNumberVisibility() {
        return false;
    }

    @Override
    public String getExitNumber() {
        return "";
    }

    @Override
    public int getDistanceToManeuver() {
        return 0;
    }

    @Override
    public ResourceLocator getColorIndicatorIcon() {
        return ASLNavInfoTileOverlayPropertyManager.OVERLAY_DATA_COLOR_INDICATOR_ICON__DEFAULT_VALUE;
    }
}

