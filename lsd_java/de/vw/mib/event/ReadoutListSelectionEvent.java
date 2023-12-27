/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface ReadoutListSelectionEvent
extends Event {
    default public int getDatasourceIndex() {
    }

    default public int getVAIndexListItem() {
    }

    default public int[] getVAIndexesButtons() {
    }

    default public int getViewHandlerID() {
    }
}

