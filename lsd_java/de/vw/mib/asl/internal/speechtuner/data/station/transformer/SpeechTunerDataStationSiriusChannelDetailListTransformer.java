/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.station.transformer;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerSiriusChannel;
import generated.de.vw.mib.asl.internal.speechtuner.data.station.transformer.AbstractSpeechTunerDataStationSiriusChannelDetailListTransformer;

public class SpeechTunerDataStationSiriusChannelDetailListTransformer
extends AbstractSpeechTunerDataStationSiriusChannelDetailListTransformer {
    @Override
    public int getInt(int n, Object object) {
        SpeechTunerSiriusChannel speechTunerSiriusChannel = (SpeechTunerSiriusChannel)object;
        switch (n) {
            case 2: {
                return speechTunerSiriusChannel.getChannelNumber();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        SpeechTunerSiriusChannel speechTunerSiriusChannel = (SpeechTunerSiriusChannel)object;
        switch (n) {
            case 0: {
                return speechTunerSiriusChannel.getObjectID();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        SpeechTunerSiriusChannel speechTunerSiriusChannel = (SpeechTunerSiriusChannel)object;
        switch (n) {
            case 1: {
                return speechTunerSiriusChannel.getName();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

