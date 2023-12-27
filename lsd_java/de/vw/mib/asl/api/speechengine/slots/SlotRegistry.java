/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.slots;

import de.vw.mib.asl.api.speechengine.slots.SlotDefinition;

public interface SlotRegistry {
    default public SlotDefinition getSlot(int n) {
    }

    default public SlotDefinition getSlot(String string) {
    }
}

