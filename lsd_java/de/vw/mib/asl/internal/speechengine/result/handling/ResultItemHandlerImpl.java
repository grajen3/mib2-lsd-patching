/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultSession;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;

public class ResultItemHandlerImpl
implements ResultItemHandler {
    private final ResultSession session;

    public ResultItemHandlerImpl(ResultSession resultSession) {
        this.session = resultSession;
    }

    @Override
    public ResultItem getResultItem() {
        return this.session.getLastCommand();
    }
}

