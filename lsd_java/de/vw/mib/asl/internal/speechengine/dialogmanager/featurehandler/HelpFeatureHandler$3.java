/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.HelpFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.ListHelpPromptMasterFeature;

class HelpFeatureHandler$3
implements FeatureHandler {
    private final /* synthetic */ HelpFeatureHandler this$0;

    HelpFeatureHandler$3(HelpFeatureHandler helpFeatureHandler) {
        this.this$0 = helpFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleListHelpPromptFeature((ListHelpPromptMasterFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleListHelpPromptFeature((ListHelpPromptMasterFeature)feature);
    }

    @Override
    public boolean handleDone() {
        if (this.this$0.isDialogStep) {
            this.this$0.prompts.setExtraPromptsEnabled(this.this$0.enableListHelp);
            this.this$0.enableListHelp = false;
        }
        this.this$0.isDialogStep = false;
        return false;
    }

    @Override
    public boolean updateDone() {
        return false;
    }
}

