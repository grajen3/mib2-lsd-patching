/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.genericevents.EventGeneric;

public class AdjustmentController
implements ModelEventConsumer {
    public static final int EVENT_ID;
    private final DialogManager dialogManager;

    public AdjustmentController(DialogManager dialogManager) {
        this.dialogManager = dialogManager;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() != -900058560) {
            return;
        }
        this.dialogManager.pauseSession();
    }
}

