/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.japan.RomajiFreeState;

class RomajiFreeState$3
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private final /* synthetic */ RomajiFreeState this$0;

    RomajiFreeState$3(RomajiFreeState romajiFreeState) {
        this.this$0 = romajiFreeState;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        String string = this.this$0.getNextValidRomajis();
        if (LOGGER.isTraceEnabled(64)) {
            LOGGER.trace(64).append(super.getClass().getName()).append(new StringBuffer().append(": Setting next valid Romajis: '").append(string).append("'").toString()).log();
        }
        this.getState().getWidget().updateSpellerButtons(string, "");
        this.doGetNextState();
    }
}

