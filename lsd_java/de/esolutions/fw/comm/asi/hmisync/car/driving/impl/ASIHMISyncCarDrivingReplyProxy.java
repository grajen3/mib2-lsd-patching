/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingReply;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADConfiguration;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$11;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$12;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$13;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$14;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$15;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$16;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$17;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncCarDrivingReplyProxy
implements ASIHMISyncCarDrivingReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.driving.ASIHMISyncCarDriving");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncCarDrivingReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("cf0d1065-933d-46b1-baf6-eb334745e56f", -1, "379cb220-0a06-531f-b0fc-2506d73807a9", "asi.hmisync.car.driving.ASIHMISyncCarDriving");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$1 aSIHMISyncCarDrivingReplyProxy$1 = new ASIHMISyncCarDrivingReplyProxy$1(this, string, bl);
        this.proxy.remoteCallMethod((short)6, aSIHMISyncCarDrivingReplyProxy$1);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$2 aSIHMISyncCarDrivingReplyProxy$2 = new ASIHMISyncCarDrivingReplyProxy$2(this, sArray, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncCarDrivingReplyProxy$2);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$3 aSIHMISyncCarDrivingReplyProxy$3 = new ASIHMISyncCarDrivingReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncCarDrivingReplyProxy$3);
    }

    @Override
    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$4 aSIHMISyncCarDrivingReplyProxy$4 = new ASIHMISyncCarDrivingReplyProxy$4(this, tADVehicleInfo, bl);
        this.proxy.remoteCallMethod((short)20, aSIHMISyncCarDrivingReplyProxy$4);
    }

    @Override
    public void updateTADConfiguration(TADConfiguration tADConfiguration, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$5 aSIHMISyncCarDrivingReplyProxy$5 = new ASIHMISyncCarDrivingReplyProxy$5(this, tADConfiguration, bl);
        this.proxy.remoteCallMethod((short)22, aSIHMISyncCarDrivingReplyProxy$5);
    }

    @Override
    public void updateTADCurrentRollAngle(float f2, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$6 aSIHMISyncCarDrivingReplyProxy$6 = new ASIHMISyncCarDrivingReplyProxy$6(this, f2, bl);
        this.proxy.remoteCallMethod((short)15, aSIHMISyncCarDrivingReplyProxy$6);
    }

    @Override
    public void updateTADPosMaxRollAngle(float f2, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$7 aSIHMISyncCarDrivingReplyProxy$7 = new ASIHMISyncCarDrivingReplyProxy$7(this, f2, bl);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncCarDrivingReplyProxy$7);
    }

    @Override
    public void updateTADNegMaxRollAngle(float f2, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$8 aSIHMISyncCarDrivingReplyProxy$8 = new ASIHMISyncCarDrivingReplyProxy$8(this, f2, bl);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncCarDrivingReplyProxy$8);
    }

    @Override
    public void updateTADCurrentPitchAngle(float f2, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$9 aSIHMISyncCarDrivingReplyProxy$9 = new ASIHMISyncCarDrivingReplyProxy$9(this, f2, bl);
        this.proxy.remoteCallMethod((short)14, aSIHMISyncCarDrivingReplyProxy$9);
    }

    @Override
    public void updateTADPosMaxPitch(float f2, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$10 aSIHMISyncCarDrivingReplyProxy$10 = new ASIHMISyncCarDrivingReplyProxy$10(this, f2, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncCarDrivingReplyProxy$10);
    }

    @Override
    public void updateTADNegMaxPitch(float f2, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$11 aSIHMISyncCarDrivingReplyProxy$11 = new ASIHMISyncCarDrivingReplyProxy$11(this, f2, bl);
        this.proxy.remoteCallMethod((short)16, aSIHMISyncCarDrivingReplyProxy$11);
    }

    @Override
    public void updateTADVisibilityState(int n, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$12 aSIHMISyncCarDrivingReplyProxy$12 = new ASIHMISyncCarDrivingReplyProxy$12(this, n, bl);
        this.proxy.remoteCallMethod((short)21, aSIHMISyncCarDrivingReplyProxy$12);
    }

    @Override
    public void updateSuspensionControlCurrentLevel(int n, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$13 aSIHMISyncCarDrivingReplyProxy$13 = new ASIHMISyncCarDrivingReplyProxy$13(this, n, bl);
        this.proxy.remoteCallMethod((short)11, aSIHMISyncCarDrivingReplyProxy$13);
    }

    @Override
    public void updateSuspensionControlTargetLevel(int n, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$14 aSIHMISyncCarDrivingReplyProxy$14 = new ASIHMISyncCarDrivingReplyProxy$14(this, n, bl);
        this.proxy.remoteCallMethod((short)12, aSIHMISyncCarDrivingReplyProxy$14);
    }

    @Override
    public void updateSuspensionVisibilityState(int[] nArray, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$15 aSIHMISyncCarDrivingReplyProxy$15 = new ASIHMISyncCarDrivingReplyProxy$15(this, nArray, bl);
        this.proxy.remoteCallMethod((short)13, aSIHMISyncCarDrivingReplyProxy$15);
    }

    @Override
    public void updateDriveSelectActiveProfile(int n, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$16 aSIHMISyncCarDrivingReplyProxy$16 = new ASIHMISyncCarDrivingReplyProxy$16(this, n, bl);
        this.proxy.remoteCallMethod((short)7, aSIHMISyncCarDrivingReplyProxy$16);
    }

    @Override
    public void updateDriveSelectActiveProfileVisibilityState(int n, boolean bl) {
        ASIHMISyncCarDrivingReplyProxy$17 aSIHMISyncCarDrivingReplyProxy$17 = new ASIHMISyncCarDrivingReplyProxy$17(this, n, bl);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncCarDrivingReplyProxy$17);
    }
}

