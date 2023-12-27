/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.video.dvd.transformer;

import de.vw.mib.asl.internal.avdc.video.dvd.transformer.DVDAudioChannelCollector;
import generated.de.vw.mib.asl.internal.avdc.video.dvd.transformer.AbstractAVDCVideoDVDAvailableDVDAudioChannelsTransformer;

public class AVDCVideoDVDAvailableDVDAudioChannelsTransformer
extends AbstractAVDCVideoDVDAvailableDVDAudioChannelsTransformer {
    @Override
    public int getInt(int n, Object object) {
        DVDAudioChannelCollector dVDAudioChannelCollector = (DVDAudioChannelCollector)object;
        switch (n) {
            case 0: {
                return dVDAudioChannelCollector.languageCode;
            }
            case 1: {
                return dVDAudioChannelCollector.audioLanguageExtension;
            }
            case 2: {
                return dVDAudioChannelCollector.numChannels;
            }
            case 3: {
                return dVDAudioChannelCollector.audioCoding;
            }
        }
        throw new IllegalArgumentException();
    }
}

