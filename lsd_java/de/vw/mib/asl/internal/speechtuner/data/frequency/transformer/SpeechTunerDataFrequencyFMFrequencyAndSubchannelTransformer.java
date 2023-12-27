/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.frequency.transformer;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFMFrequency;
import generated.de.vw.mib.asl.internal.speechtuner.data.frequency.transformer.AbstractSpeechTunerDataFrequencyFMFrequencyAndSubchannelTransformer;

public class SpeechTunerDataFrequencyFMFrequencyAndSubchannelTransformer
extends AbstractSpeechTunerDataFrequencyFMFrequencyAndSubchannelTransformer {
    @Override
    public int getInt(int n, Object object) {
        SpeechTunerFMFrequency speechTunerFMFrequency = (SpeechTunerFMFrequency)object;
        switch (n) {
            case 1: {
                return speechTunerFMFrequency.getConvertedHdSubChannel();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        SpeechTunerFMFrequency speechTunerFMFrequency = (SpeechTunerFMFrequency)object;
        switch (n) {
            case 0: {
                return speechTunerFMFrequency.getFrequencyText();
            }
            case 2: {
                return speechTunerFMFrequency.getFrequencyTextCombined();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

