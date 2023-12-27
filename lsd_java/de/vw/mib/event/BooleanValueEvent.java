/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.HMIEvent;

public interface BooleanValueEvent
extends HMIEvent {
    default public boolean getValue() {
    }
}

