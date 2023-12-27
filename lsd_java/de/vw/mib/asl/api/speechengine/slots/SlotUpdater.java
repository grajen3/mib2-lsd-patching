/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.slots;

import de.vw.mib.asl.api.speechengine.slots.SlotEntry;

public abstract class SlotUpdater {
    public static final int SLOT_UPDATE_STRATEGY_DEFAULT;
    public static final int SLOT_UPDATE_STRATEGY_GROW;
    public static final int SLOT_UPDATE_STRATEGY_IMMEDIDATE;

    public abstract void updateSlotData(int n, int n2, SlotEntry[] slotEntryArray) {
    }

    public abstract SlotEntry createSlotEntry(long l, String string) {
    }
}

