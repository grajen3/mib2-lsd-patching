/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.ooc.sTemperatureMMX;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2OocDiagServiceProxy
implements MMX2OocDiagService,
MMX2OocDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2OocDiagService");
    private Proxy proxy;

    public MMX2OocDiagServiceProxy(int n, MMX2OocDiagServiceReply mMX2OocDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("09c63284-f374-4fbe-89ea-924e201190ad", n, "24561f40-b427-5b46-a327-ce4029a7b7b0", "asi.diagnosis.mmx2app.MMX2OocDiagService");
        MMX2OocDiagServiceReplyService mMX2OocDiagServiceReplyService = new MMX2OocDiagServiceReplyService(mMX2OocDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2OocDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorOoc(sClientResponseError sClientResponseError2) {
        MMX2OocDiagServiceProxy$1 mMX2OocDiagServiceProxy$1 = new MMX2OocDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)8, mMX2OocDiagServiceProxy$1);
    }

    @Override
    public void responseTemperatureMMX(sTemperatureMMX sTemperatureMMX2) {
        MMX2OocDiagServiceProxy$2 mMX2OocDiagServiceProxy$2 = new MMX2OocDiagServiceProxy$2(this, sTemperatureMMX2);
        this.proxy.remoteCallMethod((short)2, mMX2OocDiagServiceProxy$2);
    }

    @Override
    public void responseDeleteMemory(sRoutineResponse sRoutineResponse2) {
        MMX2OocDiagServiceProxy$3 mMX2OocDiagServiceProxy$3 = new MMX2OocDiagServiceProxy$3(this, sRoutineResponse2);
        this.proxy.remoteCallMethod((short)5, mMX2OocDiagServiceProxy$3);
    }
}

