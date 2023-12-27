/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SessionTypeUtil;
import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.speechrec.NBestList;

class DialogFeatureHandler$PromptDialogListener
implements DialogListener {
    private final int sessionType;
    private final /* synthetic */ DialogFeatureHandler this$0;

    public DialogFeatureHandler$PromptDialogListener(DialogFeatureHandler dialogFeatureHandler, int n) {
        this.this$0 = dialogFeatureHandler;
        this.sessionType = n;
    }

    @Override
    public void onPromptStarted(int n) {
        this.this$0.promptStarted(n);
    }

    @Override
    public void onPromptSpoken(int n) {
        this.this$0.promptSpoken(n);
    }

    @Override
    public void onIdle(Dialog dialog) {
    }

    @Override
    public void onTerminated(Dialog dialog, int n) {
        this.disposePromptDialog(dialog);
    }

    @Override
    public void onStarted(Dialog dialog, int n) {
        if (n == 1) {
            LogMessage logMessage = this.this$0.logger.info();
            logMessage.append("PromptDialog couldn't be started. ");
            logMessage.log();
        }
    }

    @Override
    public void onUtteranceFinished() {
    }

    @Override
    public void onRecognitionFinished(int n, NBestList nBestList) {
    }

    @Override
    public void onPauseStarted() {
    }

    @Override
    public void onPauseFinished() {
    }

    @Override
    public void onEndStarted(Dialog dialog) {
    }

    private void disposePromptDialog(Dialog dialog) {
        Object object;
        if (this.this$0.logger.isTraceEnabled()) {
            object = new StringBuffer();
            ((StringBuffer)object).append("Prompt dialog with sessionType: ");
            ((StringBuffer)object).append(SessionTypeUtil.toString(this.sessionType));
            ((StringBuffer)object).append(" terminated.");
            this.this$0.logger.trace(((StringBuffer)object).toString());
        }
        if ((object = this.this$0.promptDialogs.get(this.sessionType)) != dialog) {
            this.this$0.logger.error("Something is wrong. A prompt dialog finished, but was not stored in hash map.");
        }
        this.this$0.promptDialogs.remove(this.sessionType);
        dialog.removeDialogListener(this);
    }
}

