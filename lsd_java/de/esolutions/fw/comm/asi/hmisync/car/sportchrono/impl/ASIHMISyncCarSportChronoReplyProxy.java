/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoReply;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.RecordingRange;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.TransferState;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$11;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$12;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$13;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$14;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$15;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$16;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$17;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$18;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$19;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$20;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncCarSportChronoReplyProxy
implements ASIHMISyncCarSportChronoReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncCarSportChronoReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("38295c72-4d73-4857-919d-548f4e0abbdd", -1, "98008024-b4e6-5a1f-8cf9-1c1a2dc9dad6", "asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseRecordData(SCData[] sCDataArray, int n) {
        ASIHMISyncCarSportChronoReplyProxy$1 aSIHMISyncCarSportChronoReplyProxy$1 = new ASIHMISyncCarSportChronoReplyProxy$1(this, sCDataArray, n);
        this.proxy.remoteCallMethod((short)7, aSIHMISyncCarSportChronoReplyProxy$1);
    }

    @Override
    public void responseTrackData(int n, SCData[] sCDataArray, int n2) {
        ASIHMISyncCarSportChronoReplyProxy$2 aSIHMISyncCarSportChronoReplyProxy$2 = new ASIHMISyncCarSportChronoReplyProxy$2(this, n, sCDataArray, n2);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncCarSportChronoReplyProxy$2);
    }

    @Override
    public void responseInitTrackTransfer(int n, int n2) {
        ASIHMISyncCarSportChronoReplyProxy$3 aSIHMISyncCarSportChronoReplyProxy$3 = new ASIHMISyncCarSportChronoReplyProxy$3(this, n, n2);
        this.proxy.remoteCallMethod((short)6, aSIHMISyncCarSportChronoReplyProxy$3);
    }

    @Override
    public void responseSetTrackData(int n, int n2) {
        ASIHMISyncCarSportChronoReplyProxy$4 aSIHMISyncCarSportChronoReplyProxy$4 = new ASIHMISyncCarSportChronoReplyProxy$4(this, n, n2);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncCarSportChronoReplyProxy$4);
    }

    @Override
    public void responseSetReferenceLap(int n, int n2) {
        ASIHMISyncCarSportChronoReplyProxy$5 aSIHMISyncCarSportChronoReplyProxy$5 = new ASIHMISyncCarSportChronoReplyProxy$5(this, n, n2);
        this.proxy.remoteCallMethod((short)29, aSIHMISyncCarSportChronoReplyProxy$5);
    }

    @Override
    public void responseReferenceLapData(int n, SCRefLapData[] sCRefLapDataArray, int n2) {
        ASIHMISyncCarSportChronoReplyProxy$6 aSIHMISyncCarSportChronoReplyProxy$6 = new ASIHMISyncCarSportChronoReplyProxy$6(this, n, sCRefLapDataArray, n2);
        this.proxy.remoteCallMethod((short)27, aSIHMISyncCarSportChronoReplyProxy$6);
    }

    @Override
    public void responseSaveReferenceLap(int n) {
        ASIHMISyncCarSportChronoReplyProxy$7 aSIHMISyncCarSportChronoReplyProxy$7 = new ASIHMISyncCarSportChronoReplyProxy$7(this, n);
        this.proxy.remoteCallMethod((short)28, aSIHMISyncCarSportChronoReplyProxy$7);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$8 aSIHMISyncCarSportChronoReplyProxy$8 = new ASIHMISyncCarSportChronoReplyProxy$8(this, string, bl);
        this.proxy.remoteCallMethod((short)15, aSIHMISyncCarSportChronoReplyProxy$8);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$9 aSIHMISyncCarSportChronoReplyProxy$9 = new ASIHMISyncCarSportChronoReplyProxy$9(this, sArray, bl);
        this.proxy.remoteCallMethod((short)20, aSIHMISyncCarSportChronoReplyProxy$9);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$10 aSIHMISyncCarSportChronoReplyProxy$10 = new ASIHMISyncCarSportChronoReplyProxy$10(this, sArray, bl);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncCarSportChronoReplyProxy$10);
    }

    @Override
    public void updateSCVisibilityState(int n, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$11 aSIHMISyncCarSportChronoReplyProxy$11 = new ASIHMISyncCarSportChronoReplyProxy$11(this, n, bl);
        this.proxy.remoteCallMethod((short)21, aSIHMISyncCarSportChronoReplyProxy$11);
    }

    @Override
    public void updateActiveRecord(SCHeader sCHeader, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$12 aSIHMISyncCarSportChronoReplyProxy$12 = new ASIHMISyncCarSportChronoReplyProxy$12(this, sCHeader, bl);
        this.proxy.remoteCallMethod((short)16, aSIHMISyncCarSportChronoReplyProxy$12);
    }

    @Override
    public void updateActiveRecordData(SCData sCData, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$13 aSIHMISyncCarSportChronoReplyProxy$13 = new ASIHMISyncCarSportChronoReplyProxy$13(this, sCData, bl);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncCarSportChronoReplyProxy$13);
    }

    @Override
    public void updateRecordMode(int n, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$14 aSIHMISyncCarSportChronoReplyProxy$14 = new ASIHMISyncCarSportChronoReplyProxy$14(this, n, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncCarSportChronoReplyProxy$14);
    }

    @Override
    public void updateTrackList(SCHeader[] sCHeaderArray, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$15 aSIHMISyncCarSportChronoReplyProxy$15 = new ASIHMISyncCarSportChronoReplyProxy$15(this, sCHeaderArray, bl);
        this.proxy.remoteCallMethod((short)22, aSIHMISyncCarSportChronoReplyProxy$15);
    }

    @Override
    public void updateTransferState(TransferState transferState, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$16 aSIHMISyncCarSportChronoReplyProxy$16 = new ASIHMISyncCarSportChronoReplyProxy$16(this, transferState, bl);
        this.proxy.remoteCallMethod((short)23, aSIHMISyncCarSportChronoReplyProxy$16);
    }

    @Override
    public void updateRecordingTime(long l, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$17 aSIHMISyncCarSportChronoReplyProxy$17 = new ASIHMISyncCarSportChronoReplyProxy$17(this, l, bl);
        this.proxy.remoteCallMethod((short)25, aSIHMISyncCarSportChronoReplyProxy$17);
    }

    @Override
    public void updateRecordingRange(RecordingRange recordingRange, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$18 aSIHMISyncCarSportChronoReplyProxy$18 = new ASIHMISyncCarSportChronoReplyProxy$18(this, recordingRange, bl);
        this.proxy.remoteCallMethod((short)24, aSIHMISyncCarSportChronoReplyProxy$18);
    }

    @Override
    public void updateSelectedReferenceLapUid(int n, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$19 aSIHMISyncCarSportChronoReplyProxy$19 = new ASIHMISyncCarSportChronoReplyProxy$19(this, n, bl);
        this.proxy.remoteCallMethod((short)33, aSIHMISyncCarSportChronoReplyProxy$19);
    }

    @Override
    public void updateReferenceLapList(SCRefLapHeader[] sCRefLapHeaderArray, boolean bl) {
        ASIHMISyncCarSportChronoReplyProxy$20 aSIHMISyncCarSportChronoReplyProxy$20 = new ASIHMISyncCarSportChronoReplyProxy$20(this, sCRefLapHeaderArray, bl);
        this.proxy.remoteCallMethod((short)32, aSIHMISyncCarSportChronoReplyProxy$20);
    }
}

