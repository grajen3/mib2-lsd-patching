/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio.start;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProvider;

public interface AudioProviderCallback {
    default public void onAudioProviderReady(AudioConnectionProvider audioConnectionProvider) {
    }
}

