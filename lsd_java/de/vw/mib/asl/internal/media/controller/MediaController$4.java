/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.SourceCallback;
import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

class MediaController$4
implements CommandCallback {
    private final /* synthetic */ SourceCallback val$callback;
    private final /* synthetic */ MediaCollector val$source;
    private final /* synthetic */ MediaController this$0;

    MediaController$4(MediaController mediaController, SourceCallback sourceCallback, MediaCollector mediaCollector) {
        this.this$0 = mediaController;
        this.val$callback = sourceCallback;
        this.val$source = mediaCollector;
    }

    @Override
    public void onCommandExecutionFinished(CommandState commandState) {
        if (commandState.isTerminated()) {
            this.val$callback.response(commandState.isCompleted() ? ResultCode.OK : ResultCode.NOK, MediaCollector.createSourceState(this.val$source.getMedium()));
        }
    }
}

