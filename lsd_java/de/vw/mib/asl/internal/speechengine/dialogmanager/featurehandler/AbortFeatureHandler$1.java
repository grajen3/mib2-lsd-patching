/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbortFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.AbortMasterFeature;

class AbortFeatureHandler$1
extends AbstractFeatureHandler {
    private final /* synthetic */ AbortFeatureHandler this$0;

    AbortFeatureHandler$1(AbortFeatureHandler abortFeatureHandler) {
        this.this$0 = abortFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleAbortFeature((AbortMasterFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleAbortFeature((AbortMasterFeature)feature);
    }
}

