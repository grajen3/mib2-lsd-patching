/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;
import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$11;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncTVReplyProxy
implements ASIHMISyncTVReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.tv.ASIHMISyncTV");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncTVReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f3fc2e4b-d25f-4479-9da4-6be3da7c1a1e", -1, "7b078b73-244f-5129-b88a-1c945501d223", "asi.hmisync.tv.ASIHMISyncTV");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncTVReplyProxy$1 aSIHMISyncTVReplyProxy$1 = new ASIHMISyncTVReplyProxy$1(this, string, bl);
        this.proxy.remoteCallMethod((short)12, aSIHMISyncTVReplyProxy$1);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncTVReplyProxy$2 aSIHMISyncTVReplyProxy$2 = new ASIHMISyncTVReplyProxy$2(this, sArray, bl);
        this.proxy.remoteCallMethod((short)20, aSIHMISyncTVReplyProxy$2);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncTVReplyProxy$3 aSIHMISyncTVReplyProxy$3 = new ASIHMISyncTVReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncTVReplyProxy$3);
    }

    @Override
    public void updateStationInfo(StationInfo[] stationInfoArray, boolean bl) {
        ASIHMISyncTVReplyProxy$4 aSIHMISyncTVReplyProxy$4 = new ASIHMISyncTVReplyProxy$4(this, stationInfoArray, bl);
        this.proxy.remoteCallMethod((short)23, aSIHMISyncTVReplyProxy$4);
    }

    @Override
    public void updateActiveStationInfo(ActiveStationInfo activeStationInfo, boolean bl) {
        ASIHMISyncTVReplyProxy$5 aSIHMISyncTVReplyProxy$5 = new ASIHMISyncTVReplyProxy$5(this, activeStationInfo, bl);
        this.proxy.remoteCallMethod((short)21, aSIHMISyncTVReplyProxy$5);
    }

    @Override
    public void updateActiveTVStationState(long l, boolean bl) {
        ASIHMISyncTVReplyProxy$6 aSIHMISyncTVReplyProxy$6 = new ASIHMISyncTVReplyProxy$6(this, l, bl);
        this.proxy.remoteCallMethod((short)22, aSIHMISyncTVReplyProxy$6);
    }

    @Override
    public void updateTunerConfig(long l, boolean bl) {
        ASIHMISyncTVReplyProxy$7 aSIHMISyncTVReplyProxy$7 = new ASIHMISyncTVReplyProxy$7(this, l, bl);
        this.proxy.remoteCallMethod((short)24, aSIHMISyncTVReplyProxy$7);
    }

    @Override
    public void updatePanelKeySet(KeySet[] keySetArray, boolean bl) {
        ASIHMISyncTVReplyProxy$8 aSIHMISyncTVReplyProxy$8 = new ASIHMISyncTVReplyProxy$8(this, keySetArray, bl);
        this.proxy.remoteCallMethod((short)14, aSIHMISyncTVReplyProxy$8);
    }

    @Override
    public void updateSeekStatus(byte by, boolean bl) {
        ASIHMISyncTVReplyProxy$9 aSIHMISyncTVReplyProxy$9 = new ASIHMISyncTVReplyProxy$9(this, by, bl);
        this.proxy.remoteCallMethod((short)16, aSIHMISyncTVReplyProxy$9);
    }

    @Override
    public void updateTerminalMode(byte by, boolean bl) {
        ASIHMISyncTVReplyProxy$10 aSIHMISyncTVReplyProxy$10 = new ASIHMISyncTVReplyProxy$10(this, by, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncTVReplyProxy$10);
    }

    @Override
    public void updateParentalSettings(ParentalSettings parentalSettings, boolean bl) {
        ASIHMISyncTVReplyProxy$11 aSIHMISyncTVReplyProxy$11 = new ASIHMISyncTVReplyProxy$11(this, parentalSettings, bl);
        this.proxy.remoteCallMethod((short)15, aSIHMISyncTVReplyProxy$11);
    }
}

