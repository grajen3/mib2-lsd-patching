/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.internal;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFrequency;
import de.vw.mib.asl.internal.speechtuner.utils.RadioUtils;

public class SpeechTunerFMFrequency
extends SpeechTunerFrequency {
    private final boolean isHDOnly;

    public SpeechTunerFMFrequency(RadioUtils radioUtils, int n, int n2, boolean bl) {
        super(radioUtils, n, n2);
        this.isHDOnly = bl;
    }

    public boolean isHDOnly() {
        return this.isHDOnly;
    }

    @Override
    public String getFrequencyText() {
        return this.radioUtils.getStringFromFrequencyWithoutUnit(this);
    }

    @Override
    public int getConvertedHdSubChannel() {
        return this.radioUtils.getOutputHDSubchannelFM(this.hdSubChannel);
    }

    public String getFrequencyTextCombined() {
        return this.radioUtils.getStringFromFrequencyCombined(this);
    }

    @Override
    public int getBand() {
        return 1;
    }
}

