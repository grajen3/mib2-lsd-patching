/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.internal.media.browser.sds.MediaSpeechBrowser;
import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;

class MediaController$10
implements CommandCallback {
    private final /* synthetic */ MediaSpeechBrowser val$browser;
    private final /* synthetic */ Callback val$callback;
    private final /* synthetic */ MediaController this$0;

    MediaController$10(MediaController mediaController, MediaSpeechBrowser mediaSpeechBrowser, Callback callback) {
        this.this$0 = mediaController;
        this.val$browser = mediaSpeechBrowser;
        this.val$callback = callback;
    }

    @Override
    public void onCommandExecutionFinished(CommandState commandState) {
        this.val$browser.getState().setSpeakableElementsSize(this.val$browser.getState().getListSize(), true);
        this.val$callback.response(commandState.isCompleted() ? ResultCode.OK : ResultCode.OK);
    }
}

