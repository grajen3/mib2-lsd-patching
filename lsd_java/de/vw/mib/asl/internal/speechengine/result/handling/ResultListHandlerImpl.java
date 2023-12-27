/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultSession;
import de.vw.mib.asl.api.speechengine.result.model.ResultCollection;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;

public class ResultListHandlerImpl
implements ResultListHandler {
    private final ResultSession session;

    public ResultListHandlerImpl(ResultSession resultSession) {
        this.session = resultSession;
    }

    @Override
    public ResultItem[] getTopLevelItems() {
        return this.getList().getItems();
    }

    @Override
    public ResultItem[] getDetailLevelItems(ResultItem resultItem) {
        return this.getList().expand(resultItem);
    }

    @Override
    public int getRowNumber() {
        ResultItem resultItem = this.getCommand();
        return Integer.parseInt(resultItem.getTag());
    }

    @Override
    public ResultItem selectByName() {
        return this.getList().select(this.getCommand());
    }

    @Override
    public ResultItem selectByIndex(int n) {
        return this.getList().select(n);
    }

    private ResultCollection getList() {
        return this.session.getResultList();
    }

    private ResultItem getCommand() {
        return this.session.getLastCommand();
    }
}

