/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.HMIEvent;

public interface PointEvent
extends HMIEvent {
    default public int getX() {
    }

    default public int getY() {
    }

    default public int getGestureParam1() {
    }

    default public int getGestureParam2() {
    }
}

