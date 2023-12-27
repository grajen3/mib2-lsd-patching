/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile;

class MediaController$5
implements CommandCallback {
    private final /* synthetic */ Command val$cmdPlayEntry;
    private final /* synthetic */ Callback val$callback;
    private final /* synthetic */ MediaController this$0;

    MediaController$5(MediaController mediaController, Command command, Callback callback) {
        this.this$0 = mediaController;
        this.val$cmdPlayEntry = command;
        this.val$callback = callback;
    }

    @Override
    public void onCommandExecutionFinished(CommandState commandState) {
        if (commandState.isTerminated()) {
            boolean bl = false;
            if (this.val$cmdPlayEntry.getCommandType() == (MediaController.class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile == null ? (MediaController.class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile = MediaController.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile")) : MediaController.class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile)) {
                bl = ((CmdPlayFile)commandState.getCommand()).hasPlaybackFailed();
            }
            ResultCode resultCode = commandState.isCompleted() && !bl ? ResultCode.OK : ResultCode.NOK;
            this.val$callback.response(resultCode);
        }
    }
}

