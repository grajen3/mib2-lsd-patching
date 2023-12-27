/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionClient;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionState;
import de.vw.mib.collections.ObjectArrayList;

class AudioConnection {
    private final int connectionID;
    private AudioConnectionState state = null;
    private ObjectArrayList clients = null;

    AudioConnection(int n, AudioConnectionClient audioConnectionClient) {
        this(n, audioConnectionClient, AudioConnectionState.IDLE);
    }

    AudioConnection(int n, AudioConnectionClient audioConnectionClient, AudioConnectionState audioConnectionState) {
        this.state = audioConnectionState;
        this.connectionID = n;
        this.addClient(audioConnectionClient);
    }

    void addClient(AudioConnectionClient audioConnectionClient) {
        if (audioConnectionClient != null) {
            if (this.clients == null) {
                this.clients = new ObjectArrayList(1);
            }
            if (!this.clients.contains(audioConnectionClient)) {
                this.clients.add(audioConnectionClient);
            }
            audioConnectionClient.updateAudioConnectionState(this.connectionID, this.state);
        }
    }

    void removeClient(AudioConnectionClient audioConnectionClient) {
        if (audioConnectionClient != null && this.clients.contains(audioConnectionClient)) {
            this.clients.removeValue(audioConnectionClient);
        }
    }

    void removeALLClients() {
        if (this.clients != null) {
            this.clients.clear();
        }
    }

    AudioConnectionState getAudioConnectionState() {
        return this.state;
    }

    void setAudioConnectionState(AudioConnectionState audioConnectionState) {
        this.state = audioConnectionState;
        if (this.clients != null) {
            for (int i2 = 0; i2 < this.clients.size(); ++i2) {
                ((AudioConnectionClient)this.clients.get(i2)).updateAudioConnectionState(this.connectionID, this.state);
            }
        }
    }

    boolean hasMoreClients() {
        return this.clients != null && !this.clients.isEmpty();
    }

    int getNumberOfClients() {
        if (this.clients == null) {
            return 0;
        }
        return this.clients.size();
    }

    int getConnectionID() {
        return this.connectionID;
    }
}

