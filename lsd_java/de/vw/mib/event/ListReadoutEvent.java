/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface ListReadoutEvent
extends Event {
    default public int getDatasourceIndex() {
    }

    default public int getViewHandlerID() {
    }

    default public int getVAIndexListItem() {
    }
}

