/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.handler.TransferUnconvertedStrategy;

public class TransferSymbolsUnconvertedHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    public TransferSymbolsUnconvertedHandler() {
        this.setStrategy(new TransferUnconvertedStrategy(this));
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        this.getStrategy().doGet(asiaStateProxy, asiaDatabase);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        this.getStrategy().doHandle(asiaDatabaseState, asiaDatabase);
    }
}

