/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;
import de.vw.mib.asl.api.radio.speech.amfm.AmFmTuningResponse;

public class AmFmTuningResponseImpl
implements AmFmTuningResponse {
    private int result = 2;
    private AmFmStation requestedSpeechStation;

    @Override
    public int getResultState() {
        return this.result;
    }

    @Override
    public AmFmStation getAmFmStation() {
        return this.requestedSpeechStation;
    }

    public void setResultState(int n) {
        this.result = n;
    }

    public void setAmFmStation(AmFmStation amFmStation) {
        this.requestedSpeechStation = amFmStation;
    }
}

