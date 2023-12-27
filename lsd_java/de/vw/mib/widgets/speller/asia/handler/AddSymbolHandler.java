/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AddSymbolStrategy;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.handler.HandlerStrategy;

public final class AddSymbolHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private String symbols;

    public AddSymbolHandler() {
        this("");
    }

    public AddSymbolHandler(HandlerStrategy handlerStrategy) {
        this("", handlerStrategy);
    }

    public AddSymbolHandler(String string) {
        this.symbols = string;
        this.setStrategy(new AddSymbolStrategy(this));
    }

    public AddSymbolHandler(String string, HandlerStrategy handlerStrategy) {
        super(handlerStrategy);
        this.symbols = string;
    }

    public String getSymbols() {
        return this.symbols;
    }

    public void setSymbols(String string) {
        this.symbols = string;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        this.getStrategy().doGet(asiaStateProxy, intObjectMap, asiaDatabase);
    }

    @Override
    protected void onReset() {
        super.onReset();
        this.setSymbols("");
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        this.getStrategy().doHandle(asiaDatabaseState, asiaDatabase);
    }

    @Override
    protected void onStateFaultyReceived(int n, AsiaDatabaseState asiaDatabaseState, AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        this.getStrategy().doHandleFaulty(n, asiaDatabaseState, asiaStateProxy, asiaDatabase);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        return stringBuilder.append("[symbols='").append(this.symbols).append("']").toString();
    }
}

