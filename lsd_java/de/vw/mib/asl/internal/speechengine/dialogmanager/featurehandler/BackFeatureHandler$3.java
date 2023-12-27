/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.BackMasterFeature;

class BackFeatureHandler$3
extends AbstractFeatureHandler {
    private final /* synthetic */ BackFeatureHandler this$0;

    BackFeatureHandler$3(BackFeatureHandler backFeatureHandler) {
        this.this$0 = backFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleBackFeature((BackMasterFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleBackFeature((BackMasterFeature)feature);
    }
}

