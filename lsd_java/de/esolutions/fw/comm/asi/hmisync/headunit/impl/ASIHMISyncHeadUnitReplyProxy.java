/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnitReply;
import de.esolutions.fw.comm.asi.hmisync.headunit.CarConfiguration;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockDate;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$11;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$12;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$13;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$14;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$15;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$16;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncHeadUnitReplyProxy
implements ASIHMISyncHeadUnitReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.headunit.ASIHMISyncHeadUnit");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncHeadUnitReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("00c7b221-4634-4004-97dd-03531d5bc83c", -1, "d70a28c6-c507-5f9a-8920-21d1424b355a", "asi.hmisync.headunit.ASIHMISyncHeadUnit");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void resetLanguage(int n, String string) {
        ASIHMISyncHeadUnitReplyProxy$1 aSIHMISyncHeadUnitReplyProxy$1 = new ASIHMISyncHeadUnitReplyProxy$1(this, n, string);
        this.proxy.remoteCallMethod((short)3, aSIHMISyncHeadUnitReplyProxy$1);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$2 aSIHMISyncHeadUnitReplyProxy$2 = new ASIHMISyncHeadUnitReplyProxy$2(this, string, bl);
        this.proxy.remoteCallMethod((short)7, aSIHMISyncHeadUnitReplyProxy$2);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$3 aSIHMISyncHeadUnitReplyProxy$3 = new ASIHMISyncHeadUnitReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncHeadUnitReplyProxy$3);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$4 aSIHMISyncHeadUnitReplyProxy$4 = new ASIHMISyncHeadUnitReplyProxy$4(this, sArray, bl);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncHeadUnitReplyProxy$4);
    }

    @Override
    public void updateClockTime(ClockTime clockTime, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$5 aSIHMISyncHeadUnitReplyProxy$5 = new ASIHMISyncHeadUnitReplyProxy$5(this, clockTime, bl);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncHeadUnitReplyProxy$5);
    }

    @Override
    public void updateClockDate(ClockDate clockDate, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$6 aSIHMISyncHeadUnitReplyProxy$6 = new ASIHMISyncHeadUnitReplyProxy$6(this, clockDate, bl);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncHeadUnitReplyProxy$6);
    }

    @Override
    public void updateLanguage1(int n, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$7 aSIHMISyncHeadUnitReplyProxy$7 = new ASIHMISyncHeadUnitReplyProxy$7(this, n, bl);
        this.proxy.remoteCallMethod((short)11, aSIHMISyncHeadUnitReplyProxy$7);
    }

    @Override
    public void updateLanguage2(String string, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$8 aSIHMISyncHeadUnitReplyProxy$8 = new ASIHMISyncHeadUnitReplyProxy$8(this, string, bl);
        this.proxy.remoteCallMethod((short)12, aSIHMISyncHeadUnitReplyProxy$8);
    }

    @Override
    public void updateTemperatureUnit(int n, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$9 aSIHMISyncHeadUnitReplyProxy$9 = new ASIHMISyncHeadUnitReplyProxy$9(this, n, bl);
        this.proxy.remoteCallMethod((short)15, aSIHMISyncHeadUnitReplyProxy$9);
    }

    @Override
    public void updateSpeedUnit(int n, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$10 aSIHMISyncHeadUnitReplyProxy$10 = new ASIHMISyncHeadUnitReplyProxy$10(this, n, bl);
        this.proxy.remoteCallMethod((short)14, aSIHMISyncHeadUnitReplyProxy$10);
    }

    @Override
    public void updateDistanceUnit(int n, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$11 aSIHMISyncHeadUnitReplyProxy$11 = new ASIHMISyncHeadUnitReplyProxy$11(this, n, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncHeadUnitReplyProxy$11);
    }

    @Override
    public void updatePressureUnit(int n, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$12 aSIHMISyncHeadUnitReplyProxy$12 = new ASIHMISyncHeadUnitReplyProxy$12(this, n, bl);
        this.proxy.remoteCallMethod((short)13, aSIHMISyncHeadUnitReplyProxy$12);
    }

    @Override
    public void updateCarConfiguration(CarConfiguration carConfiguration, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$13 aSIHMISyncHeadUnitReplyProxy$13 = new ASIHMISyncHeadUnitReplyProxy$13(this, carConfiguration, bl);
        this.proxy.remoteCallMethod((short)16, aSIHMISyncHeadUnitReplyProxy$13);
    }

    @Override
    public void updateRegion(int n, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$14 aSIHMISyncHeadUnitReplyProxy$14 = new ASIHMISyncHeadUnitReplyProxy$14(this, n, bl);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncHeadUnitReplyProxy$14);
    }

    @Override
    public void updateExtCarConfiguration(int[] nArray, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$15 aSIHMISyncHeadUnitReplyProxy$15 = new ASIHMISyncHeadUnitReplyProxy$15(this, nArray, bl);
        this.proxy.remoteCallMethod((short)20, aSIHMISyncHeadUnitReplyProxy$15);
    }

    @Override
    public void updateSplashScreenCoding(short s, boolean bl) {
        ASIHMISyncHeadUnitReplyProxy$16 aSIHMISyncHeadUnitReplyProxy$16 = new ASIHMISyncHeadUnitReplyProxy$16(this, s, bl);
        this.proxy.remoteCallMethod((short)21, aSIHMISyncHeadUnitReplyProxy$16);
    }
}

