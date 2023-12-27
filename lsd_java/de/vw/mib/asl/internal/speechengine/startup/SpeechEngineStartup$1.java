/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.api.speechengine.features.FeatureFactory;
import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStartup;

class SpeechEngineStartup$1
implements Runnable {
    private final /* synthetic */ FeatureFactory val$featureFactory;
    private final /* synthetic */ SpeechEngineStartup this$0;

    SpeechEngineStartup$1(SpeechEngineStartup speechEngineStartup, FeatureFactory featureFactory) {
        this.this$0 = speechEngineStartup;
        this.val$featureFactory = featureFactory;
    }

    @Override
    public void run() {
        this.this$0.onFeatureFactoryReady(this.val$featureFactory);
    }
}

