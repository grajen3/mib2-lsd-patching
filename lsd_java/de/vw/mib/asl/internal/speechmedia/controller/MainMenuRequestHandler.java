/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.speechengine.contexts.SpeechContextEmpty;
import de.vw.mib.asl.internal.speechmedia.action.global.MediaAction;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;

public class MainMenuRequestHandler
extends SpeechContextEmpty {
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[MainMenuRequestHandler] ");
    private MediaAction mediaAction;

    public MainMenuRequestHandler(MediaServiceController mediaServiceController) {
        this.mediaAction = new MediaAction(mediaServiceController);
    }

    @Override
    public void enterMainView() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Triggered SPEECH_MEDIA_MAIN from speech general.");
        }
        this.mediaAction.executeAction(4);
    }

    @Override
    public int getSpeechContextId() {
        return 3;
    }
}

