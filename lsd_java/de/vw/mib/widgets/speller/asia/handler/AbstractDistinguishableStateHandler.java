/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;

public abstract class AbstractDistinguishableStateHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    public static final int CASE_HWR;
    public static final int CASE_PINYIN_ZHUYIN_HIRAGANA;
    private final int caseToHandle;

    protected AbstractDistinguishableStateHandler(int n) {
        this.caseToHandle = n;
    }

    protected final int getCaseToHandle() {
        return this.caseToHandle;
    }

    protected final boolean isCaseToHandle(int n) {
        return this.caseToHandle == n;
    }
}

