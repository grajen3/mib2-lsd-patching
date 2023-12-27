/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.models.TouchAreaModel$ProximityDataStorage;
import de.vw.mib.widgets.models.TouchAreaModel$TouchDataStorage;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public interface TouchAreaModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_ABSOLUTE_COORDINATES;
    public static final int PID_ACCUMULATE_EVENTS;
    public static final int PID_VALUE_MIN_X;
    public static final int PID_VALUE_MAX_X;
    public static final int PID_VALUE_MIN_Y;
    public static final int PID_VALUE_MAX_Y;
    public static final int PID_SHOW_TOUCH_TRAJECTORIES;
    public static final int PID_TOUCH_TRAJECTORIES_COLOR;
    public static final int PID_TOUCH_TRAJECTORIES_LINE_WIDTH;
    public static final int PID_TOUCH_TRAJECTORIES_IMAGE;
    public static final int PID_AUDIBLE_FEEDBACK;
    public static final int PID_DRAG_DELTA_RELATIVE_TO_PRESS;
    public static final int PID_DRAG_THRESHOLD;
    public static final int PID_DRAG_THRESHOLD_MODE;
    public static final int PID_MODE;
    public static final int PID_DURATION;
    public static final int PID_TOUCH_FORWARDING_MODE;
    public static final int PID_COUNT_TOUCHAREA;
    public static final int SID_BASE;
    public static final int SID_ABSOLUTE_COORDINATES;
    public static final int SID_ACCUMULATE_EVENTS;
    public static final int SID_SHOW_TOUCH_TRAJECTORIES;
    public static final int SID_AUDIBLE_FEEDBACK;
    public static final int SID_DRAG_DELTA_RELATIVE_TO_PRESS;
    public static final int SID_STORE_TOUCH_DATA;
    public static final int SID_STORE_PROXIMITY_DATA;
    public static final int SID_COUNT_TOUCHAREA;
    public static final int DRAG_THRESHOLD_MODE_NON_DIRECTIONAL;
    public static final int DRAG_THRESHOLD_MODE_DIRECTIONAL;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_TOUCHAREA;
    public static final int MODE_NONE;
    public static final int MODE_LONGPRESS;
    public static final int TOUCH_FORWARDING_MODE_EXCLUSIVE;
    public static final int TOUCH_FORWARDING_MODE_ALWAYS;
    public static final int TOUCH_FORWARDING_MODE_NEVER;
    public static final int TOUCH_FORWARDING_MODE_CONCURRENT;

    default public boolean is_absoluteCoordinates() {
    }

    default public void set_absoluteCoordinates(boolean bl) {
    }

    default public boolean is_accumulateEvents() {
    }

    default public void set_accumulateEvents(boolean bl) {
    }

    default public boolean is_audibleFeedback() {
    }

    default public void set_audibleFeedback(boolean bl) {
    }

    default public int get_valueMinX() {
    }

    default public void set_valueMinX(int n) {
    }

    default public int get_valueMaxX() {
    }

    default public void set_valueMaxX(int n) {
    }

    default public int get_valueMinY() {
    }

    default public void set_valueMinY(int n) {
    }

    default public int get_valueMaxY() {
    }

    default public void set_valueMaxY(int n) {
    }

    default public boolean is_showTouchTrajectories() {
    }

    default public void set_showTouchTrajectories(boolean bl) {
    }

    default public Color get_touchTrajectoriesColor() {
    }

    default public void set_touchTrajectoriesColor(Color color) {
    }

    default public int get_touchTrajectoriesLineWidth() {
    }

    default public void set_touchTrajectoriesLineWidth(int n) {
    }

    default public Image get_touchTrajectoriesImage() {
    }

    default public void set_touchTrajectoriesImage(Image image) {
    }

    default public boolean is_dragDeltaRelativeToPress() {
    }

    default public void set_dragDeltaRelativeToPress(boolean bl) {
    }

    default public int get_dragThreshold() {
    }

    default public void set_dragThreshold(int n) {
    }

    default public int get_dragThresholdMode() {
    }

    default public void set_dragThresholdMode(int n) {
    }

    default public int get_mode() {
    }

    default public void set_mode(int n) {
    }

    default public int get_touchForwardingMode() {
    }

    default public void set_touchForwardingMode(int n) {
    }

    default public int get_duration() {
    }

    default public void set_duration(int n) {
    }

    default public boolean isNormalizeXValues() {
    }

    default public int normalizeXValue(int n) {
    }

    default public int normalizeDeltaXValue(int n, boolean bl) {
    }

    default public boolean isNormalizeYValues() {
    }

    default public int normalizeYValue(int n) {
    }

    default public int normalizeDeltaYValue(int n, boolean bl) {
    }

    default public void startTouchTrajectory() {
    }

    default public void finishTouchTrajectory() {
    }

    default public void addTouchTrajectoryKnot(Point2f point2f) {
    }

    default public void clearTouchTrajectories() {
    }

    default public List getTouchTrajectories() {
    }

    default public boolean isRebuildAllTouchTrajectory() {
    }

    default public void setRebuildTouchTrajectory(boolean bl) {
    }

    default public TouchAreaModel$TouchDataStorage getTouchDataStorage() {
    }

    default public boolean isStoreTouchData() {
    }

    default public void setStoreTouchData(boolean bl) {
    }

    default public TouchAreaModel$ProximityDataStorage getProximityDataStorage() {
    }

    default public boolean isStoreProximityData() {
    }

    default public void setStoreProximityData(boolean bl) {
    }
}

