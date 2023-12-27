/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface DynamicStateEvent
extends Event {
    public static final int OPEN;
    public static final int REQUEST_CLOSE;
    public static final int CLOSED;
    public static final int TIMEOUT_RESTART;

    default public int getCommand() {
    }

    default public int getDynamicStateId() {
    }

    default public int getPopupInfoId() {
    }
}

