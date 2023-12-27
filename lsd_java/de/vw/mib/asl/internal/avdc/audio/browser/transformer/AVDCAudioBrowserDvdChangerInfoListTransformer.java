/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.browser.transformer;

import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import generated.de.vw.mib.asl.internal.avdc.audio.browser.transformer.AbstractAVDCAudioBrowserDvdChangerInfoListTransformer;

public class AVDCAudioBrowserDvdChangerInfoListTransformer
extends AbstractAVDCAudioBrowserDvdChangerInfoListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        MediaCollector mediaCollector = (MediaCollector)object;
        switch (n) {
            case 0: {
                return mediaCollector.isMediaActive();
            }
            case 1: {
                return mediaCollector.isMediaPlayable();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public int getInt(int n, Object object) {
        MediaCollector mediaCollector = (MediaCollector)object;
        switch (n) {
            case 2: {
                if (mediaCollector.isCDDA()) {
                    return 2;
                }
                if (mediaCollector.isDVDVideo()) {
                    return 3;
                }
                if (mediaCollector.isDVDAudio()) {
                    return 4;
                }
                return 0;
            }
            case 5: {
                switch (mediaCollector.getMediaType()) {
                    case 12: {
                        return 4;
                    }
                    case 10: {
                        return 0;
                    }
                    case 15: {
                        return 2;
                    }
                }
                if (mediaCollector.isMediaPlayable()) {
                    return 1;
                }
                return 3;
            }
            case 4: {
                return mediaCollector.getSlotNumber();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public String getString(int n, Object object) {
        MediaCollector mediaCollector = (MediaCollector)object;
        switch (n) {
            case 3: {
                return mediaCollector.getName();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }
}

