/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.browser.transformer;

import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import generated.de.vw.mib.asl.internal.avdc.audio.browser.transformer.AbstractAVDCAudioBrowserPartitionInfoListTransformer;

public class AVDCAudioBrowserPartitionInfoListTransformer
extends AbstractAVDCAudioBrowserPartitionInfoListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        MediaCollector mediaCollector = (MediaCollector)object;
        switch (n) {
            case 0: {
                return mediaCollector.isMediaActive();
            }
            case 1: {
                return mediaCollector.isUserAvailable();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        MediaCollector mediaCollector = (MediaCollector)object;
        switch (n) {
            case 3: {
                return mediaCollector.getObjectId();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        MediaCollector mediaCollector = (MediaCollector)object;
        switch (n) {
            case 2: {
                return mediaCollector.getName();
            }
        }
        throw new IllegalArgumentException();
    }
}

