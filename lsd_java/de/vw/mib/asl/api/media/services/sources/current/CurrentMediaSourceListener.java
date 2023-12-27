/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.sources.current;

import de.vw.mib.asl.api.media.services.sources.medialist.Source;

public interface CurrentMediaSourceListener {
    default public void updateCurrentMediaSource(Source source) {
    }
}

