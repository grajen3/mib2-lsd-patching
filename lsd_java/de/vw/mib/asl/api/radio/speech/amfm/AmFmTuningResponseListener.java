/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.speech.amfm;

import de.vw.mib.asl.api.radio.speech.TuningResponseListener;
import de.vw.mib.asl.api.radio.speech.amfm.AmFmTuningResponse;

public interface AmFmTuningResponseListener
extends TuningResponseListener {
    default public void tuningResponse(AmFmTuningResponse amFmTuningResponse) {
    }
}

