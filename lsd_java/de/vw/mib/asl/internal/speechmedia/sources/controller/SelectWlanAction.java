/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.sources.controller;

import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.sources.controller.AbstractSourceSelectAction;

public class SelectWlanAction
extends AbstractSourceSelectAction {
    public SelectWlanAction(ResultHandler resultHandler, MediaServiceController mediaServiceController) {
        super(resultHandler, mediaServiceController);
    }

    @Override
    protected void onRecognition(String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("WLAN action");
        }
        this.msController.activateSource(11);
    }

    @Override
    protected boolean isTagged() {
        return false;
    }
}

