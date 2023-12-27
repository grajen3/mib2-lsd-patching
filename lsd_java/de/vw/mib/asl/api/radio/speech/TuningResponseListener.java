/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.speech;

import de.vw.mib.asl.api.radio.speech.TuningResponse;

public interface TuningResponseListener {
    default public void tuningResponse(TuningResponse tuningResponse) {
    }
}

