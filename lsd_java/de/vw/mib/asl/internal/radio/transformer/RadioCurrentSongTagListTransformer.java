/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.api.itunes.model.CurrentSongTagCollector;
import de.vw.mib.asl.internal.list.ItemTransformer;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioCurrentSongTagListTransformer;

public class RadioCurrentSongTagListTransformer
extends AbstractRadioCurrentSongTagListTransformer
implements ItemTransformer {
    @Override
    public String getString(int n, Object object) {
        CurrentSongTagCollector currentSongTagCollector = (CurrentSongTagCollector)object;
        switch (n) {
            case 0: {
                return currentSongTagCollector.mArtist;
            }
            case 1: {
                return currentSongTagCollector.mTitle;
            }
        }
        throw new IllegalArgumentException();
    }
}

