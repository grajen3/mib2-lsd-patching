/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdSetupBrowser;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

class MediaController$2
implements CommandCallback {
    private final /* synthetic */ MediaCollector val$mediaInSlot;
    private final /* synthetic */ MediaController this$0;

    MediaController$2(MediaController mediaController, MediaCollector mediaCollector) {
        this.this$0 = mediaController;
        this.val$mediaInSlot = mediaCollector;
    }

    @Override
    public void onCommandExecutionFinished(CommandState commandState) {
        if (commandState.isCompleted()) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(391908352);
            CmdSetupBrowser cmdSetupBrowser = new CmdSetupBrowser(MediaController.access$000(this.this$0).getBrowser_MainView(), this.val$mediaInSlot, 0);
            MediaController.access$100(this.this$0).addCommand(cmdSetupBrowser);
        }
    }
}

