/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.messenger.slot;

import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateConsumer;

public interface SlotStateRouter {
    default public void register(int n, SlotStateConsumer slotStateConsumer) {
    }

    default public void unregister(int n, SlotStateConsumer slotStateConsumer) {
    }
}

