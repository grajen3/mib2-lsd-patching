/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface ProximityEvent
extends Event {
    public static final int TYPE_APPEAR;
    public static final int TYPE_DISAPPEAR;
    public static final int TYPE_MOVE;
    public static final int TYPE_SWIPE_LEFT;
    public static final int TYPE_SWIPE_RIGHT;
    public static final int PROXIMITY_AREA_NEAR;
    public static final int PROXIMITY_AREA_FAR;

    default public int getType() {
    }

    default public int getProximityArea() {
    }

    default public int getObjectId() {
    }

    default public float getX() {
    }

    default public float getY() {
    }

    default public float getWidth() {
    }

    default public float getHeight() {
    }

    default public float getDistance() {
    }

    default public int getTimestamp() {
    }
}

