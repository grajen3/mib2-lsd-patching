/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.HMIEvent;

public interface StringValueEvent
extends HMIEvent {
    default public String getValue() {
    }
}

