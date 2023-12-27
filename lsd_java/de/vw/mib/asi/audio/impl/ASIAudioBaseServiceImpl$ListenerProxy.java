/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.audio.ASIAudioListener;
import de.vw.mib.asi.audio.impl.ASIAudioBaseServiceImpl;

class ASIAudioBaseServiceImpl$ListenerProxy
implements ASIAudioListener {
    private final /* synthetic */ ASIAudioBaseServiceImpl this$0;

    ASIAudioBaseServiceImpl$ListenerProxy(ASIAudioBaseServiceImpl aSIAudioBaseServiceImpl) {
        this.this$0 = aSIAudioBaseServiceImpl;
    }

    @Override
    public void updateA2LSState(A2LSState a2LSState, boolean bl) {
        try {
            this.this$0.updateA2LSState(a2LSState, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateAudibleState(int n, boolean bl) {
        try {
            this.this$0.updateAudibleState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateAudioContext(AudioState audioState, boolean bl) {
        try {
            this.this$0.updateAudioContext(audioState, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateFrontAudioContext(AudioState audioState, boolean bl) {
        try {
            this.this$0.updateFrontAudioContext(audioState, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateVolume(int n, boolean bl) {
        try {
            this.this$0.updateVolume(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateVolumeLockState(VolumeLockState volumeLockState, boolean bl) {
        try {
            this.this$0.updateVolumeLockState(volumeLockState, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateVolumeRange(VolumeRange volumeRange, boolean bl) {
        try {
            this.this$0.updateVolumeRange(volumeRange, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

