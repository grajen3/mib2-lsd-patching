/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionClientAdapter;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProvider;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AudioConnectionClient {
    private List clientAdapters = new ArrayList(1);
    protected final AudioConnectionProvider audioConnectionProvider;

    public AudioConnectionClient(AudioConnectionProvider audioConnectionProvider) {
        this.audioConnectionProvider = audioConnectionProvider;
    }

    public abstract int getClientID() {
    }

    public void addClientAdapter(AudioConnectionClientAdapter audioConnectionClientAdapter) {
        if (!this.clientAdapters.contains(audioConnectionClientAdapter)) {
            this.clientAdapters.add(audioConnectionClientAdapter);
        }
    }

    public void removeClientAdapter(AudioConnectionClientAdapter audioConnectionClientAdapter) {
        if (this.clientAdapters.contains(audioConnectionClientAdapter)) {
            this.clientAdapters.remove(audioConnectionClientAdapter);
        }
    }

    public void onAudioConnectionReserved(int n) {
        ArrayList arrayList = new ArrayList(this.clientAdapters);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((AudioConnectionClientAdapter)iterator.next()).onAudioConnectionReserved(n);
        }
    }

    public void onAudioConnectionReleased(int n) {
        ArrayList arrayList = new ArrayList(this.clientAdapters);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((AudioConnectionClientAdapter)iterator.next()).onAudioConnectionReleased(n);
        }
    }

    public void onAudioConnectionLost(int n) {
        ArrayList arrayList = new ArrayList(this.clientAdapters);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((AudioConnectionClientAdapter)iterator.next()).onAudioConnectionLost(n);
        }
    }

    public abstract void updateAudioConnectionState(int n, AudioConnectionState audioConnectionState) {
    }
}

