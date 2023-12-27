/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import de.vw.mib.asl.api.navigation.IGuidanceLaneGuidance;

public class ASLGuidanceLaneGuidance
implements IGuidanceLaneGuidance {
    private int[] lane_guidance_direction = new int[]{0};
    private int[] lane_guidance_lane_marking_left = new int[]{0};
    private int[] lane_guidance_lane_marking_right = new int[]{0};
    private int[] lane_guidance_info = new int[]{0};
    private boolean lane_guidance_is_data_valid = false;

    public void setLGDirection(int[] nArray) {
        this.lane_guidance_direction = nArray;
    }

    @Override
    public int[] getLGDirection() {
        return this.lane_guidance_direction;
    }

    public void setLGMarkingLeft(int[] nArray) {
        this.lane_guidance_lane_marking_left = nArray;
    }

    @Override
    public int[] getLGMarkingLeft() {
        return this.lane_guidance_lane_marking_left;
    }

    public void setLGMarkingRight(int[] nArray) {
        this.lane_guidance_lane_marking_right = nArray;
    }

    @Override
    public int[] getLGMarkingRight() {
        return this.lane_guidance_lane_marking_right;
    }

    public void setLGInfo(int[] nArray) {
        this.lane_guidance_info = nArray;
    }

    @Override
    public int[] getLGInfo() {
        return this.lane_guidance_info;
    }

    public void setLGisDataValid(boolean bl) {
        this.lane_guidance_is_data_valid = bl;
    }

    @Override
    public boolean getLGisDataValid() {
        return this.lane_guidance_is_data_valid;
    }
}

