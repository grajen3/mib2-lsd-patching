/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.TransferSymbolsUnconvertedHandler;

public class SpaceHandler
extends TransferSymbolsUnconvertedHandler {
    private final String SPACE = Character.toString(' ');

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        if (asiaDatabaseState.hasSpelling()) {
            super.onStateSuccessfullyReceived(asiaDatabaseState, asiaDatabase);
        } else {
            asiaDatabase.addPhrase(this.SPACE);
            int n = asiaDatabaseState.getCursorPosition();
            int n2 = n + 1;
            this.fireSpellerEvent("keyPressed", this.SPACE, n, n2, n2);
        }
    }
}

