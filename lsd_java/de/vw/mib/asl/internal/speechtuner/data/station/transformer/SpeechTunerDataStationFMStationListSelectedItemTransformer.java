/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.station.transformer;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFMStation;
import generated.de.vw.mib.asl.internal.speechtuner.data.station.transformer.AbstractSpeechTunerDataStationFMStationListSelectedItemTransformer;

public class SpeechTunerDataStationFMStationListSelectedItemTransformer
extends AbstractSpeechTunerDataStationFMStationListSelectedItemTransformer {
    @Override
    public int getInt(int n, Object object) {
        SpeechTunerFMStation speechTunerFMStation = (SpeechTunerFMStation)object;
        switch (n) {
            case 8: {
                return speechTunerFMStation.getFrequency();
            }
            case 6: {
                return speechTunerFMStation.getNumberOfSubitems();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        SpeechTunerFMStation speechTunerFMStation = (SpeechTunerFMStation)object;
        switch (n) {
            case 5: {
                return speechTunerFMStation.getObjectID();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        SpeechTunerFMStation speechTunerFMStation = (SpeechTunerFMStation)object;
        switch (n) {
            case 7: {
                return speechTunerFMStation.getName();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

