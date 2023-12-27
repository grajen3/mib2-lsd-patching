/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface LSChangeEvent
extends Event {
    public static final int LSCHANGE_START;
    public static final int LSCHANGE_FINISHED;

    default public int getCommand() {
    }
}

