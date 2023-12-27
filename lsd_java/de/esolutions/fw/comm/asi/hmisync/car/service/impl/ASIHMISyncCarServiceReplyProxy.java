/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceReply;
import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$11;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$12;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$13;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$14;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$15;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$16;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$17;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$18;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$19;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$20;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncCarServiceReplyProxy
implements ASIHMISyncCarServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.service.ASIHMISyncCarService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncCarServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7a1486d5-f261-4cc0-a776-d22b0205f993", -1, "7a22b628-8259-5dd8-ab90-23654e8883e0", "asi.hmisync.car.service.ASIHMISyncCarService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$1 aSIHMISyncCarServiceReplyProxy$1 = new ASIHMISyncCarServiceReplyProxy$1(this, string, bl);
        this.proxy.remoteCallMethod((short)6, aSIHMISyncCarServiceReplyProxy$1);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$2 aSIHMISyncCarServiceReplyProxy$2 = new ASIHMISyncCarServiceReplyProxy$2(this, sArray, bl);
        this.proxy.remoteCallMethod((short)14, aSIHMISyncCarServiceReplyProxy$2);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$3 aSIHMISyncCarServiceReplyProxy$3 = new ASIHMISyncCarServiceReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)13, aSIHMISyncCarServiceReplyProxy$3);
    }

    @Override
    public void updateOilLevelData(OilLevelData oilLevelData, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$4 aSIHMISyncCarServiceReplyProxy$4 = new ASIHMISyncCarServiceReplyProxy$4(this, oilLevelData, bl);
        this.proxy.remoteCallMethod((short)11, aSIHMISyncCarServiceReplyProxy$4);
    }

    @Override
    public void updateOilLevelDataVisibilityState(int n, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$5 aSIHMISyncCarServiceReplyProxy$5 = new ASIHMISyncCarServiceReplyProxy$5(this, n, bl);
        this.proxy.remoteCallMethod((short)12, aSIHMISyncCarServiceReplyProxy$5);
    }

    @Override
    public void updateAdBlueInfo(AdBlueInfo adBlueInfo, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$6 aSIHMISyncCarServiceReplyProxy$6 = new ASIHMISyncCarServiceReplyProxy$6(this, adBlueInfo, bl);
        this.proxy.remoteCallMethod((short)26, aSIHMISyncCarServiceReplyProxy$6);
    }

    @Override
    public void updateAdBlueInfoVisibilityState(int n, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$7 aSIHMISyncCarServiceReplyProxy$7 = new ASIHMISyncCarServiceReplyProxy$7(this, n, bl);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncCarServiceReplyProxy$7);
    }

    @Override
    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$8 aSIHMISyncCarServiceReplyProxy$8 = new ASIHMISyncCarServiceReplyProxy$8(this, sIAOilInspection, bl);
        this.proxy.remoteCallMethod((short)15, aSIHMISyncCarServiceReplyProxy$8);
    }

    @Override
    public void updateSIAOilInspectionVisibilityState(int[] nArray, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$9 aSIHMISyncCarServiceReplyProxy$9 = new ASIHMISyncCarServiceReplyProxy$9(this, nArray, bl);
        this.proxy.remoteCallMethod((short)16, aSIHMISyncCarServiceReplyProxy$9);
    }

    @Override
    public void updateSIAServiceData(SIAServiceData sIAServiceData, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$10 aSIHMISyncCarServiceReplyProxy$10 = new ASIHMISyncCarServiceReplyProxy$10(this, sIAServiceData, bl);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncCarServiceReplyProxy$10);
    }

    @Override
    public void updateSIAServiceDataVisibilityState(int n, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$11 aSIHMISyncCarServiceReplyProxy$11 = new ASIHMISyncCarServiceReplyProxy$11(this, n, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncCarServiceReplyProxy$11);
    }

    @Override
    public void updateVinData(String string, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$12 aSIHMISyncCarServiceReplyProxy$12 = new ASIHMISyncCarServiceReplyProxy$12(this, string, bl);
        this.proxy.remoteCallMethod((short)24, aSIHMISyncCarServiceReplyProxy$12);
    }

    @Override
    public void updateVinDataVisibilityState(int n, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$13 aSIHMISyncCarServiceReplyProxy$13 = new ASIHMISyncCarServiceReplyProxy$13(this, n, bl);
        this.proxy.remoteCallMethod((short)25, aSIHMISyncCarServiceReplyProxy$13);
    }

    @Override
    public void updateKeyData(int[] nArray, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$14 aSIHMISyncCarServiceReplyProxy$14 = new ASIHMISyncCarServiceReplyProxy$14(this, nArray, bl);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncCarServiceReplyProxy$14);
    }

    @Override
    public void updateKeyDataVisibilityState(int n, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$15 aSIHMISyncCarServiceReplyProxy$15 = new ASIHMISyncCarServiceReplyProxy$15(this, n, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncCarServiceReplyProxy$15);
    }

    @Override
    public void updateTireDisplayData(TireDisplayData tireDisplayData, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$16 aSIHMISyncCarServiceReplyProxy$16 = new ASIHMISyncCarServiceReplyProxy$16(this, tireDisplayData, bl);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncCarServiceReplyProxy$16);
    }

    @Override
    public void updateTireDisplayDataVisibilityState(int n, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$17 aSIHMISyncCarServiceReplyProxy$17 = new ASIHMISyncCarServiceReplyProxy$17(this, n, bl);
        this.proxy.remoteCallMethod((short)20, aSIHMISyncCarServiceReplyProxy$17);
    }

    @Override
    public void updateTireSystem(int n, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$18 aSIHMISyncCarServiceReplyProxy$18 = new ASIHMISyncCarServiceReplyProxy$18(this, n, bl);
        this.proxy.remoteCallMethod((short)21, aSIHMISyncCarServiceReplyProxy$18);
    }

    @Override
    public void updateVehicleSpeedVisibility(int n, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$19 aSIHMISyncCarServiceReplyProxy$19 = new ASIHMISyncCarServiceReplyProxy$19(this, n, bl);
        this.proxy.remoteCallMethod((short)23, aSIHMISyncCarServiceReplyProxy$19);
    }

    @Override
    public void updateVehicleSpeed(FloatBaseType floatBaseType, boolean bl) {
        ASIHMISyncCarServiceReplyProxy$20 aSIHMISyncCarServiceReplyProxy$20 = new ASIHMISyncCarServiceReplyProxy$20(this, floatBaseType, bl);
        this.proxy.remoteCallMethod((short)22, aSIHMISyncCarServiceReplyProxy$20);
    }
}

