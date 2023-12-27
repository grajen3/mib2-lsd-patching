/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.internal.speechmedia.controller.ActivationHandler;

class ActivationHandler$1
implements Runnable {
    private final /* synthetic */ ActivationHandler this$0;

    ActivationHandler$1(ActivationHandler activationHandler) {
        this.this$0 = activationHandler;
    }

    @Override
    public void run() {
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("Activation timed out.");
        }
        this.this$0.activationTimer.stop();
        if (!this.this$0.activationInProgress) {
            return;
        }
        this.this$0.activationInProgress = false;
        this.this$0.activationCallback.response(ResultCode.NOK);
    }
}

