/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.RepeatFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.RepeatMasterFeature;

class RepeatFeatureHandler$1
extends AbstractFeatureHandler {
    private final /* synthetic */ RepeatFeatureHandler this$0;

    RepeatFeatureHandler$1(RepeatFeatureHandler repeatFeatureHandler) {
        this.this$0 = repeatFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleRepeatFeature((RepeatMasterFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleRepeatFeature((RepeatMasterFeature)feature);
    }
}

