/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface PopupStackChangeEvent
extends Event {
    default public int getNumberOfPopups() {
    }

    default public int getNumberOfUserPerceivedOffPopups() {
    }
}

