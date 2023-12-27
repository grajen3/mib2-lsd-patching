/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2TelephoneDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$10;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$11;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$12;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$13;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$5;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$6;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$7;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$8;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2TelephoneDiagServiceReplyProxy
implements MMX2TelephoneDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2TelephoneDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2TelephoneDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("434ab88c-5027-40eb-92ee-df5658912e1a", -1, "dd966f77-1703-5382-80a9-c2b428743ae7", "asi.diagnosis.mmx2app.MMX2TelephoneDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestSimState(long l) {
        MMX2TelephoneDiagServiceReplyProxy$1 mMX2TelephoneDiagServiceReplyProxy$1 = new MMX2TelephoneDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)4, mMX2TelephoneDiagServiceReplyProxy$1);
    }

    @Override
    public void requestNadIMEI(long l) {
        MMX2TelephoneDiagServiceReplyProxy$2 mMX2TelephoneDiagServiceReplyProxy$2 = new MMX2TelephoneDiagServiceReplyProxy$2(this, l);
        this.proxy.remoteCallMethod((short)2, mMX2TelephoneDiagServiceReplyProxy$2);
    }

    @Override
    public void requestTelephoneAntennaState(long l, int n) {
        MMX2TelephoneDiagServiceReplyProxy$3 mMX2TelephoneDiagServiceReplyProxy$3 = new MMX2TelephoneDiagServiceReplyProxy$3(this, l, n);
        this.proxy.remoteCallMethod((short)30, mMX2TelephoneDiagServiceReplyProxy$3);
    }

    @Override
    public void requestConnectedBtHandset(long l, int n) {
        MMX2TelephoneDiagServiceReplyProxy$4 mMX2TelephoneDiagServiceReplyProxy$4 = new MMX2TelephoneDiagServiceReplyProxy$4(this, l, n);
        this.proxy.remoteCallMethod((short)0, mMX2TelephoneDiagServiceReplyProxy$4);
    }

    @Override
    public void requestNumberHandsetsHUCs(long l) {
        MMX2TelephoneDiagServiceReplyProxy$5 mMX2TelephoneDiagServiceReplyProxy$5 = new MMX2TelephoneDiagServiceReplyProxy$5(this, l);
        this.proxy.remoteCallMethod((short)3, mMX2TelephoneDiagServiceReplyProxy$5);
    }

    @Override
    public void requestTelephoneNetworkState(long l) {
        MMX2TelephoneDiagServiceReplyProxy$6 mMX2TelephoneDiagServiceReplyProxy$6 = new MMX2TelephoneDiagServiceReplyProxy$6(this, l);
        this.proxy.remoteCallMethod((short)6, mMX2TelephoneDiagServiceReplyProxy$6);
    }

    @Override
    public void requestTelephoneTemperature(long l) {
        MMX2TelephoneDiagServiceReplyProxy$7 mMX2TelephoneDiagServiceReplyProxy$7 = new MMX2TelephoneDiagServiceReplyProxy$7(this, l);
        this.proxy.remoteCallMethod((short)19, mMX2TelephoneDiagServiceReplyProxy$7);
    }

    @Override
    public void requestDeleteMemory(long l, int n) {
        MMX2TelephoneDiagServiceReplyProxy$8 mMX2TelephoneDiagServiceReplyProxy$8 = new MMX2TelephoneDiagServiceReplyProxy$8(this, l, n);
        this.proxy.remoteCallMethod((short)24, mMX2TelephoneDiagServiceReplyProxy$8);
    }

    @Override
    public void requestNetworkName(long l) {
        MMX2TelephoneDiagServiceReplyProxy$9 mMX2TelephoneDiagServiceReplyProxy$9 = new MMX2TelephoneDiagServiceReplyProxy$9(this, l);
        this.proxy.remoteCallMethod((short)34, mMX2TelephoneDiagServiceReplyProxy$9);
    }

    @Override
    public void requestNetworkType(long l) {
        MMX2TelephoneDiagServiceReplyProxy$10 mMX2TelephoneDiagServiceReplyProxy$10 = new MMX2TelephoneDiagServiceReplyProxy$10(this, l);
        this.proxy.remoteCallMethod((short)35, mMX2TelephoneDiagServiceReplyProxy$10);
    }

    @Override
    public void requestDialNumber(long l, String string) {
        MMX2TelephoneDiagServiceReplyProxy$11 mMX2TelephoneDiagServiceReplyProxy$11 = new MMX2TelephoneDiagServiceReplyProxy$11(this, l, string);
        this.proxy.remoteCallMethod((short)33, mMX2TelephoneDiagServiceReplyProxy$11);
    }

    @Override
    public void requestCallStatus(long l) {
        MMX2TelephoneDiagServiceReplyProxy$12 mMX2TelephoneDiagServiceReplyProxy$12 = new MMX2TelephoneDiagServiceReplyProxy$12(this, l);
        this.proxy.remoteCallMethod((short)32, mMX2TelephoneDiagServiceReplyProxy$12);
    }

    @Override
    public void requestInternalSimIdentification(long l) {
        MMX2TelephoneDiagServiceReplyProxy$13 mMX2TelephoneDiagServiceReplyProxy$13 = new MMX2TelephoneDiagServiceReplyProxy$13(this, l);
        this.proxy.remoteCallMethod((short)40, mMX2TelephoneDiagServiceReplyProxy$13);
    }
}

