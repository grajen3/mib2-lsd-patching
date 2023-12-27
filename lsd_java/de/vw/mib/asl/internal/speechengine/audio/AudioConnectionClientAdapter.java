/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

public interface AudioConnectionClientAdapter {
    default public void onAudioConnectionReleased(int n) {
    }

    default public void onAudioConnectionReserved(int n) {
    }

    default public void onAudioConnectionLost(int n) {
    }
}

