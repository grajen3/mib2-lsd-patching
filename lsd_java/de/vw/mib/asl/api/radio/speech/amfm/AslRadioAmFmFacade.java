/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.speech.amfm;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;
import de.vw.mib.asl.api.radio.speech.amfm.AmFmTuningResponseListener;
import de.vw.mib.asl.api.radio.speech.amfm.FmStationListListener;

public interface AslRadioAmFmFacade {
    default public void tuneStation(AmFmStation amFmStation, AmFmTuningResponseListener amFmTuningResponseListener) {
    }

    default public AmFmStation[] registerForFmStationList(FmStationListListener fmStationListListener) {
    }
}

