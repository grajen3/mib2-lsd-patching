/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemController;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public abstract class AbstractCheckedResultItemController
extends AbstractCheckedPhoneAction
implements ResultItemController {
    private final ResultItemHandler handler;

    public AbstractCheckedResultItemController(ServiceFunctions serviceFunctions, int n, PhoneHandler phoneHandler, ResultItemHandler resultItemHandler) {
        super(serviceFunctions, n, phoneHandler);
        this.handler = resultItemHandler;
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
}

