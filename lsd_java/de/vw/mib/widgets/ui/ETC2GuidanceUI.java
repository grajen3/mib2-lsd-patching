/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.LaneGuidanceModel;
import de.vw.mib.widgets.ui.LaneGuidanceUI;

public final class ETC2GuidanceUI
extends LaneGuidanceUI {
    private static final int[] LANE_INFO_TYPES_TO_TRIM = new int[]{1};

    @Override
    protected Image getLaneImage(LaneGuidanceModel laneGuidanceModel, int n, int n2) {
        if (laneGuidanceModel == null) {
            return null;
        }
        int n3 = -1;
        switch (n2) {
            case 0: {
                n3 = 0;
                break;
            }
            case 1: {
                n3 = 1;
                break;
            }
            case 2: {
                n3 = 2;
                break;
            }
        }
        Image[] imageArray = laneGuidanceModel.get_laneImages();
        if (n3 >= 0 && imageArray != null && n3 < imageArray.length) {
            return imageArray[n3];
        }
        return null;
    }

    @Override
    protected void trimVisibleLanes(LaneGuidanceModel laneGuidanceModel, int[] nArray) {
        this.trimVisibleLanes(laneGuidanceModel, nArray, LANE_INFO_TYPES_TO_TRIM, LANE_INFO_TYPES_TO_TRIM, 2);
    }
}

