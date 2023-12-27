/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioS;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncAudioAbstractBaseService
implements ASIHMISyncAudioS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.audio.ASIHMISyncAudio");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private AudioState AudioContext;
    private boolean AudioContext_valid = false;
    private AudioState FrontAudioContext;
    private boolean FrontAudioContext_valid = false;
    private VolumeLockState VolumeLockState;
    private boolean VolumeLockState_valid = false;
    private A2LSState A2LSState;
    private boolean A2LSState_valid = false;
    private VolumeRange VolumeRange;
    private boolean VolumeRange_valid = false;
    private int Volume;
    private boolean Volume_valid = false;
    private int AudibleState;
    private boolean AudibleState_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static AudioState copyAudioState(AudioState audioState) {
        if (audioState == null) {
            return null;
        }
        AudioState audioState2 = new AudioState();
        audioState2.audioContext = audioState.audioContext;
        audioState2.audioState = audioState.audioState;
        return audioState2;
    }

    public static VolumeLockState copyVolumeLockState(VolumeLockState volumeLockState) {
        if (volumeLockState == null) {
            return null;
        }
        VolumeLockState volumeLockState2 = new VolumeLockState();
        volumeLockState2.audioContext = volumeLockState.audioContext;
        volumeLockState2.state = volumeLockState.state;
        return volumeLockState2;
    }

    public static A2LSState copyA2LSState(A2LSState a2LSState) {
        if (a2LSState == null) {
            return null;
        }
        A2LSState a2LSState2 = new A2LSState();
        a2LSState2.currentDevice = ASIHMISyncAudioAbstractBaseService.copyString(a2LSState.currentDevice);
        a2LSState2.requestingDevice = ASIHMISyncAudioAbstractBaseService.copyString(a2LSState.requestingDevice);
        return a2LSState2;
    }

    public static VolumeRange copyVolumeRange(VolumeRange volumeRange) {
        if (volumeRange == null) {
            return null;
        }
        VolumeRange volumeRange2 = new VolumeRange();
        volumeRange2.min = volumeRange.min;
        volumeRange2.max = volumeRange.max;
        return volumeRange2;
    }

    public ASIHMISyncAudioAbstractBaseService() {
        ASIHMISyncAudioAbstractBaseService$AttributesBitMapProvider aSIHMISyncAudioAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncAudioAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncAudio", aSIHMISyncAudioAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncAudioReply);
        this.sendAttributeUpdate(l, aSIHMISyncAudioReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.baseService.setNotification(aSIHMISyncAudioReply);
        this.sendAttributeUpdate(aSIHMISyncAudioReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncAudioReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncAudioReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncAudioReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.baseService.clearNotification(aSIHMISyncAudioReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncAudioReply);
    }

    private void sendAttributeUpdate(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        try {
            aSIHMISyncAudioReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncAudioReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncAudioReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncAudioReply.updateAudioContext(this.AudioContext, this.AudioContext_valid);
            aSIHMISyncAudioReply.updateFrontAudioContext(this.FrontAudioContext, this.FrontAudioContext_valid);
            aSIHMISyncAudioReply.updateVolumeLockState(this.VolumeLockState, this.VolumeLockState_valid);
            aSIHMISyncAudioReply.updateA2LSState(this.A2LSState, this.A2LSState_valid);
            aSIHMISyncAudioReply.updateVolumeRange(this.VolumeRange, this.VolumeRange_valid);
            aSIHMISyncAudioReply.updateVolume(this.Volume, this.Volume_valid);
            aSIHMISyncAudioReply.updateAudibleState(this.AudibleState, this.AudibleState_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncAudioReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        try {
            if (l == 0) {
                aSIHMISyncAudioReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncAudioReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncAudioReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncAudioReply.updateAudioContext(this.AudioContext, this.AudioContext_valid);
            } else if (l == 0) {
                aSIHMISyncAudioReply.updateFrontAudioContext(this.FrontAudioContext, this.FrontAudioContext_valid);
            } else if (l == 0) {
                aSIHMISyncAudioReply.updateVolumeLockState(this.VolumeLockState, this.VolumeLockState_valid);
            } else if (l == 0) {
                aSIHMISyncAudioReply.updateA2LSState(this.A2LSState, this.A2LSState_valid);
            } else if (l == 0) {
                aSIHMISyncAudioReply.updateVolumeRange(this.VolumeRange, this.VolumeRange_valid);
            } else if (l == 0) {
                aSIHMISyncAudioReply.updateVolume(this.Volume, this.Volume_valid);
            } else if (l == 0) {
                aSIHMISyncAudioReply.updateAudibleState(this.AudibleState, this.AudibleState_valid);
            } else {
                System.out.println("unexpected");
            }
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    public void updateASIVersion(String string) {
        this.updateASIVersion(string, true);
    }

    public void updateASIVersion(String string, boolean bl) {
        this.ASIVersion = ASIHMISyncAudioAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(13);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            try {
                aSIHMISyncAudioReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRequestIDs(short[] sArray) {
        this.updateRequestIDs(sArray, true);
    }

    public void updateRequestIDs(short[] sArray, boolean bl) {
        if (sArray != null) {
            this.RequestIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.RequestIDs, 0, sArray.length);
        } else {
            this.RequestIDs = null;
        }
        this.RequestIDs_valid = bl;
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            try {
                aSIHMISyncAudioReply.updateRequestIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateReplyIDs(short[] sArray) {
        this.updateReplyIDs(sArray, true);
    }

    public void updateReplyIDs(short[] sArray, boolean bl) {
        if (sArray != null) {
            this.ReplyIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.ReplyIDs, 0, sArray.length);
        } else {
            this.ReplyIDs = null;
        }
        this.ReplyIDs_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            try {
                aSIHMISyncAudioReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAudioContext(AudioState audioState) {
        this.updateAudioContext(audioState, true);
    }

    public void updateAudioContext(AudioState audioState, boolean bl) {
        this.AudioContext = ASIHMISyncAudioAbstractBaseService.copyAudioState(audioState);
        this.AudioContext_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            try {
                aSIHMISyncAudioReply.updateAudioContext(audioState, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateFrontAudioContext(AudioState audioState) {
        this.updateFrontAudioContext(audioState, true);
    }

    public void updateFrontAudioContext(AudioState audioState, boolean bl) {
        this.FrontAudioContext = ASIHMISyncAudioAbstractBaseService.copyAudioState(audioState);
        this.FrontAudioContext_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            try {
                aSIHMISyncAudioReply.updateFrontAudioContext(audioState, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVolumeLockState(VolumeLockState volumeLockState) {
        this.updateVolumeLockState(volumeLockState, true);
    }

    public void updateVolumeLockState(VolumeLockState volumeLockState, boolean bl) {
        this.VolumeLockState = ASIHMISyncAudioAbstractBaseService.copyVolumeLockState(volumeLockState);
        this.VolumeLockState_valid = bl;
        List list = this.baseService.getNotifications(25);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            try {
                aSIHMISyncAudioReply.updateVolumeLockState(volumeLockState, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateA2LSState(A2LSState a2LSState) {
        this.updateA2LSState(a2LSState, true);
    }

    public void updateA2LSState(A2LSState a2LSState, boolean bl) {
        this.A2LSState = ASIHMISyncAudioAbstractBaseService.copyA2LSState(a2LSState);
        this.A2LSState_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            try {
                aSIHMISyncAudioReply.updateA2LSState(a2LSState, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVolumeRange(VolumeRange volumeRange) {
        this.updateVolumeRange(volumeRange, true);
    }

    public void updateVolumeRange(VolumeRange volumeRange, boolean bl) {
        this.VolumeRange = ASIHMISyncAudioAbstractBaseService.copyVolumeRange(volumeRange);
        this.VolumeRange_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            try {
                aSIHMISyncAudioReply.updateVolumeRange(volumeRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVolume(int n) {
        this.updateVolume(n, true);
    }

    public void updateVolume(int n, boolean bl) {
        this.Volume = n;
        this.Volume_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            try {
                aSIHMISyncAudioReply.updateVolume(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAudibleState(int n) {
        this.updateAudibleState(n, true);
    }

    public void updateAudibleState(int n, boolean bl) {
        this.AudibleState = n;
        this.AudibleState_valid = bl;
        List list = this.baseService.getNotifications(24);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            try {
                aSIHMISyncAudioReply.updateAudibleState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

