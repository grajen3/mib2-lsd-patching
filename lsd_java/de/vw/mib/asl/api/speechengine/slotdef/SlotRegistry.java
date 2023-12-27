/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.slotdef;

import de.vw.mib.asl.api.speechengine.slotdef.SlotDefinition;

public interface SlotRegistry {
    default public SlotDefinition getSlot(int n) {
    }

    default public SlotDefinition getSlot(String string) {
    }

    default public SlotDefinition[] getAllSlots() {
    }
}

