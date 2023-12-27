/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionClient;

public interface AudioConnectionProvider {
    default public void requestConnection(int n, AudioConnectionClient audioConnectionClient) {
    }

    default public void releaseConnection(int n, AudioConnectionClient audioConnectionClient) {
    }
}

