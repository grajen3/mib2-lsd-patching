/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.slotdef;

import de.vw.mib.asl.api.speechengine.slotdef.SlotRegistry;

public interface SlotDefinitionActivatorCallback {
    default public void onSlotDefinitionReady(SlotRegistry slotRegistry) {
    }
}

