/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionClient;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProvider;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionState;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.AbstractDialog;

public class DialogAudioConnectionClient
extends AudioConnectionClient {
    public DialogAudioConnectionClient(AbstractDialog abstractDialog, AudioConnectionProvider audioConnectionProvider) {
        super(audioConnectionProvider);
    }

    public void requestConnections(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.audioConnectionProvider.requestConnection(nArray[i2], this);
        }
    }

    public void releaseConnections(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.audioConnectionProvider.releaseConnection(nArray[i2], this);
        }
    }

    @Override
    public void updateAudioConnectionState(int n, AudioConnectionState audioConnectionState) {
        if (AudioConnectionState.ACTIVE.equals(audioConnectionState)) {
            this.onAudioConnectionReserved(n);
        }
        if (AudioConnectionState.RELEASED.isEqualTo(audioConnectionState)) {
            this.onAudioConnectionReleased(n);
        }
        if (AudioConnectionState.LOST.isEqualTo(audioConnectionState)) {
            this.onAudioConnectionLost(n);
        }
    }

    @Override
    public int getClientID() {
        return 3;
    }
}

