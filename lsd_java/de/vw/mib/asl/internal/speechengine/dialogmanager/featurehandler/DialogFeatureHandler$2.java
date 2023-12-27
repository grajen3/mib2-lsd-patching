/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.client.state.behavior.DialogStepBehaviorStateFeature;

class DialogFeatureHandler$2
implements FeatureHandler {
    private final /* synthetic */ DialogFeatureHandler this$0;

    DialogFeatureHandler$2(DialogFeatureHandler dialogFeatureHandler) {
        this.this$0 = dialogFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleDialogStepBehaviorFeature(n, (DialogStepBehaviorStateFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleDialogStepBehaviorFeature(n, (DialogStepBehaviorStateFeature)feature);
    }

    @Override
    public boolean handleDone() {
        if (this.this$0.dialogStepBehavior != null) {
            this.this$0.doDialogStepBehavior();
        } else if (this.this$0.speakOnlyBehavior != null) {
            this.this$0.doSpeakOnly();
        }
        this.this$0.dialogStepBehavior = null;
        this.this$0.speakOnlyBehavior = null;
        this.this$0.keepPromptsRunning = false;
        this.this$0.ignoreNextPrompt = false;
        return false;
    }

    @Override
    public boolean updateDone() {
        return false;
    }
}

