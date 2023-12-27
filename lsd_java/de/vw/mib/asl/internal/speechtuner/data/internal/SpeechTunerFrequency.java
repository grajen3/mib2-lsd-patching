/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.internal;

import de.vw.mib.asl.internal.speechtuner.utils.RadioUtils;

public abstract class SpeechTunerFrequency {
    protected final RadioUtils radioUtils;
    protected final int frequency;
    protected final int hdSubChannel;

    public SpeechTunerFrequency(RadioUtils radioUtils, int n, int n2) {
        this.radioUtils = radioUtils;
        this.frequency = n;
        this.hdSubChannel = n2;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getHdSubChannel() {
        return this.hdSubChannel;
    }

    public abstract int getBand() {
    }

    public abstract String getFrequencyText() {
    }

    public abstract int getConvertedHdSubChannel() {
    }
}

