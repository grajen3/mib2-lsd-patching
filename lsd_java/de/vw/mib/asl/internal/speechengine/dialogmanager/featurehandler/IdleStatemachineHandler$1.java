/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.IdleStatemachineHandler;
import de.vw.mib.asl.internal.speechengine.features.client.context.IdleStatemachineContextFeature;

class IdleStatemachineHandler$1
extends AbstractFeatureHandler {
    private final /* synthetic */ IdleStatemachineHandler this$0;

    IdleStatemachineHandler$1(IdleStatemachineHandler idleStatemachineHandler) {
        this.this$0 = idleStatemachineHandler;
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.this$0.handleIdleFeature(n, (IdleStatemachineContextFeature)feature);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.this$0.handleIdleFeature(n, (IdleStatemachineContextFeature)feature);
    }
}

