/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.audio;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;
import de.vw.mib.asi.ASIListener;

public interface ASIAudioListener
extends ASIListener {
    default public void updateA2LSState(A2LSState a2LSState, boolean bl) {
    }

    default public void updateAudibleState(int n, boolean bl) {
    }

    default public void updateAudioContext(AudioState audioState, boolean bl) {
    }

    default public void updateFrontAudioContext(AudioState audioState, boolean bl) {
    }

    default public void updateVolume(int n, boolean bl) {
    }

    default public void updateVolumeLockState(VolumeLockState volumeLockState, boolean bl) {
    }

    default public void updateVolumeRange(VolumeRange volumeRange, boolean bl) {
    }
}

