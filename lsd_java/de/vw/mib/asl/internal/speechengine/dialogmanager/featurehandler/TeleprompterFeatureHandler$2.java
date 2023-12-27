/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TeleprompterFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.client.context.TeleprompterOnOffContextFeature;

class TeleprompterFeatureHandler$2
extends AbstractFeatureHandler {
    private final /* synthetic */ TeleprompterFeatureHandler this$0;

    TeleprompterFeatureHandler$2(TeleprompterFeatureHandler teleprompterFeatureHandler) {
        this.this$0 = teleprompterFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.setTeleprompterContextFeature((TeleprompterOnOffContextFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.setTeleprompterContextFeature((TeleprompterOnOffContextFeature)feature);
    }
}

