/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.ClientEventsFeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.client.context.ContextEventsContextFeature;

class ClientEventsFeatureHandler$1
extends AbstractFeatureHandler {
    private final /* synthetic */ ClientEventsFeatureHandler this$0;

    ClientEventsFeatureHandler$1(ClientEventsFeatureHandler clientEventsFeatureHandler) {
        this.this$0 = clientEventsFeatureHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleContextEventsFeature(n, (ContextEventsContextFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleContextEventsFeature(n, (ContextEventsContextFeature)feature);
    }
}

