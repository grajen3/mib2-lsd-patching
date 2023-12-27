/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2MediaDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$10;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$11;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$12;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$13;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$14;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$15;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$16;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$5;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$6;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$7;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$8;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2MediaDiagServiceReplyProxy
implements MMX2MediaDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2MediaDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2MediaDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4c311096-2484-4cc9-acaf-f8abcdb758e6", -1, "dccdf0f3-38de-548c-a50c-274e448a5cd3", "asi.diagnosis.mmx2app.MMX2MediaDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestSubsystemState(long l) {
        MMX2MediaDiagServiceReplyProxy$1 mMX2MediaDiagServiceReplyProxy$1 = new MMX2MediaDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)31, mMX2MediaDiagServiceReplyProxy$1);
    }

    @Override
    public void requestMediaDBVersion(long l) {
        MMX2MediaDiagServiceReplyProxy$2 mMX2MediaDiagServiceReplyProxy$2 = new MMX2MediaDiagServiceReplyProxy$2(this, l);
        this.proxy.remoteCallMethod((short)1, mMX2MediaDiagServiceReplyProxy$2);
    }

    @Override
    public void requestActiveMediaSourceState(long l, int n) {
        MMX2MediaDiagServiceReplyProxy$3 mMX2MediaDiagServiceReplyProxy$3 = new MMX2MediaDiagServiceReplyProxy$3(this, l, n);
        this.proxy.remoteCallMethod((short)0, mMX2MediaDiagServiceReplyProxy$3);
    }

    @Override
    public void requestMediaRegionCodes(long l) {
        MMX2MediaDiagServiceReplyProxy$4 mMX2MediaDiagServiceReplyProxy$4 = new MMX2MediaDiagServiceReplyProxy$4(this, l);
        this.proxy.remoteCallMethod((short)2, mMX2MediaDiagServiceReplyProxy$4);
    }

    @Override
    public void requestMediaTypeOpticalDrive(long l) {
        MMX2MediaDiagServiceReplyProxy$5 mMX2MediaDiagServiceReplyProxy$5 = new MMX2MediaDiagServiceReplyProxy$5(this, l);
        this.proxy.remoteCallMethod((short)27, mMX2MediaDiagServiceReplyProxy$5);
    }

    @Override
    public void requestUsbOvercurrent(long l) {
        MMX2MediaDiagServiceReplyProxy$6 mMX2MediaDiagServiceReplyProxy$6 = new MMX2MediaDiagServiceReplyProxy$6(this, l);
        this.proxy.remoteCallMethod((short)15, mMX2MediaDiagServiceReplyProxy$6);
    }

    @Override
    public void requestPmlState(long l) {
        MMX2MediaDiagServiceReplyProxy$7 mMX2MediaDiagServiceReplyProxy$7 = new MMX2MediaDiagServiceReplyProxy$7(this, l);
        this.proxy.remoteCallMethod((short)30, mMX2MediaDiagServiceReplyProxy$7);
    }

    @Override
    public void requestSparePartNumberMediaDB(long l) {
        MMX2MediaDiagServiceReplyProxy$8 mMX2MediaDiagServiceReplyProxy$8 = new MMX2MediaDiagServiceReplyProxy$8(this, l);
        this.proxy.remoteCallMethod((short)35, mMX2MediaDiagServiceReplyProxy$8);
    }

    @Override
    public void requestApplicationSoftwareVersionNumberMediaDB(long l) {
        MMX2MediaDiagServiceReplyProxy$9 mMX2MediaDiagServiceReplyProxy$9 = new MMX2MediaDiagServiceReplyProxy$9(this, l);
        this.proxy.remoteCallMethod((short)19, mMX2MediaDiagServiceReplyProxy$9);
    }

    @Override
    public void requestSerialNumberMediaDB(long l) {
        MMX2MediaDiagServiceReplyProxy$10 mMX2MediaDiagServiceReplyProxy$10 = new MMX2MediaDiagServiceReplyProxy$10(this, l);
        this.proxy.remoteCallMethod((short)20, mMX2MediaDiagServiceReplyProxy$10);
    }

    @Override
    public void requestSystemNameMediaDB(long l) {
        MMX2MediaDiagServiceReplyProxy$11 mMX2MediaDiagServiceReplyProxy$11 = new MMX2MediaDiagServiceReplyProxy$11(this, l);
        this.proxy.remoteCallMethod((short)21, mMX2MediaDiagServiceReplyProxy$11);
    }

    @Override
    public void requestStatusUSBCommunication(long l) {
        MMX2MediaDiagServiceReplyProxy$12 mMX2MediaDiagServiceReplyProxy$12 = new MMX2MediaDiagServiceReplyProxy$12(this, l);
        this.proxy.remoteCallMethod((short)38, mMX2MediaDiagServiceReplyProxy$12);
    }

    @Override
    public void requestUSBHubIdentification(long l) {
        MMX2MediaDiagServiceReplyProxy$13 mMX2MediaDiagServiceReplyProxy$13 = new MMX2MediaDiagServiceReplyProxy$13(this, l);
        this.proxy.remoteCallMethod((short)39, mMX2MediaDiagServiceReplyProxy$13);
    }

    @Override
    public void requestDTCPEncryptionState(long l) {
        MMX2MediaDiagServiceReplyProxy$14 mMX2MediaDiagServiceReplyProxy$14 = new MMX2MediaDiagServiceReplyProxy$14(this, l);
        this.proxy.remoteCallMethod((short)47, mMX2MediaDiagServiceReplyProxy$14);
    }

    @Override
    public void requestDTCPKeytypeMMX(long l) {
        MMX2MediaDiagServiceReplyProxy$15 mMX2MediaDiagServiceReplyProxy$15 = new MMX2MediaDiagServiceReplyProxy$15(this, l);
        this.proxy.remoteCallMethod((short)48, mMX2MediaDiagServiceReplyProxy$15);
    }

    @Override
    public void requestDTCPSRMInfo(long l) {
        MMX2MediaDiagServiceReplyProxy$16 mMX2MediaDiagServiceReplyProxy$16 = new MMX2MediaDiagServiceReplyProxy$16(this, l);
        this.proxy.remoteCallMethod((short)49, mMX2MediaDiagServiceReplyProxy$16);
    }
}

