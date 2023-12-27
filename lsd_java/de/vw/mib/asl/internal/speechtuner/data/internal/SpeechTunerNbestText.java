/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.internal;

public class SpeechTunerNbestText {
    String firstEntry;
    String secondEntry;

    public SpeechTunerNbestText(String string, String string2) {
        this.firstEntry = string;
        this.secondEntry = string2;
    }

    public String getFirstEntry() {
        return this.firstEntry;
    }

    public String getSecondEntry() {
        return this.secondEntry;
    }
}

