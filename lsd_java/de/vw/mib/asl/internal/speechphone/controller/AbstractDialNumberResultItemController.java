/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemController;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractDialNumberLengthAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.util.StringUtil;

public abstract class AbstractDialNumberResultItemController
extends AbstractDialNumberLengthAction
implements ResultItemController {
    private final SpeechPhoneLogger2 logger;
    private final ResultItemHandler handler;

    public AbstractDialNumberResultItemController(ServiceFunctions serviceFunctions, PhoneHandler phoneHandler, ResultItemHandler resultItemHandler) {
        super(serviceFunctions, phoneHandler);
        this.handler = resultItemHandler;
        this.logger = serviceFunctions.createLogger("AbstractDialNumberResultItemController");
    }

    @Override
    protected void reactOnRequest(int n) {
        this.onResult();
    }

    @Override
    public void onResult() {
        ResultItem resultItem = this.handler.getResultItem();
        this.notifyResultCompleted(resultItem);
    }

    @Override
    public void notifyResultCompleted(ResultItem resultItem) {
        String string = StringUtil.replaceAll(resultItem.getIdentifier().getRecognizedString(), " ", "");
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Number part recognized: ").append(string).toString());
        }
        this.onRecognizedNumber(string);
    }

    protected abstract void onRecognizedNumber(String string) {
    }
}

