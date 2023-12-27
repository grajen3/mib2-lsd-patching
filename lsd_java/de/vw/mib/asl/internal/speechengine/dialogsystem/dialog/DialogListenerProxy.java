/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog;

import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import java.util.ArrayList;
import org.dsi.ifc.speechrec.NBestList;

class DialogListenerProxy
implements DialogListener {
    private ArrayList dialogListeners;

    DialogListenerProxy() {
    }

    void addDialogListener(DialogListener dialogListener) {
        if (this.dialogListeners == null) {
            this.dialogListeners = new ArrayList(1);
        }
        if (dialogListener != null) {
            this.dialogListeners.add(dialogListener);
        }
    }

    void removeDialogListener(DialogListener dialogListener) {
        if (this.dialogListeners != null && dialogListener != null) {
            this.dialogListeners.remove(dialogListener);
        }
    }

    void removeAllDialogListener() {
        if (this.dialogListeners != null) {
            this.dialogListeners.clear();
        }
    }

    @Override
    public void onIdle(Dialog dialog) {
        for (int i2 = 0; i2 < this.dialogListeners.size(); ++i2) {
            ((DialogListener)this.dialogListeners.get(i2)).onIdle(dialog);
        }
    }

    @Override
    public void onStarted(Dialog dialog, int n) {
        for (int i2 = 0; i2 < this.dialogListeners.size(); ++i2) {
            ((DialogListener)this.dialogListeners.get(i2)).onStarted(dialog, n);
        }
    }

    @Override
    public void onTerminated(Dialog dialog, int n) {
        for (int i2 = 0; i2 < this.dialogListeners.size(); ++i2) {
            ((DialogListener)this.dialogListeners.get(i2)).onTerminated(dialog, n);
        }
    }

    @Override
    public void onUtteranceFinished() {
        for (int i2 = 0; i2 < this.dialogListeners.size(); ++i2) {
            ((DialogListener)this.dialogListeners.get(i2)).onUtteranceFinished();
        }
    }

    @Override
    public void onRecognitionFinished(int n, NBestList nBestList) {
        for (int i2 = 0; i2 < this.dialogListeners.size(); ++i2) {
            ((DialogListener)this.dialogListeners.get(i2)).onRecognitionFinished(n, nBestList);
        }
    }

    @Override
    public void onPromptStarted(int n) {
        for (int i2 = 0; i2 < this.dialogListeners.size(); ++i2) {
            ((DialogListener)this.dialogListeners.get(i2)).onPromptStarted(n);
        }
    }

    @Override
    public void onPromptSpoken(int n) {
        for (int i2 = 0; i2 < this.dialogListeners.size(); ++i2) {
            ((DialogListener)this.dialogListeners.get(i2)).onPromptSpoken(n);
        }
    }

    @Override
    public void onPauseStarted() {
        for (int i2 = 0; i2 < this.dialogListeners.size(); ++i2) {
            ((DialogListener)this.dialogListeners.get(i2)).onPauseStarted();
        }
    }

    @Override
    public void onPauseFinished() {
        for (int i2 = 0; i2 < this.dialogListeners.size(); ++i2) {
            ((DialogListener)this.dialogListeners.get(i2)).onPauseFinished();
        }
    }

    @Override
    public void onEndStarted(Dialog dialog) {
        for (int i2 = 0; i2 < this.dialogListeners.size(); ++i2) {
            ((DialogListener)this.dialogListeners.get(i2)).onEndStarted(dialog);
        }
    }
}

