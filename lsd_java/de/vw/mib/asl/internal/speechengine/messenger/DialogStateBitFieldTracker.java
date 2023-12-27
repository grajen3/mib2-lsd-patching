/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateBitField;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import java.util.Collection;
import java.util.Iterator;

public class DialogStateBitFieldTracker
implements DialogStateBitField {
    private final AbstractClassifiedLogger logger;
    private int recognitionActiveState = 1;
    private boolean recognitionActiveStateDirty = false;
    private int speechActiveState = 3;
    private boolean speechActiveStateDirty = false;
    private int promptActiveState = 5;
    private boolean promptActiveStateDirty = false;
    private int pauseActiveState = 7;
    private boolean pauseActiveStateDirty = false;
    private int shutdownActiveState = 9;
    private boolean shutdownActiveStateDirty = false;

    public DialogStateBitFieldTracker(AbstractClassifiedLogger abstractClassifiedLogger) {
        this.logger = abstractClassifiedLogger;
    }

    @Override
    public boolean isRecognitionActive() {
        return this.recognitionActiveState == 0;
    }

    public void setRecognitionActive(int n) {
        if (this.recognitionActiveState != n) {
            this.recognitionActiveStateDirty = true;
            this.recognitionActiveState = n;
        }
    }

    @Override
    public boolean isSpeechActive() {
        return this.speechActiveState == 2;
    }

    public void setSpeechActive(int n) {
        if (this.speechActiveState != n) {
            this.speechActiveStateDirty = true;
            this.speechActiveState = n;
        }
    }

    @Override
    public boolean isPromptActive() {
        return this.promptActiveState == 4;
    }

    public void setPromptActive(int n) {
        if (this.promptActiveState != n) {
            this.promptActiveStateDirty = true;
            this.promptActiveState = n;
        }
    }

    @Override
    public boolean isPauseActive() {
        return this.pauseActiveState == 6;
    }

    public void setPauseActive(int n) {
        if (this.pauseActiveState != n) {
            this.pauseActiveStateDirty = true;
            this.pauseActiveState = n;
        }
    }

    @Override
    public boolean isShutdownActive() {
        return this.shutdownActiveState == 8;
    }

    public void setShutdownActive(int n) {
        if (this.shutdownActiveState != n) {
            this.shutdownActiveStateDirty = true;
            this.shutdownActiveState = n;
        }
    }

    void submitUpdates(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            DialogStateConsumer dialogStateConsumer = (DialogStateConsumer)iterator.next();
            if (this.pauseActiveStateDirty) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace().append("publishing pauseActiveState ").append(this.pauseActiveState).log();
                }
                dialogStateConsumer.onDialogStateChanged(this.pauseActiveState);
            }
            if (this.promptActiveStateDirty) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace().append("publishing promptActiveState ").append(this.promptActiveState).log();
                }
                dialogStateConsumer.onDialogStateChanged(this.promptActiveState);
            }
            if (this.recognitionActiveStateDirty) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace().append("publishing recognitionActiveState ").append(this.recognitionActiveState).log();
                }
                dialogStateConsumer.onDialogStateChanged(this.recognitionActiveState);
            }
            if (this.shutdownActiveStateDirty) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace().append("publishing shutdownActiveState ").append(this.shutdownActiveState).log();
                }
                dialogStateConsumer.onDialogStateChanged(this.shutdownActiveState);
            }
            if (!this.speechActiveStateDirty) continue;
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("publishing speechActiveState ").append(this.speechActiveState).log();
            }
            dialogStateConsumer.onDialogStateChanged(this.speechActiveState);
        }
        this.pauseActiveStateDirty = false;
        this.promptActiveStateDirty = false;
        this.recognitionActiveStateDirty = false;
        this.shutdownActiveStateDirty = false;
        this.speechActiveStateDirty = false;
    }
}

