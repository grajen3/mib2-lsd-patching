/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.ContainerModel;

public interface IrisModel
extends ContainerModel {
    public static final int PID_BASE;
    public static final int PID_ACCELERATION;
    public static final int PID_ACCELERATOR_IMAGES;
    public static final int PID_ACTIVE_SEGMENT;
    public static final int PID_ENTER_ANIMATION_PROGRESS;
    public static final int PID_INDICATOR_IMAGES;
    public static final int PID_INDICATOR_GLOW_OFFSET;
    public static final int PID_IRIS_BACKGROUND_IMAGE;
    public static final int PID_IRIS_COLORS;
    public static final int PID_IRIS_RADIUSES;
    public static final int PID_IRIS_RADII;
    public static final int PID_MAX_ACCELERATION;
    public static final int PID_MAX_ACCELERATION_ROTATION;
    public static final int PID_SEGMENTS_VALUE_MAX;
    public static final int PID_SEGMENTS_VALUE_MIN;
    public static final int PID_VALUES;
    public static final int PID_IRIS_SEGMENTS_IMAGES;
    public static final int PID_COUNT_IRIS;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_CHANGE_ACCELERATION;
    public static final int EASING_INDEX_CHANGE_ACTIVE_SEGMENT_PART_ONE;
    public static final int EASING_INDEX_CHANGE_ACTIVE_SEGMENT_PART_TWO;
    public static final int EASING_INDEX_GLOW;
    public static final int EASING_INDEX_COUNT_IRIS;
    public static final int SID_BASE;
    public static final int SID_IRIS_SEGMENTS_INVALID;
    public static final int SID_IRIS_ACTIVE_SEGMENT_INVALID;
    public static final int SID_COUNT_IRIS;
    public static final int COLOR_IDX_START_SEGMENT;
    public static final int COLOR_IDX_END_SEGMENT;
    public static final int COLOR_IDX_START_INDICATOR_IDEAL;
    public static final int COLOR_IDX_END_INDICATOR_IDEAL;
    public static final int COLOR_IDX_START_INDICATOR_WORST;
    public static final int COLOR_IDX_END_INDICATOR_WORST;
    public static final int COLOR_IDX_ACTIVE_SEGMENT;
    public static final int COLOR_IDX_ACTIVE_SEGMENT_PRECURSOR_ONE;
    public static final int COLOR_IDX_ACTIVE_SEGMENT_PRECURSOR_TWO;
    public static final int COLOR_IDX_ACTIVE_SEGMENT_PRECURSOR_THREE;
    public static final int COLOR_COUNT;
    public static final int COLOR_COUNT_REDUCED;
    public static final int ACCELERATOR_IMAGE_LEFT;
    public static final int ACCELERATOR_IMAGE_RIGHT;
    public static final int ACCELERATOR_IMAGE_COUNT;
    public static final int RADIUS_INNER;
    public static final int RADIUS_OUTER;
    public static final int RADIUS_COUNT;
    public static final int CURSOR_INACTIVE;

    default public int get_acceleration() {
    }

    default public void set_acceleration(int n) {
    }

    default public Image[] get_acceleratorImages() {
    }

    default public void set_acceleratorImages(Image[] imageArray) {
    }

    default public int get_activeSegment() {
    }

    default public void set_activeSegment(int n) {
    }

    default public float get_enterAnimationProgress() {
    }

    default public void set_enterAnimationProgress(float f2) {
    }

    default public Image[] get_indicatorImages() {
    }

    default public void set_indicatorImages(Image[] imageArray) {
    }

    default public int get_indicatorGlowOffset() {
    }

    default public void set_indicatorGlowOffset(int n) {
    }

    default public Image get_irisBackgroundImage() {
    }

    default public void set_irisBackgroundImage(Image image) {
    }

    default public Image[] get_irisSegmentsImages() {
    }

    default public void set_irisSegmentsImages(Image[] imageArray) {
    }

    default public int get_maxAcceleration() {
    }

    default public void set_maxAcceleration(int n) {
    }

    default public int get_maxAccelerationRotation() {
    }

    default public void set_maxAccelerationRotation(int n) {
    }

    default public Color[] get_irisColors() {
    }

    default public void set_irisColors(Color[] colorArray) {
    }

    default public int[] get_irisRadiuses() {
    }

    default public void set_irisRadiuses(int[] nArray) {
    }

    default public int[] get_irisRadii() {
    }

    default public void set_irisRadii(int[] nArray) {
    }

    default public int get_segmentsValueMax() {
    }

    default public void set_segmentsValueMax(int n) {
    }

    default public int get_segmentsValueMin() {
    }

    default public void set_segmentsValueMin(int n) {
    }

    default public int[] get_values() {
    }

    default public void set_values(int[] nArray) {
    }

    default public Color4f getStartColorSegment() {
    }

    default public Color4f getEndColorSegment() {
    }

    default public Color4f getStartColorActiveSegment() {
    }

    default public Color4f getStartColorIndicator() {
    }

    default public Color4f getEndColorIndicator() {
    }

    default public int getActiveSegmentChecked() {
    }

    default public float getSpanAngleForOneSegment() {
    }

    default public void setIrisSegmentsInvalid(boolean bl) {
    }

    default public boolean areIrisSegmentsInvalid() {
    }

    default public void setActiveSegmentInvalid(boolean bl) {
    }

    default public boolean isActiveSegmentInvalid() {
    }

    default public float getScaledActiveSegmentSize() {
    }

    default public float getGlowAlpha() {
    }

    default public void setGlowAlpha(float f2) {
    }

    default public float getGlowAngle() {
    }

    default public void setGlowAngle(float f2) {
    }

    default public float getGlowSize() {
    }

    default public void setGlowSize(float f2) {
    }

    default public boolean getGlowVisible() {
    }

    default public void setGlowVisible(boolean bl) {
    }

    default public float[] getScaledValues() {
    }

    default public boolean isEnterAnimationRunning() {
    }

    default public float getSegmentsRotation() {
    }

    default public float getIndicatorRotation() {
    }
}

