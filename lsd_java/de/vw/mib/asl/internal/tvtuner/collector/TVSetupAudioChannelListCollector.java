/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.collector;

public class TVSetupAudioChannelListCollector {
    private String iso639_2LanguageCode;
    private int audioFormat;
    private int audioDescription;

    public TVSetupAudioChannelListCollector() {
        this.iso639_2LanguageCode = "";
        this.audioFormat = 0;
        this.audioDescription = 0;
    }

    public TVSetupAudioChannelListCollector(String string, int n, int n2) {
        this.iso639_2LanguageCode = string;
        this.audioFormat = n;
        this.audioDescription = n2;
    }

    public String getIso639_2LanguageCode() {
        return this.iso639_2LanguageCode;
    }

    public int getAudioFormat() {
        return this.audioFormat;
    }

    public int getAudioDescription() {
        return this.audioDescription;
    }
}

