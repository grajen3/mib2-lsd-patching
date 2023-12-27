/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Point;
import de.vw.mib.widgets.models.TemplateListModel;

public interface FlowListModel
extends TemplateListModel {
    public static final int PREFETCH_ITEM_COUNT = Integer.parseInt(System.getProperty("de.vw.mib.widgets.FlowList.prefetchCount", "5"));
    public static final int PID_BASE;
    public static final int PID_OUTLINE;
    public static final int PID_OUTLINE_EFFECT;
    public static final int PID_OUTLINE_POINT_X;
    public static final int PID_OUTLINE_POINT_Y;
    public static final int PID_OUTLINE_ROTATION_Y;
    public static final int PID_OUTLINE_CENTER_POSITION;
    public static final int PID_OUTLINE_OFFSET;
    public static final int PID_OUTLINE_ACCELERATION;
    public static final int PID_OUTLINE_DEBOUNCE;
    public static final int PID_OUTLINE_SNAP_TO_GRID;
    public static final int PID_OUTLINE_SCROLL_SHORTCUT_SIZE;
    public static final int PID_OUTLINE_SCROLLING_DIRECTION;
    public static final int PID_RADIUS;
    public static final int PID_DISTANCE;
    public static final int PID_ELEVATION_ANGLE;
    public static final int PID_SCROLLING_SPEED;
    public static final int PID_VISIBLE_ITEM_COUNT;
    public static final int PID_ABS_SELECTED_INDEX;
    public static final int PID_COUNT_FLOW_LIST;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_SCROLLING_ANIMATION;
    public static final int EASING_INDEX_OUTLINE_CHANGE_ANIMATION;
    public static final int EASING_INDEX_OUTLINE_EFFECT_CHANGE_ANIMATION;
    public static final int EASING_INDEX_ELEVATION_ANGLE_ANIMATION;
    public static final int EASING_INDEX_RADIUS_ANIMATION;
    public static final int EASING_INDEX_DISTANCE_ANIMATION;
    public static final int EASING_INDEX_COUNT_FLOW_LIST;
    public static final int SID_BASE;
    public static final int SID_COUNT_FLOW_LIST;
    public static final int OUTLINE_CARROUSEL;
    public static final int OUTLINE_PARABOLA;
    public static final int OUTLINE_COVER_FLOW;
    public static final int OUTLINE_LINEAR;
    public static final int OUTLINE_CUSTOM;
    public static final int OUTLINE_COVER_FLOW_ACTIVE_DISPLACED;
    public static final int OUTLINE_COVER_FLOW_ACTIVE_DISPLACED_9_2;
    public static final int OUTLINE_COVER_STACK_STAGGERED;
    public static final int OUTLINE_COVER_STACK;
    public static final int OUTLINE_VERTICAL;
    public static final int OUTLINE_VERTICAL_LEFT;
    public static final int OUTLINE_VERTICAL_RIGHT;
    public static final int OUTLINE_COVER_FLOW_SEAT;
    public static final int OUTLINE_COVER_STACK_SEAT;
    public static final int OUTLINE_COVER_STACK_APPROXIMATED_SEAT;
    public static final int OUTLINEEFFECT_NONE;
    public static final int OUTLINEEFFECT_ALPHA_QUINTIC_PEAK_CENTERED;
    public static final int OUTLINEEFFECT_ALPHA_QUINTIC_BUMP_CENTERED;
    public static final int OUTLINEEFFECT_ALPHA_COVER_FLOW;
    public static final int OUTLINEEFFECT_ALPHA_COVER_FLOW_VW;
    public static final int OUTLINEEFFECT_ALPHA_COVER_STACK_VW;
    public static final int OUTLINEEFFECT_ALPHA_COVER_STACK_VW_INTERACTIVE;
    public static final int OUTLINEEFFECT_ALPHA_LINEAR_PEAK_START;
    public static final int OUTLINEEFFECT_ALPHA_CUBIC_PEAK_CENTERED;
    public static final int OUTLINEEFFECT_ALPHA_COVER_FLOW_SEAT;
    public static final int OUTLINEEFFECT_ALPHA_MAIN_MENU_SEAT;
    public static final int OUTLINEEFFECT_ALPHA_FADE_TRAVELLINK_VW;
    public static final int SCROLLING_DIRECTION_OUTLINE;
    public static final int SCROLLING_DIRECTION_HORIZONTAL;
    public static final int SCROLLING_DIRECTION_VERTICAL;
    public static final int SNAP_DIRECTION_SHORTEST;
    public static final int SNAP_DIRECTION_LEFT;
    public static final int SNAP_DIRECTION_RIGHT;
    public static final float DRAG_PRECISION;

    default public int get_radius() {
    }

    default public void set_radius(int n) {
    }

    default public int get_distance() {
    }

    default public void set_distance(int n) {
    }

    default public int get_elevationAngle() {
    }

    default public void set_elevationAngle(int n) {
    }

    default public void set_visibleItemCount(int n) {
    }

    default public int get_visibleItemCount() {
    }

    default public void set_outline(int n) {
    }

    default public int get_outline() {
    }

    default public void set_outlineEffect(int n) {
    }

    default public int get_outlineEffect() {
    }

    default public void set_outlinePointX(float[] fArray) {
    }

    default public float[] get_outlinePointX() {
    }

    default public void set_outlinePointY(float[] fArray) {
    }

    default public float[] get_outlinePointY() {
    }

    default public void set_outlineRotationY(float[] fArray) {
    }

    default public float[] get_outlineRotationY() {
    }

    default public void set_outlineCenterPosition(float f2) {
    }

    default public float get_outlineCenterPosition() {
    }

    default public void set_outlineOffset(float f2) {
    }

    default public float get_outlineOffset() {
    }

    default public void set_outlineAcceleration(float f2) {
    }

    default public float get_outlineAcceleration() {
    }

    default public void set_outlineDebounce(float f2) {
    }

    default public float get_outlineDebounce() {
    }

    default public void set_outlineSnapToGrid(boolean bl) {
    }

    default public boolean is_outlineSnapToGrid() {
    }

    default public void set_outlineScrollShortcutSize(int n) {
    }

    default public int get_outlineScrollShortcutSize() {
    }

    default public void set_outlineScrollingDirection(int n) {
    }

    default public int get_outlineScrollingDirection() {
    }

    default public int get_absSelectedIndex() {
    }

    default public void set_absSelectedIndex(int n) {
    }

    default public boolean isSelectedItemInFront() {
    }

    default public int getEnabledItemCount() {
    }

    default public int getTargetSelectedIndex() {
    }

    default public void setTargetSelectedIndex(int n, int n2) {
    }

    default public int getVisibleItemCount() {
    }

    default public int getMaxVisibleItemCount() {
    }

    default public float getFlowPositionByScreenCoordinates(int n, int n2) {
    }

    default public boolean isSnapAnimationActive() {
    }

    default public void stopSnapAnimation() {
    }

    default public boolean isDragActive() {
    }

    default public Point[] getOutlineScreenCoordinates() {
    }

    default public void updateEffectWidgetAlpha(int n) {
    }

    default public int getChildIndex(int n) {
    }

    default public int getRealIndex(int n) {
    }

    default public int getVisIndex(int n) {
    }

    default public int getItemX(int n) {
    }

    default public int getItemY(int n) {
    }

    default public int getItemAlpha(int n) {
    }

    default public int getItemRotation(int n) {
    }

    default public int getItemZ(int n) {
    }

    default public int getAbsIndexByEnabledIndex(int n) {
    }

    default public int getEnabledIndexByAbsIndex(int n) {
    }

    default public float getDragAcceleration() {
    }

    default public float getDebounceValue() {
    }
}

