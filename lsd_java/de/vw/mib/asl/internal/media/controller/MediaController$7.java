/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;

class MediaController$7
implements CommandCallback {
    private final /* synthetic */ Callback val$callback;
    private final /* synthetic */ MediaController this$0;

    MediaController$7(MediaController mediaController, Callback callback) {
        this.this$0 = mediaController;
        this.val$callback = callback;
    }

    @Override
    public void onCommandExecutionFinished(CommandState commandState) {
        this.val$callback.response(commandState.isCompleted() && MediaController.access$000(this.this$0).getPlayer().getPlaySelection().isPlaySimilarSelection() ? ResultCode.OK : ResultCode.NOK);
    }
}

