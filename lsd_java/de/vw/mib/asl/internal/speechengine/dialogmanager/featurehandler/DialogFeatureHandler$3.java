/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.client.state.behavior.SpeakOnlyStateFeature;

class DialogFeatureHandler$3
extends AbstractFeatureHandler {
    private final /* synthetic */ DialogFeatureHandler this$0;

    DialogFeatureHandler$3(DialogFeatureHandler dialogFeatureHandler) {
        this.this$0 = dialogFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleSpeakOnlyFeature(n, (SpeakOnlyStateFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleSpeakOnlyFeature(n, (SpeakOnlyStateFeature)feature);
    }
}

