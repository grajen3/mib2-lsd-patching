/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.AslTargetSystemCharacterRecognition;
import de.vw.mib.speller.hwr.HWRConfiguration;
import de.vw.mib.speller.hwr.HWREngine;
import de.vw.mib.speller.hwr.HWREngineListener;

class AslTargetSystemCharacterRecognition$HWREngineImpl
implements HWREngine {
    HWREngineListener listener;
    private final /* synthetic */ AslTargetSystemCharacterRecognition this$0;

    AslTargetSystemCharacterRecognition$HWREngineImpl(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition, HWREngineListener hWREngineListener) {
        this.this$0 = aslTargetSystemCharacterRecognition;
        this.listener = hWREngineListener;
    }

    HWREngineListener getListener() {
        return this.listener;
    }

    private boolean isActive() {
        return AslTargetSystemCharacterRecognition.access$100(this.this$0) == this;
    }

    @Override
    public synchronized void clear() {
        if (this.isActive()) {
            AslTargetSystemCharacterRecognition.access$200(this.this$0);
        }
    }

    @Override
    public synchronized HWRConfiguration getConfiguration() {
        return AslTargetSystemCharacterRecognition.access$300(this.this$0);
    }

    @Override
    public synchronized boolean isConfigured() {
        return this.isActive() && AslTargetSystemCharacterRecognition.access$400(this.this$0);
    }

    @Override
    public synchronized boolean isReady() {
        return this.isActive() && AslTargetSystemCharacterRecognition.access$500(this.this$0);
    }

    @Override
    public synchronized void release() {
        if (this.isActive()) {
            AslTargetSystemCharacterRecognition.access$600(this.this$0);
        }
        this.listener = null;
    }

    @Override
    public synchronized void sendConfiguration() {
        if (this.isActive()) {
            AslTargetSystemCharacterRecognition.access$700(this.this$0);
        }
    }

    @Override
    public synchronized void setConfiguration(HWRConfiguration hWRConfiguration) {
        if (this.isActive()) {
            AslTargetSystemCharacterRecognition.access$800(this.this$0, hWRConfiguration);
        }
    }
}

