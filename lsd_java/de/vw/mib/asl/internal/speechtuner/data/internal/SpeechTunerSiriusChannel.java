/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.internal;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerStation;

public class SpeechTunerSiriusChannel
extends SpeechTunerStation {
    private int channelNumber;

    public SpeechTunerSiriusChannel(String string, int n) {
        super(string, n);
    }

    public SpeechTunerSiriusChannel(long l, String string, int n) {
        this.objectID = l;
        this.name = string;
        this.channelNumber = n;
    }

    public int getChannelNumber() {
        return this.channelNumber;
    }
}

