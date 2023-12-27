/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PleaseWaitFeatureHandler;

class PleaseWaitFeatureHandler$2
implements Runnable {
    private final /* synthetic */ PleaseWaitFeatureHandler this$0;

    PleaseWaitFeatureHandler$2(PleaseWaitFeatureHandler pleaseWaitFeatureHandler) {
        this.this$0 = pleaseWaitFeatureHandler;
    }

    @Override
    public void run() {
        if (!this.this$0.pleaseWaitPlaying) {
            return;
        }
        this.this$0.promptPleaseWait();
    }
}

