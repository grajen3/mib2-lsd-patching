/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.genericevents.EventGeneric;

public class AdjustmentController
implements ModelEventConsumer {
    private final DialogManager dialogManager;

    public AdjustmentController(DialogManager dialogManager) {
        this.dialogManager = dialogManager;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() != -1551746240) {
            return;
        }
        this.dialogManager.pauseSession();
    }
}

