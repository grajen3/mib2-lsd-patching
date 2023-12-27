/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.slotdef;

import de.vw.mib.asl.api.speechengine.slotdef.SlotDefinitionActivatorCallback;

public interface SlotDefinitionActivator {
    public static final String SLOT_DEFINITION_ACTIVATOR;

    default public void instantiate(SlotDefinitionActivatorCallback slotDefinitionActivatorCallback) {
    }
}

