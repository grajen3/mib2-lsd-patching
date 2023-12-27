/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.AbstractImageModel;
import de.vw.mib.widgets.models.LaneGuidanceModel$1;

public interface LaneGuidanceModel
extends AbstractImageModel {
    public static final int PID_BASE;
    public static final int PID_LANE_DIRECTION;
    public static final int PID_LANE_IMAGES;
    public static final int PID_LANE_INFO;
    public static final int PID_LANE_MARKING_LEFT;
    public static final int PID_LANE_MARKING_IMAGES;
    public static final int PID_LANE_MARKING_RIGHT;
    public static final int PID_LANE_SEPARATOR_IMAGE;
    public static final int PID_NUMBER_OF_VISIBLE_LANES;
    public static final int PID_STEERING_WHEEL_SIDE;
    public static final int PID_COUNT_LANE_GUIDANCE;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_LANEGUIDANCE;
    public static final int LANE_INFO_NOT_RECOMMENDED;
    public static final int LANE_INFO_RECOMMENDED;
    public static final int LANE_INFO_BEST_RECOMMENDED;
    public static final int LANE_INFO_RESERVED;
    public static final int LANE_INFO_SHORTENED;
    public static final int LANE_000_ACTIVE;
    public static final int LANE_000_PASSIVE;
    public static final int LANE_045_ACTIVE;
    public static final int LANE_045_PASSIVE;
    public static final int LANE_090_ACTIVE;
    public static final int LANE_090_PASSIVE;
    public static final int LANE_135_ACTIVE;
    public static final int LANE_135_PASSIVE;
    public static final int LANE_225_ACTIVE;
    public static final int LANE_225_PASSIVE;
    public static final int LANE_270_ACTIVE;
    public static final int LANE_270_PASSIVE;
    public static final int LANE_315_ACTIVE;
    public static final int LANE_315_PASSIVE;
    public static final int LANE_EMPTY;
    public static final int LANE_180_CCW_ACTIVE;
    public static final int LANE_180_CCW_PASSIVE;
    public static final int LANE_180_CW_ACTIVE;
    public static final int LANE_180_CW_PASSIVE;
    public static final int LANE_ELLIPSIS;
    public static final int LANE_COUNT;
    public static final IntObjectMap LANE_DIRECTION_INFO_INDEX__MAPPING;
    public static final int LANE_MARIKING_NO;
    public static final int LANE_MARKING_SOLID;
    public static final int LANE_MARKING_DASHED;
    public static final int LANE_MARKING_RESERVED;
    public static final int MARKING_LEFT_CLOSE;
    public static final int MARKING_RIGHT_CLOSE;
    public static final int MARKING_LEFT_OPEN;
    public static final int MARKING_RIGHT_OPEN;
    public static final int MARKING_COUNT;
    public static final int STEERING_WHEEL_SIDE_LEFT;
    public static final int STEERING_WHEEL_SIDE_RIGHT;

    default public int[] get_laneDirection() {
    }

    default public void set_laneDirection(int[] nArray) {
    }

    default public Image[] get_laneImages() {
    }

    default public void set_laneImages(Image[] imageArray) {
    }

    default public int[] get_laneInfo() {
    }

    default public void set_laneInfo(int[] nArray) {
    }

    default public int[] get_laneMarkingLeft() {
    }

    default public void set_laneMarkingLeft(int[] nArray) {
    }

    default public int[] get_laneMarkingRight() {
    }

    default public void set_laneMarkingRight(int[] nArray) {
    }

    default public Image[] get_laneMarkingImages() {
    }

    default public void set_laneMarkingImages(Image[] imageArray) {
    }

    default public Image get_laneSeparatorImage() {
    }

    default public void set_laneSeparatorImage(Image image) {
    }

    default public int get_numberOfVisibleLanes() {
    }

    default public void set_numberOfVisibleLanes(int n) {
    }

    default public int get_steeringWheelSide() {
    }

    default public void set_steeringWheelSide(int n) {
    }

    static {
        LANE_DIRECTION_INFO_INDEX__MAPPING = new LaneGuidanceModel$1();
    }
}

