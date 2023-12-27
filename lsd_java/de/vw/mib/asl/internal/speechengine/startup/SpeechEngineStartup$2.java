/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStartup;

class SpeechEngineStartup$2
implements Runnable {
    private final /* synthetic */ SpeechEngineStartup this$0;

    SpeechEngineStartup$2(SpeechEngineStartup speechEngineStartup) {
        this.this$0 = speechEngineStartup;
    }

    @Override
    public void run() {
        this.this$0.onSdFeatureCollectionManagerReady();
    }
}

