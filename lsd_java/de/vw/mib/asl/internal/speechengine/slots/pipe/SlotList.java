/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe;

import de.vw.mib.asl.api.speechengine.slots.SlotEntry;

public interface SlotList {
    default public int getSlotId() {
    }

    default public void add(SlotEntry[] slotEntryArray) {
    }

    default public void exchangeAll(SlotEntry[] slotEntryArray) {
    }

    default public boolean isDirty() {
    }

    default public void load() {
    }
}

