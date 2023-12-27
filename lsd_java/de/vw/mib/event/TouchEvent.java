/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface TouchEvent
extends Event {
    public static final int RELEASE;
    public static final int PRESS;
    public static final int CLICK;
    public static final int DRAG;
    public static final int FLICK;
    public static final int ROTATE;
    public static final int PRESS2;
    public static final int DRAG2;
    public static final int FLICK2;
    public static final int ZOOM;
    public static final int RIGHTCLICK;
    public static final int CANCEL;
    public static final int RAW2;
    public static final int RAW2PLUS;
    public static final int MOUSE_POSITION;

    default public int getGestureParam1() {
    }

    default public int getGestureParam2() {
    }

    default public int getTimestamp() {
    }

    default public int getType() {
    }

    default public int getX() {
    }

    default public int getY() {
    }

    default public int getZDelta() {
    }

    default public void setCoordinates(int n, int n2) {
    }
}

