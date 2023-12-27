/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PauseFeatureHandler;

class PauseFeatureHandler$2
implements Runnable {
    private final /* synthetic */ PauseFeatureHandler this$0;

    PauseFeatureHandler$2(PauseFeatureHandler pauseFeatureHandler) {
        this.this$0 = pauseFeatureHandler;
    }

    @Override
    public void run() {
        this.this$0.onPauseTimeout();
    }
}

