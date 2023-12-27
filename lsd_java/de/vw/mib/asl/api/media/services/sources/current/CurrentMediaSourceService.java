/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.sources.current;

import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceListener;

public interface CurrentMediaSourceService {
    default public void registerListener(CurrentMediaSourceListener currentMediaSourceListener) {
    }
}

