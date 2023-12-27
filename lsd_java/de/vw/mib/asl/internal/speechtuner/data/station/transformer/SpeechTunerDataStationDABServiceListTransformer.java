/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.station.transformer;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerDABService;
import generated.de.vw.mib.asl.internal.speechtuner.data.station.transformer.AbstractSpeechTunerDataStationDABServiceListTransformer;

public class SpeechTunerDataStationDABServiceListTransformer
extends AbstractSpeechTunerDataStationDABServiceListTransformer {
    @Override
    public int getInt(int n, Object object) {
        SpeechTunerDABService speechTunerDABService = (SpeechTunerDABService)object;
        switch (n) {
            case 1: {
                return speechTunerDABService.getNumberOfSubitems();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        SpeechTunerDABService speechTunerDABService = (SpeechTunerDABService)object;
        switch (n) {
            case 0: {
                return speechTunerDABService.getObjectID();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        SpeechTunerDABService speechTunerDABService = (SpeechTunerDABService)object;
        switch (n) {
            case 2: {
                return speechTunerDABService.getName();
            }
            case 3: {
                return speechTunerDABService.getEnsembleName();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

