/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.internal;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFrequency;
import de.vw.mib.asl.internal.speechtuner.utils.RadioUtils;

public class SpeechTunerAMFrequency
extends SpeechTunerFrequency {
    public SpeechTunerAMFrequency(RadioUtils radioUtils, int n, int n2) {
        super(radioUtils, n, n2);
    }

    @Override
    public String getFrequencyText() {
        return this.radioUtils.getStringFromFrequencyWithoutUnit(this);
    }

    @Override
    public int getConvertedHdSubChannel() {
        return this.radioUtils.getOutputHDSubchannelAM(this.hdSubChannel);
    }

    @Override
    public int getBand() {
        return 0;
    }
}

