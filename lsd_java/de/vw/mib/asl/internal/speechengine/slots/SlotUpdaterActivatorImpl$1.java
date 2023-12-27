/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots;

import de.vw.mib.asl.internal.speechengine.slots.SlotUpdaterActivatorImpl;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.IsLoadRequestInAcceptedTimeHook;

class SlotUpdaterActivatorImpl$1
implements IsLoadRequestInAcceptedTimeHook {
    private final /* synthetic */ SlotUpdaterActivatorImpl this$0;

    SlotUpdaterActivatorImpl$1(SlotUpdaterActivatorImpl slotUpdaterActivatorImpl) {
        this.this$0 = slotUpdaterActivatorImpl;
    }

    @Override
    public boolean hook(boolean bl) {
        return bl;
    }
}

