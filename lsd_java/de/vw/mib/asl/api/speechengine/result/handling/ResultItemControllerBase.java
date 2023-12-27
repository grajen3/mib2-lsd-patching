/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemController;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;

public abstract class ResultItemControllerBase
implements ResultItemController {
    private final ResultItemHandler handler;

    public ResultItemControllerBase(ResultItemHandler resultItemHandler) {
        this.handler = resultItemHandler;
    }

    @Override
    public void onResult() {
        ResultItem resultItem = this.handler.getResultItem();
        this.notifyResultCompleted(resultItem);
    }
}

