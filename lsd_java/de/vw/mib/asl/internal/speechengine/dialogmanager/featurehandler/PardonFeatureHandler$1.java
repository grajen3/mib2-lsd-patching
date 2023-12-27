/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PardonFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.PardonMasterFeature;

class PardonFeatureHandler$1
extends AbstractFeatureHandler {
    private final /* synthetic */ PardonFeatureHandler this$0;

    PardonFeatureHandler$1(PardonFeatureHandler pardonFeatureHandler) {
        this.this$0 = pardonFeatureHandler;
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handlePardonFeature((PardonMasterFeature)feature);
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handlePardonFeature((PardonMasterFeature)feature);
    }
}

