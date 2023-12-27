/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PauseFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.PauseMasterFeature;

class PauseFeatureHandler$1
extends AbstractFeatureHandler {
    private final /* synthetic */ PauseFeatureHandler this$0;

    PauseFeatureHandler$1(PauseFeatureHandler pauseFeatureHandler) {
        this.this$0 = pauseFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handlePauseFeature((PauseMasterFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handlePauseFeature((PauseMasterFeature)feature);
    }
}

