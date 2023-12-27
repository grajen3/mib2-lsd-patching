/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.sources.controller;

import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.sources.controller.AbstractSourceSelectAction;

public class SelectSdAction
extends AbstractSourceSelectAction {
    public SelectSdAction(ResultHandler resultHandler, MediaServiceController mediaServiceController) {
        super(resultHandler, mediaServiceController);
    }

    @Override
    protected void onRecognition(String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("SD action, tag : ").append(string).log();
        }
        if (string == null || "".equals(string) || string.equals("0")) {
            this.msController.activateSource(30);
            return;
        }
        if (string.equals("1")) {
            this.msController.activateSource(3);
        } else if (string.equals("2")) {
            this.msController.activateSource(4);
        } else {
            this.logger.error().append("Unknown SD tag : ").append(string).log();
        }
    }

    @Override
    protected boolean isTagged() {
        return true;
    }
}

