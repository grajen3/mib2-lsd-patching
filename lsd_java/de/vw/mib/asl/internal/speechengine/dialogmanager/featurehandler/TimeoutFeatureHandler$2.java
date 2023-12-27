/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TimeoutFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.PauseMasterFeature;

class TimeoutFeatureHandler$2
extends AbstractFeatureHandler {
    private final /* synthetic */ TimeoutFeatureHandler this$0;

    TimeoutFeatureHandler$2(TimeoutFeatureHandler timeoutFeatureHandler) {
        this.this$0 = timeoutFeatureHandler;
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handlePauseFeature((PauseMasterFeature)feature);
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handlePauseFeature((PauseMasterFeature)feature);
    }
}

