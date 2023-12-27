/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$11;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$12;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$13;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$14;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$15;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$16;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$17;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$18;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$19;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$20;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$21;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$22;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$23;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$24;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$25;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncSoundReplyProxy
implements ASIHMISyncSoundReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.sound.ASIHMISyncSound");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncSoundReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7ba5c63b-4ccf-465c-abe4-f731a4967351", -1, "143510c1-02a3-544a-b01d-af15a58cbbc4", "asi.hmisync.sound.ASIHMISyncSound");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncSoundReplyProxy$1 aSIHMISyncSoundReplyProxy$1 = new ASIHMISyncSoundReplyProxy$1(this, string, bl);
        this.proxy.remoteCallMethod((short)14, aSIHMISyncSoundReplyProxy$1);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncSoundReplyProxy$2 aSIHMISyncSoundReplyProxy$2 = new ASIHMISyncSoundReplyProxy$2(this, sArray, bl);
        this.proxy.remoteCallMethod((short)27, aSIHMISyncSoundReplyProxy$2);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncSoundReplyProxy$3 aSIHMISyncSoundReplyProxy$3 = new ASIHMISyncSoundReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)26, aSIHMISyncSoundReplyProxy$3);
    }

    @Override
    public void updateSoundState(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$4 aSIHMISyncSoundReplyProxy$4 = new ASIHMISyncSoundReplyProxy$4(this, n, bl);
        this.proxy.remoteCallMethod((short)28, aSIHMISyncSoundReplyProxy$4);
    }

    @Override
    public void updateAmplifier(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$5 aSIHMISyncSoundReplyProxy$5 = new ASIHMISyncSoundReplyProxy$5(this, n, bl);
        this.proxy.remoteCallMethod((short)15, aSIHMISyncSoundReplyProxy$5);
    }

    @Override
    public void updateBassRange(SoundRange soundRange, boolean bl) {
        ASIHMISyncSoundReplyProxy$6 aSIHMISyncSoundReplyProxy$6 = new ASIHMISyncSoundReplyProxy$6(this, soundRange, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncSoundReplyProxy$6);
    }

    @Override
    public void updateBassValue(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$7 aSIHMISyncSoundReplyProxy$7 = new ASIHMISyncSoundReplyProxy$7(this, n, bl);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncSoundReplyProxy$7);
    }

    @Override
    public void updateTrebleRange(SoundRange soundRange, boolean bl) {
        ASIHMISyncSoundReplyProxy$8 aSIHMISyncSoundReplyProxy$8 = new ASIHMISyncSoundReplyProxy$8(this, soundRange, bl);
        this.proxy.remoteCallMethod((short)33, aSIHMISyncSoundReplyProxy$8);
    }

    @Override
    public void updateTrebleValue(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$9 aSIHMISyncSoundReplyProxy$9 = new ASIHMISyncSoundReplyProxy$9(this, n, bl);
        this.proxy.remoteCallMethod((short)34, aSIHMISyncSoundReplyProxy$9);
    }

    @Override
    public void updateBalanceRange(SoundRange soundRange, boolean bl) {
        ASIHMISyncSoundReplyProxy$10 aSIHMISyncSoundReplyProxy$10 = new ASIHMISyncSoundReplyProxy$10(this, soundRange, bl);
        this.proxy.remoteCallMethod((short)16, aSIHMISyncSoundReplyProxy$10);
    }

    @Override
    public void updateBalanceValue(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$11 aSIHMISyncSoundReplyProxy$11 = new ASIHMISyncSoundReplyProxy$11(this, n, bl);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncSoundReplyProxy$11);
    }

    @Override
    public void updateFaderRange(SoundRange soundRange, boolean bl) {
        ASIHMISyncSoundReplyProxy$12 aSIHMISyncSoundReplyProxy$12 = new ASIHMISyncSoundReplyProxy$12(this, soundRange, bl);
        this.proxy.remoteCallMethod((short)20, aSIHMISyncSoundReplyProxy$12);
    }

    @Override
    public void updateFaderValue(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$13 aSIHMISyncSoundReplyProxy$13 = new ASIHMISyncSoundReplyProxy$13(this, n, bl);
        this.proxy.remoteCallMethod((short)21, aSIHMISyncSoundReplyProxy$13);
    }

    @Override
    public void updateSubwooferRange(SoundRange soundRange, boolean bl) {
        ASIHMISyncSoundReplyProxy$14 aSIHMISyncSoundReplyProxy$14 = new ASIHMISyncSoundReplyProxy$14(this, soundRange, bl);
        this.proxy.remoteCallMethod((short)29, aSIHMISyncSoundReplyProxy$14);
    }

    @Override
    public void updateSubwooferValue(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$15 aSIHMISyncSoundReplyProxy$15 = new ASIHMISyncSoundReplyProxy$15(this, n, bl);
        this.proxy.remoteCallMethod((short)30, aSIHMISyncSoundReplyProxy$15);
    }

    @Override
    public void updateSurroundRange(SoundRange soundRange, boolean bl) {
        ASIHMISyncSoundReplyProxy$16 aSIHMISyncSoundReplyProxy$16 = new ASIHMISyncSoundReplyProxy$16(this, soundRange, bl);
        this.proxy.remoteCallMethod((short)31, aSIHMISyncSoundReplyProxy$16);
    }

    @Override
    public void updateSurroundValue(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$17 aSIHMISyncSoundReplyProxy$17 = new ASIHMISyncSoundReplyProxy$17(this, n, bl);
        this.proxy.remoteCallMethod((short)32, aSIHMISyncSoundReplyProxy$17);
    }

    @Override
    public void updateNoiseCompensationRange(SoundRange soundRange, boolean bl) {
        ASIHMISyncSoundReplyProxy$18 aSIHMISyncSoundReplyProxy$18 = new ASIHMISyncSoundReplyProxy$18(this, soundRange, bl);
        this.proxy.remoteCallMethod((short)22, aSIHMISyncSoundReplyProxy$18);
    }

    @Override
    public void updateNoiseCompensationValue(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$19 aSIHMISyncSoundReplyProxy$19 = new ASIHMISyncSoundReplyProxy$19(this, n, bl);
        this.proxy.remoteCallMethod((short)23, aSIHMISyncSoundReplyProxy$19);
    }

    @Override
    public void updateThreeDModeRange(SoundRange soundRange, boolean bl) {
        ASIHMISyncSoundReplyProxy$20 aSIHMISyncSoundReplyProxy$20 = new ASIHMISyncSoundReplyProxy$20(this, soundRange, bl);
        this.proxy.remoteCallMethod((short)39, aSIHMISyncSoundReplyProxy$20);
    }

    @Override
    public void updateThreeDModeValue(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$21 aSIHMISyncSoundReplyProxy$21 = new ASIHMISyncSoundReplyProxy$21(this, n, bl);
        this.proxy.remoteCallMethod((short)40, aSIHMISyncSoundReplyProxy$21);
    }

    @Override
    public void updatePresetPositionList(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$22 aSIHMISyncSoundReplyProxy$22 = new ASIHMISyncSoundReplyProxy$22(this, n, bl);
        this.proxy.remoteCallMethod((short)25, aSIHMISyncSoundReplyProxy$22);
    }

    @Override
    public void updatePresetPosition(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$23 aSIHMISyncSoundReplyProxy$23 = new ASIHMISyncSoundReplyProxy$23(this, n, bl);
        this.proxy.remoteCallMethod((short)24, aSIHMISyncSoundReplyProxy$23);
    }

    @Override
    public void updatePresetEQList(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$24 aSIHMISyncSoundReplyProxy$24 = new ASIHMISyncSoundReplyProxy$24(this, n, bl);
        this.proxy.remoteCallMethod((short)38, aSIHMISyncSoundReplyProxy$24);
    }

    @Override
    public void updatePresetEQ(int n, boolean bl) {
        ASIHMISyncSoundReplyProxy$25 aSIHMISyncSoundReplyProxy$25 = new ASIHMISyncSoundReplyProxy$25(this, n, bl);
        this.proxy.remoteCallMethod((short)37, aSIHMISyncSoundReplyProxy$25);
    }
}

