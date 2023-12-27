/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.frequency.transformer;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerAMFrequency;
import generated.de.vw.mib.asl.internal.speechtuner.data.frequency.transformer.AbstractSpeechTunerDataFrequencyAMFrequencyAndSubchannelTransformer;

public class SpeechTunerDataFrequencyAMFrequencyAndSubchannelTransformer
extends AbstractSpeechTunerDataFrequencyAMFrequencyAndSubchannelTransformer {
    @Override
    public int getInt(int n, Object object) {
        SpeechTunerAMFrequency speechTunerAMFrequency = (SpeechTunerAMFrequency)object;
        switch (n) {
            case 1: {
                return speechTunerAMFrequency.getConvertedHdSubChannel();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        SpeechTunerAMFrequency speechTunerAMFrequency = (SpeechTunerAMFrequency)object;
        switch (n) {
            case 0: {
                return speechTunerAMFrequency.getFrequencyText();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

