/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.client.state.BackstackStateFeature;

class BackFeatureHandler$2
implements FeatureHandler {
    private final /* synthetic */ BackFeatureHandler this$0;

    BackFeatureHandler$2(BackFeatureHandler backFeatureHandler) {
        this.this$0 = backFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleBackstackFeature(n, (BackstackStateFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleBackstackFeature(n, (BackstackStateFeature)feature);
    }

    @Override
    public boolean handleDone() {
        this.this$0.handleBackstackFeatureDone();
        return false;
    }

    @Override
    public boolean updateDone() {
        return false;
    }
}

