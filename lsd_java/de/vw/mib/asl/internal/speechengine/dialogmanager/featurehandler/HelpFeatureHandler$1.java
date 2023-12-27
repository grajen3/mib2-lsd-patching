/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.HelpFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.HelpMasterFeature;

class HelpFeatureHandler$1
extends AbstractFeatureHandler {
    private final /* synthetic */ HelpFeatureHandler this$0;

    HelpFeatureHandler$1(HelpFeatureHandler helpFeatureHandler) {
        this.this$0 = helpFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleHelpFeature((HelpMasterFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleHelpFeature((HelpMasterFeature)feature);
    }
}

