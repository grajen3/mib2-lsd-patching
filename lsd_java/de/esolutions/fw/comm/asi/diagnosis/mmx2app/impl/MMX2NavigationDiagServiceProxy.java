/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$10;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$11;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$12;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$13;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$14;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$15;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$16;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$17;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$5;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$6;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$7;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$8;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy$9;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sActiveNavDB;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSNoSatellite;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSOffroad;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCalibrationState;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedDirection;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedPosition;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sVersionsNavDB;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2NavigationDiagServiceProxy
implements MMX2NavigationDiagService,
MMX2NavigationDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2NavigationDiagService");
    private Proxy proxy;

    public MMX2NavigationDiagServiceProxy(int n, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3a0f97f7-4596-4e19-9184-8b0609943a55", n, "add52511-ec64-5161-8bcb-0540c6ab2e22", "asi.diagnosis.mmx2app.MMX2NavigationDiagService");
        MMX2NavigationDiagServiceReplyService mMX2NavigationDiagServiceReplyService = new MMX2NavigationDiagServiceReplyService(mMX2NavigationDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2NavigationDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorNavigation(sClientResponseError sClientResponseError2) {
        MMX2NavigationDiagServiceProxy$1 mMX2NavigationDiagServiceProxy$1 = new MMX2NavigationDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)42, mMX2NavigationDiagServiceProxy$1);
    }

    @Override
    public void responseSubsystemState(sSubsystemState sSubsystemState2) {
        MMX2NavigationDiagServiceProxy$2 mMX2NavigationDiagServiceProxy$2 = new MMX2NavigationDiagServiceProxy$2(this, sSubsystemState2);
        this.proxy.remoteCallMethod((short)38, mMX2NavigationDiagServiceProxy$2);
    }

    @Override
    public void responseVersionsNavDB(sVersionsNavDB sVersionsNavDB2) {
        MMX2NavigationDiagServiceProxy$3 mMX2NavigationDiagServiceProxy$3 = new MMX2NavigationDiagServiceProxy$3(this, sVersionsNavDB2);
        this.proxy.remoteCallMethod((short)16, mMX2NavigationDiagServiceProxy$3);
    }

    @Override
    public void responseActiveNavDB(sActiveNavDB sActiveNavDB2) {
        MMX2NavigationDiagServiceProxy$4 mMX2NavigationDiagServiceProxy$4 = new MMX2NavigationDiagServiceProxy$4(this, sActiveNavDB2);
        this.proxy.remoteCallMethod((short)8, mMX2NavigationDiagServiceProxy$4);
    }

    @Override
    public void responseGPSNoSatellite(sGPSNoSatellite sGPSNoSatellite2) {
        MMX2NavigationDiagServiceProxy$5 mMX2NavigationDiagServiceProxy$5 = new MMX2NavigationDiagServiceProxy$5(this, sGPSNoSatellite2);
        this.proxy.remoteCallMethod((short)10, mMX2NavigationDiagServiceProxy$5);
    }

    @Override
    public void responseGPSOffroad(sGPSOffroad sGPSOffroad2) {
        MMX2NavigationDiagServiceProxy$6 mMX2NavigationDiagServiceProxy$6 = new MMX2NavigationDiagServiceProxy$6(this, sGPSOffroad2);
        this.proxy.remoteCallMethod((short)11, mMX2NavigationDiagServiceProxy$6);
    }

    @Override
    public void responseNavCalibrationState(sNavCalibrationState sNavCalibrationState2) {
        MMX2NavigationDiagServiceProxy$7 mMX2NavigationDiagServiceProxy$7 = new MMX2NavigationDiagServiceProxy$7(this, sNavCalibrationState2);
        this.proxy.remoteCallMethod((short)12, mMX2NavigationDiagServiceProxy$7);
    }

    @Override
    public void responseNavCorrectedPosition(sNavCorrectedPosition sNavCorrectedPosition2) {
        MMX2NavigationDiagServiceProxy$8 mMX2NavigationDiagServiceProxy$8 = new MMX2NavigationDiagServiceProxy$8(this, sNavCorrectedPosition2);
        this.proxy.remoteCallMethod((short)20, mMX2NavigationDiagServiceProxy$8);
    }

    @Override
    public void responseNavCorrectedDirection(sNavCorrectedDirection sNavCorrectedDirection2) {
        MMX2NavigationDiagServiceProxy$9 mMX2NavigationDiagServiceProxy$9 = new MMX2NavigationDiagServiceProxy$9(this, sNavCorrectedDirection2);
        this.proxy.remoteCallMethod((short)13, mMX2NavigationDiagServiceProxy$9);
    }

    @Override
    public void responseResetCalibration(sRoutineResponse sRoutineResponse2) {
        MMX2NavigationDiagServiceProxy$10 mMX2NavigationDiagServiceProxy$10 = new MMX2NavigationDiagServiceProxy$10(this, sRoutineResponse2);
        this.proxy.remoteCallMethod((short)32, mMX2NavigationDiagServiceProxy$10);
    }

    @Override
    public void responseSparePartNumberNavDB(sSparePartNumber sSparePartNumber2) {
        MMX2NavigationDiagServiceProxy$11 mMX2NavigationDiagServiceProxy$11 = new MMX2NavigationDiagServiceProxy$11(this, sSparePartNumber2);
        this.proxy.remoteCallMethod((short)34, mMX2NavigationDiagServiceProxy$11);
    }

    @Override
    public void responseApplicationSoftwareVersionNumberNavDB(sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) {
        MMX2NavigationDiagServiceProxy$12 mMX2NavigationDiagServiceProxy$12 = new MMX2NavigationDiagServiceProxy$12(this, sApplicationSoftwareVersionNumber2);
        this.proxy.remoteCallMethod((short)28, mMX2NavigationDiagServiceProxy$12);
    }

    @Override
    public void responseHardwareNumberNavDB(sHardwareNumber sHardwareNumber2) {
        MMX2NavigationDiagServiceProxy$13 mMX2NavigationDiagServiceProxy$13 = new MMX2NavigationDiagServiceProxy$13(this, sHardwareNumber2);
        this.proxy.remoteCallMethod((short)30, mMX2NavigationDiagServiceProxy$13);
    }

    @Override
    public void responseHardwareVersionNumberNavDB(sHardwareVersionNumber sHardwareVersionNumber2) {
        MMX2NavigationDiagServiceProxy$14 mMX2NavigationDiagServiceProxy$14 = new MMX2NavigationDiagServiceProxy$14(this, sHardwareVersionNumber2);
        this.proxy.remoteCallMethod((short)31, mMX2NavigationDiagServiceProxy$14);
    }

    @Override
    public void responseSerialNumberNavDB(sSerialNumber sSerialNumber2) {
        MMX2NavigationDiagServiceProxy$15 mMX2NavigationDiagServiceProxy$15 = new MMX2NavigationDiagServiceProxy$15(this, sSerialNumber2);
        this.proxy.remoteCallMethod((short)33, mMX2NavigationDiagServiceProxy$15);
    }

    @Override
    public void responseSystemNameNavDB(sSystemName sSystemName2) {
        MMX2NavigationDiagServiceProxy$16 mMX2NavigationDiagServiceProxy$16 = new MMX2NavigationDiagServiceProxy$16(this, sSystemName2);
        this.proxy.remoteCallMethod((short)35, mMX2NavigationDiagServiceProxy$16);
    }

    @Override
    public void responseCountryRegionVersion(sNavCountryRegionVersion sNavCountryRegionVersion2) {
        MMX2NavigationDiagServiceProxy$17 mMX2NavigationDiagServiceProxy$17 = new MMX2NavigationDiagServiceProxy$17(this, sNavCountryRegionVersion2);
        this.proxy.remoteCallMethod((short)41, mMX2NavigationDiagServiceProxy$17);
    }
}

