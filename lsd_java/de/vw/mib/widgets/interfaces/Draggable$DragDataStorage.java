/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Point;
import de.vw.mib.widgets.animation.DragCalculator;

public final class Draggable$DragDataStorage {
    public final Point initialTouchPoint = new Point();
    public final Point initialViewportLocation = new Point();
    public final EasingParams easingSnap = new EasingParams(DragCalculator.EASING_SNAP);
    public float dragMultiplier;
    public int lastDragEventTime;
    public int deltaTime;
    public int deltaX;
    public int deltaY;
    public int x;
    public int y;
    public boolean dragActive;
    public boolean useThreshold = true;
}

