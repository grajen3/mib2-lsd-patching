/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerReply;
import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$11;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$12;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$13;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$14;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$15;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$16;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$17;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$18;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$19;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncCarBordComputerReplyProxy
implements ASIHMISyncCarBordComputerReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.bc.ASIHMISyncCarBordComputer");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncCarBordComputerReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("6d65ca53-0148-4329-8b3c-e8cd1fbade7a", -1, "d1b91a1b-f081-5c4c-bc68-8c00a93879a4", "asi.hmisync.car.bc.ASIHMISyncCarBordComputer");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$1 aSIHMISyncCarBordComputerReplyProxy$1 = new ASIHMISyncCarBordComputerReplyProxy$1(this, string, bl);
        this.proxy.remoteCallMethod((short)6, aSIHMISyncCarBordComputerReplyProxy$1);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$2 aSIHMISyncCarBordComputerReplyProxy$2 = new ASIHMISyncCarBordComputerReplyProxy$2(this, sArray, bl);
        this.proxy.remoteCallMethod((short)24, aSIHMISyncCarBordComputerReplyProxy$2);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$3 aSIHMISyncCarBordComputerReplyProxy$3 = new ASIHMISyncCarBordComputerReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)23, aSIHMISyncCarBordComputerReplyProxy$3);
    }

    @Override
    public void updateBCShortTermAverageConsumption1Visibility(int n, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$4 aSIHMISyncCarBordComputerReplyProxy$4 = new ASIHMISyncCarBordComputerReplyProxy$4(this, n, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncCarBordComputerReplyProxy$4);
    }

    @Override
    public void updateBCShortTermAverageConsumption1(FloatBaseType floatBaseType, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$5 aSIHMISyncCarBordComputerReplyProxy$5 = new ASIHMISyncCarBordComputerReplyProxy$5(this, floatBaseType, bl);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncCarBordComputerReplyProxy$5);
    }

    @Override
    public void updateBCShortTermAverageConsumption2Visibility(int n, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$6 aSIHMISyncCarBordComputerReplyProxy$6 = new ASIHMISyncCarBordComputerReplyProxy$6(this, n, bl);
        this.proxy.remoteCallMethod((short)20, aSIHMISyncCarBordComputerReplyProxy$6);
    }

    @Override
    public void updateBCShortTermAverageConsumption2(FloatBaseType floatBaseType, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$7 aSIHMISyncCarBordComputerReplyProxy$7 = new ASIHMISyncCarBordComputerReplyProxy$7(this, floatBaseType, bl);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncCarBordComputerReplyProxy$7);
    }

    @Override
    public void updateBCLongTermAverageConsumption1Visibility(int n, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$8 aSIHMISyncCarBordComputerReplyProxy$8 = new ASIHMISyncCarBordComputerReplyProxy$8(this, n, bl);
        this.proxy.remoteCallMethod((short)12, aSIHMISyncCarBordComputerReplyProxy$8);
    }

    @Override
    public void updateBCLongTermAverageConsumption1(FloatBaseType floatBaseType, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$9 aSIHMISyncCarBordComputerReplyProxy$9 = new ASIHMISyncCarBordComputerReplyProxy$9(this, floatBaseType, bl);
        this.proxy.remoteCallMethod((short)11, aSIHMISyncCarBordComputerReplyProxy$9);
    }

    @Override
    public void updateBCLongTermAverageConsumption2Visibility(int n, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$10 aSIHMISyncCarBordComputerReplyProxy$10 = new ASIHMISyncCarBordComputerReplyProxy$10(this, n, bl);
        this.proxy.remoteCallMethod((short)14, aSIHMISyncCarBordComputerReplyProxy$10);
    }

    @Override
    public void updateBCLongTermAverageConsumption2(FloatBaseType floatBaseType, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$11 aSIHMISyncCarBordComputerReplyProxy$11 = new ASIHMISyncCarBordComputerReplyProxy$11(this, floatBaseType, bl);
        this.proxy.remoteCallMethod((short)13, aSIHMISyncCarBordComputerReplyProxy$11);
    }

    @Override
    public void updateBCCurrentRange1Visibility(int n, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$12 aSIHMISyncCarBordComputerReplyProxy$12 = new ASIHMISyncCarBordComputerReplyProxy$12(this, n, bl);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncCarBordComputerReplyProxy$12);
    }

    @Override
    public void updateBCCurrentRange1(IntBaseType intBaseType, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$13 aSIHMISyncCarBordComputerReplyProxy$13 = new ASIHMISyncCarBordComputerReplyProxy$13(this, intBaseType, bl);
        this.proxy.remoteCallMethod((short)7, aSIHMISyncCarBordComputerReplyProxy$13);
    }

    @Override
    public void updateBCCurrentRange2Visibility(int n, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$14 aSIHMISyncCarBordComputerReplyProxy$14 = new ASIHMISyncCarBordComputerReplyProxy$14(this, n, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncCarBordComputerReplyProxy$14);
    }

    @Override
    public void updateBCCurrentRange2(IntBaseType intBaseType, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$15 aSIHMISyncCarBordComputerReplyProxy$15 = new ASIHMISyncCarBordComputerReplyProxy$15(this, intBaseType, bl);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncCarBordComputerReplyProxy$15);
    }

    @Override
    public void updateBCShortTermGeneralVisibility(int n, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$16 aSIHMISyncCarBordComputerReplyProxy$16 = new ASIHMISyncCarBordComputerReplyProxy$16(this, n, bl);
        this.proxy.remoteCallMethod((short)22, aSIHMISyncCarBordComputerReplyProxy$16);
    }

    @Override
    public void updateBCShortTermGeneral(BCTermGeneralData bCTermGeneralData, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$17 aSIHMISyncCarBordComputerReplyProxy$17 = new ASIHMISyncCarBordComputerReplyProxy$17(this, bCTermGeneralData, bl);
        this.proxy.remoteCallMethod((short)21, aSIHMISyncCarBordComputerReplyProxy$17);
    }

    @Override
    public void updateBCLongTermGeneralVisibility(int n, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$18 aSIHMISyncCarBordComputerReplyProxy$18 = new ASIHMISyncCarBordComputerReplyProxy$18(this, n, bl);
        this.proxy.remoteCallMethod((short)16, aSIHMISyncCarBordComputerReplyProxy$18);
    }

    @Override
    public void updateBCLongTermGeneral(BCTermGeneralData bCTermGeneralData, boolean bl) {
        ASIHMISyncCarBordComputerReplyProxy$19 aSIHMISyncCarBordComputerReplyProxy$19 = new ASIHMISyncCarBordComputerReplyProxy$19(this, bCTermGeneralData, bl);
        this.proxy.remoteCallMethod((short)15, aSIHMISyncCarBordComputerReplyProxy$19);
    }
}

