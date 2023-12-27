/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogConfiguration;

class DialogFeatureHandler$1
implements SpeechDialogConfiguration {
    private final /* synthetic */ DialogFeatureHandler this$0;

    DialogFeatureHandler$1(DialogFeatureHandler dialogFeatureHandler) {
        this.this$0 = dialogFeatureHandler;
    }

    @Override
    public boolean isSessionStartToneEnabled() {
        return this.this$0.settingsService.getSpeechSettings().isUseSpeechSessionStartToneActivated();
    }

    @Override
    public boolean isSessionEndToneEnabled() {
        return this.this$0.settingsService.getSpeechSettings().isUseSpeechSessionEndToneActivated();
    }

    @Override
    public boolean isRecognizerReadyToneEnabled() {
        return this.this$0.settingsService.getSpeechSettings().isRecognizerReadyToneActivated();
    }

    @Override
    public boolean isRecognizerFinishToneEnabled() {
        return this.this$0.settingsService.getSpeechSettings().isRecognizerEndToneActivated();
    }
}

