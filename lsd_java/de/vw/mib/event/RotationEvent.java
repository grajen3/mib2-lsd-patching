/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.HMIEvent;

public interface RotationEvent
extends HMIEvent {
    default public int getTimestamp() {
    }

    default public int getTicks() {
    }
}

