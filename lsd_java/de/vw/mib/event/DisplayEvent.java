/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface DisplayEvent
extends Event {
    public static final int DISPLAY_OFF;
    public static final int DISPLAY_ON;

    default public int getState() {
    }
}

