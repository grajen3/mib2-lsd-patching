/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$11;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$12;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$13;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$14;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$15;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$16;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$17;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$18;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$19;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$20;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncMediaReplyProxy
implements ASIHMISyncMediaReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.media.ASIHMISyncMedia");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncMediaReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("d4078ff5-09f8-41d6-bc52-9680f105aea0", -1, "bfc935bd-08a4-581a-85b9-c997454d068b", "asi.hmisync.media.ASIHMISyncMedia");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void indicationCmdBlocked(int n) {
        ASIHMISyncMediaReplyProxy$1 aSIHMISyncMediaReplyProxy$1 = new ASIHMISyncMediaReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)35, aSIHMISyncMediaReplyProxy$1);
    }

    @Override
    public void responsePlayList(boolean bl, int n, MediaEntry[] mediaEntryArray) {
        ASIHMISyncMediaReplyProxy$2 aSIHMISyncMediaReplyProxy$2 = new ASIHMISyncMediaReplyProxy$2(this, bl, n, mediaEntryArray);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncMediaReplyProxy$2);
    }

    @Override
    public void responseSetPlaySelection(boolean bl) {
        ASIHMISyncMediaReplyProxy$3 aSIHMISyncMediaReplyProxy$3 = new ASIHMISyncMediaReplyProxy$3(this, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncMediaReplyProxy$3);
    }

    @Override
    public void responsePlayMoreFrom(long l, int n, int n2) {
        ASIHMISyncMediaReplyProxy$4 aSIHMISyncMediaReplyProxy$4 = new ASIHMISyncMediaReplyProxy$4(this, l, n, n2);
        this.proxy.remoteCallMethod((short)34, aSIHMISyncMediaReplyProxy$4);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncMediaReplyProxy$5 aSIHMISyncMediaReplyProxy$5 = new ASIHMISyncMediaReplyProxy$5(this, string, bl);
        this.proxy.remoteCallMethod((short)21, aSIHMISyncMediaReplyProxy$5);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncMediaReplyProxy$6 aSIHMISyncMediaReplyProxy$6 = new ASIHMISyncMediaReplyProxy$6(this, sArray, bl);
        this.proxy.remoteCallMethod((short)32, aSIHMISyncMediaReplyProxy$6);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncMediaReplyProxy$7 aSIHMISyncMediaReplyProxy$7 = new ASIHMISyncMediaReplyProxy$7(this, sArray, bl);
        this.proxy.remoteCallMethod((short)31, aSIHMISyncMediaReplyProxy$7);
    }

    @Override
    public void updateSourceList(MediaSourceSlot[] mediaSourceSlotArray, boolean bl) {
        ASIHMISyncMediaReplyProxy$8 aSIHMISyncMediaReplyProxy$8 = new ASIHMISyncMediaReplyProxy$8(this, mediaSourceSlotArray, bl);
        this.proxy.remoteCallMethod((short)30, aSIHMISyncMediaReplyProxy$8);
    }

    @Override
    public void updateActiveSlotState(MediaActiveSourceState mediaActiveSourceState, boolean bl) {
        ASIHMISyncMediaReplyProxy$9 aSIHMISyncMediaReplyProxy$9 = new ASIHMISyncMediaReplyProxy$9(this, mediaActiveSourceState, bl);
        this.proxy.remoteCallMethod((short)22, aSIHMISyncMediaReplyProxy$9);
    }

    @Override
    public void updatePlaybackState(int n, boolean bl) {
        ASIHMISyncMediaReplyProxy$10 aSIHMISyncMediaReplyProxy$10 = new ASIHMISyncMediaReplyProxy$10(this, n, bl);
        this.proxy.remoteCallMethod((short)27, aSIHMISyncMediaReplyProxy$10);
    }

    @Override
    public void updateListState(MediaPlaylistState mediaPlaylistState, boolean bl) {
        ASIHMISyncMediaReplyProxy$11 aSIHMISyncMediaReplyProxy$11 = new ASIHMISyncMediaReplyProxy$11(this, mediaPlaylistState, bl);
        this.proxy.remoteCallMethod((short)23, aSIHMISyncMediaReplyProxy$11);
    }

    @Override
    public void updatePlayerCapabilities(int n, boolean bl) {
        ASIHMISyncMediaReplyProxy$12 aSIHMISyncMediaReplyProxy$12 = new ASIHMISyncMediaReplyProxy$12(this, n, bl);
        this.proxy.remoteCallMethod((short)38, aSIHMISyncMediaReplyProxy$12);
    }

    @Override
    public void updateMix(boolean bl, boolean bl2) {
        ASIHMISyncMediaReplyProxy$13 aSIHMISyncMediaReplyProxy$13 = new ASIHMISyncMediaReplyProxy$13(this, bl, bl2);
        this.proxy.remoteCallMethod((short)24, aSIHMISyncMediaReplyProxy$13);
    }

    @Override
    public void updateRepeatTitle(boolean bl, boolean bl2) {
        ASIHMISyncMediaReplyProxy$14 aSIHMISyncMediaReplyProxy$14 = new ASIHMISyncMediaReplyProxy$14(this, bl, bl2);
        this.proxy.remoteCallMethod((short)29, aSIHMISyncMediaReplyProxy$14);
    }

    @Override
    public void updateRepeatState(int n, boolean bl) {
        ASIHMISyncMediaReplyProxy$15 aSIHMISyncMediaReplyProxy$15 = new ASIHMISyncMediaReplyProxy$15(this, n, bl);
        this.proxy.remoteCallMethod((short)41, aSIHMISyncMediaReplyProxy$15);
    }

    @Override
    public void updateShuffleState(int n, boolean bl) {
        ASIHMISyncMediaReplyProxy$16 aSIHMISyncMediaReplyProxy$16 = new ASIHMISyncMediaReplyProxy$16(this, n, bl);
        this.proxy.remoteCallMethod((short)42, aSIHMISyncMediaReplyProxy$16);
    }

    @Override
    public void updatePlayingTrack(MediaEntry mediaEntry, boolean bl) {
        ASIHMISyncMediaReplyProxy$17 aSIHMISyncMediaReplyProxy$17 = new ASIHMISyncMediaReplyProxy$17(this, mediaEntry, bl);
        this.proxy.remoteCallMethod((short)28, aSIHMISyncMediaReplyProxy$17);
    }

    @Override
    public void updatePlayPosition(MediaPlayTime mediaPlayTime, boolean bl) {
        ASIHMISyncMediaReplyProxy$18 aSIHMISyncMediaReplyProxy$18 = new ASIHMISyncMediaReplyProxy$18(this, mediaPlayTime, bl);
        this.proxy.remoteCallMethod((short)25, aSIHMISyncMediaReplyProxy$18);
    }

    @Override
    public void updatePlaybackFolder(MediaEntry[] mediaEntryArray, boolean bl) {
        ASIHMISyncMediaReplyProxy$19 aSIHMISyncMediaReplyProxy$19 = new ASIHMISyncMediaReplyProxy$19(this, mediaEntryArray, bl);
        this.proxy.remoteCallMethod((short)26, aSIHMISyncMediaReplyProxy$19);
    }

    @Override
    public void updatePlaybackPossible(int n, boolean bl) {
        ASIHMISyncMediaReplyProxy$20 aSIHMISyncMediaReplyProxy$20 = new ASIHMISyncMediaReplyProxy$20(this, n, bl);
        this.proxy.remoteCallMethod((short)37, aSIHMISyncMediaReplyProxy$20);
    }
}

