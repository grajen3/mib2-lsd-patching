/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationAWDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$10;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$11;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$12;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$13;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$14;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$15;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$16;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$17;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$18;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$19;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$20;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$21;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$22;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$5;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$6;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$7;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$8;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2NavigationAWDiagServiceReplyProxy
implements MMX2NavigationAWDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2NavigationAWDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2NavigationAWDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("55213c43-0995-4f3c-9f56-08df21a1a0f5", -1, "aceab9d2-746a-59f3-836b-7e4e2d8af5ed", "asi.diagnosis.mmx2app.MMX2NavigationAWDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestSubsystemStates(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$1 mMX2NavigationAWDiagServiceReplyProxy$1 = new MMX2NavigationAWDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)16, mMX2NavigationAWDiagServiceReplyProxy$1);
    }

    @Override
    public void requestVersionsNavDB(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$2 mMX2NavigationAWDiagServiceReplyProxy$2 = new MMX2NavigationAWDiagServiceReplyProxy$2(this, l);
        this.proxy.remoteCallMethod((short)19, mMX2NavigationAWDiagServiceReplyProxy$2);
    }

    @Override
    public void requestActiveNavDB(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$3 mMX2NavigationAWDiagServiceReplyProxy$3 = new MMX2NavigationAWDiagServiceReplyProxy$3(this, l);
        this.proxy.remoteCallMethod((short)0, mMX2NavigationAWDiagServiceReplyProxy$3);
    }

    @Override
    public void requestGPSNoSatellite(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$4 mMX2NavigationAWDiagServiceReplyProxy$4 = new MMX2NavigationAWDiagServiceReplyProxy$4(this, l);
        this.proxy.remoteCallMethod((short)4, mMX2NavigationAWDiagServiceReplyProxy$4);
    }

    @Override
    public void requestGPSOffroad(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$5 mMX2NavigationAWDiagServiceReplyProxy$5 = new MMX2NavigationAWDiagServiceReplyProxy$5(this, l);
        this.proxy.remoteCallMethod((short)5, mMX2NavigationAWDiagServiceReplyProxy$5);
    }

    @Override
    public void requestNavCalibrationState(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$6 mMX2NavigationAWDiagServiceReplyProxy$6 = new MMX2NavigationAWDiagServiceReplyProxy$6(this, l);
        this.proxy.remoteCallMethod((short)9, mMX2NavigationAWDiagServiceReplyProxy$6);
    }

    @Override
    public void requestNavCorrectedPosition(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$7 mMX2NavigationAWDiagServiceReplyProxy$7 = new MMX2NavigationAWDiagServiceReplyProxy$7(this, l);
        this.proxy.remoteCallMethod((short)11, mMX2NavigationAWDiagServiceReplyProxy$7);
    }

    @Override
    public void requestNavCorrectedDirection(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$8 mMX2NavigationAWDiagServiceReplyProxy$8 = new MMX2NavigationAWDiagServiceReplyProxy$8(this, l);
        this.proxy.remoteCallMethod((short)10, mMX2NavigationAWDiagServiceReplyProxy$8);
    }

    @Override
    public void requestUnitStateDSRC(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$9 mMX2NavigationAWDiagServiceReplyProxy$9 = new MMX2NavigationAWDiagServiceReplyProxy$9(this, l);
        this.proxy.remoteCallMethod((short)18, mMX2NavigationAWDiagServiceReplyProxy$9);
    }

    @Override
    public void requestAntennaStateDSRC(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$10 mMX2NavigationAWDiagServiceReplyProxy$10 = new MMX2NavigationAWDiagServiceReplyProxy$10(this, l);
        this.proxy.remoteCallMethod((short)1, mMX2NavigationAWDiagServiceReplyProxy$10);
    }

    @Override
    public void requestAntennaStateVICS(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$11 mMX2NavigationAWDiagServiceReplyProxy$11 = new MMX2NavigationAWDiagServiceReplyProxy$11(this, l);
        this.proxy.remoteCallMethod((short)2, mMX2NavigationAWDiagServiceReplyProxy$11);
    }

    @Override
    public void requestRadioBeaconStateVICS(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$12 mMX2NavigationAWDiagServiceReplyProxy$12 = new MMX2NavigationAWDiagServiceReplyProxy$12(this, l);
        this.proxy.remoteCallMethod((short)12, mMX2NavigationAWDiagServiceReplyProxy$12);
    }

    @Override
    public void requestInfraredBeaconStateVICS(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$13 mMX2NavigationAWDiagServiceReplyProxy$13 = new MMX2NavigationAWDiagServiceReplyProxy$13(this, l);
        this.proxy.remoteCallMethod((short)8, mMX2NavigationAWDiagServiceReplyProxy$13);
    }

    @Override
    public void requestResetCalibration(long l, int n) {
        MMX2NavigationAWDiagServiceReplyProxy$14 mMX2NavigationAWDiagServiceReplyProxy$14 = new MMX2NavigationAWDiagServiceReplyProxy$14(this, l, n);
        this.proxy.remoteCallMethod((short)13, mMX2NavigationAWDiagServiceReplyProxy$14);
    }

    @Override
    public void requestSparePartNumber(long l, int n) {
        MMX2NavigationAWDiagServiceReplyProxy$15 mMX2NavigationAWDiagServiceReplyProxy$15 = new MMX2NavigationAWDiagServiceReplyProxy$15(this, l, n);
        this.proxy.remoteCallMethod((short)15, mMX2NavigationAWDiagServiceReplyProxy$15);
    }

    @Override
    public void requestApplicationSoftwareVersionNumber(long l, int n) {
        MMX2NavigationAWDiagServiceReplyProxy$16 mMX2NavigationAWDiagServiceReplyProxy$16 = new MMX2NavigationAWDiagServiceReplyProxy$16(this, l, n);
        this.proxy.remoteCallMethod((short)3, mMX2NavigationAWDiagServiceReplyProxy$16);
    }

    @Override
    public void requestHardwareNumber(long l, int n) {
        MMX2NavigationAWDiagServiceReplyProxy$17 mMX2NavigationAWDiagServiceReplyProxy$17 = new MMX2NavigationAWDiagServiceReplyProxy$17(this, l, n);
        this.proxy.remoteCallMethod((short)6, mMX2NavigationAWDiagServiceReplyProxy$17);
    }

    @Override
    public void requestHardwareVersionNumber(long l, int n) {
        MMX2NavigationAWDiagServiceReplyProxy$18 mMX2NavigationAWDiagServiceReplyProxy$18 = new MMX2NavigationAWDiagServiceReplyProxy$18(this, l, n);
        this.proxy.remoteCallMethod((short)7, mMX2NavigationAWDiagServiceReplyProxy$18);
    }

    @Override
    public void requestSerialNumber(long l, int n) {
        MMX2NavigationAWDiagServiceReplyProxy$19 mMX2NavigationAWDiagServiceReplyProxy$19 = new MMX2NavigationAWDiagServiceReplyProxy$19(this, l, n);
        this.proxy.remoteCallMethod((short)14, mMX2NavigationAWDiagServiceReplyProxy$19);
    }

    @Override
    public void requestSystemName(long l, int n) {
        MMX2NavigationAWDiagServiceReplyProxy$20 mMX2NavigationAWDiagServiceReplyProxy$20 = new MMX2NavigationAWDiagServiceReplyProxy$20(this, l, n);
        this.proxy.remoteCallMethod((short)17, mMX2NavigationAWDiagServiceReplyProxy$20);
    }

    @Override
    public void requestCountryRegionVersion(long l) {
        MMX2NavigationAWDiagServiceReplyProxy$21 mMX2NavigationAWDiagServiceReplyProxy$21 = new MMX2NavigationAWDiagServiceReplyProxy$21(this, l);
        this.proxy.remoteCallMethod((short)45, mMX2NavigationAWDiagServiceReplyProxy$21);
    }

    @Override
    public void requestDeleteMemory(long l, int n) {
        MMX2NavigationAWDiagServiceReplyProxy$22 mMX2NavigationAWDiagServiceReplyProxy$22 = new MMX2NavigationAWDiagServiceReplyProxy$22(this, l, n);
        this.proxy.remoteCallMethod((short)42, mMX2NavigationAWDiagServiceReplyProxy$22);
    }
}

