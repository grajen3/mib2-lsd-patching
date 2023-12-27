/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.HMIEvent;

public interface ListItemEvent
extends HMIEvent {
    default public int getAbsoluteIndex() {
    }

    default public int getActionIndex() {
    }

    default public int getDestinationIndex() {
    }

    default public int getDropDownIndex() {
    }

    default public String getEventSender() {
    }

    default public long getObjectId() {
    }
}

