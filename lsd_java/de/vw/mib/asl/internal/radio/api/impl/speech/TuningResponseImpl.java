/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.radio.speech.TuningResponse;

public class TuningResponseImpl
implements TuningResponse {
    private int result = 2;

    @Override
    public int getResultState() {
        return this.result;
    }

    public void setResultState(int n) {
        this.result = n;
    }
}

