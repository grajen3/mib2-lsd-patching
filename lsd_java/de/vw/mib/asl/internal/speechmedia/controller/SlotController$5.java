/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateConsumer;
import de.vw.mib.asl.internal.speechmedia.controller.SlotController;

class SlotController$5
implements SlotStateConsumer {
    private final /* synthetic */ SlotController this$0;

    SlotController$5(SlotController slotController) {
        this.this$0 = slotController;
    }

    @Override
    public void onSlotStateChanged(int n, int n2) {
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace().append("Changed slot state TITLE to: ").append(n2).log();
        }
        this.this$0.titleState = n2;
        this.this$0.notifySlotStateChanged(n, n2);
    }
}

