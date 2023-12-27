/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sTrunkOfferFBAS;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sVideoInputState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2DisplayManagerDiagServiceProxy
implements MMX2DisplayManagerDiagService,
MMX2DisplayManagerDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService");
    private Proxy proxy;

    public MMX2DisplayManagerDiagServiceProxy(int n, MMX2DisplayManagerDiagServiceReply mMX2DisplayManagerDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("d9796ad7-dbdb-4a6a-91b8-87d2003632af", n, "ce357906-130f-5933-baca-79721aa7173a", "asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService");
        MMX2DisplayManagerDiagServiceReplyService mMX2DisplayManagerDiagServiceReplyService = new MMX2DisplayManagerDiagServiceReplyService(mMX2DisplayManagerDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2DisplayManagerDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorDisplayManager(sClientResponseError sClientResponseError2) {
        MMX2DisplayManagerDiagServiceProxy$1 mMX2DisplayManagerDiagServiceProxy$1 = new MMX2DisplayManagerDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)16, mMX2DisplayManagerDiagServiceProxy$1);
    }

    @Override
    public void responseVideoInputState(sVideoInputState sVideoInputState2) {
        MMX2DisplayManagerDiagServiceProxy$2 mMX2DisplayManagerDiagServiceProxy$2 = new MMX2DisplayManagerDiagServiceProxy$2(this, sVideoInputState2);
        this.proxy.remoteCallMethod((short)13, mMX2DisplayManagerDiagServiceProxy$2);
    }

    @Override
    public void responseTrunkOfferFBAS(sTrunkOfferFBAS sTrunkOfferFBAS2) {
        MMX2DisplayManagerDiagServiceProxy$3 mMX2DisplayManagerDiagServiceProxy$3 = new MMX2DisplayManagerDiagServiceProxy$3(this, sTrunkOfferFBAS2);
        this.proxy.remoteCallMethod((short)12, mMX2DisplayManagerDiagServiceProxy$3);
    }
}

