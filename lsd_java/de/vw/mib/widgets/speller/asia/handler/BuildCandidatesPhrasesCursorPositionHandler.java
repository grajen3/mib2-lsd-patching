/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.handler.TransferUnconvertedStrategy;

public final class BuildCandidatesPhrasesCursorPositionHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private final TransferUnconvertedStrategy transferUnconvertedStrategy = new TransferUnconvertedStrategy(this);

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(28, this);
    }

    @Override
    protected void onStateFaultyReceived(int n, AsiaDatabaseState asiaDatabaseState, AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        switch (n) {
            case 49: {
                this.transferUnconvertedStrategy.doHandle(asiaDatabaseState, asiaDatabase);
                this.doGetState();
                break;
            }
            default: {
                super.onStateFaultyReceived(n, asiaDatabaseState, asiaStateProxy, asiaDatabase);
            }
        }
    }
}

