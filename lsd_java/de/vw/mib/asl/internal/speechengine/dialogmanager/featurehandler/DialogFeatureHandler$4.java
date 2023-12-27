/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.speechrec.NBestList;

class DialogFeatureHandler$4
implements DialogListener {
    private final /* synthetic */ DialogFeatureHandler this$0;

    DialogFeatureHandler$4(DialogFeatureHandler dialogFeatureHandler) {
        this.this$0 = dialogFeatureHandler;
    }

    @Override
    public void onIdle(Dialog dialog) {
        this.this$0.dialogManager.startPleaseWaitTimer();
    }

    @Override
    public void onStarted(Dialog dialog, int n) {
        if (n == 0) {
            if (this.this$0.currentSessionListener != null) {
                this.this$0.currentSessionListener.onStarted();
            }
            this.this$0.dialogManager.openMainMenu(false, true);
        } else {
            this.this$0.logger.info("Starting Dialog was rejected. ");
            this.this$0.disposeDialog();
        }
    }

    @Override
    public void onTerminated(Dialog dialog, int n) {
        if (n == 1) {
            this.this$0.logger.error("Error occured in Dialog.");
        }
        if (this.this$0.currentSpeechDialog == dialog) {
            if (this.this$0.logger.isTraceEnabled()) {
                this.this$0.logger.trace("Dialog session terminated.");
            }
            this.this$0.disposeDialog();
        }
    }

    @Override
    public void onUtteranceFinished() {
        this.this$0.isRecognitionRunning = true;
        this.this$0.dialogManager.startPleaseWaitTimer();
    }

    @Override
    public void onRecognitionFinished(int n, NBestList nBestList) {
        this.this$0.isRecognitionRunning = false;
        if (this.this$0.logger.isTraceEnabled()) {
            LogMessage logMessage = this.this$0.logger.trace().append("Received resultCode=");
            logMessage.append(n);
            logMessage.append(", nBestList = ");
            if (nBestList == null) {
                logMessage.append("{null}");
            } else {
                logMessage.append(nBestList.toString());
            }
            logMessage.log();
        }
        this.this$0.dialogManager.onRecognitionFinished(n, nBestList);
    }

    @Override
    public void onPromptStarted(int n) {
        this.this$0.promptStarted(n);
    }

    @Override
    public void onPromptSpoken(int n) {
        if (this.this$0.isRecognitionRunning) {
            this.this$0.dialogManager.startPleaseWaitTimer();
        } else {
            this.this$0.promptSpoken(n);
        }
    }

    @Override
    public void onPauseStarted() {
        this.this$0.dialogManager.startPauseTimer();
    }

    @Override
    public void onPauseFinished() {
        this.this$0.dialogManager.resetPauseTimer();
    }

    @Override
    public void onEndStarted(Dialog dialog) {
        if (this.this$0.logger.isTraceEnabled()) {
            LogMessage logMessage = this.this$0.logger.trace().append("Dialog session onEndStarted ... pro-active shutdown");
            logMessage.log();
        }
        this.this$0.dialogManager.resetPleaseWaitTimer();
        this.this$0.dialogManager.setState(1);
    }
}

