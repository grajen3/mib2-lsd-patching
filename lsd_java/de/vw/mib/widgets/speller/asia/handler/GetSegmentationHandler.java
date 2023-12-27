/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractDistinguishableStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public final class GetSegmentationHandler
extends AbstractDistinguishableStateHandler {
    private String phrase = "";

    public GetSegmentationHandler(int n) {
        super(n);
    }

    public void setPhrase(String string) {
        this.phrase = string;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        if (this.isCaseToHandle(0) && this.phrase != null && this.phrase.length() > 0) {
            intObjectMap.put(0, this.phrase);
            asiaStateProxy.getState(64, intObjectMap, this);
        } else if (this.isCaseToHandle(1)) {
            asiaStateProxy.getState(64, this);
        } else {
            this.doGetNextState();
        }
    }

    @Override
    protected void onReset() {
        super.onReset();
        this.setPhrase(null);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        this.fireStringEvent("wordSegmentationAvailable", asiaDatabaseState.getSegmentation());
    }

    @Override
    protected void onStateFaultyReceived(int n, AsiaDatabaseState asiaDatabaseState, AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        switch (n) {
            case 27: {
                LOGGER.warn(64).append(super.getClass().getName()).append(": Invalid symbols in the to be segmented phrase detected!").log();
                this.fireStringEvent("wordSegmentationAvailable", "");
                break;
            }
            default: {
                super.onStateFaultyReceived(n, asiaDatabaseState, asiaStateProxy, asiaDatabase);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        return stringBuilder.append("[phrase='").append(this.phrase).append("']").toString();
    }
}

