/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.internal;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerStation;

public class SpeechTunerFMStation
extends SpeechTunerStation {
    private int frequency = 0;

    public SpeechTunerFMStation(String string, int n) {
        super(string, n);
    }

    public SpeechTunerFMStation(long l, String string, int n) {
        this.objectID = l;
        this.name = string;
        this.frequency = n;
    }

    public int getFrequency() {
        return this.frequency;
    }
}

