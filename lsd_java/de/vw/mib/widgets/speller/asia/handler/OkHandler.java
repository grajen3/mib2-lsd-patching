/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.handler.TransferSymbolsUnconvertedHandler;

public class OkHandler
extends TransferSymbolsUnconvertedHandler {
    private final boolean transferSymbolsUnconvertedBefore;

    public OkHandler() {
        this(false);
    }

    public OkHandler(boolean bl) {
        this.transferSymbolsUnconvertedBefore = bl;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        if (this.transferSymbolsUnconvertedBefore) {
            super.doGetState(asiaStateProxy, asiaDatabase);
        } else {
            this.fireSpellerEvent("okPressed", "", 0, 0, 0);
            this.doGetNextState();
        }
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        super.onStateSuccessfullyReceived(asiaDatabaseState, asiaDatabase);
        this.fireSpellerEvent("okPressed", "", 0, 0, 0);
    }
}

