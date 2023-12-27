/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.interfaces.Draggable;
import de.vw.mib.widgets.models.DynamicImageModel;

public interface PictureViewerModel
extends DynamicImageModel,
Draggable {
    public static final int PID_BASE;
    public static final int PID_ZOOM;
    public static final int PID_ZOOM_INITIAL;
    public static final int PID_ZOOM_MIN;
    public static final int PID_ZOOM_MAX;
    public static final int PID_ZOOM_STEP;
    public static final int PID_ROTATION_ANGLE;
    public static final int PID_TRANSITION_PREV_IMAGE_IN;
    public static final int PID_TRANSITION_PREV_IMAGE_OUT;
    public static final int PID_SLIDE_SHOW_ENABLED;
    public static final int PID_SLIDE_SHOW_DELAY;
    public static final int PID_COUNT_PICTURE_VIEWER;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_ROTATION_ANIMATION;
    public static final int EASING_INDEX_ZOOM_ANIMATION;
    public static final int EASING_INDEX_DRAG_ANIMATION;
    public static final int EASING_INDEX_RETURN_ANIMATION;
    public static final int EASING_INDEX_SNAP_ANIMATION;
    public static final int EASING_INDEX_COUNT_PICTURE_VIEWER;
    public static final int SID_BASE;
    public static final int SID_SLIDESHOW_ENABLED;
    public static final int SID_LOADING_ACTIVE;
    public static final int SID_COUNT_PICTURE_VIEWER;
    public static final int FLICK_NEXT;
    public static final int FLICK_PREV;
    public static final int FLICK_MODE_COUNT;
    public static final int ROTATION_STEP;

    default public void set_zoom(int n) {
    }

    default public int get_zoom() {
    }

    default public void set_zoomInitial(int n) {
    }

    default public int get_zoomInitial() {
    }

    default public void set_zoomMax(int n) {
    }

    default public int get_zoomMax() {
    }

    default public void set_zoomMin(int n) {
    }

    default public int get_zoomMin() {
    }

    default public void set_zoomStep(int n) {
    }

    default public int get_zoomStep() {
    }

    default public void set_rotationAngle(int n) {
    }

    default public void set_transitionPrevImageIn(int n) {
    }

    default public int get_transitionPrevImageIn() {
    }

    default public int get_transitionPrevImageOut() {
    }

    default public void set_transitionPrevImageOut(int n) {
    }

    default public int get_rotationAngle() {
    }

    default public void set_slideShowEnabled(boolean bl) {
    }

    default public boolean is_slideShowEnabled() {
    }

    default public void set_slideShowDelay(int n) {
    }

    default public int get_slideShowDelay() {
    }

    default public void setPrefetchCount(int n) {
    }

    default public void increaseZoom() {
    }

    default public void decreaseZoom() {
    }

    default public void resetZoom() {
    }

    default public void rotateClockwise() {
    }

    default public void rotateCounterClockwise() {
    }

    default public boolean updateZoom(float f2, int n, int n2, boolean bl) {
    }

    default public boolean isGestureFlickEnabled() {
    }

    default public boolean isInteractionAllowed() {
    }

    default public void setFlickDirection(int n) {
    }

    default public int getFlickDirection() {
    }

    default public void stopSnappingAnimation() {
    }

    default public boolean isImageCurrentlyLoading() {
    }
}

