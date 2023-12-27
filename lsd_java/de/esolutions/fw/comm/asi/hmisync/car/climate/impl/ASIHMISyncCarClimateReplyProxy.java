/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyProxy$6;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncCarClimateReplyProxy
implements ASIHMISyncCarClimateReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.climate.ASIHMISyncCarClimate");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncCarClimateReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("5ffc8a82-9fd6-4d5f-9e5b-b7d05d798bc3", -1, "b433dc69-1912-5b9a-900b-83fe40f977cc", "asi.hmisync.car.climate.ASIHMISyncCarClimate");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncCarClimateReplyProxy$1 aSIHMISyncCarClimateReplyProxy$1 = new ASIHMISyncCarClimateReplyProxy$1(this, string, bl);
        this.proxy.remoteCallMethod((short)7, aSIHMISyncCarClimateReplyProxy$1);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarClimateReplyProxy$2 aSIHMISyncCarClimateReplyProxy$2 = new ASIHMISyncCarClimateReplyProxy$2(this, sArray, bl);
        this.proxy.remoteCallMethod((short)12, aSIHMISyncCarClimateReplyProxy$2);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarClimateReplyProxy$3 aSIHMISyncCarClimateReplyProxy$3 = new ASIHMISyncCarClimateReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)11, aSIHMISyncCarClimateReplyProxy$3);
    }

    @Override
    public void updateAirconTempZone1(IntBaseType intBaseType, boolean bl) {
        ASIHMISyncCarClimateReplyProxy$4 aSIHMISyncCarClimateReplyProxy$4 = new ASIHMISyncCarClimateReplyProxy$4(this, intBaseType, bl);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncCarClimateReplyProxy$4);
    }

    @Override
    public void updateAirconTempZone2(IntBaseType intBaseType, boolean bl) {
        ASIHMISyncCarClimateReplyProxy$5 aSIHMISyncCarClimateReplyProxy$5 = new ASIHMISyncCarClimateReplyProxy$5(this, intBaseType, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncCarClimateReplyProxy$5);
    }

    @Override
    public void updateAirconMaxAC(boolean bl, boolean bl2) {
        ASIHMISyncCarClimateReplyProxy$6 aSIHMISyncCarClimateReplyProxy$6 = new ASIHMISyncCarClimateReplyProxy$6(this, bl, bl2);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncCarClimateReplyProxy$6);
    }
}

