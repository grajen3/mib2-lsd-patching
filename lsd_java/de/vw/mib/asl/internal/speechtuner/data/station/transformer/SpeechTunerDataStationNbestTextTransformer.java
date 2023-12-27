/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.station.transformer;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerNbestText;
import generated.de.vw.mib.asl.internal.speechtuner.data.station.transformer.AbstractSpeechTunerDataStationNbestTextTransformer;

public class SpeechTunerDataStationNbestTextTransformer
extends AbstractSpeechTunerDataStationNbestTextTransformer {
    @Override
    public String getString(int n, Object object) {
        SpeechTunerNbestText speechTunerNbestText = (SpeechTunerNbestText)object;
        switch (n) {
            case 0: {
                return speechTunerNbestText.getFirstEntry();
            }
            case 1: {
                return speechTunerNbestText.getSecondEntry();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

