/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.activity;

import de.vw.mib.sm.internal.activity.EventReceiverTable$ReceiverColumn;

public interface DynamicStatemachineTrigger {
    default public void registerTriggers(EventReceiverTable$ReceiverColumn eventReceiverTable$ReceiverColumn) {
    }

    default public void handleHMIEvent() {
    }

    default public void selfClosing(int n) {
    }

    default public void closed(int n) {
    }
}

