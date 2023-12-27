/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractCommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TeleprompterFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;

class TeleprompterFeatureHandler$4
extends AbstractCommandConsumer {
    private final /* synthetic */ TeleprompterFeatureHandler this$0;

    TeleprompterFeatureHandler$4(TeleprompterFeatureHandler teleprompterFeatureHandler, DialogManagerInternal dialogManagerInternal, String string, String string2) {
        this.this$0 = teleprompterFeatureHandler;
        super(dialogManagerInternal, string, string2);
    }

    @Override
    public void recognizedCommand(Command command) {
        if (this.this$0.offPrompts.isValid()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Teleprompter OFF command recognized - Play teleprompter off prompt.");
            }
            this.dialogManager.playPrompt(this.this$0.offPrompts.getNextPromptId(), true, true);
        } else {
            this.logger.error("Teleprompter OFF command recognized - No teleprompter off prompt set.");
        }
        this.this$0.teleprompterManager.hide();
        this.dialogManager.startRecognition();
    }

    @Override
    public boolean isUniversal() {
        return false;
    }
}

