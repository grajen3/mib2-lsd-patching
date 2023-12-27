/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$10;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$11;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$12;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$13;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$14;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$15;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$16;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$5;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$6;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$7;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$8;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2NavigationDiagServiceReplyProxy
implements MMX2NavigationDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2NavigationDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2NavigationDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("128c33a5-671a-49e8-911b-ee23a09bcd10", -1, "8040a0cc-a4ea-5c17-8a45-3b275afe913b", "asi.diagnosis.mmx2app.MMX2NavigationDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestSubsystemState(long l) {
        MMX2NavigationDiagServiceReplyProxy$1 mMX2NavigationDiagServiceReplyProxy$1 = new MMX2NavigationDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)36, mMX2NavigationDiagServiceReplyProxy$1);
    }

    @Override
    public void requestVersionsNavDB(long l) {
        MMX2NavigationDiagServiceReplyProxy$2 mMX2NavigationDiagServiceReplyProxy$2 = new MMX2NavigationDiagServiceReplyProxy$2(this, l);
        this.proxy.remoteCallMethod((short)7, mMX2NavigationDiagServiceReplyProxy$2);
    }

    @Override
    public void requestActiveNavDB(long l) {
        MMX2NavigationDiagServiceReplyProxy$3 mMX2NavigationDiagServiceReplyProxy$3 = new MMX2NavigationDiagServiceReplyProxy$3(this, l);
        this.proxy.remoteCallMethod((short)0, mMX2NavigationDiagServiceReplyProxy$3);
    }

    @Override
    public void requestGPSNoSatellite(long l) {
        MMX2NavigationDiagServiceReplyProxy$4 mMX2NavigationDiagServiceReplyProxy$4 = new MMX2NavigationDiagServiceReplyProxy$4(this, l);
        this.proxy.remoteCallMethod((short)1, mMX2NavigationDiagServiceReplyProxy$4);
    }

    @Override
    public void requestGPSOffroad(long l) {
        MMX2NavigationDiagServiceReplyProxy$5 mMX2NavigationDiagServiceReplyProxy$5 = new MMX2NavigationDiagServiceReplyProxy$5(this, l);
        this.proxy.remoteCallMethod((short)2, mMX2NavigationDiagServiceReplyProxy$5);
    }

    @Override
    public void requestNavCalibrationState(long l) {
        MMX2NavigationDiagServiceReplyProxy$6 mMX2NavigationDiagServiceReplyProxy$6 = new MMX2NavigationDiagServiceReplyProxy$6(this, l);
        this.proxy.remoteCallMethod((short)3, mMX2NavigationDiagServiceReplyProxy$6);
    }

    @Override
    public void requestNavCorrectedPosition(long l) {
        MMX2NavigationDiagServiceReplyProxy$7 mMX2NavigationDiagServiceReplyProxy$7 = new MMX2NavigationDiagServiceReplyProxy$7(this, l);
        this.proxy.remoteCallMethod((short)5, mMX2NavigationDiagServiceReplyProxy$7);
    }

    @Override
    public void requestNavCorrectedDirection(long l) {
        MMX2NavigationDiagServiceReplyProxy$8 mMX2NavigationDiagServiceReplyProxy$8 = new MMX2NavigationDiagServiceReplyProxy$8(this, l);
        this.proxy.remoteCallMethod((short)4, mMX2NavigationDiagServiceReplyProxy$8);
    }

    @Override
    public void requestResetCalibration(long l, int n) {
        MMX2NavigationDiagServiceReplyProxy$9 mMX2NavigationDiagServiceReplyProxy$9 = new MMX2NavigationDiagServiceReplyProxy$9(this, l, n);
        this.proxy.remoteCallMethod((short)6, mMX2NavigationDiagServiceReplyProxy$9);
    }

    @Override
    public void requestSparePartNumberNavDB(long l) {
        MMX2NavigationDiagServiceReplyProxy$10 mMX2NavigationDiagServiceReplyProxy$10 = new MMX2NavigationDiagServiceReplyProxy$10(this, l);
        this.proxy.remoteCallMethod((short)26, mMX2NavigationDiagServiceReplyProxy$10);
    }

    @Override
    public void requestApplicationSoftwareVersionNumberNavDB(long l) {
        MMX2NavigationDiagServiceReplyProxy$11 mMX2NavigationDiagServiceReplyProxy$11 = new MMX2NavigationDiagServiceReplyProxy$11(this, l);
        this.proxy.remoteCallMethod((short)22, mMX2NavigationDiagServiceReplyProxy$11);
    }

    @Override
    public void requestHardwareNumberNavDB(long l) {
        MMX2NavigationDiagServiceReplyProxy$12 mMX2NavigationDiagServiceReplyProxy$12 = new MMX2NavigationDiagServiceReplyProxy$12(this, l);
        this.proxy.remoteCallMethod((short)23, mMX2NavigationDiagServiceReplyProxy$12);
    }

    @Override
    public void requestHardwareVersionNumberNavDB(long l) {
        MMX2NavigationDiagServiceReplyProxy$13 mMX2NavigationDiagServiceReplyProxy$13 = new MMX2NavigationDiagServiceReplyProxy$13(this, l);
        this.proxy.remoteCallMethod((short)24, mMX2NavigationDiagServiceReplyProxy$13);
    }

    @Override
    public void requestSerialNumberNavDB(long l) {
        MMX2NavigationDiagServiceReplyProxy$14 mMX2NavigationDiagServiceReplyProxy$14 = new MMX2NavigationDiagServiceReplyProxy$14(this, l);
        this.proxy.remoteCallMethod((short)25, mMX2NavigationDiagServiceReplyProxy$14);
    }

    @Override
    public void requestSystemNameNavDB(long l) {
        MMX2NavigationDiagServiceReplyProxy$15 mMX2NavigationDiagServiceReplyProxy$15 = new MMX2NavigationDiagServiceReplyProxy$15(this, l);
        this.proxy.remoteCallMethod((short)27, mMX2NavigationDiagServiceReplyProxy$15);
    }

    @Override
    public void requestCountryRegionVersion(long l) {
        MMX2NavigationDiagServiceReplyProxy$16 mMX2NavigationDiagServiceReplyProxy$16 = new MMX2NavigationDiagServiceReplyProxy$16(this, l);
        this.proxy.remoteCallMethod((short)40, mMX2NavigationDiagServiceReplyProxy$16);
    }
}

