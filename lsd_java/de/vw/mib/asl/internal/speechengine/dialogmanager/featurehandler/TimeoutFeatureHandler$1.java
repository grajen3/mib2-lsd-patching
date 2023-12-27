/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TimeoutFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.TimeoutMasterFeature;

class TimeoutFeatureHandler$1
extends AbstractFeatureHandler {
    private final /* synthetic */ TimeoutFeatureHandler this$0;

    TimeoutFeatureHandler$1(TimeoutFeatureHandler timeoutFeatureHandler) {
        this.this$0 = timeoutFeatureHandler;
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleTimeoutFeature((TimeoutMasterFeature)feature);
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleTimeoutFeature((TimeoutMasterFeature)feature);
    }
}

