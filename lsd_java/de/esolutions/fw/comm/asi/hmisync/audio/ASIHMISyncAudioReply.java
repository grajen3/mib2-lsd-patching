/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;

public interface ASIHMISyncAudioReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseEnableA2LS(int n) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateAudioContext(AudioState audioState, boolean bl) {
    }

    default public void updateFrontAudioContext(AudioState audioState, boolean bl) {
    }

    default public void updateVolumeLockState(VolumeLockState volumeLockState, boolean bl) {
    }

    default public void updateA2LSState(A2LSState a2LSState, boolean bl) {
    }

    default public void updateVolumeRange(VolumeRange volumeRange, boolean bl) {
    }

    default public void updateVolume(int n, boolean bl) {
    }

    default public void updateAudibleState(int n, boolean bl) {
    }
}

