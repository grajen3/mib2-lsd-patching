/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.InitialPromptsFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.client.state.InitialPromptsStateFeature;

class InitialPromptsFeatureHandler$1
extends AbstractFeatureHandler {
    private final /* synthetic */ InitialPromptsFeatureHandler this$0;

    InitialPromptsFeatureHandler$1(InitialPromptsFeatureHandler initialPromptsFeatureHandler) {
        this.this$0 = initialPromptsFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleInitialPromptsFeature((InitialPromptsStateFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleInitialPromptsFeature((InitialPromptsStateFeature)feature);
    }
}

