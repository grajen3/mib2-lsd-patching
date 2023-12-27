/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound.transformer;

import de.vw.mib.asl.internal.sound.transformer.SoundEqualizerBandCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.AbstractSoundEqualizerBandTransformer;

public class SoundEqualizerBandTransformer
extends AbstractSoundEqualizerBandTransformer {
    @Override
    public int getInt(int n, Object object) {
        SoundEqualizerBandCollector soundEqualizerBandCollector = (SoundEqualizerBandCollector)object;
        switch (n) {
            case 1: {
                return soundEqualizerBandCollector.sound_equalizer_band_frequency;
            }
            case 0: {
                return soundEqualizerBandCollector.sound_equalizer_band_value;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

