/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.TransferSymbolsUnconvertedHandler;

public class SwitchToHWRStateHandler
extends TransferSymbolsUnconvertedHandler {
    private boolean shouldTakeOver = false;

    public void setShouldTakeOver(boolean bl) {
        this.shouldTakeOver = bl;
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        if (this.shouldTakeOver) {
            super.onStateSuccessfullyReceived(asiaDatabaseState, asiaDatabase);
        }
    }
}

