/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.start;

import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;

public interface SlotUpdaterCallback {
    default public void onSlotUpdaterReady(SlotUpdater slotUpdater) {
    }
}

