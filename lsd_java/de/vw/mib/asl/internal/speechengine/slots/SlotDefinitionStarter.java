/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots;

import de.vw.mib.asl.api.speechengine.slotdef.SlotDefinitionActivator;
import de.vw.mib.asl.api.speechengine.slotdef.SlotDefinitionActivatorCallback;
import de.vw.mib.asl.internal.speechengine.slots.SlotRegistryNewImpl;

public class SlotDefinitionStarter
implements SlotDefinitionActivator {
    @Override
    public void instantiate(SlotDefinitionActivatorCallback slotDefinitionActivatorCallback) {
        SlotRegistryNewImpl slotRegistryNewImpl = new SlotRegistryNewImpl();
        slotDefinitionActivatorCallback.onSlotDefinitionReady(slotRegistryNewImpl);
    }
}

