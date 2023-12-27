/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;

class MediaController$11
implements CommandCallback {
    private final /* synthetic */ FactoryResetCallback val$callback;
    private final /* synthetic */ MediaController this$0;

    MediaController$11(MediaController mediaController, FactoryResetCallback factoryResetCallback) {
        this.this$0 = mediaController;
        this.val$callback = factoryResetCallback;
    }

    @Override
    public void onCommandExecutionFinished(CommandState commandState) {
        if (this.val$callback != null) {
            this.val$callback.notifyResetDone();
        }
    }
}

