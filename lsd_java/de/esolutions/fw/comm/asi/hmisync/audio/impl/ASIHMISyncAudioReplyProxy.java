/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$11;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncAudioReplyProxy
implements ASIHMISyncAudioReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.audio.ASIHMISyncAudio");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncAudioReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("cd52f5cc-371d-43de-8bc4-c3df1c55f44a", -1, "0c5e00e4-2cbf-5dfc-acd3-5499fe013c7f", "asi.hmisync.audio.ASIHMISyncAudio");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseEnableA2LS(int n) {
        ASIHMISyncAudioReplyProxy$1 aSIHMISyncAudioReplyProxy$1 = new ASIHMISyncAudioReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)7, aSIHMISyncAudioReplyProxy$1);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncAudioReplyProxy$2 aSIHMISyncAudioReplyProxy$2 = new ASIHMISyncAudioReplyProxy$2(this, string, bl);
        this.proxy.remoteCallMethod((short)13, aSIHMISyncAudioReplyProxy$2);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncAudioReplyProxy$3 aSIHMISyncAudioReplyProxy$3 = new ASIHMISyncAudioReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)20, aSIHMISyncAudioReplyProxy$3);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncAudioReplyProxy$4 aSIHMISyncAudioReplyProxy$4 = new ASIHMISyncAudioReplyProxy$4(this, sArray, bl);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncAudioReplyProxy$4);
    }

    @Override
    public void updateAudioContext(AudioState audioState, boolean bl) {
        ASIHMISyncAudioReplyProxy$5 aSIHMISyncAudioReplyProxy$5 = new ASIHMISyncAudioReplyProxy$5(this, audioState, bl);
        this.proxy.remoteCallMethod((short)14, aSIHMISyncAudioReplyProxy$5);
    }

    @Override
    public void updateFrontAudioContext(AudioState audioState, boolean bl) {
        ASIHMISyncAudioReplyProxy$6 aSIHMISyncAudioReplyProxy$6 = new ASIHMISyncAudioReplyProxy$6(this, audioState, bl);
        this.proxy.remoteCallMethod((short)15, aSIHMISyncAudioReplyProxy$6);
    }

    @Override
    public void updateVolumeLockState(VolumeLockState volumeLockState, boolean bl) {
        ASIHMISyncAudioReplyProxy$7 aSIHMISyncAudioReplyProxy$7 = new ASIHMISyncAudioReplyProxy$7(this, volumeLockState, bl);
        this.proxy.remoteCallMethod((short)25, aSIHMISyncAudioReplyProxy$7);
    }

    @Override
    public void updateA2LSState(A2LSState a2LSState, boolean bl) {
        ASIHMISyncAudioReplyProxy$8 aSIHMISyncAudioReplyProxy$8 = new ASIHMISyncAudioReplyProxy$8(this, a2LSState, bl);
        this.proxy.remoteCallMethod((short)23, aSIHMISyncAudioReplyProxy$8);
    }

    @Override
    public void updateVolumeRange(VolumeRange volumeRange, boolean bl) {
        ASIHMISyncAudioReplyProxy$9 aSIHMISyncAudioReplyProxy$9 = new ASIHMISyncAudioReplyProxy$9(this, volumeRange, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncAudioReplyProxy$9);
    }

    @Override
    public void updateVolume(int n, boolean bl) {
        ASIHMISyncAudioReplyProxy$10 aSIHMISyncAudioReplyProxy$10 = new ASIHMISyncAudioReplyProxy$10(this, n, bl);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncAudioReplyProxy$10);
    }

    @Override
    public void updateAudibleState(int n, boolean bl) {
        ASIHMISyncAudioReplyProxy$11 aSIHMISyncAudioReplyProxy$11 = new ASIHMISyncAudioReplyProxy$11(this, n, bl);
        this.proxy.remoteCallMethod((short)24, aSIHMISyncAudioReplyProxy$11);
    }
}

