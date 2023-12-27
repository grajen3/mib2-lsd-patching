/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface ViewAnimationEvent
extends Event {
    public static final int ANIMATION_STARTED;
    public static final int ANIMATION_RUNNING;
    public static final int ANIMATION_STOPPED;
    public static final int ENTER_ANIMATION_STARTED;
    public static final int ENTER_ANIMATION_STOPPED;
    public static final int LEAVE_ANIMATION_STARTED;
    public static final int LEAVE_ANIMATION_STOPPED;

    default public int getAnimationType() {
    }
}

