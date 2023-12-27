/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots;

import de.vw.mib.asl.api.speechengine.slotdef.SlotDefinition;
import de.vw.mib.asl.api.speechengine.slotdef.SlotRegistry;
import de.vw.mib.asl.internal.speechengine.slots.SlotRegistryImpl;
import java.util.Iterator;

public class SlotRegistryNewImpl
implements SlotRegistry {
    SlotRegistryImpl slotRegistryImpl = new SlotRegistryImpl();

    @Override
    public SlotDefinition getSlot(int n) {
        return (SlotDefinition)this.slotRegistryImpl.getSlotIdMap().get(n);
    }

    @Override
    public SlotDefinition getSlot(String string) {
        Iterator iterator = this.slotRegistryImpl.getSlotIdMap().valueIterator();
        while (iterator.hasNext()) {
            SlotDefinition slotDefinition = (SlotDefinition)iterator.next();
            if (!slotDefinition.getSlotName().equals(string)) continue;
            return slotDefinition;
        }
        return null;
    }

    @Override
    public SlotDefinition[] getAllSlots() {
        Object[] objectArray = new SlotDefinition[this.slotRegistryImpl.getSlotIdMap().size()];
        this.slotRegistryImpl.getSlotIdMap().valuesToArray(objectArray);
        return objectArray;
    }
}

