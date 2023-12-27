/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlCallback;
import de.vw.mib.asl.api.mediacontrol.services.MediaControlResultCode;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandCallback;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandState;

final class Helper$1
implements CommandCallback {
    private final /* synthetic */ MediaControlCallback val$cmdCallback;

    Helper$1(MediaControlCallback mediaControlCallback) {
        this.val$cmdCallback = mediaControlCallback;
    }

    @Override
    public void onCommandExecutionFinished(CommandState commandState) {
        if (commandState.isCompleted()) {
            this.val$cmdCallback.response(MediaControlResultCode.OK);
        } else {
            this.val$cmdCallback.response(MediaControlResultCode.NOK);
        }
    }
}

