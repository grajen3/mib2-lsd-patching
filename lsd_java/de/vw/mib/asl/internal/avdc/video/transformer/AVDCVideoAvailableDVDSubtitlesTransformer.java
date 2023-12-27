/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.video.transformer;

import generated.de.vw.mib.asl.internal.avdc.video.transformer.AbstractAVDCVideoAvailableDVDSubtitlesTransformer;

public class AVDCVideoAvailableDVDSubtitlesTransformer
extends AbstractAVDCVideoAvailableDVDSubtitlesTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return (Integer)object;
            }
        }
        throw new IllegalArgumentException();
    }
}

