/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils.callbacks;

import de.vw.mib.asl.api.radio.speech.TuningResponse;

public interface TuningCallback {
    default public void onTuningResponse(TuningResponse tuningResponse) {
    }
}

