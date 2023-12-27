/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog;

import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogConfiguration;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.AbstractDialog;

class AbstractDialog$1
implements SpeechDialogConfiguration {
    private final /* synthetic */ AbstractDialog this$0;

    AbstractDialog$1(AbstractDialog abstractDialog) {
        this.this$0 = abstractDialog;
    }

    @Override
    public boolean isSessionStartToneEnabled() {
        return false;
    }

    @Override
    public boolean isSessionEndToneEnabled() {
        return false;
    }

    @Override
    public boolean isRecognizerReadyToneEnabled() {
        return false;
    }

    @Override
    public boolean isRecognizerFinishToneEnabled() {
        return false;
    }
}

