/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState;

final class CurrentAudioSourceState$1
implements Runnable {
    CurrentAudioSourceState$1() {
    }

    @Override
    public void run() {
        if (CurrentAudioSourceState.access$000() == 1) {
            CurrentAudioSourceState.set(3);
        } else if (CurrentAudioSourceState.access$000() == 6) {
            CurrentAudioSourceState.access$002(5);
            CurrentAudioSourceState.set(5);
        }
    }
}

