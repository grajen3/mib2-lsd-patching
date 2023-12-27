/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.speech.amfm;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;
import de.vw.mib.asl.api.radio.speech.TuningResponse;

public interface AmFmTuningResponse
extends TuningResponse {
    default public AmFmStation getAmFmStation() {
    }
}

