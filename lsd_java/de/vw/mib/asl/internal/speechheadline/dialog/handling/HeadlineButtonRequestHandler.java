/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechheadline.dialog.handling;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.internal.speechheadline.dialog.state.ButtonStateHandler;
import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineLogger;
import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineServiceManager;

public class HeadlineButtonRequestHandler {
    private static final String LOGGER_PREFIX;
    private SpeechHeadlineLogger logger;
    private DialogManager dialogManager;
    private ButtonStateHandler buttonStateHandler;

    public HeadlineButtonRequestHandler(SpeechHeadlineServiceManager speechHeadlineServiceManager, DialogManager dialogManager, ButtonStateHandler buttonStateHandler) {
        this.logger = speechHeadlineServiceManager.createSpeechHeadlineLogger("[HeadlineButtonRequestHandler] ");
        this.dialogManager = dialogManager;
        this.buttonStateHandler = buttonStateHandler;
    }

    public void performButtonPressed() {
        if (this.buttonStateHandler.getButtonState() == ButtonStateHandler.BUTTONSTATE_BACK) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Back button has been pressed, back() of DialogManager will be called.");
            }
            this.dialogManager.back();
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Close button has been pressed, endSession() of DialogManager will be called.");
            }
            this.dialogManager.endSession(true);
        }
    }

    public void performIndicatorPressed() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("SpeechIndicator has been pressed, togglePause() of DialogManager will be called.");
        }
        this.dialogManager.togglePause();
    }
}

