/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.station.transformer;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFMStation;
import generated.de.vw.mib.asl.internal.speechtuner.data.station.transformer.AbstractSpeechTunerDataStationFMStationDetailListTransformer;

public class SpeechTunerDataStationFMStationDetailListTransformer
extends AbstractSpeechTunerDataStationFMStationDetailListTransformer {
    @Override
    public int getInt(int n, Object object) {
        SpeechTunerFMStation speechTunerFMStation = (SpeechTunerFMStation)object;
        switch (n) {
            case 5: {
                return speechTunerFMStation.getFrequency();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        SpeechTunerFMStation speechTunerFMStation = (SpeechTunerFMStation)object;
        switch (n) {
            case 3: {
                return speechTunerFMStation.getObjectID();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        SpeechTunerFMStation speechTunerFMStation = (SpeechTunerFMStation)object;
        switch (n) {
            case 4: {
                return speechTunerFMStation.getName();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

