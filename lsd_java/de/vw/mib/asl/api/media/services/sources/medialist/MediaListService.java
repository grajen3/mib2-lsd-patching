/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.sources.medialist;

import de.vw.mib.asl.api.media.services.sources.medialist.MediaListListener;

public interface MediaListService {
    default public void addSourceStateListener(MediaListListener mediaListListener) {
    }
}

