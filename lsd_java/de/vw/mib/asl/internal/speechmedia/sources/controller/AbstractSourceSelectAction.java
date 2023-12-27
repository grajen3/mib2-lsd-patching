/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.sources.controller;

import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;

public abstract class AbstractSourceSelectAction
implements RecognizedEventConsumer {
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[AbstractSourceSelectAction] ");
    private final ResultItemHandler resultHandler;
    protected final MediaServiceController msController;

    public AbstractSourceSelectAction(ResultHandler resultHandler, MediaServiceController mediaServiceController) {
        this.msController = mediaServiceController;
        this.resultHandler = resultHandler.getResultItemHandler();
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (this.isTagged()) {
            ResultItem resultItem = this.resultHandler.getResultItem();
            String string = resultItem.getTag();
            this.onRecognition(string);
        } else {
            this.onRecognition(null);
        }
    }

    protected abstract boolean isTagged() {
    }

    protected abstract void onRecognition(String string) {
    }
}

