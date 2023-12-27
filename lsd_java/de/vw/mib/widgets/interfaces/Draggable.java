/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.interfaces.Draggable$DragDataStorage;

public interface Draggable {
    public static final int SNAP_DIRECTION_NONE;
    public static final int SNAP_DIRECTION_FORWARD;
    public static final int SNAP_DIRECTION_BACKWARD;

    default public void getVisualAreaBounds(Rectangle rectangle) {
    }

    default public void getViewPort(Rectangle rectangle) {
    }

    default public Draggable$DragDataStorage getDragDataStorage() {
    }

    default public boolean adaptSnapPosition(Point point, int n) {
    }

    default public void startSnapAnimation(int n, int n2, EasingParams easingParams) {
    }

    default public void setViewportPosition(int n, int n2) {
    }

    default public boolean useDragDeceleration() {
    }

    default public int getMaxDraggingSpeed() {
    }

    default public void startDragging() {
    }

    default public void stopDragging() {
    }
}

