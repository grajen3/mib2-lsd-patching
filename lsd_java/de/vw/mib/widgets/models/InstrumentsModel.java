/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.models.InstrumentsModel$Interval;
import de.vw.mib.widgets.models.TransformContainerModel;

public interface InstrumentsModel
extends TransformContainerModel,
Adjustable {
    public static final int PID_BASE;
    public static final int PID_BACKGROUND_IMAGE;
    public static final int PID_BACKGROUND_COLOR;
    public static final int PID_FOREGROUND_IMAGE;
    public static final int PID_FOREGROUND_COLOR;
    public static final int PID_POINTER_IDX;
    public static final int PID_POINTER_IMAGES;
    public static final int PID_POINTER_COLORS;
    public static final int PID_SCALE_PARAMS;
    public static final int PID_SCALE_STROKE_ANGLES;
    public static final int PID_SCALE_STROKE_COLORS;
    public static final int PID_SCALE_STROKE_IMAGES;
    public static final int PID_SCALE_STROKE_TYPES;
    public static final int PID_SCALE_VALUES;
    public static final int PID_VALUE;
    public static final int PID_VALUE_MAX;
    public static final int PID_VALUE_MIN;
    public static final int PID_WARNING_ZONE_ANGLES;
    public static final int PID_WARNING_ZONE_IMAGE;
    public static final int PID_VALUE_OUT;
    public static final int PID_PERFORM_ENTER_ANIMATION;
    public static final int PID_HALO_ALPHAS;
    public static final int PID_MODE;
    public static final int PID_RADIUS_DRAWING_AREA;
    public static final int PID_VALUE_ANGLE;
    public static final int PID_COUNT_INSTRUMENTS;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_VALUE_CHANGE_ANIMATION;
    public static final int EASING_INDEX_POINTER_CHANGE_ANIMATION;
    public static final int EASING_INDEX_POINTER_ENTER_PHASE_1;
    public static final int EASING_INDEX_POINTER_ENTER_PHASE_2;
    public static final int EASING_INDEX_G_METER_ENTER_PHASE_1;
    public static final int EASING_INDEX_G_METER_ENTER_PHASE_2;
    public static final int EASING_INDEX_G_METER_ENTER_PHASE_3;
    public static final int EASING_INDEX_COUNT_INSTRUMENTS;
    public static final int SID_BASE;
    public static final int SID_INSTRUMENTS_SCALE_INVALID;
    public static final int SID_INSTRUMENTS_PERFORM_ENTER_ANIMATION;
    public static final int SID_COUNT_INSTRUMENTS;
    public static final int STROKE_SMALL;
    public static final int STROKE_MEDIUM;
    public static final int STROKE_LARGE;
    public static final int STROKE_COUNT;
    public static final int STROKE_COLOR_NORMAL;
    public static final int STROKE_COLOR_WARNING_ZONE;
    public static final int STROKE_COLOR_COUNT;
    public static final int WARNING_ZONE_ANGLE_ROTATE;
    public static final int WARNING_ZONE_ANGLE_CLIP;
    public static final int WARNING_ZONE_ANGLE_COUNT;
    public static final int MODE_ROTATING_POINTER;
    public static final int MODE_G_METER_IMAGE_MAPPING;
    public static final int MODE_G_METER_FREE_POSITION;

    default public Image get_backgroundImage() {
    }

    default public void set_backgroundImage(Image image) {
    }

    default public Color get_backgroundColor() {
    }

    default public void set_backgroundColor(Color color) {
    }

    default public Image get_foregroundImage() {
    }

    default public void set_foregroundImage(Image image) {
    }

    default public Color get_foregroundColor() {
    }

    default public void set_foregroundColor(Color color) {
    }

    default public boolean is_performEnterAnimation() {
    }

    default public void set_performEnterAnimation(boolean bl) {
    }

    default public int get_pointerIdx() {
    }

    default public void set_pointerIdx(int n) {
    }

    default public Image[] get_pointerImages() {
    }

    default public void set_pointerImages(Image[] imageArray) {
    }

    default public Color[] get_pointerColors() {
    }

    default public void set_pointerColors(Color[] colorArray) {
    }

    default public int[] get_scaleParams() {
    }

    default public void set_scaleParams(int[] nArray) {
    }

    default public int[] get_scaleStrokeAngles() {
    }

    default public void set_scaleStrokeAngles(int[] nArray) {
    }

    default public Color[] get_scaleStrokeColors() {
    }

    default public void set_scaleStrokeColors(Color[] colorArray) {
    }

    default public Image[] get_scaleStrokeImages() {
    }

    default public void set_scaleStrokeImages(Image[] imageArray) {
    }

    default public int[] get_scaleStrokeTypes() {
    }

    default public void set_scaleStrokeTypes(int[] nArray) {
    }

    default public int[] get_scaleValues() {
    }

    default public void set_scaleValues(int[] nArray) {
    }

    default public int get_value() {
    }

    default public void set_value(int n) {
    }

    default public int get_valueMax() {
    }

    default public void set_valueMax(int n) {
    }

    default public int get_valueMin() {
    }

    default public void set_valueMin(int n) {
    }

    default public int get_valueOut() {
    }

    default public void set_valueOut(int n) {
    }

    default public int[] get_warningZoneAngles() {
    }

    default public void set_warningZoneAngles(int[] nArray) {
    }

    default public Image get_warningZoneImage() {
    }

    default public void set_warningZoneImage(Image image) {
    }

    default public int[] get_haloAlphas() {
    }

    default public void set_haloAlphas(int[] nArray) {
    }

    default public int get_mode() {
    }

    default public void set_mode(int n) {
    }

    default public int get_radiusDrawingArea() {
    }

    default public void set_radiusDrawingArea(int n) {
    }

    default public int get_valueAngle() {
    }

    default public void set_valueAngle(int n) {
    }

    default public float getInternalAngle() {
    }

    default public InstrumentsModel$Interval getValueInterval(int n) {
    }

    default public InstrumentsModel$Interval getAngleInterval(int n) {
    }

    default public Image getScaleStrokeImage(int n) {
    }

    default public boolean isValueChangeAnimationRunning() {
    }

    default public void setScaleInvalid(boolean bl) {
    }

    default public boolean isScaleInvalid() {
    }

    default public boolean isEnterAnimationPhaseOneRunning() {
    }

    default public boolean areGMeterEnterAnimationsRunning() {
    }

    default public boolean isEnterAnimationFinished() {
    }

    default public int getHaloAdditionalParam() {
    }

    default public Point2f[] getHaloPositions() {
    }

    default public int[] getHaloAlphasInternal() {
    }
}

