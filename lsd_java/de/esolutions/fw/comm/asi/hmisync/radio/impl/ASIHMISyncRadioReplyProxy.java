/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioReply;
import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.WavebandInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncRadioReplyProxy
implements ASIHMISyncRadioReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.radio.ASIHMISyncRadio");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncRadioReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("c43514a0-a79e-4e4d-905c-816fe72baa19", -1, "5825259e-363b-5404-81a4-012a1205c9db", "asi.hmisync.radio.ASIHMISyncRadio");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void stationDetailsUpdated(CurrentStation[] currentStationArray) {
        ASIHMISyncRadioReplyProxy$1 aSIHMISyncRadioReplyProxy$1 = new ASIHMISyncRadioReplyProxy$1(this, currentStationArray);
        this.proxy.remoteCallMethod((short)20, aSIHMISyncRadioReplyProxy$1);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncRadioReplyProxy$2 aSIHMISyncRadioReplyProxy$2 = new ASIHMISyncRadioReplyProxy$2(this, string, bl);
        this.proxy.remoteCallMethod((short)11, aSIHMISyncRadioReplyProxy$2);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncRadioReplyProxy$3 aSIHMISyncRadioReplyProxy$3 = new ASIHMISyncRadioReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncRadioReplyProxy$3);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncRadioReplyProxy$4 aSIHMISyncRadioReplyProxy$4 = new ASIHMISyncRadioReplyProxy$4(this, sArray, bl);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncRadioReplyProxy$4);
    }

    @Override
    public void updateBandList(int[] nArray, boolean bl) {
        ASIHMISyncRadioReplyProxy$5 aSIHMISyncRadioReplyProxy$5 = new ASIHMISyncRadioReplyProxy$5(this, nArray, bl);
        this.proxy.remoteCallMethod((short)14, aSIHMISyncRadioReplyProxy$5);
    }

    @Override
    public void updateActiveBand(int n, boolean bl) {
        ASIHMISyncRadioReplyProxy$6 aSIHMISyncRadioReplyProxy$6 = new ASIHMISyncRadioReplyProxy$6(this, n, bl);
        this.proxy.remoteCallMethod((short)12, aSIHMISyncRadioReplyProxy$6);
    }

    @Override
    public void updateRadioStationList(StationInfo[] stationInfoArray, boolean bl) {
        ASIHMISyncRadioReplyProxy$7 aSIHMISyncRadioReplyProxy$7 = new ASIHMISyncRadioReplyProxy$7(this, stationInfoArray, bl);
        this.proxy.remoteCallMethod((short)22, aSIHMISyncRadioReplyProxy$7);
    }

    @Override
    public void updateActiveStation(CurrentStation currentStation, boolean bl) {
        ASIHMISyncRadioReplyProxy$8 aSIHMISyncRadioReplyProxy$8 = new ASIHMISyncRadioReplyProxy$8(this, currentStation, bl);
        this.proxy.remoteCallMethod((short)21, aSIHMISyncRadioReplyProxy$8);
    }

    @Override
    public void updateSeekStatus(int n, boolean bl) {
        ASIHMISyncRadioReplyProxy$9 aSIHMISyncRadioReplyProxy$9 = new ASIHMISyncRadioReplyProxy$9(this, n, bl);
        this.proxy.remoteCallMethod((short)16, aSIHMISyncRadioReplyProxy$9);
    }

    @Override
    public void updateWavebands(WavebandInfo[] wavebandInfoArray, boolean bl) {
        ASIHMISyncRadioReplyProxy$10 aSIHMISyncRadioReplyProxy$10 = new ASIHMISyncRadioReplyProxy$10(this, wavebandInfoArray, bl);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncRadioReplyProxy$10);
    }
}

