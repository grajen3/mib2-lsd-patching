/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateBitField;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.system.contentprocessor.AbstractContentProcessor;
import de.vw.mib.asl.internal.system.processor.SpeechContentProcessor$1;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.log4mib.Logger;

public class SpeechContentProcessor
extends AbstractContentProcessor {
    private DialogStateRouter dialogStateRouter;
    private SystemLogger systemLogger;

    public SpeechContentProcessor(Logger logger) {
        super(logger, "ScreenAreaSpeech");
        this.systemLogger = new SystemLogger(logger, super.getClass());
    }

    @Override
    public void requestContent(String string) {
        boolean bl;
        this.systemLogger.trace(new Object[]{"requestContent called. Content id is ", string, "."});
        boolean bl2 = "NO_CONTENT".equals(string);
        boolean bl3 = bl = this.checkSpeechIsActive() || bl2;
        if (bl) {
            this.systemLogger.trace(new Object[]{"Content request for content id ", string, " is allowed."});
            this.updateContent(string);
        } else {
            this.systemLogger.trace(new Object[]{"Content request for content id ", string, " is NOT allowed."});
        }
    }

    public void installDialogStateRouter(DialogStateRouter dialogStateRouter) {
        this.dialogStateRouter = dialogStateRouter;
        dialogStateRouter.register(new SpeechContentProcessor$1(this));
    }

    private boolean checkSpeechIsActive() {
        this.systemLogger.trace("checkSpeechIsActive is called.");
        if (this.dialogStateRouter == null) {
            this.systemLogger.trace("Instance of DialogStateRouter is null. Return speechIsActive = false.");
            return false;
        }
        DialogStateBitField dialogStateBitField = this.dialogStateRouter.getDialogState();
        boolean bl = dialogStateBitField.isSpeechActive() && !dialogStateBitField.isShutdownActive();
        this.systemLogger.trace(new Object[]{"Return speechIsActive = ", new Boolean(bl), "."});
        return bl;
    }
}

