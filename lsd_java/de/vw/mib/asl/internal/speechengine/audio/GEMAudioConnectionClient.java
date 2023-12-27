/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionClient;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProvider;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionState;

public class GEMAudioConnectionClient
extends AudioConnectionClient {
    public GEMAudioConnectionClient(AudioConnectionProvider audioConnectionProvider) {
        super(audioConnectionProvider);
    }

    @Override
    public int getClientID() {
        return 2;
    }

    @Override
    public void updateAudioConnectionState(int n, AudioConnectionState audioConnectionState) {
    }

    void requestSpeechOutputConnection() {
        this.audioConnectionProvider.requestConnection(112, this);
    }

    void releaseSpeechOutputConnection() {
        this.audioConnectionProvider.releaseConnection(112, this);
    }
}

