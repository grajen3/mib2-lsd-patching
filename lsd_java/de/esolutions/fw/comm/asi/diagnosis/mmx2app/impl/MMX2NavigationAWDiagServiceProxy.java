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
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationAWDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationAWDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationAWDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$10;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$11;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$12;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$13;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$14;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$15;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$16;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$17;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$18;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$19;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$20;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$21;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$22;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$23;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$5;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$6;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$7;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$8;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy$9;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sActiveNavDB;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSNoSatellite;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSOffroad;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCalibrationState;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedDirection;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedPosition;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sVersionsNavDB;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateDSRC;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sInfraredBeaconStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sRadioBeaconStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sSubsystemStates;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sUnitStateDSRC;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2NavigationAWDiagServiceProxy
implements MMX2NavigationAWDiagService,
MMX2NavigationAWDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2NavigationAWDiagService");
    private Proxy proxy;

    public MMX2NavigationAWDiagServiceProxy(int n, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("55ad22a1-cc94-4954-a4b5-26b3aa66a601", n, "0465a088-2c21-52dd-9089-0d4a3c078909", "asi.diagnosis.mmx2app.MMX2NavigationAWDiagService");
        MMX2NavigationAWDiagServiceReplyService mMX2NavigationAWDiagServiceReplyService = new MMX2NavigationAWDiagServiceReplyService(mMX2NavigationAWDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2NavigationAWDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorNavigation(sClientResponseError sClientResponseError2) {
        MMX2NavigationAWDiagServiceProxy$1 mMX2NavigationAWDiagServiceProxy$1 = new MMX2NavigationAWDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)47, mMX2NavigationAWDiagServiceProxy$1);
    }

    @Override
    public void responseSubsystemStates(sSubsystemStates sSubsystemStates2) {
        MMX2NavigationAWDiagServiceProxy$2 mMX2NavigationAWDiagServiceProxy$2 = new MMX2NavigationAWDiagServiceProxy$2(this, sSubsystemStates2);
        this.proxy.remoteCallMethod((short)37, mMX2NavigationAWDiagServiceProxy$2);
    }

    @Override
    public void responseVersionsNavDB(sVersionsNavDB sVersionsNavDB2) {
        MMX2NavigationAWDiagServiceProxy$3 mMX2NavigationAWDiagServiceProxy$3 = new MMX2NavigationAWDiagServiceProxy$3(this, sVersionsNavDB2);
        this.proxy.remoteCallMethod((short)40, mMX2NavigationAWDiagServiceProxy$3);
    }

    @Override
    public void responseActiveNavDB(sActiveNavDB sActiveNavDB2) {
        MMX2NavigationAWDiagServiceProxy$4 mMX2NavigationAWDiagServiceProxy$4 = new MMX2NavigationAWDiagServiceProxy$4(this, sActiveNavDB2);
        this.proxy.remoteCallMethod((short)20, mMX2NavigationAWDiagServiceProxy$4);
    }

    @Override
    public void responseGPSNoSatellite(sGPSNoSatellite sGPSNoSatellite2) {
        MMX2NavigationAWDiagServiceProxy$5 mMX2NavigationAWDiagServiceProxy$5 = new MMX2NavigationAWDiagServiceProxy$5(this, sGPSNoSatellite2);
        this.proxy.remoteCallMethod((short)25, mMX2NavigationAWDiagServiceProxy$5);
    }

    @Override
    public void responseGPSOffroad(sGPSOffroad sGPSOffroad2) {
        MMX2NavigationAWDiagServiceProxy$6 mMX2NavigationAWDiagServiceProxy$6 = new MMX2NavigationAWDiagServiceProxy$6(this, sGPSOffroad2);
        this.proxy.remoteCallMethod((short)26, mMX2NavigationAWDiagServiceProxy$6);
    }

    @Override
    public void responseNavCalibrationState(sNavCalibrationState sNavCalibrationState2) {
        MMX2NavigationAWDiagServiceProxy$7 mMX2NavigationAWDiagServiceProxy$7 = new MMX2NavigationAWDiagServiceProxy$7(this, sNavCalibrationState2);
        this.proxy.remoteCallMethod((short)30, mMX2NavigationAWDiagServiceProxy$7);
    }

    @Override
    public void responseNavCorrectedPosition(sNavCorrectedPosition sNavCorrectedPosition2) {
        MMX2NavigationAWDiagServiceProxy$8 mMX2NavigationAWDiagServiceProxy$8 = new MMX2NavigationAWDiagServiceProxy$8(this, sNavCorrectedPosition2);
        this.proxy.remoteCallMethod((short)32, mMX2NavigationAWDiagServiceProxy$8);
    }

    @Override
    public void responseNavCorrectedDirection(sNavCorrectedDirection sNavCorrectedDirection2) {
        MMX2NavigationAWDiagServiceProxy$9 mMX2NavigationAWDiagServiceProxy$9 = new MMX2NavigationAWDiagServiceProxy$9(this, sNavCorrectedDirection2);
        this.proxy.remoteCallMethod((short)31, mMX2NavigationAWDiagServiceProxy$9);
    }

    @Override
    public void responseUnitStateDSRC(sUnitStateDSRC sUnitStateDSRC2) {
        MMX2NavigationAWDiagServiceProxy$10 mMX2NavigationAWDiagServiceProxy$10 = new MMX2NavigationAWDiagServiceProxy$10(this, sUnitStateDSRC2);
        this.proxy.remoteCallMethod((short)41, mMX2NavigationAWDiagServiceProxy$10);
    }

    @Override
    public void responseAntennaStateDSRC(sAntennaStateDSRC sAntennaStateDSRC2) {
        MMX2NavigationAWDiagServiceProxy$11 mMX2NavigationAWDiagServiceProxy$11 = new MMX2NavigationAWDiagServiceProxy$11(this, sAntennaStateDSRC2);
        this.proxy.remoteCallMethod((short)21, mMX2NavigationAWDiagServiceProxy$11);
    }

    @Override
    public void responseAntennaStateVICS(sAntennaStateVICS sAntennaStateVICS2) {
        MMX2NavigationAWDiagServiceProxy$12 mMX2NavigationAWDiagServiceProxy$12 = new MMX2NavigationAWDiagServiceProxy$12(this, sAntennaStateVICS2);
        this.proxy.remoteCallMethod((short)22, mMX2NavigationAWDiagServiceProxy$12);
    }

    @Override
    public void responseRadioBeaconStateVICS(sRadioBeaconStateVICS sRadioBeaconStateVICS2) {
        MMX2NavigationAWDiagServiceProxy$13 mMX2NavigationAWDiagServiceProxy$13 = new MMX2NavigationAWDiagServiceProxy$13(this, sRadioBeaconStateVICS2);
        this.proxy.remoteCallMethod((short)33, mMX2NavigationAWDiagServiceProxy$13);
    }

    @Override
    public void responseInfraredBeaconStateVICS(sInfraredBeaconStateVICS sInfraredBeaconStateVICS2) {
        MMX2NavigationAWDiagServiceProxy$14 mMX2NavigationAWDiagServiceProxy$14 = new MMX2NavigationAWDiagServiceProxy$14(this, sInfraredBeaconStateVICS2);
        this.proxy.remoteCallMethod((short)29, mMX2NavigationAWDiagServiceProxy$14);
    }

    @Override
    public void responseResetCalibration(sRoutineResponse sRoutineResponse2) {
        MMX2NavigationAWDiagServiceProxy$15 mMX2NavigationAWDiagServiceProxy$15 = new MMX2NavigationAWDiagServiceProxy$15(this, sRoutineResponse2);
        this.proxy.remoteCallMethod((short)34, mMX2NavigationAWDiagServiceProxy$15);
    }

    @Override
    public void responseSparePartNumber(sSparePartNumber sSparePartNumber2) {
        MMX2NavigationAWDiagServiceProxy$16 mMX2NavigationAWDiagServiceProxy$16 = new MMX2NavigationAWDiagServiceProxy$16(this, sSparePartNumber2);
        this.proxy.remoteCallMethod((short)36, mMX2NavigationAWDiagServiceProxy$16);
    }

    @Override
    public void responseApplicationSoftwareVersionNumber(sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) {
        MMX2NavigationAWDiagServiceProxy$17 mMX2NavigationAWDiagServiceProxy$17 = new MMX2NavigationAWDiagServiceProxy$17(this, sApplicationSoftwareVersionNumber2);
        this.proxy.remoteCallMethod((short)23, mMX2NavigationAWDiagServiceProxy$17);
    }

    @Override
    public void responseHardwareNumber(sHardwareNumber sHardwareNumber2) {
        MMX2NavigationAWDiagServiceProxy$18 mMX2NavigationAWDiagServiceProxy$18 = new MMX2NavigationAWDiagServiceProxy$18(this, sHardwareNumber2);
        this.proxy.remoteCallMethod((short)27, mMX2NavigationAWDiagServiceProxy$18);
    }

    @Override
    public void responseHardwareVersionNumber(sHardwareVersionNumber sHardwareVersionNumber2) {
        MMX2NavigationAWDiagServiceProxy$19 mMX2NavigationAWDiagServiceProxy$19 = new MMX2NavigationAWDiagServiceProxy$19(this, sHardwareVersionNumber2);
        this.proxy.remoteCallMethod((short)28, mMX2NavigationAWDiagServiceProxy$19);
    }

    @Override
    public void responseSerialNumber(sSerialNumber sSerialNumber2) {
        MMX2NavigationAWDiagServiceProxy$20 mMX2NavigationAWDiagServiceProxy$20 = new MMX2NavigationAWDiagServiceProxy$20(this, sSerialNumber2);
        this.proxy.remoteCallMethod((short)35, mMX2NavigationAWDiagServiceProxy$20);
    }

    @Override
    public void responseSystemName(sSystemName sSystemName2) {
        MMX2NavigationAWDiagServiceProxy$21 mMX2NavigationAWDiagServiceProxy$21 = new MMX2NavigationAWDiagServiceProxy$21(this, sSystemName2);
        this.proxy.remoteCallMethod((short)38, mMX2NavigationAWDiagServiceProxy$21);
    }

    @Override
    public void responseCountryRegionVersion(sNavCountryRegionVersion sNavCountryRegionVersion2) {
        MMX2NavigationAWDiagServiceProxy$22 mMX2NavigationAWDiagServiceProxy$22 = new MMX2NavigationAWDiagServiceProxy$22(this, sNavCountryRegionVersion2);
        this.proxy.remoteCallMethod((short)46, mMX2NavigationAWDiagServiceProxy$22);
    }

    @Override
    public void responseDeleteMemory(sRoutineResponse sRoutineResponse2) {
        MMX2NavigationAWDiagServiceProxy$23 mMX2NavigationAWDiagServiceProxy$23 = new MMX2NavigationAWDiagServiceProxy$23(this, sRoutineResponse2);
        this.proxy.remoteCallMethod((short)43, mMX2NavigationAWDiagServiceProxy$23);
    }
}

