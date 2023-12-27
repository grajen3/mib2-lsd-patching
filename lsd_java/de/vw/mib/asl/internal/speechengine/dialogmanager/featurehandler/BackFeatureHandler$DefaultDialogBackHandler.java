/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandler;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler;

class BackFeatureHandler$DefaultDialogBackHandler
implements DialogBackHandler {
    protected final Event event;
    protected final int dmState;
    protected final Prompt[] storedPrompts;
    private final /* synthetic */ BackFeatureHandler this$0;

    public BackFeatureHandler$DefaultDialogBackHandler(BackFeatureHandler backFeatureHandler, Event event, int n, Prompt[] promptArray) {
        this.this$0 = backFeatureHandler;
        this.event = event;
        this.dmState = n;
        this.storedPrompts = promptArray;
    }

    @Override
    public void restoreState() {
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("Execute default DialogBackHandler.restoreState()");
        }
        this.playStoredPrompts();
        if (this.event != null) {
            this.this$0.dialogManager.keepPromptsRunning();
            if (this.this$0.logger.isTraceEnabled()) {
                this.this$0.logger.trace().append("Fire event: ").append(this.event.getEventId()).log();
            }
            if (this.storedPrompts != null) {
                this.this$0.dialogManager.ignoreInitialPrompts();
            }
            this.this$0.ignoreNextEvent = true;
            this.this$0.hmiEventPublisher.publishHmiEvent(this.this$0.backstackClient, this.event.getEventId());
            this.this$0.dialogManager.setState(this.dmState);
        } else {
            this.this$0.dialogManager.setState(this.dmState);
            this.this$0.dialogManager.openMainMenu(false, false);
        }
    }

    private void playStoredPrompts() {
        if (this.storedPrompts != null) {
            if (this.this$0.logger.isTraceEnabled()) {
                this.this$0.logger.trace("Playing stored prompts");
            }
            if (this.storedPrompts.length > 0) {
                this.this$0.dialogManager.playPrompts(this.storedPrompts, true, true, this.this$0.backstackClient);
            }
        } else if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("Playing received prompts");
        }
    }

    @Override
    public boolean shouldBackPromptBePlayed() {
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("State: ");
        if (this.dmState == 2) {
            stringBuffer.append("G");
        } else if (this.dmState == 3) {
            stringBuffer.append("H");
        } else if (this.dmState == 4) {
            stringBuffer.append("D");
        } else {
            stringBuffer.append("U");
        }
        stringBuffer.append(", Event: ");
        if (this.event == null) {
            stringBuffer.append("Main Menu");
        } else {
            stringBuffer.append(this.event.getEventId());
        }
        stringBuffer.append(", Prompts: ");
        if (this.storedPrompts == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append("[");
            String string = "";
            for (int i2 = 0; i2 < this.storedPrompts.length; ++i2) {
                stringBuffer.append(string);
                if (this.storedPrompts[i2] == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append(this.storedPrompts[i2].getPromptId());
                }
                string = ", ";
            }
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }
}

