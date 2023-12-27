/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.player;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.SourceCallback;
import de.vw.mib.asl.api.media.services.player.MediaActivationStateListener;
import de.vw.mib.asl.api.media.services.player.MediaPlaySimilarListener;
import de.vw.mib.asl.api.media.services.player.MediaPlayViewListener;
import de.vw.mib.asl.api.media.services.sources.SourceId;

public interface MediaPlayerService {
    default public void addMediaPlayViewListener(MediaPlayViewListener mediaPlayViewListener) {
    }

    default public void addMediaPlaySimilarListener(MediaPlaySimilarListener mediaPlaySimilarListener) {
    }

    default public void addMediaActivationStateListener(MediaActivationStateListener mediaActivationStateListener) {
    }

    default public void activateMediaSource(SourceId sourceId, Callback callback) {
    }

    default public void activateMediaSource(SourceId sourceId, SourceCallback sourceCallback) {
    }

    default public void activateMediaSourceByHasId(int n, SourceCallback sourceCallback) {
    }

    default public void playSimilar(Callback callback) {
    }
}

