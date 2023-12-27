/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.LaneGuidanceModel;
import de.vw.mib.widgets.ui.LaneGuidanceUI;

public final class CustomImageLaneGuidanceUI
extends LaneGuidanceUI {
    private static final int[] LANE_INFO_TYPES_TO_TRIM = new int[0];

    @Override
    protected Image getLaneImage(LaneGuidanceModel laneGuidanceModel, int n, int n2) {
        Image[] imageArray = laneGuidanceModel.get_laneImages();
        if (n2 >= 0 && imageArray != null && n2 < imageArray.length) {
            return imageArray[n2];
        }
        return null;
    }

    @Override
    protected void trimVisibleLanes(LaneGuidanceModel laneGuidanceModel, int[] nArray) {
        this.trimVisibleLanes(laneGuidanceModel, nArray, LANE_INFO_TYPES_TO_TRIM, LANE_INFO_TYPES_TO_TRIM, 0);
    }
}

