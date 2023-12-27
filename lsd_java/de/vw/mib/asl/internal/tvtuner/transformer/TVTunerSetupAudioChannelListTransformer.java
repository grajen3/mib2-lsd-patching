/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.transformer;

import de.vw.mib.asl.internal.tvtuner.collector.TVSetupAudioChannelListCollector;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.AbstractTVTunerSetupAudioChannelListTransformer;

public class TVTunerSetupAudioChannelListTransformer
extends AbstractTVTunerSetupAudioChannelListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((TVSetupAudioChannelListCollector)object).getIso639_2LanguageCode();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        if (n == 1) {
            return ((TVSetupAudioChannelListCollector)object).getAudioFormat();
        }
        if (n == 2) {
            return ((TVSetupAudioChannelListCollector)object).getAudioDescription();
        }
        throw new IllegalArgumentException();
    }
}

