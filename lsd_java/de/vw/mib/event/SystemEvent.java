/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.HMIEvent;

public interface SystemEvent
extends HMIEvent {
    default public int getASLSystemEventId() {
    }
}

